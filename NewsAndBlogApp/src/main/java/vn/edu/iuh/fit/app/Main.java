package vn.edu.iuh.fit.app;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.dao.UserDAO;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.User;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		EntityManager em = Connection.getInstance().getEntityManagerFactory().createEntityManager();

		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		}
		// Lấy danh sách tất cả các phòng
		UserDAO userDAO = new UserDAO();
		List<User> danhSachPhong =userDAO.findAllUsers();
		if (!danhSachPhong.isEmpty()) {
			System.out.println("Danh sách các phòng:");
			for (User p : danhSachPhong) {
				System.out.println(p);
			}
		} else {
			System.out.println("Không có phòng nào trong danh sách.");
		}

	}
}
