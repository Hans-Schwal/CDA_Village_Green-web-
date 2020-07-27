<link rel="stylesheet" href="<?= base_url("/css/ficheProduit.css") ?>">
<h2><?= $prod->designation_produit; ?></h2>
<div class="row">
  <div class="col-4">
    <img id="instruPic" src="<?= base_url("./img/") . $prod->lien_photo_produit; ?>" alt="photo instrument">
  </div>
</div>
<div class="row">
    <div class="col-8">
        <div class="designation"><?= $prod->designation_produit; ?></div>
        <div class="description"><?= $prod->description_produit; ?></div>
        <div class="price"><?= $prod->prix_vente_produit . " " . "€"; ?></div>
        <div class="quantity">Quantité: 
        <form action="<?= site_url("site/add/") . $prod->id_produit ?>" method="post">
        <select class="select" name="quantite_produit" >
          <?php
					for ($q=1; $q <= 100; $q++) { 
							echo'<option value="'.$q.'" >'.$q.'</option>';
						}
          ?> 
        </select>
        </div>
        <button type="submit" class="btn btn-success">Ajouter au panier</button>
        </form>
    </div>
</div>