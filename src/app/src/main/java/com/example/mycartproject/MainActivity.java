package com.example.mycartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox chk6 = (CheckBox) findViewById(R.id.chk_6);
        final CheckBox chkse = (CheckBox) findViewById(R.id.chk_se);
        final CheckBox chk3 = (CheckBox) findViewById(R.id.chk_3);

        Button cart_total = (Button) findViewById(R.id.cart_total);
        Button buy_total = (Button) findViewById(R.id.buy_total);

        //상품 선택 페이지에서 장바구니 버튼 눌렀을 때 작동
        cart_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Cart.class); //장바구니 액티비티로 이동

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

                //체크박스가 아무것도 선택되지 않았을 때
                if(!chk6.isChecked() && !chkse.isChecked() && !chk3.isChecked()) {
                    intent.putExtra("Nothing", "장바구니에 담긴 상품이 없습니다.");
                }

                startActivity(intent); //액티비티 이동

                //돌아왔을 때 체크박스가 선택되어 있지 않도록 설정
                chk6.setChecked(false);
                chkse.setChecked(false);
                chk3.setChecked(false);
            }
        });

        //상품 선택 페이지에서 바로구매 버튼 눌렀을 때 작동
        buy_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Payment.class); //결제 액티비티로 이동

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

                startActivity(intent); //액티비티 이동

                //돌아왔을 때 체크박스가 선택되어 있지 않도록 설정
                chk6.setChecked(false);
                chkse.setChecked(false);
                chk3.setChecked(false);
            }
        });

    }
}