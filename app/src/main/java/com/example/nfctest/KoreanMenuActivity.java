package com.example.nfctest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 상헌 on 2016-07-23.
 */
public class KoreanMenuActivity extends Activity {
    ListView listView;
    int finalCost = 20000;

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

        items.add("감자옹심이");
        items.add("콧등치기");
        items.add("황기닭백숙");
        items.add("한정식");

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
            TextView textView = (TextView) v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            //잔액


            // ImageView 인스턴스
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            ImageView upimage = (ImageView) v.findViewById(R.id.upimage);
            TextView priceView = (TextView) v.findViewById(R.id.price);
            TextView detailView = (TextView) v.findViewById(R.id.detail);


            // 리스트뷰의 아이템에 이미지를 변경한다.

            if ("감자옹심이".equals(items.get(position))) {
                upimage.setImageResource(R.drawable.up);
                imageView.setImageResource(R.drawable.menu1);
                priceView.setText("8000 Won");

                detailView.setText("♥ 16");

            } else if ("콧등치기".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu2);
                priceView.setText("10000 Won");
                detailView.setText("♥ 43");

            } else if ("황기닭백숙".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu3);
                priceView.setText("20000 Won");
                detailView.setText("♥ 30");

            } else if ("한정식".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.menu4);
                priceView.setText("12000 Won");
                detailView.setText("♥ 7");

            } else {
            }


            final String text = items.get(position);
            ImageButton button = (ImageButton) v.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if ("감자옹심이".equals(text)) {
                        if (finalCost - 8000 >= 0) {
                            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(KoreanMenuActivity.this); // 빌더 객체 생성
                            alertBuilder.setTitle("주문확인") // 제목
                                    .setMessage("감자옹심이를 주문하시겠습니까?\n현재 잔액:"+finalCost) // 내용
                                    .setCancelable(false) // 뭐지?

                                    .setPositiveButton("Yes",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                    finalCost = finalCost - 8000;
                                                    Toast.makeText(KoreanMenuActivity.this, "감자옹심이 주문 완료되었습니다. 잔액:" + finalCost, Toast.LENGTH_SHORT).show();
                                                }


                                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();  // 대회상자 종료
                                }
                            })
                                    .show();


                            //      finalCost=finalCost-8000;
                            //      Toast.makeText(KoreanMenuActivity.this, "감자옹심이 주문 완료되었습니다. 잔액:"+finalCost, Toast.LENGTH_SHORT).show();

                        } else
                            Toast.makeText(KoreanMenuActivity.this, "잔액이 부족합니다. 현재잔액 : " + finalCost, Toast.LENGTH_SHORT).show();
                    } else if ("콧등치기".equals(text)) {
                        if (finalCost - 10000 >= 0) {
                            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(KoreanMenuActivity.this); // 빌더 객체 생성
                            alertBuilder.setTitle("주문확인") // 제목
                                    .setMessage("콧등치기를 주문하시겠습니까?\n현재 잔액:"+finalCost) // 내용
                                    .setCancelable(false) // 뭐지?

                                    .setPositiveButton("Yes",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                    finalCost = finalCost - 10000;
                                                    Toast.makeText(KoreanMenuActivity.this, "콧등치기가 주문 완료되었습니다. 잔액:" + finalCost, Toast.LENGTH_SHORT).show();
                                                }


                                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();  // 대회상자 종료
                                }
                            })
                                    .show();

                        } else
                            Toast.makeText(KoreanMenuActivity.this, "잔액이 부족합니다. 현재잔액 : " + finalCost, Toast.LENGTH_SHORT).show();
                    } else if ("황기닭백숙".equals(text)) {
                        if (finalCost - 20000 >=0) {
                            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(KoreanMenuActivity.this); // 빌더 객체 생성
                            alertBuilder.setTitle("주문확인") // 제목
                                    .setMessage("황기닭백숙을 주문하시겠습니까?\n현재 잔액:"+finalCost) // 내용
                                    .setCancelable(false) // 뭐지?

                                    .setPositiveButton("Yes",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                    finalCost = finalCost - 20000;
                                                    Toast.makeText(KoreanMenuActivity.this, "황기닭백숙이 주문 완료되었습니다. 잔액:" + finalCost, Toast.LENGTH_SHORT).show();
                                                }


                                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();  // 대회상자 종료
                                }
                            })
                                    .show();

                        } else
                            Toast.makeText(KoreanMenuActivity.this, "잔액이 부족합니다. 현재잔액 : " + finalCost, Toast.LENGTH_SHORT).show();

                    } else if ("한정식".equals(text)) {
                        if (finalCost - 12000 >= 0) {
                            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(KoreanMenuActivity.this); // 빌더 객체 생성
                            alertBuilder.setTitle("주문확인") // 제목
                                    .setMessage("한정식을 주문하시겠습니까?\n현재 잔액:"+finalCost) // 내용
                                    .setCancelable(false) // 뭐지?

                                    .setPositiveButton("Yes",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int whichButton) {
                                                    finalCost = finalCost - 12000;
                                                    Toast.makeText(KoreanMenuActivity.this, "한정식이 주문 완료되었습니다. 잔액:" + finalCost, Toast.LENGTH_SHORT).show();
                                                }


                                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();  // 대회상자 종료
                                }
                            })
                                    .show();

                        } else
                            Toast.makeText(KoreanMenuActivity.this, "잔액이 부족합니다. 현재잔액 : " + finalCost, Toast.LENGTH_SHORT).show();
                    }
                    Log.i("NowCost", "" + finalCost);
                }
            });

            return v;
        }
    }

}
