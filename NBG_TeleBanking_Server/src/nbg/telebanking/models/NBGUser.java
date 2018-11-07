package nbg.telebanking.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name="nbg_users")
public class NBGUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*---------------ATTRIBUTES / COLUMNS IN DATABASE---------------*/
	
	/*---------------USER ID---------------*/
	@Id
	@Column(name="user_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	/*---------------FIRST NAME---------------*/
	@Column(name="first_name", nullable=false, updatable=false)
	private String fName;
	
	/*---------------LAST NAME---------------*/
	@Column(name="last_name", nullable=false, updatable=false)
	private String lName;
	
	/*---------------EMAIL---------------*/
	@Column(name="email", nullable=false, unique = true)
	private String email;
	
	/*---------------PASSWORD---------------*/
	@Column(name="password", nullable=false)
	private String password;
	
	/*---------------IMAGE URL---------------*/
	@Column(name="img_url")
	private String imageUrl;
	
	/*---------------ROLE---------------*/
	@OneToMany(mappedBy="user", cascade= {CascadeType.ALL})
	private List<NBGRole> role = new ArrayList<NBGRole>();
	
	/*---------------MESSAGES---------------*/
	@OneToMany(mappedBy="user")
	private List<NBGMessage> messages = new ArrayList<NBGMessage>();
	
	/*---------------DATE---------------*/
	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;
	
	/*---------------TRANSACTIONS---------------*/
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name = "nbg_users_transactions", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "trans_id", 
					nullable = false, updatable = false) })
	private List<NBGTransaction> transactions = new ArrayList<NBGTransaction>();
	
	
	
	
	/*---------------CONSTRUCTORS---------------*/
	
	public NBGUser() {this("","","","");}
	
	public NBGUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public NBGUser(String fName, String lName, String email, String password) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.createdAt = new Date();
	}
	
	
	/*---------------GETTERS & SETTERS---------------*/
	
	/*---------------USER ID---------------*/
	public int getUserID() {return userID;}
	public void setUserID(int userID) {this.userID = userID;}
	
	/*---------------FIRST NAME---------------*/
	public String getfName() {return fName;}
	public void setfName(String fName) {this.fName = fName;}
	
	/*---------------LAST NAME---------------*/
	public String getlName() {return lName;}
	public void setlName(String lName) {this.lName = lName;}
	
	/*---------------EMAIL---------------*/
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	/*---------------PASSWORD---------------*/
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	/*---------------IMAGE URL---------------*/
	public String getImageUrl() {return imageUrl;}
	public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
	
	/*---------------DATE---------------*/
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	
	/*---------------ROLE---------------*/
	public List<NBGRole> getRole() {return role;}
	public void setRole(NBGRole role) {
		this.role.add(role);
		role.setUser(this);
	}
	
	/*---------------MESSAGE---------------*/
	public List<NBGMessage> getMessages() {return messages;}
	public void setMessages(NBGMessage message) {
		this.messages.add(message);
		message.setUser(this);
	}

	/*---------------TRANSACTIONS---------------*/
	public List<NBGTransaction> getTransactions() {return transactions;}
	public void setTransactions(NBGTransaction nbgTrans) {
		this.transactions.add(nbgTrans);
		nbgTrans.getUsers().add(this);
	}
	
	
	
	/*---------------TO STRING---------------*/
	@Override
	public String toString() {
		return "NBGUser [userID=" + userID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", imageUrl=" + imageUrl + ", createdAt=" + createdAt + "]";
	}


}
