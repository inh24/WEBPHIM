package poly.com.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Favorite")
@NamedQuery(name="Favorite.findAll", query="SELECT o FROM Favorite o")
public class Favorite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)/*Auto tăng*/
	Long idfv ;
	@ManyToOne
	@JoinColumn(name = "vdid")
	private Videos videos;
	@ManyToOne
	@JoinColumn(name ="usid")
	private Users users;
	 Date likedate;
	public Long getIdfv() {
		return idfv;
	}
	public void setIdfv(Long idfv) {
		this.idfv = idfv;
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
	public Date getLikedate() {
		return likedate;
	}
	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
	 
}
