package jeu_objet;


import javax.swing.ImageIcon;

public class tuyau_vert extends objet
{
	
	
	public tuyau_vert(int x,int y)
	{
		super(x,y,45,80);
		super.icoobjet=new ImageIcon(getClass().getResource("/image_mario/tuyau_mario.png"));
		super.imgobjet=super.icoobjet.getImage();
	}


	//public Image getImgtuyau_vert() {return imgtuyau_vert;}

	//public void setImgtuyau_vert(Image imgtuyau_vert) {this.imgtuyau_vert = imgtuyau_vert;}
	
}
