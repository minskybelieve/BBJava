package com.helixleisure.server;

import com.helixleisure.db.HibernateUtil;
import com.helixleisure.service.IProductRequestService;
import com.helixleisure.service.ProductRequestService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class StartUp {

    private static final Logger log = LogManager.getLogger(StartUp.class);

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // change port
        // port(8080);

        // Get all products from the table
        get("/products", (req, res) -> {
            IProductRequestService svc = new ProductRequestService();
            String result = svc.getProducts();
            return result;
        });

        // store the list of products. assuming it is new, does not allow duplicate id
        post("/products/store", (req, res) -> {
            String json = "";
            if (RequestValidator.valid(req)) {
                json = req.body();
            }
            IProductRequestService svc = new ProductRequestService();
            String result = svc.storeProducts(json);
            return result;
        });

//        HibernateUtil.shutdown();
    }
}
