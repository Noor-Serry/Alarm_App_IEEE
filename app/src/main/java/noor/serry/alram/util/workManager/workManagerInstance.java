package noor.serry.alram.util.workManager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

    public class workManagerInstance {
    private static WorkManager workManager;
    private static OneTimeWorkRequest oneTimeWorkRequest;

    @NonNull
    public static synchronized WorkManager getInstance( Context context) {
      workManager =  WorkManager.getInstance(context);
      return workManager;
    }

    public static WorkRequest getWorkRequest(int minutes,String tag) {
        Data data = new Data.Builder().putString ("tag",tag).build ();
        TimeUnit unit = TimeUnit.MINUTES;
        oneTimeWorkRequest = new OneTimeWorkRequest.Builder (RingAlarm.class)
                             .setInitialDelay (minutes, unit).addTag (tag)
                .setInputData (data).build ( );
        return oneTimeWorkRequest;
    }


}