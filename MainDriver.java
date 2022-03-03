//Zachary Goniea ~ COMP 141 ~ I must remove the blue bird
import java.io.FileNotFoundException; //imports

public class MainDriver {

	public static void main(String[] args) throws FileNotFoundException {
		PPM3_InputFile inFile; //files
		PPM3_InputFile inFile2;
		PPM3_InputFile inFile3;
		PPM3_OutputFile outFile; //output file
		int width, height, maxColor; //self-explanatory
		long numPixels;
		long i; //used in for loop
		int[] testPixel = new int[3]; //test pixels
		int[] testPixel2 = new int[3];
		int[] testPixel3 = new int[3];
		int[] newPixel = new int[3]; //output pixel
		
		System.out.println("Zachary Goniea ~ COMP 141 ~ remove da bluebirds"); //intro
		
		inFile = new PPM3_InputFile("imageA.ppm"); // creates new InputFiles
		inFile2 = new PPM3_InputFile("imageB.ppm");
		inFile3 = new PPM3_InputFile("imageC.ppm");
		
		width = inFile.getWidth(); //establish H, W, and MC
		height = inFile.getHeight();
		maxColor = inFile.getMaxColor();

		outFile = new PPM3_OutputFile("newImage.ppm", width, height, maxColor); //instantiate new output file

		numPixels = width * height; //total pixels

		//test each pixel if they are equal, if not they are ignored
		if ((inFile.isEqual(inFile2)) && inFile.isEqual(inFile3)) {
			for (i = 0; i < numPixels; i++) {
				testPixel = inFile.getNextPixel();
				testPixel2 = inFile2.getNextPixel();
				testPixel3 = inFile3.getNextPixel();
					if (Math.abs(testPixel[0]-testPixel2[0]) < Math.abs(testPixel2[0]-testPixel3[0])) {
						newPixel[0] = testPixel[0]; 
					}
					else if (Math.abs(testPixel[0]-testPixel2[0]) > Math.abs(testPixel2[0]-testPixel3[0])) {
						newPixel[0] = testPixel3[0];
					}
					if (Math.abs(testPixel[1]-testPixel2[1]) < Math.abs(testPixel2[1]-testPixel3[1])) {
						newPixel[1] = testPixel[1];
					}
					else if (Math.abs(testPixel[1]-testPixel2[1]) > Math.abs(testPixel2[1]-testPixel3[1])) {
						newPixel[1] = testPixel3[1];
					}
					if (Math.abs(testPixel[2]-testPixel2[2]) < Math.abs(testPixel2[2]-testPixel3[2])) {
						newPixel[2] = testPixel[2];
					}
					else if (Math.abs(testPixel[2]-testPixel2[2]) > Math.abs(testPixel2[2]-testPixel3[2])) {
						newPixel[2] = testPixel3[2];
					}
					outFile.writeNextPixel(newPixel); //write to file
				}//for loop		
		}//if it is equal
		
		else {
			System.out.println("The files don't have either the same height, width, or maximum color value, or some combination");
		} //else
		
		// finish
		inFile.close();//close
		outFile.close();
		System.out.println("\n\n");
		System.out.println("Termination. Cya later!"); //termination
	}
} //main
