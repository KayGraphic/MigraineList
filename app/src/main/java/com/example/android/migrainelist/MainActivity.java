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
   // private RadioButton rb_sensitiveNo;
    private RadioButton rb_painYes;
   // private RadioButton rb_painNo;

    private CheckBox cb_stabbing;
    private CheckBox cb_throbbing;
    private CheckBox cb_inter;
    private CheckBox cb_dull;

    private RadioButton rb_headpullYes;
    private RadioButton rb_headpullNo;

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
        //rb_sensitiveNo = findViewById(R.id.no_radio_button1);
        rb_painYes = findViewById(R.id.yes_radio_button3);
      //  rb_painNo = findViewById(R.id.no_radio_button3);
        cb_stabbing = findViewById(R.id.stabbing_checkBox);
        cb_throbbing = findViewById(R.id.throbbing_checkBox);
        cb_inter = findViewById(R.id.intermittent_checkBox);
        cb_dull = findViewById(R.id.dull_checkBox);
        rb_headpullYes = findViewById(R.id.yes_radio_button5);
        rb_headpullNo = findViewById(R.id.no_radio_button5);
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
        }

        if (rb_headpullYes.isChecked()) {
            score = score + 10;
        }

        //*** The next step answers question #7
        if (cb_standing.isChecked() && cb_coughing.isChecked()) {
            score += 10;
        } else if (cb_coughing.isChecked() || cb_standing.isChecked() ||cb_shakin.isChecked()) {
            score += 5;
        }
        //*** The next step answers question #8
        if (rb_nauseatedYes.isChecked()) {
            score += 10;
        }

        //*** The next step answers question #9
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
        if (score >= 1 && score <= 20) {
            //show a message for a score up to 20
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_1_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();


        } else if (score >= 21 && score <= 50) {
            //show a message for a score >= 20 and <= 50
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_2_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        } else if (score >= 51 && score <= 70) {
            //show a message for a score of greater than or equal to 50 and less than or equal to 70
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_3_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();
        } else if (score >= 71 && score <= 100) {
            //show a message for a score of greater than or equal to 50 and less than or equal to 70
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_4_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        } else {
            //show a message for a score greater than 100
            Toast scoreMessage = Toast.makeText(getApplicationContext(), "" + getString(R.string.level_5_message) + "" + score, Toast.LENGTH_LONG);
            scoreMessage.show();

        }
    }
    public void clearAnswer(View view){
        score = 0;
        et_editText.getText().clear();
        rb_sensitiveYes.setChecked(false);
        //rb_sensitiveNo.setChecked(false);
        rb_painYes.setChecked(false);
        //rb_painNo.setChecked(false);
        cb_stabbing.setChecked(false);
        cb_throbbing.setChecked(false);
        cb_inter.setChecked(false);
        cb_dull.setChecked(false);
        rb_headpullYes.setChecked(false);
        rb_headpullNo.setChecked(false);
        cb_standing.setChecked(false);
        cb_coughing.setChecked(false);
        cb_shakin.setChecked(false);
      rb_nauseatedYes.setChecked(false);
        rb_q8_a_view.setChecked(false);
        rb_q8_b_view.setChecked(false);
        rb_q8_c_view.setChecked(false);
        rb_q8_d_view.setChecked(false);
    }
}
