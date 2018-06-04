package net.chabibnr.latihan;

import android.content.Context;
import android.util.JsonReader;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    Context mContext;
    private ArrayList<Item> data = new ArrayList<Item>();

    public Model(Context c){
        mContext = c;
    }

    public Model add(String title, String desc, Class<?> c){
        data.add(createItem(title, desc, c));
        return this;
    }

    public Item createItem(String title, String desc, Class<?> c){
        return new Item(title, desc, c);
    }

    public Item get(int position){
        return getData().get(position);
    }

    public ArrayList<Item> getData() {
        return data;
    }

    public class Item{
        private String mTitle;
        private String mDesctiption;
        private Class<?> mClass;

        public Item(String title, String desc, Class<?> c){
            mTitle = title;
            mClass = c;
            mDesctiption = desc;
        }

        public String getTitle(){
            return mTitle;
        }

        public String getDescription(){
            return mDesctiption;
        }

        public Class<?> getMainClass(){
            return mClass;
        }
    }
}
