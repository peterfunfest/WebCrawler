package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the TEMPORARYURLLIST database table.
 * 
 */
@Entity
public class Temporaryurllist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //@GeneratedValue(strategy=GenerationType.TABLE)
    //@GeneratedValue(strategy=GenerationType.IDENTITY)


	private int id;

	private int priority;

	@Column(length=1000)
	private String url;

	public Temporaryurllist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}