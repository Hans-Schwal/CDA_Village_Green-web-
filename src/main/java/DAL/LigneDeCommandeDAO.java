/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-04-09
 */
public class LigneDeCommandeDAO {
    private Connection con;
        // Constructeur
        public LigneDeCommandeDAO() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/village_green?serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", ""); 
        }
        
        @Override
        public void finalize() throws Throwable {
            this.con.close();
        }
        
    public void Insert(LigneDeCommande cli) {
    }

    public void Update(LigneDeCommande cli) {
    }

    public void Delete(LigneDeCommande cli) {
    }

    public LigneDeCommande Find(int id)     {
            return null;
    }

    public List<LigneDeCommande> List() throws SQLException {
        List<LigneDeCommande> resultat = new ArrayList<>();


            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM ligne_de_commande");

            while (result.next()) {
                LigneDeCommande lig = new LigneDeCommande();
                
                  lig.setId_ligne_commande(result.getInt("id_ligne_de_commande"));
                  lig.setRef_produit_commande(result.getString("ref_produit_commande"));
                  lig.setDesignation_produit_commande(result.getString("designation_produit_commande"));
                  lig.setPrix_unitaire_ht(result.getDouble("prix_unitaire_ht"));
                  lig.setQuantite_produit(result.getInt("quantite_produit"));
                  lig.setTotal_ttc(result.getDouble("total_produit"));
                  lig.setId_produit(result.getInt("id_produit"));
                  lig.setId_commande(result.getInt("id_commande"));
                  resultat.add(lig);
            }
            System.out.println(resultat);
            stm.close();
            
            result.close();
            
            return resultat;
    }
}   

