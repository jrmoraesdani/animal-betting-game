package com.example.animalbetting2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GridItem extends AppCompatActivity {

    TextView name;
    ImageView image;


    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    TextView betResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_item);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));


        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        betResult = findViewById(R.id.betResult);
        Button button = findViewById(R.id.betButton);


        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                int userInputNumber1 = Integer.parseInt(editText1.getText().toString());
                int userInputNumber2 = Integer.parseInt(editText2.getText().toString());
                int userInputNumber3 = Integer.parseInt(editText3.getText().toString());
                int userInputNumber4 = Integer.parseInt(editText4.getText().toString());

                if (
                        userInputNumber1 < 1 || userInputNumber1 > 99 ||
                        userInputNumber2 < 1 || userInputNumber2 > 99 ||
                        userInputNumber3 < 1 || userInputNumber3 > 99 ||
                        userInputNumber4 < 1 || userInputNumber4 > 99) {
                    Toast.makeText(GridItem.this, "Digite números entre 1 e 99.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Random random = new Random();
                int randomNumber1 = random.nextInt(10000);
                int randomNumber2 = random.nextInt(10000);
                int randomNumber3 = random.nextInt(10000);
                int randomNumber4 = random.nextInt(10000);

                String betNumbersResult = String.format("Result: %d, %d, %d, %d", randomNumber1, randomNumber2, randomNumber3, randomNumber4);
                betResult.setText(betNumbersResult);

                if(userInputNumber1 == randomNumber1 && userInputNumber2 == randomNumber2 && userInputNumber3 == randomNumber3 && userInputNumber4 == randomNumber4){
                    Toast.makeText(GridItem.this, "You win!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(GridItem.this, "You lose!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}