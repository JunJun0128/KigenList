package com.example.junekelectric.shoumikigenlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    //notiswitchを押したら、５日前、３日目、前日、当日、切れた後は毎日　　通知する機能を、on/off調節する。
    //まあ多くのユーザーはonにすると思うが。
    //通知機能
}
