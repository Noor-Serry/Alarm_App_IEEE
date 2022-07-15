package noor.serry.alram.data

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import noor.serry.alram.data.dataBase.AlarmDao
import noor.serry.alram.data.dataBase.AlarmData
import noor.serry.alram.data.dataBase.AlarmDataBase
import noor.serry.alram.data.dataBase.AlarmTag

class Repository(context: Context?) {
    var alarmDao: AlarmDao
    var contex = context;
    init {
        val alarmDataBase = AlarmDataBase.getInstance(context)
        alarmDao = alarmDataBase.alarmDao()
    }

    fun insertNewAlarm(alarmData: AlarmData?, alarmTag: AlarmTag) {
        GlobalScope.launch(Dispatchers.IO) { var tag = alarmDao.InsertNewAlarm(alarmData)
            alarmTag.getAlarmTag(tag)
    }}

    fun updateAlarm( tag:Int,isActive: Boolean){
        GlobalScope.launch ( Dispatchers.IO ){
            alarmDao.updateAlarm(tag,isActive)
        }
    }

    fun getAllAlarm():LiveData<List<AlarmData>> {
           return alarmDao.allAlarmLive
    }

}
