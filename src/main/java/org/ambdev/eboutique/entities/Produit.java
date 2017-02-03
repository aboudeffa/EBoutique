package org.ambdev.eboutique.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    @NotEmpty
    @Size(min = 4, max = 15)
    private String designation;
    private String description;
    private double prix;
    private int quantite;
    private boolean selected;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    public Produit() {
	super();
    }

    public Produit(String designation, String description, double prix, int quantite, boolean selected, String photo) {
	super();
	this.designation = designation;
	this.description = description;
	this.prix = prix;
	this.quantite = quantite;
	this.selected = selected;
	this.photo = photo;
    }

    public Long getIdProduit() {
	return idProduit;
    }

    public String getDesignation() {
	return designation;
    }

    public String getDescription() {
	return description;
    }

    public double getPrix() {
	return prix;
    }

    public int getQuantite() {
	return quantite;
    }

    public boolean isSelected() {
	return selected;
    }

    public String getPhoto() {
	return photo;
    }

    public Categorie getCategorie() {
	return categorie;
    }

    public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
    }

    public void setDesignation(String designation) {
	this.designation = designation;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setPrix(double prix) {
	this.prix = prix;
    }

    public void setQuantite(int quantite) {
	this.quantite = quantite;
    }

    public void setSelected(boolean selected) {
	this.selected = selected;
    }

    public void setPhoto(String photo) {
	this.photo = photo;
    }

    public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
    }

}
