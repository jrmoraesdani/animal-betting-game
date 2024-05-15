package com.example.animalbetting2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String [] animals = {"avestruz", "aguia", "burro", "borboleta", "cachorro", "cabra", "carneiro", "camelo", "cobra", "coelho", "cavalo", "elefante", "galo", "gato", "jacare", "leao", "macaco", "porco", "pavao", "peru", "touro", "tigre", "urso", "veado", "vaca"};
    int[] animalsImg = {R.drawable.avestruz, R.drawable.aguia, R.drawable.burro, R.drawable.borboleta,R.drawable.cachorro, R.drawable.cabra, R.drawable.carneiro, R.drawable.camelo, R.drawable.cobra, R.drawable.coelho, R.drawable.cavalo, R.drawable.elefante, R.drawable.galo, R.drawable.gato, R.drawable.jaca, R.drawable.leao, R.drawable.macaco, R.drawable.porco, R.drawable.pavao, R.drawable.peru, R.drawable.touro, R.drawable.tigre, R.drawable.urso, R.drawable.veado, R.drawable.vaca};

    AddCashActivity cashActivity = new AddCashActivity();
    TextView userBalanceView;

    double userBalanceGet = cashActivity.getWalletBalance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);

        userBalanceView = findViewById(R.id.wallet_value);
        userBalanceView.setText("User balance: " + String.format("%.2f", userBalanceGet));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), GridItem.class);
            intent.putExtra("name", animals[position]);
            intent.putExtra("image", animalsImg[position]);
            startActivity(intent);
        });

        Button addCashButton = findViewById(R.id.navigation_addCashButton);
        addCashButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCashActivity.class);
            startActivity(intent);
        });

    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return animalsImg.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 =  getLayoutInflater().inflate(R.layout.row_data, null);
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(animals[position]);
            image.setImageResource(animalsImg[position]);

            return view1;
        }
    }
}