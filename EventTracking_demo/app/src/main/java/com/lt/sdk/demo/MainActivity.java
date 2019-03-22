
package com.lt.sdk.demo;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.sdk.event.EventSDK;
import com.lt.sdk.eventtracking.R;


public class MainActivity extends Activity
{
    EditText editAppId;
    EditText editChannelId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_event_activity_main);

        editAppId = (EditText) this.findViewById(R.id.editText_appId);
        editChannelId = (EditText) this.findViewById(R.id.editText_channelId);

        TextView text = (TextView) this.findViewById(R.id.ltsdk_version);
        text.setText(EventSDK.SdkVersion);
    }

    String OrderId = System.currentTimeMillis() + "";

    public void clickHandler(View v)
    {
        if (v.getId() == R.id.init)
        {
            String appId = editAppId.getEditableText().toString().trim();
            String channelId = editChannelId.getEditableText().toString().trim();

            if (appId.equals("")) appId = "841113bfbf4422c6a53549a2a60e3c7d";
            if (channelId.equals("")) channelId = "_default_";

            EventSDK.Init(this, appId, channelId);
            Toast.makeText(this, "init:" + appId, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.register)
        {
            EventSDK.Send_RegistrationComplete();
            Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.login)
        {
            EventSDK.Send_LoginComplete();
            Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.chargeSuccess)
        {
            String ProductId = "0001";
            String ProductName = "商品1";
            double totalPrice_Yuan = 1.00f;

            EventSDK.Send_PayFinish(OrderId, ProductId, ProductName, totalPrice_Yuan);
            Toast.makeText(this, "chargeSuccess", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.customEvent)
        {
            int i = 1 + new Random().nextInt(11);
            String eventName = "event_" + i;

            EventSDK.Send_Event(eventName);
            Toast.makeText(this, "customEvent: " + eventName, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.uploadOrder)
        {
            OrderId = System.currentTimeMillis() + "";
            String ProductId = "0001";
            String ProductName = "商品1";
            String ProductMoney = "1.00";

            EventSDK.Send_OrderInfo(OrderId, ProductId, ProductName, ProductMoney);
            Toast.makeText(this, "uploadOrder: " + OrderId, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.exit)
        {
            EventSDK.Send_Exit();
            Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
        }
    }
}
