package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSave;
    private EditText edtName, edtPSpeed, edtPPower, edtKSpeed, edtKPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.saveBtn);
        btnSave.setOnClickListener(MainActivity.this);

        edtName = findViewById(R.id.edtName);
        edtKPower = findViewById(R.id.edtKPower);
        edtKSpeed = findViewById(R.id.edtKSpeed);
        edtPPower = findViewById(R.id.edtPPower);
        edtPSpeed = findViewById(R.id.edtPSpeed);
    }

    @Override
    public void onClick(View v) {

        try {
            final ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name", edtName.getText().toString());
            kickBoxer.put("punchSpeed", Integer.parseInt(edtPSpeed.getText().toString()));
            kickBoxer.put("punchPower", Integer.parseInt(edtPPower.getText().toString()));
            kickBoxer.put("kickSpeed", Integer.parseInt(edtKSpeed.getText().toString()));
            kickBoxer.put("kickPower", Integer.parseInt(edtKPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(MainActivity.this, kickBoxer.get("name") + " kickBoxer saved", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        //  Toast.makeText(MainActivity.this, kickBoxer.get("name") + "kickBoxer saved", Toast.LENGTH_LONG).show();
                    } else {
                        FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });

        } catch(Exception e) {
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
}
