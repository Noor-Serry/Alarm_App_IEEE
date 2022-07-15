package noor.serry.alram.data.dataBase;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database (entities = {AlarmData.class}, version = 1 )
public abstract class AlarmDataBase extends RoomDatabase {
    private static AlarmDataBase alarmDataBase;
    public abstract AlarmDao alarmDao();

    public static synchronized AlarmDataBase getInstance(Context context){
        if(alarmDataBase == null)
            alarmDataBase = Room.databaseBuilder (context.getApplicationContext (),AlarmDataBase.class,"AlarmDataBase" ).
                    fallbackToDestructiveMigration ().build ();

        return alarmDataBase;
    }
}
