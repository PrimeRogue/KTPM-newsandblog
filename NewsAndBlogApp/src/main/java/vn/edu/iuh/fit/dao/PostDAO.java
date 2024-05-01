package vn.edu.iuh.fit.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Post;

import java.util.List;

public class PostDAO {
    private EntityManager em;

    public PostDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addPost(Post post) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(post);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean updatePost(Post post) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(post);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }

    public boolean deletePost(int postId) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Post post = em.find(Post.class, postId);
            if (post != null) {
                em.remove(post);
                tr.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Post findPost(int postId) {
        return em.find(Post.class, postId);
    }

    public List<Post> findAllPosts() {
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p", Post.class);
        return query.getResultList();
    }
}
