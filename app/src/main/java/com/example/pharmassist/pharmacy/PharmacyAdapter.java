package com.example.pharmassist.pharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmassist.R;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder> {

    private Context context;
    private List<Pharmacy> pharmacyList;

    public PharmacyAdapter(Context context, List<Pharmacy> pharmacyList) {
        this.context = context;
        this.pharmacyList = pharmacyList;
    }

    @NonNull
    @Override
    public PharmacyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pharmacy_item, parent, false);
        return new PharmacyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PharmacyViewHolder holder, int position) {
        Pharmacy pharmacy = pharmacyList.get(position);
        holder.nameTextView.setText(pharmacy.getName());
        holder.locationTextView.setText(pharmacy.getProvince() + ", " + pharmacy.getCity() + ", " + pharmacy.getStreetNumber());
        holder.contactTextView.setText(pharmacy.getContactNumber());
    }


    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }

    public static class PharmacyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, locationTextView, contactTextView;

        public PharmacyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            contactTextView = itemView.findViewById(R.id.contactTextView);
        }
    }
}
