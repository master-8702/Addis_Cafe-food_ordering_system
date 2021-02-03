package com.ibrocorp.foodorderingsystem2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class user_registration extends AppCompatActivity implements View.OnClickListener{
    private EditText etfullname,etusername,etuseremail,etuserpassword;
    private Button btnregisteruser;
    private FirebaseAuth fireauth;
    GlobalClass g=new GlobalClass();
    // Creating Progress dialog.
    ProgressDialog progressDialog;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registeration);

        fireauth = FirebaseAuth.getInstance();
        etfullname=findViewById(R.id.txtuserfullname);
        etusername=findViewById(R.id.txtusername);
        etuseremail=findViewById(R.id.txtuseremail);
        etuserpassword=findViewById(R.id.txtuserpassword);
        btnregisteruser=findViewById(R.id.btnRegister);

        btnregisteruser.setOnClickListener(this);
        progressDialog = new ProgressDialog(user_registration.this);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnRegister:
                registerUser();
                break;
        }
    }
    private void registerUser() {

        g.setGfullname(etfullname.getText().toString().trim());
        g.setGusername(etusername.getText().toString().trim());
        g.setGemail(etuseremail.getText().toString().trim());
        g.setGpassword(etuserpassword.getText().toString().trim());
        if (g.getGfullname().isEmpty()) {
            etfullname.setError("Full name is required!");
            etfullname.requestFocus();

            return;
        }
        if (g.getGusername().isEmpty()) {
            etusername.setError("Username is required!");
            etusername.requestFocus();

            return;
        }
        if (g.getGemail().isEmpty()) {
            etuseremail.setError("Email is Required!");
            etuseremail.requestFocus();

            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(g.getGemail()).matches()) {
            etuseremail.setError("Please provide a valid email");
            etuseremail.requestFocus();

            return;
        }
        if (g.getGpassword().isEmpty()) {
            etuserpassword.setError("Password is required");
            etuserpassword.requestFocus();

            return;
        }

        if (g.getGpassword().length() < 6) {
            etuserpassword.setError("Min Password Length is 6");
            etuserpassword.requestFocus();

            return;
        } else  {

            progressDialog.setMessage("Please Wait, We are Registering Your Data on Server");
            progressDialog.show();
            fireauth.createUserWithEmailAndPassword(g.getGemail(), g.getGpassword())
                    .addOnCompleteListener(user_registration.this,new OnCompleteListener<AuthResult>() {
                        private String TAG;

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ((task.isSuccessful())) {
                                Toast.makeText(user_registration.this, "You Have Registered Successfully!", Toast.LENGTH_LONG).show();
                                Intent i=new Intent(user_registration.this,home_page.class);
                                i.putExtra("currentuser",g.getGemail());
                                startActivity(i);


                            /*User user=new User(g.getGfullname(),g.getGusername(),g.getGemail());
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if ((task.isSuccessful())){
                                        Toast.makeText(user_registration.this,"User has been registered successfully",Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Toast.makeText(user_registration.this,"user registration failed1",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });*/
                            } else {
                                Toast.makeText(user_registration.this, "User Registration failed! \n Try Again", Toast.LENGTH_LONG).show();
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());


                            }
                            progressDialog.dismiss();
                        }
                    });
        }

                }


}
