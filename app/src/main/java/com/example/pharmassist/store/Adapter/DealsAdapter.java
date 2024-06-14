package com.example.pharmassist.store.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pharmassist.R;
import com.example.pharmassist.store.Model.DealsModel;

import java.util.ArrayList;
import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.viewHolder> {
    private Context ctx;
    private List<DealsModel> dealsModelList = new ArrayList<>();

    public DealsAdapter(Context ctx, List<DealsModel> dealsModelList) {
        this.ctx = ctx;
        this.dealsModelList = dealsModelList;
    }


    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_deals,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final DealsModel dealsModel= dealsModelList.get(position);
        holder.dealsTitle.setText(dealsModel.getDealsTitle());
        holder.dealsType.setText(dealsModel.getDealsType());
        holder.dealsStorageLife.setText(dealsModel.getDealsStorageLife());
        holder.dealsOriginalPrice.setText(dealsModel.getDealsOriginalPrice());
        holder.dealsDiscountedPrice.setText(dealsModel.getDealsDiscountedPrice());
        holder.dealsDiscountedPercentage.setText(dealsModel.getDealsDiscountedPercentage());
        //To show the stuff
        Glide.with(ctx).load(dealsModel.getDealsImage()).into(holder.dealsImage);

    }

    @Override
    public int getItemCount() {

        return dealsModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView dealsImage ;
        private TextView dealsTitle,dealsType,dealsStorageLife,dealsDiscountedPrice,dealsOriginalPrice
        ,dealsDiscountedPercentage;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            dealsImage = itemView.findViewById(R.id.iv_deals);
            dealsTitle = itemView.findViewById(R.id.txt_dealTitle);
            dealsType = itemView.findViewById(R.id.txt_dealType);
            dealsStorageLife = itemView.findViewById(R.id.txt_dealStorageLife);
            dealsOriginalPrice = itemView.findViewById(R.id.txt_dealOriginalPrice);
            dealsDiscountedPrice = itemView.findViewById(R.id.txt_dealsDiscountedPrice);
            dealsDiscountedPercentage = itemView.findViewById(R.id.txt_dealsDiscountedPercentage);


        }
    }
}
