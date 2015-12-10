package dido.code.util;
import java.io.*;

public class ScanDirectory {
	 String[] list;
	 String ends;
	 
		 
	 public ScanDirectory(String dirname, String ends){
		 this.ends=ends.toLowerCase();
		 this.list = (new File(dirname)).list();
	 }
	 
	 // lista dei nomi dei file
	 public String[] list() {
		 return list;
	}
	// realizzazione del FilenameFilter
	public boolean accept(File dir, String s){
		return s.toLowerCase().endsWith(ends);
	}	
	
	public static void main(String[] args){
	 ScanDirectory sd = new ScanDirectory("/home/dido-ubuntu/PADworkspace/dataset", ".txt");
	 for(String name : sd.list()) System.out.println(name);
	}
}
