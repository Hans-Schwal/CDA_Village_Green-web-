<?php

class Site extends CI_Controller {
    //Déclaration d'une constante pour attribuer une valeur par défaut au champ (clé étrangère) "id_commercial" de la table "client"
    const DEFAULT_COMMERCIAL_ID = 1;
    //Déclaration d'une constante pour attribuer une valeur par défaut au champ "tva" de la table "commande"
    const DEFAULT_TVA = 20.00;
    //Déclaration d'une constante pour attribuer une valeur par défaut au champ "statut commande" de la table "commande"
    const DEFAULT_STATUT_COMMANDE = "En cours de préparation";
    // const DEFAULT_DATE_COMMANDE = date("Y-m-d H:i:s");
    //Déclaration d'une constante pour attribuer une valeur par défaut au champ "statut client" de la table "client"
    const DEFAULT_STATUT_CLIENT = 0;

    public function index() {
        $data = $this->get_header();

        $this->load->view("header", $data);
        $this->load->view("home");
        $this->load->view("footer");
    }

    public function inscription() {
        // $this->output->enable_profiler(true);
        $data = $this->get_header();
        
        $this->form_validation->set_rules(
            'mail_client', 
            'Adresse e-mail', 
            'required|regex_match[/^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/]|is_unique[client.mail_client]',
             array(
                'required' => 'Vous n\'avez pas entré l\' %s',
                'regex_match[/^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/]' => 'Le format de l\'adresse email est incorrect',
                'is_unique'     => 'L\'adresse email est déjà utilisée.'
             )
        );
        $this->form_validation->set_rules(
            'mdp_client',
            'le mot de passe',
            'required|min_length[8]',
            array(
                'required'      => 'Vous n\'avez pas saisi %s.',
                'min_length'     => '%s est trop <b>court</b>'
                )
        );    
        $this->form_validation->set_rules(
            'confirmPassword', 
            'Confirmation du mot de passe', 
            'required|min_length[8]',
            array(
                'required' => 'Vous n\'avez pas  saisi la confirmation du mot de passe.',
                'min_length'     => '%s est trop <b>court</b>'
            )
        );
        $this->form_validation->set_rules(
            'prenom_client',
            'prénom',
            'required|regex_match[/^[\wéèîéêàçîï][\w\s\-\'éèîéêàçîï]+$/i]',
             array(
                'required' => 'Vous n\'avez pas saisi le prénom', 
                'regex_match[/^[\wéèîéêàçîï][\w\s\-\'éèîéêàçîï]+$/i]' => 'Le format du prénom est incorrect' 
             )
        );
        $this->form_validation->set_rules(
            'nom_client',
            'nom',
            'required|regex_match[/^[\wéèîéêàçîï][\w\s\-\'éèîéêàçîï]+$/i]',
            array(
                'required' => 'Vous n\'avez pas saisi le nom',
                'regex_match[/^[\wéèîéêàçîï][\w\s\-\'éèîéêàçîï]+$/i]' => 'Le format du nom est incorrect'
            )
        );
        $this->form_validation->set_rules(
            'adresse_client',
            'adresse',
            'required|regex_match[/^\d+\s[A-z]+\s[A-z]+/]',
            array(
                'required' => 'Vous n\'avez pas saisi l\'adresse', 
                'regex_match[/^\d+\s[A-z]+\s[A-z]+/]' => 'Le format de l\'adresse est incorrect'
            )
        );
        $this->form_validation->set_rules('comp_adresse_client', 'complément d\'adresse', 'regex_match[/^[A-ZéèîïÉÈÏÎ]+([-\'\s][A-ZéèîïÉÈÏÎ]+)?$/]', array('regex_match[/^[A-ZéèîïÉÈÏÎ]+([-\'\s][A-ZéèîïÉÈÏÎ]+)?$/]' => 'Le format du complément d\'adresse est incorrect'));
        $this->form_validation->set_rules(
            'code_postal_client',
            'code postal',
            'required|regex_match[/^\d{5}$/]',
            array(
                'required' => 'Vous n\'avez pas saisi le code postal', 
                'regex_match[/^\d{5}$/]' => 'Le format du code postal est incorrect'
            )
        );
        $this->form_validation->set_rules(
            'ville_client',
            'ville',
            'required|regex_match[/^[A-Za-zéèîïÉÈÏÎ][a-zéèêàçîï]+([-\'\s][a-zA-ZéèîïÉÈÏÎ][a-zéèêàçîï]+)?$/]',
            array(
                'required' => 'Vous n\'avez pas saisi la ville', 
                'regex_match[/^[A-Za-zéèîïÉÈÏÎ][a-zéèêàçîï]+([-\'\s][a-zA-ZéèîïÉÈÏÎ][a-zéèêàçîï]+)?$/]' => 'Le format de la ville est incorrect'
            )
        );
        $this->form_validation->set_rules(
            'pays_client',
            'pays',
            'required|regex_match[/^[A-Za-zéèîïÉÈÏÎ][a-zéèêàçîï]+([-\'\s][a-zA-ZéèîïÉÈÏÎ][a-zéèêàçîï]+)?$/]',
            array(
                'required' => 'Vous n\'avez pas saisi le pays', 
                'regex_match[/^[A-Za-zéèîïÉÈÏÎ][a-zéèêàçîï]+([-\'\s][a-zA-ZéèîïÉÈÏÎ][a-zéèêàçîï]+)?$/]' => 'Le format de le pays est incorrect'
            )
        );
        
        if ($this->input->post() && $this->form_validation->run()) {
            $this->output->enable_profiler(true);

            $tab = $this->input->post();

            $tab["prenom_client"] = ucwords(strtolower($tab["prenom_client"]));
            $tab["nom_client"] = strtoupper($tab["nom_client"]);
            // utilisation de la constante attribuant une valeur par défaut au champ "id_commercial"
            $tab["id_commercial"] = self::DEFAULT_COMMERCIAL_ID;
            $tab["statut_client"] = self::DEFAULT_STATUT_CLIENT;
            unset($tab["confirmPassword"]);
            unset($tab["pays_client"]);
            // hashage du mot de passe client afin de ne stoker dans la db que le mot de passe "hashé".
            // en aucun cas un mot de passe ne doit être stocké en clair (cf. sécurité)
            $tab["mdp_client"] = password_hash($tab["mdp_client"], PASSWORD_DEFAULT);
            
            $this->db->trans_start();
            $this->db->insert("client", $tab);
            $id = $this->db->insert_id();
            $this->db->trans_complete();

            redirect('site/inscriptionReussie');

        } else {
            // $this->output->enable_profiler(true);
        $this->load->helper("form");
        $this->load->view("header", $data);
        $this->load->view("inscription");
        $this->load->view("footer");
        
        }
    }

