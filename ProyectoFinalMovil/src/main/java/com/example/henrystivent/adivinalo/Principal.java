package com.example.henrystivent.adivinalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private Button facil, normal, dificil, leyenda, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        facil = (Button) findViewById(R.id.btn1);
        normal = (Button) findViewById(R.id.btn2);
        dificil = (Button) findViewById(R.id.btn3);
        leyenda = (Button) findViewById(R.id.btn4);
        salir = (Button) findViewById(R.id.btnsalir);

        facil.setOnClickListener(this);
        normal.setOnClickListener(this);
        dificil.setOnClickListener(this);
        leyenda.setOnClickListener(this);
        salir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                Intent intent1 = new Intent(Principal.this, Facil.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(Principal.this, Normal.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(Principal.this, Dificil.class);
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(Principal.this, Leyenda.class);
                startActivity(intent4);
                break;
            case R.id.btnsalir:
                Intent intsalir = new Intent(Intent.ACTION_MAIN);
                intsalir.addCategory(Intent.CATEGORY_HOME);
                intsalir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intsalir);
                break;
        }
    }
}
