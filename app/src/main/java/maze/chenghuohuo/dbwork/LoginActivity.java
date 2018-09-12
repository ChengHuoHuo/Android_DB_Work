package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import data.User;
import db.UserDAO;

public class LoginActivity extends Activity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnGoRegister;
    private CheckBox cbRemember;
    private Boolean isRemember=false;
    private final String PREFERENCES_NAME="userinfo";
    private String userName,passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("登录");

        etUsername=(EditText)findViewById(R.id.et_username);
        etPassword=(EditText)findViewById(R.id.et_password);
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnGoRegister=(Button)findViewById(R.id.btn_register);
        cbRemember=(CheckBox)findViewById(R.id.ischecked);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnGoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });

        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember=isChecked;
            }
        });

        SharedPreferences preferences=getSharedPreferences(PREFERENCES_NAME,Activity.MODE_PRIVATE);

        etUsername.setText(preferences.getString("ReUsername",null));
        cbRemember.setChecked(preferences.getBoolean("Remember",true));
        if(cbRemember.isChecked()){
            etPassword.setText(preferences.getString("RePassWord",null));
        }else {
            etPassword.setText(null);
        }
    }

    private void login(){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        UserDAO userDAO = new UserDAO(this);
        User user = userDAO.find(username);
        if (user == null) {
            Toast.makeText(this, "不存在该用户！", Toast.LENGTH_SHORT).show();
        } else if (!user.password.equals(password)) {
            Toast.makeText(this, "密码错误，请输入正确的密码！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            MyApplication app = (MyApplication) getApplication();
            app.setUser(user);

            finish();
        }
    }

    public void goRegister()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void onStop() {

        super.onStop();

        SharedPreferences agPreferences=getSharedPreferences(PREFERENCES_NAME,Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=agPreferences.edit();
        userName=etUsername.getText().toString();
        passWord=etPassword.getText().toString();
        editor.putString("ReUsername",userName);
        editor.putString("RePassWord",passWord);
        editor.putBoolean("Remember",isRemember);
        editor.commit();
    }
}
