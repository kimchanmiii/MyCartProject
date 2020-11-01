package com.example.mycartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent(); //intent 받기

        //애플워치6 장바구니 넣기
        TextView name6 = (TextView) findViewById(R.id.firstTV_name);
        TextView price6 = (TextView) findViewById(R.id.firstTV_price);


        String nameProduct6 = intent.getStringExtra("Name6");
        String priceProduct6 = intent.getStringExtra("Price6");

        name6.setText(nameProduct6);
        price6.setText(priceProduct6);

        //애플워치se 장바구니 넣기
        TextView nameSE = (TextView) findViewById(R.id.secondTV_name);
        TextView priceSE = (TextView) findViewById(R.id.secondTV_price);

        String nameProductSE = intent.getStringExtra("NameSE");
        String priceProductSE = intent.getStringExtra("PriceSE");

        nameSE.setText(nameProductSE);
        priceSE.setText(priceProductSE);

        //애플워치3 장바구니 넣기
        TextView name3 = (TextView) findViewById(R.id.thirdTV_name);
        TextView price3 = (TextView) findViewById(R.id.thirdTV_price);

        String nameProduct3 = intent.getStringExtra("Name3");
        String priceProduct3 = intent.getStringExtra("Price3");

        name3.setText(nameProduct3);
        price3.setText(priceProduct3);

        //아무것도 담기지 않았을 때
        TextView nothing = (TextView) findViewById(R.id.nothing_TV);

        String noProduct = intent.getStringExtra("Nothing");

        nothing.setText(noProduct);

        //상품이 선택 안되었을때 체크박스 안보이게 만들기
        CheckBox chk6 = (CheckBox) findViewById(R.id.chk_6);
        CheckBox chkse = (CheckBox) findViewById(R.id.chk_se);
        CheckBox chk3 = (CheckBox) findViewById(R.id.chk_3);
        if(nameProduct6 == null) {
            chk6.setVisibility(android.view.View.INVISIBLE);
        }
        if(nameProductSE == null) {
            chkse.setVisibility(android.view.View.INVISIBLE);
        }
        if(nameProduct3 == null) {
            chk3.setVisibility(android.view.View.INVISIBLE);
        }

        //홈화면 돌아가기
        Button homeButton = (Button) findViewById(R.id.home);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //결제창 넘어가기
        Button order = (Button) findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {

            final CheckBox chk6 = (CheckBox) findViewById(R.id.chk_6);
            final CheckBox chkse = (CheckBox) findViewById(R.id.chk_se);
            final CheckBox chk3 = (CheckBox) findViewById(R.id.chk_3);

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);

                if(chk6.isChecked()) {
                    intent.putExtra("Name6", "애플워치 6");
                    intent.putExtra("Price6", "539,000 원");
                }

                if(chkse.isChecked()) {
                    intent.putExtra("NameSE", "애플워치 SE");
                    intent.putExtra("PriceSE", "359,000 원");
                }

                if(chk3.isChecked()) {
                    intent.putExtra("Name3", "애플워치 3");
                    intent.putExtra("Price3", "259,000 원");
                }

                if(!chk6.isChecked() && !chkse.isChecked() && !chk3.isChecked()) {
                    intent.putExtra("Nothing", "결제할 상품이 없습니다.");
                }

                startActivity(intent);

                //돌아왔을 때 체크박스가 선택되어 있지 않도록 설정
                chk6.setChecked(false);
                chkse.setChecked(false);
                chk3.setChecked(false);
            }
        });

    }
}