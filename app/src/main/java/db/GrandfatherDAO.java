package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Grandfather;
import data.Grandpa;


/**
 * Created by 44223 on 2018/9/2.
 */

public class GrandfatherDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public GrandfatherDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加父亲类信息***
    ***
     */
    public void add(Grandfather grandfather){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_grandfather (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        grandfather.getName(),grandfather.getWords()});
    }

    public void update(Grandfather grandfather){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_grandfather set words=? where name=? and id=?", new Object[]
                {grandfather.getWords(),grandfather.getName(),grandfather.id}
        );
    }

    public void delete(Grandfather grandfather){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_grandfather where id=?",new Object[]
                {
                        grandfather.id
                });
    }
}
