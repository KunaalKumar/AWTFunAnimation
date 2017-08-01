package animation;

import java.awt.Color;
import java.awt.Graphics;

public class Animation {
	/**
	 * This is the method that you need to rewrite to create a custom animation.
	 * This method is called repeatedly as the animation proceeds. It needs to
	 * draw to g how the animation should look after t milliseconds have passed.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *            started
	 */
	public static void paintFrame(Graphics g, int t, int height, int width) {

		background(g, 0, 0, Color.BLACK.brighter());
		
		
		if (t < 2000) {
			background(g, 0, 0, Color.BLUE.darker());
			drawFish(g, 5 + t, 200 + (int) ((10 * Math.sin(t * Math.PI / 100))), Color.CYAN);
			drawFish(g, t, 200 + (int) (100 + ((10 * Math.sin(t * Math.PI / 100)))), Color.CYAN.darker());
			drawFish(g, t - 100, 200 + (int) (300 + ((10 * Math.sin(t * Math.PI / 100)))), Color.RED);
			drawFish(g, t - 50, 200 + (int) (50 + ((10 * Math.sin(t * Math.PI / 100)))), Color.RED.darker());
			drawFish(g, t - 100, 200 + (int) (300 + ((10 * Math.sin(t * Math.PI / 100)))), Color.RED);
			drawFish(g, t - 120, 200 + (int) (200 + ((10 * Math.sin(t * Math.PI / 100)))), Color.YELLOW.brighter());
			drawFish(g, t - 300, 200 + (int) (240 + ((10 * Math.sin(t * Math.PI / 100)))), Color.YELLOW);
			drawFish(g, t - 10, 200 + (int) (220 + ((10 * Math.sin(t * Math.PI / 100)))), Color.YELLOW.darker());
			drawFish(g, t - 330, 200 + (int) (((10 * Math.sin(t * Math.PI / 100)))), Color.RED.brighter());
			drawFish(g, t - 310, 200 + (int) (10 + ((10 * Math.sin(t * Math.PI / 100)))), Color.YELLOW.brighter());
			drawFish(g, t - 200, 200 + (int) (40 + ((10 * Math.sin(t * Math.PI / 100)))), Color.RED.brighter());
			drawFish(g, t - 140, 200 + (int) (30 + ((10 * Math.sin(t * Math.PI / 100)))), Color.BLUE.brighter());
			drawFish(g, t - 134, 200 + (int) (100 + ((10 * Math.sin(t * Math.PI / 100)))), Color.GREEN.darker());
			drawFish(g, t - 40, 200 + (int) (100 + ((10 * Math.sin(t * Math.PI / 100)))), Color.GREEN.brighter());
			
		}
		
		if (t >= 2000) {
			background(g, 0, (t - 2000) / 10, Color.BLUE.darker());
			drawBigFish(g, t - 2000 , 200, Color.GREEN);
			drawBigFish(g, t - 2100 , 300, Color.WHITE);
			drawBigFish(g, t - 2000 , 400, Color.GREEN);
			

		}

		if (t > 3500 && t < 5000) {
			drawMoon(g, 100, 10 + (t - 4000) / 10);
		}

		if (t >= 5000) {
			drawStar(g, 100, 300, 800, 100);

			drawMoon(g, 100, 110);

			
		}

		if (t > 7000) {
			background(g, 0, 500, Color.BLUE.darker());
		}
		
		if(t >= 7500) {
			drawShip(g, 1000 - (t / 60), 490, Color.GREEN);
			//510 -550
			drawFish(g, ((t + 100) / 100), 550, Color.CYAN);
			drawSmallFish(g, 1000 - (t / 80), 510, Color.YELLOW);
		}

		g.setColor(Color.LIGHT_GRAY);
		// Left border
		g.fillRect(0, 0, 100, 1000);
		// Top border
		g.fillRect(0, 0, 1000, 100);
		// Right border
		g.fillRect(900, 0, 100, 1000);
		// Bottom border
		g.fillRect(0, 570, 1000, 100);
		
	}

	/**
     * Sets background Color
     */
	public static void background(Graphics g, int x, int y, Color color) {

		g.setColor(color);
		g.fillRect(x, y, 1000, 1000);
	}
	
	/**
     * Draws a white moon at given coordinates
     */
	public static void drawMoon(Graphics g, int x, int y) {
		g.setColor(Color.WHITE);

		g.fillOval(x, y, 100, 100);
	}
	
