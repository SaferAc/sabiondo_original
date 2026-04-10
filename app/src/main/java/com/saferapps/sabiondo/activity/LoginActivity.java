package com.saferapps.sabiondo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.dd.morphingbutton.MorphingButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.PlayersClient;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.app.NewMainActivity;
import com.saferapps.sabiondo.helper.SessionHandler;
import com.saferapps.sabiondo.model.User;


import java.util.UUID;


public class LoginActivity extends AppCompatActivity {

    private static final String KEY_EMPTY = "";
    private static final int RC_SIGN_IN = 1000;
    private EditText etUsername, etPassword;
    private String usermail, password;
    private ProgressDialog pDialog;
    private SessionHandler session;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    private String roluser = "";
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        session = new SessionHandler(this);
        mAuth = FirebaseAuth.getInstance();
       if(session.isLoggedIn()) {
            loadMain();
        } else {
            loadLogin();
        }

    }

    private void loadMain() {
        Intent i = new Intent(getApplicationContext(), NewMainActivity.class);
        startActivity(i);
        finish();

    }

    private void displayLoader() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Ingresando.. Espere un momento...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    private boolean validateInputs() {
        if (KEY_EMPTY.equals(usermail)) {
            etUsername.setError("Ingrese Correo");
            etUsername.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Ingrese Password");
            etPassword.requestFocus();
            return false;
        }
        if (usermail.length() < 6) {
            etUsername.setError("El nombre debe ser mayor a 5 caracteres");
            etUsername.requestFocus();
            return false;
        }
        if (password.length() < 6) {
            etPassword.setError("Su password debe ser mayor a 6 caracteres");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void login() {
        displayLoader();
        mAuth.signInWithEmailAndPassword(usermail, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        pDialog.dismiss();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        String id= user.getUid();
                        DatabaseReference database= FirebaseDatabase.getInstance().getReference("Users").child(id);
                        database.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               roluser= dataSnapshot.child("role").getValue(String.class);
                                String name = user.getDisplayName();
                                String uid = user.getUid();
                                session.loginUser(name, uid,roluser);
                                loadMain();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });



                    } else {
                        // If sign in fails, display a message to the user.
                        pDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Fallo autenticación",
                                Toast.LENGTH_SHORT).show();

                    }

                });

    }

    private void loadLogin() {
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);
        ImageButton register = findViewById(R.id.btnRegister);
        MorphingButton login = findViewById(R.id.btnLogin);
        MorphingButton anonymlogin = findViewById(R.id.anonymous_button);
        SignInButton googlelogin = findViewById(R.id.sign_in_button);
        checkBox = findViewById(R.id.checkboxprivacy2);
        ChipGroup chipGroup2= findViewById(R.id.chipgroup_roluser2);
        TextView textView = findViewById(R.id.txtprivacy);

        textView.setText(Html.fromHtml("He leido y acepto " +
                "<a href='https://cutt.ly/8yF2Ul7'>Terminos, Condiciones y Politica de Privacidad</a>"));
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        chipGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chipteacher2) {
                roluser = "Docente";
            } else if (checkedId == R.id.chipStudent2) {
                roluser = "Estudiante";
            }

        });



        //Launch Registration screen when Register Button is clicked

        register.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            finish();

        });

        login.setOnClickListener(v -> {
            usermail = etUsername.getText().toString().toLowerCase().trim();
            password = etPassword.getText().toString().trim();
            if (validateInputs()) {
                login();
            }
        });


        anonymlogin.setOnClickListener(v -> {
            if (validateInputstwo()) {
                displayLoader();
                mAuth.signInAnonymously().addOnCompleteListener(task -> {
                    pDialog.dismiss();
                    if(task.isSuccessful()){
                        String userid;
                        FirebaseUser user = mAuth.getCurrentUser();
                        assert user != null;
                        userid= user.getUid();
                        String sub = userid.substring(0, 5);
                        String name = "Sabiondo" + sub;
                        session.loginUser(name, userid,roluser);
                        loadMain();
                    }else{
                        String userid;
                        userid = UUID.randomUUID().toString();
                        String sub = userid.substring(0, 5);
                        String name = "Sabiondo" + sub;
                        session.loginUser(name, userid,roluser);
                        loadMain();

                    }

                    }).addOnFailureListener(e -> pDialog.dismiss());

            }
        });
        googlelogin.setOnClickListener(v -> {
           if(validateInputstwo()){


                displayLoader();
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                        .requestServerAuthCode(getString(R.string.default_web_client_id))
                        .build();
                GoogleSignInClient  mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
                Intent intent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(intent, RC_SIGN_IN);

           }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount signedInAccount = result.getSignInAccount();
                firebaseAuthWithPlayGames(signedInAccount);
            } else {
                pDialog.dismiss();
                new AlertDialog.Builder(this).setMessage("Ocurrio un error")
                        .setNeutralButton(android.R.string.ok, null).show();
            }
        }
    }

    private void firebaseAuthWithPlayGames(GoogleSignInAccount acct) {
        Log.d("TAG", "firebaseAuthWithPlayGames:" + acct.getId());

        final FirebaseAuth auth = FirebaseAuth.getInstance();
        AuthCredential credential = PlayGamesAuthProvider.getCredential(acct.getServerAuthCode());
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        pDialog.dismiss();
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = auth.getCurrentUser();
                        String id = user.getUid();
                        PlayersClient mPlayersClient = Games.getPlayersClient(this, acct);
                        mPlayersClient.getCurrentPlayer().addOnCompleteListener(task1 -> {
                            String name;
                            String profilepic;
                            Uri profile;
                            if (task1.isSuccessful()) {
                                name = task1.getResult().getDisplayName();
                                profile= task1.getResult().getIconImageUri();
                                profilepic= profile.toString();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(name)
                                        .setPhotoUri(profile)
                                        .build();
                                user.updateProfile(profileUpdates);
                                User usersab = new User(id, name);
                                usersab.setRole(roluser);
                                usersab.setProfilePic(profilepic);
                                session.loginUser(name, id,roluser);
                                reference.child(id).setValue(usersab).addOnCompleteListener(taskt -> {
                                    Toast.makeText(LoginActivity.this, "Registro Exitoso",
                                            Toast.LENGTH_SHORT).show();
                                    loadMain();
                                });
                            } else {
                                Exception e = task1.getException();

                            }
                        });


                    } else {
                        pDialog.dismiss();
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                });

    }


    private boolean validateInputstwo(){
        if(!checkBox.isChecked()){
            Toast.makeText(this, "Debes aceptar Terminos y Condiciones", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(roluser.equals("")){
            Toast.makeText(this, "Debes seleccionar un rol", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
