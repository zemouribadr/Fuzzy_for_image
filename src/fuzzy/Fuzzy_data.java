package fuzzy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import fuzzy_param.Fuzzy_function;
import outil.Center;
import outil.Point;

public class Fuzzy_data {
	private List<Point> data_point;
	private List<Center> cluster_point;
	private double fuzziness;
	private int num_clusters;
	private int width;
	private int height;
	BufferedImage image;
	
	
	
	public Fuzzy_data(double fuzziness, int num_clusters,BufferedImage image) {
		this.fuzziness = fuzziness;
		this.num_clusters = num_clusters;
		this.data_point=new LinkedList<>();
		this.cluster_point=new LinkedList<>();
		this.image=image;
		this.width=image.getWidth();;
		this.height=image.getHeight();
		for(int i=0;i<num_clusters;i++){
			Center data=new Center((int)Fuzzy_function.getRandomNumber(0, 256),(int)Fuzzy_function.getRandomNumber(0,256),(int)Fuzzy_function.getRandomNumber(0,256));
			this.cluster_point.add(data);
		}
	 
	    for (int i = 0; i < this.height; i++) {
	      for (int j = 0; j < this.width; j++) {
	        int pixel = image.getRGB(j, i);
	        data_point.add((Point) Fuzzy_function.printPixelARGB(pixel));
	      }
	    }
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public List<Point> getData_point() {
		return data_point;
	}
	public void setData_point(List<Point> data_point) {
		this.data_point = data_point;
	}
	public Point getData_point(int i) {
		return data_point.get(i);
	}
	public List<Center> getCluster_point() {
		return cluster_point;
	}
	public Center getCluster_point(int i) {
		return cluster_point.get(i);
	}
	public void setCluster_point(List<Center> cluster_point) {
		this.cluster_point = cluster_point;
	}
	public double getFuzziness() {
		return fuzziness;
	}
	public void setFuzziness(double fuzziness) {
		this.fuzziness = fuzziness;
	}
	public int getNum_clusters() {
		return num_clusters;
	}
	public void setNum_clusters(int num_clusters) {
		this.num_clusters = num_clusters;
	}
	
	
	
}
