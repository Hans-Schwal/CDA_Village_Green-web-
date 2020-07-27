/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author 80010-04-09
 */
public class Produit {
    private int id_produit;
    private String ref_produit;
    private String ref_fournisseur;
    private String lien_photo_produit;
    private String designation_produit;
    private String description_produit;
    private double prix_achat_produit;
    private double prix_vente_produit;
    private int id_sous_rubrique;
    private int id_fournisseur;

    public Produit(int id_produit, String ref_produit, String ref_fournisseur, String lien_photo_produit, String designation_produit, String description_produit, double prix_achat_produit, double prix_vente_produit, int id_sous_rubrique, int id_fournisseur) {
        this.id_produit = id_produit;
        this.ref_produit = ref_produit;
        this.ref_fournisseur = ref_fournisseur;
        this.lien_photo_produit = lien_photo_produit;
        this.designation_produit = designation_produit;
        this.description_produit = description_produit;
        this.prix_achat_produit = prix_achat_produit;
        this.prix_vente_produit = prix_vente_produit;
        this.id_sous_rubrique = id_sous_rubrique;
        this.id_fournisseur = id_fournisseur;
    }

    Produit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(String ref_produit) {
        this.ref_produit = ref_produit;
    }

    public String getRef_fournisseur() {
        return ref_fournisseur;
    }

    public void setRef_fournisseur(String ref_fournisseur) {
        this.ref_fournisseur = ref_fournisseur;
    }

    public String getLien_photo_produit() {
        return lien_photo_produit;
    }

    public void setLien_photo_produit(String lien_photo_produit) {
        this.lien_photo_produit = lien_photo_produit;
    }

    public String getDesignation_produit() {
        return designation_produit;
    }

    public void setDesignation_produit(String designation_produit) {
        this.designation_produit = designation_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public double getPrix_achat_produit() {
        return prix_achat_produit;
    }

    public void setPrix_achat_produit(double prix_achat_produit) {
        this.prix_achat_produit = prix_achat_produit;
    }

    public double getPrix_vente_produit() {
        return prix_vente_produit;
    }

    public void setPrix_vente_produit(double prix_vente_produit) {
        this.prix_vente_produit = prix_vente_produit;
    }

    public int getId_sous_rubrique() {
        return id_sous_rubrique;
    }

    public void setId_sous_rubrique(int id_sous_rubrique) {
        this.id_sous_rubrique = id_sous_rubrique;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
}
