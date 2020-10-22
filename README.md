# MyCartProject

20191574 김찬미   
국민대학교 모바일 프로그래밍 개인과제 보고서입니다.

## 목차
+ 1. 개요
    + 1.1 프로젝트 소개
    + 1.2 소스파일 설명
    + 1.3 개발 환경
  
+ 2. UI
    + 2.1 첫번째 화면 (Main)
    + 2.2 두번째 화면 (Cart)
    + 2.3 세번째 화면 (Payment)
  
+ 3. 구현 내용
    + 3.1 첫번째 화면 (Main)
    + 3.2 두번째 화면 (Cart)
    + 3.3 세번째 화면 (Payment)

## 1. 개요
### 1.1 프로젝트 소개

기본적인 장바구니 구현이다. 총 3개의 화면이 존재하는데 첫번째 화면은 상품을 고를 수 있는 상품 선택화면, 두번째 화면은 원하는 상품을 담을 수 있는 장바구니 화면, 세번째 화면은 선택한 상품을 구매하는 결제화면이다. 첫번째 화면에서 상품을 선택해서 장바구니 버튼을 누르면 두번째 화면으로, 구매하기 버튼을 누르면 세번째 화면으로 이동해야한다. 장바구니 버튼 또한 홈버튼을 누르면 첫번째 화면으로, 구매하기 버튼을 누르면 세번째 화면으로 이동해야한다. 마지막 세번째 화면 결제창에서는 구매자의 주소 및 연락처를 입력하도록 한다. 최종적으로 구매를 완료하면 홈 화면, 즉 첫번쨰 화면으로 이동한다. 

### 1.2 소스파일 설명

| 소스 파일명 | 역할 |
|---|---|
| MainActivity.java | 앱을 처음 실행했을 때 실행되는 액티비티이다. |
| Cart.java | 상품을 담은 장바구니 화면으로 넘어갔을 때 실행되는 액티비티이다. |
| Payment.java | 결제하는 화면으로 넘어갔을 때 실행되는 액티비티이다. |

### 1.3 개발 환경

+ Language: java
+ IDE: Android Studio

## 2. UI

| 레이아웃 파일명 | 연결 | 역할 |
| --- | --- | --- |
| activity_main.xml | MainActivity.java | 홈 화면을 디자인하고 메인 액티비티에 연결되는 레이아웃이다. |
| activity_cart.xml | Cart.java | 장바구니 화면을 디자인하고 두번째 액티비티에 연결되는 레이아웃이다. |
| activity_payment.xml | Payment.java | 결제 화면을 디자인하고 세번째 액티비티에 연결되는 레이아웃이다. |

### 2.1 첫번째 화면 (Main)

상품은 2개 이상 화면에 출력하고 각 상품의 제품명, 가격 정보를 표시한다.  
체크박스를 만들어 원하는 상품만 장바구니에 담을 수 있도록 한다.   
화면 하단에는 장바구니 버튼과 바로구매 버튼을 만들어 화면이 이동할 수 있도록 만든다.

<img src = "https://github.com/kimchanmiii/MyCartProject/blob/main/image/home.png" width="300" height="600">

**레이아웃 코드**   
메인 액티비티의 레이아웃은 RelativeLayout을 사용하여 그 밑에는 이미지, 텍스트, 버튼, 체크박스 등으로 디자인해주었다.   

