package models;

import helper.HelperClas;

import java.util.*;

public class IMarketable {

    private List<Product> products;
    private List<Sale> sales;

    public IMarketable(){
        this.products = HelperClas.generateProducts(HelperClas.getRandomInteger(0, 3));
        this.sales = HelperClas.generateSales(HelperClas.getRandomInteger(0, 3));
    }


    public void addNewSale(Sale sale){
        Sale newSale = sale;
        this.sales.add(newSale);
        for(Sale e: sales){
            for (SalesItem z: e.getSalesItemList()){
                System.out.println("Product: " + z.getProduct().getName() + " Count: " + z.getCount());
            }
        }
    }

    //not sure about this one
    public void withdrawProductFromSales(String saleNumber, String salesItemNumber, String productCode){
        for (Sale e: sales){
            //if(e.getSaleNumber().equals(saleNumber)){}
            for (SalesItem z: e.getSalesItemList()){
                if(e.getSaleNumber().equals(saleNumber) && z.getNumber().equals(salesItemNumber) && z.getProduct().getCode().equals(productCode)){
                    Product product = z.getProduct();
                    product = null;
                }
            }


        }
    }

    public void withdrawProductFromProducts(String productCode){
        Product deleted = null;
        for (Product e: products){
            if(e.getCode().equals(productCode)){
                deleted = e;
                break;
            }
        }
        products.remove(deleted);
    }

    public void withdrawSale(String saleNumber){
        for (Sale e: sales){
            if(e.getSaleNumber().equals(saleNumber)){
                e = null;
            }
        }
    }

    public void returnSales(){
        System.out.println(sales);
    }

    public void searchSalesByDateRange(Date startDate, Date endDate){
        for (Sale e: sales){

            if(e.getDate().after(startDate) && e.getDate().before(endDate)){
                System.out.println(e);
            }
        }
    }

    public void searchSalesByDate(Date date){
        for (Sale e: sales){
            if(e.getDate().compareTo(date) == 0){
                System.out.println(e);
            }
        }
    }

    public void searchSalesByCostRange(double lowerCost, double higherCost){
        for (Sale e: sales){
            if(e.getCost() >= lowerCost && e.getCost() <= higherCost){
                System.out.println(e);
            }
        }
    }

    public void searchSalesBySaleNumber(String saleNumber){
        for (Sale e: sales){
            if(e.getSaleNumber().equalsIgnoreCase(saleNumber)){
                System.out.println(e);
            }
        }
    }

    public void returnProducts(){
        System.out.println(products.toString());
    }

    public void addNewProduct(Product product){
        Product newProduct = product;
        products.add(newProduct);
    }

    public void replaceProductInfo(String code, String name, double price, ProductCategory category, int count){
        for (Product e: products){
            if (e.getCode().equals(code)){
                e.setName(name);
                e.setPrice(price);
                e.setCategory(category);
                e.setCount(count);
            }
        }
    }

    public void searchProductsByCategory(ProductCategory productCategory){
        for(Product e: products){
            if(e.getCategory().equals(productCategory)) System.out.println(e);
        }
    }

    public void searchProductsByPriceRange(double lowerPrice, double higherPrice){
        for (Product e: products){
            if(e.getPrice() >= lowerPrice && e.getPrice() <= higherPrice){
                System.out.println(e);
            }
        }
    }

    public void searchProductsByName(String productName){
        for(Product e: products){
            if(e.getName().equals(productName)) System.out.println(e);
        }
    }


}
