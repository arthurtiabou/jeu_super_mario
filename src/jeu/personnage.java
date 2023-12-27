package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu_mario.Main;
import jeu_objet.objet;

public class personnage 
{
	private int largeur,hauteur;//dimensions du personnage
	private int x,y;//position de l'image 
	protected boolean marche;//vrai quand le personnage marche 
	protected boolean versdroite;//vrai quand le personnage est tourne vers la droite 
	public int compteur;//compteur des pas du personnage
	protected boolean vivant;
	public personnage( int x, int y,int largeur, int hauteur) 
	{
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.compteur=0;
		this.marche=false;
		this.versdroite=true;
		this.vivant=true;
	}
	//****GETTERS AND SETTERS 
	public int getLargeur() {return largeur;}
	
	public void setLargeur(int largeur) {this.largeur = largeur;}
	
	public int getHauteur() {return hauteur;}
	
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}
	
	public int getX() {return x;}
	
	public void setX(int x) {this.x = x;}
	
	public int getY() {return y;}
	
	public void setY(int y) {this.y = y;}
	
	public boolean isMarche() {return marche;}
	
	public void setMarche(boolean marche) {this.marche = marche;}
	
	public boolean isVersdroite() {return versdroite;}
	
	public void setVersdroite(boolean versdroite) {this.versdroite = versdroite;}
	
	public int getCompteur() {return compteur;}
	
	public void setCompteur(int compteur) {this.compteur = compteur;}
	
	public boolean isVivant() {return vivant;}
	
	public void setVivant(boolean vivant) {this.vivant = vivant;}
	//****METHODE DE PERSONNAGE****//
	public void deplacement()
	{
		if(Main.scene.getXpos()>=0)
		{this.x=this.x-Main.scene.getDx();}
	}

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
	
	//detection contact a droite de mario
	
	public boolean contact_avant(objet obj)
	{
		if(this.x+this.largeur < obj.getX()||this.x +this.largeur >obj.getX()+5||this.y +this.hauteur <=obj.getY()||this.y >=obj.getY()+obj.getHauteur())
		{return false;}
		
		else{return true;}
	}
	
	//detection contact a gauche 
	public boolean contact_arriere(objet obj)
	{
		if(this.x > obj.getX() +obj.getLargeur()||this.x+this.largeur < obj.getX() + obj.getLargeur() -5||this.y +this.hauteur <=obj.getY()||this.y>obj.getY()+obj.getHauteur() )
		{return false;}
		else {return true;}
	}
	//detection contact en dessous de mario
	public boolean contact_dessous(objet obj)
	{
		if(this.x + this.largeur < obj.getX()+5||this.x > obj.getX()+obj.getLargeur()-5||this.y+this.hauteur < obj.getY()||this.y +this.hauteur > obj.getY() + 5)
		{return false;}
		else {return true;}
	}
	//detection contact au-dessus de mario
	public boolean contact_dessus(objet obj)
	{
		if(this.x + this.largeur < obj.getX()+5||this.x > obj.getX()+obj.getLargeur()-5||this.y < obj.getY()+obj.getHauteur()||this.y  > obj.getY() +obj.getHauteur() + 5)
		{return false;}
		else {return true;}
	}
	
	public boolean proche(objet obj)
	{
		if((this.x > obj.getX()-10 && this.x < obj.getX() + obj.getLargeur() + 10)|| (this.x +this.largeur > obj.getX()-10 && this.x +this.largeur < obj.getX() + obj.getLargeur() +10))
		{return true;}
		else{return false;}
	}
	
	public boolean contact_avant(personnage personnage)
	{
		if(this.isVersdroite()==true)
		{
			if(this.x+this.largeur <personnage.getX()||
					this.x +this.largeur >personnage.getX()+5||
					this.y +this.hauteur <=personnage.getY()||this.y >=personnage.getY()+personnage.getHauteur())
			{return false;}
			
			else{return true;}
		}
		else 
		{return false;}
		
	}
	public boolean contact_arriere(personnage personnage)
	{
		
		if(this.x > personnage.getX() +personnage.getLargeur()||
				this.x+this.largeur < personnage.getX() + personnage.getLargeur() -5
				||this.y>personnage.getY()+personnage.getHauteur()
				||this.y +this.hauteur <=personnage.getY())
		{return false;}
		else {return true;}
	}
	
	public boolean contact_dessous(personnage personnage)
	{
		if(this.x + this.largeur < personnage.getX()||
				this.x >personnage.getX()+personnage.getLargeur()||
				this.y+this.hauteur < personnage.getY()||this.y +this.hauteur >personnage.getY())
		{return false;}
		else {return true;}
	}
	
	public boolean proche(personnage personnage)
	{
		if((this.x >  personnage.getX()-10 && this.x < personnage.getX() +  personnage.getLargeur() + 10)|| 
				(this.x +this.largeur >  personnage.getX()-10
						&& this.x +this.largeur <  personnage.getX() +  personnage.getLargeur() +10))
		{return true;}
		else{return false;}
	}
}
