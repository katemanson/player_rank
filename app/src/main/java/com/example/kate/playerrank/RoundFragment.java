package com.example.kate.playerrank;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 13/02/2017.
 */

public class RoundFragment extends Fragment {

    private static final String ARG_ROUND = "round";
    private static final String ARG_PREV_ATHLETES = "previous_round_number_of_athletes";

    private TextView mInstruction;
    private Round mRound;
    private int mPrevNumberAthletes;

    public static RoundFragment newInstance(Round newRound, int prevNumberAthletes) {
        Bundle args = new Bundle();

        //ToDo: ?Not sure implementing Serializable in Round class is a great idea. Better to pass round number as Fragment arg and recover specific Round from Game state?
        args.putSerializable(ARG_ROUND, newRound);
        args.putInt(ARG_PREV_ATHLETES, prevNumberAthletes);

        RoundFragment fragment = new RoundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d("PlayerRank", "RoundFragment onCreate called");
        super.onCreate(savedInstanceState);

        mRound = (Round) getArguments().getSerializable(ARG_ROUND);
        mPrevNumberAthletes = getArguments().getInt(ARG_PREV_ATHLETES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("PlayerRank", "RoundFragment onCreateView called");
        View view = inflater.inflate(R.layout.fragment_round, container, false);

        //ToDo: Show toast when number of athletes goes up; ?check in Back Stack for one or two fewer in previous round (fragments refd in Back Stack as "round_n").
        if (mPrevNumberAthletes < 3 && mRound.getQuestionAthletes().size() == 3) {
            Toast.makeText(getContext(), R.string.over_fifty_toast, Toast.LENGTH_SHORT).show();
        }
        if (mPrevNumberAthletes < 4 && mRound.getQuestionAthletes().size() == 4) {
            Toast.makeText(getContext(), R.string.over_seventy_toast, Toast.LENGTH_SHORT).show();
        }

        mInstruction = (TextView) view.findViewById(R.id.instruction_text);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.question_container);
        TextView roundTitle = (TextView) view.findViewById(R.id.round_title);

        roundTitle.setText("Round " + mRound.getRoundNumber());

        ArrayList<Athlete> athletes = mRound.getQuestionAthletes();

        //ToDo: Better solution for showing player photos and names (rather than text-only buttons):
        //ToDo: Player photos hard-coded; instead, use async/loader way to get them into res/drawable (along with rest of data)?
        //ToDo: Player photos fixed size; (?)not scalable within TextView; alternative (GridView)?
        //ToDo: TextViews not centering horizontally in parent View; athleteView.setGravity(Gravity.CENTER_HORIZONTAL) doesn't seem to work?
        for (int i = 0; i < athletes.size(); i++) {

            TextView athleteView = new TextView(this.getContext());
            athleteView.setText(athletes.get(i).getFullName());
            athleteView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            ));
            athleteView.setPadding(10, 10, 10, 10);
            athleteView.setMaxHeight(340);
            athleteView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            final int athleteId = athletes.get(i).getId();
            int athletePicRef = this.getContext().getResources().getIdentifier("id_" + athleteId, "drawable", "com.example.kate.playerrank");
            athleteView.setCompoundDrawablesWithIntrinsicBounds(0, athletePicRef, 0, 0);

            athleteView.setOnClickListener(new View.OnClickListener() {
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
            layout.addView(athleteView);
        }

        return view;
    }
}