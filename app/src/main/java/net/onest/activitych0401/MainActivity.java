package net.onest.activitych0401;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.onest.activitych0401.activity.NewActivity;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"张三","李四","王五"};
    private ArrayAdapter adapter;
    private final int LOGIN_REQUEST=100;
    private int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nameListView = findViewById(R.id.lv);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                names);
        nameListView.setAdapter(adapter);
        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Activity跳转
                Intent intent = new Intent();
                //设置目的地Activity类
                intent.setClass(MainActivity.this,
                        NewActivity.class);
                //跳转时需要携带数据
                intent.putExtra("name", names[position]);
                intent.putExtra("phone", "1234565");
                intent.putExtra("email", "123132ees");
                intent.putExtra("position",position);
                //将数据先封装到Bundle对象，再添加到Intent对象
//                Bundle bundle = new Bundle();
//                bundle.putString("name",names[position]);
//                bundle.putString("phone","123231121212");
//                bundle.putString("email","adadasda");
//                intent.putExtra("bundle",bundle);
                //传递自定义类型的对象
//                Student student = new Student("张三","121312312","123121");
////                intent.putExtra("stu",student);
                //跳转到新的Activity，没有返回值
//                startActivity(intent);//不传递数据，并且不需要返回响应
                //跳转到新的Activity，并且可以返回一个响应
                startActivityForResult(intent,LOGIN_REQUEST);//请求码可以自定义数字
                currentPosition=position;
            }
        });

    }
    //接收返回的响应数据，并且刷新页面

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //requestCode跳转时的请求码
        //resultCode返回响应的结果码
        //data返回响应的intent对象
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==LOGIN_REQUEST && resultCode==200){
            //获得从NewActivity响应的数据
            String name=data.getStringExtra("name");
            Log.e("得到的响应","11111111111111");
            //修改数据源
            names[currentPosition]=name;
            //刷新adpter方法
            adapter.notifyDataSetChanged();
        }
    }
}
