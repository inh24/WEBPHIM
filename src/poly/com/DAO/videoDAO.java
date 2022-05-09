package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.JPA.jpaults;
import poly.com.model.Videos;

public class videoDAO {
	private EntityManager em = jpaults.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	public void insert(Videos entity) {
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

	
	public void update(Videos entity) {
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
			Videos Videoss = em.find(Videos.class,key);
			if(Videoss!=null) {
				em.remove(Videoss);
			}else {
				throw new Exception("This Videos does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Videos> findAll() {
		TypedQuery<Videos> query = em.createNamedQuery("Videos.findAll",Videos.class);
		return query.getResultList();
	}
	public List<Videos> videoyeuthichuserid(String id){
		String jqpl = "Select f.videos from Favorite f where f.users.usid = :id ";
		TypedQuery<Videos> query = em.createQuery(jqpl, Videos.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	public Videos findByID(String id) {
		Videos Videoss = em.find(Videos.class, id);
		return Videoss;

	}
}
