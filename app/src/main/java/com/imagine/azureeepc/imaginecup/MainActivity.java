package com.imagine.azureeepc.imaginecup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity
{
    private  static  final String TAG = MainActivity.class.getSimpleName();
    private  static  String responseInsider="";
    public   static  String ServerLink="http://linum2016.azurewebsites.net/";
    public   static  String categorieGen="";
    public   static  String company_namer="";
    public   static  String destinationLongitude="";
    public   static  String destinationLatitude="";
    public   static  String destinationPhone="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String passwordSaving = preferences.getString("passwordSaving", "");
        String usernameSaving = preferences.getString("usernameSaving", "");

        if(!passwordSaving.equalsIgnoreCase("") || !usernameSaving.equalsIgnoreCase(""))
        {
            EditText editTextUser_Name=(EditText) findViewById(R.id.user_name) ;
            editTextUser_Name.setText(usernameSaving);
            EditText editTextPassword=(EditText) findViewById(R.id.password);
            editTextPassword.setText(passwordSaving);
            Toast.makeText(getApplicationContext(), "Login data found!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {return true;}
        return super.onOptionsItemSelected(item);
    }

    public void submitClickHandler(View view) throws InterruptedException
    {
        String passRecall="";
        EditText editTextUser_Name=(EditText) findViewById(R.id.user_name);
        EditText editTextPassword=(EditText) findViewById(R.id.password);
        if( editTextUser_Name.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty())
        {Toast.makeText(getApplicationContext(),"Username or password field is empty!", Toast.LENGTH_LONG).show();}
        else if(editTextPassword.getText().toString().equals("1980") && editTextUser_Name.getText().toString().equals("0698300131"))
        {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("passwordSaving",editTextPassword.getText().toString());
            editor.putString("usernameSaving",editTextUser_Name.getText().toString());
            editor.apply();
            Thread.sleep(2000);
            Intent submit=new Intent(this, MainMenu.class);
            startActivity(submit);
        }
        else{Toast.makeText(getApplicationContext(),"Wrong username or password!", Toast.LENGTH_LONG).show();}
    }
}