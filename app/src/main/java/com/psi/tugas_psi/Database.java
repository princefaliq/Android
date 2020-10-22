package com.psi.tugas_psi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.BoringLayout;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "loginSQLite.db", null, 1);
    }
    public static final String id_user = "id";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, username text, password text)");
        db.execSQL("CREATE TABLE master_pengguna(id integer PRIMARY KEY AUTOINCREMENT, nama text, alamat text, tglLahir text, id_user text)");
        db.execSQL("INSERT INTO session(id, login) VALUES(1, 'kosong')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS master_pengguna");
        onCreate(db);
    }

    //check session
    public Boolean checkSession(String sessionValues){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", new String[]{sessionValues});
        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    //upgrade session
    public Boolean upgradeSession(String sessionValue, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", sessionValue);
        long update = db.update("session", contentValues, "id="+id, null);
        if(update == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert user
    public Boolean insertUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long insert = db.insert("user", null, contentValues);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    //insert masterpengguna
    public Boolean insertMasterPengguna(String nama, String alamat, String tglLahir){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        contentValues.put("tglLahir", tglLahir);
       // contentValues.put("id_user", id_user);
        long insert = db.insert("master_pengguna", null, contentValues );
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    //Checklogin
    public Boolean checkLogin(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    // delete barang sesuai ID
    public void deleteUser(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String strFilter = "_id=" + id;
        Cursor cursor = db.rawQuery("DELETE FROM user WHERE id_user = ? ", new String[]{strFilter});
    }
}
