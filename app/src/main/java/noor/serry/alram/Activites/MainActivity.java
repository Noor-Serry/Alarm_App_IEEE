package noor.serry.alram.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import noor.serry.alram.PrepareNewAlarm.NewAlarm.NewAlram;
import noor.serry.alram.R;

public class MainActivity extends AppCompatActivity {
     Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void goToNewAlramActivity(View view){
        intent=new Intent (getBaseContext (),NewAlram.class);
        startActivity (intent);
    }

}