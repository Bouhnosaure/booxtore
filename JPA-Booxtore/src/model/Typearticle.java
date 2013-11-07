package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPEARTICLE database table.
 * 
 */
@Entity
public class Typearticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPEARTICLE")
	private int idTypearticle;

	@Column(name="DESCRIPTION_TYPE")
	private String descriptionType;

	@Column(name="LIBELLE_TYPE_ARTICLE")
	private String libelleTypeArticle;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="typearticle")
	private List<Article> articles;

	public Typearticle() {
	}

	public int getIdTypearticle() {
		return this.idTypearticle;
	}

	public void setIdTypearticle(int idTypearticle) {
		this.idTypearticle = idTypearticle;
	}

	public String getDescriptionType() {
		return this.descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

	public String getLibelleTypeArticle() {
		return this.libelleTypeArticle;
	}

	public void setLibelleTypeArticle(String libelleTypeArticle) {
		this.libelleTypeArticle = libelleTypeArticle;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setTypearticle(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setTypearticle(null);

		return article;
	}

}