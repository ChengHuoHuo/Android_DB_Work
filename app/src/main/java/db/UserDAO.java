package db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import data.User;
import db.DBHelper;

/**
 * Created by 44223 on 2018/8/27.
 */

public class UserDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public UserDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加学生信息***
    ***
     */
    public void add(User user){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_user (name ,password ,email) values (?,?,?)",new Object[]
                {
                        user.getName(),user.password,user.getEmail()});
    }

    public void update(User user){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_user set password=?,email=? where name=? ", new Object[]
                {user.password,user.getEmail(),user.getName()}
        );
    }

    /*查找学生信息**
    ***
     */

    public User find(String name) {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select name, password, email from t_user where name =?", new String[] {name});
        if (cursor.moveToNext()) {
            return new User(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("password")), cursor.getString(cursor.getColumnIndex("email")));
        }
        return null;
    }
}
