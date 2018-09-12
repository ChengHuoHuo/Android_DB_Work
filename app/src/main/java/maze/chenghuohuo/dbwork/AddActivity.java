package maze.chenghuohuo.dbwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddActivity extends Activity {

    private ListView lv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        lv=(ListView)findViewById(R.id.Lv);
        final String[] name = new String[] { "爸爸", "妈妈", "你的那个TA","爷爷","奶奶","外公","外婆" };
        final String[] message=new String[]{ "father", "mother", "lover","grandpa","grandma","grandfather","grandmother"};
        final int[] photo = new int[] { R.drawable.father, R.drawable.mom, R.drawable.lianren ,R.drawable.yeye,R.drawable.nainai,R.drawable.waigong,R.drawable.waipo};
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.father);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.mom);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.lianren);
        map3.put("name", name[2]);
        data.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("photo", R.drawable.yeye);
        map4.put("name", name[3]);
        data.add(map4);

        Map<String, Object> map5= new HashMap<String, Object>();
        map5.put("photo", R.drawable.nainai);
        map5.put("name", name[4]);
        data.add(map5);

        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.waigong);
        map6.put("name", name[5]);
        data.add(map6);

        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("photo", R.drawable.waipo);
        map7.put("name", name[6]);
        data.add(map7);

        lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("message", message[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(AddActivity.this, WriteActivity.class);

                startActivity(intent);
            }
        });
    }
}
