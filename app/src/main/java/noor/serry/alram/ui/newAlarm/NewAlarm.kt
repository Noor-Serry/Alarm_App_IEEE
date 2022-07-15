package noor.serry.alram.ui.newAlarm

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import noor.serry.alram.R
import noor.serry.alram.data.dataBase.AlarmData
import noor.serry.alram.data.dataBase.AlarmDataBase
import noor.serry.alram.data.Repository
import noor.serry.alram.databinding.FragmentNewAlarmBinding
import noor.serry.alram.util.PrepareNewAlarm.CalcTime.AlarmTime
import noor.serry.alram.util.PrepareNewAlarm.Properies.AlarmTimeInTextView
import noor.serry.alram.util.PrepareNewAlarm.Properies.PropertiesOfNumberPiker
import noor.serry.alram.util.workManager.workManagerInstance

@RequiresApi(api = Build.VERSION_CODES.O)
class NewAlarm : Fragment() {
    var binding: FragmentNewAlarmBinding? = null
    var alarmDataBase: AlarmDataBase? = null
    var alarmTime :AlarmTime? = null
    var repository :Repository? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentNewAlarmBinding.inflate(inflater, container, false)
        binding!!.amAndPm = resources.getStringArray(R.array.amAndpm)
        binding!!.newAlarm = this
        alarmTime = AlarmTime(binding)
        repository = Repository(context)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PropertiesOfNumberPiker(binding)
        AlarmTimeInTextView(binding)
        alarmDataBase = AlarmDataBase.getInstance(requireContext().applicationContext)
    }

    fun cancel() {
        NavHostFragment.findNavController(this).navigate(R.id.action_newAlarm_to_viewPager)
    }

    fun siveNewAlarm() {
        setDataInRoomDataBase()
        NavHostFragment.findNavController(this).navigate(R.id.action_newAlarm_to_viewPager)
    }

    private fun setDataInRoomDataBase() {
        repository!!.insertNewAlarm(getAlarmData(),this::turnOnStartAlarm)

    }

        private fun  getAlarmData(): AlarmData {
            val AmPm = resources.getStringArray(R.array.amAndpm)[binding!!.amOrPm.value]
            val note = binding!!.AlarmNote.text.toString()
            val minute = binding!!.numberOfMinute.value
            val hour = binding!!.numberOfHours.value
            return AlarmData(
                note,
                AmPm,
                minute,
                hour,
                true
            )

        }

    private fun turnOnStartAlarm(tag :Long){
        val workRequest = workManagerInstance.getWorkRequest(alarmTime!!.timeInMinute,tag.toString())
        val workManager = workManagerInstance.getInstance(context)
        workManager.enqueue(workRequest)

    }

}