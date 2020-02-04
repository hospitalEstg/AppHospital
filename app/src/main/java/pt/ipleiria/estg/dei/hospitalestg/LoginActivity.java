package pt.ipleiria.estg.dei.hospitalestg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final int PASS_MIN_SIZE = 8;
    private EditText et_email, et_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        et_email = findViewById(R.id.et_LUsername);
        et_password = findViewById(R.id.et_LPassword);


        et_email.setText("manel@email.pt");
        et_password.setText("123456789");

    }


    public void onClickLogin(View view) {


        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (!isEmailValid(email)) {
            et_email.setError("E-mail inválido.");
            return;
        }

        if (!isPasswordValid(password)) {
            et_password.setError("Password inválida.");
            return;
        }




        // nova atividade
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, MenuMainActivity.class);
        intent.putExtra("EMAIL", email);
        startActivity(intent);
        finish(); // fechar atividade atual


    }



    private boolean isEmailValid(String email) {
        if(email != null){
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    private boolean isPasswordValid(String password) {
        if(password != null){
            return (password.length() > PASS_MIN_SIZE ? true : false);
        }
        return false;
    }


}
