package com.ibrocorp.foodorderingsystem2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home_page extends AppCompatActivity {
    private FirebaseAuth fireauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        final GlobalClass g=(GlobalClass)getApplication();

        Button btnbreakfast = findViewById(R.id.btnbreakfast);
        Button btnlunch = findViewById(R.id.btnlunch);
        Button btndinner = findViewById(R.id.btndinner);
        Button btnsnacks = findViewById(R.id.btnsnacks);
        Button btndrinks = findViewById(R.id.btndrinks);
        Button btncheckorders= findViewById(R.id.btncheckorders);
        Button b3=findViewById(R.id.btnlogout);
        TextView tv=findViewById(R.id.txtcurrentuser);
        tv.setText(getIntent().getExtras().getString("currentuser"));
        //extra
        final Button btnextra=findViewById(R.id.btnextra);
         Button btnExtra2=findViewById(R.id.btnExtra2);

        btnbreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(home_page.this,breakfast.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //to open activities without destroying the first (without calling finih())
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); ////to open activities without destroying the first (without calling finih())
                startActivity(intent1);
            }
        });

        btnlunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(home_page.this, lunch.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent2);
            }
        });

        btndinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(home_page.this, dinner.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent3.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent3);
            }
        });

        btnsnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(home_page.this, snacks.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent4.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent4);

            }
        });

        btndrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(home_page.this, drinks.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent5.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent5);
            }
        });

        btncheckorders.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    Intent i = new Intent(home_page.this, order_detail.class);
                    i.putExtra("orders",GlobalClass.getGorders().toString());
                    startActivity(i);
                    /*alertdialog();
                }
            private void alertdialog(){
                AlertDialog.Builder dialog= new AlertDialog.Builder(home_page.this);
                dialog.setTitle("Please Confirm Your Order!");
                dialog.setMessage(new StringBuilder().append("You have ordered:\n").append(g.getGorders()).append("\n Total Cost is: ").append(g.getTotalCost()).toString());
                dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(home_page.this,"confirm is clicked",Toast.LENGTH_LONG);
                        AlertDialog.Builder adb=new AlertDialog.Builder(home_page.this);
                        adb.setTitle("Addis Cafe");
                        adb.setMessage("Thanks For Ordering!");
                        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(home_page.this,"cancel is clicked", Toast.LENGTH_LONG);
                    }
                });
                AlertDialog alertDialog= dialog.create();
                alertDialog.show();

            }*/

            }
        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(home_page.this,login.class));
            }
        });

        btnextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home_page.this, dinlunch.class);
                startActivity(i);
            }
        });
        /*btnExtra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(home_page.this,order_detail.class);
                i.putExtra("orders",g.getGorders());
                        startActivity(i);
            }
        });*/
    }



}
