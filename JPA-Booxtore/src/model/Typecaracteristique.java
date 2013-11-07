package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPECARACTERISTIQUE database table.
 * 
 */
@Entity
public class Typecaracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPECARACTERISTIQUE")
	private int idTypecaracteristique;

	@Column(name="LIBELLE_TYPE_CARACTERISTIQUE")
	private String libelleTypeCaracteristique;

	//bi-directional many-to-one association to Caracteristique
	@OneToMany(mappedBy="typecaracteristique")
	private List<Caracteristique> caracteristiques;

	public Typecaracteristique() {
	}

	public int getIdTypecaracteristique() {
		return this.idTypecaracteristique;
	}

	public void setIdTypecaracteristique(int idTypecaracteristique) {
		this.idTypecaracteristique = idTypecaracteristique;
	}

	public String getLibelleTypeCaracteristique() {
		return this.libelleTypeCaracteristique;
	}

	public void setLibelleTypeCaracteristique(String libelleTypeCaracteristique) {
		this.libelleTypeCaracteristique = libelleTypeCaracteristique;
	}

	public List<Caracteristique> getCaracteristiques() {
		return this.caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public Caracteristique addCaracteristique(Caracteristique caracteristique) {
		getCaracteristiques().add(caracteristique);
		caracteristique.setTypecaracteristique(this);

		return caracteristique;
	}

	public Caracteristique removeCaracteristique(Caracteristique caracteristique) {
		getCaracteristiques().remove(caracteristique);
		caracteristique.setTypecaracteristique(null);

		return caracteristique;
	}

}