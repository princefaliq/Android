package com.psi.tugas_psi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Database db;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);

        //logout = (Button)findViewById(R.id.btnlogout);

        //Boolean checkSession = db.checkSession("kosong");
       /* if(checkSession == true){
            Boolean updtSession = db.upgradeSession("ada", 1);
            Intent loginIntent = new Intent(MainActivity.this, Login.class);
            startActivity(loginIntent);
            finish();
        }*/
        //logout
        /*logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                Toast.makeText(getApplicationContext(), "berhasil keluar", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_aplikasi,menu );
        return true;
    }
    //Menthod ini digunakan untuk menangani kejadian saat OptionMenu diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(getApplicationContext(),"Buka Profil",Toast.LENGTH_SHORT).show();
                Intent register = new Intent(MainActivity.this, Register.class);
                startActivity(register);
                finish();
                break;

            case R.id.menu2:
                Toast.makeText(getApplicationContext(),"Data list register",Toast.LENGTH_SHORT).show();
                Intent data_register = new Intent(MainActivity.this, list_register.class);
                startActivity(data_register);
                finish();
                break;

            case R.id.menu3:
                Toast.makeText(getApplicationContext(),"Group",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu4:
                Toast.makeText(getApplicationContext(),"Keluar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu5:
                Toast.makeText(getApplicationContext(), "berhasil keluar", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
                finish();
                break;
        }
        return true;
    }
}