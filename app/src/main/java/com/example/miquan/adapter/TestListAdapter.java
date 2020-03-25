package com.example.miquan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miquan.R;
import com.example.miquan.entry.ReciveData;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class TestListAdapter extends BaseAdapter {
    private List<ReciveData.PhotoData> mDatas;

    public TestListAdapter(List<ReciveData.PhotoData> datas) {
        mDatas = datas;

    }

    @Override
    public int getCount() {
        if (mDatas == null) return 0;
        return mDatas.size();
    }

    @Override
    public ReciveData.PhotoData getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_test, null, true);
        ImageView imageView = rootview.findViewById(R.id.item_imageview);
        TextView textView = rootview.findViewById(R.id.item_textview);
        textView.setText(getItem(position).productName);
        ImageLoader.getInstance().displayImage(getItem(position).productCover, imageView);

        return rootview;
    }


}
