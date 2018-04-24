# Network-Programming

This file explains how to compile and run phase2router0.java, phase2router1.java, phase2router2.java, and
phase2router3.java on an NJIT server.

phase2router0.java is the client side and all the other corresponding files are servers.

To compile the server programs, please type the following commands in afsaccess1.njit.edu: 
javac phase2router1.java 
javac phase2router2.java 
javac phase2router3.java

To run the server programs, please type in the command: 
java phase2router1 (in afsaccess1.njit.edu)
java phase2router2 (in afsaccess2.njit.edu)
java phase2router3 (in afsaccess3.njit.edu)

When the server programs are executed, it will print the initial routing tables for each server,
and also print "Waiting for client...".
This is a queue for the host to switch to another afsaccess account and compile and execute the client program.
To compile the client program, please type in the command: javac phase2router0.java (in afsaccess4.njit.edu)
To run the client program, please type in the command: java phase2router0 (in afsaccess4.njit.edu)



