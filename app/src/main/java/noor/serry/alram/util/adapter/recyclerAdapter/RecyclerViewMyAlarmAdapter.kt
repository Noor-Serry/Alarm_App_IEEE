package noor.serry.alram.util.adapter.recyclerAdapter

import android.content.Context
import android.os.Build
import noor.serry.alram.data.dataBase.AlarmData
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import noor.serry.alram.databinding.HolderMainBinding


class recyclerViewMyAlarmAdapter(var context: Context, var alarmData: List<AlarmData?>?) :
    RecyclerView.Adapter<viewHolder>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = HolderMainBinding.inflate(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, i: Int) {
        holder.binding.alarmData = alarmData?.get(i)
    }

    override fun getItemCount(): Int {
        return alarmData!!.size
    }


}