package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu_mario.Main;
import jeu_objet.objet;

public class Goomba extends personnage implements Runnable
{
	private Image imggoomba;
	private ImageIcon icogoomba;
	
	private final int pause=15;
	private int dxgoomba;
	
	//CONSTRUCTEUR
	public Goomba(int x,int y)
	{
		super(x,y,30,30);
		super.setVersdroite(true);
		super.setMarche(true);
		this.dxgoomba=1;
		
		this.icogoomba=new ImageIcon(getClass().getResource("/image_mario/goomba_arret_droite.png"));
		this.imggoomba=this.icogoomba.getImage();
		
		Thread chronogoomba=new Thread(this);
		chronogoomba.start();
	}
	//GETTERS QND SETTERS

	public Image getImggoomba() {return imggoomba;}

	public void setImggoomba(Image imggoomba) {this.imggoomba = imggoomba;}

	public ImageIcon getIcogoomba() {return icogoomba;}

	public void setIcogoomba(ImageIcon icogoomba) {this.icogoomba = icogoomba;}

	//****METHODES DE GOOMBA****//
	public void contact(objet obj)
	{
		if((super.contact_avant(obj)==true && this.isVersdroite()==true))
		{
			super.setVersdroite(false);
			this.dxgoomba=-1;
		}
		else if(super.contact_arriere(obj)==true && this.isVersdroite()==false)
		{
			super.setVersdroite(true);
			this.dxgoomba=1;
		}
	}
	public void bouge()//deplacement du goomba
	{
		if(super.isVersdroite()==true)
		{this.dxgoomba=1;}
		else
		{this.dxgoomba=-1;}
		super.setX(super.getX() +this.dxgoomba);
	}
	public void run() 
	{
		try
		{Thread.sleep(20);}
		catch (InterruptedException e){}
		
		while(true)
		{
			if(this.vivant==true)
			{
				this.bouge();
				try
				{Thread.sleep(pause);}
				catch (InterruptedException e){}
			}
			
		}
		
	}
	
	public void contact(personnage personnage)
	{
		if(super.contact_avant(personnage)==true && this.isVersdroite()==true)
		{
			super.setVersdroite(false);
			this.dxgoomba=-1;
		}
		else if(super.contact_arriere(personnage)==true && this.isVersdroite()==false) 
		{
			super.setVersdroite(true);
			this.dxgoomba=1;
		}
	}
	
	public Image meurt()
	{
		String str;
		ImageIcon ico;
		Image img;
		
		
		
		if(this.isVersdroite()==true)
		{str="/image_mario/tortue_ecrase_droite.png";}
		else
		{str="/image_mario/tortue_ecrase_gauche.png";}
		
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}
}
