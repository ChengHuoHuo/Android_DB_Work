package maze.chenghuohuo.dbwork;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

import data.Father;
import db.DBHelper;

public class ShowActivity extends AppCompatActivity {


    public static final String NAME="show_name";
    public static final String IMAGE_ID="show_image_id";
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        Intent intent=getIntent();
        String showName=intent.getStringExtra(NAME);
        int showImageId=intent.getIntExtra(IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView showImageView=(ImageView)findViewById(R.id.show_image_view);
        TextView showContentText=(TextView)findViewById(R.id.show_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(showName);
        Glide.with(this).load(showImageId).into(showImageView);


        String showContent=generateShowContent(showName);
        showContentText.setText(showContent);
    }

    public String generateShowContent(String showName){
        MyApplication app=(MyApplication)getApplication();
        username=app.getUser().name;
        DBHelper helper=new DBHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        StringBuilder showContent=new StringBuilder();

        if(showName.equals("Father"))
        {
            Cursor cursor=db.query("t_father",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else if(showName.equals("Mother"))
        {
            Cursor cursor=db.query("t_mother",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else if(showName.equals("Lover"))
        {
            Cursor cursor=db.query("t_lover",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else if(showName.equals("Grandpa"))
        {
            Cursor cursor=db.query("t_grandpa",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else if(showName.equals("Grandma"))
        {
            Cursor cursor=db.query("t_grandma",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else if(showName.equals("Grandfather"))
        {
            Cursor cursor=db.query("t_grandfather",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        else {
            Cursor cursor=db.query("t_grandmother",null,null,null,null,null,null);
            if(cursor!=null&&cursor.moveToFirst()){
                do{
                    String wordsColumn=cursor.getString(cursor.getColumnIndex("words"));
                    String nameColumn=cursor.getString(cursor.getColumnIndex("name"));
                    if(nameColumn.equals(username)){
                        showContent.append(wordsColumn+".");
                    }
                    else {
                        showContent.append("");
                    }
                }while (cursor.moveToNext());
            }
            else {
                showContent.append(showName);
            }
            cursor.close();
        }
        return showContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
