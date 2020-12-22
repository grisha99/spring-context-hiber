package ru.grishchenko.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.grishchenko.configs.DBFactory;
import ru.grishchenko.models.Buyer;
import ru.grishchenko.models.Product;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {

    private Session session;

    public List<Buyer> getBuyerListByProductId(int productId) {
        session = DBFactory.getInstance().getFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, productId);
        List<Buyer> result = new ArrayList<Buyer>(product.getBuyers());
        session.getTransaction().commit();
        return result;
    }


}
