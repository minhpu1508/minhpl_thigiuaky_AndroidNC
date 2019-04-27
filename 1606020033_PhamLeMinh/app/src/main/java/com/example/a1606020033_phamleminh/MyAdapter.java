package com.example.a1606020033_phamleminh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<ModelContact> models;
    int mResource;
    Context mContext;
    public MyAdapter(Context context,int resource, List<ModelContact> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        ModelContact modelContact = models.get(i);
        viewHolder.tvID.setText(String.valueOf(modelContact.getId()));
        viewHolder.tvProductName.setText(modelContact.getProductname());
        viewHolder.tvPrice.setText(modelContact.getPrice()+"");
        viewHolder.tvdescription.setText(modelContact.getDescription());
        viewHolder.tvProducer.setText(modelContact.getProducer());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID;
        TextView tvProductName;
        TextView tvPrice;
        TextView tvdescription;
        TextView tvProducer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvID = itemView.findViewById(R.id.tvID);
            this.tvProductName = itemView.findViewById(R.id.tvProductName);
            this.tvPrice = itemView.findViewById(R.id.tvPrice);
            this.tvdescription = itemView.findViewById(R.id.tvDescription);
            this.tvProducer = itemView.findViewById(R.id.tvProducer);
        }
    }
}