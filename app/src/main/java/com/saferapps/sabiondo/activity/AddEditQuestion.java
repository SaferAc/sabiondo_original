package com.saferapps.sabiondo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.saferapps.sabiondo.R;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class AddEditQuestion extends AppCompatActivity {
    public static final String QUESTIONTEXT =
            "com.saferapps.sabiondo.Extras.QUESTIONTEXT";
    public static final String OPT_A =
            "com.saferapps.sabiondo.Extras.OPTA";
    public static final String OPT_B =
            "com.saferapps.sabiondo.Extras.OPTB";
    public static final String OPT_C =
            "com.saferapps.sabiondo.Extras.OPTC";
    public static final String OPT_D =
            "com.saferapps.sabiondo.Extras.OPTD";
    public static final String TRUE_ANS =
            "com.saferapps.sabiondo.Extras.TRUE_ANS";
    public static final String FEEDBACK =
            "com.saferapps.sabiondo.Extras.FEEDBACK";
    public static final String URI =
            "com.saferapps.sabiondo.Extras.URI";
    public static final String SUBJECT =
            "com.saferapps.sabiondo.Extras.SUBJECT";

    ImageView image, camera;
    CardView cardView;
    private static final String KEY_EMPTY = "";
    private EditText et_question, et_opta, et_optb,et_optc,et_optd,et_feedback;
    private String txt_question, opt_a, opt_b,opt_c,opt_d,feedback,txt_right_ans="";
    int subject=0;
    private RadioButton rb_a,rb_b,rb_c,rb_d;
    private Button btn_addquestion;
    private ChipGroup subjectChipGroup;
    private Context mcontext;
    private String currentPhotoPath="";
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int GALLERY_REQUEST_CODE = 2;
    boolean hasimage=false;
    private StorageReference mStorageRef;
    private DatabaseReference mDaBaseRef;
    private ProgressBar mProgressBar;
    private Bitmap scaledBitmap;
    private Uri selectedImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_question);
        cardView= findViewById(R.id.card_txtquestion);
        mcontext= getApplicationContext();
        et_question= findViewById(R.id.et_question);
        et_opta= findViewById(R.id.et_opta);
        et_optb= findViewById(R.id.et_optb);
        et_optc= findViewById(R.id.et_optc);
        et_optd= findViewById(R.id.et_optd);
        et_feedback= findViewById(R.id.et_feedback);
        rb_a=findViewById(R.id.rb_a);
        rb_b=findViewById(R.id.rb_b);
        rb_c=findViewById(R.id.rb_c);
        rb_d=findViewById(R.id.rb_d);
        btn_addquestion= findViewById(R.id.btn_addquestion);
        subjectChipGroup= findViewById(R.id.subjectChipGroup);
        image= findViewById(R.id.image);
        image.setVisibility(View.GONE);
        camera= findViewById(R.id.camera_image);
        camera.bringToFront();
        camera.setVisibility(View.GONE);



        Intent i = getIntent();
            et_question.setText(i.getStringExtra(QUESTIONTEXT));
            et_opta.setText(i.getStringExtra(OPT_A));
            et_optb.setText(i.getStringExtra(OPT_B));
            et_optc.setText(i.getStringExtra(OPT_C));
            et_optd.setText(i.getStringExtra(OPT_D));
            et_feedback.setText(i.getStringExtra(FEEDBACK));









       rb_a.setOnClickListener(v -> {
           clearchecks();
           rb_a.setChecked(true);
           txt_right_ans="A";

       });
        rb_b.setOnClickListener(v -> {
            clearchecks();
            rb_b.setChecked(true);
            txt_right_ans="B";

        });
        rb_c.setOnClickListener(v -> {
            clearchecks();
            rb_c.setChecked(true);
            txt_right_ans="C";

        });
        rb_d.setOnClickListener(v -> {
            clearchecks();
            rb_d.setChecked(true);
            txt_right_ans="D";

        });
        subjectChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip20) {
                subject = 1;
            } else if (checkedId == R.id.chip21) {
                subject = 2;
            } else if (checkedId == R.id.chip22) {
                subject = 3;
            } else if (checkedId == R.id.chip23) {
                subject = 4;
            } else if (checkedId == R.id.chip24) {
                subject = 5;
            } else if (checkedId == R.id.chip25) {
                subject = 6;
            } else if (checkedId == R.id.chip26) {
                subject = 7;
            } else if (checkedId == R.id.chip27) {
                subject = 8;
            } else if (checkedId == R.id.chip28) {
                subject = 9;
            } else if (checkedId == R.id.chip29) {
                subject = 10;
            } else {
                subject = 0;
            }

        });



        btn_addquestion.setOnClickListener(v -> {
            txt_question=et_question.getText().toString().trim();
            opt_a=et_opta.getText().toString().trim();
            opt_b=et_optb.getText().toString().trim();
            opt_c=et_optc.getText().toString().trim();
            opt_d=et_optd.getText().toString().trim();
            feedback=et_feedback.getText().toString().trim();
            if (validateInputs()) {
                registerQuestion();
            }

        });

      camera.setOnClickListener(v -> {


          image.setVisibility(View.VISIBLE);
          selectImage();
      });


    }


    private boolean validateInputs() {
        if (txt_question.length()<4) {
            et_question.setError("¿No crees que es una pregunta muy corta?");
            et_question.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(txt_question)) {
            et_question.setError("Escriba una pregunta");
            et_question.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(opt_a)) {
            et_opta.setError("Ingrese una opción");
            et_opta.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(opt_b)) {
            et_optb.setError("Ingrese una opción");
            et_optb.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(opt_c)) {
            et_optc.setError("Ingrese una opción");
            et_optc.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(opt_d)) {
            et_optd.setError("Ingrese una opción");
            et_optd.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(txt_right_ans)) {
            Toast.makeText(this, "Seleccione la respuesta correcta", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (opt_a.equals(opt_b)) {
            et_optb.setError("Opción repetida");
            et_optb.requestFocus();
            return false;
        }
        if (opt_a.equals(opt_c)) {
            et_optc.setError("Opción repetida");
            et_optc.requestFocus();
            return false;
        }
        if (opt_a.equals(opt_d)) {
            et_optd.setError("Opción repetida");
            et_optd.requestFocus();
            return false;
        }
        if (opt_b.equals(opt_c)) {
            et_optc.setError("Opción repetida");
            et_optc.requestFocus();
            return false;
        }
        if (opt_b.equals(opt_d)) {
            et_optd.setError("Opción repetida");
            et_optd.requestFocus();
            return false;
        }
        if (opt_c.equals(opt_d)) {
            et_optd.setError("Opción repetida");
            et_optd.requestFocus();
            return false;
        }
        if (subject==0) {
            Toast.makeText(mcontext, "Seleccione una Asignatura", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private void registerQuestion(){
        Intent data = new Intent();
        data.putExtra(QUESTIONTEXT,txt_question);
        data.putExtra(OPT_A, opt_a);
        data.putExtra(OPT_B,opt_b);
        data.putExtra(OPT_C,opt_c);
        data.putExtra(OPT_D,opt_d);
        data.putExtra(TRUE_ANS,txt_right_ans);
        data.putExtra(FEEDBACK,feedback);
        data.putExtra(URI, currentPhotoPath);
        data.putExtra(SUBJECT,String.valueOf(subject));
        setResult(RESULT_OK, data);
        finish();



    }
    private void clearchecks(){
        rb_a.setChecked(false);
        rb_b.setChecked(false);
        rb_c.setChecked(false);
        rb_d.setChecked(false);
        txt_right_ans="";
    }


    private void tomarFoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.saferapps.sabiondo.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            hasimage = true;
            CardView.LayoutParams params = new CardView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.BOTTOM;
            et_question.setLayoutParams(params);
            et_question.setBackgroundColor(Color.WHITE);
            et_question.getBackground().setAlpha(200);
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    selectedImage = data.getData();
                    Glide.with(mcontext)
                            .asBitmap()
                            .centerCrop()
                            .load(selectedImage)
                            .into(image);
                    break;
                case REQUEST_TAKE_PHOTO:
                    Glide.with(mcontext)
                            .asBitmap()
                            .centerCrop()
                            .load(currentPhotoPath)
                            .into(image);
                    break;
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }



    private void pickFromGallery() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    private void selectImage() {

        final CharSequence[] items = {
                "Camara", "Galeria",
                "Regresar"
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(AddEditQuestion.this);
        builder.setTitle("Seleccione una imagen");

        builder.setItems(items, (dialog, item) -> {
            if (items[item].equals("Camara")) {

                tomarFoto();
            } else if (items[item].equals("Galeria")) {
                pickFromGallery();
            } else if (items[item].equals("Cancel")) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int[] scrcoords = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            //Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }
    private void initFirebase(){
        mDaBaseRef= FirebaseDatabase.getInstance().getReference("uploads");

    }
    private String getFileExtension(Uri uri){
        ContentResolver cr= getContentResolver();
        MimeTypeMap mime= MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void uploadFile(Uri uri){
        if(!currentPhotoPath.isEmpty()){
            StorageReference filereference= mStorageRef.child(System.currentTimeMillis()
            + "." +getFileExtension(uri));

            filereference.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot snapshot) {
                    Handler handler= new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(0);
                        }
                    },500);
                    Toast.makeText(mcontext, "Imagen guardada en servidor", Toast.LENGTH_SHORT).show();
                    currentPhotoPath= snapshot.getStorage().getDownloadUrl().toString();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddEditQuestion.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100.0 *taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    mProgressBar.setProgress((int)progress);
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Cambios no guardados")
                .setMessage("¿Desea perder los cambios?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    AddEditQuestion.super.onBackPressed();
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .show();
    }


}
