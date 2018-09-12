package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import data.Father;
import data.Mother;


/**
 * Created by 44223 on 2018/9/2.
 */

public class MotherDAO {
    private DBHelper helper;
    private SQLiteDatabase db;
    public MotherDAO(Context context){
        helper=new DBHelper(context);
    }

    /*添加母亲类信息***
    ***
     */
    public void add(Mother mother){
        db=helper.getWritableDatabase();
        db.execSQL("insert into t_mother (id,name ,words) values (NULL,?,?)",new Object[]
                {
                        mother.getName(),mother.getWords()});
    }

    public void update(Mother mother){
        db=helper.getWritableDatabase();
        db.execSQL(" update t_mother set words=? where name=? and id=?", new Object[]
                {mother.getWords(),mother.getName(),mother.id}
        );
    }

    public void delete(Mother mother){
        db=helper.getWritableDatabase();
        db.execSQL("delete from t_mother where id=?",new Object[]
                {
                        mother.id
                });
    }
}
