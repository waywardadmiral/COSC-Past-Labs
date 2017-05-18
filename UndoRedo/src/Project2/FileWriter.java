package Project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


@SuppressWarnings("unused")
public class FileWriter {
	
	private String dbFile;
	ArrayList<String> lines = new ArrayList<String>();
	//LinkedList<String> line = new LinkedList<String>();
	public int size;

	private static final String DEFAULT_DB_FILE = "letter.txt";

	public FileWriter() throws FileNotFoundException {
		this(DEFAULT_DB_FILE);
	}

	public FileWriter(String fileName) throws FileNotFoundException {
		File newFile = new File(fileName);
		this.dbFile = fileName;
		if( newFile.exists()&& !newFile.isDirectory()){
			this.init();
		}else{
			
		}
		
	}
	
	public void add(String l){
		lines.add(l);
	}
    public void remove(){
    	lines.remove(size-1);
    }
	public void addLine(String newLine) {
		boolean append = true;
		lines.add(newLine);
		//PrintWriter writer = new PrintWriter(theOutputStream);
		//writer.println(newLine);
		//writer.close();
		size++;
	}
	public void printToFile(String filename){
		boolean append = false;
		FileOutputStream theOutputStream = null;
		try {
			theOutputStream = new FileOutputStream(filename, append);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintWriter writer = new PrintWriter(theOutputStream);
		StringBuffer sb = new StringBuffer("");
		for(String l : lines){
			sb.append(l);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		writer.println(sb);
		writer.close();
	}

	private void init() throws FileNotFoundException {
		Scanner infile = new Scanner(new FileInputStream(this.dbFile));

		while (infile.hasNext()) {
			String newLine = infile.nextLine();
			this.lines.add(this.lines.size(), newLine);
			size++;
		}

		infile.close();
	}
	
	public void print(){
		for(int i = 0; i < lines.size() ; i++){
		System.out.println(lines.get(i));
		}
	}

	public String remove(int newLine, String filename) {
		boolean append = false;
		String toRemove = lines.get(newLine-1);
		FileOutputStream theOutputStream = null;
		try {
			theOutputStream = new FileOutputStream(filename, append);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		lines.remove(toRemove);
		PrintWriter writer = new PrintWriter(theOutputStream);
		//Delete the line from the txt file itself
		writer.close();
		size--;
		return toRemove;
		
	}
	/**
	 * Taken from user aioobe on stackoverflow.com
	 * @param f
	 * @param toRemove
	 * @throws IOException
	 */
	public void removeNthLine(String f, int toRemove) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(f, "rw");

	    // Leave the n first lines unchanged.
	    for (int i = 0; i < toRemove; i++)
	        raf.readLine();
	    

	    // Shift remaining lines upwards.
	    
	    long writePos = raf.getFilePointer();
	    raf.readLine();
	    long readPos = raf.getFilePointer();

	    byte[] buf = new byte[1024];
	    int n;
	    while (-1 != (n = raf.read(buf))) {
	        raf.seek(writePos);
	        raf.write(buf, 0, n);
	        readPos += n;
	        writePos += n;
	        raf.seek(readPos);
	    }

	    raf.setLength(writePos);
	    raf.close();
	    lines.equals(raf);
	    size--;
	}

	public String get(int i) {
		return lines.get(i);
	}
	
}
