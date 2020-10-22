package com.psi.tugas_psi;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.app.Dialog;
import android.view.View;

public class list_register extends AppCompatActivity {
    private ListView listView;
    private Database MyDatabase;
    private ArrayList<String> ListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_register);
        getSupportActionBar().setTitle("Daftar User");
        listView = findViewById(R.id.list);
        ListData = new ArrayList<>();
        MyDatabase = new Database(getBaseContext());
        getData();
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListData));
    }
    //Berisi Statement-Statement Untuk Mengambi Data dari Database
    @SuppressLint("Recycle")
    private void getData() {
        //Mengambil Repository dengan Mode Membaca
        SQLiteDatabase ReadData = MyDatabase.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM master_pengguna", null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal

        //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
        for (int count = 0; count < cursor.getCount(); count++) {

            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir

            ListData.add("Nama: " + cursor.getString(1)+"\nAlamat: " + cursor.getString(2) + "\nTanggal lahir: " + cursor.getString(3));//Menambil Data Dari Kolom 1 (Nama)

            //Lalu Memasukan Semua Datanya kedalam ArrayList
        }
    }

}