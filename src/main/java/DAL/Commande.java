/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.Date;

/**
 *
 * @author 80010-04-09
 */
public class Commande {
    private int id_commande;
    private String numero_commande;
    private Date date_commande;
    private String adresse_livraison_commande;
    private String adresse_facturation_commande;
    private String statut_commande;
    private String numero_facture;
    private Date date_facture;
    private double tva;
    private double montant_ht;
    private String type_reglement;
    private Date date_reglement_facture;
    private int id_client;
//  Constructeur
    public Commande(int id_commande, String numero_commande, Date date_commande, String adresse_livraison_commande, String adresse_facturation_commande, String statut_commande, String numero_facture, Date date_facture, Double tva, Double montant_ht, String type_reglement, Date date_reglement_facture, int id_client) {
        this.id_commande = id_commande;
        this.numero_commande = numero_commande;
        this.date_commande = date_commande;
        this.adresse_livraison_commande = adresse_livraison_commande;
        this.adresse_facturation_commande = adresse_facturation_commande;
        this.statut_commande = statut_commande;
        this.numero_facture = numero_facture;
        this.date_facture = date_facture;
        this.tva = tva;
        this.montant_ht = montant_ht;
        this.type_reglement = type_reglement;
        this.date_reglement_facture = date_reglement_facture;
        this.id_client = id_client;
    }

    Commande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getNumero_commande() {
        return numero_commande;
    }

    public void setNumero_commande(String numero_commande) {
        this.numero_commande = numero_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public String getAdresse_livraison_commande() {
        return adresse_livraison_commande;
    }

    public void setAdresse_livraison_commande(String adresse_livraison_commande) {
        this.adresse_livraison_commande = adresse_livraison_commande;
    }

    public String getAdresse_facturation_commande() {
        return adresse_facturation_commande;
    }

    public void setAdresse_facturation_commande(String adresse_facturation_commande) {
        this.adresse_facturation_commande = adresse_facturation_commande;
    }

    public String getStatut_commande() {
        return statut_commande;
    }

    public void setStatut_commande(String statut_commande) {
        this.statut_commande = statut_commande;
    }

    public String getNumero_facture() {
        return numero_facture;
    }

    public void setNumero_facture(String numero_facture) {
        this.numero_facture = numero_facture;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getMontant_ht() {
        return montant_ht;
    }

    public void setMontant_ht(Double montant_ht) {
        this.montant_ht = montant_ht;
    }

    public String getType_reglement() {
        return type_reglement;
    }

    public void setType_reglement(String type_reglement) {
        this.type_reglement = type_reglement;
    }

    public Date getDate_reglement_facture() {
        return date_reglement_facture;
    }

    public void setDate_reglement_facture(Date date_reglement_facture) {
        this.date_reglement_facture = date_reglement_facture;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
}
