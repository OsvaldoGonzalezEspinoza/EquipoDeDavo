package com.example.henrystivent.adivinalo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Leyenda extends AppCompatActivity {

    private EditText numero;
    private Button jugar, reiniciar, atras;
    private TextView mensaje, mensaje2, mensaje3;
    private int aleatorio;
    private int intento = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leyenda);

        numero = (EditText) findViewById(R.id.txtnumero);
        jugar = (Button) findViewById(R.id.btnjugar);
        reiniciar = (Button)findViewById(R.id.btnreiniciar);
        atras = (Button)findViewById(R.id.btnatras);
        mensaje = (TextView) findViewById(R.id.lblmensaje);
        mensaje2 = (TextView) findViewById(R.id.lblmensaje2);
        mensaje3 = (TextView) findViewById(R.id.lblmensaje3);
        reiniciar.setEnabled(false);

        aleatorio = crearAleatorio();

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nroUsuario;
                nroUsuario = Integer.parseInt(numero.getText().toString());
                if (nroUsuario < 0 || nroUsuario > 2000) {
                    mensaje.setText("Este no es un numero valido");
                } else if (aleatorio < nroUsuario) {
                    mensaje.setText("Ingrese un numero más bajo");
                } else {
                    mensaje.setText("Ingrese un numero más alto");
                }
                if (aleatorio == nroUsuario){
                    jugar.setEnabled(false);
                    reiniciar.setEnabled(true);
                    mensaje.setText("Felicitaciones Has Ganado!");
                    mensaje3.setText("El numero ganador es: " + aleatorio);
                }
                intento = intento - 1;
                mensaje2.setText("Intentos restantes: " + intento);

                if (intento == 0 && aleatorio != nroUsuario){
                    jugar.setEnabled(false);
                    reiniciar.setEnabled(true);
                    mensaje.setText("Perdiste!");
                    mensaje2.setText("");
                    mensaje3.setText("El numero ganador es: " + aleatorio);
                }


             }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = 5;
                aleatorio = crearAleatorio();
                jugar.setEnabled(true);
                reiniciar.setEnabled(false);
                numero.setText("");
                mensaje.setText("");
                mensaje2.setText("");
                mensaje3.setText("");
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Leyenda.this, Principal.class);
                startActivity(intento);
            }
        });
    }

    private int crearAleatorio() {

        return (int)(Math.random()*2000+1);
    }
}
