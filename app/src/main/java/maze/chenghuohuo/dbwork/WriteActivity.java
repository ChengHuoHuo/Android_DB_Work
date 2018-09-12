package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import data.Father;
import data.Grandfather;
import data.Grandma;
import data.Grandmother;
import data.Grandpa;
import data.Lover;
import data.Mother;
import db.DBHelper;
import db.FatherDAO;
import db.GrandfatherDAO;
import db.GrandmaDAO;
import db.GrandmotherDAO;
import db.GrandpaDAO;
import db.LoverDAO;
import db.MotherDAO;

public class WriteActivity extends Activity {

    private ImageButton ib_father_word;
    private String message;
    private String checkusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        message=bundle.getString("message");
        ImageView Iv=(ImageView) findViewById(R.id.Iv);
        Iv.setImageResource(id);

        MyApplication app=(MyApplication)getApplication();
        checkusername=app.getUser().name;
        DBHelper helper=new DBHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();

        if(message.equals("father"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_father where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }

        else if(message.equals("mother"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_mother where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }
        else if(message.equals("lover"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_lover where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }
        else if(message.equals("grandpa"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_grandpa where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }
        else if(message.equals("grandma"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_grandma where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }
        else if(message.equals("grandfather"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_grandfather where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }
        else if(message.equals("grandmother"))
        {
            Cursor cursor=db.rawQuery("SELECT id as _id,name,words FROM t_grandmother where name=?",new String[]{checkusername});
            String[] from = { "_id","name", "words" };
            int[] to = { R.id.txtID,R.id.txtName ,R.id.txtWord };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
            ListView list=(ListView)findViewById(R.id.lv_add_theword);
            registerForContextMenu( list );
            list.setAdapter(adapter);
            TextView tv_number=(TextView)findViewById(R.id.tv_findthenumber);
            tv_number.setText("查询到"+cursor.getCount()+"条记录");
        }


        ib_father_word=(ImageButton)findViewById(R.id.btn_add_words);
        ib_father_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_add_wordsaactivity();
            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("操作");
        getMenuInflater().inflate(R.menu.manage, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.delete:
                delete(item); //代码见后
                return true;
            case R.id.update :
                update(item); //代码见后
                return true;
            default:
                return false;
        }
    }

    public void go_add_wordsaactivity(){
        Intent intent=new Intent(WriteActivity.this,InsertActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("peoplename",message);
        intent.putExtras(bundle);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
            if(resultCode==RESULT_OK){
                onCreate(null);
            }
        if(requestCode==200)
            if(resultCode==RESULT_OK){
                onCreate(null);
            }

    }

    public void delete(MenuItem item){
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(info.id>0){
            new AlertDialog.Builder(this).setTitle("删除" + info.id)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            gotodelete((int) info.id);
                        }
                    })
                    .setNegativeButton("取消", null) .show();
        }
    }

    public void gotodelete(int i){
        if(message.equals("father")){
            FatherDAO fatherDAO=new FatherDAO(this);
            Father father1=new Father(i);
            fatherDAO.delete(father1);
        }
        else if(message.equals("mother"))
        {
            MotherDAO motherDAO=new MotherDAO(this);
            Mother mother=new Mother(i);
            motherDAO.delete(mother);
        }
        else if(message.equals("lover"))
        {
            LoverDAO loverDAO=new LoverDAO(this);
            Lover lover=new Lover(i);
            loverDAO.delete(lover);
        }
        else if(message.equals("grandpa"))
        {
            GrandpaDAO grandpaDAO=new GrandpaDAO(this);
            Grandpa grandpa=new Grandpa(i);
            grandpaDAO.delete(grandpa);
        }
        else if(message.equals("grandma"))
        {
            GrandmaDAO grandmaDAO=new GrandmaDAO(this);
            Grandma grandma=new Grandma(i);
            grandmaDAO.delete(grandma);
        }
        else if(message.equals("grandfather"))
        {
            GrandfatherDAO grandfatherDAO=new GrandfatherDAO(this);
            Grandfather grandfather=new Grandfather(i);
            grandfatherDAO.delete(grandfather);
        }
        else if(message.equals("grandmother"))
        {
            GrandmotherDAO grandmotherDAO=new GrandmotherDAO(this);
            Grandmother grandmother=new Grandmother(i);
            grandmotherDAO.delete(grandmother);
        }
        Toast.makeText(getApplicationContext(), "记录删除成功", Toast.LENGTH_SHORT).show();
        onCreate(null); //重新加载一次Activity，刷新
    }

    public void update(MenuItem item){
        final AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Intent intent =new Intent(WriteActivity.this, UpdateActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("peoplename",message);
        bundle.putString("id", String.valueOf(info.id));
        bundle.putString("username",((TextView)info.targetView.findViewById(R.id.txtName)).getText().toString());
        bundle.putString("words",((TextView)info.targetView.findViewById(R.id.txtWord)).getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, 200);
    }
}
