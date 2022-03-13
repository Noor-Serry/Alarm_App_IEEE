package noor.serry.alram.SpalshScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import noor.serry.alram.Activites.MainActivity;
import noor.serry.alram.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_screen);
        new Handler (  ).postDelayed (new runnable (),3600);
    }

    private class runnable implements Runnable{

        @Override
        public void run() {
            goToMainActivity ();
        }
    }

    private void goToMainActivity(){
        Intent intent;
        intent = new Intent ( this, MainActivity.class);
        startActivity (intent);
        finish ();
    }

}