package vn.edu.iuh.fit.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Category;

import java.util.List;

public class CategoryDAO {
    private EntityManager em;

    public CategoryDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addCategory(Category category) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(category);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateCategory(Category category) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(category);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean deleteCategory(int categoryId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Category category = em.find(Category.class, categoryId);
            if (category != null) {
                em.remove(category);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Category findCategory(int categoryId) {
        return em.find(Category.class, categoryId);
    }

    public List<Category> findAllCategories() {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }
}
