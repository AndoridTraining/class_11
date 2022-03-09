package com.bbs.sampleproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bbs.sampleproject.R;
import com.bbs.sampleproject.database.AppEntity;

import java.util.List;

public class ViewAllUserInfo extends RecyclerView.Adapter<ViewAllUserInfo.UserViewHolder> {

    List<AppEntity> userList;
    private final LayoutInflater layoutInflater;

    public ViewAllUserInfo(Context context, List<AppEntity> userList) {
        layoutInflater = LayoutInflater.from(context);
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(layoutInflater.inflate(R.layout.custom_user_info, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.s_id.setText(String.valueOf(userList.get(position).sid));
        holder.user_name.setText(userList.get(position).user_name);
        holder.user_phone.setText(userList.get(position).user_phone);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView s_id, user_name, user_phone;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            s_id = itemView.findViewById(R.id.s_id);
            user_name = itemView.findViewById(R.id.user_name);
            user_phone = itemView.findViewById(R.id.user_phone);
        }
    }
}
