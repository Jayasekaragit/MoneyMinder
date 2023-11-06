package com.example.moneyminder;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private Cursor cursor;
    private Context context;
    private ArrayList amount,category;

    public ExpenseAdapter( Context context, ArrayList amount, ArrayList category) {
        this.cursor = cursor;
        this.context = context;
        this.amount = amount;
        this.category = category;
    }


    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new ExpenseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        holder.category.setText(String.valueOf(category.get(position)));
        holder.amount.setText(String.valueOf(amount.get(position)));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView category,amount;
        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.textname);
            amount = itemView.findViewById(R.id.textamount);

        }
    }


}
