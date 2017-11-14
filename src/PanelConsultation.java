import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelConsultation extends JPanel implements ActionListener{
	
	private JLabel message, message1;
	
	private JTable tableau;
	private JScrollPane scrollPane;
	private JComboBox combo1;
	private JButton btn1;
	private JTextArea textXml;
	String xml;

	
	public PanelConsultation(String chaine){
		
		switch(chaine){
		
			case "film":
					
				ArrayList<Film> list = Modele.getLesFilms();
				int compteur = list.size();
				
				Object[][] data = new Object[compteur][10];
				String [] title = {"Code Film", "Nom Film", "temps min","Nb places", "genre","prix"};
				
				
				int i = 0;
				for(Film f : list){
					 data[i][0] = f.getIdFilm();
					 data[i][1]= f.getTitreFilm();
					 data[i][2] = f.getDureeFilm();
					 data[i][3] = f.getNbPlaces();
					 data[i][4] = f.getLeGenre().getLibelle();
					 if(f instanceof Film2D){
					 	data[i][5] = Film2D.getPrix2D();

					 }
					 else{
						 data[i][5] = Film3D.getPrix3D();
					 }
					 i += 1;
				}
						
		
				this.tableau = new JTable(data,title);
				this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 64));
				this.scrollPane = new JScrollPane(this.tableau);
				this.add(scrollPane);
				break;
			
			case "acteur":	
				
				ArrayList<String> liste = Modele.getLesActeurs();
				int compteur1 = liste.size();
				Object[][] data2 = new Object[compteur1][10];
				String [] title2 = {"Nom acteur", "Prenom acteur", "Date naissance"};
				
				int j = 0;
				String[] separation;
				String nom, prenom;
				ArrayList<LocalDate> date;
				for (String e : liste){
					separation = e.split(" ");
					nom = separation[0];
					prenom = separation[1];
					date = Modele.getDate(nom, prenom);
					data2[j][0] = nom;
					data2[j][1] = prenom;
					data2[j][2] = date.get(0);
					j++;
				}
				
				combo1 = new JComboBox();
				for(String acteur : liste){
					combo1.addItem(acteur);
				}		
				
				message1 = new JLabel("                        Generateur XML:");
				
				btn1 = new JButton("Valider");
				btn1.addActionListener(this);
				
				xml = "";
				textXml = new JTextArea(xml);
		
				this.tableau = new JTable(data2,title2);
				this.tableau.setPreferredScrollableViewportSize(new Dimension(400, 64));
				this.scrollPane = new JScrollPane(this.tableau);
				this.add(scrollPane);
				this.add(message1);
				this.add(combo1);
				this.add(btn1);
				this.add(textXml);
				break;
				
				
				
			case "genre":
				
				ArrayList<Genre> list1 = Modele.getGenres();
				int compteur11 = list1.size();
				
				Object[][] data1 = new Object[compteur11][10];				
				String [] title1 = {"code","libellé"};
				
				j = 0;
				for (Genre e : list1){
					 data1[j][0] = e.getCodeGenre();
					 data1[j][1] = e.getLibelle();
					 j++;
				}

				System.out.println(data1);
				
				this.tableau = new JTable(data1,title1);
				this.tableau.setPreferredScrollableViewportSize(new Dimension(200, 64));
				this.scrollPane = new JScrollPane(this.tableau);
				this.add(scrollPane);
				break;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1){
			String nom, prenom;
			String[] separation;
			int id;
			String rep = (String) combo1.getSelectedItem();
			separation = rep.split(" ");
			nom = separation[0];
			prenom = separation[1];
			id = Modele.getIdActeur(nom, prenom);
			xml = Modele.getXml(id, nom, prenom);
			textXml.setText(xml);
			
		}
		
	}
}
