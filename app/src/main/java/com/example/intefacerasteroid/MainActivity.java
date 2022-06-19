package com.example.intefacerasteroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private final String DEBUG_TAG = "MAIN ACTIVITY MESSAGE:";
    private ArrayList<Integer>
            IpList = new ArrayList<>(Arrays.asList(192, 198, 160));

    private MyViewModel viewModel;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getIpNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(DEBUG_TAG,"PASANDO POR LIVE DATA");
            }
        });
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            Log.d(DEBUG_TAG, "savedinstancestate es null");
            fragmentManager
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view_spacecraft,
                            SpaceCraftSelection.class, null)
                    .commit();
        }
    }
}