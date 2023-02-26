package seth.nelson.sportmatching.CoinFootball;

import android.app.Application;

public class MyCoinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BillingDataPref.init(getApplicationContext());
    }
}
