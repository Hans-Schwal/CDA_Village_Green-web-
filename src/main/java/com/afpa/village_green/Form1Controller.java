/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.village_green;

import API.Api;
import DAL.Client;
import DAL.ClientDAO;
import DAL.Clientn;
import DAL.Commercial;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author 80010-04-09
 */
public class Form1Controller implements Initializable {

    // Création d'un label contenant un message qui s'affichera en cas d'erreur
    @FXML
    private Label message;
    @FXML
    private TableView<Client> tableView;
    
    ObservableList<Client> model = FXCollections.observableArrayList();
 
   // ObservableList<Commercial> model_commercial = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Client, String> col_num;
    @FXML
    private TableColumn<Client, String> col_coeff;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_adresse;
    @FXML
    private TableColumn<Client, String> col_comp_adresse;
    @FXML
    private TableColumn<Client, String> col_codepos;
    @FXML
    private TableColumn<Client, String> col_ville;
    @FXML
    private TableColumn<Client, Integer> col_statut;
    @FXML
    private TableColumn<Client, String> col_tel;
    @FXML
    private TableColumn<Client, String> col_mail;
    @FXML
    private TableColumn<Client, String> col_mdp;
    @FXML
    private TableColumn<Client, Double> col_reduc;
    @FXML
    private TableColumn<Client, String> col_adresse_liv;
    @FXML
    private TableColumn<Client, String> col_adresse_fac;
    @FXML
    private TableColumn<Client, Integer> col_id_commercial;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_supprim;
    @FXML
    private TextField txt_num_client;
    @FXML
    private TextField txt_coeff;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_comp_adresse;
    @FXML
    private TextField txt_codpos;
    @FXML
    private TextField txt_ville;
    @FXML
    private TextField txt_stat_client;
    @FXML
    private TextField txt_tel;
    @FXML
    private TextField txt_mail;
    @FXML
    private TextField txt_mdp;
    @FXML
    private TextField txt_reduc;
    @FXML
    private TextField txt_adresse_liv;
    @FXML
    private TextField txt_adresse_fac;
    @FXML
    private ComboBox<Commercial> txt_id_comm;
    @FXML
    private Pane pane;
    @FXML
    private Button btn_ok;
    @FXML
    private Button btn_annuler;
    @FXML
    private Label lbl_miss_adresse_fac;
    @FXML
    private Label lbl_miss_tel;
    @FXML
    private Label lbl_miss_mail;
    @FXML
    private Label lbl_miss_mdp;
    @FXML
    private Label lbl_miss_reduc;
    @FXML
    private Label lbl_miss_adresse_liv;
    @FXML
    private Label lbl_miss_adresse;
    @FXML
    private Label lbl_miss_comp_adresse;
    @FXML
    private Label lbl_miss_codpos;
    @FXML
    private Label lbl_miss_ville;
    @FXML
    private Label lbl_miss_stat_client;
    @FXML
    private Label lbl_miss_num_client;
    @FXML
    private Label lbl_miss_coeff;
    @FXML
    private Label lbl_miss_nom;
    @FXML
    private Label lbl_miss_prenom;
    @FXML
    private Button btn_commandes;
    
    String action = "";
    
    Client actionCli;
    
    ClientDAO repo;
    
