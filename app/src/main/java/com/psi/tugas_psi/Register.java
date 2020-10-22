package com.psi.tugas_psi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Database db;
    Button login, register;
    EditText username, password, passwwordConf, nama, alamat, tglLahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(this);

        username = (EditText)findViewById(R.id.editText_usernameRegist);
        password = (EditText)findViewById(R.id.editText_passwordRegist);
        passwwordConf = (EditText)findViewById(R.id.editText_passwordConfirm);
        nama = (EditText)findViewById(R.id.editText_nama);
        alamat = (EditText)findViewById(R.id.editText_alamat);
        tglLahir = (EditText)findViewById(R.id.editText_tglLahir);
        //login = (Button)findViewById(R.id.btnlogin_regist);
        register = (Button)findViewById(R.id.btnRegister_regist);

        //login
       /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent =new Intent(Register.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        });*/

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConf = passwwordConf.getText().toString();
                String strNama = nama.getText().toString();
                String strAlamat = alamat.getText().toString();
                String strTglLahir = tglLahir.getText().toString();
                //String strid_user = id_user.get


                if (strPassword.equals(strPasswordConf)){
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    Boolean pengguna = db.insertMasterPengguna(strNama,strAlamat,strTglLahir);
                    if(daftar==true && pengguna==true){
                        Toast.makeText(getApplicationContext(), "DAFTAR SUKSES", Toast.LENGTH_SHORT).show();
                        Intent loginIntent =new Intent(Register.this, Login.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "DAFTAR GAGAL", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}