package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GaranteeFolder implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private String pieceOfIdentity;
	private String engagementLetter;
	private String proofPayement;
	private Boolean approved;
	
	
	public GaranteeFolder() {
		super();
	}

	public GaranteeFolder(long id, String pieceOfIdentity, String engagementLetter, String proofPayement,
			Boolean approved) {
		super();
		this.id = id;
		this.pieceOfIdentity = pieceOfIdentity;
		this.engagementLetter = engagementLetter;
		this.proofPayement = proofPayement;
		this.approved = approved;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPieceOfIdentity() {
		return pieceOfIdentity;
	}

	public void setPieceOfIdentity(String pieceOfIdentity) {
		this.pieceOfIdentity = pieceOfIdentity;
	}

	public String getEngagementLetter() {
		return engagementLetter;
	}

	public void setEngagementLetter(String engagementLetter) {
		this.engagementLetter = engagementLetter;
	}

	public String getProofPayement() {
		return proofPayement;
	}

	public void setProofPayement(String proofPayement) {
		this.proofPayement = proofPayement;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

}
