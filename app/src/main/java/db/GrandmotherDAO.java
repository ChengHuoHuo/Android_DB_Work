package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Grandfather;
import data.Grandmother;


/**
 * Created by 44223 on 2018/9/2.
 */

public class GrandmotherDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public GrandmotherDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加父亲类信息***
    ***
     */
    public void add(Grandmother grandmother){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_grandmother (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        grandmother.getName(),grandmother.getWords()});
    }

    public void update(Grandmother grandmother){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_grandmother set words=? where name=? and id=?", new Object[]
                {grandmother.getWords(),grandmother.getName(),grandmother.id}
        );
    }

    public void delete(Grandmother grandmother){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_grandmother where id=?",new Object[]
                {
                        grandmother.id
                });
    }
}
