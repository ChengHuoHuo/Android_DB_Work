package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class UpdateActivity extends Activity {
    private TextView et1;
    private TextView et2;
    private EditText et3;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String id=bundle.getString("id");
        String name=bundle.getString("username");
        String words=bundle.getString("words");
        message=bundle.getString("peoplename");
        et1=(TextView) findViewById(R.id.tv_id);
        et2=(TextView) findViewById(R.id.tv_name);
        et3=(EditText)findViewById(R.id.et_words);
        et1.setText(id);
        et2.setText(name);
        et3.setText(words);

        Button btn1=(Button)findViewById(R.id.btn_upsate_save);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goupdate();
                finish();
            }
        });

        Button bt2= (Button)findViewById(R.id.btn_update_nagetive);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }

    public void goupdate(){
        if(message.equals("father"))
        {
            FatherDAO fatherDAO=new FatherDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Father father=new Father(i,words2,words3);
            fatherDAO.update(father);
        }
        else if(message.equals("mother"))
        {
            MotherDAO motherDAO=new MotherDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Mother mother=new Mother(i,words2,words3);
            motherDAO.update(mother);
        }
        else if(message.equals("lover"))
        {
            LoverDAO loverDAO=new LoverDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Lover lover=new Lover(i,words2,words3);
            loverDAO.update(lover);
        }
        else if(message.equals("grandpa"))
        {
            GrandpaDAO grandpaDAO=new GrandpaDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Grandpa grandpa=new Grandpa(i,words2,words3);
            grandpaDAO.update(grandpa);
        }
        else if(message.equals("grandma"))
        {
            GrandmaDAO grandmaDAO=new GrandmaDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Grandma grandma=new Grandma(i,words2,words3);
            grandmaDAO.update(grandma);
        }
        else if(message.equals("grandfather"))
        {
            GrandfatherDAO grandfatherDAO=new GrandfatherDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Grandfather grandfather=new Grandfather(i,words2,words3);
            grandfatherDAO.update(grandfather);
        }
        else if(message.equals("grandmother"))
        {
            GrandmotherDAO grandmotherDAO=new GrandmotherDAO(this);
            String words1=et1.getText().toString();
            int i=Integer.parseInt(words1);
            String words2=et2.getText().toString();
            String words3=et3.getText().toString();
            Grandmother grandmother=new Grandmother(i,words2,words3);
            grandmotherDAO.update(grandmother);
        }
        Toast.makeText(getApplicationContext(), "记录修改成功", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK,null);
    }
}
