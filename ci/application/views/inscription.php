<link rel="stylesheet" href="<?= base_url("/css/inscription.css") ?>">
<section>
<!-- <form class="form1" action="<?= site_url("site/inscription") ?>" method="POST"> -->
<?= form_open("site/inscription");?>
      <div class="row">
        <div class="col">
          <h2 id="firstId">Créez vos identifiants</h2>
          <!-- DEBUT FORMULAIRE -->
          <?= validation_errors(); ?>
            <div class="form-group row">
              <label for="inputEmail" class="col-sm-2 col-form-label inputEmail">E-mail</label>
              <div class="col-sm-10">
                <input type="email" name="mail_client" value="<?= set_value('mail_client', '') ?>" class="form-control" id="email" required>
                <span id="missEmail"></span>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-6">
            <div class="form-group row">
              <label for="inputPassword" class="col-sm-2 col-form-label inputPassword">Créez votre mot de passe</label>
              <div class="col-sm-10">
                <input type="password" name="mdp_client" value="<?= set_value('mdp_client', '') ?>" class="form-control" id="password" placeholder="8 caractères minimum" required>
                <span id="missPassword"></span>
              </div>
            </div>
          </div>
          <div class="col-6">
            <div class="form-group row">
              <label for="inputPassword" class="col-sm-2 col-form-label inputConfirmPassword">Confirmation mot de passe</label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                <span id="missConfirmPassword"></span>
              </div>
            </div>
          </div>
        </div>
     
        <h2 id="title2">Renseignez vos informations</h2>
        <div class="row">
          <div class="col">
            <!-- <form class="form2"> -->
              <div class="form-group row">
                <label for="prenom" class="col-sm-2 col-form-label" id="labelFirstName">Prenom</label>
                <div class="col-sm-10">
                  <input type="text" name="prenom_client" value="<?= set_value('prenom_client', '') ?>" class="form-control" id="firstName" required>
                  <span id="missFirstName"></span>
                </div>
              </div>
              <div class="form-group row">
                <label for="nom" class="col-sm-2 col-form-label" id="labelName">Nom</label>
                <div class="col-sm-10">
                  <input type="text" name="nom_client" value="<?= set_value('nom_client', '') ?>" class="form-control" id="name" required>
                  <span id="missName"></span>
                </div>
              </div>
              <div class="form-group row">
                <label for="adresse" class="col-sm-2 col-form-label" id="labelAdress">Adresse</label>
                <div class="col-sm-10">
                  <input type="text" name="adresse_client" value="<?= set_value('adresse_client', '') ?>" class="form-control" id="adress" required>
                  <span id="missAdress"></span>
                </div>
              </div>
              <div class="form-group row">
                <label for="compAdresse" class="col-sm-2 col-form-label" id="labelCompAdress">Complément d'adresse</label>
                <div class="col-sm-10">
                  <input type="text" name="comp_adresse_client" value="<?= set_value('comp_adresse_client', '') ?>" class="form-control" id="compAdress">
                </div>
              </div>
              <div class="form-group row">
                <label for="codePostal" class="col-sm-2 col-form-label" id="labelZip">Code postal</label>
                <div class="col-sm-10">
                  <input type="zip" name="code_postal_client" value="<?= set_value('code_postal_client', '') ?>" class="form-control" id="zip" required>
                  <span id="missZip"></span>
                </div>
              </div>
              <div class="form-group row">
                <label for="ville" class="col-sm-2 col-form-label" id="labelCity">Ville</label>
                <div class="col-sm-10">
                  <input type="text" name="ville_client" value="<?= set_value('ville_client', '') ?>" class="form-control" id="city" required>
                  <span id="missCity"></span>
                </div>
              </div>
              <div class="form-group row">
                <label for="pays" class="col-sm-2 col-form-label" id="labelCountry">Pays</label>
                <div class="col-sm-10">
                  <input type="text" name="pays_client" value="<?= set_value('pays_client', '') ?>" class="form-control" id="country" required>
                  <span id="missCountry"></span>
                </div>
              </div>
            </div>
            <div class="col">
              <img class="numberFrame" src="<?= base_url("/assets/Charte/BODY/ESPACE CLIENT/CADRE numero.png") ?>" alt="cadre numéro">
            </div>
        </div>
        <button type="submit" id="button" class="btn btn-success">
        Valider
        </button>
<?= form_close(); ?>      
        </form>
      </section>
      <section class="endPage">
        <img class="pictos" src="<?= base_url("/assets/Charte/BODY/ESPACE CLIENT/bas de page pictos.png") ?>" alt="pictos bas de page">
      </section>
    </div>