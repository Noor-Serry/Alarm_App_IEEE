package noor.serry.alram.util.PrepareNewAlarm.Properies;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import java.time.LocalTime;

import noor.serry.alram.databinding.FragmentNewAlarmBinding;

public class PropertiesOfNumberPiker {
    LocalTime timeNow ;
    FragmentNewAlarmBinding binding;
    final private int textSize = 100;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public PropertiesOfNumberPiker(FragmentNewAlarmBinding binding){
        this.binding=binding;
        timeNow = LocalTime.now ();
        setData ();
        setDefultDateInNumberPicker ();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setTextSize ();
            setTextColor ();
            onchange ();
        }
    }

    private void setData(){
        binding.numberOfMinute.setMinValue (0);
        binding.numberOfMinute.setMaxValue (59);
        binding.numberOfHours.setMinValue (1);
        binding.numberOfHours.setMaxValue (12);
        binding.amOrPm.setMaxValue (1);
        binding.amOrPm.setDisplayedValues(binding.getAmAndPm ());
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

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void setTextSize(){
        binding.numberOfMinute.setTextSize (textSize);
        binding.numberOfHours.setTextSize (textSize);
        binding.amOrPm.setTextSize (textSize);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void setTextColor(){
        binding.amOrPm.setTextColor (Color.WHITE);
        binding.numberOfMinute.setTextColor (Color.WHITE);
        binding.numberOfHours.setTextColor (Color.WHITE);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void onchange(){
        binding.numberOfMinute.setOnScrollChangeListener (this::onScrollChange);
        binding.numberOfHours.setOnScrollChangeListener (this::onScrollChange);
        binding.amOrPm.setOnScrollChangeListener (this::onScrollChange);
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            new AlarmTimeInTextView (binding);
    }
}

