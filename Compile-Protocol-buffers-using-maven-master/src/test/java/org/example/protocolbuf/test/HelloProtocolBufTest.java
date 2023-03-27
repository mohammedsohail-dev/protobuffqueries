package org.example.protocolbuf.test;



import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


import example.myapp.helloworld.grpc.*;

public class HelloProtocolBufTest {
	
	private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
	
    @Test
    public void testTCPProtocoBuf() throws UnknownHostException, IOException {
    	 // Socket sock = new Socket("127.0.0.1", 3000);
    	 startConnection("127.0.0.1", 3000);
         HelloRequest request = HelloRequest.newBuilder()
        		 .setFirstname("artist1").build();
         
        request.writeDelimitedTo(clientSocket.getOutputStream());
          
         
        //  assertEquals("artist1", firstName);
    }
   
    @Test
    public void testRequestPrototocoBuf() {
    	HelloRequest.Builder request = HelloRequest.newBuilder();
        request.setFirstname("artist1");
        
        FileOutputStream output;
        try {
			output  = new FileOutputStream("request.data");
			request.build().writeTo(output);
			//request.build().toByteString().writeTo(output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        HelloRequest requestDeserial = null;
        try {
        	requestDeserial = 
					HelloRequest.parseFrom(new FileInputStream("request.data"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        assertEquals("artist1", requestDeserial.getFirstname());
    }


    
   
}