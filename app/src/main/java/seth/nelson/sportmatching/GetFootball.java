package seth.nelson.sportmatching;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import seth.nelson.sportmatching.R;

import seth.nelson.iap.BillingConnector;
import seth.nelson.iap.BillingEventListener;
import seth.nelson.iap.enums.PurchasedResult;
import seth.nelson.iap.enums.SupportState;
import seth.nelson.iap.models.BillingResponse;
import seth.nelson.iap.models.PurchaseInfo;
import seth.nelson.iap.models.SkuInfo;
import seth.nelson.sportmatching.CoinFootball.BillingDataPref;

import java.util.ArrayList;
import java.util.List;

public class GetFootball extends AppCompatActivity {
    private LinearLayout football_purchase_1,football_purchase_2,football_purchase_3,football_purchase_4,football_purchase_5,football_purchase_6,football_purchase_7,football_purchase_8;

    private TextView football_price_1, football_price_2, football_price_3, football_price_4,football_price_5,football_price_6,football_price_7,football_price_8 , showCoinFootball;


    private BillingConnector billingConnector;
    MediaPlayer welBgm;
    private final List<PurchaseInfo> purchasedInfoListFootball = new ArrayList<>();
    
    private final List<SkuInfo> fetchedSkuInfoListFootball = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_football);

        initViewsFootball();
        initializeBillingClientFootball();
        clickListenersFootball();
        welBgm = MediaPlayer.create(GetFootball.this,R.raw.bgm_wel);
        welBgm.start();
        welBgm.setLooping(true);
    }
    private void initializeBillingClientFootball() {
        List<String> consumableIds = new ArrayList<>();
        consumableIds.add("football_1");
        consumableIds.add("football_2");
        consumableIds.add("football_3");
        consumableIds.add("football_4");
        consumableIds.add("football_5");

        
        List<String> subscriptionIds = new ArrayList<>();
        subscriptionIds.add("football_sub_1");
        subscriptionIds.add("football_sub_2");
        subscriptionIds.add("football_sub_3");

        billingConnector = new BillingConnector(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1bw9GNOUjoHq+JlLTpj7WOJBA1EGJ/amhlOYm/gSZKRy6oGkikYxpMR3BGyFy9Yij5fNmz2/w6DHX7Iu0oIUYYzApgKR9R6u+/V+eH/8H20UEtIjJi0HHtlifFIjEmf+JsERQ0m80u54c/5G0Atmq6ollzvA6Aa2lZs44qA+CKAunR8hL9vNARYHsINJovxbmG4Se+z6Sy1T/wAD9r+vTcKI9E7yGNugz2NfPL96e9guw4IHRVc3zPwu66LTN3J0vLOcCGQUO1d4vbmtrIDqXGBNxAUvz85hW90bx6NLqufqsyVW76HTBlN/0X5uqMrxt/k2E91CW8T4AxpJAlMMrQIDAQAB")
                .setConsumableIds(consumableIds)
                .setSubscriptionIds(subscriptionIds)
                .autoAcknowledge() 
                .autoConsume() 
                .enableLogging() 
                .connect(); 

        billingConnector.setBillingEventListener(new BillingEventListener() {
            @Override
            public void onProductsFetched(@NonNull List<SkuInfo> skuDetails) {
                String sku;
                String price;

                for (SkuInfo skuInfo : skuDetails) {
                    sku = skuInfo.getSku();
                    price = skuInfo.getPrice();

                    if (sku.equalsIgnoreCase("football_1")) {
                        
                        Log.d("BillingConnector", "Product fetched: " + sku);

                        

                        football_price_1.setText(price);
                        
                        Log.d("BillingConnector", "Product price: " + price);
                        
                    }

                    if (sku.equalsIgnoreCase("football_2")) {
                        
                        Log.d("BillingConnector", "Product fetched: " + sku);
                        

                        football_price_2.setText(price);
                        
                        Log.d("BillingConnector", "Product price: " + price);
                        // Toast.makeText(GetFootball.this, "Product price: " + price, Toast.LENGTH_SHORT).show();
                    }

                    if (sku.equalsIgnoreCase("football_3")) {
                        
                        Log.d("BillingConnector", "Product fetched: " + sku);
                        

                        football_price_3.setText(price);
                        
                        Log.d("BillingConnector", "Product price: " + price);
                        
                    }

                    if (sku.equalsIgnoreCase("football_4")) {
                        
                        Log.d("BillingConnector", "Product fetched: " + sku);


                        football_price_4.setText(price);

                        
                        Log.d("BillingConnector", "Product price: " + price);

                    }
                    if (sku.equalsIgnoreCase("football_sub_1")) {
                        
                        Log.d("BillingConnector", "Product fetched: " + sku);


                        football_price_5.setText(price);

                        
                        Log.d("BillingConnector", "Product price: " + price);

                    }


                    //TODO - similarly check for other ids

                    fetchedSkuInfoListFootball.add(skuInfo);
                }
            }

            @Override
            public void onPurchasedProductsFetched(@NonNull List<PurchaseInfo> purchases) {
            }

            @Override
            public void onProductsPurchased(@NonNull List<PurchaseInfo> purchases) {
                String sku;
                String purchaseToken;
                String price;

                for (PurchaseInfo purchaseInfo : purchases) {
                    sku = purchaseInfo.getSku();
                    purchaseToken = purchaseInfo.getPurchaseToken();
                    price = purchaseInfo.getSkuInfo().getPrice();

                    if (sku.equalsIgnoreCase("football_1")) {


                        football_price_1.setText(price);

                        
                        Log.d("BillingConnector", "Purchase token: " + purchaseToken);
                        Toast.makeText(GetFootball.this, "Purchase token: " + purchaseToken, Toast.LENGTH_SHORT).show();
                    }
                    if (sku.equalsIgnoreCase("football_2")) {
                        

                        football_price_2.setText(price);

                        
                        Log.d("BillingConnector", "Purchase token: " + purchaseToken);
                        Toast.makeText(GetFootball.this, "Purchase token: " + purchaseToken, Toast.LENGTH_SHORT).show();
                    }
                    if (sku.equalsIgnoreCase("football_3")) {
                        


                        football_price_3.setText(price);

                        
                        Log.d("BillingConnector", "Purchase token: " + purchaseToken);
                        Toast.makeText(GetFootball.this, "Purchase token: " + purchaseToken, Toast.LENGTH_SHORT).show();
                    }
                    if (sku.equalsIgnoreCase("football_4")) {
                        


                        football_price_4.setText(price);

                        
                        Log.d("BillingConnector", "Purchase token: " + purchaseToken);
                        Toast.makeText(GetFootball.this, "Purchase token: " + purchaseToken, Toast.LENGTH_SHORT).show();
                    }
                    if (sku.equalsIgnoreCase("football_sub_1")) {
                        


                        football_price_5.setText(price);

                        
                        Log.d("BillingConnector", "Purchase token: " + purchaseToken);
                        Toast.makeText(GetFootball.this, "Purchase token: " + purchaseToken, Toast.LENGTH_SHORT).show();
                    }

                }
            }


            @Override
            public void onPurchaseAcknowledged(@NonNull PurchaseInfo purchase) {

                String acknowledgedSku = purchase.getSku();

                if (acknowledgedSku.equalsIgnoreCase("football_sub_1")) {
                    
                    Log.d("BillingConnector", "Acknowledged: " + acknowledgedSku);
                    football_price_5.setText(acknowledgedSku);
                    Toast.makeText(GetFootball.this, "Acknowledged: " + acknowledgedSku, Toast.LENGTH_SHORT).show();
                }
//

                //TODO - similarly check for other ids
            }

            @Override
            public void onPurchaseConsumed(@NonNull PurchaseInfo purchase) {

                String consumedSku = purchase.getSku();

                if (consumedSku.equalsIgnoreCase("football_1")) {
                    
                    Log.d("BillingConnector", "Consumed: " + consumedSku);
                    Toast.makeText(GetFootball.this, "Consumed: " + consumedSku, Toast.LENGTH_SHORT).show();
                    BillingDataPref.setCoinItem(BillingDataPref.getCoinItem() + 500);
                }
                if (consumedSku.equalsIgnoreCase("football_2")) {
                    
                    Log.d("BillingConnector", "Consumed: " + consumedSku);
                    Toast.makeText(GetFootball.this, "Consumed: " + consumedSku, Toast.LENGTH_SHORT).show();
                    BillingDataPref.setCoinItem(BillingDataPref.getCoinItem() + 1000);
                }
                if (consumedSku.equalsIgnoreCase("football_3")) {
                    
                    Log.d("BillingConnector", "Consumed: " + consumedSku);
                    Toast.makeText(GetFootball.this, "Consumed: " + consumedSku, Toast.LENGTH_SHORT).show();
                    BillingDataPref.setCoinItem(BillingDataPref.getCoinItem() + 1500);
                }
                if (consumedSku.equalsIgnoreCase("football_4")) {
                    
                    Log.d("BillingConnector", "Consumed: " + consumedSku);
                    Toast.makeText(GetFootball.this, "Consumed: " + consumedSku, Toast.LENGTH_SHORT).show();
                    BillingDataPref.setCoinItem(BillingDataPref.getCoinItem() + 2000);
                }

                //TODO - similarly check for other ids
            }

            @Override
            public void onBillingError(@NonNull BillingConnector billingConnector, @NonNull BillingResponse response) {
                switch (response.getErrorType()) {
                    case CLIENT_NOT_READY:
                        //TODO - client is not ready yet
                        break;
                    case CLIENT_DISCONNECTED:
                        //TODO - client has disconnected
                        break;
                    case SKU_NOT_EXIST:
                        //TODO - sku does not exist
                        break;
                    case CONSUME_ERROR:
                        //TODO - error during consumption
                        break;
                    case ACKNOWLEDGE_ERROR:
                        //TODO - error during acknowledgment
                        break;
                    case ACKNOWLEDGE_WARNING:
                        //TODO - warning during acknowledgment
                        break;
                    case FETCH_PURCHASED_PRODUCTS_ERROR:
                        //TODO - error occurred while querying purchased products
                        break;
                    case BILLING_ERROR:
                        //TODO - error occurred during initialization / querying sku details
                        break;
                    case USER_CANCELED:
                        //TODO - user pressed back or canceled a dialog
                        break;
                    case SERVICE_UNAVAILABLE:
                        //TODO - network connection is down
                        break;
                    case BILLING_UNAVAILABLE:
                        //TODO - billing API version is not supported for the type requested
                        break;
                    case ITEM_UNAVAILABLE:
                        //TODO - requested product is not available for purchase
                        break;
                    case DEVELOPER_ERROR:
                        //TODO - invalid arguments provided to the API
                        break;
                    case ERROR:
                        //TODO - fatal error during the API action
                        break;
                    case ITEM_ALREADY_OWNED:
                        //TODO - failure to purchase since item is already owned
                        break;
                    case ITEM_NOT_OWNED:
                        //TODO - failure to consume since item is not owned
                        break;
                }

                Log.d("BillingConnector", "Error type: " + response.getErrorType() +
                        " Response code: " + response.getResponseCode() + " Message: " + response.getDebugMessage());

                Toast.makeText(GetFootball.this, "Error type: " + response.getErrorType() +
                        " Response code: " + response.getResponseCode() + " Message: " + response.getDebugMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViewsFootball() {
        //init purchase buttons
        football_purchase_1 = findViewById(R.id.line_1);
        football_purchase_2 = findViewById(R.id.line_2);
        football_purchase_3 = findViewById(R.id.line_3);
        football_purchase_4 = findViewById(R.id.line_4);
        football_purchase_5 = findViewById(R.id.line_5);


        //TextOut


        //TextView
        football_price_1 = findViewById(R.id.football_price_1);
        football_price_2 = findViewById(R.id.football_price_2);
        football_price_3 = findViewById(R.id.football_price_3);
        football_price_4 = findViewById(R.id.football_price_4);
        football_price_5 = findViewById(R.id.football_price_5);
        showCoinFootball = findViewById(R.id.txt_coin_get_shop);

        int shownumberCoinFootball = BillingDataPref.getCoinItem();
        showCoinFootball.setText("" + shownumberCoinFootball);


    }

    private void clickListenersFootball() {
        //purchase an item
        football_purchase_1.setOnClickListener(v -> billingConnector.purchase(GetFootball.this, "football_1"));
        football_purchase_2.setOnClickListener(v -> billingConnector.purchase(GetFootball.this, "football_2"));
        football_purchase_3.setOnClickListener(v -> billingConnector.purchase(GetFootball.this, "football_3"));
        football_purchase_4.setOnClickListener(v -> billingConnector.purchase(GetFootball.this, "football_4"));
        football_purchase_5.setOnClickListener(v -> billingConnector.purchase(GetFootball.this, "football_5"));
    }

    @SuppressWarnings("unused")
    private void usefulPublicMethods() {

        if (billingConnector.isReady()) {
            
            Log.d("BillingConnector", "Billing client is ready");
        }

        if (billingConnector.isSubscriptionSupported() == SupportState.SUPPORTED) {
            
            Log.d("BillingConnector", "Device subscription support: SUPPORTED");
        } else if (billingConnector.isSubscriptionSupported() == SupportState.NOT_SUPPORTED) {
            
            Log.d("BillingConnector", "Device subscription support: NOT_SUPPORTED");
        } else if (billingConnector.isSubscriptionSupported() == SupportState.DISCONNECTED) {
            
            Log.d("BillingConnector", "Device subscription support: client DISCONNECTED");
        }


        for (SkuInfo skuInfo : fetchedSkuInfoListFootball) {
            if (billingConnector.isPurchased(skuInfo) == PurchasedResult.YES) {
                
                Log.d("BillingConnector", "The SKU: " + skuInfo.getSku() + " is purchased");
            } else if (billingConnector.isPurchased(skuInfo) == PurchasedResult.NO) {
                
                Log.d("BillingConnector", "The SKU: " + skuInfo.getSku() + " is not purchased");
            } else if (billingConnector.isPurchased(skuInfo) == PurchasedResult.CLIENT_NOT_READY) {
                
                Log.d("BillingConnector", "Cannot check: " + skuInfo.getSku() + " because client is not ready");
            } else if (billingConnector.isPurchased(skuInfo) == PurchasedResult.PURCHASED_PRODUCTS_NOT_FETCHED_YET) {
                
                Log.d("BillingConnector", "Cannot check: " + skuInfo.getSku() + " because purchased products are not fetched yet");
            }
        }

        for (PurchaseInfo purchaseInfo : purchasedInfoListFootball) {
            billingConnector.consumePurchase(purchaseInfo);
        }

        for (PurchaseInfo purchaseInfo : purchasedInfoListFootball) {
            billingConnector.acknowledgePurchase(purchaseInfo);
        }

        billingConnector.purchase(GetFootball.this, "sku_id");

        billingConnector.subscribe(GetFootball.this, "sku_id");
    }
}