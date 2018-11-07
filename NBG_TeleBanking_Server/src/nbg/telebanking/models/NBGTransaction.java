package nbg.telebanking.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


@Entity
@Table(name="nbg_transactions")
public class NBGTransaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Primary Key for Transaction ID
	@Id
	@Column(name="trans_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transID;
	
	//Transaction Amount
	@Column(name="amount", nullable=false)
	private BigDecimal amount;
	
	//Transaction Description
	@Column(name="description")
	private String description;
	
	//Transaction Type
	@Column(name="type", nullable=false)
	private String type;
	
	//Action whether it is a debit or credit
	@Column(name="trans_action", nullable=false)
	private String transAction;
	
	
	@ManyToMany(mappedBy = "transactions")
	public List<NBGUser> users = new ArrayList<NBGUser>(); 
	
	//Transaction Date
	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createAt;
	
	public NBGTransaction() {
		this(new BigDecimal(0), "", "","");
	}
	
	public NBGTransaction(BigDecimal amount, String description, String type, String transAction) {
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.createAt = new Date();
		this.transAction = transAction;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<NBGUser> getUsers() {
		return users;
	}

	public void setUsers(List<NBGUser> users) {
		this.users = users;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	

	public String getTransAction() {
		return transAction;
	}

	public void setTransAction(String transAction) {
		this.transAction = transAction;
	}

	@Override
	public String toString() {
		return "NBGTransaction [transID=" + transID + ", amount=" + amount + ", description=" + description + ", type="
				+ type + ", users=" + users + ", createAt=" + createAt + "]";
	}
	

}
