package noor.serry.alram.util.PrepareNewAlarm.Properies;





import android.os.Build;

import androidx.annotation.RequiresApi;

import noor.serry.alram.R;
import noor.serry.alram.databinding.FragmentNewAlarmBinding;
import noor.serry.alram.util.PrepareNewAlarm.CalcTime.AlarmTime;

public class AlarmTimeInTextView {
    String alarmIn,hours,minute;
    FragmentNewAlarmBinding binding;
    AlarmTime alarmTime;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public AlarmTimeInTextView(FragmentNewAlarmBinding binding){
        this.binding = binding;
        alarmTime = new AlarmTime (binding);
        getTranslationText();
        addAlarmTimeToTextView();
    }

    public void getTranslationText(){
        alarmIn =  binding.getRoot ().getResources ().getString(R.string.alarm_in);
        hours = binding.getRoot ().getResources ().getString(R.string.Hour);
        minute = binding.getRoot ().getResources ().getString(R.string.minute);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addAlarmTimeToTextView(){
        if(alarmTime.getHours () == 0)
            binding.textAlarmTime.setText (alarmIn +alarmTime.getMinutes ()+minute );
        else
            binding.textAlarmTime.setText (alarmIn +alarmTime.getHours () +hours+alarmTime.getMinutes ()+minute );
    }



}
