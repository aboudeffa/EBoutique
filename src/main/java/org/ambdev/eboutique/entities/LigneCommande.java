package org.ambdev.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;

    public LigneCommande() {
	super();
    }

    public LigneCommande(int quantite, double prix) {
	super();
	this.quantite = quantite;
	this.prix = prix;
    }

    public Long getId() {
	return id;
    }

    public int getQuantite() {
	return quantite;
    }

    public double getPrix() {
	return prix;
    }

    public Produit getProduit() {
	return produit;
    }

    public Commande getCommande() {
	return commande;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setQuantite(int quantite) {
	this.quantite = quantite;
    }

    public void setPrix(double prix) {
	this.prix = prix;
    }

    public void setProduit(Produit produit) {
	this.produit = produit;
    }

    public void setCommande(Commande commande) {
	this.commande = commande;
    }

}
