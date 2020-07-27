/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DAL.Client;
import DAL.Produit;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 80010-04-09
 */
public class Api {

    public static List<Client> List() {
        ArrayList<Client> resultat = new ArrayList<Client>();

        try {
            String sURL = "http://127.0.0.1:8080/index.php/api/liste";

            URL api = new URL(sURL);
            URLConnection request = api.openConnection();
            request.connect();

            Gson gg = new Gson();
            JsonParser jp = new JsonParser();
            com.google.gson.JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            Client[] liste = gg.fromJson(root, Client[].class);

            resultat.addAll(Arrays.asList(liste));

        } catch (Exception er) {
            System.out.println("Un problème est survenu");
            System.out.println(er.getMessage());
        }

        return resultat;
    }

    public static void Insert(Client cli) {
        try {

            // Configuration du service web
            String sURL = "http://127.0.0.1:8080/index.php/api/insert";
            URL api = new URL(sURL);
            HttpURLConnection request = (HttpURLConnection) api.openConnection();
            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/json; utf-8");
            request.setRequestProperty("Accept", "application/json");
            request.setDoOutput(true);

            Gson gg = new Gson();
            JsonParser jp = new JsonParser();

            //Emission des données
            String s = gg.toJson(cli);
            System.out.println(s);
            try (OutputStream os = request.getOutputStream()) {
                byte[] input = s.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Reception des données
            String response = "";

            try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response += responseLine.trim();
                }
            }

            System.out.println(response);
            //JsonObject reponse = jp.parse(response).getAsJsonObject();
            //System.out.println(reponse.get("message").getAsString());

        } catch (Exception er) {
            System.out.println("Un problème est survenue");
            System.out.println(er.getMessage());
        }
    }
    
    public static List<Produit> ListeProduit() {
        ArrayList<Produit> resultat = new ArrayList<Produit>();

        try {
            String sURL = "http://127.0.0.1:8080/index.php/api/listeProduit";

            URL api = new URL(sURL);
            URLConnection request = api.openConnection();
            request.connect();

            Gson gg = new Gson();
            JsonParser jp = new JsonParser();
            com.google.gson.JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            Produit[] liste = gg.fromJson(root, Produit[].class);

            resultat.addAll(Arrays.asList(liste));

        } catch (Exception er) {
            System.out.println("Un problème est survenu");
            System.out.println(er.getMessage());
        }

        return resultat;
    }
    
    public static void DetailProduit(Produit Pro) {
        try {
            String sURL = "http://127.0.0.1:8080/index.php/api/detailProduit";

            URL api = new URL(sURL);
            URLConnection request = api.openConnection();
            request.connect();

            Gson gg = new Gson();
            JsonParser jp = new JsonParser();
            com.google.gson.JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            Produit[] detail = gg.fromJson(root, Produit[].class);

            

        } catch (Exception er) {
            System.out.println("Un problème est survenu");
            System.out.println(er.getMessage());
        }
        
    }
}
