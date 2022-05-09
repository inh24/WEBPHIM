package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.JPA.jpaults;
import poly.com.model.Favorite;

public class favoriteDAO {
	private EntityManager em = jpaults.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	public void insert(Favorite entity) {
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

	
	public void update(Favorite entity) {
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

	
	public void delete(Long key){
		try {
			trans.begin();
			Favorite Favorites = em.find(Favorite.class,key);
			if(Favorites!=null) {
				em.remove(Favorites);
			}else {
				throw new Exception("This Favorite does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
	public Favorite findByfav(String userID,String videoId) {
		String jqpl = "Select f from Favorite f where f.users.usid = :userID and f.videos.vdid = :videoId";
		TypedQuery<Favorite> query = em.createQuery(jqpl, Favorite.class);
		query.setParameter("userID", userID);
		query.setParameter("videoId", videoId);
		List<Favorite> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<Favorite> findAll() {
		TypedQuery<Favorite> query = em.createNamedQuery("Favorite.findAll",Favorite.class);
		return query.getResultList();
	}


	public Favorite findByID(String id) {
		Favorite Favorites = em.find(Favorite.class, id);
		return Favorites;

	}
}