```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#4F76EA"
            android:orientation="horizontal">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="110dp"
                android:text="상품 선택 페이지"
                android:textColor="#ffffff"
                android:textSize="25dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="170dp"
            android:background="#D2C2F6"
            android:orientation="horizontal">

            <CheckBox
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="60dp"
                android:id="@+id/chk_6"/>

            <ImageView
                android:layout_width="175dp"
                android:layout_height="165dp"
                android:layout_gravity="left"
                android:src="@drawable/applewatch6"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="170dp"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:text="애플워치 6 "
                    android:textColor="#000000"
                    android:textSize="25dp"
                    android:textStyle="bold"
                    android:layout_marginTop="40dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:text="539,000 원"
                    android:textColor="#000000"
                    android:textSize="20dp"
                    android:textStyle="bold"
                    android:layout_marginTop="20dp"/>

            </LinearLayout>

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="170dp"
            android:background="#F1D1FA"
            android:orientation="horizontal">

            <CheckBox
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="60dp"
                android:id="@+id/chk_se"/>

            <ImageView
                android:layout_width="175dp"
                android:layout_height="165dp"
                android:layout_gravity="left"
                android:src="@drawable/applewatchse"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="170dp"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:text="애플워치 SE"
                    android:textColor="#000000"
                    android:textSize="25dp"
                    android:textStyle="bold"
                    android:layout_marginTop="40dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:text="359,000 원"
                    android:textColor="#000000"
                    android:textSize="20dp"
                    android:textStyle="bold"
                    android:layout_marginTop="20dp"/>

            </LinearLayout>

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="170dp"
            android:background="#C6A6F3"
            android:orientation="horizontal">

            <CheckBox
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="60dp"
                android:id="@+id/chk_3"/>

            <ImageView
                android:layout_width="175dp"
                android:layout_height="165dp"
                android:layout_gravity="left"
                android:src="@drawable/applewatch3"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="170dp"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:text="애플워치 3"
                    android:textColor="#000000"
                    android:textSize="25dp"
                    android:textStyle="bold"
                    android:layout_marginTop="40dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    android:layout_marginTop="20dp"
                    android:text="259,000 원"
                    android:textColor="#000000"
                    android:textSize="20dp"
                    android:textStyle="bold"/>

            </LinearLayout>

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="170dp"
            android:background="#ECD6F8"
            android:orientation="horizontal">

            <TextView
                android:layout_width="300dp"
                android:layout_height="70dp"
                android:layout_gravity="center"
                android:layout_marginLeft="40dp"
                android:id="@+id/fourth_TV"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold"/>

        </LinearLayout>

    </LinearLayout>

    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="70dp"
        android:layout_alignParentBottom="true"
        android:layout_gravity="bottom"
        android:background="#ECD6F8"
        android:orientation="horizontal">

        <Button
            android:layout_width="150dp"
            android:layout_height="70dp"
            android:background="#6567D5"
            android:id="@+id/cart_total"
            android:drawableStart="@drawable/ic_baseline_shopping_cart_24"
            android:drawableLeft="@drawable/ic_baseline_shopping_cart_24"
            android:text="장바구니"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:textStyle="bold"
            android:layout_marginLeft="40dp"
            android:layout_marginRight="30dp"/>

        <Button
            android:layout_width="150dp"
            android:layout_height="70dp"
            android:background="#9974ED"
            android:id="@+id/buy_total"
            android:drawableStart="@drawable/ic_baseline_credit_card_24"
            android:drawableLeft="@drawable/ic_baseline_credit_card_24"
            android:text="바로 구매"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:textStyle="bold" />

    </LinearLayout>

</RelativeLayout>
```

### 2.2 두번째 화면 (Cart)

장바구니에는 추가된 상품의 상품명과 가격정보가 출력된다.   
체크박스를 만들어 원하는 상품만 결제할 수 있도록 설정한다.   
화면 하단에는 '홈' 버튼과 '결제하기' 버튼을 만들어 화면이 이동할 수 있도록 만든다.   

<img src = "https://github.com/kimchanmiii/MyCartProject/blob/main/image/cart.png" width="300" height="600">

**레이아웃 코드**   
Cart 액티비티의 레이아웃은 LinearLayout을 사용하여 그 밑에는 이미지, 텍스트, 버튼으로 디자인해주었다.   

