package com.example.cesarepini.pacecalculator;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PredictedRaceTimesFragment extends Fragment {

    public PredictedRaceTimesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String format = "%.0f";
        Intent intent = getActivity().getIntent();
        View root = inflater.inflate(R.layout.fragment_predicted_race_times, container, false);
        double time5km = (double) Integer.parseInt(intent.getStringExtra(Intent.EXTRA_TEXT));
        FirstPaces firstPaces = new FirstPaces(time5km);
        firstPaces.predictRaceTimes();
        String[] predictedTimes = {
                "10 km" + String.format(format, firstPaces.first10km.time),
                "Marathon" + String.format(format, firstPaces.firstMP.time),
                "Half Marathon" + String.format(format, firstPaces.firstHMP.time)
        };
        ListView pacesListView = (ListView) root.findViewById(R.id.predicted_race_times_list_view);
        ArrayAdapter<String> trainingPacesArrayAdaptor = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_view_element,
                R.id.list_view_text_view_element,
                predictedTimes
        );
        pacesListView.setAdapter(trainingPacesArrayAdaptor);
        return root;
    }
}
