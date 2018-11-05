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
@Table(name="nbg_messages")
public class NBGMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="msg_id", nullable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgID;
	
	@Column(name="subject", nullable=false)
	private String subject;
	
	@Column(name="description", nullable=false)
	private String msgBody;
	
	@Column(name="query", nullable=false)
	private String query;
	
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	public NBGMessage() {
		this("", "",null);
	}
	public NBGMessage(String msgBody, String query, Date dateSent) {
		this.msgBody = msgBody;
		this.query = query;
		this.createdAt = dateSent;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getMsgID() {
		return msgID;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public Date getDateSent() {
		return createdAt;
	}
	public void setDateSent(Date dateSent) {
		this.createdAt = dateSent;
	}
	
	
	@Override
	public String toString() {
		return "Message [msgID=" + msgID + ", msgBody=" + msgBody + ", query=" + query + ", createdAt=" + createdAt
				+ "]";
	}
	
	
	
	

	

}