```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Cart">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#6BE3F4D1"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#427A2E"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="10dp"
                android:text="장바구니"
                android:textColor="#ffffff"
                android:textSize="25dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:background="#6BE3F4D1"
            android:orientation="horizontal">

            <TextView
                android:layout_width="180dp"
                android:layout_height="30dp"
                android:layout_marginLeft="80dp"
                android:layout_marginTop="10dp"
                android:text="상품 정보"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="150dp"
                android:layout_height="30dp"
                android:layout_marginTop="10dp"
                android:text="주문 금액"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="vertical"
            android:background="#6BE3F4D1">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="20dp"
                android:text="_____________________________________________________________________________________________________"
                android:textColor="#000000"
                android:textSize="10dp"
                android:textStyle="bold"/>

            <TextView
                android:id="@+id/nothing_TV"
                android:layout_width="300dp"
                android:layout_height="25dp"
                android:layout_gravity="center"
                android:layout_marginLeft="10dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="italic" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="70dp"
            android:background="#6BE3F4D1"
            android:orientation="horizontal">

            <CheckBox
                android:id="@+id/chk_6"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="10dp" />

            <TextView
                android:id="@+id/firstTV_name"
                android:layout_width="180dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="5dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/firstTV_price"
                android:layout_width="150dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="20dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="70dp"
            android:background="#6BE3F4D1"
            android:orientation="horizontal">

            <CheckBox
                android:id="@+id/chk_se"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="10dp" />

            <TextView
                android:id="@+id/secondTV_name"
                android:layout_width="180dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="5dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/secondTV_price"
                android:layout_width="150dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="20dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="70dp"
            android:background="#6BE3F4D1"
            android:orientation="horizontal">

            <CheckBox
                android:id="@+id/chk_3"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_marginTop="10dp" />

            <TextView
                android:id="@+id/thirdTV_name"
                android:layout_width="180dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="5dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/thirdTV_price"
                android:layout_width="150dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="20dp"
                android:textColor="#000000"
                android:textSize="22dp"
                android:textStyle="bold" />

        </LinearLayout>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:text="_____________________________________________________________________________________________________"
            android:textColor="#000000"
            android:textSize="10dp"
            android:textStyle="bold"/>

    </LinearLayout>

    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="50dp"
        android:layout_alignParentBottom="true"
        android:layout_gravity="bottom"
        android:background="#6BE3F4D1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/home"
            android:layout_width="150dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            android:layout_marginLeft="40dp"
            android:layout_marginRight="30dp"
            android:background="#17511B"
            android:drawableStart="@drawable/ic_baseline_home_24"
            android:drawableLeft="@drawable/ic_baseline_home_24"
            android:text="홈"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:textStyle="bold" />

        <Button
            android:id="@+id/order"
            android:layout_width="170dp"
            android:layout_height="50dp"
            android:background="#2B3E0D"
            android:drawableStart="@drawable/ic_baseline_credit_card_24"
            android:drawableLeft="@drawable/ic_baseline_credit_card_24"
            android:text="주문하기"
            android:textColor="#ffffff"
            android:textSize="20dp"
            android:textStyle="bold" />

    </LinearLayout>

</RelativeLayout>
```

### 2.3 세번째 화면 (Payment)

결제 화면에서는 장바구니에서 넘어온 결제할 상품의 상품명과 가격정보가 출력된다.   
상품의 개수에 따라 총 결제 금액을 출력하도록 한다.   
화면 상단에는 '홈' 버튼을 만들어 화면이 이동할 수 있도록 만든다.   
구매자의 주소와 연락처를 입력해야만 결제를 진행할 수 있도록 한다.   
결제가 완료되면 첫 화면(홈)으로 돌아간다.  

<img src = "https://github.com/kimchanmiii/MyCartProject/blob/main/image/payment.png" width="300" height="600">

**레이아웃 코드**   
Payment 액티비티의 레이아웃은 GridLayout을 사용하여 그 밑에는 이미지, 텍스트, 버튼으로 디자인해주었다.   

