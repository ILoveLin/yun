package com.company.yun.ui.fragment.account.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.bean.account.AccountBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {


    public void setData(ArrayList<AccountBean.DataBean.Chams_usersEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int bean);
    }

    public ArrayList<AccountBean.DataBean.Chams_usersEntity> datas = null;
    private ItemClickCallBack clickCallBack;

    private FragmentActivity activity;

    public AccountAdapter(ArrayList<AccountBean.DataBean.Chams_usersEntity> datas, FragmentActivity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_account, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        AccountBean.DataBean.Chams_usersEntity bean = datas.get(position);
        viewHolder.tv_account_name.setText(bean.getAccount() + "");
        viewHolder.tv_frame_name.setText(bean.getCham_account() + "");
        viewHolder.tv_zhanxian.setText(bean.getShows() + "");
        viewHolder.tv_click.setText(bean.getClick() + "");
        viewHolder.tv_xiaofei.setText(bean.getConsume() + "");

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
        public TextView tv_account_name;
        public TextView tv_frame_name;
        public TextView tv_zhanxian;
        public TextView tv_click;
        public TextView tv_xiaofei;
        public View v_title_line;

        public ViewHolder(View view) {
            super(view);
            tv_account_name = (TextView) view.findViewById(R.id.tv_account_name);
            tv_frame_name = (TextView) view.findViewById(R.id.tv_frame_name);
            tv_zhanxian = (TextView) view.findViewById(R.id.tv_zhanxian);
            tv_click = (TextView) view.findViewById(R.id.tv_click);
            tv_xiaofei = (TextView) view.findViewById(R.id.tv_xiaofei);
            v_title_line = (View) view.findViewById(R.id.v_title_line);
        }
    }
}





















