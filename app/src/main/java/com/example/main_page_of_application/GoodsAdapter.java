package com.example.main_page_of_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GoodsAdapter extends RecyclerView.Adapter<CreateValueOfElementOfListGoods> {
    private  static int viewHolderCount;
    private int numberItems;
    private Array_of_goods myListGoods = new Array_of_goods();

    public GoodsAdapter(Array_of_goods myListGoods) {
        this.myListGoods = myListGoods;
        this.numberItems = myListGoods.goods.size();
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public CreateValueOfElementOfListGoods onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListGoods = R.layout.list_of_goods_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListGoods, parent, false);
        CreateValueOfElementOfListGoods myViewHolder = new CreateValueOfElementOfListGoods(view);

        myViewHolder.WriteValues_into_product(myListGoods.goods.get(viewHolderCount), context);
        viewHolderCount++;

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreateValueOfElementOfListGoods holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }
}