```java
<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Payment">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ECE9EF"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#5A5B5E"
            android:orientation="horizontal">

            <Button
                android:id="@+id/home"
                android:layout_width="70dp"
                android:layout_height="40dp"
                android:layout_gravity="center"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="40dp"
                android:background="#37383E"
                android:drawableStart="@drawable/ic_baseline_home_24"
                android:drawableLeft="@drawable/ic_baseline_home_24"
                android:text="홈"
                android:textColor="#ffffff"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="60dp"
                android:text="결제"
                android:textColor="#ffffff"
                android:textSize="25dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="30dp"
            android:orientation="horizontal">

            <TextView
                android:layout_width="200dp"
                android:layout_height="50dp"
                android:layout_marginLeft="60dp"
                android:layout_marginTop="5dp"
                android:text="상품 정보"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_marginTop="5dp"
                android:text="주문 금액"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="20dp">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="20dp"
                android:text="_____________________________________________________________________________________________________"
                android:textColor="#000000"
                android:textSize="10dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="25dp"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/nothing_TV"
                android:layout_width="250dp"
                android:layout_height="25dp"
                android:layout_gravity="center"
                android:layout_marginLeft="100dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="italic" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/firstTV_name"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/firstTV_price"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/secondTV_name"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/secondTV_price"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/thirdTV_name"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/thirdTV_price"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:layout_gravity="center"
                android:layout_marginLeft="50dp"
                android:textColor="#000000"
                android:textSize="20dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="20dp"
                android:text="_____________________________________________________________________________________________________"
                android:textColor="#000000"
                android:textSize="10dp"
                android:textStyle="bold" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="60dp"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:layout_gravity="center"
                    android:layout_marginLeft="80dp"
                    android:layout_marginTop="15dp"
                    android:layout_marginBottom="10dp"
                    android:text="총 주문 금액 "
                    android:textSize="18dp"
                    android:textStyle="bold" />

                <TextView
                    android:id="@+id/price_total"
                    android:layout_width="150dp"
                    android:layout_height="40dp"
                    android:layout_marginLeft="20dp"
                    android:layout_marginTop="15dp"
                    android:layout_marginBottom="10dp"
                    android:textSize="25dp"
                    android:textStyle="bold" />

            </LinearLayout>

            <TextView
                android:layout_width="match_parent"
                android:layout_height="20dp"
                android:text="_____________________________________________________________________________________________________"
                android:textColor="#000000"
                android:textSize="10dp"
                android:textStyle="bold" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:orientation="vertical">

            <TextView
                android:layout_width="150dp"
                android:layout_height="30dp"
                android:layout_marginTop="5dp"
                android:text="주문 정보"
                android:textSize="20dp"
                android:textStyle="bold" />

            <EditText
                android:id="@+id/ET_address"
                android:layout_width="300dp"
                android:layout_height="wrap_content"
                android:layout_marginLeft="50dp"
                android:layout_marginTop="10dp"
                android:drawableStart="@drawable/ic_baseline_house_24"
                android:drawableLeft="@drawable/ic_baseline_house_24"
                android:hint="    주소를 입력하세요." />

            <EditText
                android:id="@+id/ET_phone"
                android:layout_width="300dp"
                android:layout_height="wrap_content"
                android:layout_marginLeft="50dp"
                android:layout_marginTop="10dp"
                android:digits="0123456789"
                android:drawableStart="@drawable/ic_baseline_phone_android_24"
                android:drawableLeft="@drawable/ic_baseline_phone_android_24"
                android:hint="    연락처를 입력하세요."
                android:inputType="phone" />

            <Button
                android:layout_width="100dp"
                android:layout_height="wrap_content"
                android:layout_marginLeft="150dp"
                android:layout_marginTop="10dp"
                android:text="입력완료"
                android:id="@+id/finish"/>

        </LinearLayout>

    </LinearLayout>

</GridLayout>
```

## 3. 구현 내용

각 액티비티간의 화면 전환과 페이지간 데이터 전달은 Intent를 통해서 구현하였다. 인텐트란 앱 컴포넌트가 무엇을 할 것인가를 담는 메세지 객체이다. 화면끼리 데이터를 주고 받아야 하는 상황에서 많이 사용된다.   

각 함수의 사용 이유에 대해선 주석으로 설명을 적어놓았다.   

### 3.1 첫번째 화면 (Main)

+ 버튼 클릭 이벤트 

``` java
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
```

### 3.2 두번째 화면 (Cart)

+ 홈 화면에서 받아온 데이터 출력하기 

``` java
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

```

+ 체크박스 추가 기능 구현 

``` java 
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
```

+ 버튼 클릭 이벤트 

```java
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
```

### 3.3 세번째 화면 (Payment)

+ 홈 화면과 장바구니 화면에서 받아오는 데이터 출력하기
```java 
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
```

+ 결제할 총 합계 계산하기 
``` java
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
```

+ 버튼 클릭 함수 (팝업창 띄우기)

<img src = "https://github.com/kimchanmiii/MyCartProject/blob/main/image/pay_fail.png" width="300" height="600">
<img src = "https://github.com/kimchanmiii/MyCartProject/blob/main/image/pay_success.png" width="300" height="600">

```java
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
```

+ 결제완료 후 홈화면으로 돌아가기 
```java 
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
```
