package com.company.yun.ui.fragment.financedata.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.company.yun.R;
import com.company.yun.bean.financedata.FinanceDataBean;
import com.company.yun.utils.DataUtils;
import com.company.yun.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {
    public void setData(ArrayList<FinanceDataBean.DataBean.Recharge_companys_listEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int bean);
    }

    public ArrayList<FinanceDataBean.DataBean.Recharge_companys_listEntity> datas = null;
    private ItemClickCallBack clickCallBack;

    private FragmentActivity activity;

    public TopAdapter(ArrayList<FinanceDataBean.DataBean.Recharge_companys_listEntity> datas, FragmentActivity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data_top, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        FinanceDataBean.DataBean.Recharge_companys_listEntity bean = datas.get(position);


//        viewHolder.mTextView.setText(datas.get(position));

        viewHolder.tv_company_name.setText(bean.getCompany_name());

        viewHolder.tv_company_money.setText(NumberUtils.amountConversion(Double.parseDouble(bean.getMoney() + "")));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_company_name;
        public TextView tv_company_money;
        public LinearLayout mLinearLayout;

        public ViewHolder(View view) {
            super(view);
            tv_company_name = (TextView) view.findViewById(R.id.tv_company_name);
            tv_company_money = (TextView) view.findViewById(R.id.tv_company_money);
//            //图片
//            mLinearLayout = (LinearLayout) view.findViewById(R.id.first_linera);
        }
    }
}





















