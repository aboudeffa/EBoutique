package org.ambdev.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @NotEmpty
    @Size(min = 4, max = 15)
    private String nomClient;
    private String adresse;
    private String email;
    private String tel;
    @OneToMany(mappedBy = "client")
    private Collection<Commande> commandes;

    public Client() {
	super();
    }

    public Client(String nomClient, String adresse, String email, String tel) {
	super();
	this.nomClient = nomClient;
	this.adresse = adresse;
	this.email = email;
	this.tel = tel;
    }

    public Long getIdClient() {
	return idClient;
    }

    public String getNomClient() {
	return nomClient;
    }

    public String getAdresse() {
	return adresse;
    }

    public String getEmail() {
	return email;
    }

    public String getTel() {
	return tel;
    }

    public Collection<Commande> getCommandes() {
	return commandes;
    }

    public void setIdClient(Long idClient) {
	this.idClient = idClient;
    }

    public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
    }

    public void setAdresse(String adresse) {
	this.adresse = adresse;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setTel(String tel) {
	this.tel = tel;
    }

    public void setCommandes(Collection<Commande> commandes) {
	this.commandes = commandes;
    }

}
