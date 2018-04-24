/* Devanshi Janani 
   CS 356 
   Section 102*/

import java.net.Socket;
import java.lang.*;
import java.io.*;
import java.net.*;

/*Sources for creating an InputStream to read date from routers: http://www.discoversdk.com/blog/java-socket-programming  , http://www.javaworld.com/article/2077322/core-java/core-java-sockets-programming-in-java-a-tutorial.html */

public class phase2router0{
	public static void main(String args[]) throws IOException
	{
    //Print initial cost table.
		int clientRouterID = 0;
		int InitialCostTable[] = {0, 1, 3, 7};
    System.out.println("Initial Router0 Table: "); 
    printTable(clientRouterID, InitialCostTable);

    //Read data from router 1.
		Socket s1 = new Socket("afsaccess1.njit.edu", 57634);
    InputStream input1 = s1.getInputStream();
    BufferedReader br1 = new BufferedReader(new InputStreamReader(input1));
    String line1;
    System.out.println("Router 1 updated.");
    while((line1 = br1.readLine()) != null){
      System.out.println(line1);
    }
    br1.close();
    s1.close();
    
    //Read data from router 2.
    Socket s2 = new Socket("afsaccess2.njit.edu", 28754);
    InputStream input2 = s2.getInputStream();
    BufferedReader br2 = new BufferedReader(new InputStreamReader(input2));
    String line2;
    System.out.println("Router 2 updated.");
    while((line2 = br2.readLine()) != null){
      System.out.println(line2);
    }
    br2.close();
    s2.close();
    
    //Read data from router 3.
    Socket s3 = new Socket("afsaccess3.njit.edu", 13764);
    InputStream input3 = s3.getInputStream();
    BufferedReader br3 = new BufferedReader(new InputStreamReader(input3));
    String line3;
    System.out.println("Router 3 updated.");
    while((line3 = br3.readLine()) != null){
      System.out.println(line3);
    }
    br3.close();
    s3.close();
  }  
/* Source for printTable method: http://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java */
//print table.
public static void printTable(int routerType, int[] table){
	String output = String.format("Cost Table for Router%s (Client) \n ", String.valueOf(routerType));
	output += "Destination Cost\n";
	for(int i =0; i<4; i++){
		output += String.format("%8d%8s\n", i, table[i]==-1?"n/a":String.valueOf((3-routerType+i)%4), String.valueOf(table[i]));
	}
	System.out.print(output);
}
}
