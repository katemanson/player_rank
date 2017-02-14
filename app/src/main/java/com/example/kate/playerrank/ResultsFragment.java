package com.example.kate.playerrank;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by admin on 14/02/2017.
 */

public class ResultsFragment extends Fragment {

    private static final String ARG_RESULTS = "results";

    private HashMap<String, Integer> mResults;

    public static ResultsFragment newInstance(HashMap<String, Integer> results) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_RESULTS, results);

        ResultsFragment fragment = new ResultsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d("PlayerRank", "ResultsFragment onCreate called");
        super.onCreate(savedInstanceState);

        mResults = (HashMap<String, Integer>) getArguments().getSerializable(ARG_RESULTS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("PlayerRank", "ResultsFragment onViewCreate called");
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        TextView resultsView = (TextView) view.findViewById(R.id.results_text);
        int numberCorrect = (int) mResults.get("number correct");
        int numberOfRounds = (int) mResults.get("number of rounds");
        int percentageCorrect = (int) mResults.get("percentage correct");

        resultsView.setText(
                "Number of rounds: " + numberOfRounds + "\n" +
                "Correct answers: " + numberCorrect + "\n" +
                "Percentage correct: " + percentageCorrect
        );

        return view;
    }
}
