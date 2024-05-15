package com.example.animalbetting2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddCashActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private TextView textViewAddedValue;



    public double walletBalance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_cash_activity);

        editTextAmount = findViewById(R.id.saldoEditText);
        textViewAddedValue = findViewById(R.id.textViewAddedValue);

        Button addButton = findViewById(R.id.adicionarSaldoButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValueToWallet(v);
            }
        });
    }

    public void addValueToWallet(View view) {
        String amountString = editTextAmount.getText().toString();
        if (!amountString.isEmpty()) {
            double amount = Double.parseDouble(amountString);
            walletBalance += amount;
            textViewAddedValue.setText("Valor adicionado: R$ " + String.format("%.2f", walletBalance));
            Toast.makeText(this, "Valor adicionado com sucesso à carteira", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, insira um valor válido", Toast.LENGTH_SHORT).show();
        }
    }

    public double getWalletBalance() {
        return walletBalance;
    }
}