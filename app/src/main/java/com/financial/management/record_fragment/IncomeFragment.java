package com.financial.management.record_fragment;

import com.financial.management.R;
import com.financial.management.db.DBManager;
import com.financial.management.db.TypeBean;

import java.util.List;

/**
 * 收入记录页面
 */
public class IncomeFragment extends BaseRecordFragment {


    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
//        List<TypeBean> inlist = DBManager.getTypeList(1);
//        typeList.addAll(inlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.in_qt_fs);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(1);
        DBManager.insertItemToAccounttb(accountBean);
    }
}