package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LIGNECOMMANDE database table.
 * 
 */
@Embeddable
public class LignecommandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_COMMANDE")
	private int idCommande;

	@Column(name="ID_ARTICLE")
	private int idArticle;

	public LignecommandePK() {
	}
	public int getIdCommande() {
		return this.idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdArticle() {
		return this.idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LignecommandePK)) {
			return false;
		}
		LignecommandePK castOther = (LignecommandePK)other;
		return 
			(this.idCommande == castOther.idCommande)
			&& (this.idArticle == castOther.idArticle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCommande;
		hash = hash * prime + this.idArticle;
		
		return hash;
	}
}