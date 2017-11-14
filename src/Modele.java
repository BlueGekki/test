import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;


public class Modele {
	//coucou madame et moi
	private static Connection connexion ;
	private static Statement state;
	private static ResultSet rs, rs2;
	private static PreparedStatement st, st2;
	
	public static boolean connexion() {
		boolean rep = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cine","root","");
			state = connexion.createStatement();
		}
		catch (ClassNotFoundException err){ //si le driver ne charge pas
			System.out.println("Driver non trouvé");
			rep = false;
		}
		catch (SQLException erreur) { //si une erreur sql occurre
			System.out.println("La connexion a échouée");
			rep = false;
		}
		return rep;
	}
	
	/*public static void deconnexion() {
		try{
			rs.close();
		}
		catch (SQLException error) {
			System.out.println("déco raté");
		}
	}*/
	

	
	public static void ajouterUnFilm(String unTitre, int uneDuree, int unNbPlace, String unGenre, String unType) {
		String requete, requete2;
		int unNumGenre;
		
		requete = "SELECT codeGenre FROM genre WHERE nomGenre = ?;";
		try{
			st =(PreparedStatement) connexion.prepareStatement(requete);
			st.setString(1, unGenre);
			rs = st.executeQuery();
			
			if(rs.next()){
				unNumGenre = rs.getInt(1);
				if(unType.equals("2D")){
					requete2 = "INSERT INTO film(nomFilm, tempsFilm, nbPlaces, numGenre, prixFilm, typeFilm) VALUES ('"+unTitre+"', '"+ uneDuree +"', '"+unNbPlace+"', '"+unNumGenre+"',"+Film2D.getPrix2D()+",'2D');";
				}
				else{
					requete2 = "INSERT INTO film(nomFilm, tempsFilm, nbPlaces, numGenre, prixFilm, typeFilm) VALUES('"+unTitre+"', '"+uneDuree+"', '"+unNbPlace+"', '"+unNumGenre+"',"+Film3D.getPrix3D()+", '3D');";
				}
				state.executeUpdate(requete2);
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}
	}	
	
	public static void ajouterUnActeur(String unNom, String unPrenom, Object annee, Object mois, Object jour){
		String requete = "SELECT * FROM acteur WHERE nomActeur = ? and prenomActeur = ?;";
		try{
			st =(PreparedStatement) connexion.prepareStatement(requete);
			st.setString(1, unNom);
			st.setString(2, unPrenom);
			rs = st.executeQuery();
			
			if(!rs.next()){
				String requete2 = "INSERT INTO acteur(nomActeur, prenomActeur, dateNaissActeur) VALUES ('"+unNom+"', '"+ unPrenom +"','"+ annee +"-"+ mois +"-"+ jour +"');";
				state.executeUpdate(requete2);
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}

	}
	
	public static void ajouterUnGenre(String unGenre){
		
		String requete = "INSERT INTO genre(nomGenre) VALUES('"+unGenre+"');";
		System.out.println(requete);
		try {
			st =(PreparedStatement) connexion.prepareStatement("SELECT * FROM genre WHERE nomGenre = ?");
			st.setString(1, unGenre);
			rs = st.executeQuery();
			
			if(!rs.next()){
				state.executeUpdate(requete);
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}
		
	}
	
	public static ArrayList<String> getLesGenres(){
		ArrayList<String> rep = new ArrayList<String>();
		try{
			st =(PreparedStatement) connexion.prepareStatement( "SELECT * FROM genre");
			rs = st.executeQuery();
			
			while(rs.next()){
				rep.add(rs.getString(2));
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}

		return rep;
	}
	
	public static ArrayList<Genre> getGenres(){
		ArrayList<Genre> rep = new ArrayList<Genre>();
		try{
			st =(PreparedStatement) connexion.prepareStatement( "SELECT * FROM genre");
			rs = st.executeQuery();
			
			while(rs.next()){
				rep.add(new Genre(rs.getInt(1), rs.getString(2)));
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}

		return rep;
	}
	
	public static ArrayList<Film> getLesFilms(){
		ArrayList<Film> rep = new ArrayList<Film>();
		Genre unGenre;
		String requete = "SELECT * FROM genre WHERE codeGenre = ?;";
		
		try{
			st =(PreparedStatement) connexion.prepareStatement(requete);
			st2 =(PreparedStatement) connexion.prepareStatement( "SELECT * FROM film");
			rs2 = st2.executeQuery();
			
			while(rs2.next()){
				st.setInt(1, rs2.getInt(5));
				rs = st.executeQuery();
				rs.next();
				
				unGenre = new Genre(rs.getInt(1), rs.getString(2));
				if(rs2.getString(7).equals("2D")){
					rep.add(new Film2D(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), unGenre));
				}
				else{
					rep.add(new Film3D(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), unGenre));
				}
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}

		return rep;
	}
	
	public static ArrayList<String> getLesActeurs(){
		ArrayList<String> rep = new ArrayList<String>();
		try{
			st =(PreparedStatement) connexion.prepareStatement( "SELECT * FROM acteur");
			rs = st.executeQuery();
			
			while(rs.next()){
				rep.add(rs.getString(2) + " " +  rs.getString(3));
			}
		}
		catch (SQLException erreur) {
			System.out.println("Erreur SQL" + erreur);		
		}

		return rep;
	}
	
	public static ArrayList<LocalDate> getDate(String nom, String prenom){
		ArrayList<LocalDate> rep = new ArrayList<LocalDate>();
		try {
			st =(PreparedStatement) connexion.prepareStatement( "SELECT dateNaissActeur FROM acteur WHERE nomActeur = ? AND prenomActeur = ?");
			st.setString(1, nom);
			st.setString(2, prenom);
			rs = st.executeQuery();
			if(rs.next()){
				rep.add(rs.getDate(1).toLocalDate());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rep;
		
	}
	
	public static int getIdActeur(String nom, String prenom){
		int id = 0;
		try {
			st =(PreparedStatement) connexion.prepareStatement( "SELECT codeActeur FROM acteur WHERE nomActeur = ? AND prenomActeur = ?");
			st.setString(1, nom);
			st.setString(2, prenom);
			rs = st.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static String getXml(int id, String nom, String prenom){
		String rep = "";
		rep += "<acteur>";
		rep += "\n\t<codeActeur>" + id + "</codeActeur>";
		rep += "\n\t<nomActeur>" + nom + "</nomActeur>";
		rep += "\n\t<prenomActeur>" + prenom + "</prenomActeur>";
		rep += "\n\t<dateNaissActeur>" + getDate(nom, prenom).get(0) + "</dateNaissActeur>";
		rep += "\n\t<films>";
		rep += "\n\t</films>";
		rep += "\n</acteur>";
		return rep;
	}
}
