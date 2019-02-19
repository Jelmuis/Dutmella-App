package com.example.dutmella;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    GoogleSignInOptions gso = new  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build();

    int RC_SIGN_IN;
    GoogleSignInClient mGoogleSignInClient;
    String TAG = "Error";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.sign_in_button:
                        signInMethod();
                        break;
                }

            }
        });
    }

    private void signInMethod() {
        try {
            Intent i = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(i,RC_SIGN_IN);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    public void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try{
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            toMainMenu();
        }catch (ApiException e){
            Log.w(TAG,"singInResult: failed code" +e.getStatusCode());
            //updateUI
        }
    }

    public void onStart(){
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (GoogleSignIn.getLastSignedInAccount(this)== null){
            //android gaat automatisch naar inloggen.
        }else {
            //android ziet dat je ingelogd bent en gaat door naar het hoofdmenu.
            toMainMenu();
        }



    }

    public void toMainMenu(){
        Intent toMainMenuIntent = new Intent(this,MainMenuActivity.class);
        startActivity(toMainMenuIntent);
    }
}
