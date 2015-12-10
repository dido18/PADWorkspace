package dido.code.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.*;

public class Frequenze {
		
		final static String inDirectory = "/home/dido-ubuntu/PADworkspace/dataset";
		final static String delim=" , . ; ?!\"\'";
		//static SystemData systemData;
		
		public Frequenze(){
			Map<Object, Integer> hMap = new HashMap<Object,Integer>();
			ScanDirectory  sd = new ScanDirectory(inDirectory,".txt");
			System.out.print("Memory used: "+SystemData.askMemory());
			
			SystemData.initTime();
			
			// for each word count the occurrences in all the collection documents
			for( String fileName : sd.list())
					read(hMap, fileName);
			System.out.println("First Map times: "+SystemData.askTime());
			System.out.print("Memory used: "+SystemData.askMemory());
			
			//treeMap
			Map<Object,Integer> treeMap = new TreeMap<Object,Integer>();
			for(Integer value: hMap.values())
					add(treeMap, value);
			System.out.println(" TreeMap after times: "+SystemData.askTime());
			System.out.print("Memory used: "+SystemData.askMemory());
			
			// stampa dei risultati 
	        for (Map.Entry e : treeMap.entrySet()) System.out.println(e);
		}
		
		public void read(Map<Object,Integer> map, String fn){
			try{
				BufferedReader buffIn = new BufferedReader(
						new FileReader(inDirectory+"/"+fn));
				String line = buffIn.readLine();
				while( line != null){
					StringTokenizer tok = new StringTokenizer(line);
					while( tok.hasMoreElements()){
						add(map, tok.nextToken());
					}
					line = buffIn.readLine();
				}
		}
			catch(IOException e){
				e.printStackTrace();
				
			}
		}
		
		public void add(Map<Object,Integer> map, Object v){
			Integer o = map.get(v);
			if (o!= null) map.put(v,o+1);
			else map.put(v,1);
		}
		
		
		public static void main(String[] args){
			Frequenze f =  new Frequenze();
		}

}
