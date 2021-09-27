import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

	public class Manager {
		Hound Hound = new Hound();
		Hare Hare = new Hare ();
		String winner;
		int ground [] = new int[20];
		final double maxheight = 2500;
		final double maxwidth = 2000;
		double time = 0;
		int k = 0;
		File file = new File("ground.txt");
		double distance;

	public  int randomFrom (int low, int high) {

			int randNum = 0;

			randNum = (int) (Math.random()*(high-low)+low);

			return randNum;

		}

		public int loadG() {
			System.out.println("K is 0");
			this.k = k;
			k = 0;
			return k;
		}

		public int randomG() {
			System.out.println("K is 1");
			this.k = k;
			k = 1;

			return k;
		}


	public boolean hareStop() {

			return Hare.getXdisplacement()< maxwidth && Hare.getYdisplacement() < ground[(int) Hare.getXdisplacement()/100];

	}

	public boolean houndStop() {

		return Hound.getXdisplacement()< maxwidth && Hound.getYdisplacement() < ground[(int) Hound.getXdisplacement()/100];

	}

	public void determineMethod() {
		// set up the grounds
		if (k==1) {
		for (int i = 0; i < ground.length; i++) {
			ground [i]= randomFrom(10, 325);
			System.out.println(ground[i]);
			}
		}else {
			 parseFile();
			//readFile
		}
	}

	public void exitHell() {
		System.exit(0);
	}

	private void parseFile() {

		try {
			int p = 0;
					FileReader filereader = new FileReader("ground.txt");
					BufferedReader bufferedreader = new BufferedReader (filereader);
					String Line = bufferedreader.readLine();
					while (Line!=null) {
						ground[p]= Integer.valueOf(Line);
						Line = bufferedreader.readLine();
						p++;
					}

					bufferedreader.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double calculateDistance() {

		distance = Math.abs(Hound.getXdisplacement()-Hare.getXdisplacement());
		//tell who is winner
		if (distance < 7) {
			winner = ("Hound");


		}
		if (distance >= 7) {
			winner = ("Hare");

		}

		return distance;

	}

	public void saveScore() {

		try {
		FileWriter fileWriter = new FileWriter("ground.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		// The program shall write the computed results to a file.
		for (int i = 0; i < 20; i++) {
		bufferedWriter.write(""+ ground[i]);
		bufferedWriter.newLine();
		}

		bufferedWriter.close();
		System.out.println("Write Completed");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Writing Error");
		}

	}
}
