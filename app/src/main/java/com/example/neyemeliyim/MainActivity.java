package com.example.neyemeliyim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ImageView menemen;
    private TextView tv_neyemeliyim;
    private Button btn_tikla;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menemen = findViewById(R.id.menemen);
        tv_neyemeliyim = findViewById(R.id.tv_neyemeliyim);
        btn_tikla = findViewById(R.id.btn_tikla);


        btn_tikla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NeYemeliyimAnaSayfa.class));
            }
        });








    }
}