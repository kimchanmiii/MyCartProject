package com.example.mycartproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();

        //애플워치6 결제화면
        TextView name6 = (TextView) findViewById(R.id.firstTV_name);
        TextView price6 = (TextView) findViewById(R.id.firstTV_price);

        String nameProduct6 = intent.getStringExtra("Name6");
        String priceProduct6 = intent.getStringExtra("Price6");

        name6.setText(nameProduct6);
        price6.setText(priceProduct6);

        //애플워치se 결제화면
        TextView nameSE = (TextView) findViewById(R.id.secondTV_name);
        TextView priceSE = (TextView) findViewById(R.id.secondTV_price);

        String nameProductSE = intent.getStringExtra("NameSE");
        String priceProductSE = intent.getStringExtra("PriceSE");

        nameSE.setText(nameProductSE);
        priceSE.setText(priceProductSE);

        //애플워치3 결제화면
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

        //결제 총합 계산하기
        int totalPrice = 0;
        if(nameProduct6 != null) {
            totalPrice += 539000;
        }
        if(nameProductSE != null) {
            totalPrice += 359000;
        }
        if(nameProduct3 != null) {
            totalPrice += 259000;
        }

        TextView total = (TextView) findViewById(R.id.price_total);

        //금액대 별로 나눠서 출력하기
        if(totalPrice >= 1000000) {
            total.setText((totalPrice/1000)/1000 + "," + (totalPrice/1000)%1000 + "," + totalPrice%1000 + "00 원");
        }
        else if(totalPrice < 1000) {
            total.setText(totalPrice + " 원");
        }
        else {
            total.setText(totalPrice/1000 + "," + totalPrice%1000 + "00 원");
        }

        //팝업창 띄우기
        Button finish = (Button) findViewById(R.id.finish);

        final int finalTotalPrice = totalPrice;

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText_address = (EditText) findViewById(R.id.ET_address);
                EditText editText_phone = (EditText) findViewById(R.id.ET_phone);

                AlertDialog.Builder ad = new AlertDialog.Builder(Payment.this);

                //주문정보 혹은 연락처정보가 입력되지 않았을 때
                if(editText_address.getText().length() == 0 || editText_phone.getText().length() == 0) {
                    ad.setIcon(R.drawable.ic_baseline_pan_tool_24);
                    ad.setTitle("한번 더 확인해주세요!");
                    ad.setMessage("아무것도 입력되지 않았습니다.");

                    //확인을 누르면 원래 화면으로 돌아간다
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                //결제할 상품이 아무것도 없을 때
                else if(finalTotalPrice == 0) {
                    ad.setIcon(R.drawable.ic_baseline_pan_tool_24);
                    ad.setTitle("한번 더 확인해주세요!");
                    ad.setMessage("결제할 상품이 없습니다.");

                    //확인을 누르면 원래 화면으로 돌아간다
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                else {
                    ad.setIcon(R.drawable.ic_baseline_pan_tool_24);
                    ad.setTitle("한번 더 확인해주세요!");
                    ad.setMessage("입력하신 정보로 결제 진행 하시겠습니까?\n확인을 누르시면 처음 화면으로 돌아갑니다.");

                    //확인을 눌렀을 때 홈 화면으로 돌아간다
                    ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                            intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //스택 중간에 있었던 액티비티들을 지우는 역할
                            intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); //띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다는 의미
                            startActivity(intentHome);
                        }
                    });

                    //취소 눌렀을 때 팝업창이 없어진다
                    ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                ad.show();
            }
        });

        //홈화면 돌아가기
        Button homeButton = (Button) findViewById(R.id.home);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch(id) {
                    case R.id.home:
                        Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                        intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //스택 중간에 있었던 액티비티들을 지우는 역할
                        intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); //띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다는 의미
                        startActivity(intentHome);
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}