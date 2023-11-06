package com.example.moneyminder;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

public class ExpenseViewHolder extends RecyclerView.ViewHolder {
    TextView amount;
    TextView category;
    View view;

    ExpenseViewHolder(View itemView){
        super(itemView);
        category = itemView.findViewById(R.id.textname);
        amount = itemView.findViewById(R.id.textamount);
        view = itemView;

    }

}
