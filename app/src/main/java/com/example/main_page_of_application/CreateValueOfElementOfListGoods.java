package com.example.main_page_of_application;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class CreateValueOfElementOfListGoods extends RecyclerView.ViewHolder {
    ImageView ImageProduct;
    TextView NameProduct;
    TextView PriceProduct;

    public CreateValueOfElementOfListGoods(View itemView) {
        super(itemView);

        ImageProduct = itemView.findViewById(R.id.ImageProduct_id);
        NameProduct = itemView.findViewById(R.id.NameProduct_id);
        PriceProduct = itemView.findViewById(R.id.PriceProduct_id);
    }


    public void WriteValues_into_product(ProductStructure my_productStructure, Context myCTX) {
        my_productStructure.Create_ready_url_image();
        Picasso.with(myCTX)
                .load(my_productStructure.readyURLimage)
                .placeholder(R.drawable.ic_load_image_picasso)
                .error(R.drawable.ic_error_loading_image_picasso)
                .resize(142, 110).centerCrop()
                .into(ImageProduct);

        NameProduct.setText(my_productStructure.name);
        PriceProduct.setText(String.valueOf(my_productStructure.price));
    }

}
