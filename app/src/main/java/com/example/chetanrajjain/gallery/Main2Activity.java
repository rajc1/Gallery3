package com.example.chetanrajjain.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image);

        Bundle extra = getIntent().getExtras();
        byte[] array = extra.getByteArray("picture");
        Bitmap bitmap = BitmapFactory.decodeByteArray(array,0,array.length);
        imageView = (ImageView)findViewById(R.id.show_image);
        imageView.setImageBitmap(bitmap);



    }
}
