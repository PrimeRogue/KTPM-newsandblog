package vn.edu.iuh.fit.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Comment;

import java.util.List;

public class CommentDAO {
    private EntityManager em;

    public CommentDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addComment(Comment comment) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(comment);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updateComment(Comment comment) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(comment);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean deleteComment(int commentId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Comment comment = em.find(Comment.class, commentId);
            if (comment != null) {
                em.remove(comment);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Comment findComment(int commentId) {
        return em.find(Comment.class, commentId);
    }

    public List<Comment> findAllComments() {
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c", Comment.class);
        return query.getResultList();
    }
}
