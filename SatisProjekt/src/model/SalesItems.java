package model;

public class SalesItems {
    private String salesItemsId;
    private Product product;
    private double salescount;

    public SalesItems() {
    }

    public SalesItems(String salesItemsId, Product product, double salescount) {
        this.salesItemsId = salesItemsId;
        this.product = product;
        this.salescount = salescount;
        if (product.getProductCount() - salescount>0) {
            product.setProductCount(product.getProductCount() - salescount);
        }else{
            System.out.println("mehsul qalmayibdi");
        }
    }
    public String getSalesItemsId() {
        return salesItemsId;
    }

    public void setSalesItemsId(String salesItemsId) {
        this.salesItemsId = salesItemsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSalescount() {
        return salescount;
    }

    public void setSalescount(double salescount) {
        if(salescount > 0 && salescount <= this.product.getProductCount()) this.salescount = salescount;
        else System.out.println("Say düzgün qeyd olunmayıb");    }

    @Override
    public String toString() {
        return "SalesItems{" +
                "salesItemsId='" + salesItemsId + '\'' +
                ", product=" + product +
                ", salescount=" + salescount +
                '}';
    }
}
