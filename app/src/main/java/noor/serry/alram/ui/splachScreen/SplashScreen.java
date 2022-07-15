package noor.serry.alram.ui.splachScreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import noor.serry.alram.R;


public class SplashScreen extends Fragment {
    private final int sleepTime = 4000;
    private NavController navController;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        navController = Navigation.findNavController (view);
        goToMainScreen ();

    }

    private void goToMainScreen(){
        new Handler (  ).postDelayed (this::run,sleepTime);

    }

    public void run() {
     navController.navigate (R.id.action_splashScreen_to_viewPager);
    }
}