package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TVA database table.
 * 
 */
@Entity
public class Tva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TVA")
	private int idTva;

	@Column(name="LIBELLE_TVA")
	private String libelleTva;

	private BigDecimal taux;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="tva")
	private List<Article> articles;

	public Tva() {
	}

	public int getIdTva() {
		return this.idTva;
	}

	public void setIdTva(int idTva) {
		this.idTva = idTva;
	}

	public String getLibelleTva() {
		return this.libelleTva;
	}

	public void setLibelleTva(String libelleTva) {
		this.libelleTva = libelleTva;
	}

	public BigDecimal getTaux() {
		return this.taux;
	}

	public void setTaux(BigDecimal taux) {
		this.taux = taux;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setTva(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setTva(null);

		return article;
	}

}