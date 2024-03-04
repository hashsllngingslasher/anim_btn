package com.example.mobiledev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGenerate;
    TextView tvAnswer, tvMain;
    int numAnswer, getNumAnswer;
    LottieAnimationView lottieSun, lottieFire, lottieFun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        lottieSun.setAnimation(R.raw.sunshine);
        lottieFire.setAnimation(R.raw.animation_fire);
        lottieFun.setAnimation(R.raw.fun_time);

        btnGenerate.setOnClickListener(v -> {
            Random random = new Random();
            getNumAnswer = random.nextInt(100);
            numAnswer = getNumAnswer;

            if ((numAnswer != 0)) {
                tvAnswer.setText(String.valueOf(numAnswer) + " %");
                printAnswer();
                btnGenerate.setVisibility(View.VISIBLE);

            } else {
                Toast.makeText(MainActivity.this, "Нажмите ещё один раз", Toast.LENGTH_SHORT).show();
                btnGenerate.setVisibility(View.VISIBLE);
            }
        });
    }

    private void printAnswer() {
        if (numAnswer >= 1 && numAnswer <= 48) {
            hideAnimation();
            tvMain.setText("Не грустии(((");
            lottieSun.setVisibility(View.VISIBLE);

        } else if (numAnswer >= 48 && numAnswer <= 65) {
            hideAnimation();
            tvMain.setText("Хехей все круто!!");
            lottieFun.setVisibility(View.VISIBLE);

        } else if (numAnswer >= 65 && numAnswer <= 100) {
            hideAnimation();
            tvMain.setText("Супер кайф");
            lottieFire.setVisibility(View.VISIBLE);
        }
    }

    private void init() {
        btnGenerate = findViewById(R.id.btn_generate);
        tvAnswer = findViewById(R.id.txt_procent);
        tvMain = findViewById(R.id.txt_main);

        lottieFire = findViewById(R.id.lottie_one);
        lottieSun = findViewById(R.id.lottie_sun);
        lottieFun = findViewById(R.id.lottie_two);
    }

    private void hideAnimation() {
        lottieSun.setVisibility(View.INVISIBLE);
        lottieFun.setVisibility(View.INVISIBLE);
        lottieFire.setVisibility(View.INVISIBLE);
    }
}