<?php

class Api extends CI_Controller {

    public function liste() {
        
        $tab = $this->db->query('SELECT * FROM client')->result();
	
	    $this->output->set_content_type('application/json');
        $this->output->set_header('Access-Control-Allow-Origin: *');
        
        $this->output->set_output(json_encode($tab));
    }

    public function CommercialsList() {
        
        $tab = $this->db->query('SELECT * FROM commercial')->result();
	
	    $this->output->set_content_type('application/json');
        $this->output->set_header('Access-Control-Allow-Origin: *');
        
        $this->output->set_output(json_encode($tab));
    }


    public function insert() {

        header("Access-Control-Allow-Origin: *");
        header('Content-Type: application/json');
	
        //$json = file_get_contents('php://input', true);
        $json = $this->input->raw_input_stream;

        //var_dump($json);

        $data = json_decode($json);

        //echo $data->nom;
            
        $this->db->query("INSERT INTO client (numero_client, coefficient_client, nom_client, prenom_client, adresse_client, comp_adresse_client, code_postal_client, ville_client, statut_client, tel_client, mail_client, mdp_client, reduction_client,  adresse_livraison_client, adresse_facturation_client, id_commercial) 
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1);", array($data->numero_client, $data->coefficient_client, $data->nom_client, $data->prenom_client, $data->adresse_client, $data->comp_adresse_client, $data->code_postal_client, $data->ville_client,$data->statut_client, $data->tel_client, $data->mail_client, $data->mdp_client, $data->reduction_client, $data->adresse_livraison_client, $data->adresse_facturation_client));
            
        echo('{ "message": "ok" }');
    }

    public function update() {

        header("Access-Control-Allow-Origin: *");
        header('Content-Type: application/json');
	
        //$json = file_get_contents('php://input', true);
        $json = $this->input->raw_input_stream;

        //var_dump($json);

        $data = json_decode($json);

        //echo $data->nom;
            
        $this->db->query("UPDATE client SET numero_client=?, coefficient_client=?, nom_client=?, prenom_client=?, adresse_client=?, comp_adresse_client=?, code_postal_client=?, ville_client=?, statut_client=?, tel_client=?, mail_client=?, mdp_client=?, reduction_client=?, adresse_livraison_client=?, adresse_facturation_client=?, id_commercial=? WHERE id_client=?", 
        array($data->numero_client, $data->coefficient_client, $data->nom_client, $data->prenom_client, $data->adresse_client, $data->comp_adresse_client, $data->code_postal_client, $data->ville_client,$data->statut_client, $data->tel_client, $data->mail_client, $data->mdp_client, $data->reduction_client, $data->adresse_livraison_client, $data->adresse_facturation_client, $data->id_commercial, $data->id_client));
            
        echo('{ "message": "ok" }');
    }

    public function delete() {

        header("Access-Control-Allow-Origin: *");
        header('Content-Type: application/json');
	
        //$json = file_get_contents('php://input', true);
        $json = $this->input->raw_input_stream;

        //var_dump($json);

        $data = json_decode($json);

        //echo $data->nom;
            
        $this->db->query("DELETE FROM client WHERE id_client=?", array($data->id_client));
            
        echo('{ "message": "ok" }');
    }

    public function listeProduit() {
        
        $tab = $this->db->query('SELECT * FROM produit')->result();
	
	    $this->output->set_content_type('application/json');
        $this->output->set_header('Access-Control-Allow-Origin: *');
        
        $this->output->set_output(json_encode($tab));
    }

    public function detailProduit($id) {

        $tab = $this->db->query("SELECT * FROM produit WHERE id_produit=?", $id)->result();

        $this->output->set_content_type('application/json');
        $this->output->set_header('Access-Control-Allow-Origin: *');
        
        $this->output->set_output(json_encode($tab));
    }
}
