package noor.serry.alram.workManager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

    public class workManagerInstance {
    private static WorkManager workManager;
    private static OneTimeWorkRequest oneTimeWorkRequest;

    @NonNull
    public static WorkManager Instance(WorkRequest workRequest, Context context) {
      workManager =  WorkManager.getInstance(context);
      workManager.enqueue ( workRequest);
      return workManager;
    }

    public static WorkRequest getWorkRequest(int minutes) {
        TimeUnit unit = TimeUnit.MINUTES;
        oneTimeWorkRequest = new OneTimeWorkRequest.Builder (RingAlarm.class)
                             .setInitialDelay (minutes, unit).build ( );
        return oneTimeWorkRequest;
    }

}