package poly.com.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Videos")
@NamedQuery(name = "Videos.findAll", query = "SELECT o FROM Videos o")
public class Videos {
	@Id
	String vdid;
	String tieude;
	String hinh;
	boolean hd;
	int viewr;
	String video;

	@OneToMany(mappedBy = "videos") /* tùy ý */
	private List<Favorite> Favorite;

	@OneToMany(mappedBy = "videos")
	private List<Share> shares;

	public String getVdid() {
		return vdid;
	}

	public void setVdid(String vdid) {
		this.vdid = vdid;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public boolean isHd() {
		return hd;
	}

	public void setHd(boolean hd) {
		this.hd = hd;
	}

	public int getViewr() {
		return viewr;
	}

	public void setViewr(int viewr) {
		this.viewr = viewr;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Favorite> getFavorite() {
		return Favorite;
	}

	public void setFavorite(List<Favorite> favorite) {
		Favorite = favorite;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
}
