package com.helixleisure.dao;

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

public class ProductsDAO {

    private static final Logger log = LogManager.getLogger(ProductsDAO.class);

    public ProductsDAO() {

    }

    /**
     *
     * @return
     */
    public ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Product.class);
            cq.from(Product.class);
            List productList = session.createQuery(cq).getResultList();
            transaction.commit();
            session.close();
            if (productList != null) {
                products.addAll(productList);
            }
        } catch (RuntimeException e) {
            try {
                transaction.rollback();
            } catch (RuntimeException rbe) {
                log.error("Couldn’t roll back transaction", rbe);
                return null;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return products;
    }

    /**
     *
     * @param productsToStore
     * @return
     */
    public boolean storeProducts(ArrayList<Product> productsToStore) {
        boolean success = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            for (Product product : productsToStore) {
                session.save(product);
            }
            transaction.commit();
            session.close();
        } catch (RuntimeException e) {
            try {
                transaction.rollback();
            } catch (RuntimeException rbe) {
                log.error("Couldn’t roll back transaction", rbe);
                return success;
            }
            return success;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        success = true;
        return success;
    }
}