    //Affiche une page informant l'utilisateur de la réussite de son inscription
    public function inscriptionReussie() {
        $data = $this->get_header();

        $this->load->view("header", $data);
        $this->load->view("inscriptionReussie");
        $this->load->view("footer");
    }

    public function connexion() {
        $data = $this->get_header();
        
        //conditions de connexion
        if ($this->input->post()) {
            
            $e = $this->input->post("mail_client");
            $p = $this->input->post("mdp_client");
            if ($this->auth->login($e, $p, "client")) {
                redirect(site_url("site/connexionReussie"));
            } else {
                redirect(site_url("site/connexion"));
            }
        }

        $this->load->helper("form");
        $this->load->view("header", $data);
        $this->load->view("connexion");
        $this->load->view("footer");
    }

    //Affiche une page informant l'utilisateur de la réussite de sa connexion
    public function connexionReussie() {
        $data = $this->get_header();

        $this->load->view("header", $data);
        $this->load->view("connexionReussie");
        $this->load->view("footer");
    }

    //déconnexion
    public function logout() {

        $this->auth->logout();
        redirect(site_url("site/index")); 
    }
    

    public function sousRubrique($id_sous_rubrique) {
        $data = $this->get_header();

        $liste2 = $this->db->query("select * from sous_rubrique where id_sous_rubrique=?", $id_sous_rubrique)->result();

        foreach ($liste2 as $sous_rub) {
            $sous_rub->produits = $this->db->query("select * from produit where id_sous_rubrique=?", $sous_rub->id_sous_rubrique)->result();
        }

        $data["liste2"] = $liste2;

        $this->load->view("header", $data);
        $this->load->view("sousRubrique");
        $this->load->view("footer");
    }

    public function ficheProduit($id_produit) {
        $data = $this->get_header();

        $liste2 = $this->db->query("select * from produit where id_produit=?;", $id_produit)->row();
        
        $data["prod"] = $liste2;
     
        
        $this->load->view("header", $data);
        $this->load->view("ficheProduit");
        $this->load->view("footer");
    }

    public function panier() {
        $data = $this->get_header();

        $data["panier"] = $this->basket->get_basket();

        $this->load->view("header", $data);
        $this->load->view("panier");
        $this->load->view("footer");
    }

    public function add($id) {
    
        $produit = $this->db->query("select * from produit where id_produit=?", $id)->row();

        $data = [
            "id" => $produit->id_produit, 
            "lien_photo_produit" => $produit->lien_photo_produit,
            "designation_produit" => $produit->designation_produit, 
            "description_produit" => $produit->description_produit, 
            "prix_vente_produit" => $produit->prix_vente_produit, 
        ];

        $qte = $this->input->post("quantite_produit");

        $this->basket->add($data, $qte );

        redirect(site_url("site/index"));
    }

