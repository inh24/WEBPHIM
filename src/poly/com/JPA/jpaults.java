package poly.com.JPA;

import javax.persistence.*;

public class jpaults {
	private static EntityManagerFactory factory;
	static public EntityManager getEntityManager() {
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("ASM4");
		}
		return factory.createEntityManager();
	}
	static public void shutdown() {
		if(factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
