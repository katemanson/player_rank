package com.example.kate.playerrank;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 12/02/2017.
 */

public class Main extends FragmentActivity {

    private Game mGame;
    private Button mNextButton;
    private Button mFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("PlayerRank", "Main onCreate called");

        //ToDo: ?Create static context with getApplicationContext() to store context, access from fragments? (See http://stackoverflow.com/questions/8215308/using-context-in-a-fragment.)
        //ToDo: ?Better solution for getting data from API than running query in main thread (something to do with Loaders)? Delete the two lines below?
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mGame = new Game();
        }
        setContentView(R.layout.activity_main);

        FragmentManager fragMan = getSupportFragmentManager();
        Fragment fragment = fragMan.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            mGame.newRound();
            Round round = mGame.getLatestRound();
            fragment = RoundFragment.newInstance(round);
            fragMan.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToDo: Go to next round.
            }
        });

        mFinishButton = (Button) findViewById(R.id.finish_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToDo: Go to results activity/fragment.
            }
        });

    }
}
