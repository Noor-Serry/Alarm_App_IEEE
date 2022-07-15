package noor.serry.alram.ui.viewpager.viewMyAlarm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import noor.serry.alram.data.dataBase.AlarmData
import noor.serry.alram.data.Repository

class ViewModel(application: Application) : AndroidViewModel( application)  {
     var repository : Repository
     var alarmLiveData : LiveData<List<AlarmData>>


    init {
       repository = Repository(application.applicationContext)
        alarmLiveData = repository.getAllAlarm()
    }







}