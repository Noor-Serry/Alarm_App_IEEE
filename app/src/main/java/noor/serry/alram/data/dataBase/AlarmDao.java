package noor.serry.alram.data.dataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlarmDao {
    @Insert
     long InsertNewAlarm(AlarmData alarmData);

    @Query (" Update AlarmData Set isActive = :isActive   where tag = :tag  ")
      void updateAlarm(int tag,boolean isActive);

  @Query ("Select * From AlarmData")
  LiveData<List<AlarmData>> getAllAlarmLive();


}
