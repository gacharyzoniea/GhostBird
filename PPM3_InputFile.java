//input file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; //imports

public class PPM3_InputFile {
	int width, height, maxColor; // names are self-explanatory
	int RGB = 3;// the "R" "G' "B" values
	String fileName = ""; // stores file name later
	Scanner myScan = null; // used throughout program to read file
	File myFile = null;

	public PPM3_InputFile(String name) throws FileNotFoundException {

		myFile = new File(name);
		myScan = new Scanner(myFile);
		myScan.next(); // going past the irrelevant lines to assign important ones
		myScan.next();
		fileName = myScan.nextLine();
		width = myScan.nextInt();
		height = myScan.nextInt();
		maxColor = myScan.nextInt();
	}

	public int[] getNextPixel() {
		int[] curPixel = new int[RGB]; // array for storing RGB
		for (int i = 0; i < RGB; i++) {
			curPixel[i] = myScan.nextInt();
		}
		return curPixel;
	}// getNextPixel

//Getters
	public Integer getWidth() {
		return this.width;
	}

	public Integer getHeight() {
		return this.height;
	}

	public Integer getMaxColor() {
		return this.maxColor;
	}

	public String getFileName() {
		return fileName;
	}

	// determine if any two PPM3 files are equivalent
	public boolean isEqual(PPM3_InputFile other) {
		boolean isEqual = false; // our determiner
		if ((width == other.getWidth()) && (height == other.getHeight()) && (maxColor == other.getMaxColor())) {
			isEqual = true;
		}
		return isEqual;
	}// isEqual
	
	//close
	void close() {
		myScan.close(); // close the scan
	}

} // PPM3_InputFile
