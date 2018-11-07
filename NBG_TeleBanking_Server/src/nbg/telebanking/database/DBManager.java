package nbg.telebanking.database;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import nbg.telebanking.models.NBGUser;

public class DBManager extends HibernateConnector{
	private static DBManager instance;

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	/*---------------USER ACTIONS---------------*/
	
	/*ADD NEW USER TO DATABASE*/
	
	public void addUser(NBGUser user) {
		Session session = getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
		}catch(RuntimeException e) {
			e.printStackTrace();
			if (trans != null) {
				trans.rollback();
			}
		}finally {
			if (trans != null && trans.isActive()) {
				session.flush();
			}
			session.close();
		}
	}
	
	/*GET USER FROM DATABASE*/
	
	public NBGUser fetchUser(String email, String password) {
		Session session = getSession();
		NBGUser user = null;
		try {
			String hql = "from NBGUser u where u.email=:email and u.password=:password";
			Query<NBGUser> query = session.createQuery(hql,NBGUser.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			user = query.getSingleResult();
		}catch(RuntimeException e) {
			e.printStackTrace();
			
		}
		return user;
	}
	
	
	
	public void retrieveUserTransaction(int id) {
		Session session = getSession();
		Transaction trans = null;
		NBGUser user = null;
		try {
			trans = session.beginTransaction();
			user = session.find(NBGUser.class, 1);
			trans.commit();
			if(user!=null) {
				user.getTransactions().forEach(System.out::println);
			}
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
		
		
	}
	
	 

}
