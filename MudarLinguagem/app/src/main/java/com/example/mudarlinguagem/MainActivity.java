package com.example.mudarlinguagem;

import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics; // caracteristicas da tela
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale; //local de cada lingua e cada lingua, contem seu código


public class MainActivity extends AppCompatActivity {
    Button portugues, ingles, espanhol;
    TextView textoJava; // Texto antes de atualizar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        portugues = findViewById(R.id.portugues);
        ingles = findViewById(R.id.ingles);
        espanhol = findViewById(R.id.espanhol);
        textoJava = findViewById(R.id.textoJava);

        portugues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarLinguagem("pt");
            }
        });
        ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarLinguagem("en");
            }
        });
        espanhol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarLinguagem("es");
            }
        });
    }
    public void mudarLinguagem(String codigo){ // nome da string pra chamar "codigo"
        Resources res = getResources(); // os recursos
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration(); // configuração dos recursos
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) { // verifica a versao do android com o sdk
            conf.setLocale(new Locale(codigo.toLowerCase()));
        }else {
            conf.locale = new Locale(codigo.toLowerCase());
        }

        res.updateConfiguration(conf, dm);
        textoJava.setText(getResources().getString(R.string.linguagemAlterada)); // ele chama a strings

        finish();
        startActivity(getIntent());// inicia com outra linguagem
    }
}
