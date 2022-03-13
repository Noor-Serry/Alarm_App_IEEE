package noor.serry.alram.PrepareNewAlarm.NewAlarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import noor.serry.alram.PrepareNewAlarm.CalcTime.AlarmTime;
import noor.serry.alram.PrepareNewAlarm.Properies.PropertiesOfNumberPiker;
import noor.serry.alram.R;
import noor.serry.alram.databinding.ActivityNewAlramBinding;
import noor.serry.alram.workManager.workManagerInstance;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class NewAlram extends AppCompatActivity {
     ActivityNewAlramBinding binding;
     int alarmMinutes;
     int alarmHours;
     AlarmTime alarmTime;
    WorkRequest workRequest;
    WorkManager workManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_new_alram);
        binding.setAmAndPm (getResources ( ).getStringArray (R.array.amAndpm));

        new PropertiesOfNumberPiker (binding);
        alarmTime = new AlarmTime (binding);
        new AlarmTimeInTextView ();
        onchange ();
    }

    private class AlarmTimeInTextView{
        String alarmIn,hours,minute;
        AlarmTimeInTextView (){
            getTranslationText();
            addAlarmTimeToTextView();
        }

        public void getTranslationText(){
            alarmIn = getString (R.string.alarm_in);
              hours = getString (R.string.Hour);
             minute = getString (R.string.minute);
        }

        private void addAlarmTimeToTextView(){
            setAlarmTimeInValues ();
            if(alarmHours == 0){
                binding.textAlarmTime.setText (alarmIn +alarmMinutes+minute );}
            else{
                binding.textAlarmTime.setText (alarmIn +alarmHours +hours+alarmTime.getMinutes ()+minute );
            }
        }

    }

    public void setAlarmTimeInValues(){
        alarmMinutes = alarmTime.getMinutes ();
        alarmHours = alarmTime.getHours ();
    }

    public void onchange(){
        binding.numberOfMinute.setOnScrollChangeListener (new onScrollChangeListener ());
        binding.numberOfHours.setOnScrollChangeListener (new onScrollChangeListener ());
        binding.amOrPm.setOnScrollChangeListener (new onScrollChangeListener ());
    }

    private class onScrollChangeListener implements View.OnScrollChangeListener {

        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            new AlarmTimeInTextView ();
        }
    }

    public void cancel(View view){
        finish ();
    }

    public void siveNewAlarm(View view){
            workRequest = workManagerInstance.getWorkRequest (alarmMinutes);
            workManager = workManagerInstance.Instance (workRequest,getBaseContext ());
          finish ();
    }









}