<link rel="stylesheet" href="<?= base_url("/css/connexion.css") ?>">
<h2>Connectez-vous</h2>
<!-- <form action="<?= site_url("site/connexion") ?>" method="POST" class="form-group"> -->
<?= form_open("site/connexion"); ?>
  <div>
    <label for="email" id="emailLabel">Email</label>
    <input type="email" name="mail_client"  class="form-control" id="email" placeholder="Entrez votre email" required>
    <span id="missEmail"></span>
  </div>
  <div class=row>
  <div class="col-6">
  <div class="form-group">
    <label for="password" id="passwordLabel">Mot de passe</label>
    <input type="password" name="mdp_client"  class="form-control" id="password" placeholder="Entrez votre mot de passe" required>
    <span id="missPassword"></span>
  </div>
  </div>
  <div class="col-6">
  <div class="form-group">
    <label for="passwordConfirm" id="passwordConfirmLabel">Confirmation du mot de passe</label>
    <input type="password" name="confirmPassword"  class="form-control" id="confirmPassword" placeholder="Confirmez votre mot de passe" required>
    <span id="missConfirmPassword"></span>
  </div>
  </div>
  </div>
  <button type="submit" id="button" class="btn btn-success">
        Valider
        </button>
<?= form_close(); ?>
<!-- </form>     -->
<section class="endPage">
    <img class="pictos" src="<?= base_url("/assets/Charte/BODY/ESPACE CLIENT/bas de page pictos.png") ?>" alt="pictos bas de page">
</section>
