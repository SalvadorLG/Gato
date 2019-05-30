package com.example.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_ok,btn_x,btn_o;
    private EditText num_juegos;
    int player=0;
    boolean bandera=false;
    int jugador1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ok = (ImageButton) findViewById(R.id.btn_ok);
        btn_x = (ImageButton) findViewById(R.id.btn_x);
        btn_o = (ImageButton) findViewById(R.id.btn_o);
        num_juegos = (EditText) findViewById(R.id.num_juegos);


        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=10;
                jugador1 = 1;
                bandera=true;
                Toast toast1 = Toast.makeText(getApplicationContext(),"jugador 1 inicia con X", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
        btn_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=20;
                jugador1 = 1;
                bandera=true;
                Toast toast1 = Toast.makeText(getApplicationContext(),"jugador 1 inicia con O", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bandera == true){
                    if(!String.valueOf(num_juegos.getText()).equals("") || !String.valueOf(num_juegos.getText()).equals("0")) {
                        Intent SegActivity = new Intent(MainActivity.this, ActivityJuego.class);
                        SegActivity.putExtra("var", 4);
                        SegActivity.putExtra("jugador", player);
                        SegActivity.putExtra("jugadas", String.valueOf(num_juegos.getText()));
                        SegActivity.putExtra("j",jugador1);
                        startActivity(SegActivity);
                    }
                    else{
                        Toast toast1 = Toast.makeText(getApplicationContext(),"Campo vacio", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Elije una opcion", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
    }
}
