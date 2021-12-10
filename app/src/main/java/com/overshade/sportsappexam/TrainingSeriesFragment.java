package com.overshade.sportsappexam;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class TrainingSeriesFragment extends ListFragment {
    Listener listener;

    //////// CONSTRUCTORS

    public TrainingSeriesFragment() {}

    //////// LIFECYCLE METHODS

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //returning our view
        return inflater.inflate(R.layout.fragment_training_series, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Getting our training listview
        ListView trainingList = getListView();

        //Getting all trainings
        Entrenament[] trainings = Entrenament.entrenaments;

        //Creating an ArrayAdapter for our list
        int listItemLayout = R.layout.training_list_item;
        trainingList.setAdapter(new ListAdapter(requireContext(), listItemLayout, trainings));
        Log.d("List items count = ", String.valueOf(trainingList.getCount()));
    }

    //////// EVENT HANDLERS
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("Item clicked at :", String.valueOf(id));
        listener.itemClicked(id);

    }

    //////// LISTENERS

    interface Listener {
        void itemClicked(long id);
    }

    public void setOnItemClickListener(Listener listener) {
        this.listener = listener;
    }

    //////// LIST ADAPTER

    private static class ListAdapter extends ArrayAdapter<Entrenament> {
        private final int     resourceLayout;
        private final Context context;

        public ListAdapter(Context context, int layoutRes, Entrenament[] trainings) {
            super(context, layoutRes, trainings);
            this.resourceLayout = layoutRes;
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                //inflating view if its null
                LayoutInflater inflater;
                inflater = LayoutInflater.from(context);
                view = inflater.inflate(resourceLayout, null);
            }
            //getting all trainings one by one
            Entrenament training = getItem(position);
            if (training != null) {
                //setting the training name into the list textview
                TextView nameTextView = view.findViewById(R.id.trainingName);
                if (nameTextView != null) {
                    //if the text view exist (should) we set the training name
                    nameTextView.setText(training.getNom());
                }
                //setting its image
                ImageView imageView = view.findViewById(R.id.trainingImage);
                if (imageView != null) {
                    // if the imageview exists (should) we set the training image
                    imageView.setImageResource(training.getImatge());
                }
            }
            //returning our view
            return view;
        }
    }

}