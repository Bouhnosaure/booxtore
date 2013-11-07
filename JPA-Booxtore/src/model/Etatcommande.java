package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ETATCOMMANDE database table.
 * 
 */
@Entity
public class Etatcommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ETATCOMMANDE")
	private int idEtatcommande;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_ETAT")
	private Date dateEtat;

	@Column(name="DESCRIPTION_ETAT")
	private String descriptionEtat;

	@Column(name="LIBELLE_ETAT")
	private String libelleEtat;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="etatcommande")
	private List<Commande> commandes;

	public Etatcommande() {
	}

	public int getIdEtatcommande() {
		return this.idEtatcommande;
	}

	public void setIdEtatcommande(int idEtatcommande) {
		this.idEtatcommande = idEtatcommande;
	}

	public Date getDateEtat() {
		return this.dateEtat;
	}

	public void setDateEtat(Date dateEtat) {
		this.dateEtat = dateEtat;
	}

	public String getDescriptionEtat() {
		return this.descriptionEtat;
	}

	public void setDescriptionEtat(String descriptionEtat) {
		this.descriptionEtat = descriptionEtat;
	}

	public String getLibelleEtat() {
		return this.libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setEtatcommande(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setEtatcommande(null);

		return commande;
	}

}