    private CheckInput num_client;
    private CheckInput coeff;
    private CheckInput prenom;
    private CheckInput nom;
    private CheckInput adresse;
    private CheckInput comp_adresse;
    private CheckInput codpos;
    private CheckInput ville;
    private CheckInput stat_client;
    private CheckInput tel;
    private CheckInput mail;
    private CheckInput mdp;
    private CheckInput reduc;
    private CheckInput adresse_liv;
    private CheckInput adresse_fac;
    private ArrayList<CheckInput> allInputs;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        col_num.setCellValueFactory(new PropertyValueFactory<>("numero_client"));
        col_coeff.setCellValueFactory(new PropertyValueFactory<>("coefficient_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_client"));	
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_client"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_client"));
        col_comp_adresse.setCellValueFactory(new PropertyValueFactory<>("comp_adresse_client"));
        col_codepos.setCellValueFactory(new PropertyValueFactory<>("code_postal_client"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville_client"));
        col_statut.setCellValueFactory(new PropertyValueFactory<>("statut_client"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel_client"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail_client"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp_client"));
        col_reduc.setCellValueFactory(new PropertyValueFactory<>("reduction_client"));
        col_adresse_liv.setCellValueFactory(new PropertyValueFactory<>("adresse_livraison_client"));
        col_adresse_fac.setCellValueFactory(new PropertyValueFactory<>("adresse_facturation_client"));
        col_id_commercial.setCellValueFactory(new PropertyValueFactory<>("id_commercial"));
        
        tableView.setItems(model);
 
        try{
            repo = new ClientDAO();
            txt_id_comm.getItems().addAll(repo.CommercialsList());

            model.clear();
            //model.addAll(repo.List());
            model.addAll(Api.List());
            
            
            //List<Clientn> liste = Api.getAll();
            
//            for (Clientn clientn : liste) {
//                System.out.println(clientn.getNom());
//            }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        //txt_id_comm.getSelectionModel().select(0);
        //txt_adresse_fac.setText(txt_id_comm.getValue().getNom_commercial());
        
        prenom = new CheckInput(txt_prenom, lbl_miss_prenom, "un prénom");
        num_client = new CheckInput(txt_num_client, lbl_miss_num_client, "un numéro client");
        coeff = new CheckInput(txt_coeff, lbl_miss_coeff, "un coefficient", "^[0-9]+$");
        nom = new CheckInput(txt_nom, lbl_miss_nom, "un nom");
        adresse = new CheckInput(txt_adresse, lbl_miss_adresse, "une adresse");
        comp_adresse = new CheckInput(txt_comp_adresse, lbl_miss_comp_adresse, "une adresse complémentaire");
        comp_adresse.setIsNeeded(false);
        codpos = new CheckInput(txt_codpos, lbl_miss_codpos, "un code postal au format 00000");
        ville = new CheckInput(txt_ville, lbl_miss_ville, "une ville");
        stat_client = new CheckInput(txt_stat_client, lbl_miss_stat_client, "un statut client");
        tel = new CheckInput(txt_tel, lbl_miss_tel, "un numéro\n de téléphone a 10 chiffres", "^(\\+\\d+(\\s|-))?0\\d(\\s|-)?(\\d{2}(\\s|-)?){4}");
        mail = new CheckInput(txt_mail, lbl_miss_mail, "une adresse email valide", "^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$");
        mdp = new CheckInput(txt_mdp, lbl_miss_mdp, "un mot de passe non vide");
        reduc = new CheckInput(txt_reduc, lbl_miss_reduc, "un taux de réduction");
        adresse_liv = new CheckInput(txt_adresse_liv, lbl_miss_adresse_liv, "une adresse\n de livraison");
        adresse_fac = new CheckInput(txt_adresse_fac, lbl_miss_adresse_fac, "une adresse\n de facturation");
        
        allInputs = new ArrayList<CheckInput>(CheckInput.createCheckInputList(prenom, num_client, coeff, nom, adresse, comp_adresse, codpos, ville, stat_client, tel, mail, mdp, reduc, adresse_liv, adresse_fac));
    }
    
    @FXML
    private void btn_ok_click(ActionEvent event) {
        System.out.println("OK Button");
        try {
            for(CheckInput ci : allInputs) {
                ci.resetStyle();
            }
            switch(action){
                case "ajouter":
                    actionCli = (actionCli == null) ? new Client() : actionCli;
                    break;
                case "modifier":
                    actionCli = (actionCli == null) ? tableView.getSelectionModel().getSelectedItem() : actionCli;
                    break;
                case "supprimer":
                    actionCli = tableView.getSelectionModel().getSelectedItem();
                    break;
                case "afficher les commandes":
                    actionCli = tableView.getSelectionModel().getSelectedItem();
                default:
                    // throw error
                    break;
            } 

            try {
                if (this.checkAllInputs(actionCli)){
                    actionCli.print();
                    if (action == "ajouter") {
                        //repo.Insert(actionCli);
                        Api.Insert(actionCli);
                    }
                    if (action == "modifier") repo.Update(actionCli);
                    if (action == "supprimer") repo.Delete(actionCli);

                    action = "";
                    actionCli = null;
                    pane.setVisible(false);
                }
            } catch(MissFormatException e){
                for(CheckInput checkInput : e.getErrorCheckInputs()) {
                    checkInput.setErrorMode();
                }
            }
            model.clear();
            model.addAll(repo.List());
            
        } catch (SQLException ex) {
            message.setText("Error " + ex.getMessage());
        }
    }
    
    private boolean checkAllInputs(Client cli) throws MissFormatException{
        MissFormatException missFormat = new MissFormatException();
        System.out.println(cli);
        cli.setNumero_client(num_client.getStringInput(missFormat));
        cli.setCoefficient_client(coeff.getStringInput(missFormat));
        cli.setNom_client(nom.getStringInput(missFormat));
        cli.setPrenom_client(prenom.getStringInput(missFormat));
        cli.setAdresse_client(adresse.getStringInput(missFormat));
        cli.setComp_adresse_client(comp_adresse.getStringInput(missFormat));
        cli.setCode_postal_client(codpos.getStringInput(missFormat));
        cli.setVille_client(ville.getStringInput(missFormat));
        cli.setMdp_client(mdp.getStringInput(missFormat));
        cli.setAdresse_livraison_client(adresse_liv.getStringInput(missFormat));
        cli.setAdresse_facturation_client(adresse_fac.getStringInput(missFormat));

        cli.setTel_client(tel.getStringInput(missFormat));
       
        cli.setMail_client(mail.getStringInput(missFormat));

        cli.setStatut_client(stat_client.getIntInput(missFormat));

        cli.setReduction_client(reduc.getDoubleInput(missFormat));
       
        cli.setId_commercial(txt_id_comm.getValue().getId_commercial()); // check if exists
        
        if (!missFormat.isEmpty()){
            throw missFormat;
        }
        
        return true;
    }
    
    @FXML
    private void btn_annuler_click(ActionEvent event) {
        pane.setVisible(false);
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        pane.setVisible(true);

        txt_num_client.setText("");
        txt_coeff.setText("");
        txt_nom.setText("");
        txt_prenom.setText("");
        txt_adresse.setText("");
        txt_comp_adresse.setText("");
        txt_codpos.setText("");
        txt_ville.setText("");
        txt_stat_client.setText("");
        txt_tel.setText("");
        txt_mail.setText("");
        txt_mdp.setText("");
        txt_reduc.setText("");
        txt_adresse_liv.setText("");
        txt_adresse_fac.setText("");
        try {
            txt_id_comm.setValue(repo.getCommercialById(1));
        } catch(SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }
        action = "ajouter";
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        pane.setVisible(true);
        
        if (tableView.getSelectionModel().getSelectedItem() != null) {
        Client cli = tableView.getSelectionModel().getSelectedItem();
        
        txt_num_client.setText(cli.getNumero_client());
        txt_coeff.setText(cli.getCoefficient_client());
        txt_nom.setText(cli.getNom_client());
        txt_prenom.setText(cli.getPrenom_client());
        txt_adresse.setText(cli.getAdresse_client());
        txt_comp_adresse.setText(cli.getComp_adresse_client());
        txt_codpos.setText(cli.getCode_postal_client());
        txt_ville.setText(cli.getVille_client());
        txt_stat_client.setText(String.valueOf(cli.getStatut_client()));
        txt_tel.setText(cli.getTel_client());
        txt_mail.setText(cli.getMail_client());
        txt_mdp.setText(cli.getMdp_client());
        txt_reduc.setText(String.valueOf(cli.getReduction_client()));
        txt_adresse_liv.setText(cli.getAdresse_livraison_client());
        txt_adresse_fac.setText(cli.getAdresse_facturation_client());
        //txt_id_comm.setText(String.valueOf(cli.getId_commercial()));
        try {
            txt_id_comm.setValue(repo.getCommercialById(1));
        } catch(SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }
        pane.setVisible(true);
        action = "modifier";
        }
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        pane.setVisible(true);
        
        if (tableView.getSelectionModel().getSelectedItem() != null) {
        Client cli = tableView.getSelectionModel().getSelectedItem();
        
        txt_num_client.setText(cli.getNumero_client());
        txt_coeff.setText(cli.getCoefficient_client());
        txt_nom.setText(cli.getNom_client());
        txt_prenom.setText(cli.getPrenom_client());
        txt_adresse.setText(cli.getAdresse_client());
        txt_comp_adresse.setText(cli.getComp_adresse_client());
        txt_codpos.setText(cli.getCode_postal_client());
        txt_ville.setText(cli.getVille_client());
        txt_stat_client.setText(String.valueOf(cli.getStatut_client()));
        txt_tel.setText(cli.getTel_client());
        txt_mail.setText(cli.getMail_client());
        txt_mdp.setText(cli.getMdp_client());
        txt_reduc.setText(String.valueOf(cli.getReduction_client()));
        txt_adresse_liv.setText(cli.getAdresse_livraison_client());
        txt_adresse_fac.setText(cli.getAdresse_facturation_client());
        //txt_id_comm.setValue(String.valueOf(cli.getId_commercial()));
        try {
            txt_id_comm.setValue(repo.getCommercialById(1));
        } catch(SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }
        pane.setVisible(true);
        action = "supprimer";
        }
    }

    @FXML
    private void combo_action(ActionEvent event) {
        txt_id_comm.getValue();
    }
    
    @FXML
    public void voir_commandes(ActionEvent event){
        System.out.println("voir commandes");
    }
}
