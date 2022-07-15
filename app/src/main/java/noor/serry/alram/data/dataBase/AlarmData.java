package noor.serry.alram.data.dataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AlarmData")
public class AlarmData {

    @PrimaryKey (autoGenerate = true)
    private  int tag;
    private String note;
    private int ringInOfMinute;
    private int ringInHour;
    private boolean isActive;
    private String AmPm;

    public AlarmData(String note, String AmPm, int ringInOfMinute, int ringInHour, boolean isActive) {
        this.note = note;
        this.AmPm = AmPm;
        this.ringInOfMinute = ringInOfMinute;
        this.ringInHour = ringInHour;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getTag() {
        return tag;
    }

    public String getNote() {
        return note;
    }

    public String getAmPm() {
        return AmPm;
    }

    public int getRingInOfMinute() {
        return ringInOfMinute;
    }

    public int getRingInHour() {
        return ringInHour;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }



}
