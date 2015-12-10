package dido.net;

import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

public class NameServer {
	
	
	private HashMap<String, InetAddress> nameToIp ;
	
	public NameServer(){
		
	}
	
	public void addName(String nameHost, InetAddress ip){
		nameToIp.put(nameHost, ip);
		
	}
	
	public InetAddress lookup(String nameHost){
		InetAddress iphost = null;
		if(nameToIp.containsKey(nameHost))
			iphost =nameToIp.get(nameHost);
		return iphost;
		
	}
	
	public void putOnline() throws SocketException{
		/*InetSocketAddress inetsocket ;
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)){
        	Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        	for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                 
               
            }
        }*/
		try{
			ServerSocket ss = create(12345);
			System.out.println("Porta in ascolto "+ss.getLocalPort());
			ss.accept();
		}catch(IOException ex){
			System.err.println("No avalable port");
		}
		
	}
	
	public ServerSocket create( int portFeed) throws IOException{
		
		for(int p = portFeed; p< 65535; p++){
			System.out.println("searching port");
			try{
				return new ServerSocket(p);
			}catch(IOException ex){
				continue;
			}
			
		}
		
		//if the program get here, no port was found
		throw new IOException("no free port found");
	}
	public static void main(String args[]) throws SocketException{
	 NameServer ns = new NameServer();
	 ns.putOnline();
	}


}
