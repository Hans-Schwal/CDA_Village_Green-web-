<link rel="stylesheet" href="<?= base_url("/css/sousRubrique.css") ?>">
<?php foreach($liste2 as $sous_rub): ?>
<h2><?= $sous_rub->nom_sous_rubrique; ?></h2>
<div class="row">

<?php foreach($sous_rub->produits as $prod): ?>
    <div class="col-4">
<a href='<?php echo site_url('site/ficheProduit/') . $prod->id_produit; ?>'><img id="instrument" src="<?= base_url("./img/") . $prod->lien_photo_produit; ?>" alt="photo instrument"></a>
<a href='<?php echo site_url('site/ficheProduit/') . $prod->id_produit; ?>'><div class="designation"><?= $prod->designation_produit; ?></div></a>
<div class="price"><?= $prod->prix_vente_produit . " " . "€"; ?></div>
</div>
<?php endforeach; ?>

</div>
<?php endforeach; ?>



         