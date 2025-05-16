/**
 * 
 */
package fr.zzltxla.deploy_books.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author zzltxla
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class SimpleResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	public SimpleResponse() {

	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HelloResponse [message=" + message + "]";
	}

}

