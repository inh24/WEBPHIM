package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.JPA.jpaults;
import poly.com.model.Share;

public class shareDAO {
	private EntityManager em = jpaults.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	public void insert(Share entity) {
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

	
	public void update(Share entity) {
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
			Share Shares = em.find(Share.class,key);
			if(Shares!=null) {
				em.remove(Shares);
			}else {
				throw new Exception("This Share does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Share> findAll() {
		TypedQuery<Share> query = em.createNamedQuery("Share.findAll",Share.class);
		return query.getResultList();
	}


	public Share findByID(String id) {
		Share Shares = em.find(Share.class, id);
		return Shares;

	}
}
