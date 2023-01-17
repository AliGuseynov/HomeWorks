import az.code.dao.impl.AbstractDao;
import az.code.models.Category;
import az.code.models.Product;
import az.code.models.Sales;
import az.code.models.SalesItems;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main extends AbstractDao {
    public static void main(String[] args) {
        EntityManager em = em();
        em.getTransaction().begin();
        Product product=new Product(1l,"Snikers",3.5, Category.Sweets,23);
        SalesItems salesItem1= new SalesItems(1l,product,12);
        List<SalesItems>salesItems=new ArrayList<>();
        salesItems.add(salesItem1);
        Sales sales=new Sales(1l,12,salesItems, LocalDate.of(2022,01,17));
        em.merge(salesItem1);
        em.merge(sales);
        em.getTransaction().commit();
        em.close();

    }
}
