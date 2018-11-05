package nbg.telebanking.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="nbg_transactions")
public class Transaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="trans_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transID;
	
	@Column(name="amount", nullable=false)
	private float amount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	public Transaction() {
		this(0, "", "",null);
	}
	
	public Transaction(float amount, String description, String type, Date created_at) {
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.createAt = created_at;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public Date getDate() {
		return createAt;
	}

	public void setDate(Date created_at) {
		this.createAt = created_at;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+ " [id=" + transID + ", type=" + type + ", dateCreated="
				+ createAt + "]";
	}
	

}
