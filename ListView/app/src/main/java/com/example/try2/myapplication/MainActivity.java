package com.example.try2.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[][] data = {
            {"1","臺北市"},
            {"2","信義區"},
            {"1","新北市"},
            {"2","板橋區"},
            {"1","桃園市"},
            {"2","桃園區"},
            {"1","臺中市"},
            {"2","西屯區"},
            {"1","臺南市"},
            {"2","安平區"},
            {"2","新營區"},
            {"1","高雄市"},
            {"2","苓雅區"},
            {"2","鳳山區"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listview);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewAdapter adapter = new ViewAdapter(data,inflater);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onClickListView);       //指定事件 Method

    }

    /***
     * 點擊ListView事件Method
     */
    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"點選第 "+(position +1) +" 個 \n內容："+data[position][1], Toast.LENGTH_SHORT).show();
        }

    };

}
