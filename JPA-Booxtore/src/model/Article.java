package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ARTICLE database table.
 * 
 */
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ARTICLE")
	private int idArticle;

	@Column(name="DESCRIPTION_ARTICLE")
	private String descriptionArticle;

	@Column(name="LIBELLE_ARTICLE")
	private String libelleArticle;

	private BigDecimal prixht;

	private BigDecimal seuil;

	private BigDecimal stock;

	//bi-directional many-to-one association to Tva
	@ManyToOne
	@JoinColumn(name="ID_TVA")
	private Tva tva;

	//bi-directional many-to-one association to Typearticle
	@ManyToOne
	@JoinColumn(name="ID_TYPEARTICLE")
	private Typearticle typearticle;

	//bi-directional many-to-many association to Caracteristique
	@ManyToMany(mappedBy="articles")
	private List<Caracteristique> caracteristiques;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="article")
	private List<Lignecommande> lignecommandes;

	public Article() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescriptionArticle() {
		return this.descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	public String getLibelleArticle() {
		return this.libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public BigDecimal getPrixht() {
		return this.prixht;
	}

	public void setPrixht(BigDecimal prixht) {
		this.prixht = prixht;
	}

	public BigDecimal getSeuil() {
		return this.seuil;
	}

	public void setSeuil(BigDecimal seuil) {
		this.seuil = seuil;
	}

	public BigDecimal getStock() {
		return this.stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public Tva getTva() {
		return this.tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	public Typearticle getTypearticle() {
		return this.typearticle;
	}

	public void setTypearticle(Typearticle typearticle) {
		this.typearticle = typearticle;
	}

	public List<Caracteristique> getCaracteristiques() {
		return this.caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setArticle(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setArticle(null);

		return lignecommande;
	}

}