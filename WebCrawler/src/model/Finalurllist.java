package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * JPA Model for the FINALURLLIST table
 * 
 * @author Peter Hayes
 * @author Iain Ritchie
 * 
 */
@Entity
public class Finalurllist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private int priority;
	
	@Column(length = 1000, unique = true)
	private String url;
	
	/**
	 * Default constructor
	 */
	public Finalurllist() {
	}
	
	/**
	 * Get the ID of the record
	 * 
	 * @return The ID of the record
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Set the ID of the record
	 * 
	 * @param id
	 *            The ID of the record
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get the priority of the record
	 * 
	 * @return The priority of the record
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Set the priority of the record
	 * 
	 * @param priority
	 *            The priority of the record
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * Get the URL of the record
	 * 
	 * @return The URL of the record
	 */
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * Set the URL of the record
	 * 
	 * @param url
	 *            The URL of the record
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}