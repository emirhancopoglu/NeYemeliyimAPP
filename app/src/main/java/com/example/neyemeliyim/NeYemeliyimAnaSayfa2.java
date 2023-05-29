package com.example.neyemeliyim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class NeYemeliyimAnaSayfa2 extends AppCompatActivity {


    public TextView tv_egzrutin , tv_kalorihesap ;
    public RadioButton rb_cokegzersiz, rb_ortaegzersiz, rb_azegzersiz, rb_kiloal , rb_kilover , rb_kiloayni;
    public Button btn_hesapla;

    public RadioGroup radioGroupKiloHedefi , radioGroupEgzersiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_yemeliyim_ana_sayfa2);

        tv_egzrutin = findViewById(R.id.tv_egzrutin);
        tv_kalorihesap = findViewById(R.id.tv_kalorihedef);
        rb_cokegzersiz = findViewById(R.id.rb_cokegzersiz);
        rb_ortaegzersiz = findViewById(R.id.rb_ortaegzersiz);
        rb_azegzersiz = findViewById(R.id.rb_azegzersiz);
        rb_kiloal = findViewById(R.id.rb_kiloal);
        rb_kilover = findViewById(R.id.rb_kilover);
        rb_kiloayni = findViewById(R.id.rb_kiloayni);
        btn_hesapla = findViewById(R.id.btn_hesapla);
        radioGroupEgzersiz = findViewById(R.id.radioGroupEgzersiz);
        radioGroupKiloHedefi = findViewById(R.id.radioGroupKiloHedefi);






        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int secilmisEgzersizId = radioGroupEgzersiz.getCheckedRadioButtonId();
                int secilmisKiloHedefiId = radioGroupKiloHedefi.getCheckedRadioButtonId();

                Intent intentt = getIntent();


                double boy = intentt.getDoubleExtra("boy",0.0);
                double kilo = intentt.getDoubleExtra("kilo", 0);
                double yas = intentt.getDoubleExtra("yas",0);
                double erkekise = intentt.getDoubleExtra("erkekise", 0);
                double kadinise = intentt.getDoubleExtra("kadinise", 0);
                int radioGroupCinsiyet = intentt.getIntExtra("radioGroupCinsiyet",0 );






                String cinsiyet = intentt.getStringExtra("cinsiyet");
                Intent intent = new Intent(NeYemeliyimAnaSayfa2.this, NeYemeliyimAnaSayfa3.class);




                if (cinsiyet.equals("Erkek"))
                {
                    // Erkek için olan sonuçları yazdır
                    String sonuc = "Boy: " + boy + "\nKilo: " + kilo + "\nYaş: " + yas + "\nCinsiyet: "
                            + cinsiyet  +"\nBazal Metabolizma Hızın: " + erkekise;
                    intent.putExtra("sonuc" , sonuc);
                    // Diğer verileri de alabilirsiniz
                } else if (cinsiyet.equals("Kadın"))
                {
                    // Kadın için olan sonucu yazdır
                    String sonuc = "Boy: " + boy + "\nKilo: " + kilo + "\nYaş: " + yas + "\nCinsiyet: "
                            + cinsiyet  +"\nBazal Metabolizma Hızın: " + kadinise;
                    intent.putExtra("sonuc" , sonuc);
                    // Diğer verileri de alabilirsiniz
                }




                double erkeksonuc = 0;
                double erkekkilo = 0;
                String emesaj = "";
                if(cinsiyet.equals("Erkek"))
                {

                    if(rb_cokegzersiz.isChecked())
                    {
                        double cokegzersize = erkekise * 1.725;
                        erkeksonuc = cokegzersize;
                    }
                    else if (rb_ortaegzersiz.isChecked())
                    {
                        double ortaegzersize = erkekise * 1.55;
                        erkeksonuc = ortaegzersize;
                    }
                    else if (rb_azegzersiz.isChecked())
                    {
                        double azegersize = erkekise * 1.375;
                        erkeksonuc = azegersize;
                    }
                    if(rb_kiloal.isChecked())
                    {
                        erkekkilo = erkeksonuc;
                        erkekkilo += 500;
                        emesaj = "\nKilo Almak İçin: ";
                    }
                    else if (rb_kilover.isChecked())
                    {
                     erkekkilo = erkeksonuc;
                     erkekkilo -= 500;
                     emesaj = "\nKilo Vermek İçin: ";
                    }
                    else if (rb_kiloayni.isChecked())
                    {
                     erkekkilo =erkeksonuc;
                     emesaj = "\nKilonuzu Korumak İçin: ";
                    }


                    String sonuc = "Boy: " + boy + "\nKilo: " + kilo + "\nYaş: " + yas + "\nCinsiyet: "
                            + cinsiyet  +"\nBazal Metabolizma Hızın: " + erkekise + "\nGünlük enerji ihtiyacınız:" + erkeksonuc + emesaj + erkekkilo;
                    intent.putExtra("sonuc" , sonuc);
                }


                double kadinsonuc = 0;
                double kadinkilo = 0;
                String mesaj = "";
                if(cinsiyet.equals("Kadın"))
                {

                    
                    if(rb_cokegzersiz.isChecked())
                    {
                        double cokegzersizk = kadinise * 1.725;
                        kadinsonuc = cokegzersizk;
                    } 
                    else if (rb_ortaegzersiz.isChecked())
                    {
                        double ortaegzersizk = kadinise * 1.55;
                        kadinsonuc = ortaegzersizk;
                    }
                    else if (rb_azegzersiz.isChecked())
                    {
                        double azegzersizk = kadinise * 1.375;
                        kadinsonuc = azegzersizk;
                    }

                    if(rb_kiloal.isChecked())
                    {
                        kadinkilo = kadinsonuc;
                        kadinkilo += 500;
                        mesaj = "\nKilo Almak İçin: ";
                    }
                    else if (rb_kilover.isChecked())
                    {
                        kadinkilo = kadinsonuc;
                        kadinkilo -= 500;
                        mesaj = "\nKilo Vermek İçin: ";
                    }
                    else if (rb_kiloayni.isChecked())
                    {
                        kadinkilo = kadinsonuc;
                        mesaj ="\nKilonuzu Korumak İçin: ";
                    }


                    String sonuc = "Boy: " + boy + "\nKilo: " + kilo + "\nYaş: " + yas + "\nCinsiyet: "
                            + cinsiyet  +"\nBazal Metabolizma Hızın : " + kadinise + "\nGünlük Enerji İhtiyacınız: " + kadinsonuc +   mesaj + kadinkilo ;
                    intent.putExtra("sonuc" , sonuc);
                }










                startActivity(intent);








            }
        });



    }
}