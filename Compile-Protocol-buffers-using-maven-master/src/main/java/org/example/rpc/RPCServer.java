package org.example.rpc;

import java.io.*;
import java.net.*;

import org.bson.Document;
import org.example.mongodb.DAOQuery1;
import org.example.mongodb.DAOQuery2;
import org.example.mongodb.DAOQuery3;
import org.example.mongodb.DAOQuery4;
import org.example.mongodb.DAOQuery5;
import org.example.mongodb.DetailsDAO;
import org.example.mongodb.artistDAO;

import example.myapp.helloworld.grpc.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// write to store the data first and refer the question booklet
class RPCServer {
	
    private ServerSocket serverSocket;
    private Socket connection;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        // DetailsDAO dao = new DetailsDAO();
        //  dao.insertAll();
        serverSocket = new ServerSocket(port); 
        







        connection=serverSocket.accept();
        OutputStream outputStream = connection.getOutputStream();
        System.out.println("Server started.");
        
        
        Details requestDeserial = Details.parseDelimitedFrom(connection.getInputStream());
        String query =requestDeserial.getQuery();
        String Year = requestDeserial.getYear();
        String State = requestDeserial.getState();
        String Type = requestDeserial.getType();
        String Length = requestDeserial.getLength();
        String Expense = requestDeserial.getExpense();
        String[] Range = requestDeserial.getRange();
        String Value = requestDeserial.getValue();
        List<Document> k= new ArrayList<>();
        List<String[]> k2= new ArrayList<>();
        List<String[]> k3= new ArrayList<>();

        if(query.equals("1")){

        DAOQuery1 query1 = new DAOQuery1();
    
        k =query1.getCosts(Year, State, Type, Length, Expense);
        
        
        }

        else if(query.equals("2")){


            DAOQuery2 query2 = new DAOQuery2();
            k2 = query2.getExpensivestates(Year, Type, Length);




        }
        else if(query.equals("3")){

            DAOQuery3 query3 = new DAOQuery3();
            k3=query3.getEconomicstates(Year, Type, Length);
        }

        else if(query.equals("4")){

            DAOQuery4 query4 = new DAOQuery4();
            k3=query4.getgrowthstates(Range, Type, Length);
        }

        else if(query.equals("5")){

            DAOQuery5 query5 = new DAOQuery5();
            k3=query5.getAveragesstates(Year, Type, Length);
        }
        else{
            
        }


         

        for(int i=0;i<k2.size();i++){
            String response = k2.get(i)[0]+" "+k2.get(i)[1] ;
            
            System.out.println(response);


        }

         
        
        

    
        
            

            

           
            
            


           
            
            
            // do storage to the NoSQL database
            // call data access object to perform the task;
    
            
    
            
            

        }
    

    public void stop() throws IOException {
        in.close();
        out.close();
        connection.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        RPCServer server=new RPCServer();
        server.start(3000);
    }
}


//    public static void main(String[] args) throws Exception {
//        ServerSocket sersock = new ServerSocket(3000);
//        System.out.println("Server ready");
//        Socket sock = sersock.accept();
//       // BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
//        OutputStream ostream = sock.getOutputStream();
//      // PrintWriter pwrite = new PrintWriter(ostream, true);
//       
//        InputStream istream = sock.getInputStream();
//        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
//        String read = receiveRead.readLine();
//        System.out.println("client's request :" + read);
//        ostream.write(read.getBytes());
//        ostream.flush();
//        
////        String receiveMessage, sendMessage, fun;
////        int a, b, c;
////        while (true) {
////            fun = receiveRead.readLine();
////            if (fun != null) {
////                System.out.println("Operation : " + fun);
////            }
////            a = Integer.parseInt(receiveRead.readLine());
////            System.out.println("Parameter 1 : " + a);
////            b = Integer.parseInt(receiveRead.readLine());
////            if (fun.compareTo("add") == 0) {
////                c = a + b;
////                System.out.println("Addition = " + c);
////                pwrite.println("Addition = " + c);
////            }
////            if (fun.compareTo("sub") == 0) {
////                c = a - b;
////                System.out.println("Substraction = " + c);
////                pwrite.println("Substraction = " + c);
////            }
////            if (fun.compareTo("mul") == 0) {
////                c = a * b;
////                System.out.println("Multiplication = " + c);
////                pwrite.println("Multiplication = " + c);
////            }
////            if (fun.compareTo("div") == 0) {
////                c = a / b;
////                System.out.println("Division = " + c);
////                pwrite.println("Division = " + c);
////            }
////            System.out.flush();
////        }
//    }

//}