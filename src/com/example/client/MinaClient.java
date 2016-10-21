package com.example.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MinaClient {
	public static void main(String[] args) {
		MinaClient minaClient = new MinaClient();
		minaClient.start();

	}

	public void start() {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9898);
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String str=null;
			startServerReplyListener(socket);
			int num=0;
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
				bufferedWriter.write(str);
				if(num%2==0){
					bufferedWriter.write("\n");
				}
				num++;
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {

					bufferedReader.close();
				}

				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void startServerReplyListener(Socket socket){
		new Thread(new Runnable(){

			@Override
			public void run() {
				BufferedReader bufferedReader=null;
				try {
					bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String str=null;
					while((str=bufferedReader.readLine())!=null){
						System.out.println(str);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(bufferedReader!=null){
						try {
							bufferedReader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		}).start();
		
	}

}
