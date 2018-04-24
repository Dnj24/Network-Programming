/* Devanshi Janani 
   CS 356 
   Section 102*/

import java.io.*;
import java.net.*;

public class phase2router2 {


  class Router {
  
    int src, dest, cost;

    Router(){
       src = 0;
       dest = 0;
       cost = 0;
    }
 }
   int routers, interfaces; 
   Router r[];
   
   phase2router2(int routerval, int interfaceval){
   
     routers = routerval;
     interfaces = interfaceval;
     
     r = new Router[interfaceval];
     
     for(int i = 0; i < interfaceval; ++i){
         r[i] = new Router();
     }
 }
   /* Source for BellmanFord algorithm: http://stackoverflow.com/questions/15681885/bellman-ford-algorithm-in-java */
   void BellmanFord(phase2router2 graph, int src) throws Exception{
       
         int routerval = graph.routers;
         int interfaceval = graph.interfaces;
         int table[] = new int[routerval];
         for(int i = 0; i < routerval; ++i){
               table[i] = Integer.MAX_VALUE;
         }
         table[src] = 0;
         for(int i = 1; i < routers; ++i){
           for(int j = 0; j < interfaces; ++j){
               int x = graph.r[j].src;
               int y = graph.r[j].dest;
               int cost = graph.r[j].cost;
               if(table[x] != Integer.MAX_VALUE && table[x]+cost < table[y]) {
               table[y] = table[x] + cost;
           }
         }
       }
        print(table, routers);
   }
    /* Opens a socket on server-side to listen for clients on a specified port number. 
       Source: http://www.discoversdk.com/blog/java-socket-programming*/        
   void print(int table[], int routers) throws IOException {
     
        ServerSocket srvr = null;
        Socket s = null;
        PrintStream printOutput = null;
     try{
         srvr = new ServerSocket(28754);
         s = srvr.accept();
         System.out.println("Server has connected to "+ s.getRemoteSocketAddress());
         System.out.println("Sending routing update to R0..\n");
         OutputStream clientOutput = s.getOutputStream();
         printOutput = new PrintStream(clientOutput);
         printOutput.println("Destination\tCost");
         for(int i = 0; i < routers; ++i){
             printOutput.println((i + "\t\t" + table[i]));
         }
         } catch(Exception e){
           System.out.println("Server failed to work\n");
           System.out.println(e.getMessage());
         } finally {
             printOutput.close();
             s.close();
             srvr.close();
         }
         System.out.println("Routing update successful! \n");
   }
   
   public static void main(String[] args) throws IOException, Exception {
         //Print initial router1 table.
         int clientRouterID = 2;
         int InitialCostTable[] = {2, 3, 1, 2};
         System.out.println("Initial Router2 Table: "); 
         printTable(clientRouterID, InitialCostTable);
          System.out.println("Waiting on client...\n");
   
         //use Bellman Ford algorithm to calculate shortest path.
         int routerval = 4;
         int interfaceval = 5;
         phase2router2 table = new phase2router2(routerval, interfaceval);
         table.r[0].src = 0;
         table.r[0].dest = 1;
         table.r[0].cost = 1;
         table.r[1].src = 0;
         table.r[1].dest = 2;
         table.r[1].cost = 3;
         table.r[2].src = 1;
         table.r[2].dest = 2;
         table.r[2].cost = 1;
         table.r[3].src = 0;
         table.r[3].dest = 3;
         table.r[3].cost = 7;
         table.r[4].src = 2;
         table.r[4].dest = 3;
         table.r[4].cost = 2;
         table.BellmanFord(table, 0);
    }
/* Source for printTable method: http://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java */      
public static void printTable(int routerType, int[] table){
	String output = String.format("Cost Table for Router%s (Server) \n ", String.valueOf(routerType));
	output += "Destination Cost\n";
	for(int i =0; i<4; i++){
		output += String.format("%8d%8s\n", i, table[i]==-1?"n/a":String.valueOf((3-routerType+i)%4), String.valueOf(table[i]));
	}
	System.out.print(output);
}
}
 
 
     
    