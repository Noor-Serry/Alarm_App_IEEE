package noor.serry.alram.ui;




import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;





import noor.serry.alram.R;
import noor.serry.alram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   public static ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this,R.layout.activity_main);

    }



}