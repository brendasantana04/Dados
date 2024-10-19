package com.example.dados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

/*
 *@author:<Brenda>
 *@ra:<1110482313042>
 */

public class MainActivity extends AppCompatActivity {

    private EditText facesInput;
    private EditText diceInput;
    private Button rollButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facesInput = findViewById(R.id.facesInput);
        diceInput = findViewById(R.id.diceInput);
        rollButton = findViewById(R.id.rollButton);
        resultText = findViewById(R.id.resultText);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        String facesStr = facesInput.getText().toString();
        String diceStr = diceInput.getText().toString();

        if (!facesStr.isEmpty() && !diceStr.isEmpty()) {
            int faces = Integer.parseInt(facesStr);
            int dice = Integer.parseInt(diceStr);
            Random random = new Random();
            StringBuilder results = new StringBuilder("Resultados: ");

            for (int i = 0; i < dice; i++) {
                int result = random.nextInt(faces) + 1;
                results.append(result).append(" ");
            }

            resultText.setText(results.toString());
        } else {
            resultText.setText("Por favor, preencha ambos os campos.");
        }
    }
}
