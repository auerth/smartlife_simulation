
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server {
	// GLOBAL ATTRIBUTES

	private Hashtable<Socket, PrintWriter> output = new Hashtable<Socket, PrintWriter>(); // List
																							// of
																							// all
																							// connections
	private ServerSocket ss; // Server socket
	private Socket s; // Socket
	private int port;
	private Control c;
	public void closeServer() throws IOException {
		ss.close();
	}
	
	public void createServer() {
		try {
			ss = new ServerSocket(port); // Start server
			System.out.println("Server started...");
			final Server server = this;
			new Thread(new Runnable() {
				public void run() {
					// Do whatever

					while (true) { // Wait for connection
						try {

							s = ss.accept(); // New connection
							DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
							Calendar cal = Calendar.getInstance();
							String log = dateFormat.format(cal.getTime()) + " : Connection from " + s;
							System.out.println(log); // Log
							PrintWriter outMsg = new PrintWriter(s.getOutputStream()); // Get
																						// stream
							output.put(s, outMsg); // Safe stream
							new ServerThread(server, s,c);
						} catch (Exception e) {
							// New thread for connection
						}
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Server(int port,Control c) {
		this.port = port;
		this.c = c;
	}

	public void sendMsgToAll(String msg) {
		synchronized (output) {

			Enumeration keys = output.keys(); // List of all connections

			while (keys.hasMoreElements()) { // While their is an unused
												// connection
				Socket ss = (Socket) keys.nextElement(); // New client
															// connection
				PrintWriter outMsg = output.get(ss); // Create writer
				outMsg.println(msg + " | " + ss); // Write message
				outMsg.flush(); // Send message
			}
		}
	}

	public void connectionClose(Socket socket) {
		try {
			output.remove(socket); // Remove client connection
			socket.close(); // Close connection
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
