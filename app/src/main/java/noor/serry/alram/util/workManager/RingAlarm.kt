package noor.serry.alram.util.workManager

import android.content.Context
import androidx.work.WorkerParameters
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.widget.Toast
import androidx.work.Worker
import kotlinx.coroutines.*
import noor.serry.alram.data.Repository

class RingAlarm(var context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)
{
    var mediaPlayer: MediaPlayer? = null
    var musicUri: Uri? = null
    val timeRang = 30
    val  repository = Repository(context)


    override fun doWork(): Result {
        GlobalScope.launch (newSingleThreadContext("ringThread")){
            creatMediaPlayer()
            mediaPlayer!!.start()
            sleep(timeRang)
            mediaPlayer!!.stop()
            updateDataAfterRing()
           withContext(Dispatchers.Main){
               Toast.makeText(context,"done",Toast.LENGTH_LONG).show()
           }
       }
        return Result.success()
    }

    private fun creatMediaPlayer() {
        mediaPlayer = MediaPlayer.create(context, uri)
    }

    private val uri: Uri?
        private get():Uri?{
            setMusicUri()
            return musicUri
        }

    private fun setMusicUri() {
        val musicIndex = RingtoneManager.TYPE_RINGTONE
        musicUri = RingtoneManager.getDefaultUri(musicIndex)
    }

    private  fun sleep(seconds: Int) {
        try {
            Thread.sleep((seconds * 1000).toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private fun updateDataAfterRing(){
        var tag = inputData.getString("tag")
        repository.updateAlarm(Integer.parseInt(tag),false)

    }
}