	/**
     * Draws a small scale fish facing left
     */
	public static void drawSmallFish(Graphics g, int x, int y, Color color) {
		int[] xCordsTailBot = {x + 20, x + 30, x + 25};
		int[] yCordsTailBot = {y + 5, y + 15, y + 5};
		int[] xCordsTailTop = {x + 20, x + 30, x + 25};
		int[] yCordsTailTop = {y + 5, y - 5, y +5};
		g.setColor(color);
		g.fillOval(x, y, 20, 10);
		//Bottom tail fin
		g.fillPolygon(xCordsTailBot, yCordsTailBot, 3);
		g.fillPolygon(xCordsTailTop, yCordsTailTop, 3);
		
		if(color == Color.WHITE) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.WHITE);
		}
		
		g.fillOval( x + 3, y + 3, 5, 5);

	}
	
	/**
     * Draws a normal scale fish facing right
     */
	public static void drawFish(Graphics g, int x, int y, Color color) {
		int[] xCordsTail = { x, x - 10, x - 10 };
		int[] yCordsTail = { y + 5, y - 10, y + 20 };
		int[] xCordsBotFin = { x + 25, x + 20, x + 30 };
		int[] yCordsBotFin = { y + 10, y + 20, y + 10 };
		int[] xCordsTopFin = { x + 25, x + 20, x + 30 };
		int[] yCordsTopFin = { y + 1, y - 10, y + 1 };

		g.setColor(color);
		g.fillOval(x, y, 50, 10);
		// draws top fin
		g.fillPolygon(xCordsTopFin, yCordsTopFin, 3);
		// draws bot fin
		g.fillPolygon(xCordsBotFin, yCordsBotFin, 3);
		// draws tail
		g.fillPolygon(xCordsTail, yCordsTail, 3);
		if (color == Color.WHITE) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.WHITE);
		}
		g.fillOval(x + 38, y + 2, 5, 5);

	}
	
	/**
     * Draws a big scale fish facing right
     */
	public static void drawBigFish(Graphics g, int x, int y, Color color) {
		int[] xCordsTail = { x + 5, x - 10, x - 10 };
		int[] yCordsTail = { y + 35, y - 30, y + 100 };
		
		g.setColor(color);
		//Fish body
		g.fillOval(x, y, 100, 80);
		// draws tail
		g.fillPolygon(xCordsTail, yCordsTail, 3);
		g.setColor(Color.BLUE.darker());
		//Fish Mouth
		g.fillOval( x + 80, y + 45, 50, 40);
		
		if(color == Color.RED) {
			g.setColor(Color.BLACK);
		}
		else {
			g.setColor(Color.RED.darker());
		}
		
		g.fillOval(x + 70, y + 15, 10, 10);
	}
	

	private static int starDrawPhase = 0;
	private static int starDrawX = 0;
	private static int starDrawY = 0;
	private static int starDrawSize = 0;
	private static Color starDrawColor;
	
	/**
     * Spawns stars randomly.
     * Stars grow and shrink.
     * Stars are in the shape of circles and rectangles
     * Stars also spawn in different colors randomly ( Currently set to false)
     */
	public static void drawStar(Graphics g, int starSkyLeft,  int starSkyTop, int starSkyWidth, int starSkyHeight) {
			
			Color[] colors = { 
					Color.RED.darker(), 
					Color.WHITE, 
					Color.WHITE.brighter(), 
					Color.BLUE, 
					Color.BLUE.brighter(),
					Color.CYAN.darker(), 
					Color.GRAY.brighter(), 
					Color.MAGENTA.darker() 
			};
			
			boolean makeStarsGrowAndShrink = true;
			boolean makeStarsAsCircle = true;
			boolean makeStarsWithDifferentColors = false;
			
			if (makeStarsGrowAndShrink && starDrawPhase > 0) {
				starDrawPhase += 1;
				starDrawPhase %=  1 + (int)(Math.random() * 30);
				
				// do we grow or shrink the star?
				int grow = 1;
				if (starDrawSize > 1) { // only grow if it is too small
					int random = (int) (Math.random() * 100);
					if (random < 33) {
						grow = -1;
					}  else if ( random < 66) {
						grow = 0;
					}
	
					// if it is too big, shrink it
					if (starDrawSize > 5 + (int)(Math.random() * 2)) {
						grow = -1;
					}
				}
				
				starDrawSize += grow;
			} else {
			
				// Dont always draw a star; too predictable
				if ((int) (Math.random() * 100) > 25) {
					// return;
				}
				
				int colorIndex =  (int)(Math.random() * 8) % 8;
				starDrawColor = colors[colorIndex];
				if (!makeStarsWithDifferentColors) {
					starDrawColor = Color.YELLOW.brighter();
				}
					
				starDrawX = starSkyLeft + (int)(Math.random() * starSkyWidth);
				starDrawY = starSkyTop - (int)(Math.random() * starSkyHeight); 
				starDrawSize = 1 + (int) (Math.random() * 2);
				starDrawPhase = 1;
			}
			
			if (makeStarsAsCircle) {
				g.setColor(starDrawColor);
				g.fillOval(starDrawX, starDrawY, starDrawSize, starDrawSize);
			} else {
	
				int[] xCord = {
						starDrawX,
						starDrawX + (5 * starDrawSize),
						starDrawX + (10 * starDrawSize), 
						starDrawX + (5 * starDrawSize)
						};
				int[] yCord = {
						starDrawY,
						starDrawY - (5 * starDrawSize), 
						starDrawY, 
						starDrawY + (5 * starDrawSize)
						};
				g.setColor(starDrawColor);
			    g.fillPolygon(xCord, yCord, 4);
			}
	}
	
	/**
     * Draws ship of given color at given coordinates 
     */
	public static void drawShip(Graphics g, int x, int y, Color color) {
		int[] xCords = { x, x + 50, x + 45, x + 5 };
		int[] yCords = { y, y, y + 10, y + 10 };

		g.setColor(color);
		g.fillPolygon(xCords, yCords, 4);
		g.fillRect(x + 30, y - 20, 12, 24);
		g.fillRect(x + 15, y - 10, 10, 15);

	}

}
