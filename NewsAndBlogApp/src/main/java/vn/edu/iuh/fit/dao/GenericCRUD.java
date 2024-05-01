package vn.edu.iuh.fit.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connection;

public class GenericCRUD<T> {
	protected EntityManager em;

	public GenericCRUD() {
		// TODO Auto-generated constructor stub
		em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
	}

	public boolean add(T t) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(t);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean update(T t) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.merge(t);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean delete(Class<T> clazz, Object id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(clazz, id));

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public T findOne(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

}
