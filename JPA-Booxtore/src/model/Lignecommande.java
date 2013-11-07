package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LIGNECOMMANDE database table.
 * 
 */
@Entity
public class Lignecommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LignecommandePK id;

	private BigDecimal prixttc;

	private BigDecimal quantite;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="ID_ARTICLE")
	private Article article;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE")
	private Commande commande;

	public Lignecommande() {
	}

	public LignecommandePK getId() {
		return this.id;
	}

	public void setId(LignecommandePK id) {
		this.id = id;
	}

	public BigDecimal getPrixttc() {
		return this.prixttc;
	}

	public void setPrixttc(BigDecimal prixttc) {
		this.prixttc = prixttc;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}