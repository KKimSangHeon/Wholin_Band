package com.example.nfctest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 상헌 on 2016-07-23.
 */
public class AmericanMenuActivity extends Activity {
    ListView listView;
    int finalCost=0;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) this.findViewById(R.id.listView);

        ArrayList<String> items = new ArrayList<>();

        items.add("Картопля ongsim");
        items.add("ніс інсульт");
        items.add("Астрагал курка baeksuk");
        items.add("Hanjeongsik");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        listView.setAdapter(adapter);
    }

    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.listviewitem, null);
            }


            //음식 종류 쓰기
            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            // ImageView 인스턴스
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            ImageView upimage = (ImageView) v.findViewById(R.id.upimage);
            TextView priceView=(TextView)v.findViewById(R.id.price);
            TextView detailView=(TextView)v.findViewById(R.id.detail);


            // 리스트뷰의 아이템에 이미지를 변경한다.

            if ("Картопля ongsim".equals(items.get(position))) {
                upimage.setImageResource(R.drawable.up);
                imageView.setImageResource(R.drawable.menu1);
                priceView.setText("8000 Won");

                detailView.setText("♥ 12");

            } else if ("ніс інсульт".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu2);
                priceView.setText("10000 Won");
                detailView.setText("♥ 3");

            } else if ("Астрагал курка baeksuk".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu3);
                priceView.setText("20000 Won");
                detailView.setText("♥ 4");

            } else if ("Hanjeongsik".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu4);
                priceView.setText("12000 Won");
                detailView.setText("♥ 6");

            }
            else
            {}






            final String text = items.get(position);
            ImageButton button = (ImageButton) v.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("Картопля ongsim".equals(text)) {
                        Toast.makeText(AmericanMenuActivity.this, text + " added "+8000, Toast.LENGTH_SHORT).show();
                        finalCost+=8000;
                    } else if ("ніс інсульт".equals(text)) {
                        Toast.makeText(AmericanMenuActivity.this, text + " added "+10000, Toast.LENGTH_SHORT).show();
                        finalCost+=10000;
                    } else if ("Астрагал курка baeksuk".equals(text)) {
                        Toast.makeText(AmericanMenuActivity.this, text + " added "+20000, Toast.LENGTH_SHORT).show();
                        finalCost+=20000;
                    } else if ("Hanjeongsik".equals(text)) {
                        Toast.makeText(AmericanMenuActivity.this, text + " added "+12000, Toast.LENGTH_SHORT).show();
                        finalCost+=12000;
                    }
                    Log.i("NowCost",""+finalCost);
                }
            });

            return v;
        }
    }

}
