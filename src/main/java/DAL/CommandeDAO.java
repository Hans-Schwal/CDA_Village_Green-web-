/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.Date;
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
public class CommandeDAO {
        
    private Connection con;
        // Constructeur
        public CommandeDAO() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/village_green?serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", ""); 
        }
        
        @Override
        public void finalize() throws Throwable {
            this.con.close();
        } 
        
    public void Insert(Commande com) throws SQLException {
        PreparedStatement stm = con.prepareStatement("INSERT INTO `commande`(`numero_commande`, `date_commande`, `adresse_livraison_commande`, `adresse_facturation_commande`, `statut_commande`, `numero_facture`, `date_facture`, `tva`, `montant_ht`, `type_reglement`, `date_reglement_facture`, `id_client`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stm.setString(1, com.getNumero_commande());
            stm.setDate(2, (Date) com.getDate_commande());
            stm.setString(3, com.getAdresse_livraison_commande());
            stm.setString(4, com.getAdresse_facturation_commande());
            stm.setString(5, com.getStatut_commande());
            stm.setString(6, com.getNumero_facture());
            stm.setDate(7, (Date) com.getDate_facture());
            stm.setDouble(8, com.getTva());
            stm.setDouble(9, com.getMontant_ht());
            stm.setString(10, com.getType_reglement());
            stm.setDate(11, (Date) com.getDate_reglement_facture());
            stm.setInt(12, com.getId_client());

            stm.execute();
            
            stm.close();
    }

    public void Update(Commande com) throws SQLException {
        PreparedStatement stm = con.prepareStatement("UPDATE `commande` SET `numero_commande`=?, `date_commande`=?, `adresse_livraison_commande`=?, `adresse_facturation_commande`=?, `statut_commande`=?, `numero_facture`=?, `date_facture`=?, `tva`=?, `montant_ht`=?, `type_reglement`=?, `date_reglement_facture=?` WHERE `id_client` =?");
            
            stm.setString(1, com.getNumero_commande());
            stm.setDate(2, (Date) com.getDate_commande());
            stm.setString(3, com.getAdresse_livraison_commande());
            stm.setString(4, com.getAdresse_facturation_commande());
            stm.setString(5, com.getStatut_commande());
            stm.setString(6, com.getNumero_facture());
            stm.setDate(7, (Date) com.getDate_facture());
            stm.setDouble(8, com.getTva());
            stm.setDouble(9, com.getMontant_ht());
            stm.setString(10, com.getType_reglement());
            stm.setDate(11, (Date) com.getDate_reglement_facture());
            stm.setInt(12, com.getId_client());

            stm.execute();
            
            stm.close();
    }

    public void Delete(Commande com) throws SQLException {
        System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("DELETE FROM Commande WHERE id_commande =?");
            
            stm.setInt(1, com.getId_commande());

            stm.execute();
            
            stm.close();
    }

    public Commande Find(int id, Commande com) throws SQLException {
            System.out.println("connexion");

            PreparedStatement stm = con.prepareStatement("SELECT * FROM Commande WHERE id_client =?");
            
            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();
            Client cli = null;
            
            if (result.next()) {
                com = new Commande();
                
                stm.setString(1, com.getNumero_commande());
                stm.setDate(2, (Date) com.getDate_commande());
                stm.setString(3, com.getAdresse_livraison_commande());
                stm.setString(4, com.getAdresse_facturation_commande());
                stm.setString(5, com.getStatut_commande());
                stm.setString(6, com.getNumero_facture());
                stm.setDate(7, (Date) com.getDate_facture());
                stm.setDouble(8, com.getTva());
                stm.setDouble(9, com.getMontant_ht());
                stm.setString(10, com.getType_reglement());
                stm.setDate(11, (Date) com.getDate_reglement_facture());
                stm.setInt(12, com.getId_client());
     
            }
            
            stm.close();
            
            return com;
    }

    public List<Commande> List() throws SQLException {
        List<Commande> resultat = new ArrayList<>();


            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM commande");

            while (result.next()) {
                Commande com = new Commande();
                
                  com.setId_commande(result.getInt("id_commande"));
                  com.setNumero_commande(result.getString("numero_commande"));
                  com.setDate_commande(result.getDate("date_commande"));
                  com.setAdresse_livraison_commande(result.getString("adresse_livraison_commande"));
                  com.setAdresse_facturation_commande(result.getString("adresse_facturation_commande"));
                  com.setStatut_commande(result.getString("statut_commande"));
                  com.setNumero_facture(result.getString("numero_facture"));
                  com.setDate_facture(result.getDate("date_facture"));
                  com.setTva(result.getDouble("tva"));
                  com.setMontant_ht(result.getDouble("montant_ht"));
                  com.setType_reglement(result.getString("type_reglement"));
                  com.setDate_reglement_facture(result.getDate("date_reglement_facture"));
                  com.setId_client(result.getInt("id_client"));
                  resultat.add(com);
            }
            System.out.println(resultat);
            stm.close();
            
            result.close();
            
            return resultat;
    }
}
