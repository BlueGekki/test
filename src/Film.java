import java.util.ArrayList;


public abstract class Film {
	private int idFilm;
	private String titreFilm;
	private int dureeFilm;
	private int nbPlaces;
	private ArrayList<Acteur> lesActeurs;
	private Genre leGenre;
	
	public Film(){
		lesActeurs = new ArrayList<Acteur>();
	}
	
	public Film(int unId, String unTitre, int uneDuree, int unNb, Genre unGenre){
		this.idFilm = unId;
		this.titreFilm = unTitre;
		this.dureeFilm = uneDuree;
		this.nbPlaces = unNb;
		this.leGenre = unGenre;
		lesActeurs = new ArrayList<Acteur>();
	}
	
	public int getIdFilm() {
		return idFilm;
	}
	
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	
	public String getTitreFilm() {
		return titreFilm;
	}
	
	public void setTitreFilm(String titreFilm) {
		this.titreFilm = titreFilm;
	}
	
	public float getDureeFilm() {
		return dureeFilm;
	}
	
	public void setDureeFilm(int dureeFilm) {
		this.dureeFilm = dureeFilm;
	}
	
	public int getNbPlaces() {
		return nbPlaces;
	}
	
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	public Genre getLeGenre() {
		return leGenre;
	}
	
	public void setLeGenre(Genre leGenre) {
		this.leGenre = leGenre;
	}
	
	
}

