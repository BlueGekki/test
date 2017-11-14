import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{
	
	private JPanel monPanel;
	private PanelAccueil panelAccueil;

	
	private JMenuBar menuBar;
	
	private JMenu menuConsultation;
	//
	private JMenu menuAjouter;
	//
	private JMenu menuSupprimer;
	
	private JMenuItem itemFilm;
	private JMenuItem itemActeur; 
	private JMenuItem itemGenre;
	//
	private JMenuItem itemAFilm;
	private JMenuItem itemAActeur; 
	private JMenuItem itemAGenre;
	private JMenuItem itemALien;
	//
	private JMenuItem itemSFilm;
	private JMenuItem itemSActeur; 
	private JMenuItem itemSGenre;
	//
	private JMenuItem itemQuitter;
	
	private JLabel lblMessage;

	String lePanel;	
	
	public Fenetre(){
		//configuration
		this.setTitle("Cinema");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//principal
		monPanel = new JPanel();
		
		//menu
		menuBar = new JMenuBar();
		menuConsultation = new JMenu("consultation");
		menuAjouter = new JMenu("ajouter");
		menuSupprimer = new JMenu("supprimer");
		
		itemFilm =  new JMenuItem("Films");
		itemActeur = new JMenuItem("Acteur");
		itemGenre = new JMenuItem("Genre");
		
		itemAFilm =  new JMenuItem("Films");
		itemAActeur = new JMenuItem("Acteur");
		itemAGenre = new JMenuItem("Genre");
		itemALien = new JMenuItem("Lien");
		
		itemSFilm =  new JMenuItem("Films");
		itemSActeur = new JMenuItem("Acteur");
		itemSGenre = new JMenuItem("Genre");
		
		
		itemQuitter = new JMenuItem("Quitter");
		
		//accueil
		panelAccueil = new PanelAccueil();

		monPanel.setLayout(new FlowLayout());
		
		itemFilm.addActionListener(this);
		itemActeur.addActionListener(this);
		itemGenre.addActionListener(this);
		
		itemAFilm.addActionListener(this);
		itemAActeur.addActionListener(this);
		itemAGenre.addActionListener(this);
		itemALien.addActionListener(this);
		
		itemSFilm.addActionListener(this);
		itemSActeur.addActionListener(this);
		itemSGenre.addActionListener(this);
		
		itemQuitter.addActionListener(this);
		
		menuConsultation.add(itemFilm);
		menuConsultation.add(itemActeur);
		menuConsultation.add(itemGenre);
		
		menuAjouter.add(itemAFilm);
		menuAjouter.add(itemAActeur);
		menuAjouter.add(itemAGenre);
		menuAjouter.add(itemALien);
		
		menuSupprimer.add(itemSFilm);
		menuSupprimer.add(itemSActeur);
		menuSupprimer.add(itemSGenre);

		menuBar.add(menuConsultation);
		menuBar.add(menuAjouter);
		menuBar.add(menuSupprimer);
		menuBar.add(itemQuitter);
		setJMenuBar(menuBar);
		
		monPanel.add(panelAccueil);
		
		this.getContentPane().add(monPanel);	
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == itemFilm){
			PanelConsultation panelConsultation = new PanelConsultation("film");
			this.setContentPane(panelConsultation);
			this.revalidate();
		}
		else{
			
			if(e.getSource() == itemActeur){
				PanelConsultation panelConsultation = new PanelConsultation("acteur");
				this.setContentPane(panelConsultation);
				this.revalidate();
				
			
			}
			else{
				
				if(e.getSource() == itemGenre){
					PanelConsultation panelConsultation = new PanelConsultation("genre");
					this.setContentPane(panelConsultation);
					this.revalidate();
					
				}
				
				else{
					if(e.getSource() == itemAFilm){
						PanelAjouter panelAjouter = new PanelAjouter("film");
						this.setContentPane(panelAjouter);
						this.revalidate();
					}
					else{
						
						if(e.getSource() == itemAActeur){
							PanelAjouter panelAjouter = new PanelAjouter("acteur");
							this.setContentPane(panelAjouter);
							this.revalidate();;
							
						
						}
						else{
							
							if(e.getSource() == itemAGenre){
								PanelAjouter panelAjouter = new PanelAjouter("genre");
								this.setContentPane(panelAjouter);
								this.revalidate();
								
							}
							
							else{
								if(e.getSource() == itemALien){
									PanelAjouter panelAjouter = new PanelAjouter("lien");
									this.setContentPane(panelAjouter);
									this.revalidate();
								}
								else{
									System.exit(0);
								}								
							}
						}
					}
				}
				
			}
				
		}
		
	}

}
