package noor.serry.alram.ui.viewpager.viewMyAlarm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import noor.serry.alram.R;
import noor.serry.alram.data.dataBase.AlarmData;

import noor.serry.alram.databinding.FragmentMainScreenBinding;
import noor.serry.alram.util.adapter.recyclerAdapter.recyclerViewMyAlarmAdapter;

public class ViewMyAlarm extends Fragment {
       FragmentMainScreenBinding binding;
       ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainScreenBinding.inflate (inflater,container,false);
        binding.imageButton.setOnClickListener (this::goToNewAlarm);
        return binding.getRoot ();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity ()).get (ViewModel.class);
        setRecyclerLayoutManager ();
        setObserver ();
    }

    private void setRecyclerLayoutManager(){
        binding.recyclerViewAlarm.setLayoutManager (new LinearLayoutManager (getContext ()));
    }

    private void setObserver(){
      viewModel.getAlarmLiveData ().observe (getViewLifecycleOwner (),this::onChanged);
    }

    public void onChanged(List<AlarmData> alarmData) {
      setRecyclerAdapter (alarmData);
    }

    private void setRecyclerAdapter(List<AlarmData> alarmData){
        binding.recyclerViewAlarm.setAdapter (new recyclerViewMyAlarmAdapter (getContext (),alarmData));
    }
    public void goToNewAlarm(View view){
        NavHostFragment.findNavController (this).navigate (R.id.action_viewPager_to_newAlarm);
    }
}