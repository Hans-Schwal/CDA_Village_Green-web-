<link rel="stylesheet" href="<?= base_url("/css/historiqueCommande.css") ?>">
<h2>Votre historique de commande</h2>
<table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Date commande</th>
            <th>Article commandé</th>
            <th>Qté</th>
            <th>Total TTC</th>
            <th>Statut commande</th>
            <th>Date réglement</th>
          </tr>
        </thead>
        <tbody>
        <?php foreach ($liste2 as $commandes) { ?>
          <tr>
            <td><?= $commandes["date_commande"] ?></td>
            <td><?= $commandes["designation_produit_commande"] ?></td>
            <td><?= $commandes["quantite_produit"] ?></td>
            <td><?= $commandes["total_ttc"] ?></td>
            <td><?= $commandes["statut_commande"] ?></td>
            <td><?= $commandes["date_reglement_facture"] ?></td>
          </tr>
        <?php } ?>
        </tbody>
      </table>
      