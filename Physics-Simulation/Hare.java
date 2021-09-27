public class Hare extends Projectile{

	double time = 0;
	public Hare () {
		initialAngle = randomFrom(0,91);
		initialAngle = initialAngle * Math.PI / 180;
		initialVelocity = randomFrom(70,121);
		yDisplacement = randomFrom(50,501);
		initialheight = yDisplacement;
		}

	public void moveHare () {
		xDisplacement = initialVelocity*time*Math.cos(initialAngle);
		yDisplacement = initialVelocity*time*Math.sin(initialAngle) - ( .5 * Math.pow(time, 2) * gravitationConstant) + initialheight ;
		time = time + .5;
	}
}
