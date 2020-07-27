<link rel="stylesheet" href="<?= base_url("/css/commande.css") ?>">
<h2>Votre commande</h2>
<?php foreach($panier as $produit): ?>
<div class="row">
  <div class="col-4">
      <img src="<?= base_url("img/") . $produit["element"]["lien_photo_produit"] ?>" alt="instrument" id="instrument">
  </div>
</div>
<div class="row">
  <div class="col-8">
    <div class="designation"><?= $produit["element"]["designation_produit"] ?></div>
    <div class="price"><?= $produit["element"]["prix_vente_produit"] . " " . "€"?></div>
    <div class="quantity">Quantité: <?= $produit["qty"] ?></div>
  </div>
</div>
<?php endforeach; ?>
<hr>
<div class="totalPrice">TOTAL: <?= $this->basket->get_price_sum("prix_vente_produit") . '' . '€'; ?></div>
<!-- <form action="<?= site_url("site/commande/") ?>" method="post"> -->
<?= form_open("site/commande/"); ?>
<?= validation_errors(); ?>
    <label for="shippingAdress" class="col-form-label">Adresse complète de livraison: </label><br>
    <input type="text" name="adresse_livraison_commande" value="<?= set_value('adresse_livraison_commande', '') ?>" class="form-control" id="shippingAdress" placeholder="ex: 1 rue du Bonheur 80000 Village Green" required><br>
    <span id="missShippingAdress"></span>
    <label for="facturationAdress" class="col-form-label">Adresse complète de facturation: </label><br>
    <input type="text" name="adresse_facturation_commande" value="<?= set_value('adresse_facturation_commande', '') ?>" class="form-control" id="facturationAdress" placeholder="ex: 1 rue du Bonheur 80000 Village Green" required><br>
    <span id="missFacturationAdress"></span>
    <label for="facturationAdress" class="col-form-label">Type de réglement: </label><br>
    <select name="type_reglement" id="pay">
    <!-- <option>--Choisir une option--</option> -->
    <option value="<?= set_value('type_reglement', 'carte bancaire') ?>" selected>Carte bancaire</option>
    <option value="<?= set_value('type_reglement','virement bancaire') ?>">Virement bancaire</option>
    </select>
    <br>
    <a href="<?= site_url("site/commandeEnregistree/") ?>">
    <button type="submit" id="button" class="btn btn-success">
    Valider ma commande
    </button>
    </a>
<!-- </form> -->
<?= form_close(); ?>
<hr>
<a href="<?= site_url("site/panier/") ?>"><button type="submit" class="btn btn-warning" id="back">Retour panier</button></a>
<a href="<?= site_url("site/index/") ?>"><button type="submit" class="btn btn-danger" id="abort">Annuler</button></a>
