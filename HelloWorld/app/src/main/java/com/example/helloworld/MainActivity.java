package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void onBtnClick(View view){

        EditText editTxtName = findViewById(R.id.editTxtName);
        EditText editTxtSurname = findViewById(R.id.editTxtSurname);
        EditText editTxtEmail = findViewById(R.id.editTxtEmail);

        TextView nameTxt = findViewById(R.id.nameTxt);
        TextView surnameTxt = findViewById(R.id.surnameTxt);
        TextView emailTxt = findViewById(R.id.emailTxt);

        nameTxt.setText("First Name : "+ editTxtName.getText().toString());
        surnameTxt.setText("Surname : "+ editTxtSurname.getText().toString());
        emailTxt.setText("Email : "+ editTxtEmail.getText().toString());

    }
}