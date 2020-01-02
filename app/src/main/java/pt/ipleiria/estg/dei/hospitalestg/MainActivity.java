package pt.ipleiria.estg.dei.hospitalestg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        //intent.putExtra("Username", email);
        startActivity(intent);
        finish(); // fechar atividade atual
    }

    public void registar(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        //intent.putExtra("Username", email);
        startActivity(intent);
        finish(); // fechar atividade atual
    }
}
