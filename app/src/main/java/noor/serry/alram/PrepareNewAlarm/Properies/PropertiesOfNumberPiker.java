package noor.serry.alram.PrepareNewAlarm.Properies;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalTime;
import noor.serry.alram.databinding.ActivityNewAlramBinding;

public class PropertiesOfNumberPiker {
    LocalTime timeNow ;
    ActivityNewAlramBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public PropertiesOfNumberPiker(ActivityNewAlramBinding binding){
        this.binding=binding;
        timeNow = LocalTime.now ();
        callMethod ();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void callMethod(){
        setData ();
        setDefultDateInNumberPicker ();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setSize (); }
    }

    private void setData(){
        binding.numberOfMinute.setMinValue (0);
        binding.numberOfMinute.setMaxValue (59);
        binding.numberOfHours.setMinValue (1);
        binding.numberOfHours.setMaxValue (12);
        binding.amOrPm.setMaxValue (1);
        binding.amOrPm.setDisplayedValues(binding.getAmAndPm ());
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void setSize(){
        binding.numberOfHours.setTextSize (100);
        binding.numberOfMinute.setTextSize (100);
        binding.amOrPm.setTextSize (100);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setDefultDateInNumberPicker(){
        if(timeNow.getHour()>12){
            binding.numberOfHours.setValue (timeNow.getHour()-12);
            changeAmToPm ();
        }
        else{ binding.numberOfHours.setValue (timeNow.getHour());
        }
        binding.numberOfMinute.setValue (timeNow.getMinute ());
    }

    private void changeAmToPm (){
        binding.amOrPm.setValue (1);
    }
}
