package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Grandma;
import data.Grandpa;


/**
 * Created by 44223 on 2018/9/2.
 */

public class GrandmaDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public GrandmaDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加父亲类信息***
    ***
     */
    public void add(Grandma grandma){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_grandma (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        grandma.getName(),grandma.getWords()});
    }

    public void update(Grandma grandma){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_grandma set words=? where name=? and id=?", new Object[]
                {grandma.getWords(),grandma.getName(),grandma.id}
        );
    }

    public void delete(Grandma grandma){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_grandma where id=?",new Object[]
                {
                        grandma.id
                });
    }
}
