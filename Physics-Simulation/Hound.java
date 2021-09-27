public class Hound extends Projectile {

	public Hound() {
		yDisplacement = 400;
	}

	public void setXHound() {
		xDisplacement += xdisplacement();
	}


	public void setYHound() {
		yDisplacement += ydisplacement();

	}
	public double xdisplacement () {
		return 11.3;
	}

	public double ydisplacement() {
		return -9.81;
	}

	public void fuelburn() {

		yDisplacement += 11;
	}


}
