package com.example.gato;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class ActivityJuego extends AppCompatActivity {
    int turno=0, ju, jugadore, contGanados1=0,contGanados2=0,matriz[][] = new int[3][3];
    Bundle datos;
    int contVeces=9,numerodejuegos;
    ImageButton pos_0,pos_1,pos_2,pos_3,pos_4,pos_5,pos_6,pos_7,pos_8;
    String jugandonum="";
    private TextView score1,score2;
    String plr;
    boolean ganando = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        pos_0 = (ImageButton) findViewById(R.id.pos_0);
        pos_1 = (ImageButton) findViewById(R.id.pos_1);
        pos_2 = (ImageButton) findViewById(R.id.pos_2);
        pos_3 = (ImageButton) findViewById(R.id.pos_3);
        pos_4 = (ImageButton) findViewById(R.id.pos_4);
        pos_5 = (ImageButton) findViewById(R.id.pos_5);
        pos_6 = (ImageButton) findViewById(R.id.pos_6);
        pos_7 = (ImageButton) findViewById(R.id.pos_7);
        pos_8 = (ImageButton) findViewById(R.id.pos_8);
        score1 = (TextView) findViewById(R.id.score_1);
        score2 = (TextView) findViewById(R.id.score_2);
        datos = this.getIntent().getExtras();
        jugadore = datos.getInt("jugador");
        numerodejuegos = Integer.parseInt(datos.getString("jugadas"));
        ju = datos.getInt("j");
        RestaurarMatriz();
    }

    public void reiniciarTablero(){
        pos_0.setImageResource(R.drawable.fondotablero);
        pos_0.setTag("R.drawable.fondotablero");
        pos_1.setImageResource(R.drawable.fondotablero);
        pos_1.setTag("R.drawable.fondotablero");
        pos_2.setImageResource(R.drawable.fondotablero);
        pos_2.setTag("R.drawable.fondotablero");
        pos_3.setImageResource(R.drawable.fondotablero);
        pos_3.setTag("R.drawable.fondotablero");
        pos_4.setImageResource(R.drawable.fondotablero);
        pos_4.setTag("R.drawable.fondotablero");
        pos_5.setImageResource(R.drawable.fondotablero);
        pos_5.setTag("R.drawable.fondotablero");
        pos_6.setImageResource(R.drawable.fondotablero);
        pos_6.setTag("R.drawable.fondotablero");
        pos_7.setImageResource(R.drawable.fondotablero);
        pos_7.setTag("R.drawable.fondotablero");
        pos_8.setImageResource(R.drawable.fondotablero);
        pos_8.setTag("R.drawable.fondotablero");
    }

    public void Presionar(View view){
        contVeces--;
        ImageButton aux = findViewById(view.getId());
        Log.d("1",aux.getTag().toString());
        if(String.valueOf(aux.getTag()).equals("R.drawable.fondotablero")){

            if(jugadore==10){
                if(ju==1){
                     plr = " 1 ";
                    ju=2;
                }else{
                     plr = " 2 ";
                    ju=1;
                }
                aux.setImageResource(R.drawable.imagen_dex);
                aux.setTag("R.drawable.imagen_dex");
                switch(view.getId()){
                    case R.id.pos_0:
                        matriz[0][0] = 1;
                        break;
                    case R.id.pos_1:
                        matriz[0][1] = 1;
                        break;
                    case R.id.pos_2:
                        matriz[0][2] = 1;
                        break;
                    case R.id.pos_3:
                        matriz[1][0] = 1;
                        break;
                    case R.id.pos_4:
                        matriz[1][1] = 1;
                        break;
                    case R.id.pos_5:
                        matriz[1][2] = 1;
                        break;
                    case R.id.pos_6:
                        matriz[2][0] = 1;
                        break;
                    case R.id.pos_7:
                        matriz[2][1] = 1;
                        break;
                    case R.id.pos_8:
                        matriz[2][2] = 1;
                        break;
                }

                if(matriz[0][0] == 1 && matriz[0][1] == 1 && matriz[0][2] == 1) {
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();

                        }
                }, 3000);
                    ju=1;
                    contVeces=9;
                jugadore=10;
                }else
                if(matriz[1][0] == 1 && matriz[1][1] == 1 && matriz[1][2] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(contGanados1);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[2][0] == 1 && matriz[2][1] == 1 && matriz[2][2] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[0][0] == 1 && matriz[1][0] == 1 && matriz[2][0] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[0][1] == 1 && matriz[1][1] == 1 && matriz[2][1] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[0][2] == 1 && matriz[1][2] == 1 && matriz[2][2] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[0][0] == 1 && matriz[1][1] == 1 && matriz[2][2] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else
                if(matriz[0][2] == 1 && matriz[1][1] == 1 && matriz[2][0] == 1){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados1++;
                    score1.setText(String.valueOf(contGanados1));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else if(contVeces==0){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Empate", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=10;
                }else{
                    jugadore=20;
                }
            }else
            if(jugadore==20){

                if(ju==1){ plr = " 1 ";
                    ju=2;
                }else{
                     plr = " 2 ";
                    ju=1;
                }
                aux.setImageResource(R.drawable.imagen_dey);
                aux.setTag(R.drawable.imagen_dey);
                switch(view.getId()){
                    case R.id.pos_0:
                        matriz[0][0] = 2;
                        break;
                    case R.id.pos_1:
                        matriz[0][1] = 2;
                        break;
                    case R.id.pos_2:
                        matriz[0][2] = 2;
                        break;
                    case R.id.pos_3:
                        matriz[1][0] = 2;
                        break;
                    case R.id.pos_4:
                        matriz[1][1] = 2;
                        break;
                    case R.id.pos_5:
                        matriz[1][2] = 2;
                        break;
                    case R.id.pos_6:
                        matriz[2][0] = 2;
                        break;
                    case R.id.pos_7:
                        matriz[2][1] = 2;
                        break;
                    case R.id.pos_8:
                        matriz[2][2] = 2;
                        break;
                }

                if(matriz[0][0] == 2 && matriz[0][1] == 2 && matriz[0][2] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[1][0] == 2 && matriz[1][1] == 2 && matriz[1][2] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[2][0] == 2 && matriz[2][1] == 2 && matriz[2][2] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[0][0] == 2 && matriz[1][0] == 2 && matriz[2][0] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[0][1] == 2 && matriz[1][1] == 2 && matriz[2][1] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[0][2] == 2 && matriz[1][2] == 2 && matriz[2][2] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[0][0] == 2 && matriz[1][1] == 2 && matriz[2][2] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else
                if(matriz[0][2] == 2 && matriz[1][1] == 2 && matriz[2][0] == 2){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    contGanados2++;
                    score2.setText(String.valueOf(contGanados2));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else if(contVeces==0){
                    Toast ganador = Toast.makeText(getApplicationContext(),"Empate", Toast.LENGTH_SHORT);
                    ganador.show();
                    RestaurarMatriz();
                    numerodejuegos--;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override public void run() {
                            reiniciarTablero();
                        }
                    }, 3000);
                    ju=1;
                    contVeces=9;
                    jugadore=20;
                }else {
                jugadore=10;
                }
            }
        }
        if(numerodejuegos==0){
            if(contGanados1 > contGanados2){
                Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado la partida", Toast.LENGTH_SHORT);
                ganador.show();
            }else if(contGanados2 > contGanados1){
                Toast ganador = Toast.makeText(getApplicationContext(),"Jugador"+plr+"a ganado la partida", Toast.LENGTH_SHORT);
                ganador.show();
            }
            RestaurarMatriz();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override public void run() {
                    reiniciarTablero();
                    Intent mainActivity = new Intent(ActivityJuego.this, MainActivity.class);
                    startActivity(mainActivity);
                }
            }, 3000);
            ju=1;
            contVeces=9;
            jugadore=20;
        }
    }
    public void RestaurarMatriz(){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j]=0;
            }
        }
    }
}
