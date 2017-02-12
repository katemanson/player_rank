package com.example.kate.playerrank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by admin on 12/02/2017.
 */

public class Main extends AppCompatActivity {

    TextView mInstruction;

    Game mGame = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("PlayerRank", "Main onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstruction = (TextView)findViewById(R.id.instruction_text);
    }
}
