package jeu_objet;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends objet implements Runnable 
{
	//****VARIABLES****//
	private final int pause=15;
	private int compteur;
	//****CONTRUCTEUR
	public Piece(int x,int y)
	{
		super(x,y,40,40);
		super.icoobjet=new ImageIcon(getClass().getResource("/image_mario/piece_mario2.png"));
		super.imgobjet=super.icoobjet.getImage();
	}
	
	//****METHODES****//
	public Image bouge() 
	{
		String str;
		ImageIcon ico;
		Image img;
		this.compteur++;
		if(this.compteur/100==0)
		{str="/image_mario/piece_mario.png";}
		else{str="/image_mario/piece_mario2.png";}
		
		if(this.compteur==200)	{this.compteur=0;}
		
		// Affichage de l'image 
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		
		return img;
	}

	@Override
	public void run() 
	{
		try
		{Thread.sleep(20);}
		catch(InterruptedException e){}
		
		while(true)//boucle infinie
		{
			this.bouge();
			try
			{Thread.sleep(pause);}
			catch(InterruptedException e){}
		}
		
	}
}
