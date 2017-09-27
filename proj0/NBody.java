import java.util.*;
public class NBody {
	public static double readRadius (String file){
		In in = new In(file);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets (String file){
		ArrayList<Planet> lst = new ArrayList<Planet>();
		In in = new In(file);
		in.readInt();
		in.readDouble();
		int[] a = new int[4];
		for(int element : a) {
			double xxp = in.readDouble();
			double yyp = in.readDouble();
			double xxv = in.readDouble();
			double yyv = in.readDouble();
			double mm = in.readDouble();
			String imageFile = in.readString();
			lst.add(new Planet(xxp, yyp, xxv, yyv, mm, imageFile));
		}
		Planet[] lst2 = lst.toArray(new Planet[lst.size()]);
		return lst2;
	}

}
