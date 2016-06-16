package com.example.carthy.maths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Addition extends AppCompatActivity {
    private String equation;
    private int bnRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        init();
    }

    public void init(){
        Random random = new Random();
        int resultat = random.nextInt(100) + 1;
        int nb;

        while(premier(resultat)){
            resultat = random.nextInt(100) + 1;
        }

        if(resultat > 20){
            nb = 3;
        }else{
            nb = random.nextInt(3) + 1;
        }

        equation = addition(nb, resultat) + " =  ?";

        TextView txt = (TextView) findViewById(R.id.equation);
        txt.setText(equation);
        changeButton(resultat);
    }

    public void changeButton(int resultat){
        unclock();
        reset();
        Random random = new Random();
        bnRep = random.nextInt(3) + 1;

        if(bnRep == 1){
            Button button = (Button) findViewById(R.id.answers1);
            button.setText(resultat + "");
            button = (Button) findViewById(R.id.answers2);
            button.setText((resultat + random()) + "");
            button = (Button) findViewById(R.id.answers3);
            button.setText((resultat - random()) + "");
        }else if(bnRep == 2){
            Button button = (Button) findViewById(R.id.answers2);
            button.setText(resultat + "");
            button = (Button) findViewById(R.id.answers1);
            button.setText((resultat - random()) + "");
            button = (Button) findViewById(R.id.answers3);
            button.setText((resultat + random()) + "");
        }else if(bnRep == 3){
            Button button = (Button) findViewById(R.id.answers3);
            button.setText(resultat + "");
            button = (Button) findViewById(R.id.answers2);
            button.setText((resultat - random()) + "");
            button = (Button) findViewById(R.id.answers1);
            button.setText((resultat + random()) + "");
        }
    }

    public void exit(View view){
        finish();
    }

    public void answers1(View view){
        Button button = (Button) view;

        if(bnRep == 1){
            button.setBackgroundResource(R.drawable.green_button);
            final Button next2 = button;
            lock();
            next2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    init();
                }
            }, 2000);
        }else{
            button.setBackgroundResource(R.drawable.red_button);
            goodAns();
        }
    }

    public void answers2(View view){
        Button button = (Button) view;

        if(bnRep == 2){
            button.setBackgroundResource(R.drawable.green_button);
            final Button next2 = button;
            lock();
            next2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    init();
                }
            }, 2000);
        }else{
            button.setBackgroundResource(R.drawable.red_button);
            goodAns();
        }
    }

    public void answers3(View view){
        Button button = (Button) view;

        if(bnRep == 3){
            button.setBackgroundResource(R.drawable.green_button);
            final Button next2 = button;
            lock();
            next2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    init();
                }
            }, 2000);
        }else{
            button.setBackgroundResource(R.drawable.red_button);
            goodAns();
        }
    }

    public void reset(){
        Button button = (Button) findViewById(R.id.answers1);
        button.setBackgroundResource(R.drawable.white_button);
        button = (Button) findViewById(R.id.answers2);
        button.setBackgroundResource(R.drawable.white_button);
        button = (Button) findViewById(R.id.answers3);
        button.setBackgroundResource(R.drawable.white_button);
    }

    public void goodAns(){
        Button button;

        if(bnRep == 1){
            button = (Button) findViewById(R.id.answers1);
            button.setBackgroundResource(R.drawable.green_button);

        }else if(bnRep == 2){
            button = (Button) findViewById(R.id.answers2);
            button.setBackgroundResource(R.drawable.green_button);
        }else{
            button = (Button) findViewById(R.id.answers3);
            button.setBackgroundResource(R.drawable.green_button);
        }

        final Button next2 = button;
        lock();
        next2.postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }, 2000);
    }

    public void lock(){
        Button button = (Button) findViewById(R.id.answers1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.answers2);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.answers3);
        button.setEnabled(false);
    }

    public void unclock(){
        Button button = (Button) findViewById(R.id.answers1);
        button.setEnabled(true);
        button = (Button) findViewById(R.id.answers2);
        button.setEnabled(true);
        button = (Button) findViewById(R.id.answers3);
        button.setEnabled(true);
    }

    public String addition(int nb, int resultat){
        if(nb <= 0 || premier(resultat)){
            return resultat + "";
        }else {

            int temp = 0;
            Random random = new Random();

            while ((temp == 0) || (resultat - temp) <= 0) {
                temp = random.nextInt(20) + 1;
            }

            return addition(nb - 2, resultat - temp) + " + " + addition(nb - 2, temp);
        }
    }

    public boolean premier(int i){
        int temp = 0;

        if(i == 0 || i == 1){
            return true;
        }

        for(int j = i; j > 1; j--){
            if(i%j == 0){
                temp++;
            }
        }

        return (temp > 1) ? false : true;
    }

    public int random(){
        Random random = new Random();
        return (random.nextInt(2) + 1 > 1)? (random.nextInt(5) + 1) : -(random.nextInt(5) + 1);
    }
}
