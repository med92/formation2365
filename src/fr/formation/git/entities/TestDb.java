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
         // enregistrement du pilote aupr�s du DriverManager
        DriverManager.registerDriver(pilote);
         // Protocole de connexion
        String protocole =  "jdbc:mysql:" ;
         // Adresse IP de l�h�te de la base et port
        String ip =  "localhost" ;  // d�pend du contexte
        String port =  "3306" ;  // port MySQL par d�faut
         // Nom de la base ;
        String nomBase =  "test_db" ;  // d�pend du contexte
         // Cha�ne de connexion
        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
         // Identifiants de connexion et mot de passe
        String nomConnexion =  "user" ;  // d�pend du contexte
        String motDePasse =  "passwd" ;  // d�pend du contexte
         // Connexion
        Connection con = DriverManager.getConnection(
           conString, nomConnexion, motDePasse) ;

         // Envoi d�un requ�te g�n�rique
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