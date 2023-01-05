package az.code.shopManagement.model;

public class PurchasedGood {
    private int purchaseId;
    private int productId;
    private int purchasedCount;

    public PurchasedGood(){

    }
    public PurchasedGood(int productId, int purchasedCount, int purchaseId) {
        this.productId = productId;
        this.purchasedCount = purchasedCount;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    public void setPurchasedCount(int purchasedCount) {
        this.purchasedCount = purchasedCount;
    }

}
