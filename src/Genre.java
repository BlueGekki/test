//ceci est un genre
public class Genre {
	private int codeGenre;
	private String libelle;
	
	public Genre(){
		
	}
	
	public Genre(int unCode, String lib){
		this.codeGenre = unCode;
		this.libelle = lib;
	}
	
	public int getCodeGenre(){
		return codeGenre;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	public String toString() {
		return "libelle= " + libelle;
	}
	
	
	
}
