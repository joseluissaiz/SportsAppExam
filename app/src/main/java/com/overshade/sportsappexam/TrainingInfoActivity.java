package com.overshade.sportsappexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class TrainingInfoActivity extends AppCompatActivity {
    TrainingInfoFragment trainingInfoFragment;
    private long trainingID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(new Bundle());
        setContentView(R.layout.activity_training_info);
        //Getting our training position
        trainingID = getIntent().getLongExtra("ENTRENAMENT", 0);
        //Getting our training
        Entrenament training = Entrenament.entrenaments[(int) trainingID];
        //Creating our trainingInfoFragment passing our training
        trainingInfoFragment = new TrainingInfoFragment(training);
        //Setting our fragment
        setFragment(trainingInfoFragment);
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container2, fragment).commit();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("ENTRENAMENT", trainingID);
            startActivity(i);
        }
    }

}