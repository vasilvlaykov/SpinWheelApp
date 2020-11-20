package com.example.yourturn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView spinWheel;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinWheel = findViewById(R.id.spinWheel);

        Button spin = findViewById(R.id.buttonSpin);

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!spinning) {
                    int newDir = random.nextInt(3600);
                    float pivotX = spinWheel.getPivotX();
                    float pivotY = spinWheel.getPivotY();

                    Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
                    rotate.setDuration(5500);
                    rotate.setFillAfter(true);
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinning = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spinning = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    lastDir = newDir;
                    spinWheel.startAnimation(rotate);
                }
            }
        });
    }
}