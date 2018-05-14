package com.example.chetanrajjain.gallery;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.simpleviewholder> {


        ArrayList<Bitmap> data;
        ImageView showimage;
        Activity activity;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ImageAdapter(ArrayList<Bitmap> data, Activity activity) throws IOException {
        this.data = data;
        this.activity = (Activity) activity;
    }
    @NonNull
    @Override
    public simpleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.each_image,parent,false);

        return new simpleviewholder(v);
    }

    @Override
    public void onBindViewHolder(final simpleviewholder holder, int position) {
        final Bitmap item = data.get(position);
        Log.i("item",String.valueOf(item));
        holder.imageView.setImageBitmap(item);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                item.compress(Bitmap.CompressFormat.JPEG,400,stream);
                byte[] bytearray = stream.toByteArray();
                Intent intent = new Intent(activity,Main2Activity.class);
                intent.putExtra("picture",bytearray);
                activity.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


public class simpleviewholder extends RecyclerView.ViewHolder{

     ImageView imageView;
    public simpleviewholder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.each_image_view);
    }
}
}
