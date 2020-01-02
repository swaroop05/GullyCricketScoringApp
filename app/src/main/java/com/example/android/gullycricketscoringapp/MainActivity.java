package com.example.android.gullycricketscoringapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int wicketsTeamA = 0;
    int scoreTeamB = 0;
    int wicketsTeamB = 0;
    boolean teamAInningsOverFlag = false;
    boolean matchOver = false;
    String winningTeam = null;
    String teamAInningsOver = "Team A Innings Over";
    String teamBInningsOver = "Team B Innings Over";
    String teamAIsWinner = "Team A is the Winner";
    String teamBIsWinner = "Team B is the Winner";
    String drawMatch = "Draw Match";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Updates the Score to 6 when sixer is hit by team A
     *
     * @param view
     */

    public void updateScoreTo6ToTeamA(View view) {
        if (!teamAInningsOverFlag) {
            scoreTeamA = scoreTeamA + 6;
            displayForTeamA(scoreTeamA, wicketsTeamA);
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }

    /**
     * Updates the Score to 4 when Boundary is hit by team A
     *
     * @param view
     */
    public void updateScoreTo4ToTeamA(View view) {
        if (!teamAInningsOverFlag) {
            scoreTeamA = scoreTeamA + 4;
            displayForTeamA(scoreTeamA, wicketsTeamA);
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }

    /**
     * Updates the Score to 2 when two runs are hit by team A
     *
     * @param view
     */

    public void updateScoreTo2ToTeamA(View view) {
        if (!teamAInningsOverFlag) {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA, wicketsTeamA);
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }

    /**
     * Updates the Score to 1 when 1 run is hit by team A
     *
     * @param view
     */
    public void updateScoreTo1ToTeamA(View view) {
        if (!teamAInningsOverFlag) {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA, wicketsTeamA);
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }

    /**
     * Adds one wicket for Team A & also finds if the innings is over for Team A
     *
     * @param view
     */
    public void aPlayerIsOutInTeamA(View view) {
        if (!teamAInningsOverFlag) {
            wicketsTeamA = wicketsTeamA + 1;
            if (wicketsTeamA <= 10) {
                displayForTeamA(scoreTeamA, wicketsTeamA);
                if (wicketsTeamA == 10) {
                    displayInningsOverTeamA(teamAInningsOver);
                    teamAInningsOverFlag = true;
                }
            } else {
                teamAInningsOverFlag = true;
                displayInningsOverTeamA(teamAInningsOver);
            }
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }

    /**
     * Displays the message to team A as innings over when this function is called.
     *
     * @param message
     */
    public void displayInningsOverTeamA(String message) {
        TextView inningsOverTeamA = (TextView) findViewById(R.id.innings_over_team_a);
        inningsOverTeamA.setText(message);
    }

    /**
     * Displays Score for Team A
     *
     * @param score
     */
    public void displayForTeamA(int score, int wickets) {
        if (!teamAInningsOverFlag) {
            if (wicketsTeamA <= 10) {
                TextView scoreView = (TextView) findViewById(R.id.team_a_score);
                scoreView.setText(String.valueOf(score) + " For " + String.valueOf(wickets));
            } else {
                displayInningsOverTeamA(teamAInningsOver);
            }
        } else {
            displayInningsOverTeamA(teamAInningsOver);
        }
    }


    /**
     * Updates the Score to 6 when sixer is hit by team B
     *
     * @param view
     */

    public void updateScoreTo6ToTeamB(View view) {
        if (!matchOver) {
            scoreTeamB = scoreTeamB + 6;
            displayForTeamBAndFindWinner(scoreTeamB, wicketsTeamB);
        }
    }

    /**
     * Updates the Score to 4 when Boundary is hit by team B
     *
     * @param view
     */
    public void updateScoreTo4ToTeamB(View view) {
        if (!matchOver) {
            scoreTeamB = scoreTeamB + 4;
            displayForTeamBAndFindWinner(scoreTeamB, wicketsTeamB);
        }
    }

    /**
     * Updates the Score to 2 when two runs are hit by team B
     *
     * @param view
     */

    public void updateScoreTo2ToTeamB(View view) {
        if (!matchOver) {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamBAndFindWinner(scoreTeamB, wicketsTeamB);
        }
    }

    /**
     * Updates the Score to 1 when 1 run is hit by team B
     *
     * @param view
     */
    public void updateScoreTo1ToTeamB(View view) {
        if (!matchOver) {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamBAndFindWinner(scoreTeamB, wicketsTeamB);
        }
    }

    /**
     * Adds one wicket to Team B & also finds if a team is won
     *
     * @param view
     */
    public void aPlayerIsOutInTeamB(View view) {
        if (!matchOver) {
            wicketsTeamB = wicketsTeamB + 1;
            if (wicketsTeamB <= 10) {
                displayForTeamBAndFindWinner(scoreTeamB, wicketsTeamB);
                if (wicketsTeamB == 10) {
                    displayInningsOverTeamB(teamBInningsOver);
                    if (scoreTeamB < scoreTeamA) {
                        winningTeam = "Team A";
                        matchOver = true;
                        displayMatchResult(teamAIsWinner);
                    } else if (scoreTeamB == scoreTeamA) {
                        winningTeam = "Team A & B";
                        matchOver = true;
                        displayMatchResult(drawMatch);
                    }
                }
            } else {
                displayInningsOverTeamB(teamBInningsOver);
            }
        }
    }

    /**
     * Displays Score for Team B & decide
     *
     * @param score
     */
    public void displayForTeamBAndFindWinner(int score, int wickets) {
        if (!matchOver) {
            teamAInningsOverFlag = true;
            displayInningsOverTeamA(teamAInningsOver);
            if (wicketsTeamB <= 10) {
                if (scoreTeamB < scoreTeamA) {
                    TextView scoreView = (TextView) findViewById(R.id.team_b_score);
                    scoreView.setText(String.valueOf(score) + " For " + String.valueOf(wickets));
                } else if (scoreTeamB > scoreTeamA) {
                    TextView scoreView = (TextView) findViewById(R.id.team_b_score);
                    scoreView.setText(String.valueOf(score) + " For " + String.valueOf(wickets));
                    winningTeam = "Team B";
                    matchOver = true;
                    displayMatchResult(teamBIsWinner);
                } else if (scoreTeamB == scoreTeamA) {
                    TextView scoreView = (TextView) findViewById(R.id.team_b_score);
                    scoreView.setText(String.valueOf(score) + " For " + String.valueOf(wickets));
                }
            } else {
                displayInningsOverTeamB(teamBInningsOver);
                if (scoreTeamB > scoreTeamA) {
                    winningTeam = "Team B";
                    matchOver = true;
                    displayMatchResult(teamBIsWinner);
                } else if (scoreTeamB < scoreTeamA) {
                    winningTeam = "Team A";
                    displayMatchResult(teamAIsWinner);
                    matchOver = true;
                } else if (scoreTeamB == scoreTeamA) {
                    matchOver = true;
                    winningTeam = "Draw";
                    displayMatchResult(drawMatch);
                }
            }
        }
    }

    /**
     * Displays the match Result
     *
     * @param message
     */
    public void displayMatchResult(String message) {
        TextView inningsOverTeamB = (TextView) findViewById(R.id.match_result);
        inningsOverTeamB.setText(message);
    }

    /**
     * Displays the message to team b as innings over when this function is called.
     *
     * @param message
     */
    public void displayInningsOverTeamB(String message) {
        TextView inningsOverTeamB = (TextView) findViewById(R.id.innings_over_team_b);
        inningsOverTeamB.setText(message);
    }

    /**
     * Resets the score of both Team A & Team B and resets the match Result
     *
     * @param view
     */
    public void resetTheScoresAndResult(View view) {
        scoreTeamB = 0;
        wicketsTeamB = 0;
        scoreTeamA = 0;
        wicketsTeamA = 0;
        matchOver = false;
        teamAInningsOverFlag = false;
        winningTeam = null;
        displayInningsOverTeamA("");
        displayInningsOverTeamB("");
        displayForTeamA(scoreTeamA, wicketsTeamA);
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB) + " For " + String.valueOf(wicketsTeamB));
        displayMatchResult("");
    }
}
