package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu_mario.Main;
import jeu_objet.Piece;
import jeu_objet.objet;

public class mario extends personnage
{
	private Image imgmario;
	private ImageIcon icomario;
	private boolean saut;
	private int compteur_saut;//duree du saut et la hauteur du saut
	private int compteur_mort;
	public mario(int x, int y) 
	{
		super(x, y, 40, 75);
		this.icomario=new ImageIcon("/image_mario/mario_arret_droite.png");
		this.imgmario=this.icomario.getImage();
		
		this.saut=false;
		this.compteur_saut=0;
		this.compteur_mort=0;
	}
	public Image getImgmario() {return imgmario;}
	
	public void setImgmario(Image imgmario) {this.imgmario = imgmario;}
	
	
	public boolean isSaut() {return saut;}
	
	public void setSaut(boolean saut) {this.saut = saut;}
	
	public int getCompteur_saut() {return compteur_saut;}
	
	public void setCompteur_saut(int compteur_saut) {this.compteur_saut = compteur_saut;}
	
	//****METHODE DE MARIO****//
	public Image marche(String nom,int frequence)
	{

		String str;
		ImageIcon ico;
		Image img;
		
		if(this.marche==false)
		{
			if(this.versdroite==true)
			{
				str="/image_mario/"+nom+"_arret_droite.png";
			}
			else
			{
				str="/image_mario/"+nom+"_arret_gauche.png";
			}
		}
		else
		{
			this.compteur++;
			if(this.compteur/frequence==0)
			{
				if(this.versdroite==true)
				{
					str="/image_mario/"+nom+"_arret_droite.png";
				}
				else
				{
					str="/image_mario/"+nom+"_arret_gauche.png";
				}
			}
			else
			{
				if(this.versdroite==true)
				{
					str="/image_mario/"+nom+"_marche_droite.png";
				}
				else
				{
					str="/image_mario/"+nom+"_marche_gauche.png";
				}
			}
			if(this.compteur==2*frequence)
			{
				this.compteur=0;
			}
		}
		//Affichage de l'image du personnage
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}
	
	public Image saute()
	{
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteur_saut++;
		//montee du saut 
		if(this.compteur_saut<=45)
		{
			if(this.getY()>Main.scene.getHauteur_plafond()){this.setY(this.getY()-4);}
			else{this.compteur_saut=46;}
			if(this.isVersdroite()==true){str="/image_mario/mario_saut_droite.png";}
			else{str="/image_mario/mario_saut_gauche.png";}
		}
		//retomber du saut
		else if(this.getY()+this.getHauteur() < Main.scene.getYsol())
		{
			this.setY(this.getY() +1);
			if(this.isVersdroite()==true){str="/image_mario/mario_saut_droite.png";}
			else{str="/image_mario/mario_saut_gauche.png";}
		}
		//saut terminer
		else
		{
			if(this.isVersdroite()==true){str="/image_mario/mario_marche_droite.png";}
			else {str="/image_mario/mario_marche_gauche.png";}
			this.setY(this.getY()+4);
			this.saut=false;
			this.compteur_saut=0;
		}
		//affichage de l'image
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}
		//contact horizontale
	public void contact(objet obj)
	{
		if((super.contact_avant(obj)==true && this.isVersdroite()==true)||(super.contact_arriere(obj)==true && this.isVersdroite()==false))
		{
			Main.scene.setDx(0);
			this.setMarche(false);
		}
		//contact avec objet en dessous
		if(super.contact_dessous(obj)==true&& this.saut==true)
		{Main.scene.setYsol(obj.getY());}
		
		else if(super.contact_dessous(obj)==false)//mario tombe sur le sol initiale
		{
			Main.scene.setYsol(295);//altitude sol initiale
			if(this.saut==false) {this.setY(228);}//altitude initiale de mario
			
		}
		// contact avec un objet au-dessus
		if(super.contact_dessus(obj)==true)
		{Main.scene.setHauteur_plafond(obj.getY()+obj.getHauteur());}//le plafond devient le dessous de l'objet
		
		else if(super.contact_dessus(obj)==false&& this.saut==false)
		{Main.scene.setHauteur_plafond(0);}//altpitude du plafond (ciel)
	}
	
	public boolean contact_piece(objet piece)
	{
		//le contact avec une piece n'a aucune repercution sur mario
		if(this.contact_arriere(piece)==true||this.contact_avant(piece)==true||this.contact_dessous(piece)==true ||this.contact_dessus(piece)==true)
		{return true;}
		else {return false;}
	}
	
	public void contact(personnage personnage)
	{
		if((super.contact_avant(personnage)==true)|| (super.contact_arriere(personnage)==true))
		{
			this.setMarche(false);
			this.setVivant(false);
		}
		else if(super.contact_dessous(personnage)==true)
		{
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
	}
	
	public Image meurt()
	{
		String str;
		ImageIcon ico;
		Image img;
		
		str="/image_mario/explosition.png";
		this.compteur_mort++;
		if(this.compteur_mort > 100)
		{
			str="/image_mario/mario_arret_droite.png";
			this.setY(this.getY()-1);
		}
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}
	
	
}
