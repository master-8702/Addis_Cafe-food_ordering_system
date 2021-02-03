package com.ibrocorp.foodorderingsystem2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class snacks extends AppCompatActivity {
    private TextView tv1,tv2, tv3, tv4, tv5, tv6;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks);
        final GlobalClass g=(GlobalClass) getApplication();
        final Spinner myspinner1,myspinner2,myspinner3,myspinner4,myspinner5,myspinner6;
        myspinner1=findViewById(R.id.spinner); myspinner2=findViewById(R.id.spinner2); myspinner3=findViewById(R.id.spinner3);
        myspinner4=findViewById(R.id.spinner4); myspinner5=findViewById(R.id.spinner5); myspinner6=findViewById(R.id.spinner6);
        tv1=findViewById(R.id.textView16);  tv2=findViewById(R.id.textView17); tv3=findViewById(R.id.textView18);
        tv4=findViewById(R.id.textView19);  tv5=findViewById(R.id.textView20);  tv6=findViewById(R.id.textView21);
        String [] numbers={"0","1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,numbers);
        myspinner1.setAdapter(adapter); myspinner2.setAdapter(adapter); myspinner3.setAdapter(adapter);
        myspinner4.setAdapter(adapter); myspinner5.setAdapter(adapter); myspinner6.setAdapter(adapter);

        Button btnoksnacks=findViewById(R.id.btnoksnacks);
        btnoksnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(snacks.this,home_page.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        myspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    ordercalculator(myspinner1,tv1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        myspinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    ordercalculator(myspinner2,tv2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        myspinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    ordercalculator(myspinner3,tv3);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        myspinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    ordercalculator(myspinner4,tv4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        myspinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    ordercalculator(myspinner5,tv5);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        myspinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    ordercalculator(myspinner6,tv6);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void ordercalculator(Spinner s, TextView tv){

        String st;  int i;
        st="=> "+s.getSelectedItemPosition()+" "+s.getContentDescription()+"\n";
        GlobalClass.Gorders+=st;
        i=s.getSelectedItemPosition()*Integer.parseInt(tv.getText().toString());
        GlobalClass.GtotalCost+=i;


    }
}
