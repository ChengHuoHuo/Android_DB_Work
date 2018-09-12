package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Father;
import data.Grandpa;


/**
 * Created by 44223 on 2018/9/2.
 */

public class GrandpaDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public GrandpaDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加父亲类信息***
    ***
     */
    public void add(Grandpa grandpa){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_grandpa (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        grandpa.getName(),grandpa.getWords()});
    }

    public void update(Grandpa grandpa){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_grandpa set words=? where name=? and id=?", new Object[]
                {grandpa.getWords(),grandpa.getName(),grandpa.id}
        );
    }

    public void delete(Grandpa grandpa){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_grandpa where id=?",new Object[]
                {
                        grandpa.id
                });
    }
}
