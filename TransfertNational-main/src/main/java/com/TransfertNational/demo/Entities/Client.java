package com.TransfertNational.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client{
	

	@GeneratedValue
	private long id;
	@Id
	@Column(nullable=false)
	private String clientId;
	
	@Column(nullable=false, length=100)
	private String fullName;
	
	@Column(length=4)
	private String titre; 	//  M. / Mme
	
	@Column(nullable=false)
	private String GSM;

	@Column(nullable=false)
	private String email;

	@OneToOne(mappedBy="client", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private Compte comptes;

	@Column
	private Boolean hasCompte = true ;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isHasCompte() {
		return hasCompte;
	}

	public void setHasCompte(Boolean hasCompte) {
		this.hasCompte = hasCompte;
	}

	public Compte getComptes() {
		return comptes;
	}

	public void setComptes(Compte comptes) {
		this.comptes = comptes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}
}