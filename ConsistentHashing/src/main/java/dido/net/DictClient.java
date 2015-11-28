package dido.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketAddress;

public class DictClient {

	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;
	

	static void define(String word, Writer writer, BufferedReader reader) throws IOException, UnsupportedEncodingException{
		writer.write("DEFINE eng-lat " + word + "\r\n");
		System.out.print("It is sending DEFINE eng-lat " + word +"...");
		writer.flush();
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			if (line.startsWith("250 ")) { // OK
			return;
			} else if (line.startsWith("552 ")) { // no match
			System.out.println("No definition found for " + word);
			return;
		}
		else if (line.matches("\\d\\d\\d .*")) continue;
		else if (line.trim().equals(".")) continue;
		else System.out.println(line);
		}		
		
	}
	public static void main(String[] args) {
	
	if(args.length< 2){
		System.out.println("usage: \n \t"+args[0]+" word [word]");
		return ;
	}
		Socket socket = null;
		try{
			socket = new Socket(SERVER,PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out,"UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in, "UTF-8"));
			
			for (String word : args) {
				define(word, writer, reader);
				}
			writer.write("quit\r\n");
			writer.flush();
		}catch(IOException ex) {
			System.err.println(ex);
		} finally { // dispose
			if (socket != null) {
			try {
				socket.close();
			} catch (IOException ex) {
			// ignore
		}
			}
		}
	}
	
}
