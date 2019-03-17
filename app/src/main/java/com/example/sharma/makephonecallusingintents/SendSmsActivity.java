package com.example.sharma.makephonecallusingintents;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSmsActivity extends AppCompatActivity {
    EditText edt_sms_text,edt_phone_no;
    Button btn_send_sms;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        init();
    }

    private void init() {
        edt_sms_text=findViewById(R.id.edt_sms);
        edt_phone_no=findViewById(R.id.edt_phone_no);
        btn_send_sms=findViewById(R.id.btn_sms);
    }

    public void Send(View view) {
        //check permission granted or not
        if (ActivityCompat.checkSelfPermission(SendSmsActivity.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, 1001);
        }
        String phoneNo= edt_phone_no.getText().toString();
        String message=edt_sms_text.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, message, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.",
                Toast.LENGTH_LONG).show();
    }
}
