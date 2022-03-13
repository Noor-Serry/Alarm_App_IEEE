package noor.serry.alram.workManager;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import noor.serry.alram.R;

public class RingAlarm extends Worker {
    Context context;
    MediaPlayer mediaPlayer;
    Uri musicUri ;
    public RingAlarm(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super (context, workerParams);
        this.context=context;
    }


    @NonNull
    @Override
    public Result doWork() {
        creatMediaPlayer ();
        mediaPlayer.start ();
        sleep (30);
        mediaPlayer.stop ();
        return Result.success ();
    }

        private void creatMediaPlayer(){
        mediaPlayer =  MediaPlayer.create(context,getUri ());
    }

        private Uri getUri(){
        setMusicUri ();
        return musicUri;
    }

        private void setMusicUri(){
        int musicIndex = RingtoneManager.TYPE_RINGTONE;
        musicUri = RingtoneManager.getDefaultUri (musicIndex);
    }
        private void sleep(int seconds)  {
            try {
                Thread.sleep (seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
    }
}






