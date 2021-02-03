package com.ibrocorp.foodorderingsystem2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class login extends AppCompatActivity implements View.OnClickListener{
    private Button btncreateuser,btnlogin;
    GlobalClass g=new GlobalClass();
private FirebaseAuth fireauth;
private FirebaseAuth.AuthStateListener mauthstatelistener;
private EditText etloginemail,etloginpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btncreateuser=findViewById(R.id.btncreateuser);
        btnlogin=findViewById(R.id.btnlogin);
        btncreateuser.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        fireauth=FirebaseAuth.getInstance();
        etloginemail=findViewById(R.id.etloginemail);
        etloginpassword=findViewById(R.id.etloginpassword);

        mauthstatelistener=new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser=fireauth.getCurrentUser();

                if(mfirebaseuser != null){
                    Toast.makeText(login.this,"You are already Logged in", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(login.this,home_page.class));
                }
                else {
                    Toast.makeText(login.this,"Please Login",Toast.LENGTH_LONG).show();


                }
            }
        };


    }


    @Override
    public void onClick(View view) {

        g.setGemail(etloginemail.getText().toString().trim());
        g.setGpassword(etloginpassword.getText().toString().trim());
        switch(view.getId()){
            case R.id.btnlogin:
                if(g.getGemail().isEmpty()){
                    etloginemail.setError("Email is Required!");
                    etloginemail.requestFocus();

                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(g.getGemail()).matches()){
                    etloginemail.setError("Please provide a valid email");
                    etloginemail.requestFocus();

                    return;
                }
                if(g.getGpassword().isEmpty()){
                    etloginpassword.setError("Password is required");
                    etloginpassword.requestFocus();

                    return;
                }

                if(g.getGpassword().length()<6){
                    etloginpassword.setError("Min Password Length is 6");
                    etloginpassword.requestFocus();

                    return;
                }

                    fireauth.signInWithEmailAndPassword(g.getGemail(),g.getGpassword()).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(login.this,"WelCome back! ",Toast.LENGTH_LONG).show();
//                                startActivity(new Intent(login.this,home_page.class));
                                Intent i=new Intent(login.this,home_page.class);
                                i.putExtra("currentuser",g.getGemail());
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(login.this,"Login Error! \n Please Try Again",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                        break;

            case R.id.btncreateuser:
                startActivity(new Intent(this,user_registration.class));
                break;

        }
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        fireauth.addAuthStateListener(mauthstatelistener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fireauth.addAuthStateListener((mauthstatelistener));
    }*/
}