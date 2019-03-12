package projectBrick;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// interface keylistener is for using key on the keyboard
public class BrickBreaker extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7032618883563882441L;
	static int ball = 0;
	// need to have play variable to not let game be start when we run program- by
	// default it will be false
	private boolean play;
	// it will be score for players
	static int score = 0;

	private Timer timer;
	private int delay = 8;

	// position for paddle
	private int playerX = 310;

	// position X for ball - how many pixel from left
	private int ballposX = 210;
	static ArrayList<Object> list = new ArrayList<>();

	public int getBallposX() {
		return ballposX;
	}

	public int getBallposY() {
		return ballposY;
	}

	// position Y for ball - how many pixel from top
	private int ballposY = 350;

	// direction of movement of ball on X (from left to right) position
	// if number goes more negetive, direction of movment will be more complicate
	private int ballXdir = -1;

	// direction of movement of ball on Y position (from top to bottom) -
	// if number goes more negetive, direction of movment will be more complicate
	// if for example put the ballYdir on ziro, we will only have X direction and
	// ball only go from left to right
	//this number should be negetive because if we put positive number, ball will go down and we don't want that
	//we want ball going up and that is because we put negetive number.
	private int ballYdir = -2;

	// create variable of MapGenerator class
	private MapGenerator myMap;

	// give our MapGenerator numbers
	Random rnd1 = new Random();

	// create a random number between 3 - 7 for row
	int randomNum1 = rnd1.nextInt(5) + 3;

	// create a random number between 6 - 10 for column
	int randomNum2 = rnd1.nextInt(5) + 6;

	// every time, totalBricks will be change because we have 2 random number that
	// will be multiply to each other
	private int totalBricks = randomNum1 * randomNum2;

	static String name = JOptionPane.showInputDialog(null, "", "Enter Your Name", JOptionPane.QUESTION_MESSAGE);
	String user = getName();

	// constructor
	public BrickBreaker() {

		myMap = new MapGenerator(randomNum1, randomNum2);

		// Adds the specified key listener to receive key events from this component.
		// here this addKeyListener means that we want this class to have listener to
		// every key that we want write code for it
		// means with addKeyListener, our class will be ready to listen to every key on
		// the keyboard if we want have code for them
		addKeyListener(this);
		// Sets the focusable state of this Component to the specified value.
		setFocusable(true);

		// Sets whether focus traversal keys are enabled for this Component.
		// Components for which focus traversal keys are disabled receive key events for
		// focus traversal keys. such as Tab and Shift Tab
		setFocusTraversalKeysEnabled(false);

		// will make speed for our ball. lower number give more speed and higher number
		// will make it slower
		// timer will start after we push arrow key on the keyboard
		timer = new Timer(delay, this);
		timer.start();

	}

	// create all our shapes and colors here
	public void paint(Graphics g) {
		// background
		g.setColor(new Color(100, 181, 246));
		g.fillRect(1, 1, 692, 642); 

		// drawing map
		myMap.draw((Graphics2D) g);

		// borders
		g.setColor(new Color(81,3,34));
		// left line
		g.fillRect(0, 0, 3, 575);
		// up line
		g.fillRect(0, 0, 692, 3);
		// right line
		g.fillRect(687, 0, 3, 575);
		// drawong bottom line
		g.fillRect(0, 574, 692, 3);

		// scores
		g.setColor(Color.black);
		g.setFont(new Font("Helvetica", Font.BOLD, 25));

		// showing user's name at the top close to score
		if(name.length() > 7){
			g.drawString(name + ": ", 320, 30);
		} else{
			g.drawString(name + ": ", 490, 30);
		}
		g.drawString("" + score, 590, 30);

		// paddle
		g.setColor(Color.black);
		g.fillOval(playerX, 550, 120, 8);

		// ball
		
		g.setColor(Color.RED);

		switch (ball) {

		case 0:
			g.setColor(new Color(13,71,161));
			g.fillOval(ballposX, ballposY, 20, 20);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			g.fillRect(ballposX, ballposY, 20, 20);
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.drawString("▲", ballposX, ballposY + 20);
			break;
		case 3:
			g.setColor(Color.WHITE);
			g.drawString("★", ballposX, ballposY + 20);
			break;
		case 4:
			g.setColor(Color.RED);
			g.drawString("♥", ballposX, ballposY + 20);
			break;

		}

		// checking if user breaked all the Bricks and showing won message
		// user can hit enter for play again
		if (totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("Helvetica", Font.BOLD, 30));
			g.drawString("You Won ", 190, 300);
			g.setFont(new Font("Helvetica", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230, 350);

		}

		// check if user can't catch ball and showing GAME OVER message
		if (ballposY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("Helvetica", Font.BOLD, 30));
			g.drawString("GAME OVER! Score: " + score, 190, 300);

			g.setFont(new Font("Helvetica", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 230, 350);

			g.setColor(new Color(249, 191, 59));
			g.fillRect(playerX, 550, 120, 8);

		}

		// releases any system resources that it is using.
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// check for paddle not going out of frame (frame size for X position on RIGHT
		// HAND SIDE)
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX >= 570) {
				playerX = 570;
			} else
				moveRight();
		}
		// check for paddle not going out of frame (frame size for X position on LEFT
		// HAND SIDE)
		// checking if paddle want to go further than 17 it wont let it go out of frame
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX <= 17) {
				playerX = 17;
			} else
				moveLeft();
		}
		// when user hit ENTER for playing again
		// should restarting every variable that we have and also create MAP again
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				play = true;
				ballposX = 120;
				ballposY = 350;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;

				// create a random number between 3 - 7 for row
				int randomNum1 = rnd1.nextInt(5) + 3;

				// create a random number between 6 - 10 for column
				int randomNum2 = rnd1.nextInt(5) + 6;
				myMap = new MapGenerator(randomNum1, randomNum2);

				totalBricks = randomNum1 * randomNum2;

				repaint();
			}
		}

	}

	// paddle movement to left. every time paddle position will be subtract from 20
	private void moveLeft() {
		play = true;
		playerX -= 20;

	}

	// paddle movement to right. every time paddle position (playerX) will be add to
	// 20
	private void moveRight() {
		play = true;
		playerX += 20;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {

			// detecting with paddle
			// detecting if ball will touch paddle, if so, ball will go up again.
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 547, 100, 8))) {
				ballYdir = -ballYdir;

			}

			A: for (int i = 0; i < myMap.map.length; i++) {
				for (int j = 0; j < myMap.map[0].length; j++) {
					if (myMap.map[i][j] > 0) {
						int brickX = j * myMap.brickWidth + 80;
						int brickY = i * myMap.brickHeight + 50;
						/*int brickX2 = j * myMap.brickWidth + 380;
						
						
						int brickY2 = i * myMap.brickHeight + 150;*/
						
						int brickWidth = myMap.brickWidth;
						int brickHeight = myMap.brickHeight;
						
						// the rect variable would be size of each brick
						// making rectangle with size of brick
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						
						/*Rectangle rect2 = new Rectangle(brickX2, brickY, brickWidth, brickHeight);
						Rectangle rect3 = new Rectangle(brickX, brickY2, brickWidth, brickHeight);
						Rectangle rect4 = new Rectangle(brickX2, brickY2, brickWidth, brickHeight);*/
						
						
						
						// making rectangle with size of ball depends of ball position
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						/*Rectangle brickRect2 = rect2;
						Rectangle brickRect3 = rect3;
						Rectangle brickRect4 = rect4;*/

						// touching ball with each brick
						if (ballRect.intersects(brickRect)) {
							//when ball hit each brick, the line below send the 0 value for that specific brick depends on i,j
							//when we put 0 for that specific brick, the brick will disappear.
							myMap.setBrickValue(0, i, j);
							totalBricks--;
							score += 5;
							// checking to make sure breaking only one brick at the time
							// after break each brick, the ball will be seperate from brick
							if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir;
							}
							break A;
						}
						
						/*else if (ballRect.intersects(brickRect2)) {
							//when ball hit each brick, the line below send the 0 value for that specific brick depends on i,j
							//when we put 0 for that specific brick, the brick will disappear.
							myMap.setBrickValue2(0, i, j);
							totalBricks--;
							score += 5;
							// checking to make sure breaking only one brick at the time
							// after break each brick, the ball will be seperate from brick
							if (ballposX + 19 <= brickRect2.x || ballposX + 1 >= brickRect2.x + brickRect2.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir;
							}
							break A;
						}*/
						
					}
				}
			}
			
			//every time the number for ballposX will be calculate with ballXdir.
			ballposX += ballXdir;
			//every time the number for ballposY will be calculate with ballYdir.
			ballposY += ballYdir;
			
			// this is for left border
			if (ballposX < 0) {
				ballXdir = -ballXdir;
			}
			// this is for top border
			if (ballposY < 0) {
				ballYdir = -ballYdir;
			}
			// this is for right border
			if (ballposX > 670) {
				ballXdir = -ballXdir;
			}
		}

		repaint();

	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return String.format("Name: %s Score: %d", name, score);

	}

	// adds the scores to a list and returns a list to be serialized
	public static ArrayList<Object> wrapScore() {

		list = new ArrayList<>();

		list.add(name);
		list.add(score);
		list.add(ball);

		return list;
	}

}
