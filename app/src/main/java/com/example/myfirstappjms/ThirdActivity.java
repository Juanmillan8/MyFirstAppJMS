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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeComponents();

        //Si pulsamos el boton btnReturn nos dirigiremos a la MainActivity de nuevo para poder volver a repetir de nuevo el proceso
        btnReturn.setOnClickListener(v -> {
            Intent mainActivityIntent = new Intent(this, MainActivity.class);
            startActivity(mainActivityIntent);
        });


    }

    /**
     * Este metodo se encarga de inicializar todos los componentes de la interfaz de usuario y otros
     * objetos necesarios para el funcionamiento de la actividad
     */
    private void initializeComponents(){

        btnReturn = findViewById(R.id.btnReturn);
        extras = getIntent().getExtras();
        switchState = extras.getBoolean("Switch");

        tvText = findViewById(R.id.tvText);
        tvText.setText(tvText.getText() + extras.getString("Text"));

        tvWholeNumber = findViewById(R.id.tvWholeNumber);
        tvWholeNumber.setText(tvWholeNumber.getText() + extras.getString("WholeNumber").toString());

        tvNumberDecimal = findViewById(R.id.tvNumberDecimal);
        tvNumberDecimal.setText(tvNumberDecimal.getText() + extras.getString("NumberDecimal").toString());

        tvSwitch = findViewById(R.id.tvSwitch);

        if (switchState){
            tvSwitch.setText(tvSwitch.getText() + "Activado");
        }else{
            tvSwitch.setText(tvSwitch.getText() + "Desactivado");
        }






    }

}