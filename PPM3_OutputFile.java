import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PPM3_OutputFile {
	// attributes
	private File myFile; //file
	private PrintWriter myWriter; //writes to file
	private int pixelsWritten; //tracks pixels written
	private int width, height, maxColor; //self-explanatory
	private String fileName; //stores filename

	public PPM3_OutputFile(String fName, int w, int h, int mc) throws FileNotFoundException {
		// instantiation
		myFile = new File(fName); //new file
		fileName = fName; //file name
		myWriter = new PrintWriter(myFile);

		// define the attributes
		width = w;
		height = h;
		maxColor = mc;

		// write header for new file
		myWriter.println("P3");
		myWriter.println("# Created by Zachary Goniean ~ Comp 141");
		myWriter.printf("%d %d\n", width, height);
		myWriter.println(maxColor);

		pixelsWritten = 0; // starting point
	}
	//write the pixels
	public void writeNextPixel(int[] pixel) {
		// prints RGB values
		myWriter.printf("%4d%4d%4d", pixel[0], pixel[1], pixel[2]);
		pixelsWritten++;
		if (pixelsWritten % 5 == 0)
			myWriter.println();
	}
	// getters

	// gets file name
	public String getFileName() {
		return fileName;
	}

	// gets height
	public int getHeight() {
		return height;
	}

	// gets width
	public int getWidth() {
		return width;
	}

	// gets maxColor
	public int getMaxColor() {
		return maxColor;
	}

	// closes and flushes writer
	public void close() {
		myWriter.flush();
		myWriter.close();
	}
}
