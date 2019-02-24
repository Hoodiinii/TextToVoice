package com.apkglobal.texttovoice;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private Button btn_speak;
    private EditText et_message;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_speak=findViewById(R.id.btn_speak);
        et_message=findViewById(R.id.et_message);

        textToSpeech= new TextToSpeech(this,this);
    }

    @Override
    public void onInit(int status) {

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=et_message.getText().toString();
                textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}
