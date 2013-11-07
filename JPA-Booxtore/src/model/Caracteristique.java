package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CARACTERISTIQUE database table.
 * 
 */
@Entity
public class Caracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CARACTERISTIQUE")
	private int idCaracteristique;

	@Column(name="VALEUR_CARACTERISTIQUE")
	private String valeurCaracteristique;

	//bi-directional many-to-many association to Article
	@ManyToMany
	@JoinTable(
		name="CARACTERISE"
		, joinColumns={
			@JoinColumn(name="ID_CARACTERISTIQUE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ARTICLE")
			}
		)
	private List<Article> articles;

	//bi-directional many-to-one association to Typecaracteristique
	@ManyToOne
	@JoinColumn(name="ID_TYPECARACTERISTIQUE")
	private Typecaracteristique typecaracteristique;

	//bi-directional many-to-one association to Caracteristique
	@ManyToOne
	@JoinColumn(name="PARENT_ID_CARACTERISTIQUE")
	private Caracteristique caracteristique;

	//bi-directional many-to-one association to Caracteristique
	@OneToMany(mappedBy="caracteristique")
	private List<Caracteristique> caracteristiques;

	public Caracteristique() {
	}

	public int getIdCaracteristique() {
		return this.idCaracteristique;
	}

	public void setIdCaracteristique(int idCaracteristique) {
		this.idCaracteristique = idCaracteristique;
	}

	public String getValeurCaracteristique() {
		return this.valeurCaracteristique;
	}

	public void setValeurCaracteristique(String valeurCaracteristique) {
		this.valeurCaracteristique = valeurCaracteristique;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Typecaracteristique getTypecaracteristique() {
		return this.typecaracteristique;
	}

	public void setTypecaracteristique(Typecaracteristique typecaracteristique) {
		this.typecaracteristique = typecaracteristique;
	}

	public Caracteristique getCaracteristique() {
		return this.caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public List<Caracteristique> getCaracteristiques() {
		return this.caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public Caracteristique addCaracteristique(Caracteristique caracteristique) {
		getCaracteristiques().add(caracteristique);
		caracteristique.setCaracteristique(this);

		return caracteristique;
	}

	public Caracteristique removeCaracteristique(Caracteristique caracteristique) {
		getCaracteristiques().remove(caracteristique);
		caracteristique.setCaracteristique(null);

		return caracteristique;
	}

}