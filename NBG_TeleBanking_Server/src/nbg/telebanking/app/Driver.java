package nbg.telebanking.app;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nbg.telebanking.database.DBManager;
import nbg.telebanking.models.NBGRole;
import nbg.telebanking.models.NBGTransaction;
import nbg.telebanking.models.NBGUser;

public class Driver {
	
	public static void main(String[] args) {
		 DBManager db = DBManager.getInstance();
		 
		 //Create User
//		 NBGUser nbgUser = new NBGUser("Daneil", "Greaves", "dan@gmail.com", "password");
//		 nbgUser.setRole(new NBGRole("Customer"));
//		 
//		 //Create Transaction
//		 NBGTransaction nbgTrans = new NBGTransaction(new BigDecimal(100900), "", "deposit","credit");
//		 
//		 //Set user transaction
//		 nbgUser.setTransactions(nbgTrans);
		 
		 //Get a user
		 NBGUser dan = db.fetchUser("dan@gmail.com", "password");
		 dan.getTransactions().forEach(trans -> System.out.println(trans.getAmount()));
		 
		 
//		 db.addUser(nbgUser);
		 
		 

	}

}
