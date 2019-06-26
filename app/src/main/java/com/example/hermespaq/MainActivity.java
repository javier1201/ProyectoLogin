package com.example.hermespaq;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;

public class MainActivity extends AppCompatActivity {

    private EditText Name, Password;
    private Button Login, Clear;
    private Auth0 auth0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Clear = (Button) findViewById(R.id.btnClear);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        auth0 = new Auth0(this);
        auth0.setOIDCConformant(true);
    }


    private void login() {

        WebAuthProvider.init(auth0)
                .withScheme("demo")
                .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
                .start(MainActivity.this, new AuthCallback() {
                    @Override
                    public void onFailure(@NonNull Dialog dialog) {
                        // Show error Dialog to user
                    }

                    @Override
                    public void onFailure(AuthenticationException exception) {
                        // Show error to user
                        Toast.makeText(getApplicationContext(),"Wrong Information!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(@NonNull Credentials credentials) {
                        Clear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Password.setText("");
                                Name.setText("");
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(), Customers.class);
                        startActivity(intent);
                    }
                });
    }
}
