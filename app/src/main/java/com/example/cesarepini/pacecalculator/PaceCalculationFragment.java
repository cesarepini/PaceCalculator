package com.example.cesarepini.pacecalculator;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PaceCalculationFragment extends Fragment {

    private final String LOG_TAG = PaceCalculationFragment.class.getSimpleName();

    public PaceCalculationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        String format = "%.0f";
        View root = inflater.inflate(R.layout.fragment_pace_calculation, container, false);
        double time5km = (double) Integer.parseInt(intent.getStringExtra(Intent.EXTRA_TEXT));
        FirstPaces firstPaces = new FirstPaces(time5km);
        firstPaces.setFirstPacesFromFiveKmTime();
        String[] trainingPacesString = {
                String.format(format, firstPaces.first400.pace),
                String.format(format, firstPaces.first600.pace),
                String.format(format, firstPaces.first800.pace),
                String.format(format, firstPaces.first1000.pace),
                String.format(format, firstPaces.first1200.pace),
                String.format(format, firstPaces.first1600.pace),
                String.format(format, firstPaces.first2000.pace),
                String.format(format, firstPaces.firstST.pace),
                String.format(format, firstPaces.firstMT.pace),
                String.format(format, firstPaces.firstLT.pace),
                String.format(format, firstPaces.firstEA.pace),
                String.format(format, firstPaces.firstMP.pace),
                String.format(format, firstPaces.firstHMP.pace)
        };
        String[] distancesString = {
                "400 m",
                "600 m",
                "800 m",
                "1000 m",
                "1200 m",
                "1600 m",
                "2000 m",
                "ST",
                "MT",
                "LT",
                "EA",
                "MP",
                "HMP"
        };
        String[] trainingPacesWithDistances = new String[distancesString.length];
        for (int i = 0; i < distancesString.length; i++) {
            trainingPacesWithDistances[i] = distancesString[i] + "          " + trainingPacesString[i];
        }
        ListView pacesListView = (ListView) root.findViewById(R.id.paces_list_view);
        ArrayAdapter<String> trainingPacesArrayAdaptor = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_view_element,
                R.id.list_view_text_view_element,
                trainingPacesWithDistances
        );
        pacesListView.setAdapter(trainingPacesArrayAdaptor);
        return root;
    }
}
