package com.helixleisure.test;

import com.helixleisure.dao.ProductsDAO;
import com.helixleisure.db.HibernateUtil;
import com.helixleisure.entities.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class HibernateTest {

    private static final Logger log = LogManager.getLogger(HibernateTest.class);


    public static void main(String[] args) {
        log.debug("");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Product.class);
        cq.from(Product.class);
        List productList = session.createQuery(cq).getResultList();
        log.debug(productList.size());
        for (Object obj : productList) {
            if(obj instanceof Product) {
                Product prod = (Product)obj;
                log.info(prod.getId());
            }

        }
        transaction.commit();
        sessionFactory.close();
        ArrayList<Product> products = new ArrayList<>();
        if (productList != null) {
            products.addAll(productList);
        }
    }
}
