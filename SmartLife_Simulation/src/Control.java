import java.io.IOException;

public class Control {
	
	private GUI gui;					
	private Server server;				
	private int port = 1001;

	/**
	 * Constructor for Control object
	 *
	 * @param  gui 	existing object of gui
	 */
	public Control(GUI gui) {
		this.gui = gui;					//Safe gui to access gui
	}
	/**
	 * Constructor for Control object
	 *
	 * @param  gui 	existing object of gui
	 * @param  port port for server as int
	 */
	public Control(GUI gui, int port) {	
		this.gui = gui;
		this.port = port;				//Safe port for server

	}
	/**
	 * Start server 
	 * 
	 * create object of server and start server	 *
	 */
	public void startServer() {
		server = new Server(port, this); //New server object
		server.createServer();			 //Start server
	}
	/**
	 * Stop server
	 *
	 * close server with error output
	 */
	public void stopServer() {
		try {
			server.closeServer();		//Stop server

		} catch (Exception e) {
			System.out.println(e.toString());	//Error Message output
		}
	}
	/**
	 * Constructor for Control object
	 *
	 *
	 * @param  room 	id of room as int
	 * @param  element id of element as int
	 * @param  on    state for light
	 * @param  value value for temperature as String

	 */
	public void updateElement(int room, int element, boolean on, String value) {
		switch (room) {
		// Schlafzimmer
		case 1:
			switch (element) {
			// Light
			case 1:
				gui.setSchlafzimmer(on);		//Set light on
				break;
			// Temperature
			case 2:
				gui.setTempSchlafzimmer(value);	//Set value for temperature
				break;
			}
			break;
		// Wohnzimmer
		case 2:
			switch (element) {
			// Light
			case 1:
				gui.setWohnzimmer(on);			//Set light on
				break;
			// Temperature
			case 2:
				gui.setTempWohnzimmer(value);	//Set value for temperature
				break;
			}
			break;

		// Bad
		case 3:
			switch (element) {
			// Light
			case 1:
				gui.setBad(on);
				break;
			// Temperature
			case 2:
				gui.setTempBad(value);
				break;
			}
			break;

		// Kueche
		case 4:
			switch (element) {
			// Light
			case 1:
				gui.setKueche(on);
				break;
			// Temperature
			case 2:
				gui.setTempKueche(value);
				break;
			}
			break;
		}
	}

}
