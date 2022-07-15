package noor.serry.alram.util.PrepareNewAlarm.CalcTime;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalTime;

import noor.serry.alram.databinding.FragmentNewAlarmBinding;
public class AlarmTime {

    FragmentNewAlarmBinding binding;
    private int hours;
    private int minutes;

    public AlarmTime(){
    }

    public AlarmTime(FragmentNewAlarmBinding binding){
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  int getTimeInMinute(){
        return (getHours ()*60)+ getMinutes ();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  int getTimeInMinute( String amOrPm, int hours, int minutes ){
        int timeSelected = amOrPm=="Am"||amOrPm=="ص" ?12:0;
        timeSelected +=hours;
        timeSelected = (timeSelected * 60) + minutes;
        int time = (timeSelected - getTimeNow ()) ;
            time += time<=-1?24*60:0;
        return time;
    }
}
