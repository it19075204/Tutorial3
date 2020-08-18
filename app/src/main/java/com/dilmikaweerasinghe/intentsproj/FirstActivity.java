package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dilmikaweerasinghe.intentsproj.R;

public class FirstActivity extends AppCompatActivity {
    private Button btn;
    public static final String EXTRA_NUMBER1 = "com.example.intentsproj.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.intentsproj.EXTRA_NUMBER2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnNav);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                OK();

                //Toast message method 01
                //Toast.makeText(getApplicationContext(),R.string.toast,Toast.LENGTH_LONG).show();

                //Toast message method 02
                Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                CharSequence message = "You just clicked the OK button"; //Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
            }
        });
    }

    public void OK(){
        EditText edtxt1 = (EditText) findViewById(R.id.inputOne);
        EditText edtxt2 = (EditText) findViewById(R.id.inputTwo);
        int num1 = Integer.parseInt(edtxt1.getText().toString());
        int num2 = Integer.parseInt(edtxt2.getText().toString());

        Intent intent  = new Intent(this, com.example.intentsproj.SecondActivity.class);
        intent.putExtra(EXTRA_NUMBER1, num1);
        intent.putExtra(EXTRA_NUMBER2, num2);
        startActivity(intent);
        finish();
    }
}