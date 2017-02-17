package org.ambdev.eboutique.metier;

import org.ambdev.eboutique.entities.Categorie;
import org.ambdev.eboutique.entities.Role;
import org.ambdev.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {

    public Long ajouterCategorie(Categorie c);

    public void supprimerCategorie(Long idcat);

    public void modifierCategorie(Categorie c);

    public void ajouterUser(User u);

    public void attribuerRole(Role r, Long userID);
}
