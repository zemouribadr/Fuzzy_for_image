package fuzzy_param;

import outil.Data;
import outil.Point;

public class Fuzzy_function {
	public static Data printPixelARGB(int pixel) {
	    int alpha = (pixel >> 24) & 0xff;
	    int red = (pixel >> 16) & 0xff;
	    int green = (pixel >> 8) & 0xff;
	    int blue = (pixel) & 0xff;
	    return new Point(red,green,blue);
	  }
	public static double getRandomNumber(double a, double b) {
	    if (b < a)
	        return getRandomNumber(b, a);
	    double a_d=a,b_d=b;
	    double result=a_d +  ((1 + b - a) * Math.random());
	    if(result>b_d || result<a_d)
	    	return getRandomNumber(b, a);
	    
	    return Math.floor(result);
	}
	public static double convert(double a){
		int result=10;
		for (int i=1;i<Fuzzy_parametre.getAfter_dot();i++)
		{
			result=result*10;
		}
		return Math.floor(a * result) / result;
	}
	public static double convert_ceil(double a){
		int result=10;
		for (int i=1;i<Fuzzy_parametre.getAfter_dot();i++)
		{
			result=result*10;
		}
		return Math.ceil(a * result) / result;
	}
	public static double floorconvert(double a){
		double result;
		double x = a - Math.floor(a*100)/100;
		if(x<0.005)
		{
			result=convert(a);
		}
		else{ 
			if(x>0.005){
				result=convert_ceil(a);
			}
			else{
				result=convert(a);
			}
			
		}
		return result;
	}

}
