
public class Film2D extends Film{
	static private float prix2D = 5;
	
	public Film2D(){
		super();
	}
	
	public Film2D(int unId, String unTitre, int uneDuree, int unNb, Genre unGenre){
		super(unId, unTitre, uneDuree, unNb, unGenre);
	}

	public static float getPrix2D() {
		return prix2D;
	}

	public void setPrix2D(float prix2d) {
		this.prix2D = prix2d;
	}
	
	
}
