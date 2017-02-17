package org.ambdev.eboutique.metier;

import java.util.List;

import org.ambdev.eboutique.entities.Categorie;
import org.ambdev.eboutique.entities.Client;
import org.ambdev.eboutique.entities.Commande;
import org.ambdev.eboutique.entities.Panier;
import org.ambdev.eboutique.entities.Produit;

public interface InternauteMetier {

    public List<Categorie> listCategories();

    public Categorie getCategorie(Long idCat);

    public List<Produit> listProduits();

    public List<Produit> produitsParMotCle(String mc);

    public List<Produit> produitsParCategorie(Long idCat);

    public List<Produit> produitsSelectionnes();

    public Produit getProduit(Long idP);

    public Commande enregistrerCommande(Panier p, Client c);
}
