package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView status;
    private TextView score;
    private final int randomNumberMax = 100;
    private int numScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLeft = (Button)findViewById(R.id.leftNumber);
        buttonRight = (Button)findViewById(R.id.rightNumber);
        status = (TextView)findViewById(R.id.status);
        score = (TextView)findViewById(R.id.score);
        numScore = 0;
        setNumbers();
        score.setText("SCORE: " + numScore);
        status.setText("");
    }

    public void onClick(View view) {
        int button = 1;
        if(view.getId() == buttonRight.getId()) {
            button = 2;
        }
        updateScore(button);
        setNumbers();
    }

    private void setNumbers() {
        buttonLeft.setText(randomGen(randomNumberMax)+"");
        buttonRight.setText(randomGen(randomNumberMax)+"");
    }

    private void updateScore(int button) {
        Integer num1 = Integer.parseInt(buttonLeft.getText().toString());
        Integer num2 = Integer.parseInt(buttonRight.getText().toString());
        int res = num1.compareTo(num2);
        if(button == 2) res = res*(-1);
        numScore += res;
        score.setText("SCORE: "+numScore);
        switch(res) {
            case 0:
                status.setText("equal no score given");
                break;
            case 1:
                status.setText("BRAVOO!! +1 social credits");
                break;
            case -1:
                status.setText("WRONG!! -1 social credits");
                break;
            default:
                status.setText("");
                break;
        }
    }

    private int randomGen(int max) {
        Random rand = new Random();
        int n = rand.nextInt(max);
        return n;
    }
}