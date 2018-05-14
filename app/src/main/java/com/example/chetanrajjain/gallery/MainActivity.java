package com.example.chetanrajjain.gallery;

import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Bitmap>>{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageAdapter imageAdapter;
    GetFilesFolder getFiles;
    ArrayList<Bitmap> arrayList = new ArrayList<>();
    File cameradirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      getLoaderManager().initLoader(0,null,this);


    }


    @Override
    public Loader<ArrayList<Bitmap>> onCreateLoader(int id, Bundle args) {
        return new GetImageFiles(this);

    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Bitmap>> loader, ArrayList<Bitmap> data) {
        this.arrayList = data;
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Bitmap>> loader) {

    }
}
