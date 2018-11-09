//package nbg.telebanking.server;
//
//import nbg.telebanking.communication.*;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import nbg.telebanking.database.*;
//import nbg.telebanking.models.NBGMessage;
//import nbg.telebanking.models.NBGRole;
//import nbg.telebanking.models.NBGTransaction;
//import nbg.telebanking.models.NBGUser;
//
//public class ClientConnection implements Runnable {
//
//	private static Logger clientlog = LogManager.getLogger(ClientConnection.class);
//	private Socket conn;
//	private ObjectInputStream ois;
//	private ObjectOutputStream oos;
//	private String email;
//	private ClientManager clientManager;
//
//	public ClientConnection(Socket connection) {
//		this("temp", connection);
//	}
//
//	public ClientConnection(String email, Socket connection) {
//		this.email = email;
//		clientManager = ClientManager.getInstance();
//		this.conn = connection;
//
//		if (initStreams()) {
//			Thread myThread = new Thread(this);
//			myThread.start();
//			clientlog.info("New Thread Instatiated");
//
//		}
//	}
//
//	private boolean initStreams() {
//		try {
//			if (conn == null) {
//				return false;
//			}
//			oos = new ObjectOutputStream(conn.getOutputStream());
//			ois = new ObjectInputStream(conn.getInputStream());
//		} catch (IOException e) {
//			clientlog.error("Exception occrueed while starting Stream recieved");
//			clientlog.error(e.getMessage());
//		}
//		return false;
//	}
//
//	private void close() {
//		try {
//			oos.close();
//			ois.close();
//			conn.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//			clientlog.error("Error occured while closing stream" + e.getMessage());
//		}
//	}
//
//	@Override
//	public void run() {
//		Request request = new Request();
//		Response response = new Response();
//		DBManager db = new DBManager();
//		NBGMessage mess = new NBGMessage();
//		NBGRole role = new NBGRole();
//		NBGTransaction trans = new NBGTransaction();
//		NBGUser user = new NBGUser();
//
//		try {
//			while (!request.getAction().equals("exit") || !request.getAction().equals("disconnect")) {
//				try {
//
//					request = (Request) ois.readObject();
//					response = new Response();
//
//					switch (request.getAction()) {
//
//					// Customer Actions
//					case "regiester":
//						clientlog.info("action contains this" + request.getAction());
//						user = (NBGUser) ois.readObject();
//						db.addUser(user);
//						response.setSuccess(true);
//						response.setData(user);
//						response.setErrorMessage(user + "was added to database");
//						break;
//					case "Login":
//						clientlog.info("action contains this" + request.getAction());
//						user = (NBGUser) ois.readObject();
//						db.fetchUser(user.getEmail(), user.getPassword());
//						response.setSuccess(true);
//						response.setData(user);
//						response.setErrorMessage(user + "was found in database");
//						break;
//					case "get transaction":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//
//					case "search transaction":
//						clientlog.info("action contains this" + request.getAction());
//						trans = (NBGTransaction) ois.readObject();
//						db.retrieveUserTransaction(trans.getTransID());
//						response.setSuccess(true);
//						response.setData(trans);
//						response.setErrorMessage(trans.getTransID() + "was found in database");
//						break;
//					case "send message":
//
//						clientlog.info("action contains this" + request.getAction());
//						break;
//
//					case "open chat":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//
//					case "add funds":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//					case "transfer funds":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//					case "pay bills":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//
//					default:
//						clientlog.info("action contains this" + request.getAction() + "is not vaild");
//						break;
//					// Manager Actions
//					case "register manager":
//						clientlog.info("action contains this" + request.getAction());
//						user = (NBGUser) ois.readObject();
//						db.addUser(user);
//						response.setSuccess(true);
//						response.setData(user);
//						response.setErrorMessage(user + "was added to database");
//						break;
//					case "manage login":
//						clientlog.info("action contains this" + request.getAction());
//
//						user = (NBGUser) ois.readObject();
//						db.fetchUser(user.getEmail(), user.getPassword());
//						response.setSuccess(true);
//						response.setData(user);
//						response.setErrorMessage(user + "was found in database");
//
//						break;
//					case "debited transaction chart":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//					case "credited transaction chart":
//						clientlog.info("action contains this" + request.getAction());
//						break;
//					}
//				} catch (ClassCastException | ClassNotFoundException e) {
//					clientlog.error(e.getMessage());
//					e.printStackTrace();
//				}
//			}
//		} catch (IOException e) {
//			clientlog.error(e.getMessage());
//
//		}
//	}
//
//}
