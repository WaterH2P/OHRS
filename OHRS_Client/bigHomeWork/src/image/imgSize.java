package image;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class imgSize {
		public imgSize(){
		
		}
		public ImageIcon getIconRight(ImageIcon icon , int width, int height){
			ImageIcon imageIcon=new ImageIcon( getSizeRight(icon, width, height));
			return imageIcon;
		}
		public Image getSizeRight(ImageIcon icon,double width,int height){ 
			BufferedImage tag;       
			           Image img = icon.getImage();
			           // 鏋勯�營mage瀵硅薄
			            tag = new BufferedImage((int)width,  height,
			                  BufferedImage.TYPE_INT_RGB);
			           tag.getGraphics().drawImage(img, 0, 0, (int)width,  height, null); 
			           
		    return tag;
		}
		public ImageIcon getIconRight(ImageIcon icon , double width, int height){
			ImageIcon imageIcon=new ImageIcon( getSizeRight(icon, width, height));
			return imageIcon;
		}
		public Image getSizeRight(ImageIcon icon,int width,int height){ 
			BufferedImage tag;       
			           Image img = icon.getImage();
			           // 鏋勯�營mage瀵硅薄
			            tag = new BufferedImage(width,  height,
			                  BufferedImage.TYPE_INT_RGB);
			           tag.getGraphics().drawImage(img, 0, 0, width,  height, null); 
			           
		    return tag;
		}
		public Image getSizeRight(ImageIcon icon,int width,double height){ 
			BufferedImage tag;       
			           Image img = icon.getImage();
			           // 鏋勯�營mage瀵硅薄
			            tag = new BufferedImage(width,  (int)height,
			                  BufferedImage.TYPE_INT_RGB);
			           tag.getGraphics().drawImage(img, 0, 0, width, (int) height, null); 
			           
		    return tag;
		}
		public ImageIcon getIconRight(ImageIcon icon , int width, double height){
			ImageIcon imageIcon=new ImageIcon( getSizeRight(icon, width, height));
			return imageIcon;
		}
}
