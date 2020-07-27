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
public class Commercial {
    private int id_commercial;
    private String nom_commercial;
    private String prenom_commercial;
    private String tel_commercial;
    private String mail_commercial;
    private String mdp_commercial;

    
    Commercial (){};

    public Commercial(int id_commercial, String nom_commercial, String prenom_commercial) {
        this.id_commercial = id_commercial;
        this.nom_commercial = nom_commercial;
        this.prenom_commercial = prenom_commercial;
    }

    public int getId_commercial() {
        return id_commercial;
    }

    public void setId_commercial(int id_commercial) {
        this.id_commercial = id_commercial;
    }

    public String getNom_commercial() {
        return nom_commercial;
    }

    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
    }

    public String getPrenom_commercial() {
        return prenom_commercial;
    }

    public void setPrenom_commercial(String prenom_commercial) {
        this.prenom_commercial = prenom_commercial;
    }

    public String getTel_commercial() {
        return tel_commercial;
    }

    public void setTel_commercial(String tel_commercial) {
        this.tel_commercial = tel_commercial;
    }

    public String getMail_commercial() {
        return mail_commercial;
    }

    public void setMail_commercial(String mail_commercial) {
        this.mail_commercial = mail_commercial;
    }

    public String getMdp_commercial() {
        return mdp_commercial;
    }

    public void setMdp_commercial(String mdp_commercial) {
        this.mdp_commercial = mdp_commercial;
    }
    
    @Override
    public String toString(){
        return this.nom_commercial;
    }
            
    



}
