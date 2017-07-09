import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class GUI {

	private JFrame frame;
	private Control c;
	
	private ImagePanel schlafZimmer = new ImagePanel(getClass().getResourceAsStream("schlafzimmer_dunkel.png"));
	private ImagePanel wohnZimmer = new ImagePanel(getClass().getResourceAsStream("wohnzimmer_dunkel.png"));
	private ImagePanel bad = new ImagePanel(getClass().getResourceAsStream("bad_dunkel.png"));
	private ImagePanel kueche = new ImagePanel(getClass().getResourceAsStream("kueche_dunkel.png"));

	private JLabel lbTempSchlafzimmer = new JLabel("TEMP");
	private JLabel lblTempWohnzimmer = new JLabel("tempWohnzimmer");
	private JLabel lbTempBad = new JLabel("tempBad");
	private JLabel lblTempKueche = new JLabel("tempKueche");


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public GUI() {
		c = new Control(this);

		initialize();
		c.startServer();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		schlafZimmer.setBounds(23, 12, 212, 350);

		wohnZimmer.setBounds(230, 12, 301, 350);

		bad.setBounds(530, 14, 207, 137);

		kueche.setBounds(530, 155, 207, 207);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(schlafZimmer);
		schlafZimmer.setLayout(null);

		lbTempSchlafzimmer.setBounds(48, 216, 37, 15);
		schlafZimmer.add(lbTempSchlafzimmer);
		frame.getContentPane().add(wohnZimmer);
		wohnZimmer.setLayout(null);

		lblTempWohnzimmer.setBounds(167, 204, 103, 15);
		wohnZimmer.add(lblTempWohnzimmer);
		frame.getContentPane().add(bad);
		bad.setLayout(null);

		lbTempBad.setBounds(25, 67, 88, 15);
		bad.add(lbTempBad);
		frame.getContentPane().add(kueche);
		kueche.setLayout(null);

		lblTempKueche.setBounds(32, 72, 70, 15);
		kueche.add(lblTempKueche);

	}

	/**
	 * By windows closing stop Server
	 *
	 * Call automatically
	 *
	 * @param  ev Window Event
	 */
	public void windowClosing(WindowEvent ev) {
		c.stopServer();

	}

	
	/**
	 * Set light for Schlafzimmer
	 *
	 * @param  on State to set for light 
	 */
	public void setSchlafzimmer(boolean on) {
		if (on) {
			schlafZimmer.setImage(getClass().getResourceAsStream("schlafzimmer_hell.png"));
		} else {
			schlafZimmer.setImage(getClass().getResourceAsStream("schlafzimmer_dunkel.png"));
		}
	}
	/**
	 * Set temperature for Schlafzimmer
	 *
	 * @param  temp	value for temperature
	 */
	public void setTempSchlafzimmer(String temp) {
		temp = temp + "°C";
		lbTempSchlafzimmer.setText(temp);

	}
	/**
	 * Set light for Bad
	 *
	 * @param  on State to set for light 
	 */
	public void setBad(boolean on) {
		if (on) {
			bad.setImage(getClass().getResourceAsStream("bad_hell.png"));
		} else {
			bad.setImage(getClass().getResourceAsStream("bad_dunkel.png"));
		}
	}
	/**
	 * Set temperature for Bad
	 *
	 * @param  temp	value for temperature
	 */
	public void setTempBad(String temp) {
		temp = temp + "°C";
		lbTempBad.setText(temp);

	}
	/**
	 * Set light for Wohnzimmer
	 *
	 * @param  on State to set for light 
	 */
	public void setWohnzimmer(boolean on) {
		if (on) {
			wohnZimmer.setImage(getClass().getResourceAsStream("wohnzimmer_hell.png"));
		} else {
			wohnZimmer.setImage(getClass().getResourceAsStream("wohnzimmer_dunkel.png"));
		}
	}
	/**
	 * Set temperature for Wohnzimmer
	 *
	 * @param  temp	value for temperature
	 */
	public void setTempWohnzimmer(String temp) {
		temp = temp + "°C";
		lblTempWohnzimmer.setText(temp);

	}
	/**
	 * Set light for Kueche
	 *
	 * @param  on State to set for light 
	 */
	public void setKueche(boolean on) {
		if (on) {
			kueche.setImage(getClass().getResourceAsStream("kueche_hell.png"));
		} else {
			kueche.setImage(getClass().getResourceAsStream("kueche_dunkel.png"));
		}
	}
	/**
	 * Set temperature for Kueche
	 *
	 * @param  temp	value for temperature
	 */
	public void setTempKueche(String temp) {
		temp = temp + "°C";
		lblTempKueche.setText(temp);

	}

}
