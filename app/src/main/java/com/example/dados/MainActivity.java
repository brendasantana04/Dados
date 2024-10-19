package com.example.dados;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

/*
 *@author:<Brenda>
 *@ra:<1110482313042>
 */

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Spinner spinnerDiceCount;
    private Button rollButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        spinnerDiceCount = findViewById(R.id.spinnerDiceCount);
        rollButton = findViewById(R.id.rollButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dice_count_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDiceCount.setAdapter(adapter);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int selectedDice = radioGroup.getCheckedRadioButtonId();
        if (selectedDice == -1) {
            resultText.setText("Por favor, escolha um tipo de dado.");
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedDice);
        int faces = Integer.parseInt(selectedRadioButton.getText().toString().substring(1));
        int diceCount = Integer.parseInt(spinnerDiceCount.getSelectedItem().toString());

        Random random = new Random();
        StringBuilder results = new StringBuilder("Resultados: ");

        for (int i = 0; i < diceCount; i++) {
            int result = random.nextInt(faces) + 1;
            results.append(result).append(" ");
        }

        resultText.setText(results.toString());
    }
}