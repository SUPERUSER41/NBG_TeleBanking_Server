package nbg.telebanking.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity
@Table(name="nbg_roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy = "nbg_roles")
	private Set<User> users= new HashSet<>();
	
	@Id
	@Column(name="role_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	
	@Column(name="name", nullable=false)
	private String name;
	
	public Roles() {
		this("");
	}
	
	public Roles(String name) {
		this.name =  name;
	}
	

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Roles [roleID=" + roleID + ", name=" + name + "]";
	}
	
	
	
	
	

}
