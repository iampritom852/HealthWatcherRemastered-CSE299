package com.example.pritom.healthwatcher;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class Primary extends AppCompatActivity {

    private String user;
    private int p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);

        ImageButton HeartRate = (ImageButton)this.findViewById(R.id.HR);
        ImageButton BloodPressure = (ImageButton)this.findViewById(R.id.BP);
        ImageButton Ox2 = (ImageButton)this.findViewById(R.id.O2);
        ImageButton RRate = (ImageButton)this.findViewById(R.id.RR);
        ImageButton VitalSigns = (ImageButton)this.findViewById(R.id.VS);
        ImageButton Abt = (ImageButton)this.findViewById(R.id.About);





        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");
            //The key argument here must match that used in the other activity
        }

        Abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AboutApp.class);
                startActivity(i);
                finish();
            }
        });


        //Every Test Button sends the username + the test number, to go to the wanted test after the instructions activity
        HeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=1;
                Intent i = new Intent(v.getContext(),StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();
            }
        });

        BloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=2;
                Intent i = new Intent(v.getContext(),StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();
            }
        });

        RRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=3;
                Intent i = new Intent(v.getContext(),StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();
            }
        });

        Ox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=4;
                Intent i = new Intent(v.getContext(),StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();

            }
        });

        VitalSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=5;
                Intent i = new Intent(v.getContext(),StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();
            }
        });

    }
    public void open(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.medicalnewstoday.com/"));
        startActivity(browserIntent);
    }
    public void eye(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.personaleyes.com.au/online-eye-test/index.php"));
        startActivity(browserIntent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("You Done?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        Primary.super.onBackPressed();
                        finish();
                        System.exit(0);
                    }
                }).create().show();
    }


}

