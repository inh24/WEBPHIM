package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.JPA.jpaults;
import poly.com.model.Users;

public class userDAO {
	private EntityManager em = jpaults.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	public void insert(Users entity) {
		try {
			if(entity !=null) {
				trans.begin();
				em.persist(entity);
				trans.commit();
			}else {
				throw new Exception("User null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}finally {
			em.close();
		}
		
	}

	
	public void update(Users entity) {
		try {
			if(entity !=null) {
				trans.begin();
				em.merge(entity);
				trans.commit();
			}else {
				throw new Exception("User null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}finally {
			em.close();
		}
		
	}

	
	public void delete(String key){
		try {
			trans.begin();
			Users Userss = em.find(Users.class,key);
			if(Userss!=null) {
				em.remove(Userss);
			}else {
				throw new Exception("This Users does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll",Users.class);
		return query.getResultList();
	}

	public Users findByID(String id) {
		Users userss = em.find(Users.class, id);
		return userss;

	}
}
