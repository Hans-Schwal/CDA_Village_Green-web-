var regexForFirstName = /^[A-Za-zéèîïÉÈÏÎ][a-zéèêàçîï]+([-'\s][a-zA-ZéèîïÉÈÏÎ][a-zéèêàçîï]+)?$/;
//var regexForName = /^[A-ZéèîïÉÈÏÎ]+([-'\s][A-ZéèîïÉÈÏÎ]+)?$/;
var regexForMail = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
var regexForAdress= /^\d+\s[A-z]+\s[A-z]+/;
var regexForZip = /^\d{5}$/;

var formValidation = document.getElementById('button');

formValidation.addEventListener('click', validation);

function validation(event){
  // Vérification du champ "E-mail"
  // Déclarations de variables
  var email = document.getElementById('email');
  var missEmail = document.getElementById('missEmail');
  // Si le champ est vide
  if (email.validity.valueMissing){
    //event.preventDefault();
    missEmail.textContent = 'E-mail manquant';
    missEmail.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForMail.test(email.value) == false){
    //event.preventDefault();
    missEmail.textContent = 'Format incorrect';
    missEmail.style.color = 'orange';
  }else{
    missEmail.textContent = '';
  }
  // Vérification du champ "Mot de passe"
  // Déclarations de variables
  var password = document.getElementById('password');
  var missPassword = document.getElementById('missPassword');
  // Si le champ est vide
  if (password.validity.valueMissing){
    //event.preventDefault();
    missPassword.textContent = 'Mot de passe manquant';
    missPassword.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else{
    missPassword.textContent = '';
  }
  // Vérification du champ "Confirmation mot de passe"
  // Déclarations de variables
  var confirmPassword = document.getElementById('confirmPassword');
  var missConfirmPassword = document.getElementById('missConfirmPassword');
  // Si le champ est vide
  if (confirmPassword.validity.valueMissing){
    //event.preventDefault();
    missConfirmPassword.textContent = 'Confirmation du mot de passe manquante';
    missConfirmPassword.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else{
  }
  // Vérification du champ "Prenom"
  // Déclarations de variables
  var firstName = document.getElementById('firstName');
  var missFirstName = document.getElementById('missFirstName');
  // Si le champ est vide
  if (firstName.validity.valueMissing){
    // event.preventDefault();
    missFirstName.textContent = 'Prénom manquant';
    missFirstName.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForFirstName.test(firstName.value) == false){
    // event.preventDefault();
    missFirstName.textContent = 'Format incorrect';
    missFirstName.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Nom"
  // Déclarations de variables
  var name = document.getElementById('name');
  var missName = document.getElementById('missName');
  // Si le champ est vide
  if (name.validity.valueMissing){
    // event.preventDefault();
    missName.textContent = 'Nom manquant';
    missName.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForFirstname.test(name.value) == false){
    // event.preventDefault();
    missName.textContent = 'Format incorrect';
    missName.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Adresse"
  // Déclarations de variables
  var adress = document.getElementById('adress');
  var missAdress = document.getElementById('missAdress');
  // Si le champ est vide
  if (adress.validity.valueMissing){
    // event.preventDefault();
    missAdress.textContent = 'Adresse manquante';
    missAdress.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForAdress.test(adress.value) == false){
    // event.preventDefault();
    missAdress.textContent = 'Format incorrect';
    missAdress.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Code postal"
  // Déclarations de variables
  var zip = document.getElementById('zip');
  var missZip = document.getElementById('missZip');
  // Si le champ est vide
  if (zip.validity.valueMissing){
    // event.preventDefault();
    missZip.textContent = 'Code postal manquant';
    missZip.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForZip.test(zip.value) == false){
    // event.preventDefault();
    missZip.textContent = 'Format incorrect';
    missZip.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Ville"
  // Déclarations de variables
  var city = document.getElementById('city');
  var missCity = document.getElementById('missCity');
  // Si le champ est vide
  if (city.validity.valueMissing){
    // event.preventDefault();
    missCity.textContent = 'Ville manquante';
    missCity.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
    // Utilisation de la même regex que pour le prénom
  }else if (regexForFirstName.test(city.value) == false){
    // event.preventDefault();
    missCity.textContent = 'Format incorrect';
    missCity.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Pays"
  // Déclarations de variables
  var country = document.getElementById('country');
  var missCountry = document.getElementById('missCountry');
  // Si le champ est vide
  if (country.validity.valueMissing){
    // event.preventDefault();
    missCountry.textContent = 'Pays manquant';
    missCountry.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
    // Utilisation de la même regex que pour le prénom
  }else if (regexForFirstName.test(city.value) == false){
    // event.preventDefault();
    missCountry.textContent = 'Format incorrect';
    missCountry.style.color = 'orange';
  }else{
  }
  // --------------------- view Commande ---------------------------
  // Vérification du champ "Adresse complète de livraison"
  // Déclarations de variables
  var shippingAdress = document.getElementById('shippingAdress');
  var missShippingAdress = document.getElementById('missShippingAdress');
  // Si le champ est vide
  if (shippingAdress.validity.valueMissing){
    // event.preventDefault();
    missShippingAdress.textContent = 'Adresse complète de livraison manquante';
    missShippingAdress.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForAdress.test(city.value) == false){
    // event.preventDefault();
    missShippingAdress.textContent = 'Format incorrect';
    missShippingAdress.style.color = 'orange';
  }else{
  }
  // Vérification du champ "Adresse complète de facturation"
  // Déclarations de variables
  var facturationAdress = document.getElementById('facturationAdress');
  var missFacturationAdress = document.getElementById('missFacturationAdress');
  // Si le champ est vide
  if (facturationAdress.validity.valueMissing){
    // event.preventDefault();
    missFacturationAdress.textContent = 'Adresse complète de facturation manquante';
    missFacturationAdress.style.color = 'red';
    // Si le format de données saisies par l'utilisateur ne correspond pas à la regex
  }else if (regexForAdress.test(city.value) == false){
    // event.preventDefault();
    missFacturationAdress.textContent = 'Format incorrect';
    missFacturationAdress.style.color = 'orange';
  }else{
  }


  if(missEmail.textContent == '' && missPassword.textContent == '' && missConfirmPassword.textContent == '' && missFirstname.textContent == '' 
     && missName.textContent == '' && missAdress.textContent == '' && missZip.textContent == '' && missCity.textContent == '' && missCountry.textContent == ''
     && missShippingAdress.textContent == '' && missFacturationAdress.textContent == '') {

  }
  else {
    event.preventDefault();
  }
}
// Déclaration de variable
var submit = document.getElementById("confirmPassword");
// vérification de la correspondance entre le mot de passe et la confirmation du mot de passe grâce à un eventListener.
submit.addEventListener("input", function() {
  var password = document.getElementById("password").value;
  var confirmPassword = document.getElementById("confirmPassword").value;
  if (password === confirmPassword) {
    document.getElementById("password").style.border="2px solid green";
    document.getElementById("confirmPassword").style.border="2px solid green";
  }else{
    document.getElementById("password").style.border="2px solid red";
    document.getElementById("confirmPassword").style.border="2px solid red";
  }
});
