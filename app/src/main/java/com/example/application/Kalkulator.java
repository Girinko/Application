package com.example.application;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Kalkulator extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private Spinner spinnerOperation;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        spinnerOperation = findViewById(R.id.spinnerOperation);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Daftar item yang akan ditampilkan di Spinner
        String[] operatorsArray = getResources().getStringArray(R.array.operators_array);

        // Buat ArrayAdapter untuk Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operatorsArray);

        // Atur tata letak dropdown yang akan digunakan
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapter ke Spinner
        spinnerOperation.setAdapter(adapter);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        // Mendapatkan nilai dari EditText
        String input1 = editTextNumber1.getText().toString();
        String input2 = editTextNumber2.getText().toString();

        // Mendapatkan operator yang dipilih dari Spinner
        String selectedOperator = spinnerOperation.getSelectedItem().toString();

        // Mengecek apakah input 1 dan 2 tidak kosong
        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mengubah nilai input menjadi tipe data numerik
        double number1 = Double.parseDouble(input1);
        double number2 = Double.parseDouble(input2);

        // Melakukan perhitungan berdasarkan operator yang dipilih
        double result = 0;

        switch (selectedOperator) {
            case "Tambah":
                result = number1 + number2;
                break;
            case "Kurang":
                result = number1 - number2;
                break;
            case "Kali":
                result = number1 * number2;
                break;
            case "Bagi":
                // Mengecek apakah pembagi tidak nol
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    Toast.makeText(this, "Pembagi tidak boleh nol", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        // Menampilkan hasil perhitungan di TextView
        textViewResult.setText("Hasil: " + result);
    }
}
