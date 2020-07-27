<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">  
  <link rel="stylesheet" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>Village Green</title>
</head>
<body>
  <div class="container">
    <section>
      <a href="index.html"><img src="assets/Charte/HEADER/logo village green.png" alt="logo" class="logo"></a>
      <img src="assets/Charte/HEADER/3 bandes.png" alt="3 bandes" id="stripes">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
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
                  $('.nav-link').popover({content: "Etes-vous déjà client chez nous?<br>nous?<br>nous?<br>nous?<br>", html: true}); 
                });
              </script> 
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"><img src="assets/Charte/HEADER/picto panier.png" alt="picto panier"></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"><img src="assets/Charte/HEADER/picto pays.png" alt="picto pays"></a>
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
            <li class="nav-item">
              <div class="nav-link" 
              href="#" id="nav2link1" 
              data-toggle="popover"
              data-placement="bottom" 
              tabindex="0" 
              data-trigger="focus"  
              data-content="<a href=''>Guitares Electriques</a><br><a href=''>Guitares Classiques</a><br><a href=''>
              Guitare Acoustique & Electro-Acoustiques</a><br><a href=''>Basses Electriques</a><br><a href=''>Basses Acoustiques</a><br>
              <a href=''>Basses Semi-Acoustiques</a><br><a href=''>Ukulélés</a><br><a href=''>Autres instrument à cordes pincées</a><br>">Guit/Bass</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Batteries</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Claviers</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Studio</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Sono</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Eclairage</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">DJ</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Cases</div>
            </li>
            <li class="nav-item">
                <div class="nav-link" 
                href="#" id="nav2link1" 
                data-toggle="popover"
                data-placement="bottom" 
                tabindex="0" 
                data-trigger="focus"
                data-content="<a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br><a href=''>lien1</a><br>">Accessoires</div>
            </li>
          </ul>
        </div>  
      </nav>
      <!-- FIN DE LA NAVBAR -->
    </section>
    <section>
      <div class="ads">
        <a href="#"><img class="adButton" src="assets/Charte/BODY/pub guitare bouton blanc.png" alt="clic pub guitare"></a>
        <img class="guitarAd" src="assets/Charte/BODY/pub guitare.png" alt="pub guitare">
        <img class="priceAd" src="assets/Charte/BODY/banniere droite prix.png" alt="banniere prix">
      </div>
    </section>
    <section>
      <div class="centralBanner">
        <img class="bannerImg" src="assets/Charte/BODY/banniere centre 4 pictos.png" alt="banniere centrale">
      </div>
    </section>
    <section>
      <h3 class="lienCat">Nos catégories</h3>
      <div class="categories">
        <div class="imgContainer1">
          <a href="#"><img class="img1" src="assets/Charte/BODY/CATEGORIES guitare.png" alt="guitare"></a>
          <a href="#"><img class="img2" src="assets/Charte/BODY/CATEGORIES batterie.png" alt="batterie"></a>
          <a href="#"><img class="img3" src="assets/Charte/BODY/CATEGORIES piano.png" alt="piano"></a>
          <a href="#"><img class="img4" src="assets/Charte/BODY/CATEGORIES micro.png" alt="micro"></a>
        </div>
        <div class="imgContainer2">
          <a href="#"><img class="img5" src="assets/Charte/BODY/CATEGORIES sono.png" alt="sono"></a>
          <a href="#"><img class="img6" src="assets/Charte/BODY/CATEGORIES cases.png" alt="cases"></a>
          <a href="#"><img class="img7" src="assets/Charte/BODY/CATEGORIES cable.png" alt="cables"></a>
          <a href="#"><img class="img8" src="assets/Charte/BODY/CATEGORIES saxo.png" alt="saxo"></a>
        </div>
      </div>
    </section>
    <section>
      <div class="sellsAndPartners">
        <div class="row">
          <div class="col-6">
            <h3>Nos meilleures ventes</h3>
            <div class="topContainer1">
              <a href="#"><img class="imgTopVente1" src="assets/Charte/BODY/TOP VENTES guitare.png" alt="Top vente guitare"></a>
              <a href="#"><img class="imgTopVente2" src="assets/Charte/BODY/TOP VENTES saxo.png" alt="Top vente saxo"></a>
              <a href="#"><img class="imgTopVente3" src="assets/Charte/BODY/TOP VENTES piano.png" alt="Top vente piano"></a>
            </div>
          </div>
          <div class="col-6">
            <h3>Nos partenaires</h3>
            <div class="topContainer2">
              <img class="imgParteners" src="assets/Charte/BODY/partenaires 4 logos.png" alt="logos partenaires">
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <footer>
    <img class="imgFooter" src="assets/Charte/FOOTER/footer SIMPLE.png" alt="footer">
  </footer>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="scriptPopover.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
