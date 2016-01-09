package fuzzy_param;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader extends Component {
	 
	  public static void main(String[] foo) {
	    new ImageReader();
	  }
	 
	  public void printPixelARGB(int pixel) {
	    int alpha = (pixel >> 24) & 0xff;
	    int red = (pixel >> 16) & 0xff;
	    int green = (pixel >> 8) & 0xff;
	    int blue = (pixel) & 0xff;
	    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
	  }
	 
	  private void marchThroughImage(BufferedImage image) {
	    int w = image.getWidth();
	    int h = image.getHeight();
	    System.out.println("width, height: " + w + ", " + h);
	 
	    for (int i = 0; i < h; i++) {
	      for (int j = 0; j < w; j++) {
	        System.out.println("x,y: " + j + ", " + i);
	        int pixel = image.getRGB(j, i);
	        printPixelARGB(pixel);
	        System.out.println("");
	      }
	    }
	  }
	 
	  public ImageReader() {
	    try {
	      // get the BufferedImage, using the ImageIO class
	      BufferedImage image = 
	        ImageIO.read(this.getClass().getResource("img.jpg"));
	      marchThroughImage(image);
	      for(int i=1;i<=153;i++)
	    	  for(int j=1;j<=177;j++)
	      image.setRGB(i, j, 0);
	      System.out.println("test");
	      marchThroughImage(image);
	      printPixelARGB(259);
	      try {
	    	    // retrieve image
	    	    BufferedImage bi = image;
	    	    File outputfile = new File("saved.jpg");
	    	    ImageIO.write(bi, "jpg", outputfile);
	    	} catch (IOException e) {
	    		System.out.println(e);
	    	}
	    } catch (IOException e) {
	      System.err.println(e.getMessage());
	      
	    }
	  }
	 
	}
