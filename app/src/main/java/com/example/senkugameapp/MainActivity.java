package com.example.senkugameapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén una referencia al layout principal
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // Asigna un OnTouchListener al layout principal
        gridLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Obtiene la posición de la pulsación
                float x = event.getX();
                float y = event.getY();

                // Obtiene el ID del recurso XML
//              int resourceId = getResourceIdFromTouch(x, y);
                int column = getColumnFromTouch(x, gridLayout);
                int row = getRowFromTouch(y, gridLayout);
                // Muestra un Toast con la posición y el ID del recurso XML
                showToast("Posición: (" + row + ", " + column + ") - ID: ");
                return true;
            }
        });
    }
    private int getColumnFromTouch(float x, GridLayout gridLayout) {
        float columnWidth = gridLayout.getWidth() / gridLayout.getColumnCount();
        return (int) (x / columnWidth);
    }

    // Método para obtener la fila tocada en el GridLayout
    private int getRowFromTouch(float y, GridLayout gridLayout) {
        float rowHeight = gridLayout.getHeight() / gridLayout.getRowCount();
        return (int) (y / rowHeight);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

