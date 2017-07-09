import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel(InputStream input) {
       try {                
          image = ImageIO.read(input);
       } catch (IOException ex) {

    	   ex.printStackTrace();
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
    
    public void setImage(InputStream input){
    	try {                
            image = ImageIO.read(input);
         } catch (IOException ex) {

      	   ex.printStackTrace();
         }
    	this.repaint();
    }

}