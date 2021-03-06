package com.loginradius.demo;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button btnlogin,btnregister,btnforgotpassword;
    Button.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = null;
                switch (v.getId()) {
                    case R.id.login_bt:
                      intent = new Intent(getApplication(), LoginActivity.class);
                       break;
                    case R.id.signup_bt:
                        intent = new Intent(getApplication(), RegisterActivity.class);
                        // do stuff;
                        break;
                    case R.id.forgot_bt:
                        intent = new Intent(getApplication(), ForgotPasswordActivity.class);
                        break;
                    default:
                        return;
                }


                startActivityForResult(intent, 2);
            }
        };
        initWidget();

    }
   private void initWidget() {
        //initialize button
        btnlogin = (Button) findViewById(R.id.login_bt);
        btnregister = (Button) findViewById(R.id.signup_bt);
        btnforgotpassword = (Button) findViewById(R.id.forgot_bt);
        //set on Click listener
        btnlogin.setOnClickListener(listener);
        btnregister.setOnClickListener(listener);
        btnforgotpassword.setOnClickListener(listener);

}
}