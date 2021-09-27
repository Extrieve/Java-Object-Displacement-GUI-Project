public class Projectile {

	protected double xDisplacement;
	protected double yDisplacement;
	protected double initialAngle;
	protected double initialVelocity;
	protected double gravitationConstant = 9.81;
	protected double initialheight;


	public  double randomFrom (double low, double high) {
		double randNum = 0;
		randNum = (Math.random()*(high-low)+low);

		return randNum;
	}

	public void setXdisplacement(double newX) {
		xDisplacement = newX;
	}

	public void setYdisplacement(double newY) {
		yDisplacement = newY;
	}

	public double getXdisplacement () {
		return xDisplacement;
	}

	public double getYdisplacement () {
		return yDisplacement;
	}

}
