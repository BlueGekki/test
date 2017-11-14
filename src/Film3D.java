
public class Film3D extends Film {
	private static float prix3D = 10;
	
	public Film3D(){
		super();
	}
	
	public Film3D(int unId, String unTitre, int uneDuree, int unNb, Genre unGenre){
		super(unId, unTitre, uneDuree, unNb, unGenre);
	}

	public static float getPrix3D() {
		return prix3D;
	}

	public void setPrix3D(float prix3d) {
		this.prix3D = prix3d;
	}
	
	
}
