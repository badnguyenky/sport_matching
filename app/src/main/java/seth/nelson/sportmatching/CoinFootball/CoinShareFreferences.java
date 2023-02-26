package seth.nelson.sportmatching.CoinFootball;

import android.content.Context;
import android.content.SharedPreferences;

public class CoinShareFreferences {
    private static final String COIN_ITEM_SHARED = "COIN_ITEM_SHARED";
    private Context mContext;

    public CoinShareFreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putIntValue(String key,int value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(COIN_ITEM_SHARED,mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntValue(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(COIN_ITEM_SHARED,mContext.MODE_PRIVATE);
        return sharedPreferences.getInt(key,0);
    }
}
