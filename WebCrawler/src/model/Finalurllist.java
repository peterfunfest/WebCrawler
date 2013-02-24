package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FINALURLLIST database table.
 * 
 */
@Entity
public class Finalurllist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //@GeneratedValue(strategy=GenerationType.TABLE)
    @GeneratedValue(strategy=GenerationType.IDENTITY)


	private int id;

	private String url;

	public Finalurllist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}