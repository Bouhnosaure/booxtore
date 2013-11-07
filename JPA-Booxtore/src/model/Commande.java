package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMMANDE database table.
 * 
 */
@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMMANDE")
	private int idCommande;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="ID_ADDRESSE")
	private int idAddresse;

	//bi-directional many-to-one association to Etatcommande
	@ManyToOne
	@JoinColumn(name="ID_ETATCOMMANDE")
	private Etatcommande etatcommande;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="commande")
	private List<Lignecommande> lignecommandes;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdAddresse() {
		return this.idAddresse;
	}

	public void setIdAddresse(int idAddresse) {
		this.idAddresse = idAddresse;
	}

	public Etatcommande getEtatcommande() {
		return this.etatcommande;
	}

	public void setEtatcommande(Etatcommande etatcommande) {
		this.etatcommande = etatcommande;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setCommande(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setCommande(null);

		return lignecommande;
	}

}