package com.example.android.karatecounter;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        /**
         * Increase the score for Red Team by 3 points.
         */
        button = (MagicButton) findViewById(R.id.threebutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA = scoreTeamA + 3;
                displayForTeamA(scoreTeamA);
            }
        });
        /**
        * Increase the score for Red Team by 2 points.
        */
        button = (MagicButton) findViewById(R.id.twobutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA = scoreTeamA + 2;
                displayForTeamA(scoreTeamA);
            }
        });
        /**
        * Increase the score for Red Team by 1 point.
        */
        button = (MagicButton) findViewById(R.id.onebutton);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
            }
        });
        /**
        * Increase the warning for Red Team by 1 in warning.
        */
        button = (MagicButton) findViewById(R.id.warninga);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarningA = WarningA + 1;
                if (WarningA==3) {
                    //Show an error message as a toast
                    Toast.makeText(MainActivity.this, "Red Team lost! ", Toast.LENGTH_SHORT).show();
                    scoreTeamA = 0;
                    WarningA = 0;
                    displayForTeamA(0);
                    displayForRedTeam(0);
                    return;
                }
                displayForRedTeam(WarningA);
            }
        });

        /**
         * Increase the score for Blue Team by 3 points.
         */
        button = (MagicButton) findViewById(R.id.threebuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB = ScoreTeamB + 3;
                displayForTeamB(ScoreTeamB);
            }
        });
        /**
         * Increase the score for Blue Team by 2 points.
         */
        button = (MagicButton) findViewById(R.id.twobuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB = ScoreTeamB + 2;
                displayForTeamB(ScoreTeamB);
            }
        });
        /**
         * Increase the score for Blue Team by 1 point.
         */
        button = (MagicButton) findViewById(R.id.onebuttonb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreTeamB = ScoreTeamB + 1;
                displayForTeamB(ScoreTeamB);
            }
        });

        /**
        * Increase the warning for Blue Team by 1 point in warning.
        */

        button = (MagicButton) findViewById(R.id.warningb);
        button.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarningB = WarningB + 1;
                if (WarningB==3) {
                    //Show an error message as a toast
                    Toast.makeText(MainActivity.this, "Blue Team lost! ", Toast.LENGTH_SHORT).show();
                    ScoreTeamB = 0;
                    WarningB = 0;
                    displayForTeamB(0);
                    displayForBlueTeam(0);
                    return;
                }
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
     * Displays the given warning for Red Team.
     */
    public void displayForRedTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_warning);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given warning for Blue Team.
     */
    public void displayForBlueTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_warning);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Delete the score for both Team points and warnings.
     */
    public void Reset(View v) {
        scoreTeamA = 0;
        ScoreTeamB = 0;
        WarningA = 0;
        WarningB = 0;
        displayForTeamB(0);
        displayForTeamA(0);
        displayForRedTeam(0);
        displayForBlueTeam(0);
    }

    /**
     * save counter and on device rotation
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("saveA", scoreTeamA);
        savedInstanceState.putInt("saveB", ScoreTeamB);
        savedInstanceState.putInt("savedA", WarningA);
        savedInstanceState.putInt("savedB", WarningB);
    }

    /**
     * restore score and after rotation
     */

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null) {
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


}
