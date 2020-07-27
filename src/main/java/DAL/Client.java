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
public class Client {
    private int id_client;
    private String numero_client;
    private String coefficient_client;
    private String nom_client;
    private String prenom_client;
    private String adresse_client;
    private String comp_adresse_client;
    private String code_postal_client;
    private String ville_client;
    private int statut_client;
    private String tel_client;
    private String mail_client;
    private String mdp_client; 
    private double reduction_client;
    private String adresse_livraison_client;
    private String adresse_facturation_client;
    private int id_commercial;

    // Constructeur
    public Client(int id_client, String numero_client, String coefficient_client, String nom_client, String prenom_client, String adresse_client, String comp_adresse_client, String code_postal_client, String ville_client, int statut_client, String tel_client, String mail_client, String mdp_client, double reduction_client, String adresse_livraison_client, String adresse_facturation_client, int id_commercial) {
        this.id_client = id_client;
        this.numero_client = numero_client;
        this.coefficient_client = coefficient_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.adresse_client = adresse_client;
        this.comp_adresse_client = comp_adresse_client;
        this.code_postal_client = code_postal_client;
        this.ville_client = ville_client;
        this.statut_client = statut_client;
        this.tel_client = tel_client;
        this.mail_client = mail_client;
        this.mdp_client = mdp_client;
        this.reduction_client = reduction_client;
        this.adresse_livraison_client = adresse_livraison_client;
        this.adresse_facturation_client = adresse_facturation_client;
        this.id_commercial = id_commercial;
    }
    
    public Client() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(String numero_client) {
        this.numero_client = numero_client;
    }

    public String getCoefficient_client() {
        return coefficient_client;
    }

    public void setCoefficient_client(String coefficient_client) {
        this.coefficient_client = coefficient_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getAdresse_client() {
        return adresse_client;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresse_client = adresse_client;
    }

    public String getComp_adresse_client() {
        return comp_adresse_client;
    }

    public void setComp_adresse_client(String comp_adresse_client) {
        this.comp_adresse_client = comp_adresse_client;
    }

    public String getCode_postal_client() {
        return code_postal_client;
    }

    public void setCode_postal_client(String code_postal_client) {
        this.code_postal_client = code_postal_client;
    }

    public String getVille_client() {
        return ville_client;
    }

    public void setVille_client(String ville_client) {
        this.ville_client = ville_client;
    }

    public int getStatut_client() {
        return statut_client;
    }

    public void setStatut_client(int statut_client) {
        this.statut_client = statut_client;
    }

    public String getTel_client() {
        return tel_client;
    }

    public void setTel_client(String tel_client) {
        this.tel_client = tel_client;
    }

    public String getMail_client() {
        return mail_client;
    }

    public void setMail_client(String mail_client) {
        this.mail_client = mail_client;
    }

    public String getMdp_client() {
        return mdp_client;
    }

    public void setMdp_client(String mdp_client) {
        this.mdp_client = mdp_client;
    }

    public double getReduction_client() {
        return reduction_client;
    }

    public void setReduction_client(double reduction_client) {
        this.reduction_client = reduction_client;
    }

    public String getAdresse_livraison_client() {
        return adresse_livraison_client;
    }

    public void setAdresse_livraison_client(String adresse_livraison_client) {
        this.adresse_livraison_client = adresse_livraison_client;
    }

    public String getAdresse_facturation_client() {
        return adresse_facturation_client;
    }

    public void setAdresse_facturation_client(String adresse_facturation_client) {
        this.adresse_facturation_client = adresse_facturation_client;
    }

    public int getId_commercial() {
        return id_commercial;
    }

    public void setId_commercial(int id_commercial) {
        this.id_commercial = id_commercial;
    }
    
    public void print() {
        System.out.println(String.format("ID: %d\nnumero_client: %S\n=====", this.id_client, this.numero_client));
    }
}
