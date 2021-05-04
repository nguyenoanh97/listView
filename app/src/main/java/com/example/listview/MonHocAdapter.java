package com.example.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            // ánh xạ view
            holder.txtTen = (TextView) convertView.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textviewMoTa);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageHinh);
            convertView.setTag(holder);


        }else{
            holder = (ViewHolder) convertView.getTag();
        }



        // gán giá trị
        MonHoc monhoc = monHocList.get(position);
        holder.txtTen.setText(monhoc.getTen());
        holder.txtMoTa.setText(monhoc.getMoTa());
        holder.imgHinh.setImageResource(monhoc.getHinh());


        return convertView;
    }
}
