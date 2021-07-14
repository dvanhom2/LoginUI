package com.example.loginbg;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    List<UserAccount> userAccount ;
    Context context;
    DataBaseHelper myDB;

    public RecycleAdapter(List<UserAccount> userAccount, Context context) {
        this.userAccount = userAccount;
        this.context = context;
        myDB = new DataBaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.account_data,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecycleAdapter.ViewHolder holder, int position) {
            final UserAccount account  = userAccount.get(position);
            holder.txtmsv.setText(account.getId());
            holder.txtdn.setText(account.getUser());
            holder.txtpass.setText(account.getPass());
            holder.txtemail.setText(account.getEmail());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtmsv,txtdn,txtpass,txtemail;
        public ViewHolder(@NonNull View itemView){
            super((itemView));
            txtmsv=itemView.findViewById(R.id.msv);
            txtdn=itemView.findViewById(R.id.tendn);
            txtpass=itemView.findViewById(R.id.pw);
            txtemail=itemView.findViewById(R.id.mail);
        }
    }
}
