package pt.ipleiria.estg.dei.hospitalestg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final int PASS_MIN_SIZE = 8;
    private EditText et_username, et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        et_username = findViewById(R.id.et_LUsername);
        et_password = findViewById(R.id.et_LPassword);


        et_username.setText("user");
        et_password.setText("123456789");

    }


    public void onClickLogin(View view) {


        String username = et_username.getText().toString();
        String password = et_password.getText().toString();



        // nova atividade
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, MenuMainActivity.class);
        //intent.putExtra("Username", email);
        startActivity(intent);
        finish(); // fechar atividade atual


    }
}
