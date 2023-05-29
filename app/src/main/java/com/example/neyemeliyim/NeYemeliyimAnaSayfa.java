package com.example.neyemeliyim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NeYemeliyimAnaSayfa extends AppCompatActivity {

    public EditText et_boy , et_kilo , et_yas;
    public RadioButton rb_erkek,rb_kadın;
    public Button btn_next;
    public RadioGroup radioGroupCinsiyet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_yemeliyim_ana_sayfa);

        et_boy = findViewById(R.id.et_boy);
        et_kilo = findViewById(R.id.et_kilo);
        et_yas = findViewById(R.id.et_yas);
        rb_erkek = findViewById(R.id.rb_erkek);
        rb_kadın = findViewById(R.id.rb_kadın);
        btn_next = findViewById(R.id.btn_next);
        radioGroupCinsiyet = findViewById(R.id.radioGroupCinsiyet);




        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Erkekler için (bmr) = 66 + (13,7 x kg cinsinden ağırlık ) + (5 x cm cinsinden boy) – (6,8 yıl cinsinden yaş)
                //Kadınlar için (bmr) = 655 + (9,6 x kg cinsinden ağırlık ) + (1,8 x cm cinsinden boy) – (4,7 x yıl cinsinden yaş)


                double boy = Double.parseDouble(et_boy.getText().toString());
                double kilo = Double.parseDouble(et_kilo.getText().toString());
                double yas = Double.parseDouble(et_yas.getText().toString());



                int secilmisRadioButtonId = radioGroupCinsiyet.getCheckedRadioButtonId();




                    Intent intent = new Intent(NeYemeliyimAnaSayfa.this, NeYemeliyimAnaSayfa2.class);

                    if(rb_erkek.isChecked())
                    {
                        double erkekbmr = 66.5 + (13.75 * kilo) + (5.03 * boy) - (6.75 * yas);
                        intent.putExtra("erkekise", erkekbmr);

                    }
                    else
                    {
                        double kadinbmr = 665.1 + (9.56 * kilo) + (1.85 * boy) - (4.68 * yas);
                        intent.putExtra("kadinise",kadinbmr);
                    }


                    intent.putExtra("boy", boy);
                    intent.putExtra("kilo", kilo);
                    intent.putExtra("yas", yas);
                    if(rb_erkek.isChecked())
                    {
                        intent.putExtra("rb_erkek" , "erkek");
                    }
                    if(rb_kadın.isChecked())
                    {
                        intent.putExtra("rb_kadin", "kadın");
                    }


                if (rb_erkek.isChecked()) {
                    intent.putExtra("cinsiyet", "Erkek");
                } else {
                    intent.putExtra("cinsiyet", "Kadın");
                }



                    startActivity(intent);


            }
        });



    }
}