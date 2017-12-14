package com.example.android.karatecounter;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import br.com.bloder.magic.view.MagicButton;


public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int ScoreTeamB = 0;
    int WarningA = 0;
    int WarningB = 0;
    MagicButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (MagicButton)findViewById(R.id.threebutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA=scoreTeamA+3;
                displayForTeamA(scoreTeamA);
            }
        });

        button = (MagicButton)findViewById(R.id.twobutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA=scoreTeamA+2;
                displayForTeamA(scoreTeamA);
            }
        });

        button = (MagicButton)findViewById(R.id.onebutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA=scoreTeamA+1;
                displayForTeamA(scoreTeamA);
            }
        });

        button = (MagicButton)findViewById(R.id.warninga);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarningA=WarningA+1;
                displayForRedTeam(WarningA);
            }
        });

        button = (MagicButton)findViewById(R.id.threebuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB=ScoreTeamB+3;
                displayForTeamB(ScoreTeamB);
            }
        });

        button = (MagicButton)findViewById(R.id.twobuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB=ScoreTeamB+2;
                displayForTeamB(ScoreTeamB);
            }
        });

        button = (MagicButton)findViewById(R.id.onebuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB=ScoreTeamB+1;
                displayForTeamB(ScoreTeamB);
            }
        });

        button = (MagicButton)findViewById(R.id.warningb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarningB=WarningB+1;
                displayForBlueTeam(WarningB);
            }
        });

    }

    /**
     * Displays the given score for Red Team.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given score for Blue Team.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(ScoreTeamB));
    }

    /**
     * Increase the score for Red Team by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA=scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Red Team by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA=scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Red Team by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given warning for Red Team.
     */
    public void displayForRedTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_warning);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the warning for Red Team by 1 i n warning.
     */
    public void addOneWarningForA(View v) {
        WarningA=WarningA+1;
        displayForRedTeam(WarningA);
    }


    /**
     * Increase the score for Blue Team by 1 point.
     */
    public void addOneForTeamB(View v) {
        ScoreTeamB=ScoreTeamB+1;
        displayForTeamB(ScoreTeamB);
    }

    /**
     * Increase the score for Blue Team by 2 points.
     */
    public void addTwoForTeamB(View v) {
        ScoreTeamB=ScoreTeamB+2;
        displayForTeamB(ScoreTeamB);
    }

    /**
     * Increase the score for Blue Team by 3 points.
     */
    public void addThreeForTeamB(View v) {
        ScoreTeamB=ScoreTeamB+3;
        displayForTeamB(ScoreTeamB);
    }


    /**
     * Displays the given warning for Blue Team.
     */
    public void displayForBlueTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_warning);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the warning for Blue Team by 1 point in warning.
     */
    public void addOneWarningForBlue(View v) {
        WarningB=WarningB+1;
        displayForBlueTeam(WarningB);
    }
    /**
     * Delete the score for both Team points and warnings.
     */
    public void Reset(View v) {
        scoreTeamA=0;
        ScoreTeamB=0;
        WarningA = 0;
        WarningB = 0;
        displayForTeamB(0);
        displayForTeamA(0);
        displayForRedTeam(0);
        displayForBlueTeam(0);
    }

    /** save counter and on device rotation*/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("saveA", scoreTeamA);
        savedInstanceState.putInt("saveB", ScoreTeamB);
        savedInstanceState.putInt("savedA", WarningA);
        savedInstanceState.putInt("savedB", WarningB);
    }

    /** restore score and after rotation*/

    @Override
    public void onRestoreInstanceState (Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null){
            scoreTeamA = saveInstanceState.getInt("saveA");
            ScoreTeamB = saveInstanceState.getInt("saveB");
            WarningA = saveInstanceState.getInt("savedA");
            WarningB = saveInstanceState.getInt("savedB");
        }

        displayForTeamA(scoreTeamA);
        displayForTeamB(ScoreTeamB);
        displayForRedTeam(WarningA);
        displayForBlueTeam(WarningB);

    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }


}
