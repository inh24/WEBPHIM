package poly.com.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@NamedQuery(name="Users.findAll", query="SELECT o FROM Users o")
public class Users {
	@Id
	String usid;
	String pass;
	String hoten;
	String email;
	boolean vaitro;
	String hinh;
	
	@OneToMany(mappedBy="users")/*tùy ý*/
	private List<Favorite> favorites;

	@OneToMany(mappedBy="users")
	private List<Share> shares;

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVaitro() {
		return vaitro;
	}

	public void setVaitro(boolean vaitro) {
		this.vaitro = vaitro;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
}
