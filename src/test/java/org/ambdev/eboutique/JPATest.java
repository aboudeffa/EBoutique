package org.ambdev.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.ambdev.eboutique.entities.Categorie;
import org.ambdev.eboutique.entities.Produit;
import org.ambdev.eboutique.metier.IAdminCategoriesMetier;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPATest {
    ClassPathXmlApplicationContext context;
    @Before
    public void setUp() throws Exception {
	context = new ClassPathXmlApplicationContext(
		    new String[] { "applicationContext.xml" });
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
	try {
	    IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
	    List<Categorie> cats1 = metier.listCategories();
	    metier.ajouterCategorie(new Categorie("Ordinateurs ", "ordinateurs", null, "img.jpeg"));
	    metier.ajouterCategorie(new Categorie("Imprimantes ", "imprimentes", null, "img.jpeg"));
	    List<Categorie> cats2 = metier.listCategories();
	    assertTrue(cats1.size()+2 == cats2.size());
	} catch (Exception e) {
	    assertTrue(e.getMessage(), false);
	}
    }
    
    @Test
    public void test2() {
	try {
	    IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
	    List<Produit> prods1 = metier.listProduits();
	    metier.ajouterProduit(new Produit("HP4500", "IMPRIMENTE HP4500", 100, 0, true, "image1.jpg"), 1L);
	    metier.ajouterProduit(new Produit("HP7650", "IMPRIMENTE HP7650", 150, 0, true, "image2.jpg"), 1L);	    
	    List<Produit> prods2 = metier.listProduits();
	    assertTrue(prods1.size()+2 == prods2.size());
	} catch (Exception e) {
	    assertTrue(e.getMessage(), false);
	}
    }

}
