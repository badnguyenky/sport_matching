package seth.nelson.sportmatching.CoinFootball;

import android.content.Context;

public class BillingDataPref {
    private static final String SHOW_COIN_ITEM = "SHOW_COIN_ITEM";
    private static BillingDataPref instance;
    private CoinShareFreferences coinShareFreferences;

    public static void init(Context context){
        instance = new BillingDataPref();
        instance.coinShareFreferences = new CoinShareFreferences(context);
    }

    public static BillingDataPref getInstance(){
        if (instance == null){
            instance = new BillingDataPref();
        }
        return instance;
    }

    public static void setCoinItem(int coinItem){
        BillingDataPref.getInstance().coinShareFreferences.putIntValue(SHOW_COIN_ITEM,coinItem);
    }

    public static int getCoinItem(){
       return BillingDataPref.getInstance().coinShareFreferences.getIntValue(SHOW_COIN_ITEM);
    }
}
