package com.example.loginbg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AccountAdapter extends BaseAdapter {
    private List<UserAccount>listData;
    private int layout;
    private Context context;

    public AccountAdapter(Context aContext,int layout, List<UserAccount>listData){
        this.context = aContext;
        this.layout =layout;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txtid , txttdn,txtpass,txtemail;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =inflater.inflate(layout,null);
            holder.txtid=row.findViewById(R.id.msv);
            holder.txttdn=row.findViewById(R.id.tdn);
            holder.txtpass=row.findViewById(R.id.matkhau);
            holder.txtemail=row.findViewById(R.id.Email);
            UserAccount account = listData.get(position);
            row.setTag(holder);
        }else{
            holder=(ViewHolder)row.getTag();
        }
        UserAccount account = listData.get(position);
        if (account != null){
            holder.txtid.setText(account.getId());
            holder.txtemail.setText(account.getEmail());
            holder.txttdn.setText(account.getUser());
            holder.txtpass.setText(account.getPass());
     }
     return row;
    }
}
