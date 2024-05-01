package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
	private static Connection instance;
	private EntityManagerFactory emf;

	private Connection() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("NewsAndBlogApp");

	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
