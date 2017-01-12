package com.fangzg.netpro;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNew {
	private int port=8000;
	private ServerSocket serverSocket;
	
	public ServerSocketNew () throws IOException{
		serverSocket = new ServerSocket(port,3);
		System.out.println("服务已启动");
	}
	
	public void service(){
		while(true){
			Socket socket = null;
			try{
				socket = serverSocket.accept();
				System.out.println("New connection accepted"+socket.getInetAddress()+":"+socket.getPort());
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					if(socket !=null)socket.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		ServerSocketNew server  = new ServerSocketNew();
		Thread.sleep(6000);
		server.service();
	}
}
