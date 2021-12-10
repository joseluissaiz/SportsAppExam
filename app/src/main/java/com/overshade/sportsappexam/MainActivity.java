package com.overshade.sportsappexam;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    private boolean isLandscape;
    //variables for landscape variation
    TrainingInfoFragment trainingInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(new Bundle());
        //Check if the device in in landscape mode or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            isLandscape = true;
            setContentView(R.layout.activity_main_landscape);
        } else {
            setContentView(R.layout.activity_main);
            isLandscape = false;
        }
        //Check if we return into the landscape mode from info fragment
        long trainingExtra = getIntent().getLongExtra("ENTRENAMENT", -1);
        if (trainingExtra != -1 && isLandscape) {
            Entrenament training = Entrenament.entrenaments[
                    (int) getIntent().getLongExtra("ENTRENAMENT", -1)];
            setTrainingInfoActivity(trainingExtra);
        }
        //Creating our training series fragment
        TrainingSeriesFragment trainingSeriesFragment = new TrainingSeriesFragment();
        //when selected, change activity
        trainingSeriesFragment.setOnItemClickListener(this::setTrainingInfoActivity);
        setFragment(R.id.fragment_container1, trainingSeriesFragment);
    }

    public void setTrainingInfoActivity(long trainingId) {
        if (isLandscape) {
            //Getting our training
            Entrenament training = Entrenament.entrenaments[(int) trainingId];
            if (trainingInfoFragment == null) {
                //Creating our trainingInfoFragment passing our training
                TrainingInfoFragment trainingInfoFragment = new TrainingInfoFragment(training);
                setFragment(R.id.fragment_container2, trainingInfoFragment);
            } else {
                //if the fragment already exists, we only update its values
                trainingInfoFragment.updateValues(training);
            }
        } else {
            //if its in portrait, launch the training info activity
            Intent i = new Intent(this, TrainingInfoActivity.class);
            Log.d("TOCTOC-", String.valueOf(trainingId));
            i.putExtra("ENTRENAMENT", trainingId);
            startActivity(i);
        }
    }

    public void setFragment(int containerID, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, fragment).commit();
    }

}