/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 80010-04-09
 */
public class ClientDAOTest {
    
    public ClientDAOTest() {
    }
    // Insert 
    @Test
    public void Insert_cas1(){
        try {
            int id_client;
            String numero_client;
            String coefficient_client;
            String nom_client;
            String prenom_client;
            String adresse_client;
            String comp_adresse_client;
            String code_postal_client;
            String ville_client;
            int statut_client;
            String tel_client;
            String mail_client;
            String mdp_client;
            double reduction_client;
            String adresse_livraison_client;
            String adresse_facturation_client;
            int id_commercial;
            
            Client cli = new Client();
            
            cli.setNumero_client("CLI2208");
            cli.setCoefficient_client("12");
            cli.setNom_client("Vimart");
            cli.setPrenom_client("Valérie");
            cli.setAdresse_client("9 rue de Beaumetz");
            cli.setComp_adresse_client("Résidence La Chapelle");
            cli.setCode_postal_client("80370");
            cli.setVille_client("Bernaville");
            cli.setStatut_client(0);
            cli.setTel_client("0369584712");
            cli.setMail_client("valerie.vimart@test.fr");
            cli.setMdp_client("Hjrmpho65");
            cli.setReduction_client(10.50);
            cli.setAdresse_livraison_client("9 rue de Beaumetz Résidence La Chapelle 80370 Bernaville");
            cli.setAdresse_facturation_client("9 rue de Beaumetz Résidence La Chapelle 80370 Bernaville");
            cli.setId_commercial(1);
            
            ClientDAO repo = new ClientDAO();
            
            List<Client> liste1 = repo.List();
            
            repo.Insert(cli);
            
            List<Client> liste2 = repo.List();
            
            assertEquals(liste1.size()+1, liste2.size());
            
        } catch (SQLException ex) {
            System.out.println("Error...");
            fail("Error in test insert_cas1 " + ex.getMessage());
        }   
    }
    
    // Update 
    @Test
    public void Insert_cas2(){
        try {
            ClientDAO repo = new ClientDAO();
            
            List<Client> liste1 = repo.List();
            
            Client cli = liste1.get(liste1.size()-1);
            
            int id = cli.getId_client();
            
            cli.setNom_client("test");
            
            repo.Update(cli);
            
            Client cli2 = repo.Find(id);
            
            assertEquals(cli2.getNom_client(), "test");
            
        } catch (SQLException ex) {
            System.out.println("Error in test");
        }    
    }
    
    // Delete
    @Test
    public void Insert_cas3(){
        try {
            ClientDAO repo = new ClientDAO();
            
            List<Client> liste1 = repo.List();
            Client cli = liste1.get(liste1.size()-1);
            
            repo.Delete(cli);
            
            List<Client> liste2 = repo.List();
            
            assertEquals(liste1.size()-1, liste2.size());
            
        } catch (SQLException ex) {
            System.out.println("Error in test");
        }   
    } 
}
/**
 * 
 */