    public function remove($id) {
        
        $produit = $this->db->query("select * from produit where id_produit=?", $id)->row();

        $data = [
            "id" => $produit->id_produit, 
            "lien_photo_produit" => $produit->lien_photo_produit,
            "designation_produit" => $produit->designation_produit, 
            "description_produit" => $produit->description_produit, 
            "prix_vente_produit" => $produit->prix_vente_produit, 
        ];

        $this->basket->remove($data);

        redirect(site_url("site/panier"));
    }

    public function clean() {
        $this->basket->clean();

        redirect(site_url("site/panier"));
    }

    public function commande() {
        $data = $this->get_header();

        // Affichage du contenu du panier
        $data["panier"] = $this->basket->get_basket();
        
        // Formulaire 
        $this->form_validation->set_rules(
            'adresse_livraison_commande', 
            'Adresse de livraison', 
            'required',
             array(
                'required' => 'Vous n\'avez pas entré l\' %s',
             )
        );
        $this->form_validation->set_rules(
            'adresse_facturation_commande', 
            'Adresse de facturation', 
            'required',
             array(
                'required' => 'Vous n\'avez pas entré l\' %s',
             )
        );

        if ($this->input->post() && $this->form_validation->run()) {
            // $this->output->enable_profiler(true);
            $tab = $this->input->post();
            $tab["tva"] = self::DEFAULT_TVA;
            $tab["statut_commande"] = self::DEFAULT_STATUT_COMMANDE;
            $tab["date_commande"] = date("Y-m-d H:i:s");  //self::DEFAULT_DATE_COMMANDE;

            $id_client = $this->db->query("SELECT id_client FROM client WHERE mail_client = ?", [$this->auth->get_login()])->row()->id_client;
            $tab["id_client"] = $id_client;

            $this->db->trans_start();
            $this->db->insert("commande", $tab);
            $id_commande = $this->db->insert_id();
            foreach($this->basket->get_basket() as $row){
                $id_produit = $row["element"]["id"];
                $qty = $row["qty"];
                $order_line = $this->make_order_line($id_commande, $id_client, $id_produit, $qty);
                $this->db->insert("ligne_de_commande", $order_line);
            }
            $this->db->trans_complete();

            redirect('site/commandeEnregistree');
            
        } else {
            // $this->output->enable_profiler(true);
            $this->load->view("header", $data);
            $this->load->view("commande");
            $this->load->view("footer");
        }
    }

    // Page informant l'utilisateur de l'enregistrement effectif de sa commande
    public function commandeEnregistree() {
        $data = $this->get_header();

        $this->load->view("header", $data);
        $this->load->view("commandeEnregistree");
        $this->load->view("footer");
    }
        
    public function historiqueCommande() {
        // $this->auth->authorized(['client'], '/');
        $data = $this->get_header();
    
        $liste2 = $this->db->select("commande.date_commande, commande.statut_commande, commande.date_reglement_facture, ligne_de_commande.designation_produit_commande, ligne_de_commande.quantite_produit, ligne_de_commande.prix_unitaire_ht, ligne_de_commande.total_ttc");
                  $this->db->from('ligne_de_commande');
                  $this->db->join('commande','commande.id_commande=ligne_de_commande.id_commande','inner');
                  $this->db->join('client','client.id_client=commande.id_client','inner');
                  $this->db->where('client.mail_client', $this->auth->get_login());

        $query=$this->db->get();
        $liste2=$query->result_array();

        $data["liste2"] = $liste2;          

        $this->load->view("header", $data);    
        $this->load->view("historiqueCommande");
        $this->load->view("footer");

    }

    private function get_header() {
        $data = [];
        $liste1 = $this->db->query("select * from rubrique")->result();

        foreach($liste1 as $rub) {
            $rub->sous_rubriques = $this->db->query("select * from sous_rubrique where id_rubrique=?", $rub->id_rubrique)->result();
        }

        $data["liste1"] = $liste1;
        return $data;
    }

    private function make_order_line($id_commande, $id_client, $id_produit, $qty){
        $produit = $this->db->get_where("produit", ["id_produit" => $id_produit])->row();
        $reduction_client = $this->db->get_where("client", ["id_client" => $id_client])->row()->reduction_client;
        $sous_total = $produit->prix_vente_produit * $qty;
        $total_ttc = $sous_total - ($sous_total * $reduction_client / 100);
        return [
            "ref_produit_commande" => $produit->ref_produit,
            "designation_produit_commande" => $produit->designation_produit,
            "prix_unitaire_ht" => $produit->prix_vente_produit,
            "quantite_produit" => $qty,
            "total_ttc" => $total_ttc,
            "id_produit" => $id_produit, 
            "id_commande" => $id_commande
        ];
    }
}
