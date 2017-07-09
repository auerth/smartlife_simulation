import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	// GLOBAL ATTRIBUTES
	private Server server;
	private Socket socket;
	private Control c;

	public ServerThread(Server server, Socket socket, Control c) {
		this.server = server; // Safe server
		this.socket = socket; // Safe Client connection
		this.c = c;
		this.start(); // Start thread
	}
	@Override
	public void run() {
		try {
			Scanner input = new Scanner(socket.getInputStream()); // Scanner to
																	// read
																	// client
																	// input
			String inMsg;
			int i = 0;
			int room = 0;
			int element = 0;
			boolean on = false;
			String value = "";// Message from client
			while (input.hasNextLine()) { // While client has next line

				inMsg = input.nextLine(); // Get next data line
				System.out.print(inMsg + " "); // Line output (LOG)
				switch (i) {
				case 0:
					room = Integer.parseInt(inMsg); // Parse room id
					break;
				case 1:
					element = Integer.parseInt(inMsg); // Parse element id
					break;
				case 2:
					on = Boolean.parseBoolean(inMsg); // Parse light value
					break;
				case 3:
					value = inMsg; // Parse temperature value
					break;

				}

				i++;
				if (i > 3) {
					break;
				}
			}

			PrintWriter outMsg = new PrintWriter(socket.getOutputStream()); // Answer
																			// to
																			// client
			c.updateElement(room, element, on, value);
			outMsg.println("1"); // Write done

			outMsg.flush(); // Send message

			outMsg.close(); // Close connection

			// server.sendMsgToAll(inMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
