package ru.grishchenko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grishchenko.dao.BuyerDAO;
import ru.grishchenko.dao.ProductDAO;
import ru.grishchenko.dao.ShoppingListDAO;
import ru.grishchenko.models.Buyer;
import ru.grishchenko.models.Product;

import java.util.List;

@Service
public class ShopService {

    private BuyerDAO buyerDAO;
    private ProductDAO productDAO;
    private ShoppingListDAO shoppingListDAO;

    @Autowired
    public void setBuyerDAO(BuyerDAO buyerDAO) {
        this.buyerDAO = buyerDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setShoppingListDAO(ShoppingListDAO shoppingListDAO) {
        this.shoppingListDAO = shoppingListDAO;
    }

    public List<Product> getProductListByBuyerId(int id) {
        return buyerDAO.getProductListByBuyerId(id);
    }

    public List<Buyer> getBuyerListByProductId(int id) {
        return productDAO.getBuyerListByProductId(id);
    }

    public double getOldCost(int buyerId, int productId) {
        return shoppingListDAO.getOldProductCostById(buyerId, productId);
    }

    public int getCountPurchasedProduct(int buyerId, int productId) {
        return shoppingListDAO.getCountPurchasedProduct(buyerId, productId);
    }

}
