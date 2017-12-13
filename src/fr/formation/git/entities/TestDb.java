package fr.formation.git.entities;

import java.sql.* ;
import java.io.* ;

import com.mysql.jdbc.Driver;;

public  class TestDb {

   public  static  void main (String[] args) {
      try {
         // chargement de la classe par son nom
        Class c = Class.forName("com.mysql.jdbc.Driver") ;
        Driver pilote = (Driver)c.newInstance() ;
         // enregistrement du pilote auprès du DriverManager
        DriverManager.registerDriver(pilote);
         // Protocole de connexion
        String protocole =  "jdbc:mysql:" ;
         // Adresse IP de l’hôte de la base et port
        String ip =  "localhost" ;  // dépend du contexte
        String port =  "3306" ;  // port MySQL par défaut
         // Nom de la base ;
        String nomBase =  "test_db" ;  // dépend du contexte
         // Chaîne de connexion
        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
         // Identifiants de connexion et mot de passe
        String nomConnexion =  "user" ;  // dépend du contexte
        String motDePasse =  "passwd" ;  // dépend du contexte
         // Connexion
        Connection con = DriverManager.getConnection(
           conString, nomConnexion, motDePasse) ;

         // Envoi d’un requête générique
        String sql =  "select * from Marins" ;
        Statement smt = con.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;
         while (rs.next()) {
           System.out.println(rs.getString("nom + bnjour lol")) ;
        }
     }  catch (Exception e) {
         // gestion des exceptions
     }
  }
}