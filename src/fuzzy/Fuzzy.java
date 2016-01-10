package fuzzy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import fuzzy_param.Fuzzy_function;
import fuzzy_param.Fuzzy_parametre;
import outil.Center;
import outil.Point;

public class Fuzzy {
		Fuzzy_data fuzzy_data;
		private double[][] matrix;
		
		
		
		public Fuzzy(String url) {
			
			try {
				BufferedImage image =ImageIO.read(this.getClass().getResource(url));
				fuzzy_data=new Fuzzy_data(Fuzzy_parametre.getFuzziness(),Fuzzy_parametre.getNum_cluster(), image);
				matrix=new double[image.getHeight()*image.getWidth()][Fuzzy_parametre.getNum_cluster()];
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		public void init()
		{
			for(int i=0;i<this.matrix.length;i++){
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					matrix[i][j]=euclidien_distance(fuzzy_data.getData_point(i).getR(),fuzzy_data.getCluster_point(j).getR(),fuzzy_data.getData_point(i).getG(),fuzzy_data.getCluster_point(j).getG(),fuzzy_data.getData_point(i).getB(),fuzzy_data.getCluster_point(j).getB());
				}
			}
			
		}
		public double euclidien_distance(int rd,int rc,int gd,int gc,int bd,int bc){
			return Math.sqrt((rd-rc)*(rd-rc)+(gd-gc)*(gd-gc)+(bd-bc)*(bd-bc));
		}
		public void membership_matrix()
		{
			for(int i=0;i<this.matrix.length;i++){
		    	double result=0.0;
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					result=result+Math.pow(1/matrix[i][j],1/(fuzzy_data.getFuzziness()-1));
				}
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					matrix[i][j]=Fuzzy_function.floorconvert(Math.pow(1/matrix[i][j],1/(fuzzy_data.getFuzziness()-1))/result);
				}
				
			}
		}
		public List<Center> new_cendroid()
		{
			List<Center> center_point=new LinkedList<>();
			for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
				double result=0.0,r=0.0,g=0.0,b=0.0;
			for(int i=0;i<this.matrix.length;i++){
				result=result+Math.pow(matrix[i][j],fuzzy_data.getFuzziness());
				}
			for(int i=0;i<this.matrix.length;i++){

				r=r+Math.pow(matrix[i][j],fuzzy_data.getFuzziness())*fuzzy_data.getData_point(i).getR();
				g=g+Math.pow(matrix[i][j],fuzzy_data.getFuzziness())*fuzzy_data.getData_point(i).getG();
				b=b+Math.pow(matrix[i][j],fuzzy_data.getFuzziness())*fuzzy_data.getData_point(i).getB();
			
			
		}
			center_point.add(new Center((int)(r/result),(int)(g/result),(int)(b/result)));
			System.out.println(r/result+"    "+ g/result+"    Y="+b/result);
		}
			return center_point;
						
		}
		public void cendroid_converge(){
			boolean cond=true;
			loops:
			while(cond){
				init();
				membership_matrix();
				List<Center> center=new_cendroid();
				
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					Integer r=center.get(j).getR();
					Integer g=center.get(j).getR();
					Integer b=center.get(j).getR();
					if(((Double)(g.doubleValue())).isNaN()||((Double)(b.doubleValue())).isNaN()||((Double)(r.doubleValue())).isNaN()){
						break loops;
					}
					if(Math.abs(center.get(j).getR()-fuzzy_data.getCluster_point(j).getR())==0&& Math.abs(center.get(j).getG()-fuzzy_data.getCluster_point(j).getG())==0 && Math.abs(center.get(j).getB()-fuzzy_data.getCluster_point(j).getB())==0 ){
						cond=false;
					}
					else{
						cond=true;
					}
				}
					System.out.println(" badr");
					fuzzy_data.setCluster_point(center);
				
			}
		}
		public List<Point>[] cluster()
		{
			List<Point>[] cluster=new List[Fuzzy_parametre.getNum_cluster()];
			for(int i=0;i<Fuzzy_parametre.getNum_cluster();i++){
				cluster[i]=new LinkedList<>();
			}
			for(int i=0;i<this.matrix.length;i++){
				int max=0;
				double value=0;
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					if(matrix[i][j]>value){
						max=j;
						value=matrix[i][j];
					}
					}
				cluster[max].add(fuzzy_data.getData_point(i));
			}
			return cluster;
		}
		public Fuzzy_data getFuzzy_data() {
			return fuzzy_data;
		}
		public void setFuzzy_data(Fuzzy_data fuzzy_data) {
			this.fuzzy_data = fuzzy_data;
		}
		public double[][] getMatrix() {
			return matrix;
		}
		public void setMatrix(double[][] matrix) {
			this.matrix = matrix;
		}			
}
