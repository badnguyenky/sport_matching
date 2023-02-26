package seth.nelson.iap;

import androidx.annotation.NonNull;

import java.util.List;

import seth.nelson.iap.models.BillingResponse;
import seth.nelson.iap.models.PurchaseInfo;
import seth.nelson.iap.models.SkuInfo;

public interface BillingEventListener {
    /**
     * Callback will be triggered when products are queried for Play Console
     *
     * @param skuDetails - a list with available SKUs
     */
    void onProductsFetched(@NonNull List<SkuInfo> skuDetails);

    /**
     * Callback will be triggered when purchased products are queried from Play Console
     *
     * @param purchases - a list with owned products
     */
    void onPurchasedProductsFetched(@NonNull List<PurchaseInfo> purchases);

    /**
     * Callback will be triggered when a product is purchased successfully
     *
     * @param purchases - a list with purchased products
     */
    void onProductsPurchased(@NonNull List<PurchaseInfo> purchases);

    /**
     * Callback will be triggered when a purchase is acknowledged
     *
     * @param purchase - specifier of acknowledged purchase
     */
    void onPurchaseAcknowledged(@NonNull PurchaseInfo purchase);

    /**
     * Callback will be triggered when a purchase is consumed
     *
     * @param purchase - specifier of consumed purchase
     */
    void onPurchaseConsumed(@NonNull PurchaseInfo purchase);

    /**
     * Callback will be triggered when error occurs
     *
     * @param response - provides information about the error
     */
    void onBillingError(@NonNull BillingConnector billingConnector, @NonNull BillingResponse response);
}