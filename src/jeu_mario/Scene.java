package jeu_mario;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jeu.Goomba;
import jeu.Tortue;
import jeu.mario;
import jeu_objet.Piece;
import jeu_objet.bloc;
import jeu_objet.objet;
import jeu_objet.tuyau_vert;
import jeu_score.Compte_rebout;
import jeu_score.Score;

@SuppressWarnings("serial")
public class Scene extends JPanel
{
	//****image du fond****//
	private ImageIcon icofond,icofond2;
	private Image imgfond1;
	private Image imgfond2;
	//****image mario****//
	
	private int xfond1;
	private int xfond2;
	private int dx;
	private int xpos;
	private int ysol;//hauteur courante du sol
	private int hauteur_plafond;//hauteur courante du plafond
	private int i;
	private int j;
	//****image chateau****//
	private ImageIcon icochateau1;
	private ImageIcon icodepart;
	private Image imgdepart;
	private Image imgchateau1;
	private ImageIcon icodrapeau;
	private Image imgdrapeau;
	
	//objet mario
	public mario mar;
	//****objet tuyau
	public tuyau_vert tuyau_vert1;
	public tuyau_vert tuyau_vert2;
	public tuyau_vert tuyau_vert3;
	public tuyau_vert tuyau_vert4;
	public tuyau_vert tuyau_vert5;
	public tuyau_vert tuyau_vert6;
	public tuyau_vert tuyau_vert7;
	public tuyau_vert tuyau_vert8;
	//****objet bloc
	public bloc bloc1;
	public bloc bloc2;
	public bloc bloc3;
	public bloc bloc4;
	public bloc bloc5;
	public bloc bloc6;
	public bloc bloc7;
	public bloc bloc8;
	public bloc bloc9;
	public bloc bloc10;
	public bloc bloc11;
	public bloc bloc12;
	//****objet piece
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	//****personnage tortue****//
	public Tortue tortue1;
	public Tortue tortue2;
	public Tortue tortue3;
	public Tortue tortue4;
	public Tortue tortue5;
	public Tortue tortue6;
	public Tortue tortue7;
	public Tortue tortue8;
	public Tortue tortue9;
	//****personnage goomba****//
	public Goomba goomba1;
	public Goomba goomba2;
	public Goomba goomba3;
	public Goomba goomba4;
	public Goomba goomba5;
	public Goomba goomba6;
	public Goomba goomba7;
	public Goomba goomba8;
	//****liste objet****//
	private ArrayList<objet> tabobjets;//tableau qui enregistre tous les objets
	private  ArrayList<Piece> tabpieces;
	private  ArrayList<Tortue> tabtortues;
	private  ArrayList<Goomba> tabgoombas;
	//****
	private Score score;
	private Font police;
	private Compte_rebout compte_rebout;
	//**** CONTRUCTEUR ****//
	public Scene()
	{
		super();
		this.xfond1=-50;
		this.xfond2=750;
		this.dx=0;
		this.xpos=-1;
		this.ysol=295;
		this.hauteur_plafond=0;
		
		icofond =new ImageIcon(getClass().getResource("/image_mario/fond_mario.png"));
		this.imgfond1=this.icofond.getImage();
		this.imgfond2=this.icofond.getImage();
		
		this.icochateau1=new ImageIcon(getClass().getResource("/image_mario/chateau_fin.png"));
		this.imgchateau1=this.icochateau1.getImage();
		this.icodepart=new ImageIcon(getClass().getResource("/image_mario/mario_depart.png"));
		this.imgdepart=this.icodepart.getImage();
		
		mar=new mario(300,228);
		
		//****
		tuyau_vert1=new tuyau_vert(800,222);
		tuyau_vert2=new tuyau_vert(1200,222);
		tuyau_vert3=new tuyau_vert(1800,222);
		tuyau_vert4=new tuyau_vert(2100,222);
		tuyau_vert5=new tuyau_vert(2700,222);
		tuyau_vert6=new tuyau_vert(3200,222);
		tuyau_vert7=new tuyau_vert(4000,222);
		tuyau_vert8=new tuyau_vert(4600,222);
		//****bloc instancier***//
		bloc1=new bloc(600,180);
		bloc2=new bloc(1410,180);
		bloc3=new bloc(1500,170);
		bloc4=new bloc(1590,160);
		bloc5=new bloc(2200,180);
		bloc6=new bloc(2800,160);
		bloc7=new bloc(2900,180);
		bloc8=new bloc(3700,160);
		bloc9=new bloc(3790,140);
		bloc10=new bloc(4200,170);
		bloc11=new bloc(4400,200);
		bloc12=new bloc(4500,210);
		//***piece instancier****//
		piece1=new Piece(602,120);
		piece2=new Piece(1412,120);
		piece3=new Piece(1502,95);
		piece4=new Piece(1592,125);
		piece5=new Piece(1900,145);
		piece6=new Piece(1850,145);
		piece7=new Piece(3250,135);
		piece8=new Piece(3600,125);
		piece9=new Piece(4390,145);
		piece10=new Piece(4500,40);
		//****tortue instancier****//
		tortue1=new Tortue(950,253);
		tortue2=new Tortue(1500,253);
		tortue3=new Tortue(1800,253);
		tortue4=new Tortue(2400,253);
		tortue5=new Tortue(3100,253);
		tortue6=new Tortue(3600,253);
		tortue7=new Tortue(3900,253);
		tortue8=new Tortue(4250,253);
		tortue9=new Tortue(4400,253);
		//****goomba instancier****//
		goomba1=new Goomba(800,273);
		goomba2=new Goomba(1100,273);
		goomba3=new Goomba(2100,273);
		goomba4=new Goomba(2600,273);
		goomba5=new Goomba(3200,273);
		goomba6=new Goomba(3500,273);
		goomba7=new Goomba(4000,273);
		goomba8=new Goomba(4500,273);
		
		this.icodrapeau=new ImageIcon(getClass().getResource("/image_mario/drapeau_fin.png"));
		this.imgdrapeau=this.icodrapeau.getImage();
		
		tabobjets=new ArrayList<objet>();
		//****ajout des objets dans le tableau****//
		this.tabobjets.add(tuyau_vert1);
		this.tabobjets.add(tuyau_vert2);
		this.tabobjets.add(tuyau_vert3);
		this.tabobjets.add(tuyau_vert4);
		this.tabobjets.add(tuyau_vert5);
		this.tabobjets.add(tuyau_vert6);
		this.tabobjets.add(tuyau_vert7);
		this.tabobjets.add(tuyau_vert8);
		
		this.tabobjets.add(bloc1);
		this.tabobjets.add(bloc2);
		this.tabobjets.add(bloc3);
		this.tabobjets.add(bloc4);
		this.tabobjets.add(bloc5);
		this.tabobjets.add(bloc6);
		this.tabobjets.add(bloc7);
		this.tabobjets.add(bloc8);
		this.tabobjets.add(bloc9);
		this.tabobjets.add(bloc10);
		this.tabobjets.add(bloc11);
		this.tabobjets.add(bloc12);
		
		tabpieces=new ArrayList<Piece>();
		this.tabpieces.add(piece1);
		this.tabpieces.add(piece2);
		this.tabpieces.add(piece3);
		this.tabpieces.add(piece4);
		this.tabpieces.add(piece5);
		this.tabpieces.add(piece6);
		this.tabpieces.add(piece7);
		this.tabpieces.add(piece8);
		this.tabpieces.add(piece9);
		this.tabpieces.add(piece10);
		
		tabgoombas=new ArrayList<Goomba>();
		this.tabgoombas.add(this.goomba1);
		this.tabgoombas.add(this.goomba2);
		this.tabgoombas.add(this.goomba3);
		this.tabgoombas.add(this.goomba4);
		this.tabgoombas.add(this.goomba5);
		this.tabgoombas.add(this.goomba6);
		this.tabgoombas.add(this.goomba7);
		this.tabgoombas.add(this.goomba8);
		
		tabtortues=new  ArrayList<Tortue>();
		this.tabtortues.add(this.tortue1);
		this.tabtortues.add(this.tortue2);
		this.tabtortues.add(this.tortue3);
		this.tabtortues.add(this.tortue4);
		this.tabtortues.add(this.tortue5);
		this.tabtortues.add(this.tortue6);
		this.tabtortues.add(this.tortue7);
		this.tabtortues.add(this.tortue8);
		this.tabtortues.add(this.tortue9);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		score=new Score();
		police=new Font("Arial",Font.PLAIN,18);
		compte_rebout=new Compte_rebout();
		
		Thread chrono_ecran= new Thread(new Chrono());
		chrono_ecran.start();
		
	}
	
	
	public int getXfond1() {return xfond1;}


