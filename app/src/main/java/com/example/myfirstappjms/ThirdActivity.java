package com.example.myfirstappjms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private Bundle extras;
    private TextView tvText;
    private TextView tvWholeNumber;
    private TextView tvNumberDecimal;
    private TextView tvSwitch;
    private Boolean switchState;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Inicializamos los componentes
        initializeComponents();

        //Si pulsamos el botón btnReturn nos dirigiremos a la MainActivity de nuevo
        btnReturn.setOnClickListener(v -> {
            Intent mainActivityIntent = new Intent(this, MainActivity.class);
            startActivity(mainActivityIntent);
        });

        //Mostramos los datos recibidos de la SecondActivity en los TextView correspondientes
        tvText.setText(tvText.getText() + extras.getString("Text"));
        tvWholeNumber.setText(tvWholeNumber.getText() + extras.getString("WholeNumber").toString());
        tvNumberDecimal.setText(tvNumberDecimal.getText() + extras.getString("NumberDecimal").toString());

        //Obtenemos y mostramos el estado del switch (Activado/Desactivado)
        switchState = extras.getBoolean("Switch");
        if (switchState){
            tvSwitch.setText(tvSwitch.getText() + "Activado");
        }else{
            tvSwitch.setText(tvSwitch.getText() + "Desactivado");
        }
    }

    /**
     * Este método se encarga de inicializar todos los componentes de la interfaz de usuario y otros
     * objetos necesarios para el funcionamiento de la actividad
     */
    private void initializeComponents(){

        btnReturn = findViewById(R.id.btnReturn);
        tvText = findViewById(R.id.tvText);
        extras = getIntent().getExtras();
        tvWholeNumber = findViewById(R.id.tvWholeNumber);
        tvNumberDecimal = findViewById(R.id.tvNumberDecimal);
        tvSwitch = findViewById(R.id.tvSwitch);

    }

}