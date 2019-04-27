package com.example.a1606020033_phamleminh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser,txtpw;
    String mUser = "";
    String mPass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInit();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onValidateForm()) {
                    Map<String, String> mMap = new HashMap<>();
                    mMap.put("user_name", mUser);
                    mMap.put("password", mPass);
                    new LoginAsyncTask(LoginActivity.this, new ILoginView() {
                       @Override
                        public void onLoginSuccess(String m,int iID) {
                            Toast.makeText(LoginActivity.this, m, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, PhoneActivity.class);
                            intent.putExtra("getID",iID);
                            startActivity(intent);
                        }
                        @Override
                        public void onLoginFail(String m) {
                            Toast.makeText(LoginActivity.this, m, Toast.LENGTH_SHORT).show();
                        }
                    }, mMap).execute("http://www.vidophp.tk/api/account/signin");
                }
            }
        });
    }

    private boolean onValidateForm(){
        mUser = txtUser.getText().toString();
        if (mUser.length() < 1){
            txtUser.setError("Username field cannot be blank");
            return false;
        }

        mPass = txtpw.getText().toString();
        if (mPass.length() < 1){
            txtpw.setError("Password field cannot be blank");
            return  false;
        }
        return true;
    }
    private void onInit() {
        txtUser = findViewById(R.id.txtLogin);
        txtpw = findViewById(R.id.txtPw);
        btnLogin = findViewById(R.id.btnLogin);
    }
}

