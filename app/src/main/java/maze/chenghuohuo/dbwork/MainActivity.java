package maze.chenghuohuo.dbwork;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import data.Father;
import db.FatherDAO;

public class MainActivity extends AppCompatActivity {

    private TextView tv_username;
    private TextView tv_email;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private View headerLayout;
    private SwipeRefreshLayout swipeRefresh;

    private Fit[] fit={new Fit("Father",R.drawable.father),
            new Fit("Mother",R.drawable.mom),
            new Fit("Lover",R.drawable.lianren),
            new Fit("Grandpa",R.drawable.yeye),
            new Fit("Grandma",R.drawable.nainai),
            new Fit("Grandfather",R.drawable.waigong),
            new Fit("Grandmother",R.drawable.waipo)
    };
    private List<Fit> fitList=new ArrayList<>();
    private FitAdapter adapter;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        navigationView=(NavigationView)findViewById(R.id.nav_view);
        headerLayout=navigationView.getHeaderView(0);
        headerLayout=navigationView.inflateHeaderView(R.layout.nav_header);

        FatherDAO fatherDAO=new FatherDAO(this);

        MyApplication app=(MyApplication)getApplication();
        String tvname=app.getUser().name;
        Log.d("msg",tvname);
        tv_username=(TextView)headerLayout.findViewById(R.id.username);
        tv_username.setText("欢迎您，"+tvname);
        String tvemail=app.getUser().email;
        tv_email=(TextView)headerLayout.findViewById(R.id.email);
        tv_email.setText(tvemail);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_home);
        }
        navView.setCheckedItem(R.id.nav_all);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_all:
                        Intent intent1=new Intent(MainActivity.this,UserManageActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_exit:
                        dialog();
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });



        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"去看看添加的数据吧",Snackbar.LENGTH_SHORT).setAction("Go", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"转到所写的话的页面",Toast.LENGTH_SHORT).show();
                        gotoaddactivity();
                    }
                }).show();
            }
        });

        initfit();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FitAdapter(fitList);
        recyclerView.setAdapter(adapter);

        //下拉刷新
        swipeRefresh=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFit();
            }
        });
    }

    private void refreshFit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initfit();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initfit(){
        fitList.clear();
        for(int i=0;i<7;i++){
            fitList.add(fit[i]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this,"you click backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_all:
                Toast.makeText(this,"you click delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"you click settings",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }

    public void gotoaddactivity(){
        Intent intent=new Intent(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确定要退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MainActivity.this.finish();
                    }
                });
        builder.setNegativeButton("取消",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) { //监控/拦截/屏蔽返回键
            dialog();
            return false;
        } else if(keyCode == KeyEvent.KEYCODE_MENU) {
// rl.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
