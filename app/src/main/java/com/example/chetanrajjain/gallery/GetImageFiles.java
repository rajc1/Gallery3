package com.example.chetanrajjain.gallery;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.ArrayList;

class GetImageFiles extends AsyncTaskLoader<ArrayList<Bitmap>> {
    ArrayList<Bitmap> images =  new ArrayList<>();
    File root;

    public GetImageFiles(Context context) {
        super(context);
        root = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());



    }


    public void walk(File f){
        File[] rootlist = f.listFiles();

        for (File eachfile : rootlist) {
            Log.i("image name",eachfile.toString());
            if (eachfile.isDirectory()) {

                walk(eachfile);

            } else if (eachfile.isFile() && (eachfile.toString().contains("jpg"))) {
                Log.i("image name",eachfile.toString());
                    Bitmap bitmap = BitmapFactory.decodeFile(eachfile.getPath());
                    images.add(bitmap);




            }
        }



    }

    @Override
    public ArrayList<Bitmap> loadInBackground() {
        walk(root);
        return images;
    }


}
