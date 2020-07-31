package dev.collegues.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class CreerCollegueDto {
	
	@NotNull
	@NotBlank
	@Size(min=2)
	private String nom;
	@NotNull
	@NotBlank
	@Size(min=2)
	private String prenoms;
	private String email;
	private LocalDate dateDeNaissance;
	private String photoUrl;
	
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}
	/** Setter
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/** Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** Getter
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	/** Setter
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	/** Getter
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
	/** Setter
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
