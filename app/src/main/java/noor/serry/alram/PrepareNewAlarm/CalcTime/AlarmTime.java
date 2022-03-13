package noor.serry.alram.PrepareNewAlarm.CalcTime;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;

import noor.serry.alram.databinding.ActivityNewAlramBinding;

public class AlarmTime {

    ActivityNewAlramBinding binding;
    private int hours;
    private int minutes;

    public AlarmTime(ActivityNewAlramBinding binding){
        this.binding= binding;
    }

   private int calcSelectTime(){
        int hoursSelected = binding.numberOfHours.getValue () ;
        int minutesSelected = binding.numberOfMinute.getValue ();
        int PmAm = binding.amOrPm.getValue () * 12;
        int totalInMinutes= (hoursSelected + PmAm) * 60 + minutesSelected;
        return totalInMinutes ;
   }

   @RequiresApi(api = Build.VERSION_CODES.O)
   private int getTimeNow(){
       LocalTime localTime = LocalTime.now ();
       int hoursNow = localTime.getHour ();
       int minutesNow = localTime.getMinute ();
       int totalInMinutes = hoursNow * 60 +minutesNow;
       return  totalInMinutes;
   }

   @RequiresApi(api = Build.VERSION_CODES.O)
   private int getTimeAlarm(){
        int time = calcSelectTime() - getTimeNow();
        if(time<0){
            time += 24 * 60;
        }
        return time;
   }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getHours() {
        hours = getTimeAlarm ()/60;
        return hours;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getMinutes(){
        minutes = getTimeAlarm () % 60;
        return minutes;
    }
}
