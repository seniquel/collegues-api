package dev.collegues.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String message;

	public Note() {
	}

	/** Getter
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/** Setter
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
