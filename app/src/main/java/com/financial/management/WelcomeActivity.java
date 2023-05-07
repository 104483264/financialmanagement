package com.financial.management;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.financial.management.adapter.AccountAdapter;
import com.financial.management.db.AccountBean;
import com.financial.management.db.DBManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    ListView todayLv;  //展示今日收支情况的ListView

    ImageView searchIv;
    Button editBtn;
    ImageButton moreBtn;

    //声明数据源
    List<AccountBean> mDatas;
    AccountAdapter adapter;
    int year,month,day;

    //头布局相关控件
    View headerView;
    TextView topOutTv,topInTv,topbudgetTv,topConTv;
    ImageView topShowIv;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main111);
        initTime();
        todayLv = findViewById(R.id.main_lv);

        //添加ListView的头布局
        //addLVHeaderView();

        mDatas = new ArrayList<>();
        //设置适配器：加载每一行数据到列表当中
        adapter = new AccountAdapter(this, mDatas);
        todayLv.setAdapter(adapter);

    }

    /* 获取今日的具体时间*/
    private void initTime() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.main_iv_search:

                break;

            case R.id.main_btn_edit:
                Intent intent1 = new Intent(getApplicationContext(), RecordActivity.class);//跳转界面
                startActivity(intent1);
                break;

            case R.id.main_btn_more:
                break;

        }
    }

    /** 给ListView添加头布局的方法*/
    private void addLVHeaderView() {
        //将布局转换成View对象
        headerView = getLayoutInflater().inflate(R.layout.item_mainlv_top, null);
        todayLv.addHeaderView(headerView);
        //查找头布局可用控件
        topOutTv = headerView.findViewById(R.id.item_mainlv_top_tv_out);
        topInTv = headerView.findViewById(R.id.item_mainlv_top_tv_in);
        topbudgetTv = headerView.findViewById(R.id.item_mainlv_top_tv_budget);
        topConTv = headerView.findViewById(R.id.item_mainlv_top_tv_day);
        topShowIv = headerView.findViewById(R.id.item_mainlv_top_iv_hide);

        topbudgetTv.setOnClickListener(this);
        headerView.setOnClickListener(this);
        topShowIv.setOnClickListener( this);

    }
    
    // 当activity获取焦点时，会调用的方法
    @Override
    protected void onResume() {
        super.onResume();
        loadDBData();

    }

    // 加载数据库数据
    private void loadDBData() {
        List<AccountBean> list = DBManager.getAccountListOneDayFromAccounttb(year, month, day);
        mDatas.clear();
        mDatas.addAll(list);
        adapter.notifyDataSetChanged();
    }

}
