import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelAccueil extends JPanel{
	
	private JLabel messageAccueil;
	
	PanelAccueil(){
		
		messageAccueil = new JLabel("Bienvenue au cinémaMania!");	
		messageAccueil.setFont(new Font("Arial", Font.BOLD, 30));
		this.add(messageAccueil);
	}
	

}
