//package nbg.telebanking.database;
//
//
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import java.util.List;
//import nbg.telebanking.models.*;
//
//public class DBProvider extends HibernateConnector{
//	
//	private static DBProvider instance;
//
//	public static DBProvider getInstance() {
//		if (instance == null) {
//			instance = new DBProvider();
//		}
//		return instance;
//	}
//	
//	public NBGUser createUser(NBGUser user) {
//		Session session = getSession();
//		Transaction trans = null;
//		try {
//			trans = session.beginTransaction();
//			session.save(user);
//			trans.commit();
//			return user;
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//			if (trans != null) {
//				trans.rollback();
//			}
//
//		} finally {
//			if (trans != null && trans.isActive()) {
//				session.flush();
//			}
//			session.close();
//		}
//		return null;
//	}
//	public NBGUser retrieveUser(int id)
//	{
//		Session session= getSession();
//		NBGUser user= null;
//		try {
//			user=session.find(NBGUser.class, id);
//			
//		}catch(RuntimeException e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			session.close();
//		}
//		return user;
//	}	
////	//ToDo: Create Transaction
////	public Transaction createTransaction(Transaction transaction) {
////		Session session = getSession();
////		Transaction trans = null;
////		try {
////			trans = session.beginTransaction();
////			session.save(transaction);
////			trans.commit();
////			return transaction;
////		} catch (RuntimeException e) {
////			e.printStackTrace();
////			if (trans != null) {
////				trans.rollback();
////			}
////
////		} finally {
////			if (trans != null && trans.isActive()) {
////				session.flush();
////			}
////			session.close();
////		}
////		return null;
////	}	
////	//ToDo: Get Transaction by Date
////	public List<Transaction> retrieveTransactionByDate(Date date)//ToDo: Get User by Id
////	{
////		Session session= getSession();
////		SimpleDateFormat sdf = new SimpleDateFormat();
////		try {
////			//transaction=session.find(Transaction.class, date);
////			String hql = "SELECT transID, amount FROM Transaction WHERE date = "+sdf.format(date);
////			Query query= session.createQuery(hql);
////			@SuppressWarnings("unchecked")
////			List<Transaction> transactions = query.getResultList();
////			return transactions;
////		}catch(RuntimeException e)
////		{
////			e.printStackTrace();
////		}
////		finally
////		{
////			session.close();
////		}
////		return null;
////	}
////	//Get Transaction by amount range
////	public List<Transaction> retrieveTransactionByAmount(float min, float max)
////	{
////		Session session= getSession();				
////		try {
////			//transaction=session.find(Transaction.class, date);
////			String hql = "SELECT transID, amount FROM Transaction WHERE amount BETWEEN "+min+ " AND "+max;
////			Query query= session.createQuery(hql);
////			List<Transaction> transactions = query.getResultList();
////			return transactions;
////		}catch(RuntimeException e)
////		{
////			e.printStackTrace();
////		}
////		finally
////		{
////			session.close();
////		}
////		return null;
////	}	
////	//ToDO: Get All Transactions
////	public List<Transaction> retrieveAllTransactions()//ToDo: Get User by Id
////	{
////		Session session= getSession();		
////		try {
////			//transaction=session.find(Transaction.class, date);
////			String hql = "SELECT transID, amount FROM Transaction";
////			Query query= session.createQuery(hql);
////			List<Transaction> transactions = query.getResultList();
////			return transactions;
////		}catch(RuntimeException e)
////		{
////			e.printStackTrace();
////		}
////		finally
////		{
////			session.close();
////		}
////		return null;
////	}	
////	//ToDo: Create Message
////	public NBGMessage createMessage(NBGMessage msg) {
////		Session session = getSession();
////		Transaction trans = null;
////		try {
////			trans = session.beginTransaction();
////			session.save(msg);
////			trans.commit();
////			return msg;
////		} catch (RuntimeException e) {
////			e.printStackTrace();
////			if (trans != null) {
////				trans.rollback();
////			}
////
////		} finally {
////			if (trans != null && trans.isActive()) {
////				session.flush();
////			}
////			session.close();
////		}
////		return null;
////	}
////	//ToDo: Get Message
////	public List<NBGMessage> retrieveAllMessages()
////	{
////		Session session=getSession();
////		try {			
////			String hql = "SELECT msg_id, subject, description, createdAt FROM Message";
////			Query query= session.createQuery(hql);
////			List<NBGMessage> msgs = query.getResultList();
////			return msgs;
////		}catch(RuntimeException e)
////		{
////			e.printStackTrace();
////		}
////		finally
////		{
////			session.close();
////		}
////		return null;
////	}	
//
//}
