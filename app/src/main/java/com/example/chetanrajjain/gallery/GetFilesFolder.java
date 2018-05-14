package com.example.chetanrajjain.gallery;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class GetFilesFolder  extends AsyncTaskLoader<ArrayList<File>>{
    private ArrayList<Bitmap> arrayList= new ArrayList<>();
    private File root;
    private Activity activity;
    File file;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public GetFilesFolder(File root, Activity activity) {
        super(activity);

        this.root = root;
        walk(root);
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void walk(File root){
        File[] f = root.listFiles();


        for (File eachfile : f){

            if(eachfile.isDirectory()){

                walk(eachfile);

            }
            else if(eachfile.isFile()){
                    if(eachfile.toString().contains("jpg")){
                        Bitmap bitmap = BitmapFactory.decodeFile(eachfile.toString());
                        Log.i("bitmap value", String.valueOf(bitmap));

                        arrayList.add(bitmap);

                        Log.i("file folder name", String.valueOf(arrayList.size()));

                    }



            }


        }




    }


    @Override
    public ArrayList<File> loadInBackground() {
        return null;
    }
}
