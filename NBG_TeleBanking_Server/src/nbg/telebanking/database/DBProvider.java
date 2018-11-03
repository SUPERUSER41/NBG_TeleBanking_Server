package nbg.telebanking.database;



import org.hibernate.Session;
import org.hibernate.Transaction;

import nbg.telebanking.models.User;

public class DBProvider extends HibernateConnector{
	
	private static DBProvider instance;

	public static DBProvider getInstance() {
		if (instance == null) {
			instance = new DBProvider();
		}
		return instance;
	}
	
	public User createUser(User user) {
		Session session = getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
			return user;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (trans != null) {
				trans.rollback();
			}

		} finally {
			if (trans != null && trans.isActive()) {
				session.flush();
			}
			session.close();
		}
		return null;
	}
	
	//ToDo: Get User by Id
	//ToDo: Create Transaction
	//ToDo: Get Transaction
	//ToDO: Get All Transactions
	//ToDo: Create Message
	//ToDo: Get Message
	
	

}
