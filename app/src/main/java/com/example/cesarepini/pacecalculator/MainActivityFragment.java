package com.example.cesarepini.pacecalculator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button buttonCalculatePaces = (Button) rootView.findViewById(R.id.calculate_paces_button);
        buttonCalculatePaces.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          EditText time5KmEditText = (EditText) rootView.findViewById(R.id.five_km_time_edit_text);
                                          String time5Km = time5KmEditText.getText().toString();
                                          if (time5Km.split(":").length == 2
                                                  ) {
                                              try {
                                                  double timeInSeconds = convertTimeInSeconds(time5Km);
                                                  if (timeInSeconds != -1) {
                                                      String timeInSecondsString = String.format("%4.0f", timeInSeconds);
                                                      Toast.makeText(getActivity(), timeInSecondsString, Toast.LENGTH_SHORT).show();
                                                      Intent intent = new Intent(getActivity(), PaceCalculation.class).putExtra(Intent.EXTRA_TEXT, timeInSecondsString);
                                                      startActivity(intent);
                                                  } else {
                                                      TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                                      textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                                  }
                                              } catch (NumberFormatException e) {
                                                  TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                                  textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                              }
                                          } else {
                                              TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                              textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                          }
                                      }
                                  }
        );

        Button buttonPredictRaceTimes = (Button) rootView.findViewById(R.id.predict_race_times_button);
        buttonPredictRaceTimes.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        EditText time5KmEditText = (EditText) rootView.findViewById(R.id.five_km_time_edit_text);
                                                        String time5Km = time5KmEditText.getText().toString();
                                                        if (time5Km.split(":").length == 2
                                                                ) {
                                                            try {
                                                                double timeInSeconds = convertTimeInSeconds(time5Km);
                                                                if (timeInSeconds != -1) {
                                                                    String timeInSecondsString = String.format("%4.0f", timeInSeconds);
                                                                    Toast.makeText(getActivity(), timeInSecondsString, Toast.LENGTH_SHORT).show();
                                                                    Intent intent = new Intent(getActivity(), PredictedRaceTimes.class).putExtra(Intent.EXTRA_TEXT, timeInSecondsString);
                                                                    startActivity(intent);
                                                                } else {
                                                                    TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                                                    textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                                                textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                                            }
                                                        } else {
                                                            TextView textView = (TextView) rootView.findViewById(R.id.bad_time_entered_warning);
                                                            textView.setText(getString(R.string.incorrect_5_km_time_entry));
                                                        }
                                                    }
                                                }
        );
        return rootView;
    }

    private double convertTimeInSeconds(String timeString){
        String minutes = timeString.split(":")[0];
        String seconds = timeString.split(":")[1];
        if (minutes.length() != 2 || seconds.length() != 2) {
            return -1;
        }
        return Integer.parseInt(timeString.split(":")[0]) * 60 + Integer.parseInt(timeString.split(":")[1]);
    }
}