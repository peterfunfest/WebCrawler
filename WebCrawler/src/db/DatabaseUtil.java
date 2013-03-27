package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Finalurllist;
import model.Temporaryurllist;

/**
 * Utility class for database access, managing JPA persistence and data access
 * including insertion and deletion of records
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
public class DatabaseUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "JPATestProject";
	private static EntityManagerFactory factory;
	private EntityManager em;
	
	/**
	 * Creates EntityManagerFactory for the given persistence unit and creates
	 * an EntityManager based on this
	 */
	public DatabaseUtil() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	/**
	 * Inserts a record into the temporary URL table
	 * 
	 * @param id
	 *            ID of the record
	 * @param url
	 *            URL of the record
	 * @param priority
	 *            Priority of the record
	 * @return True if record successfully inserted, false otherwise
	 */
	public boolean insertRecordTemporaryTable(int id, String url, int priority) {
		
		Query q = em
				.createQuery("select count(1) FROM Temporaryurllist frul where frul.url = :url");
		q.setParameter("url", url);
		Long count = (Long) q.getSingleResult();
		
		if (count == 0) {
			em.getTransaction().begin();
			Temporaryurllist todo2 = new Temporaryurllist();
			todo2.setId(id);
			todo2.setUrl(url);
			todo2.setPriority(priority);
			em.persist(todo2);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Inserts a record into the final URL table
	 * 
	 * @param id
	 *            ID of the record
	 * @param url
	 *            URL of the record
	 * @param priority
	 *            Priority of the record
	 */
	public void insertRecordFinalTable(int id, String url, int priority) {
		em.getTransaction().begin();
		Finalurllist todo2 = new Finalurllist();
		todo2.setId(id);
		todo2.setUrl(url);
		todo2.setPriority(priority);
		// todo2.setId('%');
		em.persist(todo2);
		em.getTransaction().commit();
		
	}
	
	/**
	 * Get a record from the temporary URL table based on the ID
	 * 
	 * @param id
	 *            The ID of the record to retrieve
	 * @return The model representing the URL
	 */
	public Temporaryurllist getTemporaryURLListById(int id) {
		Query q = em
				.createQuery("select frul FROM Temporaryurllist frul where frul.id = "
						+ id);
		Temporaryurllist temporaryurlList = (Temporaryurllist) q
				.getSingleResult();
		return temporaryurlList;
	}
	
	/**
	 * Get a record from the final URL table based on the ID
	 * 
	 * @param id
	 *            The ID of the record to retrieve
	 * @return The model representing the URL
	 */
	public Finalurllist getFinalURLListById(int id) {
		Query q = em
				.createQuery("select frul FROM Finalurllist frul where frul.id = "
						+ id);
		Finalurllist finalurlList = (Finalurllist) q.getSingleResult();
		return finalurlList;
	}
	
	/**
	 * Get a list of all records in the temporary URL table
	 * 
	 * @return List of all records in the temporary URL table
	 */
	public List<Temporaryurllist> queryTemporaryURLList() {
		em.getTransaction().begin();
		Query q = em.createQuery("select frul FROM Temporaryurllist frul");
		@SuppressWarnings("unchecked")
		List<Temporaryurllist> temporaryurlList = (List<Temporaryurllist>) q
				.getResultList();
		
		return temporaryurlList;
		
	}
	
	/**
	 * Get a list of all records in the final URL table
	 * 
	 * @return List of all records in the final URL table
	 */
	public List<Finalurllist> queryFinalURLList() {
		Query q = em.createQuery("select frul FROM Finalurllist frul");
		@SuppressWarnings("unchecked")
		List<Finalurllist> finalURLListList = (List<Finalurllist>) q
				.getResultList();
		return finalURLListList;
	}
	
	/**
	 * Delete all records from the temporary URL table
	 */
	public void deleteAllFromTemporaryTable() {
		em.getTransaction().begin();
		em.createQuery("delete FROM Temporaryurllist frul").executeUpdate();
		em.getTransaction().commit();
	}
	
	/**
	 * Delete all records from the final URL table
	 */
	public void deleteAllFromFinalTable() {
		em.getTransaction().begin();
		em.createQuery("delete FROM Finalurllist frul").executeUpdate();
		em.getTransaction().commit();
		
	}
	
}
