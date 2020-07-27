<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="<?= base_url("/css/header.css")?>">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>Village Green</title>
</head>
<body>
  <div class="container">
    <section>
     <a href="<?php echo site_url('site/index'); ?>"><img src="<?= base_url("/assets/Charte/HEADER/logo village green.png") ?>" alt="logo" class="logo"></a>
      <img src="<?= base_url("/assets/Charte/HEADER/3 bandes.png") ?>" alt="3 bandes" id="stripes">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
          <?php
          if ($this->auth->is_logged()) {
            ?>
            <li class="nav-item">
              <a class="nav-link" href="<?= site_url("site/logout/")?>" id="firstNavLink">Deconnexion</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<?= site_url("site/historiqueCommande/")?>" id="firstNavLink">Vos commandes</a>
            </li>
            <?php
          }
          ?>
            <li class="nav-item">
              <a class="nav-link" href="#" id="firstNavLink">Infos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link"
              href="#"
              data-toggle="popover"
              data-placement="bottom"
              tabindex="0"
              data-trigger="focus">Espace client</a>
              <script>
                $(document).ready(function(){
                  $('.nav-link').popover({content: "Vous êtes déjà client chez nous?<br><a href='<?php echo site_url('site/connexion'); ?>'>Connectez-vous</a><br>Nouveau client?<br><a href='<?php echo site_url('site/inscription'); ?>'>Inscrivez-vous</a><br>", html: true});
                });
              </script>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="basketContent" href='<?php echo site_url('site/panier/')?>'><img src="<?= base_url("/assets/Charte/HEADER/picto panier.png") ?>" alt="picto panier"><?= $this->basket->get_quantity_sum() ?></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"><img src="<?= base_url("/assets/Charte/HEADER/picto pays.png") ?>" alt="picto pays"></a>
            </li>
          </ul>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav2">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#" id="nav2link1">Produits</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" id="nav2link2">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" id="nav2link3">Aide</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" id="nav2link4">A propos</a>
            </li>
          </ul>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav3">
          <ul class="navbar-nav">
            <?php foreach($liste1 as $rub): ?>
            <li class="nav-item">
              <div class="nav-link"
                href="#" id="nav2link1"
                data-toggle="popover"
                data-placement="bottom"
                tabindex="0"
                data-trigger="focus"
                data-content="
                  <?php foreach($rub->sous_rubriques as $sous_rub): ?>
                    <a href='<?php echo site_url('site/sousRubrique/') . $sous_rub->id_sous_rubrique ?>'><?= $sous_rub->nom_sous_rubrique ?></a><br>
                  <?php endforeach; ?>
                  ">
                <?= $rub->nom_rubrique ?>
              </div>
            </li>
            <?php endforeach; ?>
          </ul>
        </div>
      </nav>
      <!-- FIN DE LA NAVBAR -->
    </section>
