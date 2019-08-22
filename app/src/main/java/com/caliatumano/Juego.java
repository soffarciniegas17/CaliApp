package com.caliatumano;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Juego extends AppCompatActivity {

    String categoria = "";
    TextView textCatego = null;
    int catego_id = 0;
    int position = 0, buenas, malas;
    TextView resp1, resp2, resp3, resp4, titulo_resp, desc_resp;
    ImageView image;
    Button aceptar;
    int correctas[] = new int[8];
    Dialog dialo_resp;
    TextView textos[] = {resp1, resp2, resp3, resp4};
    TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        textCatego = findViewById(R.id.categoria_tx);
        resp1 = findViewById(R.id.resp_1);
        resp2 = findViewById(R.id.resp_2);
        resp3 = findViewById(R.id.resp_3);
        resp4 = findViewById(R.id.resp_4);

        Bundle extras = getIntent().getExtras();
        categoria = extras.getString("categoria");
        textCatego.setText(categoria);

        pregunta = findViewById(R.id.pregunta);
        pregunta.setText(getPreguntas(1, extras.getInt("id_categoria")));
        position = 1;
        catego_id = extras.getInt("id_categoria");

        TextView textos[] = {resp1, resp2, resp3, resp4};

        for (int i = 0; i < textos.length; i++) {
            if (extras.getInt("id_categoria") == 0) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(0)[i]);
                } else {
                    textos[i].setText(getRespuestas(1)[i]);
                }
            } else if (extras.getInt("id_categoria") == 1) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(2)[i]);
                } else {
                    textos[i].setText(getRespuestas(3)[i]);
                }
            } else if (extras.getInt("id_categoria") == 2) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(4)[i]);
                } else {
                    textos[i].setText(getRespuestas(5)[i]);
                }
            } else {
                if (position == 1) {
                    textos[i].setText(getRespuestas(6)[i]);
                } else {
                    textos[i].setText(getRespuestas(7)[i]);
                }
            }

        }

        dialo_resp = new Dialog(this);
        dialo_resp.setContentView(R.layout.dialog);
        dialo_resp.setCancelable(false);
        dialo_resp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        titulo_resp = dialo_resp.findViewById(R.id.txt_main);
        desc_resp = dialo_resp.findViewById(R.id.txt_desc);
        aceptar = dialo_resp.findViewById(R.id.btn_main);
        image = dialo_resp.findViewById(R.id.img_main);

        buenas = 0;
        malas = 0;

    }


    public String getPreguntas(int position, int categoria) {
        String pregunta = "";
        switch (categoria) {
            case 0:
                if (position == 1) {
                    //0
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                } else {
                    //1
                    pregunta = "Maria, es la única novelda de Jorge Isaac, la cúal es considerada una de las obras más destacadas" +
                            "de la literatura hispanica. ¿De que trata esta novela?";
                }

                break;
            case 1:

                if (position == 1) {
                    //2
                    pregunta = "El 26 de febrero de 1971 ocurrió La Masacre estudiantil más memorada de la historia cuando estudiantes" +
                            " de Univalle trataron de retorma su campus. '¿Bajo el mandato de quién sucedio este hecho?";
                } else {
                    //3
                    pregunta = "¿En que año Santiago de Cali pasó a ser la capital del (en esa epoca) renaciente Valle del Cauca?";
                }
                break;
            case 2:
                if (position == 1) {
                    //4
                    pregunta = "La feria de Cali fue motivada para transformar el dolor de una tregedia en alegría y festividad ¿Qué tragedia condecoro esta festividad?";
                } else {
                    //5
                    pregunta = "El 'Petronio' es una festividad músical reconocida mundialmente que consiste en...";
                }
                break;
            case 3:
                if (position == 1) {
                    //6
                    pregunta = "Uno de los barrios más antiguos de Cali resalta en una de las tantas lomas de Cali, es considerada patrimonio de la ciudad" +
                            "y dentro de él, se encuentra una de las iglesias más antiguas de Colombia.";
                } else {
                    //7
                    pregunta = "La Ermita conserva una de las imagenes con más de tres siglos como Nuestra señora de los Dolores, San Francisco, ect. En " +
                            " su lateral izquierdo contiene una de las más antiguas imagenes que conserva la iglesia y es una representación vallecaucana.";
                }
                break;

        }

        return pregunta;
    }

    public String[] getRespuestas(int pregunta) {
        String resp[] = new String[4];
        switch (pregunta) {
            case 0:
                correctas[0] = 1;
                resp[0] = "Andres Caicedo y Luis Ospina";
                resp[1] = "Luis Ospina y Carlos Mayolo";
                resp[2] = "Diego León Giraldo y Patricia Restrepo";
                resp[3] = "Fernando velez y Carlos Mayolo";
                break;
            case 1:
                correctas[1] = 2;
                resp[0] = "La tragedia de Efráin";
                resp[1] = "La muerte de Maria";
                resp[2] = "El idilio entre Maria y Efráin";
                resp[3] = "El viaje de Efrain";
                break;
            case 2:
                correctas[2] = 3;
                resp[0] = "Jore Holguín Mallarino";
                resp[1] = "Andrés Pastrana";
                resp[2] = "Álvaro Uribe Velez";
                resp[3] = "Gustavo Rojas Pinilla";
                break;
            case 3:
                correctas[3] = 3;
                resp[0] = "1834";
                resp[1] = "1821";
                resp[2] = "1991";
                resp[3] = "1911";
                break;
            case 4:
                correctas[4] = 0;
                resp[0] = "La explosión de 6 camiones militares";
                resp[1] = "La masacre estudiantil";
                resp[2] = "Las elecciones de 1970";
                resp[3] = "Masacre de las bananeras";
                break;
            case 5:
                correctas[5] = 1;
                resp[0] = "Realizar un homenaje a la música Colombiana";
                resp[1] = "Impulsar la cultura del pacifico colombiano trayendo su cultura, sus platos y su música";
                resp[2] = "Incentivar el turismo colombiano";
                resp[3] = "Para realizar una introducción a la cultura pacifica";
                break;
            case 6:
                correctas[6] = 2;
                resp[0] = "San Fernando";
                resp[1] = "Los Farallones";
                resp[2] = "San Antonio";
                resp[3] = "Parque del gato";
                break;
            case 7:
                correctas[7] = 3;
                resp[0] = "El niño Jesús";
                resp[1] = "El viacrusis";
                resp[2] = "Maria Magdalena";
                resp[3] = "Cristo de la caña";
                break;
            default:

                break;
        }
        return resp;
    }

    public void respuesta(View view) {
        switch (catego_id) {
            case 0:
                if (position == 1) {
                    preguntaCorrecta((correctas[0] == Integer.parseInt(view.getTag().toString())));
                } else {
                    preguntaCorrecta((correctas[1] == Integer.parseInt(view.getTag().toString())));

                }
                break;
            case 1:
                if (position == 1) {
                    preguntaCorrecta((correctas[2] == Integer.parseInt(view.getTag().toString())));
                } else {
                    preguntaCorrecta((correctas[3] == Integer.parseInt(view.getTag().toString())));

                }
                break;
            case 2:
                if (position == 1) {
                    preguntaCorrecta((correctas[4] == Integer.parseInt(view.getTag().toString())));
                } else {
                    preguntaCorrecta((correctas[5] == Integer.parseInt(view.getTag().toString())));

                }
                break;
            case 3:
                if (position == 1) {
                    preguntaCorrecta((correctas[6] == Integer.parseInt(view.getTag().toString())));

                } else {
                    preguntaCorrecta((correctas[7] == Integer.parseInt(view.getTag().toString())));

                }
                break;
        }
    }

    public void preguntaCorrecta(boolean respuesta) {

        if (respuesta) {
            buenas++;
            titulo_resp.setText("Correcto");
            titulo_resp.setTextColor(Color.parseColor("#4CAF50"));
            image.setBackgroundResource(R.drawable.ic_buena);
            desc_resp.setText("Es correcto la respuesta");
        } else {
            malas++;
            image.setBackgroundResource(R.drawable.ic_mala);
            titulo_resp.setText("Incorrecto");
            titulo_resp.setTextColor(Color.parseColor("#F44336"));

            desc_resp.setText("Es incorrecta la respuesta");
        }

        dialo_resp.show();

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 1) {

                    dialo_resp.dismiss();
                    position++;
                    set(position);
                }else{
                    dialo_resp.dismiss();
                    Intent intent = new Intent(getApplicationContext(), FinalJuego.class);
                    intent.putExtra("preguntas", 2);
                    intent.putExtra("buenas", "" + buenas);
                    intent.putExtra("malas", "" + malas);
                    startActivity(intent);
                }

            }
        });
    }


    public void set(int position) {
        TextView textos[] = {resp1, resp2, resp3, resp4};
        pregunta.setText(getPreguntas(position, catego_id));

        for (int i = 0; i < textos.length; i++) {
            if (catego_id == 0) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(0)[i]);
                } else {
                    textos[i].setText(getRespuestas(1)[i]);
                }
            } else if (catego_id == 1) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(2)[i]);
                } else {
                    textos[i].setText(getRespuestas(3)[i]);
                }
            } else if (catego_id == 2) {
                if (position == 1) {
                    textos[i].setText(getRespuestas(4)[i]);
                } else {
                    textos[i].setText(getRespuestas(5)[i]);
                }
            } else {
                if (position == 1) {
                    textos[i].setText(getRespuestas(6)[i]);
                } else {
                    textos[i].setText(getRespuestas(7)[i]);
                }
            }

        }

    }

}