	public void setXfond1(int xfond1) {this.xfond1 = xfond1;}


	public int getXfond2() {return xfond2;}


	public void setXfond2(int xfond2) {this.xfond2 = xfond2;}


	public int getXpos() {return xpos;}

	public void setXpos(int xpos) {this.xpos = xpos;}

	public int getDx() {return dx;}

	public void setDx(int dx) {this.dx = dx;}
	
	

	public int getYsol() {return ysol;}


	public void setYsol(int ysol) {this.ysol = ysol;}


	public int getHauteur_plafond() {return hauteur_plafond;}

	public void setHauteur_plafond(int hauteur_plafond) {this.hauteur_plafond = hauteur_plafond;}


	public void deplacement_fond()
	{
		if(this.xpos>=0 && this.xpos <=4600)
		{
			
			this.xpos=this.xpos+this.dx;
			this.xfond1=this.xfond1-this.dx;
			this.xfond2=this.xfond2-this.dx;
		}
		
		if(this.xfond1==-800)
		{
			this.xfond1=800;
		}
		else if(this.xfond2==-800)
		{
			this.xfond2=800;
		}
		else if(this.xfond1==800)
		{
			this.xfond1=-800;
		}
		else if(this.xfond2==800)
		{
			this.xfond2=-800;
		}
	}
	
