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
		int[] a = new int[5];
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


	public static void main (String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);

		/* set the scale from -radius to radius*/
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "/images/starfield.jpg");
		for (Planet p : planets){
			p.draw();
		}
		double t0 = 0;
		while(t0 != T){
		double[] xForces = new double[5];
		double[] yForces = new double[5];
		int i = 0;
			for (Planet p : planets){
				double fX = p.calcNetForceExertedByX (planets);
				double fY = p.calcNetForceExertedByY (planets);
				xForces[i] = fX;
				yForces[i] = fY;
				i += 1;
			}
			int j = 0;
			for (Planet p : planets){
				p.update(dt, xForces[j], yForces[j]);
				j += 1;
			}
		StdDraw.picture(0, 0, "/images/starfield.jpg");
		for (Planet p : planets){
			p.draw();
		}

		t0 += dt;
		StdDraw.show(10);
		}
	}

}
