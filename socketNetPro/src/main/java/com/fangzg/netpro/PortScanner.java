package com.fangzg.netpro;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class PortScanner {
	public static void main(String[] args) {
		String host="localhost";
		PortScanner ps = new PortScanner();
//		ps.scan(host);
//		ps.scan1();
		ps.scan2();
	}
	
	public void scan(String host){
		Socket socket = null;
		for(int i=0;i<1024;i++){
			try {
				socket = new Socket(host,i);
				System.out.println("There is a serveron port "+i);
			} catch (IOException e) {
				System.out.println("Conn't connect to port "+i);
			}finally{
				try{
					if(socket != null){
						socket.close();
						System.out.println("socket has been closed");
					}else{
						System.out.println("socket is null");
					}
				}catch(Exception e){}
			}
		}
	}
	
	public void scan1(){
		Socket socket = new Socket();
		SocketAddress sa = new InetSocketAddress("localhost", 8000);
		try {
			socket.connect(sa, 60000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void scan2(){
		try {
			InetAddress ia = InetAddress.getLocalHost();
			InetAddress ia2 = InetAddress.getByName("119.75.218.71");
			System.out.println(ia);
			System.out.println(ia2);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Socket socket = new Socket();
		SocketAddress sa = new InetSocketAddress("localhost", 8000);
		try {
			socket.connect(sa, 60000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
