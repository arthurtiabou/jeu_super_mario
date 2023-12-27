package jeu_objet;


import javax.swing.ImageIcon;

public class bloc extends objet
{
	
	
	public bloc(int x,int y)
	{
		super(x,y,40,40);
		super.icoobjet=new ImageIcon(getClass().getResource("/image_mario/bloc_mario.png"));
		super.imgobjet=super.icoobjet.getImage();
	}


	//public Image getImgbloc() {return imgbloc;}

	//public void setImgbloc(Image imgbloc) {this.imgbloc = imgbloc;}
}
