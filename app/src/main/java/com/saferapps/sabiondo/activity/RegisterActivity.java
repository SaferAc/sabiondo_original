package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.morphingbutton.MorphingButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SessionHandler;
import com.saferapps.sabiondo.model.User;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private static final String KEY_EMPTY = "";
    private RelativeLayout rlayout;
    private Animation animation;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etMail;
    private String username, password,confirmPassword,email, roluser;
    private ProgressDialog pDialog;
    private ChipGroup chipGroup;
    private SessionHandler session;
    boolean chipselected= false;
    private CheckBox privacy;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        session = new SessionHandler(this);
        chipGroup= findViewById(R.id.chipgroup_roluser);
        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);
        etMail= findViewById(R.id.etMail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        privacy= findViewById(R.id.checkboxprivacy);
        mAuth = FirebaseAuth.getInstance();
        MorphingButton register = findViewById(R.id.btnRegister);

        reference= FirebaseDatabase.getInstance().getReference();
        TextView textView = findViewById(R.id.txtprivacy2);

        textView.setText(Html.fromHtml("He leido y Acepto " +
                "<a href='https://cutt.ly/8yF2Ul7'>Terminos, Condiciones y Politica de Privacidad</a>"));
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());




        chipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chipteacher) {
                roluser = "Docente";
                chipselected = true;
            } else if (checkedId == R.id.chipStudent) {
                roluser = "Estudiante";
                chipselected = true;
            }
        });

        register.setOnClickListener(v -> {
            //Retrieve the data entered in the edit texts
            username = etUsername.getText().toString().toLowerCase().trim();
            password = etPassword.getText().toString().trim();
            confirmPassword = etConfirmPassword.getText().toString().trim();
            email = etMail.getText().toString().trim();
            if (validateInputs()) {
                registerUser();
            }
        });

    }
    private void registerUser() {
        displayLoader();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        pDialog.dismiss();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Firebase", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        String id= user.getUid();
                        User usersab= new User(id,username);
                        usersab.setMail(email);
                        usersab.setRole(roluser);
                        session.loginUser(username,id,roluser);
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setDisplayName(username)
                                .build();
                        user.updateProfile(profileUpdates);
                        reference.child("Users").child(id).setValue(usersab).addOnCompleteListener(taskt -> {
                            Toast.makeText(RegisterActivity.this, "Registro Exitoso",
                                    Toast.LENGTH_SHORT).show();
                            loadMain();
                        });

                    } else {
                        pDialog.dismiss();
                        // If sign in fails, display a message to the user.
                        Log.w("Firebase", "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "Fallo en el  registro",
                                Toast.LENGTH_SHORT).show();
                    }

                });


    }
    private boolean validateInputs() {
        if (KEY_EMPTY.equals(email)) {
            etMail.setError("Escribe un correo");
            etMail.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(username)) {
            etUsername.setError("Escribe un nombre");
            etUsername.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Escribe un password");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirma tu Password");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password y Confirmación no coinciden");
            etConfirmPassword.requestFocus();
            return false;
        }
        if(username.length()<6){
            etUsername.setError("El nombre debe ser mayor a 6 caracteres");
            etUsername.requestFocus();
            return false;
        }
        if(password.length()<6){
            etPassword.setError("Su password debe ser mayor 6 caracteres");
            etPassword.requestFocus();
            return false;
        }
        if(!chipselected){
            Toast.makeText(this, "Indica un tipo de usuario", Toast.LENGTH_SHORT).show();


            return false;
        }
        if(!privacy.isChecked()){
            Toast.makeText(this, "Debe aceptar Terminos y Condiciones", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(RegisterActivity.this);
        pDialog.setMessage("Registrando.. Un momento...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, LoginActivity.class);
        overridePendingTransition(R.anim.anim_enter, R.anim.anim_leave);
        startActivity(i);
        finish();
    }

    private void loadMain() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();

    }
}

