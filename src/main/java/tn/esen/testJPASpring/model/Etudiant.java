package tn.esen.testJPASpring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class Etudiant implements Serializable{

	@Id
	@GeneratedValue
private Long id;
	@Column (name="name",length=30)
	@NotEmpty
	@Size(min=5,max=30)
private String nom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date;
	@NotEmpty
	@Email
private String email;
private String photo;

@ManyToOne
@JoinColumn(name="ref")
private Section maSection;

public Section getMaSection() {
	return maSection;
}


public void setMaSection(Section maSection) {
	this.maSection = maSection;
}


public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}


public Etudiant(String nom, Date date, String email,Section section, String photo) {
	super();
	this.nom = nom;
	this.date = date;
	this.email = email;
	this.maSection=section;
	this.photo = photo;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhoto() {
	return photo;
}


public void setPhoto(String photo) {
	this.photo = photo;
}

}
