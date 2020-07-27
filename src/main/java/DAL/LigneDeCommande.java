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
public class LigneDeCommande {
    private int id_ligne_commande;
    private String ref_produit_commande;
    private String designation_produit_ommande;
    private double prix_unitaire_ht;
    private int quantite_produit;
    private double total_ttc;
    private int id_produit;
    private int id_commande;

    public LigneDeCommande(int id_ligne_commande, String ref_produit_commande, String designation_produit_ommande, double prix_unitaire_ht, int quantite_produit, double total_ttc, int id_produit, int id_commande) {
        this.id_ligne_commande = id_ligne_commande;
        this.ref_produit_commande = ref_produit_commande;
        this.designation_produit_ommande = designation_produit_ommande;
        this.prix_unitaire_ht = prix_unitaire_ht;
        this.quantite_produit = quantite_produit;
        this.total_ttc = total_ttc;
        this.id_produit = id_produit;
        this.id_commande = id_commande;
    }

    LigneDeCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_ligne_commande() {
        return id_ligne_commande;
    }

    public void setId_ligne_commande(int id_ligne_commande) {
        this.id_ligne_commande = id_ligne_commande;
    }

    public String getRef_produit_commande() {
        return ref_produit_commande;
    }

    public void setRef_produit_commande(String ref_produit_commande) {
        this.ref_produit_commande = ref_produit_commande;
    }

    public String getDesignation_produit_commande() {
        return designation_produit_ommande;
    }

    public void setDesignation_produit_commande(String designation_produit_ommande) {
        this.designation_produit_ommande = designation_produit_ommande;
    }

    public double getPrix_unitaire_ht() {
        return prix_unitaire_ht;
    }

    public void setPrix_unitaire_ht(double prix_unitaire_ht) {
        this.prix_unitaire_ht = prix_unitaire_ht;
    }

    public int getQuantite_produit() {
        return quantite_produit;
    }

    public void setQuantite_produit(int quantite_produit) {
        this.quantite_produit = quantite_produit;
    }

    public double getTotal_ttc() {
        return total_ttc;
    }

    public void setTotal_ttc(double total_ttc) {
        this.total_ttc = total_ttc;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }
    
}
