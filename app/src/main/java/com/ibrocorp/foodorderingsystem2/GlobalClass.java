package com.ibrocorp.foodorderingsystem2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

public final class GlobalClass extends Application {
    public static String Gorders="";
    public static int GtotalCost=0;
    public static String Gfullname="";
    public static String Gusername="";
    public static String Gemail="";
    public static String Gpassword="";


   public View getlayoutByres(@LayoutRes int layoutRes, @Nullable ViewGroup viewGroup)
   {
       final LayoutInflater factory= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       return factory.inflate(layoutRes,viewGroup);
   }
    static public String getGorders(){
        return Gorders;
    }
    public void setGorders(String d){
        Gorders+=d;
       // Button b= getlayoutByres(R.layout.order_detail,null).findViewById()

    }
    public static void clearData(){ Gorders=""; GtotalCost=0; }

    public String getGfullname(){ return  Gfullname; }
    public String getGusername(){
        return Gusername;
    }
    public String getGemail(){
        return Gemail;
    }
    public String getGpassword(){ return Gpassword; }
    public int getTotalCost(){  return GtotalCost;  }

    public void setGfullname(String s){
        Gfullname=s;
    }
    public void setGusername(String s){
        Gusername=s;
    }
    public void setGemail(String s){
        Gemail=s;
    }
    public void setGpassword(String s){
        Gpassword=s;
    }
    public  void setGtotalCost(int i){GtotalCost+=i;}
}
