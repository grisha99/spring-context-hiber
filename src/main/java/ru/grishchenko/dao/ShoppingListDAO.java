package ru.grishchenko.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.grishchenko.configs.DBFactory;
import ru.grishchenko.models.ShoppingList;
import ru.grishchenko.models.ShoppingListKey;

@Component
public class ShoppingListDAO {

    private Session session;

    public double getOldProductCostById(int buyerId, int productId) {
        session = DBFactory.getInstance().getFactory().getCurrentSession();
        session.beginTransaction();
        ShoppingList sl = session.get(ShoppingList.class, new ShoppingListKey(buyerId,productId));
        session.getTransaction().commit();
        return sl.getOldCost();
    }

    public int getCountPurchasedProduct(int buyerId, int productId) {
        session = DBFactory.getInstance().getFactory().getCurrentSession();
        session.beginTransaction();
        ShoppingList sl = session.get(ShoppingList.class, new ShoppingListKey(buyerId,productId));
        session.getTransaction().commit();
        return sl.getCount();
    }
}
