package org.ambdev.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Date dateCommande;
    @OneToMany(mappedBy = "commande")
    private Collection<LigneCommande> items;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    public Commande() {
	super();
    }

    public Long getIdCommande() {
	return idCommande;
    }

    public Date getDateCommande() {
	return dateCommande;
    }

    public Collection<LigneCommande> getItems() {
	return items;
    }

    public Client getClient() {
	return client;
    }

    public void setIdCommande(Long idCommande) {
	this.idCommande = idCommande;
    }

    public void setDateCommande(Date dateCommande) {
	this.dateCommande = dateCommande;
    }

    public void setItems(Collection<LigneCommande> items) {
	this.items = items;
    }

    public void setClient(Client client) {
	this.client = client;
    }

}
