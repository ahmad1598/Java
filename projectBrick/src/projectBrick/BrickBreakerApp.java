package projectBrick;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BrickBreakerApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		BrickBreakerApp frame = new BrickBreakerApp();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public BrickBreakerApp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 700, 640);
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Breakout Ball");
		BrickBreaker myBrick = new BrickBreaker();
		contentPane.add(myBrick);
		
		// select ball menu
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//menu for file
		JMenu file = new JMenu("File");
		menuBar.add(file);
		//menu item to save a save
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {

			private ObjectOutputStream out;

			@Override
			public void actionPerformed(ActionEvent e) {

				File jFile = new File(BrickBreaker.name + ".ser");
				try {
					out = new ObjectOutputStream(new FileOutputStream(jFile));
					out.writeObject((Object) BrickBreaker.wrapScore());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		file.add(save);
		//menu item to load a save
		JMenuItem load = new JMenuItem("Load");

		load.addActionListener(new ActionListener() {

			private ObjectInputStream in;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				File jFile = null;
				try {
					jFile = new File(JOptionPane.showInputDialog(null, "Case Sensitive\n\nEnter the name of the save",
							"Load save", JOptionPane.PLAIN_MESSAGE) + ".ser");
				} catch (Exception eZ) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, "File was not found", "File Not Found ",
							JOptionPane.PLAIN_MESSAGE);
				}

				try {
					in = new ObjectInputStream(new FileInputStream(jFile));
					ArrayList<Object> newList = (ArrayList<Object>) in.readObject();
					BrickBreaker.name = (String) newList.get(0);
					BrickBreaker.score = (int) newList.get(1);
					BrickBreaker.ball = (int) newList.get(2);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, "File was not found", "File Not Found ",
							JOptionPane.PLAIN_MESSAGE);
				}

			}

		});

		file.add(load);
		//menu item for reset
		JMenuItem reset = new JMenuItem("Reset");

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				contentPane = new JPanel();
				BrickBreaker myBrick = new BrickBreaker();
				contentPane.add(myBrick);
				contentPane.validate();
				BrickBreaker.name = JOptionPane.showInputDialog(null, "Enter the new Name", "New Player",
						JOptionPane.PLAIN_MESSAGE);
				BrickBreaker.score = 0;
				BrickBreaker.ball = 0;
				
				
				
			}

		});
		file.add(reset);
		//menu item for exiting the program
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		file.add(exit);
		//menu for selecting the ball
		JMenu ball = new JMenu("Select Ball");
		menuBar.add(ball);
		//menu item for triangle
		JMenuItem triangle = new JMenuItem("Triangle");
		triangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrickBreaker.ball = 2;
			}

		});
		ball.add(triangle);
		//menu item for square
		JMenuItem square = new JMenuItem("Square");

		square.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrickBreaker.ball = 1;
			}

		});

		ball.add(square);
		//menu item for ball
		JMenuItem ballItem = new JMenuItem("Ball");
		ballItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrickBreaker.ball = 0;
			}

		});

		ball.add(ballItem);
		//menu item for star
		JMenuItem star = new JMenuItem("Star");
		star.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrickBreaker.ball = 3;
			}

		});

		ball.add(star);
		//menu item for heart
		JMenuItem heart = new JMenuItem("Heart");
		heart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrickBreaker.ball = 4;
			}

		});

		ball.add(heart);

		//creating the about menu
		JMenu about = new JMenu("About");
		menuBar.add(about);
		//making the about button
		JMenuItem aboutProject = new JMenuItem("About");
		aboutProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String jString = "Brick Breaker revolves around breaking bricks which add to the score."
						+ "\nA user's name, ball choice and score is serialized and saved, and will be loaded again \nby name recognition."						
						+ "\n\nThis game was developed by Ahmad Rasoulpour (2018).";

				JTextArea jTex = new JTextArea(8, 50);
				jTex.setText(jString);

				JScrollPane jScroller = new JScrollPane(jTex);
				JOptionPane.showMessageDialog(null, jScroller, "About the Project", JOptionPane.PLAIN_MESSAGE);

			}

		});

		about.add(aboutProject);

	}

}
