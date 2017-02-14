package com.example.kate.playerrank;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 13/02/2017.
 */

public class RoundFragment extends Fragment {

    private static final String ARG_ROUND = "round";

    private TextView mInstruction;
    private Round mRound;

    public static RoundFragment newInstance(Round newRound) {
        Bundle args = new Bundle();

        //ToDo: ?Not sure implementing Serializable in Round class is a great idea. Better to pass round number as Fragment arg and recover specific Round from Game state?
        args.putSerializable(ARG_ROUND, newRound);

        RoundFragment fragment = new RoundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d("PlayerRank", "RoundFragment onCreate called");
        super.onCreate(savedInstanceState);

        mRound = (Round) getArguments().getSerializable(ARG_ROUND);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("PlayerRank", "RoundFragment onCreateView called");

        View view = inflater.inflate(R.layout.fragment_round, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.button_container);

        mInstruction = (TextView) view.findViewById(R.id.instruction_text);

        ArrayList<Athlete> athletes = mRound.getQuestionAthletes();

        //ToDo: Delete Logs.
        Log.d("PlayerRank", "athletes 0: " + athletes.get(0).getFullName());
        Log.d("PlayerRank", "athletes 1: " + athletes.get(1).getFullName());
        Log.d("PlayerRank", "answer athlete id: " + Integer.toString(mRound.getAnswerAthleteId()));

        for (int i = 0; i < athletes.size(); i++) {
            Button athleteButton = new Button(getActivity());
            athleteButton.setText(athletes.get(i).getFullName());
            athleteButton.setMinHeight(300);
            athleteButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            final int athleteId = athletes.get(i).getId();
            athleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean correct = mRound.checkAnswer(athleteId);
                    //ToDo: Delete Logs.
                    Log.d("PlayerRank", "Guess correct: " + mRound.getWhetherGuessCorrect());
                    int correctToast;
                    if (correct) {
                        correctToast = R.string.correct_toast;
                    } else {
                        correctToast = R.string.incorrect_toast;
                    }
                    Toast.makeText(getContext(), correctToast, Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(athleteButton);
        }

        return view;
    }
}