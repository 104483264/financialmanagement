package com.financial.management.record_fragment;
import androidx.fragment.app.Fragment;

import com.financial.management.R;
import com.financial.management.db.DBManager;
import com.financial.management.db.TypeBean;

import java.util.List;
public class OutcomeFragment extends BaseRecordFragment {


    // 重写
    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
//        List<TypeBean> outlist = DBManager.getTypeList(0);
//        typeList.addAll(outlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.ic_qita_fs);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(0);
        DBManager.insertItemToAccounttb(accountBean);
    }
}