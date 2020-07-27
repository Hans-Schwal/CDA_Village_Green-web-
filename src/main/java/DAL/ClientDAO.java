/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-04-09
 */
public class ClientDAO {
    
        private Connection con;
        // Constructeur
        public ClientDAO() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/village_green?serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", ""); 
        }
        
        public void finalize() throws Throwable {
            this.con.close();
        }

// On gérera les exceptions avec le controller plutôt que sur le pattern DAO
    public void Insert(Client cli) throws SQLException {


            
            PreparedStatement stm = con.prepareStatement("INSERT INTO `client`(`numero_client`, `coefficient_client`, `nom_client`, `prenom_client`, `adresse_client`, `comp_adresse_client`, `code_postal_client`, `ville_client`, `statut_client`, `tel_client`, `mail_client`, `mdp_client`, `reduction_client`, `adresse_livraison_client`, `adresse_facturation_client`, `id_commercial`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stm.setString(1, cli.getNumero_client());
            stm.setString(2, cli.getCoefficient_client());
            stm.setString(3, cli.getNom_client());
            stm.setString(4, cli.getPrenom_client());
            stm.setString(5, cli.getAdresse_client());
            stm.setString(6, cli.getComp_adresse_client());
            stm.setString(7, cli.getCode_postal_client());
            stm.setString(8, cli.getVille_client());
            stm.setInt(9, cli.getStatut_client());
            stm.setString(10, cli.getTel_client());
            stm.setString(11, cli.getMail_client());
            stm.setString(12, cli.getMdp_client());
            stm.setDouble(13, cli.getReduction_client());
            stm.setString(14, cli.getAdresse_livraison_client());
            stm.setString(15, cli.getAdresse_facturation_client());
            stm.setInt(16, cli.getId_commercial());

            stm.execute();
            
            stm.close();
    }

    public void Update(Client cli) throws SQLException {

//            String url = "jdbc:mysql://localhost:3306/village_green?serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement stm = con.prepareStatement("UPDATE `client` SET `numero_client` = ?, `coefficient_client` = ?, `nom_client` = ?, `prenom_client` = ?, `adresse_client` = ?, `comp_adresse_client` = ?, `code_postal_client` = ?, `ville_client` = ?, `statut_client` = ?, `tel_client` = ?, `mail_client` = ?, `mdp_client` = ?, `reduction_client` = ?, `adresse_livraison_client` = ?, `adresse_facturation_client` = ?, `id_commercial` = ? WHERE `id_client`=?");
            
            stm.setString(1, cli.getNumero_client());
            stm.setString(2, cli.getCoefficient_client());
            stm.setString(3, cli.getNom_client());
            stm.setString(4, cli.getPrenom_client());
            stm.setString(5, cli.getAdresse_client());
            stm.setString(6, cli.getComp_adresse_client());
            stm.setString(7, cli.getCode_postal_client());
            stm.setString(8, cli.getVille_client());
            stm.setInt(9, cli.getStatut_client());
            stm.setString(10, cli.getTel_client());
            stm.setString(11, cli.getMail_client());
            stm.setString(12, cli.getMdp_client());
            stm.setDouble(13, cli.getReduction_client());
            stm.setString(14, cli.getAdresse_livraison_client());
            stm.setString(15, cli.getAdresse_facturation_client());
            stm.setInt(16, cli.getId_commercial());
            stm.setInt(17, cli.getId_client());

            stm.execute();
            
            stm.close();
    }

    public void Delete(Client cli) throws SQLException {

            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("DELETE FROM Client WHERE id_client =?");
            
            stm.setInt(1, cli.getId_client());

            stm.execute();
            
            stm.close();
    }

    public Client Find(int id) throws SQLException {

            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("SELECT * FROM Client WHERE id_client =?");
            
            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();
            Client cli = null;
            
            if (result.next()) {
                cli = new Client();
                
                cli.setId_client(result.getInt("id_client"));
                cli.setNumero_client(result.getString("numero_client"));
                cli.setCoefficient_client(result.getString("coefficient_client"));
                cli.setNom_client(result.getString("nom_client"));
                cli.setPrenom_client(result.getString("prenom_client"));
                cli.setAdresse_client(result.getString("adresse_client"));
                cli.setComp_adresse_client(result.getString("comp_adresse_client"));
                cli.setCode_postal_client(result.getString("code_postal_client"));
                cli.setVille_client(result.getString("ville_client"));
                cli.setStatut_client(result.getInt("statut_client"));
                cli.setTel_client(result.getString("tel_client"));
                cli.setMail_client(result.getString("mail_client"));
                cli.setMdp_client(result.getString("mdp_client"));
                cli.setReduction_client(result.getDouble("reduction_client"));
                cli.setAdresse_livraison_client(result.getString("adresse_livraison_client"));
                cli.setAdresse_facturation_client(result.getString("adresse_facturation_client"));
                cli.setId_commercial(result.getInt("id_commercial"));
     
            }
            
            stm.close();
            
            return cli;
    }

    public List<Client> List() throws SQLException {
        List<Client> resultat = new ArrayList<Client>();


            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM client");

            while (result.next()) {
                Client cli = new Client();
                
                cli.setId_client(result.getInt("id_client"));
                cli.setNumero_client(result.getString("numero_client"));
                cli.setCoefficient_client(result.getString("coefficient_client"));
                cli.setNom_client(result.getString("nom_client"));
                cli.setPrenom_client(result.getString("prenom_client"));
                cli.setAdresse_client(result.getString("adresse_client"));
                cli.setComp_adresse_client(result.getString("comp_adresse_client"));
                cli.setCode_postal_client(result.getString("code_postal_client"));
                cli.setVille_client(result.getString("ville_client"));
                cli.setStatut_client(result.getInt("statut_client"));
                cli.setTel_client(result.getString("tel_client"));
                cli.setMail_client(result.getString("mail_client"));
                cli.setMdp_client(result.getString("mdp_client"));
                cli.setReduction_client(result.getDouble("reduction_client"));
                cli.setAdresse_livraison_client(result.getString("adresse_livraison_client"));
                cli.setAdresse_facturation_client(result.getString("adresse_facturation_client"));
                cli.setId_commercial(result.getInt("id_commercial"));
                resultat.add(cli);
            }

            stm.close();
            
            result.close();
            
            return resultat;
    }
    
    public List<Commercial> CommercialsList() throws SQLException {

            List commerciaux = new ArrayList<Commercial>();
            
            PreparedStatement stm = con.prepareStatement ("SELECT * FROM commercial");
            ResultSet result =stm.executeQuery ();
            
            while (result.next()) {
               commerciaux.add(this.makeCommercial(result));
            }

            result.close();
            return commerciaux;
    }
    
    private Commercial makeCommercial(ResultSet result) throws SQLException {
        int id = result.getInt("id_commercial");
        String nom = result.getString("nom_commercial");
        String prenom = result.getString("prenom_commercial");

        Commercial cc = new Commercial(id, nom, prenom);

        return cc;
    }
    
    public Commercial getCommercialById(int id) throws SQLException {
        PreparedStatement stm = con.prepareStatement("SELECT * FROM commercial WHERE id_commercial=? LIMIT 1;");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        result.next();
        Commercial out = this.makeCommercial(result);
        stm.close();
        return out;
    }
}
