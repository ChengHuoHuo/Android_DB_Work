package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserManageActivity extends Activity {

    private TextView tv1;
    private TextView tv2;
    private String str1;
    private String str2;
    private Button btn_revise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manage);

        MyApplication app=(MyApplication)getApplication();
        tv1=(TextView)findViewById(R.id.tv_user_name);
        tv2=(TextView)findViewById(R.id.tv_user_email);
        str1=app.getUser().name;
        str2=app.getUser().email;
        tv1.setText(str1);
        tv2.setText(str2);

        btn_revise=(Button)findViewById(R.id.btn_user_revise);
        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goReviseActivity();
            }
        });
    }

    public void goReviseActivity(){
        Intent intent=new Intent(UserManageActivity.this,ReviseActivity.class);
        startActivity(intent);
    }
}
