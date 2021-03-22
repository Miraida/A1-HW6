package com.geek.a1_hw6;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {
    List<UserContactModel> list;
    Context context;
    IFragment listener;

    public TextAdapter(List<UserContactModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_text,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
            holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView item_tvTitle,item_tvSubTitle;
        private final ImageView item_ivProfile;
        private UserContactModel model;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item_tvTitle = itemView.findViewById(R.id.item_tvTitle);
            item_tvSubTitle = itemView.findViewById(R.id.item_tvSubTitle);
            item_ivProfile = itemView.findViewById(R.id.item_ImageView);
        }

        public void onBind(UserContactModel userContactModel) {
            this.model = userContactModel;
            item_tvTitle.setText(model.getTitle());
            item_tvSubTitle.setText(model.getSubTitle());
                Glide.with(context)
                        .load(model.getImage())
                        .circleCrop().into(item_ivProfile);

        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.displayDetails(model);
            }
        }

    }
    public void setOnclickListener(IFragment iFragment){
        this.listener = iFragment;
    }

}
