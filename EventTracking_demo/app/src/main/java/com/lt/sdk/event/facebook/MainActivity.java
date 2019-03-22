package com.lt.sdk.event.facebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lt.sdk.eventtracking.R;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lt_event_activity_main);

        //        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //        setSupportActionBar(toolbar);
        //
        //        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //        fab.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                        .setAction("Action", null).show();
        //            }
        //        });

//        FaceBook_EventSDK.Init(this);
    }


    public void clickHandler(View v)
    {
        if (v.getId() == R.id.init)
        {
            FaceBook_EventSDK.Init(this, "");

            Toast.makeText(this, "init:", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.register)
        {
            FaceBook_EventSDK.logCompleteRegistrationEvent("register");

            //            FaceBook_EventSDK.logCompleteRegistrationEvent();
            Toast.makeText(this, "register: ", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.login)
        {
            FaceBook_EventSDK.logCustomEvent("login");

            // String accountId = Tracking.getDeviceId();
            // Tracking.setLoginSuccessBusiness(accountId);

            Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.chargeSuccess)
        {
            String transactionId = System.currentTimeMillis() + "";
            String paymentType = "alipay";
            String currencyType = "CNY";
            float currencyAmount = 5.0f;
            // Tracking.setPayment(transactionId, paymentType, currencyType, currencyAmount);

            BigDecimal purchaseAmount = BigDecimal.valueOf(1);
            Currency currency = Currency.getInstance(Locale.CHINA);
            Bundle parameters = new Bundle();
            parameters.putString("currencyType", "CNY");

//
//            FaceBook_EventSDK.logPurchase(purchaseAmount, currency,  parameters);

            FaceBook_EventSDK.logPurchase(purchaseAmount, currency, parameters);

            Toast.makeText(this, "chargeSuccess", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.customEvent)
        {
            int i = 1 + new Random().nextInt(11);
            String eventName = "event_" + i;
            // Tracking.setEvent(eventName);

            FaceBook_EventSDK.logCustomEvent(eventName);
            Toast.makeText(this, "customEvent: " + eventName, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.uploadOrder)
        {
            String contentData = "";
            String contentId = "0001";
            String contentType ="商品1";
            int numItems = 1;
            boolean paymentInfoAvailable = true;
            String currency = "CNY";
            double totalPrice = 1.00f;
            FaceBook_EventSDK.logInitiateCheckoutEvent(contentData, contentId, contentType, numItems, paymentInfoAvailable, currency, totalPrice);

            Toast.makeText(this, "uploadOrder: " + contentId, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.exit)
        {
            // Tracking.exitSdk();
            FaceBook_EventSDK.logCustomEvent("exit");

            Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
        }
    }

    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        // Inflate the menu; this adds items to the action bar if it is present.
    //        getMenuInflater().inflate(R.menu.menu_main, menu);
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item) {
    //        // Handle action bar item clicks here. The action bar will
    //        // automatically handle clicks on the Home/Up button, so long
    //        // as you specify a parent activity in AndroidManifest.xml.
    //        int id = item.getItemId();
    //
    //        //noinspection SimplifiableIfStatement
    //        if (id == R.id.action_settings) {
    //            return true;
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }

}
