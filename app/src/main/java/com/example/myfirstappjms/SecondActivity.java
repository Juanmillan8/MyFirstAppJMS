package com.example.myfirstappjms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private Button btnGoToThirdActivity;
    private EditText etWholeNumber;
    private EditText etNumberDecimal;
    private EditText etText;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initializeComponents();

        //Si pulsamos el boton btnGoToThirdActivity nos dirigiremos a la ThirdActivity pasandole ademas los datos que el usuario haya
        //insertado en esta activity
        btnGoToThirdActivity.setOnClickListener(v -> {
            Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);

            thirdActivityIntent.putExtra("WholeNumber", etWholeNumber.getText().toString());
            thirdActivityIntent.putExtra("NumberDecimal", etNumberDecimal.getText().toString());
            thirdActivityIntent.putExtra("Text", etText.getText().toString());
            thirdActivityIntent.putExtra("Switch", switch1.isChecked());

            startActivity(thirdActivityIntent);
        });

    }

    /**
     * Este metodo se encarga de inicializar todos los componentes de la interfaz de usuario y otros
     * objetos necesarios para el funcionamiento de la actividad
     */
    private void initializeComponents(){
        btnGoToThirdActivity = findViewById(R.id.btnSendData);
        etWholeNumber = findViewById(R.id.etWholeNumber);
        etNumberDecimal = findViewById(R.id.etNumberDecimal);
        etText = findViewById(R.id.etText);
        switch1 = findViewById(R.id.switch1);

    }

}