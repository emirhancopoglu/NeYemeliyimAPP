package com.example.neyemeliyim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.SharedValues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NeYemeliyimAnaSayfa3 extends NeYemeliyimAnaSayfa2 {

    public TextView tv_sonucyazisi, tv_sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_yemeliyim_ana_sayfa3);

        tv_sonucyazisi = findViewById(R.id.tv_sonucyazisi);
        tv_sonuc = findViewById(R.id.tv_sonuc);


        Intent intent = getIntent();
        if (intent != null)
        {
            double boy = intent.getDoubleExtra("boy",0.0);
            double kilo = intent.getDoubleExtra("kilo" , 0.0);
            double yas = intent.getDoubleExtra("yas",0.0);
            String cinsiyet = intent.getStringExtra("Cinsiyet");
            String egzersizDurumu = intent.getStringExtra("egzersizDurumu");
            String kiloHedefi = intent.getStringExtra("KiloHedefi");
            double erkekise = intent.getDoubleExtra("erkekise", 0.0);
            double kadinise = intent.getDoubleExtra("kadinise", 0.0);





            String sonucc = intent.getStringExtra("sonuc");

            tv_sonuc.setText(sonucc);
        }



    }
}