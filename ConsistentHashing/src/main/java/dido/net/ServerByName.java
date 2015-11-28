package dido.net;
import java.net.*;
import java.util.Enumeration;

public class ServerByName {

	public static void printNetworkInterface(){
		Enumeration<NetworkInterface> enumInterface;
		try {
			enumInterface = NetworkInterface.getNetworkInterfaces();
			while(enumInterface.hasMoreElements()){
				NetworkInterface ni = enumInterface.nextElement();
				System.out.print(ni.getDisplayName()+": \n");
				Enumeration nia = ni.getInetAddresses();
				while (nia.hasMoreElements()) {
					System.out.println("\t"+nia.nextElement());
					}
			
			}
		} catch (SocketException e) {
			System.out.println("Error get Network Interfaces");
		}
	}
	
	public static void printInetAddress( String name){
		try{
			InetAddress address = InetAddress.getByName(name);
			InetAddress me = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.println(me);
			NetworkInterface ni = NetworkInterface.getByName("eth0");
			if (ni == null) {
				System.out.println("No such interface: eth0");
			}
		}catch (UnknownHostException ex){
			System.out.print("Could not resolve the name"+name);
		}catch (SocketException ex) {
			System.out.println("Could not list sockets.");
		}
		
	}
	
	public static void main( String[] args){
		
		printNetworkInterface();
		printInetAddress("neridavide.com");
		
		
		
	}
}
