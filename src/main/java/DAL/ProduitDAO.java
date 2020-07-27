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
public class ProduitDAO {
    private Connection con;
        // Constructeur
        public ProduitDAO() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/village_green?serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", ""); 
        }
        
        public void finalize() throws Throwable {
            this.con.close();
        }
        
    public void Insert(Produit pro) throws SQLException {
        
            PreparedStatement stm = con.prepareStatement("INSERT INTO `produit`(`ref_produit`, `ref_fournisseur`, `lien_photo_produit`, `designation_produit`, `description_produit`, `prix_achat_produit`, `prix_vente_produit`, `id_sous_rubrique`, `id_fournisseur`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stm.setString(1, pro.getRef_produit());
            stm.setString(2, pro.getRef_fournisseur());
            stm.setString(3, pro.getLien_photo_produit());
            stm.setString(4, pro.getDesignation_produit());
            stm.setString(5, pro.getDescription_produit());
            stm.setDouble(6, pro.getPrix_achat_produit());
            stm.setDouble(7, pro.getPrix_vente_produit());
            stm.setInt(8, pro.getId_sous_rubrique());
            stm.setInt(9, pro.getId_fournisseur());

            stm.execute();
            
            stm.close();
        }
        
    public void Update(Produit pro) throws SQLException {

        }
        
    public void Delete(Produit pro) throws SQLException {
      
        }

    public Produit Find(int id) throws SQLException {
        return null;
        }

    public List<Produit> List() throws SQLException {
        List<Produit> resultat = new ArrayList<>();


            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM produit");

                while (result.next()) {
                    Produit pro = new Produit();

                    pro.setId_produit(result.getInt("id_produit"));
                    pro.setRef_produit(result.getString("ref_produit"));
                    pro.setRef_fournisseur(result.getString("ref_fournisseur"));
                    pro.setLien_photo_produit(result.getString("lien_photo_produit"));
                    pro.setDesignation_produit(result.getString("designation_produit"));
                    pro.setDescription_produit(result.getString("description_produit"));
                    pro.setPrix_achat_produit(result.getDouble("prix_achat_produit"));
                    pro.setPrix_vente_produit(result.getDouble("prix_vente_produit"));
                    pro.setId_sous_rubrique(result.getInt("id_sous_produit"));
                    pro.setId_fournisseur(result.getInt("id_fournisseur"));
                    resultat.add(pro);
                }

            stm.close();
            
            result.close();
            
            return resultat;
        }
}
