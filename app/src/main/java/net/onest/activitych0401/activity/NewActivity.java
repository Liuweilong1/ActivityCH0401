package net.onest.activitych0401.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.onest.activitych0401.R;
import net.onest.activitych0401.Student;

public class NewActivity extends AppCompatActivity {

    private EditText nameET;
    private int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        //接收从MainActivity传递的数据
        Intent request = getIntent();
        //获取不使用Bundle封装的数据
        String name = request.getStringExtra("name");
        String phone = request.getStringExtra("phone");
        String email = request.getStringExtra("email");
        position=request.getIntExtra("position",0);
        //获取使用Bundle封装的数据
//        Bundle bundle = request.getBundleExtra("bundle");
//        String name = bundle.getString("name");
//        String phone = bundle.getString("phone");
//        String email = bundle.getString("email");
        //获取自定义类型的数据
//        Student stu = (Student) request.getSerializableExtra("stu");
//        String name = stu.getName();
//        String phone = stu.getPhone();
//        String email = stu.getEmail();

        nameET = findViewById(R.id.et_name);
        EditText phoneET = findViewById(R.id.et_phone);
        EditText emailET = findViewById(R.id.et_email);

        nameET.setText(name);
        phoneET.setText(phone);
        emailET.setText(email);
    }
    public void buttonClicked(View v){
        //返回数据
        Intent response=new Intent();
        response.putExtra("name",nameET.getText().toString());
        Log.e("字符串",nameET.getText().toString());
        //响应
        setResult(200,response);
        //结束当前的newActivity
        finish();
    }
}
