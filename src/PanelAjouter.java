import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PanelAjouter extends JPanel implements ActionListener{
	
	private JLabel message;
	
	private JPanel monPanelHaut;
	private JPanel monPanelBas;
	
	private JLabel messageFilm;
	private JLabel messageActeur;
	private JLabel messageGenre;
	
	private JLabel message1;
	private JLabel message2;
	private JLabel message3;
	private JLabel message4;
	private JLabel message5;
	
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	
	private JLabel messagea;
	private JLabel messageb;
	private JLabel messagec;
	private JLabel messageg;
	private JLabel messager;
	
	private JFormattedTextField jtfa;
	private JFormattedTextField jtfb;
	private JFormattedTextField jtfc;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private JComboBox combo1;
	private JComboBox combo2;
	private JComboBox combo3;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private ButtonGroup bg;
	
	public PanelAjouter(String chaine){
		
		message = new JLabel();
		
		monPanelHaut = new JPanel();
		monPanelBas = new JPanel();
		
		this.setLayout(new BorderLayout());
		monPanelHaut.setLayout(new FlowLayout());
		monPanelBas.setLayout(new FlowLayout());

		switch(chaine){
		
			case "film":
				messageFilm = new JLabel("Ajout d'un film");
				
				message1 = new JLabel("           Titre: ");
				jtf1 = new JTextField();
				
				messagea = new JLabel("       Durée: ");
				jtfa = new JFormattedTextField(NumberFormat.getIntegerInstance());		
				
				messageb = new JLabel("     Nombre de places: ");
				jtfb = new JFormattedTextField(NumberFormat.getIntegerInstance());
				
				messageg = new JLabel("            Genre: ");
				combo1 = new JComboBox();
				
				ArrayList<String> lesGenres = Modele.getLesGenres();
				for(String leGenre : lesGenres){
					combo1.addItem(leGenre);
				}
				
				messager =  new JLabel("              Type: ");
				rb1 = new JRadioButton("2D");
				rb2 = new JRadioButton("3D");
				bg = new ButtonGroup();
				bg.add(rb1);
				bg.add(rb2);		
				
				
				messageFilm.setFont(new Font("Arial", Font.BOLD, 25));
				jtf1.setPreferredSize(new Dimension(175,30));
				jtfa.setPreferredSize(new Dimension(150,30));
				jtfb.setPreferredSize(new Dimension(150,30));
				combo1.setPreferredSize(new Dimension(150,30));
				
				btn1 = new JButton("Valider");
				btn1.addActionListener(this);
				
				monPanelHaut.add(messageFilm);
				monPanelBas.add(message1);
				monPanelBas.add(jtf1);
				monPanelBas.add(messagea);
				monPanelBas.add(jtfa);
				monPanelBas.add(messageb);
				monPanelBas.add(jtfb);
				monPanelBas.add(messageg);
				monPanelBas.add(combo1);
				monPanelBas.add(messager);
				monPanelBas.add(rb1);
				monPanelBas.add(rb2);
				monPanelBas.add(btn1);
				monPanelBas.add(message);
				
				monPanelBas.add(message);
				this.add(monPanelHaut, BorderLayout.NORTH);
				this.add(monPanelBas);
				
				break;
			
			case "acteur":
				messageActeur = new JLabel("Ajout d'un acteur");
				
				message1 = new JLabel("Nom: ");
				jtf1 = new JTextField();
				
				message2 = new JLabel("Prénom: ");
				jtf2 = new JTextField();	
				
				messagea = new JLabel("                          Date de naissance: ");
				
				combo1 = new JComboBox();
				combo2 = new JComboBox();
				combo3 = new JComboBox();
				
				int i;
				combo1.addItem("jour");
				for(i = 1; i <= 31; i++){
					combo1.addItem(new Integer(i));
				}
				combo2.addItem("mois");
				for(i = 1; i <= 12; i++){
					combo2.addItem(new Integer(i));
				}
				combo3.addItem("année");
				for(i = 1940; i <= 2010; i++){
					combo3.addItem(new Integer(i));
				}
				
				messageActeur.setFont(new Font("Arial", Font.BOLD, 25));
				jtf1.setPreferredSize(new Dimension(150,30));
				jtf2.setPreferredSize(new Dimension(150,30));
				combo1.setPreferredSize(new Dimension(90,30));
				combo2.setPreferredSize(new Dimension(90,30));
				combo3.setPreferredSize(new Dimension(130,30));
				btn2= new JButton("Valider");
				btn2.addActionListener(this);
				
				monPanelHaut.add(messageActeur);
				monPanelBas.add(message1);
				monPanelBas.add(jtf1);
				monPanelBas.add(message2);
				monPanelBas.add(jtf2);
				monPanelBas.add(messagea);
				monPanelBas.add(combo1);
				monPanelBas.add(combo2);
				monPanelBas.add(combo3);
				monPanelBas.add(btn2);
				
				monPanelBas.add(message);
				this.add(monPanelHaut, BorderLayout.NORTH);
				this.add(monPanelBas);
				
				break;
				
			case "genre":
				messageGenre = new JLabel("Ajout d'un genre");
				message1 = new JLabel("saisir le genre: ");
				jtf1 = new JTextField();
				
				messageGenre.setFont(new Font("Arial", Font.BOLD, 25));
				jtf1.setPreferredSize(new Dimension(150,30));
				
				btn3 = new JButton("Valider");
				btn3.addActionListener(this);
				
				monPanelHaut.add(messageGenre);
				monPanelBas.add(message1);
				monPanelBas.add(jtf1);
				monPanelBas.add(btn3);
				
				monPanelBas.add(message);
				this.add(monPanelHaut, BorderLayout.NORTH);
				this.add(monPanelBas);				
				break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1){
			boolean etatBouton;
			String rep;
			if(rb1.isSelected() || rb2.isSelected()){
				etatBouton = false;
			}
			else{
				etatBouton = true;
			}
			if(jtf1.getText().equals("") || jtfa.getText().equals("") || jtfb.getText().equals("") || etatBouton){
				message.setText("veuillez saisir tous les champs");
			}
			else{
				message.setText("saisie du film fait!");
				rep = (String) combo1.getSelectedItem();
				if(rb1.isSelected()){
					Modele.ajouterUnFilm(jtf1.getText(), Integer.parseInt(jtfa.getText()), Integer.parseInt(jtfb.getText()), rep, "2D");
				}
				else{
					Modele.ajouterUnFilm(jtf1.getText(), Integer.parseInt(jtfa.getText()), Integer.parseInt(jtfb.getText()), rep, "3D");
				}
			}
		}
		else{
			
			if(e.getSource() == btn2){
				if(jtf1.getText().equals("") || jtf2.getText().equals("")){
					message.setText("Veuillez saisir tous les champs");
				}
				else{
					if (combo1.getSelectedItem().equals("jour") || combo2.getSelectedItem().equals("mois") || combo3.getSelectedItem().equals("année")){
						message.setText("Veillez sélectionner des chiffres pour la date de naissance");
					}
					else{
						message.setText("saisie de l'acteur faite!");
						Modele.ajouterUnActeur(jtf1.getText(), jtf2.getText(), combo3.getSelectedItem(), combo2.getSelectedItem(), combo1.getSelectedItem());
					}
				}
			}
			else{
				if(jtf1.getText().equals("")){
					message.setText("Veuillez saisir tous les champs");
				}
				else{
					Modele.ajouterUnGenre(jtf1.getText());
					message.setText("saisie du genre fait!");
				}
			}
		}
	}
}
