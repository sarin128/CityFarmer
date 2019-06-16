package com.example.yaesl.cityfarmer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private Map allData;
    private ArrayList<ContractorData> listData;
    private ListView lv;
    private DBControll dbControll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.garden_list);

        allData = new TreeMap<Integer,ContractorData>();
        listData = new ArrayList<ContractorData>();
        listData.addAll(allData.values());
        adapter = new CustomAdapter(this,0,listData);
        lv.setAdapter(adapter);
        dbControll = new DBControll(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        allData = dbControll.SelectData();
        adapter.addAll(allData.values());
    }



    private class CustomAdapter extends ArrayAdapter<ContractorData>{
        private ArrayList<ContractorData> items;
        public CustomAdapter(Context context, int textViewResourceId, ArrayList<ContractorData> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.custumviewitem, null);
            }

            ImageView imageView = (ImageView)v.findViewById(R.id.imgView);
            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position).getName());
            Button btn = (Button)v.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),KitchenGarden_Info.class);
                    intent.putExtra("Id",items.get(position).getId());
                    startActivity(intent);
                }
            });
            return v;
        }
    }
}
