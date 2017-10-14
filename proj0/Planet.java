public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet(double xP, double yP, double xV,
				  double yV, double m, 	String img) {
			xxPos = xP;
			yyPos = yP;
			xxVel = xV;
			yyVel = yV;
			mass = m;
			imgFileName = img;
	}

	public Planet(Planet p){
			xxPos = p.xxPos;
			yyPos = p.yyPos;
			xxVel = p.xxVel;
			yyVel = p.yyVel;
			mass = p.mass;
			imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
			double distance = Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + 
			Math.pow(this.yyPos - p.yyPos, 2));
			return distance;
	}

	public double calcForceExertedBy(Planet p){
		double gravitationalG = 6.67 * Math.pow(10,-11);
		double distance = this.calcDistance(p);
		double force = gravitationalG * this.mass * p.mass / (distance * distance);
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double xForce = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return xForce;
	}

	public double calcForceExertedByY(Planet p){
		double yForce = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return yForce;
	}

	public double calcNetForceExertedByX (Planet[] parray){
		double netForceX = 0;
		for (int i = 0; i < parray.length; i++){
		Planet p = parray[i];
			if (! this.equals(p)){
				netForceX += this.calcForceExertedByX(p);
			}
		}
		return netForceX;
	}

	public double calcNetForceExertedByY (Planet[] parray){
		double netForceY = 0;
		for (int i = 0; i < parray.length; i++){
		Planet p = parray[i];
			if (! this.equals(p)){
				netForceY += this.calcForceExertedByY(p);
			}
		}
		return netForceY;
	}

	public void update (double t, double fx, double fy){
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		this.xxVel += ax * t;
		this.yyVel += ay * t;
		this.xxPos += this.xxVel * t;
		this.yyPos += this.yyVel * t;
	}

	public void draw (){
		StdDraw.picture(this.xxPos,this.yyPos,"/images/" + this.imgFileName);
	}
}



