package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADRESSE database table.
 * 
 */
@Entity
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ADRESSE")
	private int idAdresse;

	private String cp;

	@Column(name="NOM_ADRESSE")
	private String nomAdresse;

	@Column(name="NOM_DESTINATAIRE")
	private String nomDestinataire;

	@Column(name="PRENOM_DESTINATAIRE")
	private String prenomDestinataire;

	private String ville;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNomAdresse() {
		return this.nomAdresse;
	}

	public void setNomAdresse(String nomAdresse) {
		this.nomAdresse = nomAdresse;
	}

	public String getNomDestinataire() {
		return this.nomDestinataire;
	}

	public void setNomDestinataire(String nomDestinataire) {
		this.nomDestinataire = nomDestinataire;
	}

	public String getPrenomDestinataire() {
		return this.prenomDestinataire;
	}

	public void setPrenomDestinataire(String prenomDestinataire) {
		this.prenomDestinataire = prenomDestinataire;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}