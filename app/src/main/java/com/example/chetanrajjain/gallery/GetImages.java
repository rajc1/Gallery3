package com.example.chetanrajjain.gallery;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class GetImages {
    ArrayList<Bitmap> images = new ArrayList<Bitmap>();

    File cameradirectory;
    public GetImages() {




    }


    public ArrayList<Bitmap> walk(File f1) {

            File[] list = f1.listFiles();

            for (File f : list) {
                if (f.isDirectory()) {
                    Log.d("", "Dir: " + f.getAbsoluteFile());
                    Log.i("image",String.valueOf(f));
                    walk(f);
                }
                else if(f.isFile()){
                    if(f.toString().contains(".jpg")) {
                        Bitmap bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                        images.add(bitmap);
                        Log.i("image",String.valueOf(bitmap));
                    }
                }
            }
        return  images;
    }


}
