package com.overshade.sportsappexam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TrainingInfoFragment extends Fragment {
    private Entrenament training;
    private View view;

    //////// CONSTRUCTOR

    public TrainingInfoFragment(Entrenament entrenament) {
        training = entrenament;
    }

    //////// LIFECYCLE METHODS

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_training_info, container, false);
        //Returning our image
        updateValues(training);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateValues(training);
    }

    public void updateValues(Entrenament newTraining) {
        this.training = newTraining;
        //Getting our fragments components
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        ImageView image = view.findViewById(R.id.image);
        //Setting all the info if a training is selected
        if (training == null) {
            title.setVisibility(View.GONE);
            description.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        } else {
            title.setVisibility(View.VISIBLE);
            description.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            title.setText(training.getNom());
            description.setText(training.getDescripcio());
            image.setImageResource(training.getImatge());
        }
    }
}