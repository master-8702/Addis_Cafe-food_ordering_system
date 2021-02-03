package com.ibrocorp.foodorderingsystem2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class order_detail extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    GlobalClass g;
    Button btnClearOrders,btnCofirmOrders;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        tv=findViewById(R.id.etOrderDetail);
        g=new GlobalClass();
        btnCofirmOrders= findViewById(R.id.btnConfirmOrders);
        btnClearOrders=findViewById(R.id.btnClearOrders);

        btnCofirmOrders.setEnabled(false);
        btnClearOrders.setEnabled(false);
      /*  if(getIntent().getExtras().getString("orders").equals("")){
            tv.setText("You Don't Have Any Orders");
        }
        else tv.setText(getIntent().getExtras().getString("orders"));*/
      if(GlobalClass.getGorders().equals("")){
          tv.setText("You Don't Have Any Orders");
      }else {
          String s;
          s=g.getGorders()+"\n Total Cost is: "+g.getTotalCost();
          tv.setText(s);
      }

btnCofirmOrders.setOnClickListener(this);
btnClearOrders.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConfirmOrders:
                if(GlobalClass.getGorders()!=""){
                Toast.makeText(this,"Thank You!\nYour Order has been Successfully Sent!",Toast.LENGTH_LONG).show();
                Intent i=new Intent(order_detail.this,home_page.class);
                startActivity(i);
                }
                else {
                    btnCofirmOrders.setEnabled(false);
                    btnClearOrders.setEnabled(false);
                }

            case R.id.btnClearOrders:
               GlobalClass.clearData();
               tv.setText(GlobalClass.getGorders());
                Intent i=new Intent(order_detail.this,home_page.class);
                startActivity(i);
        }
    }

    public void splitter(String str){
        String[] s;
        String temp="";
        s=str.split(" ");

        for (String temp2: s) {
            temp+=s;
        }
        tv.setText(temp);
    }
}
