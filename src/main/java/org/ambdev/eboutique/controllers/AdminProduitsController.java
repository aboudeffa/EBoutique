package org.ambdev.eboutique.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.validation.Valid;

import org.ambdev.eboutique.entities.Categorie;
import org.ambdev.eboutique.entities.Produit;
import org.ambdev.eboutique.metier.IAdminProduitsMetier;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/adminProd")
public class AdminProduitsController {
    @Autowired
    private IAdminProduitsMetier metier;

    @RequestMapping(value = "/index")
    public String index(Model model) {
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listProduits());
	model.addAttribute("categories", metier.listCategories());
	return "produits";
    }

    @RequestMapping(value = "/saveProd")
    public String saveProd(@Valid Produit p, BindingResult bindingResult, Model model, MultipartFile file)
	    throws IOException {
	if (bindingResult.hasErrors()) {
	    model.addAttribute("categories", metier.listCategories());
	    model.addAttribute("produits", metier.listProduits());
	    return "produits";
	}

	if (!file.isEmpty()) {
	    String path = System.getProperty("java.io.tmpdir");
	    p.setPhoto(file.getOriginalFilename());
	    Long idProd = null;
	    if (p.getIdProduit() == null) {
		idProd = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
	    } else {
		metier.modifierProduit(p);
		idProd = p.getIdProduit();
	    }
	    file.transferTo(new File(path + "/" + "PROD_" + idProd + "_" + file.getOriginalFilename()));
	} else {
	    if (p.getIdProduit() == null)
		metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
	    else
		metier.modifierProduit(p);

	}
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listProduits());
	model.addAttribute("categories", metier.listCategories());
	return "produits";
    }

    @RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] photProd(Long idProd) throws IOException {
	Produit p = metier.getProduit(idProd);
	File f = new File(System.getProperty("java.io.tmpdir") + "/PROD_" + idProd + "_" + p.getPhoto());
	return IOUtils.toByteArray(new FileInputStream(f));
    }

    @RequestMapping(value = "/suppProd")
    public String suppProd(Long idProd, Model model) throws IOException {
	metier.supprimerProduit(idProd);
	model.addAttribute("produit", new Produit());
	model.addAttribute("produits", metier.listProduits());
	model.addAttribute("categories", metier.listCategories());
	return "produits";
    }

    @RequestMapping(value = "/editProd")
    public String editProd(Long idProd, Model model) throws IOException {
	Produit p = metier.getProduit(idProd);
	model.addAttribute("produit", p);
	model.addAttribute("produits", metier.listProduits());
	model.addAttribute("categories", metier.listCategories());
	return "produits";
    }

}