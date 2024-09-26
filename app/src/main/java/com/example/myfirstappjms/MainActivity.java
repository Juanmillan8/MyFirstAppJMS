package com.example.myfirstappjms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos los componentes
        initializeComponents();

        //Si pulsamos el botón btnGoToSecondActivity nos dirigiremos a la SecondActivity
        btnGoToSecondActivity.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, SecondActivity.class);
            startActivity(secondActivityIntent);
        });

    }

    /**
     * Este método se encarga de inicializar todos los componentes de la interfaz de usuario y otros
     * objetos necesarios para el funcionamiento de la actividad
     */
    private void initializeComponents(){
        btnGoToSecondActivity = findViewById(R.id.btnGoToSecondActivity);

    }

}