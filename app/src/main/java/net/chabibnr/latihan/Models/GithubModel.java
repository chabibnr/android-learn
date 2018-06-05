package net.chabibnr.latihan.Models;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class GithubModel {

    Context mContext;

    private String id;
    private Drawable icon;
    private Bitmap iconBitmap;
    private String version;
    private String name;

    public GithubModel(Context m){
        mContext = m;
    }

    public GithubModel(String id, String name, Drawable icon){
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public GithubModel(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
