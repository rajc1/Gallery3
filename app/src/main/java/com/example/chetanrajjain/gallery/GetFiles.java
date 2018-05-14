package com.example.chetanrajjain.gallery;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.net.FileNameMap;

import java.io.File;
import java.util.ArrayList;

import static java.nio.file.Files.probeContentType;

public class GetFiles extends AsyncTaskLoader<ArrayList<Bitmap>> {
    ArrayList<Bitmap> images;
    File f;
    FileNameMap fileNameMap;
    public GetFiles(Context context, File f1) {
        super(context);
        this.f = f1;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void walk(File f1) {

        File[] list = f1.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {
                Log.i("image",String.valueOf(f));
                walk(f);
            }
            else if(f.isFile()){
                    String mimetype = fileNameMap.getContentTypeFor(f.getName());
                    Log.i("file type",mimetype);
                if(f.toString().contains("jpg")) {
                    Bitmap bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                    images.add(bitmap);
                    Log.i("image",String.valueOf(bitmap));
                }
            }

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public ArrayList<Bitmap> loadInBackground() {
        walk(f);
        return images;
    }
}
