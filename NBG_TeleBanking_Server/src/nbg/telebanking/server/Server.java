package nbg.telebanking.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Date;

import nbg.telebanking.models.*;

public class Server implements Runnable {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket connection;
	private static Logger logger = LogManager.getLogger(Server.class);

	public Server(Socket connection) {
		this.connection = connection;
		Thread thread = new Thread(this);
		thread.start();
		logger.info("New Thread Instatiated");
	}

	public void getStream() {
		try {

			oos = new ObjectOutputStream(connection.getOutputStream());
			logger.info("Stream recieved");
			ois = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			logger.error("Exception occrueed while starting Stream recieved");
		}
	}

	public void closeConnection() {
		try {
			ois.close();
			oos.close();
			connection.close();
		} catch (IOException ex) {
			logger.error("Error occured while closing stream " + ex.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			getStream();
			Request req = null;
			Response res = new Response();
			res.setSuccess(false);
			do {
				try {
					req = (Request) ois.readObject();
					switch (req.getAction()) {
					// switches the action received from the client
					case "add customr":
						logger.info("action contains this" + req.getAction());
						// this.insertUser((User))ois.readObject(); add the function to insert new
						// customer here
						break;
					case "update customer":
						logger.info("action contains this" + req.getAction());
						// this.updateCustomer(())ois.readObject();
						break;
					case "get customer":
						logger.info("action contains this" + req.getAction());
						int obj = (int) ois.readObject();
						// this.getUser(obj); should return a user with matching id
						break;
					case "get all customer":
						logger.info("action contains this" + req.getAction());
						// this.getUser();
						break;
					case "login":
						logger.info("action contains this" + req.getAction());
						// this.login((User))ois.readObject(); checks if user is in the system
						break;
					case "sign up":
						logger.info("action contains this" + req.getAction());
						// this.newAccount((User))ois.readObject(); allows the user to create a new
						// account
						break;
					case "view transactions":
						logger.info("action contains this" + req.getAction());
						// this.viewAllTransaction((Transaction))ois.readObject(); should allow the user
						// to view all of his/ her transactions
						break;
					case "search transactions":
						logger.info("action contains this" + req.getAction());
						// this.searchTransaction((date=new Date()))ois.readObject();
						// should all the user to search transactions by date period
						break;
					case "leave a message":
						logger.info("action contains this" + req.getAction());
						// Message message=(Message)ois.readObject(); should all the user to leave a
						// message
						break;
					case "open chatbot":
						logger.info("action contains this" + req.getAction());
						// allows the user to open chatbot
						break;
					case "add founds":
						logger.info("action contains this" + req.getAction());
						break;
					case "pay bills":
						logger.info("action contains this" + req.getAction());
						break;
					}

				} catch (ClassCastException | ClassNotFoundException e) {
					e.printStackTrace();
				}

			} while (!req.equals("Exit"));

		} catch (IOException e) {

		}

	}
/*
	private void insertUser(User user) {
		try {
			// JOptionPane.showMessageDialog(null, cust.getFirstName());
			oos.writeObject(UserHibernate.insertCustomer(user));
		} catch (IOException ex) {
			try {
				System.out.println(ex.getMessage());
				oos.flush();
				oos.writeObject(false);
			} catch (IOException ex1) {
				logger.error("A new user was not added to database " + ex1.getMessage());
			}
		}
	}

	private void editUser(User cust) {
		try {
			oos.writeObject(UserHibernate.updateCustomer(cust));
		} catch (IOException ex) {
			try {
				oos.writeObject(false);
			} catch (IOException ex1) {
				logger.error("A new user was not updated in database " + ex1.getMessage());
			}
		}
	}

	private void getCustomer(int id) {

		try {
			oos.writeObject(UserHibernate.selectCustomer(id));

		} catch (IOException ex) {
			logger.error(" user was not added found in database " + ex.getMessage());
		}
	}

	private void getCustomer() {
		ArrayList<User> obj = null;
		try {
			obj = UserHibernate.selectAllCustomer();
			oos.writeObject(obj);
		} catch (IOException ex) {
			try {
				oos.writeObject(obj);
			} catch (IOException ex1) {
				logger.error("Database is empty " + ex1.getMessage());
			}

		}
	}

	private void deleteCustomer(User cust) {
		try {
			oos.writeObject(UserHibernate.deleteCustomer(cust));
		} catch (IOException ex) {
			logger.error(" user was not  deleted from database " + ex.getMessage());
			try {
				oos.writeObject(false);
			} catch (IOException ex1) {
				logger.error("user was not deleted from database " + ex1.getMessage());
			}
		}
	}

	private void getTransaction(int id) {
		try {
			// Booking book =
			oos.writeObject(TransactionHibernate.selectTransaction(id));
		} catch (IOException ex) {
			logger.error("transaction of not found " + ex.getMessage());
		}
	}

	private void getAllTransaction() {
		ArrayList<Transaction> booklist = null;

		try {
			translist = TransactionHibernate.selectAllTransaction();
			oos.writeObject(translist);
		} catch (IOException ex) {
			try {
				oos.writeObject(translist);
			} catch (IOException ex1) {
				logger.error("Transaction datbase is empty " + ex1.getMessage());
			}
		}
	}
*/
}
