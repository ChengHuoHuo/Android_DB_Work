package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.Father;
import data.Grandfather;
import data.Grandma;
import data.Grandmother;
import data.Grandpa;
import data.Lover;
import data.Mother;
import db.FatherDAO;
import db.GrandfatherDAO;
import db.GrandmaDAO;
import db.GrandmotherDAO;
import db.GrandpaDAO;
import db.LoverDAO;
import db.MotherDAO;

public class InsertActivity extends Activity {

    private Button btn1;
    private EditText et_words;
    private String username;
    private String peoplename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        peoplename=bundle.getString("peoplename");

        btn1=(Button)findViewById(R.id.btn_save);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
                setResult(RESULT_OK,null);
                finish();
            }
        });

    }


    public void add(){
        et_words=(EditText)findViewById(R.id.et_insert_words);
        String words=et_words.getText().toString();
        if(peoplename.equals("father")&&words.length()!=0)
        {
                FatherDAO fatherDAO=new FatherDAO(this);
                MyApplication app1=(MyApplication)getApplication();
                username=app1.getUser().name;
                Father father=new Father(username,words);
                fatherDAO.add(father);
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                app1.setFather(father);
        }
        else if(peoplename.equals("mother")&&words.length()!=0)
        {
            MotherDAO motherDAO=new MotherDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Mother mother=new Mother(username,words);
            motherDAO.add(mother);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }
        else if(peoplename.equals("lover")&&words.length()!=0)
        {
            LoverDAO loverDAO=new LoverDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Lover lover=new Lover(username,words);
            loverDAO.add(lover);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }
        else if(peoplename.equals("grandpa")&&words.length()!=0)
        {
            GrandpaDAO grandpaDAO=new GrandpaDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Grandpa grandpa=new Grandpa(username,words);
            grandpaDAO.add(grandpa);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }
        else if(peoplename.equals("grandma")&&words.length()!=0)
        {
            GrandmaDAO grandmaDAO=new GrandmaDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Grandma grandma=new Grandma(username,words);
            grandmaDAO.add(grandma);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }
        else if(peoplename.equals("grandfather")&&words.length()!=0)
        {
            GrandfatherDAO grandfatherDAO=new GrandfatherDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Grandfather grandfather=new Grandfather(username,words);
            grandfatherDAO.add(grandfather);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }
        else if(peoplename.equals("grandmother")&&words.length()!=0)
        {
            GrandmotherDAO grandmotherDAO=new GrandmotherDAO(this);
            MyApplication app1=(MyApplication)getApplication();
            username=app1.getUser().name;
            Grandmother grandmother=new Grandmother(username,words);
            grandmotherDAO.add(grandmother);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        }

    }

}
