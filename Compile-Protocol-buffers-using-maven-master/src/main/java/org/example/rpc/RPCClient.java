package org.example.rpc;

import java.io.*;
import java.net.*;

import example.myapp.helloworld.grpc.*;

class RPCClient {

    public static void main(String[] args) throws Exception {
        try (Socket sock = new Socket("127.0.0.1", 3000)) {
            InputStream istream = sock.getInputStream();
            OutputStream ostream = sock.getOutputStream();

            String message0 = "5";
            String message = "2013";
            String message1 = "Alabama";
            String message2 = "Private";
            String message3 = "4-year";
            String message4 = "Fees/Tuition";
            String message5 ="2015";
            String message6 = "2014";
            Details request = Details.newBuilder().setQuery(message0).setYear(message).setState(message1).setType(message2).setLength(message3).setExpense(message4).setRange1(message5).setRange2(message6).build();

                request.writeDelimitedTo(ostream);

                ostream.flush();

            byte[] buffer = new byte[1024];
            int bytesRead = istream.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println(response);
            }
           
        }
    }










