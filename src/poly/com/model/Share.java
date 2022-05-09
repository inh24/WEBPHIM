package poly.com.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Share")
@NamedQuery(name="Share.findAll", query="SELECT o FROM Share o")
public class Share {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idsr; 
	@ManyToOne
	@JoinColumn(name="vdid")
	private Videos videos;
	@ManyToOne
	@JoinColumn(name="usid")
	private Users users;
	String email;
	Date sharedate;
	public Long getIdsr() {
		return idsr;
	}
	public void setIdsr(Long idsr) {
		this.idsr = idsr;
	}
	public Videos getVideos() {
		return videos;
	}
	public void setVideos(Videos videos) {
		this.videos = videos;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	
}