	private boolean partieGagne()
	{
		if(this.compte_rebout.getCompteur_temps()> 0 &&this.mar.isVivant()==true && this.score.getNbre_pieces()==10 && this.xpos >4400)
		{return true;}
		
		else{return false;}
	}
	
	private boolean partiePerdue()
	{
		if(this.mar.isVivant()==false || this.compte_rebout.getCompteur_temps() <=0)
		{return true;}
		
		else
		{return false;}
	}
	public boolean finPartie()
	{
		if(this.partieGagne()==true || this.partiePerdue()==true)
		{return true;}
		else
		{return false;}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2=(Graphics2D)g;
		
		//detection contact  avec objet
		for(i=0;i < this.tabobjets.size();i++)
		{
			//mario
			if(this.mar.proche(this.tabobjets.get(i))){this.mar.contact(this.tabobjets.get(i));}
			//goomba
			for(j=0;j < this.tabgoombas.size();j++)
			{
				if(this.tabgoombas.get(j).proche(this.tabobjets.get(i)))
				{
					this.tabgoombas.get(j).contact(this.tabobjets.get(i));
				}
			}
			//tortue
			for(j=0;j < this.tabtortues.size();j++)
			{
				if(this.tabtortues.get(j).proche(this.tabobjets.get(i)))
				{
					this.tabtortues.get(j).contact(this.tabobjets.get(i));
				}
			}
		}
		//detection des contact mario avec des pieces
		for(i=0;i < this.tabpieces.size();i++)
		{
			
			if(this.mar.proche(this.tabpieces.get(i)))
			{
				if(this.mar.contact_piece(this.tabpieces.get(i)))
				{
					this.tabpieces.remove(i);
					this.score.setNbre_pieces(this.score.getNbre_pieces()+1);
				}
				
			}
		}
		
		//detection des contact des goombas  avec personnage hors mario
		for(i=0;i< this.tabgoombas.size();i++)
		{
			//goombas
			for(j=0;j < this.tabgoombas.size();j++)
			{
				if(j!=i)
				{
					if(this.tabgoombas.get(j).proche(this.tabgoombas.get(i)))
					{
						this.tabgoombas.get(j).contact(this.tabgoombas.get(i));
					}
				}
			}
			//tortues
			for(j=0;j < this.tabtortues.size();j++)
			{
					if(this.tabtortues.get(j).proche(this.tabgoombas.get(i)))
					{
						this.tabtortues.get(j).contact(this.tabgoombas.get(i));
					}
			}
		}
		//detection des contact des tortues  avec personnage hors mario
		for(i=0;i< this.tabtortues.size();i++)
		{
			//goombas
			for(j=0;j < this.tabgoombas.size();j++)
			{
					if(this.tabgoombas.get(j).proche(this.tabtortues.get(i)))
					{
						this.tabgoombas.get(j).contact(this.tabtortues.get(i));
					}
			}
			//tortues
			for(j=0;j < this.tabtortues.size();j++)
			{
				if(j!=i)
				{
					if(this.tabtortues.get(j).proche(this.tabtortues.get(i)))
					{
						this.tabtortues.get(j).contact(this.tabtortues.get(i));
					}
				}
			}
		}
		
		//detection des contact mario avec les personnages 
		//goombas
		for(i=0;i< this.tabgoombas.size();i++)
		{
			if((this.mar.proche(this.tabgoombas.get(i))) && (this.tabgoombas.get(i).isVivant()==true))
			{
				this.mar.contact(this.tabgoombas.get(i));
			}
		}
		//tortue
		for(i=0;i< this.tabtortues.size();i++)
		{
			if((this.mar.proche(this.tabtortues.get(i))) && (this.tabtortues.get(i).isVivant()==true))
			{
				this.mar.contact(this.tabtortues.get(i));
			}
		}
	    //****deplacement de tous les objets du tableaux****//
		this.deplacement_fond();
		if(this.xpos >=0 && this.xpos <= 4600)
		{
			for(i=0;i < this.tabobjets.size();i++){this.tabobjets.get(i).deplacement();}
			for(i=0;i < this.tabpieces.size();i++){this.tabpieces.get(i).deplacement();}
			for(i=0;i < this.tabtortues.size();i++){this.tabtortues.get(i).deplacement();}
			for(i=0;i < this.tabgoombas.size();i++){this.tabgoombas.get(i).deplacement();}
		}
		
		//****image de fond****//
		g2.drawImage(this.imgfond1,this.xfond1,0,800,360,null);//dessin de l'image de fond
		g2.drawImage(this.imgfond2,this.xfond2,0,800,360,null);
		//****image chateau depart et fin****//
		g2.drawImage(imgchateau1,0-this.xpos,130,150,175,null);//code provisoire
		g2.drawImage(imgchateau1,5000-this.xpos,130,150,175,null);//code provisoire
		//****image objet****//
		for(i=0;i < this.tabobjets.size();i++)
		{g2.drawImage(this.tabobjets.get(i).getImgobjet(), this.tabobjets.get(i).getX(), this.tabobjets.get(i).getY(),this.tabobjets.get(i).getLargeur(),this.tabobjets.get(i).getHauteur(),null);}
		//****image piece****//
		for(i=0;i < this.tabpieces.size();i++)
		{g2.drawImage(this.tabpieces.get(i).bouge(), this.tabpieces.get(i).getX(), this.tabpieces.get(i).getY(),this.tabpieces.get(i).getLargeur(),this.tabpieces.get(i).getHauteur(),null);}
		//****drapeau d'arrive****//
		g2.drawImage(imgdrapeau, 4800-this.xpos, 230, 75,75,null);
		//****image panneau de depart****//
		g2.drawImage(imgdepart,175-this.xpos,227,75,75,null);
		//****image mario****//
		if(this.mar.isVivant()==true)
		{
			if(this.mar.isSaut()){g2.drawImage(this.mar.saute(),this.mar.getX(),this.mar.getY(),40,75,null);}
			else{g2.drawImage(this.mar.marche("mario", 15),this.mar.getX(),this.mar.getY(),40,75,null);}
		}
			else{g2.drawImage(this.mar.meurt(),this.mar.getX(),this.mar.getY(),40,75,null);}
		
		//****image goombas****//
		for(i=0;i< this.tabgoombas.size();i++)
		{
			if(this.tabgoombas.get(i).isVivant()==true)
			{g2.drawImage(this.tabgoombas.get(i).marche("goomba", 45),this.tabgoombas.get(i).getX(),this.tabgoombas.get(i).getY(),this.tabgoombas.get(i).getLargeur(),this.tabgoombas.get(i).getHauteur(),null);}
			else{g2.drawImage(this.tabgoombas.get(i).meurt(),this.tabgoombas.get(i).getX(),this.tabgoombas.get(i).getY(),this.tabgoombas.get(i).getLargeur(),this.tabgoombas.get(i).getHauteur(),null);}
		}
		//****image tortues****//
		for(i=0;i< this.tabtortues.size();i++)
		{
			if(this.tabtortues.get(i).isVivant()==true)
			{g2.drawImage(this.tabtortues.get(i).marche("tortue", 55),this.tabtortues.get(i).getX(),this.tabtortues.get(i).getY(),this.tabtortues.get(i).getLargeur(),this.tabtortues.get(i).getHauteur(),null);}
			else{g2.drawImage(this.tabtortues.get(i).meurt(),this.tabtortues.get(i).getX(),this.tabtortues.get(i).getY(),this.tabtortues.get(i).getLargeur(),this.tabtortues.get(i).getHauteur(),null);}
		}
		
		//MISE a jour du score
		g2.setFont(police);
		g2.drawString(this.score.getNbre_pieces()+"piece(s) trouvee(s) sur "+this.score.getNbre_total_pieces(),450,25);
		//Affichage compte a rebout
		g2.drawString(this.compte_rebout.getStr(),5,25);
		//Fin de partie
		
		if(this.finPartie()==true)
		{
			Font policeFin=new Font("Arial",Font.BOLD,50);
			g2.setFont(policeFin);
			if(this.partieGagne()==true)
			{g2.drawString("vous avez gagne!!",120,180);}
			else
			{g2.drawString("Vous avez perdu...",120,180);}
		}
	}
}
