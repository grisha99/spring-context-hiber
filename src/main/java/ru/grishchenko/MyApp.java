package ru.grishchenko;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.grishchenko.configs.MyAppConfig;
import ru.grishchenko.models.Buyer;
import ru.grishchenko.models.Product;
import ru.grishchenko.services.ShopService;

public class MyApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        ShopService shopService = context.getBean("shopService", ShopService.class);


        int buyerId = 1;
        for (Product item : shopService.getProductListByBuyerId(buyerId)) {
            System.out.println(item.getTitle() + ", current cost: " + item.getCost() + ", purchased cost: " + shopService.getOldCost(buyerId, item.getId()));
        }

        int productId = 2;
        for (Buyer item : shopService.getBuyerListByProductId(productId)) {
            System.out.println(item.getName() + " buy product by count: " + shopService.getCountPurchasedProduct(item.getId(), productId));
        }

    }
}
