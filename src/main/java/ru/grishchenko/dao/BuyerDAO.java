package ru.grishchenko.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.grishchenko.configs.DBFactory;
import ru.grishchenko.models.Buyer;
import ru.grishchenko.models.Product;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerDAO {

    private Session session;


    public List<Product> getProductListByBuyerId(int buyerId) {
        session = DBFactory.getInstance().getFactory().getCurrentSession();
        session.beginTransaction();
        Buyer buyer = session.get(Buyer.class, buyerId);
        List<Product> result = new ArrayList<>(buyer.getProducts());
//        List<Product> result = buyer.getProducts();                       // такой запрос вызывает org.hibernate.LazyInitializationException:
                                                                            //        failed to lazily initialize a collection of role: ru.grishchenko.models.Buyer.products,
                                                                            //        could not initialize proxy - no Session
                                                                            // Видимо что-то связано с контекстом постоянства, в чем может быть пролема?
        session.getTransaction().commit();
        return result;
    }

}
