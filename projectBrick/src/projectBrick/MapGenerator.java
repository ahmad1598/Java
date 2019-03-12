package projectBrick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	//construcror
	// by default we want to put number 1 for value for all brick that we will make them
	//because we want to change this value to 0 if the ball hit the bricks
	public MapGenerator(int row, int col){
		map = new int[row][col];
		for(int i = 0; i < map.length; i++){
			for (int j = 0; j < map[0].length; j++){
				 map[i][j] = 1;
			}
		}
		
		//determine size of width and height for each brick.
		brickWidth = 540 / col;
		brickHeight = 150 / row;
			
		}

	public void draw(Graphics2D g){
		
		for(int i = 0; i < map.length; i++){
			
			for (int j = 0; j < map[0].length; j++){
				if (map[i][j] > 0){
					
					//make random color for bricks
					int R = (int)(Math.random()*256);
					int G = (int)(Math.random()*256);
					int B= (int)(Math.random()*256);
					g.setColor(new Color(R,G,B));
					
					//our fillrect for our map will start from 80 for X and 50 for Y
					// for first brick, 80 from left and 50 from top
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					//the gap between bricks
					g.setStroke(new BasicStroke(2));
					
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
		
	}
	// changing the value of each brick of i,j
	public void setBrickValue(int value, int row, int col){
		map[row][col] = value;
	}
}
