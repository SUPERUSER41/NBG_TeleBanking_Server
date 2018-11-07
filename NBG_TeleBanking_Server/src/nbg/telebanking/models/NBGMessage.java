package nbg.telebanking.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="nbg_users_messages")
public class NBGMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*---------------ATTRIBUTES / COLUMNS IN DATABASE---------------*/
	
	/*---------------MESSAGE ID---------------*/
	
	@Id
	@Column(name="msg_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgID;
	
	/*---------------SUBJECT---------------*/
	
	@Column(name="subject", nullable=false)
	private String subject;
	
	/*---------------DESCRIPTION---------------*/
	
	@Column(name="body", nullable=false)
	private String msgBody;
	
	/*---------------QUERY---------------*/
	
	@Column(name="query", nullable=false)
	private String query;
	
	/*---------------USER---------------*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private NBGUser user;
	
	/*---------------DATE---------------*/
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	
	/*---------------CONSTRUCTORS---------------*/
	public NBGMessage() {this("", "");}
	public NBGMessage(String msgBody, String query) {
		this.msgBody = msgBody;
		this.query = query;
		this.createdAt = new Date();
	}
	
	
	/*---------------GETTERS & SETTERS---------------*/
	
	/*---------------USER---------------*/
	public NBGUser getUser() {return user;}
	public void setUser(NBGUser user) {this.user = user;}
	
	/*---------------SUBJECT---------------*/
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}
	
	/*---------------DATE---------------*/
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	
	/*---------------QUERY---------------*/
	public String getQuery() {return query;}
	public void setQuery(String query) {this.query = query;}
	
	/*---------------MESSAGE ID---------------*/
	public int getMsgID() {return msgID;}
	public void setMsgID(int msgID) {this.msgID = msgID;}
	
	/*---------------BODY---------------*/
	public String getMsgBody() {return msgBody;}
	public void setMsgBody(String msgBody) {this.msgBody = msgBody;}
	
	
	/*---------------TO STRING---------------*/
	@Override
	public String toString() {
		return "NBGMessage [msgID=" + msgID + ", subject=" + subject + ", msgBody=" + msgBody + ", query=" + query
				+ ", user=" + user + ", createdAt=" + createdAt + "]";
	}
	
	
	

}
