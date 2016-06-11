package com.imagine.azureeepc.imaginecup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenu extends Activity
{
    public static String FromPageParam="";
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        gps=new GPSTracker(MainMenu.this);
        if(gps.isCanGetLocation())
        {
            double latitude=gps.getLatitude();
            double longitude=gps.getLongitude();
            Toast.makeText(getApplicationContext(),
                    "Your location is found\nLat: \t!" + latitude + "\nlon:\t" + longitude,
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            gps.showSettingsAlert();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void compagnshipClickHandler(View view)
    {
        FromPageParam = "compagnship";
        Intent compagnship=new Intent(this, Selector.class);
        startActivity(compagnship);

    }
}
