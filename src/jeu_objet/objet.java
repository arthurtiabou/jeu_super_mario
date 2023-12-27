package jeu_objet;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu_mario.Main;

public class objet 
{
	private int largeur,hauteur;//taille de l'objet
	private int x,y;//position de l'objet
	public Image imgobjet;
	public ImageIcon icoobjet;
	
	
	public objet( int x, int y ,int largeur, int hauteur) {
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
	}

	public int getLargeur() {return largeur;}

	public void setLargeur(int largeur) {this.largeur = largeur;}

	public int getHauteur() {return hauteur;}

	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	public int getX() {return x;}

	public void setX(int x) {this.x = x;}

	public int getY() {return y;}

	public void setY(int y) {this.y = y;}
	
	public Image getImgobjet() {return imgobjet;}

	public void setImgobjet(Image imgobjet) {this.imgobjet = imgobjet;}

	public ImageIcon getIcoobjet() {return icoobjet;}

	public void setIcoobjet(ImageIcon icoobjet) {this.icoobjet = icoobjet;}

	public void deplacement()
	{
		if(Main.scene.getXpos()>=0)
		{this.x=this.x-Main.scene.getDx();}
	}

	
}
