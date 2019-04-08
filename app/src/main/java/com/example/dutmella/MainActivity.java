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

/**
 * @author : Jelle Muijsers
 * Met deze klasse wordt de applicatie opgestart. Omdat te realiseren dat deze applicatie gebruik gemaakt van google-signIn heb ik de
 * google API gebruikt die beschreven staat op de website van Google. https://developers.google.com/identity/sign-in/android/sign-in
 *
 * Een aantal methoden staan hier beschreven:
 *
 * onCreate: Wordt automatisch aangeroepen wanneer de applicatie gestart wordt. Deze verwijst door naar de methode signInMethod
 * signInMethod: In deze methode wordt de signInIntent aangeroepen
 * onActivityResult:
 * handleSignInResult: Deze methode hanteerd de aanmelding van de gebruiker
 * onStart: Deze methode kijkt of er al een gebruiker is aangemeld in de applicatie. Wanneer dit niet het geval is roept hij de signInMethod aan,
 * en anders stuurt hij je door naar het hoofdmenu d.m.v. de toMainMenu methode.
 * toMainMenu: Deze methode stuurt je door naar de volgende activity voor het hoofdmenu.
 */
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
