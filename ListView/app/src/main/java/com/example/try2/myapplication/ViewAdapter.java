package com.example.try2.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ViewAdapter extends BaseAdapter {


    private String[][] ElementsData ;   //資料
    private LayoutInflater inflater;    //加載layout
    private int indentionBase;          //item缩排

    //優化Listview 避免重新加載
    //這邊宣告你會動到的Item元件
    static class ViewHolder{
        LinearLayout rlBorder;
        TextView Name;
        TextView Local;
        //   EditText Num;
    }

    //初始化
    public ViewAdapter(String[][] data, LayoutInflater inflater){
        this.ElementsData = data;
        this.inflater = inflater;
        indentionBase = 100;
    }

    //取得數量
    @Override
    public int getCount() {
        return ElementsData.length;
    }
    //取得Item
    @Override
    public Object getItem(int position) {
        return ElementsData[position];
    }
    //此範例沒有特別設計ID所以隨便回傳一個值
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.style, null);
            holder.Name = (TextView) convertView.findViewById(R.id.tvName);
            holder.Local = (TextView) convertView.findViewById(R.id.tvLocal);
            //  holder.Num = (EditText) convertView.findViewById(R.id.number);
            holder.rlBorder = (LinearLayout) convertView.findViewById(R.id.llBorder);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //1=都市 2=政府所在地
        //不同類型用不同Style的表現方式
        if (ElementsData[position][0].equals("1")){
            holder.Local.setText("★");
            holder.Name.setText(ElementsData[position][1]);
            holder.Name.setTextColor(Color.rgb(255,0,255));
            holder.rlBorder.setBackgroundColor(Color.parseColor("#FFDBC9"));


        }else{
            holder.Local.setText("");
            holder.Name.setText(ElementsData[position][1]);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.rlBorder.getLayoutParams();
            lp.setMargins(indentionBase,0, -400,0);//縮牌
        }
        return convertView;
    }
}