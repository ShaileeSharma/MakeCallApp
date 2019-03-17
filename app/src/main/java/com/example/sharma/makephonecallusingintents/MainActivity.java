package com.example.sharma.makephonecallusingintents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edt_phone_no;
Button btn_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        edt_phone_no=findViewById(R.id.edt_phone_no);
        btn_call=findViewById(R.id.btn_call);

    }

    public void Call(View view) {
       //check permission granted or not
       if (ActivityCompat.checkSelfPermission(MainActivity.this,
              Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

           ActivityCompat.requestPermissions(this,
                   new String[]{Manifest.permission.CALL_PHONE}, 1001);
      }
        // call using intent
        String number=edt_phone_no.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));
        startActivity(callIntent);

    }


}
