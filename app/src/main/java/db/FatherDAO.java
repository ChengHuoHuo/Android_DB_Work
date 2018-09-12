package db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import data.Father;


/**
 * Created by 44223 on 2018/9/2.
 */

public class FatherDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public FatherDAO(Context context){
        helper=new DBHelper(context);
    }


    /*添加父亲类信息***
    ***
     */
    public void add(Father father){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_father (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        father.getName(),father.getWords()});
    }

    public void update(Father father){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_father set words=? where name=? and id=?", new Object[]
                {father.getWords(),father.getName(),father.id}
        );
    }

    public void delete(Father father){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_father where id=?",new Object[]
                {
                        father.id
                });
    }


}
