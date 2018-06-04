package net.chabibnr.latihan.Models;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PackageModel {

    Context mContext;

    private String id;
    private Drawable icon;
    private String version;
    private String name;

    public PackageModel(Context m){
        mContext = m;
    }

    public PackageModel(String id, String name, Drawable icon){
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    public ArrayList<PackageModel> all(){
        ArrayList<PackageModel> packageModels = new ArrayList<PackageModel>();
        final PackageManager pm = mContext.getPackageManager();
        Intent main = new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> packages = pm.queryIntentActivities(main, 0);

        ArrayList<String> app_name_list = new ArrayList<String>();
        ArrayList<String> app_package_list = new ArrayList<String>();
        for(ResolveInfo resolve_info : packages) {
            try {
                String package_name = resolve_info.activityInfo.packageName;
                ApplicationInfo ai = pm.getApplicationInfo(package_name, PackageManager.GET_META_DATA);
                String app_name = (String)pm.getApplicationLabel(ai);
                Drawable icon = pm.getApplicationIcon(ai);
                boolean same = false;
                for(int i = 0 ; i < app_name_list.size() ; i++) {
                    if(package_name.equals(app_package_list.get(i)))
                        same = true;
                }
                if(!same) {
                    app_name_list.add(app_name);
                    app_package_list.add(package_name);
                }

                packageModels.add(new PackageModel(package_name, app_name, icon));
            } catch(Exception e) { }
        }


        return packageModels;
    }
}
