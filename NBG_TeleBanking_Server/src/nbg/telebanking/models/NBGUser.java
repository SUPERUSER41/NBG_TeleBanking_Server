package nbg.telebanking.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
@Table(name="nbg_users")
public class NBGUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(
//			name="user_roles",
//			joinColumns= { @JoinColumn(name ="user_id")},
//			inverseJoinColumns = { @JoinColumn(name="role_id")})
//	private List<Role> roles= new ArrayList<Role>();
//	
//	@ManyToOne
//	@JoinColumn(name="fk_msgs")//foreign key column
	
	@Id
	@Column(name="user_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column(name="first_name", nullable=false, updatable=false)
	private String fName;
	
	@Column(name="last_name", nullable=false, updatable=false)
	private String lName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="img_url")
	private String imageUrl;
	
	@ManyToMany
	@JoinTable(name = "nbg_users_transactions", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "trans_id", 
					nullable = false, updatable = false) })
	private List<NBGTransaction> transactions = new ArrayList<NBGTransaction>();
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;
	
	public NBGUser() {
		this("","","","",null);
	}
	
	public NBGUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public NBGUser(String fName, String lName, String email, String password, Date createdAt) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}
	
	//Add transaction
	public void addTransaction(NBGTransaction nbgTrans) {
		this.transactions.add(nbgTrans);
		nbgTrans.getUsers().add(this);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	public List<NBGTransaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<NBGTransaction> transactions) {
		this.transactions = transactions;
	}


	@Override
	public String toString() {
		return "NBGUser [userID=" + userID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", imageUrl=" + imageUrl + ", createdAt=" + createdAt + "]";
	}


	


	
	
	

}
