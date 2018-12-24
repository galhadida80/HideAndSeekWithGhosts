/**
 * Will class represent the GUI Menu of the Project.
 * @author Tzvi Mints and Or Abuhazira
 * @version 4.0
 */
package myFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Robot.Play;


public class Menu extends JPanel{
	private static final long serialVersionUID = 1L;
	/* * * * * * * * * * * * * *  Initialization Variables * * * * * * * * * * * * * * * */
	private  JLabel Start; // Start button
	private  JLabel Load; // Load button
	private  JTextField Score; // Score TextField
	private Image MenuBackground = Toolkit.getDefaultToolkit().getImage("./img/MenuBackground.jpg"); // Menu background image path
	private GamePanel panel;
	private static final long Tzvi_ID = 314977489;
	private static final long Or_ID = 311226617;

	/* * * * * * * * * * * * * * Setters and Getters * * * * * * * * * * * * * * * */

	/* * * * * * * * * * * * * *  Constructor  * * * * * * * * * * * * * * * */
	public Menu(GamePanel panel)
	{
		this.panel = panel;
		initialize();
	}
	/* * * * * * * * * * * * * * * * * * Paint Background  * * * * * * * * * * * * * * * */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < getWidth(); i+=50) {
			g.drawImage(MenuBackground,i,50,50,50, this);	
			for (int j = 0; j < getHeight(); j+=50) {
				g.drawImage(MenuBackground,i,j,50,50, this);
			}		
		}		    
	}
	/* * * * * * * * * * * * * * * * * * Initialize Window * * * * * * * * * * * * * * * */
	private void initialize() {
		
		// **** Start JButton ***** //
		Start = new JLabel(new ImageIcon("./img/Start.png"));
		Start.setVisible(true);
		Start.setBounds(0, 20, 232, 69);
		this.add(Start);
		
		// **** Start Mouse Listener ***** //
		Start.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e) {
				panel.play.setIDs(Tzvi_ID,Or_ID);
				panel.StartGame();
				Start.setVisible(false);
			}
		});

		// **** Load JButton ***** //
		Load = new JLabel(new ImageIcon("./img/Load.png"));
		Load.setVisible(true);
		Load.setBounds(0, 20 + 20 + 69, 232, 69);
		this.add(Load);

		// **** Load Mouse Listener ***** //
		Load.addMouseListener(new MouseAdapter() { 		// ************** On Click Load
			public void mouseClicked(MouseEvent e)  {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
				{
					String _Filename = chooser.getSelectedFile().getAbsolutePath();
					if(_Filename.contains(".csv")) 
					{
//						MyFrame.game = new Game(_Filename);
//						MainFrame.mainSplittedPane.invalidate();
//						MainFrame.mainSplittedPane.setVisible(false);
//						MainFrame.mainSplittedPane.removeAll();
//						MainFrame.panel = new DotsAndLines(MyFrame.game,MainFrame.map);
//						MainFrame.StartPanel();
					}
					else {
						JOptionPane.showMessageDialog(null, "This File is not .CSV file");
					}
				}
			}
		});

		// **** Score Text Field ***** //
		final ImageIcon Score_Image = new ImageIcon("./img/Score.png");
		Score = new JTextField() { // Making TextArea From Image
			private static final long serialVersionUID = 1L;
			Image image = Score_Image.getImage();
			{
				setOpaque(false);
			}
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, this);
				super.paint(g);
			}
		};	
		Score.setHorizontalAlignment(JTextField.CENTER);
		Score.setBorder(null);
		Score.setVisible(true);
		Score.setText("0");
		Score.setFont(new Font("Courier New", Font.PLAIN, 15));
		Score.setForeground(Color.WHITE);
		Score.setBounds(0 + 8, 697 - 120 , 232, 69);
		Score.setEditable(false);
		this.add(Score);
		
	}
}
