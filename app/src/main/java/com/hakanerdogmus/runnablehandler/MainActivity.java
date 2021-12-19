package com.hakanerdogmus.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView gosterge ;
    Handler handler;
    Runnable runnable;
    int number;
    Button baslat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gosterge=findViewById(R.id.gosterge);
        number = 0;
        baslat = findViewById(R.id.baslat);

    }

    public void baslat(View view){

        handler=new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                gosterge.setText("Time: " + number);
                number++;
                gosterge.setText("Time: "+ number);
                handler.postDelayed(runnable,1000); //baslat butonuna basıldığında 1sn arayla saymaya başlıyor.

            }
        };
        handler.post(runnable);
        baslat.setEnabled(false); //butona tekrar basılmasını engeller. butona tekrar basamayız.

    }

    public void durdur(View view){
        baslat.setEnabled(true);  //butonu tekrar aktif hale getirdik.

        handler.removeCallbacks(runnable); //sayma işlemini durdurduk.
        number=0;
        gosterge.setText("Time: " + number);

    }
}