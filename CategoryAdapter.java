package com.example.retrofitimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<TestModel.Category> CategoryList;
    Context ctx;

    public CategoryAdapter(ArrayList<TestModel.Category> categoryList, Context ctx) {
        CategoryList = categoryList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(ctx).inflate(R.layout.row_category,parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemViewHolder itemView = (ItemViewHolder) holder;

        TestModel.Category CurrentCategoty = CategoryList.get(position);

        itemView.tvCatId.setText("Category Id : " + CurrentCategoty.CatId);
        itemView.tvCatName.setText("Category Name : " + CurrentCategoty.CategoryName);

        String icon = CurrentCategoty.Icon;

        Glide.with(ctx).load(icon).into(itemView.ivCategory);
    }

    @Override
    public int getItemCount() {
        return CategoryList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView ivCategory;
        TextView tvCatId, tvCatName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCategory = itemView.findViewById(R.id.ivCategory);
            tvCatId = itemView.findViewById(R.id.tvCatId);
            tvCatName = itemView.findViewById(R.id.tvCatName);
        }
    }
}
