package vn.edu.iuh.fit.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.User;

import java.util.List;

public class UserDAO {
    private EntityManager em;

    public UserDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addUser(User user) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(user);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateUser(User user) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(user);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public User findUser(int userId) {
        return em.find(User.class, userId);
    }

    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
