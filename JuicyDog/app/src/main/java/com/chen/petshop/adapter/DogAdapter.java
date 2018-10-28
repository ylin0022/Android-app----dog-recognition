package com.chen.petshop.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chen.petshop.R;
import com.chen.petshop.constant.StoreConst;
import com.chen.petshop.domain.DogBean;

import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/24
 */

public class DogAdapter extends BaseAdapter {

    private Context context;

    private List<DogBean> list = StoreConst.DOGS;

    public DogAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list, null);
            holder = new Holder();
            holder.img = convertView.findViewById(R.id.item_img);
            holder.name = convertView.findViewById(R.id.item_name);
            holder.count = convertView.findViewById(R.id.item_count);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        DogBean dogBean = list.get(position);
        holder.name.setText(dogBean.getName());
        holder.count.setText("Count: " + dogBean.getCount());
        Glide.with(context)
                .load(dogBean.getImgRes())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
        return convertView;
    }

    public class Holder {
        ImageView img;
        TextView name;
        TextView count;
    }
}
