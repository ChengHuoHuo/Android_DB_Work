package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.User;
import db.UserDAO;

public class ReviseActivity extends Activity {
    private String psd1;
    private String psd2;
    private EditText et1;
    private EditText et2;
    private Button btn1;
    private Button btn2;
    private String username;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);



            btn1=(Button)findViewById(R.id.btn_revise_save);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et1=(EditText)findViewById(R.id.et_revise_password1);
                    et2=(EditText)findViewById(R.id.et_revise_repassword1);
                    psd1=et1.getText().toString();
                    psd2=et2.getText().toString();
                    Log.d("msg1111","111111111111,"+psd1);
                    if(psd1.equals(psd2)&&psd1!=null) {
                        save();
                    }
                    else if(psd1==null)
                    {
                        Toast.makeText(getApplicationContext(), "密码不能为空，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btn2=(Button)findViewById(R.id.btn_revise_quxiao);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


    }

    public void save(){
        MyApplication app=(MyApplication)getApplication();
        username=app.getUser().name;
        email=app.getUser().email;
        UserDAO userDAO=new UserDAO(this);
        User user=new User(username,psd1,email);
        userDAO.update(user);
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(ReviseActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
