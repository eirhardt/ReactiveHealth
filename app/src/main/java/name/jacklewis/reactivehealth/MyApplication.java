package name.jacklewis.reactivehealth;

import android.app.Application;
import android.content.res.Configuration;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.polidea.rxandroidble2.RxBleClient;

public class MyApplication extends Application {

    private FirebaseAnalytics mFirebaseAnalytics;
    static RxBleClient rxBleClient; //single instance of the client, can be used by all.


    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        rxBleClient = RxBleClient.create(this);

    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
