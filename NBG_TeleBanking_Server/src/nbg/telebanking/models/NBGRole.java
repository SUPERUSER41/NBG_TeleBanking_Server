package nbg.telebanking.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "nbg_users_roles", 
	uniqueConstraints = @UniqueConstraint(
		columnNames = { "role_name", "email" }))
public class NBGRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*---------------ATTRIBUTES / COLUMNS IN DATABASE---------------*/
	
	/*---------------ROLE ID---------------*/
	
	@Id
	@Column(name="role_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	
	
	/*---------------USER---------------*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email", nullable = false)
	private NBGUser user;
	
	
	/*---------------ROLE NAME---------------*/
	@Column(name="role_name", nullable=false, length=12)
	private String roleName;
	
	
	/*---------------CONSTRUCTORS---------------*/
	public NBGRole() {this("");}
	public NBGRole(String name) {this.roleName =  name;}
	
	
	
	/*---------------GETTERS & SETTERS---------------*/
	
	/*---------------ROLE ID---------------*/
	public int getRoleID() {return roleID;}
	public void setRoleID(int roleID) {this.roleID = roleID;}
	
	/*---------------USER---------------*/
	public NBGUser getUser() {return user;}
	public void setUser(NBGUser user) {this.user = user;}
	
	/*---------------ROLE NAME---------------*/
	public String getName() {return roleName;}
	public void setName(String name) {this.roleName = name;}
	
	/*---------------TO STRING---------------*/
	@Override
	public String toString() {
		return "NBGRole [roleID=" + roleID + ", user=" + user + ", roleName=" + roleName + "]";
	}
	
	
	
}
