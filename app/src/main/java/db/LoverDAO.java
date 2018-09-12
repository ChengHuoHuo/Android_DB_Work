package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Father;
import data.Lover;


/**
 * Created by 44223 on 2018/9/2.
 */

public class LoverDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public LoverDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加父亲类信息***
    ***
     */
    public void add(Lover lover){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_lover (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        lover.getName(),lover.getWords()});
    }

    public void update(Lover lover){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_lover set words=? where name=? and id=?", new Object[]
                {lover.getWords(),lover.getName(),lover.id}
        );
    }

    public void delete(Lover lover){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_lover where id=?",new Object[]
                {
                        lover.id
                });
    }
}
