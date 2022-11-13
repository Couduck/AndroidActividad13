package com.example.bdlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPhoneNumber, etEmail, etPassword;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Manejo de excepciones
                try{
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "administracion", null, 1);
                    SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

                    String username = etUsername.getText().toString();
                    String phoneNumber = etPhoneNumber.getText().toString();
                    String email = etEmail.getText().toString();
                    String password = etEmail.getText().toString();

                    //Validación: los parametros están llenos
                    if(!username.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                        //nuevo registro
                        ContentValues registro = new ContentValues();
                        registro.put("username", username);
                        registro.put("phoneNumber", phoneNumber);
                        registro.put("email", email);
                        registro.put("password", password);

                        //insertar el registro
                        baseDeDatos.insert("tblUsers", null, registro);
                        baseDeDatos.close();

                        etUsername.setText("");
                        etPhoneNumber.setText("");
                        etEmail.setText("");
                        etPassword.setText("");


                        Toast.makeText(MainActivity.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Debes rellenar todos los campos", Toast.LENGTH_LONG).show();
                    }

                    baseDeDatos.close();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}