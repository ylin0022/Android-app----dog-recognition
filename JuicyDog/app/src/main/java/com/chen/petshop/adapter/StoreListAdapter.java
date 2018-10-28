package com.chen.petshop.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chen.petshop.R;
import com.chen.petshop.domain.StoreBean;
import com.chen.petshop.util.PointMapUtil;

import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/24
 */

public class StoreListAdapter extends BaseAdapter {

    private Context context;
    private PopupWindow popupWindow;
    private View contentView;
    private List<StoreBean> list;

    public StoreListAdapter(Context context, List<StoreBean> list) {
        this.context = context;
        this.list = list;
        showPopwindow();
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
            convertView = View.inflate(context, R.layout.item_store, null);
            holder = new Holder();
            holder.name = convertView.findViewById(R.id.item_store_name);
            holder.locataion = convertView.findViewById(R.id.item_store_location);
            holder.btn = convertView.findViewById(R.id.item_store_btn);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        StoreBean dogBean = list.get(position);
        holder.name.setText(dogBean.getName());
        holder.locataion.setText(dogBean.getAddress());

        holder.btn.setOnClickListener(v -> {
            contentView.findViewById(R.id.pop_baidu).setOnClickListener(v3 -> PointMapUtil.openBaiduMap(context, dogBean));
            contentView.findViewById(R.id.pop_gaode).setOnClickListener(v1 -> PointMapUtil.openGaoDeMap(context, dogBean));
            contentView.findViewById(R.id.pop_google).setOnClickListener(v2 -> PointMapUtil.openGoogleMap(context, dogBean));
            popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
        });

        return convertView;
    }

    public class Holder {
        TextView name;
        TextView locataion;
        Button btn;
    }

    /**
     * 显示popupWindow
     */
    private void showPopwindow() {
        //加载弹出框的布局
        contentView = LayoutInflater.from(context).inflate(
                R.layout.pop, null);


        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        //进入退出的动画，指定刚才定义的style
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 按下android回退物理键 PopipWindow消失解决

        contentView.findViewById(R.id.pop_cancel).setOnClickListener(v -> popupWindow.dismiss());
    }

    public void canclePop() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
