package noor.serry.alram.util.adapter.recyclerAdapter

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.work.WorkManager
import noor.serry.alram.data.Repository
import noor.serry.alram.databinding.HolderMainBinding
import noor.serry.alram.util.PrepareNewAlarm.CalcTime.AlarmTime
import noor.serry.alram.util.workManager.workManagerInstance

@RequiresApi(Build.VERSION_CODES.O)
class viewHolder(var binding: HolderMainBinding) : RecyclerView.ViewHolder(binding.root) {
    val repository = Repository(binding.root.context)
   lateinit var  tag  : String
    lateinit var workManager :WorkManager

    init {
        binding.switchButton.setOnClickListener(this::onSwitchClick)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSwitchClick(view: View){
       tag = binding.switchButton.tag.toString()
        if(binding.switchButton.isChecked)
            turnOnAlarm()

        else turnOffTheAlarm()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun turnOnAlarm(){
        updateDataBase()
        startWorkManager()
    }

    fun updateDataBase(){repository.updateAlarm(Integer.parseInt(tag),binding.switchButton.isChecked)}

    @RequiresApi(Build.VERSION_CODES.O)
    fun startWorkManager(){
        var hoursAndMinutes = binding.timeTextView.text.toString().split(":")
        var amOrPm = binding.noteTextView.text.toString().split("|")[0]
        var minute = AlarmTime().getTimeInMinute(amOrPm,Integer.parseInt(hoursAndMinutes[0]),Integer.parseInt(hoursAndMinutes[1]))
        val workRequest = workManagerInstance.getWorkRequest(minute,tag)
        workManager  = workManagerInstance.getInstance(binding.root.context)
        workManager.enqueue(workRequest)
    }

    fun turnOffTheAlarm(){
        updateDataBase()
        workManager  = workManagerInstance.getInstance(binding.root.context)
       workManager.cancelAllWorkByTag(tag)
    }}