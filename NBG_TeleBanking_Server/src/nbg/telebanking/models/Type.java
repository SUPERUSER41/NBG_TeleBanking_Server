package nbg.telebanking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="nbg_transaction_type")
public class Type
{
	@OneToMany(mappedBy="nbg_type")
	private List<Transaction> transactions= new ArrayList<>(); 
	//type -> transactions = one to many
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="type_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeID;
	
	@Column(name="type_name", nullable=false)
	private String typeName;
	
	public Type() {
		this(0, "");
	}
	
	public Type(int id, String name) {
		this.typeID = id;
		this.typeName = name;
		
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Type [typeID=" + typeID + ", typeName=" + typeName + "]";
	}

	
}
