import java.util.ArrayList;
import java.time.LocalDate;


public class Acteur {
	private int idActeur;
	private String nomActeur;
	private String prenomActeur;
	private LocalDate dateNaiss;
	private ArrayList<Film> lesFilms;
	
	public Acteur(){
		lesFilms = new ArrayList<Film>();
	}
	
	public Acteur(int unId, String unNom, String unPrenom, LocalDate uneDate){
		this.idActeur = unId;
		this.nomActeur = unNom;
		this.prenomActeur = unPrenom;
		this.dateNaiss = uneDate;
		lesFilms = new ArrayList<Film>();
	}

	public int getIdActeur() {
		return idActeur;
	}

	public void setIdActeur(int idActeur) {
		this.idActeur = idActeur;
	}

	public String getNomActeur() {
		return nomActeur;
	}

	public void setNomActeur(String nomActeur) {
		this.nomActeur = nomActeur;
	}

	public String getPrenomActeur() {
		return prenomActeur;
	}

	public void setPrenomActeur(String prenomActeur) {
		this.prenomActeur = prenomActeur;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	
	public ArrayList<Film> getLesFilms(){
		return this.lesFilms;
	}
	
	public void ajouterFilm(Film unFilm){
		this.lesFilms.add(unFilm);
	}
	
	public void supprimerFilm(Film unFilm){
		this.lesFilms.remove(unFilm);
	}
	
	public String afficherFilm(){
		String chaine = "";
		for(Film e : this.lesFilms){
			chaine += e.getTitreFilm();
		}
		return chaine;
	}
	
	public String toString(){
		String chaine = "";
		

		if(this.nomActeur == null){
			chaine += "Nom: pas d'information";
		}
		else{
			chaine +="\tNom: " + this.nomActeur;
		}
		
		if(this.prenomActeur == null){
			chaine += "\tPrenom: pas d'information";
		}
		else{
			chaine += "\tPrenom: " + this.prenomActeur;
		}
		
		if(this.dateNaiss == null){
			chaine += "\tDate naissance: pas d'information";
		}
		else{
			chaine += "\tDate naissance: " + this.dateNaiss;
		}
		
		chaine += this.afficherFilm();
		
		return chaine;
	}
	
}
