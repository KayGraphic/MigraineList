package com.example.android.migrainelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;


    //  Define the Views

    private EditText et_editText;

    private RadioButton rb_sensitiveYes;
    private RadioButton rb_painYes;

    private CheckBox cb_stabbing;
    private CheckBox cb_throbbing;
    private CheckBox cb_inter;
    private CheckBox cb_dull;

    private RadioButton rb_headpullYes;

    private CheckBox cb_standing;
    private CheckBox cb_coughing;
    private CheckBox cb_shakin;

    private RadioButton rb_nauseatedYes;

    private RadioButton rb_q8_a_view;
    private RadioButton rb_q8_b_view;
    private RadioButton rb_q8_c_view;
    private RadioButton rb_q8_d_view;


    //declare global Variables, assigning views
    private void assignFindViews() {

        et_editText = findViewById(R.id.et_editText);
        rb_sensitiveYes = findViewById(R.id.yes_radio_button1);
        rb_painYes = findViewById(R.id.yes_radio_button3);
        cb_stabbing = findViewById(R.id.stabbing_checkBox);
        cb_throbbing = findViewById(R.id.throbbing_checkBox);
        cb_inter = findViewById(R.id.intermittent_checkBox);
        cb_dull = findViewById(R.id.dull_checkBox);
        rb_headpullYes = findViewById(R.id.yes_radio_button5);
        cb_standing = findViewById(R.id.standing_checkBox);
        cb_coughing = findViewById(R.id.coughing_checkBox);
        cb_shakin = findViewById(R.id.shakinghead_checkBox);
        rb_nauseatedYes = findViewById(R.id.yes_radio_button7);
        rb_q8_a_view = findViewById(R.id.rb_q8_a);
        rb_q8_b_view = findViewById(R.id.rb_q8_b);
        rb_q8_c_view = findViewById(R.id.rb_q8_c);
        rb_q8_d_view = findViewById(R.id.rb_q8_d);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignFindViews();

    }


    //The following is processed when the submit button is pressed on the app screen.
    public void submitQuiz(View view) {

        String value = et_editText.getText().toString();
        int desiredValue = Integer.parseInt(value);
        if (desiredValue <= 3) {
            score += 10;

        } else {
            score = 300;

        }


        //*** The next step answers question #3
        if (rb_sensitiveYes.isChecked()) {
            score = score + 10;
        }
        //*** The next step answers question #4

        if (rb_painYes.isChecked()) {
            score = score + 10;
        }
        //*** The next step answers question #5

        if (cb_stabbing.isChecked() && cb_throbbing.isChecked() && !cb_dull.isChecked() && !cb_inter.isChecked()) {
            score = score + 20;
        } else {
            score += 5;
        }
        //*** The next step answers question #6
        if (rb_headpullYes.isChecked()) {
            score += 10;
        }
        if (cb_standing.isChecked() && cb_coughing.isChecked()) {
            score += 10;
        } else if (cb_coughing.isChecked() || cb_standing.isChecked() ||cb_shakin.isChecked()) {
            score += 5;
        }
        //*** The next step answers question #7
        if (rb_nauseatedYes.isChecked()) {
            score += 10;
        }

        //*** The next step answers question #8
        if (rb_q8_c_view.isChecked() || rb_q8_d_view.isChecked()) {
            score += 2;
        } else if (rb_q8_a_view.isChecked() || (rb_q8_b_view.isChecked())) {
            score += 10;
        }


        //This next step calls  scoreToastMessage
        scoreToastMessage(score);

    }


    // This calculates the score and interprets it in a Toast message
    private void scoreToastMessage(int score) {
        if (score >= 0 && score <= 20) {
            //show a message for a score up to 20
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_1_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();


        } else if (score >= 20 && score <= 50) {
            //show a message for a score >= 20 and <= 50
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_2_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        } else if (score >= 50 && score <= 70) {
            //show a message for a score of greater than or equal to 50 and less than or equal to 70
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_3_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();
        } else if (score >= 70 && score <= 100) {
            //show a message for a score of greater than or equal to 50 and less than or equal to 70
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_4_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        } else {
            //show a message for a score greater than 100
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_5_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        }
    }
}
