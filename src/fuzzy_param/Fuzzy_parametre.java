package fuzzy_param;

public class Fuzzy_parametre {
	private static int num_cluster=5;
	private static double fuzziness=1.25;
	private static int draw_surface_height=500;
	private static int draw_surface_width=500;
	private static double epsilon=0.009;
	
	
	public static double getEpsilon() {
		return epsilon;
	}
	public static void setEpsilon(double epsilon) {
		Fuzzy_parametre.epsilon = epsilon;
	}
	public static int getDraw_surface_height() {
		return draw_surface_height;
	}
	public static void setDraw_surface_height(int draw_surface_height) {
		Fuzzy_parametre.draw_surface_height = draw_surface_height;
	}
	public static int getDraw_surface_width() {
		return draw_surface_width;
	}
	public static void setDraw_surface_width(int draw_surface_width) {
		Fuzzy_parametre.draw_surface_width = draw_surface_width;
	}
	
	public static double getFuzziness() {
		return fuzziness;
	}
	public static void setFuzziness(double fuzziness) {
		Fuzzy_parametre.fuzziness = fuzziness;
	}
	public static int getNum_cluster() {
		return num_cluster;
	}
	public static void setNum_cluster(int num_cluster) {
		Fuzzy_parametre.num_cluster = num_cluster;
	}
	
	
}
