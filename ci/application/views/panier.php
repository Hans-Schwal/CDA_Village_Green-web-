<link rel="stylesheet" href="<?= base_url("/css/panier.css") ?>">
<h2>Votre Panier</h2>
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
    <a href="<?= site_url("site/remove/") . $produit["element"]["id"] ?>"><button type="submit" class="btn btn-warning" id="extract">Extraire</button></a>  
  </div> 
</div>
<hr>
<?php endforeach; ?>
<div class="totalPrice">TOTAL: <?= $this->basket->get_price_sum("prix_vente_produit") . '' . '€'; ?></div>
<a href="<?= site_url("site/commande/") ?>"><button id="validation" type="submit" class="btn btn-success">Commander</button></a>
<a href="<?= site_url("site/clean/") ?>"><button id="clear" type="submit" class="btn btn-warning">Vider mon panier</button></a>
<a href="<?= site_url("site/index/") ?>"><button id="back" type="submit" class="btn btn-danger">Poursuivre mes achats</button></a>
</div>
</div>