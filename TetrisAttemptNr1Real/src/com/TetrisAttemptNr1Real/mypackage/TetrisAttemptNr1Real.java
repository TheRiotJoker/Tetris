package com.TetrisAttemptNr1Real.mypackage;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/* 
 * Idea is to generate a random number which will decide which tetromino to generate
 * Then when the tetromino gets decided, we decide the flip, everything else can be generated
 * 
 * 
 * System explanation:
 * First, a tetromino is generated. This happens with a random number from 1 to 7, because that's how many tetrominos there are
 * Then a random number gets generated for the flip (which there are 4 of) - basically the flip is the form of the tetromino
 * then the flip gets applied over a system that takes 1 "deciding block" and builds off of it
 * so at any time there's just one block that's actually there as an object and the other blocks are just built off of it following a pattern
 * the block gets moved by a press of a key on the keyboard, on a press the following happens:
 * all blocks get deleted except for the deciding block
 * the deciding block gets moved
 * the other blocks get built off of the deciding block
 * */
public class TetrisAttemptNr1Real extends JFrame 
implements KeyListener{
	private static final int DIMENSIONS = 50;
	public static TetrisAttemptNr1Real gui = new TetrisAttemptNr1Real();
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 520;
	public static final int HEIGHT = 910;
	private static Grid[][] field = new Grid[16][10];
	private static TBlock tTetromino;
	private static LineBlock lineTetromino;
	private static OBlock oTetromino;
	private static JBlock jTetromino;
	private static LBlock lTetromino;
	private static int decider = 0; //decides which tetromino is being built
	Image doubleBufferImg;
	Graphics doubleBufferGraphics;
	private static void init() {
		int x = 5;
		int y = 30;
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = new Grid(x,y);
				x = x+DIMENSIONS;
			}
			y = y+DIMENSIONS;
			x = 5;
		}
		gui.setSize(WIDTH,HEIGHT);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.addKeyListener(gui);
		gui.setTitle("Yet Another Tetris Attempt");
	}
	private static int randomNumber(int max, int min){
		Random random = new Random();
		return random.nextInt((max-min)+1)+min;
	}
	public static void main(String[] args) {
		init();
		while(true) { //main game loop
			//decider = randomNumber(7,1);
			decider = 1;
			generateTetromino(decider);
			applyFlip(decider);
			while(true) {
				//System.out.println(tTetromino.getFlip());
				//gui.repaint();	
			}
			
		}
	}
	private static void generateTetromino (int decider) {
		switch(decider) {
		case 1: //T Shape (T)
			tTetromino = new TBlock(randomNumber(4,1));
			break;
		case 2: //line shape (----)
			lineTetromino = new LineBlock(randomNumber(2,1));
			break;
		case 3: //block shape ([])
			oTetromino = new OBlock();
			break;
		case 4: //J shape (J)
			jTetromino = new JBlock(randomNumber(4,1));
			break;
		case 5: //L shape (L)
			
			break;
		case 6:
			break;
		case 7:
			break;
		}
	}
	private static void applyFlip(int decider) {
		switch(decider) {
		case 1:
			switch(tTetromino.getFlip()) {
			case 1:
				field[tTetromino.getX()][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()-1].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()+1].setEmpty(false);
				field[tTetromino.getX()+1][tTetromino.getY()].setEmpty(false);
				break;
			case 2:
				field[tTetromino.getX()][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()-1][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()-1].setEmpty(false);
				field[tTetromino.getX()+1][tTetromino.getY()].setEmpty(false);
				break;
			case 3:
				field[tTetromino.getX()][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()-1].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()+1].setEmpty(false);
				field[tTetromino.getX()-1][tTetromino.getY()].setEmpty(false);
				break;
			case 4:
				field[tTetromino.getX()][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()][tTetromino.getY()+1].setEmpty(false);
				field[tTetromino.getX()+1][tTetromino.getY()].setEmpty(false);
				field[tTetromino.getX()-1][tTetromino.getY()].setEmpty(false);
				break;
			}
			break;
		case 2:
			if(lineTetromino.getFlip() == 1) {
				field[lineTetromino.getX()][lineTetromino.getY()].setEmpty(false);
				field[lineTetromino.getX()][lineTetromino.getY()-1].setEmpty(false);
				field[lineTetromino.getX()][lineTetromino.getY()+1].setEmpty(false);
				field[lineTetromino.getX()][lineTetromino.getY()+2].setEmpty(false);
			} else {
				field[lineTetromino.getX()][lineTetromino.getY()].setEmpty(false);
				field[lineTetromino.getX()-1][lineTetromino.getY()].setEmpty(false);
				field[lineTetromino.getX()+1][lineTetromino.getY()].setEmpty(false);
				field[lineTetromino.getX()+2][lineTetromino.getY()].setEmpty(false);
			}
			break;
		case 3:
			field[oTetromino.getX()][oTetromino.getY()].setEmpty(false);
			field[oTetromino.getX()][oTetromino.getY()+1].setEmpty(false);
			field[oTetromino.getX()+1][oTetromino.getY()].setEmpty(false);
			field[oTetromino.getX()+1][oTetromino.getY()+1].setEmpty(false);
			break;
		case 4:
			switch(jTetromino.getFlip()) {
			case 1:
				field[jTetromino.getX()][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()-1][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()+1][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()+1][jTetromino.getY()-1].setEmpty(false);
				break;
			case 2:
				field[jTetromino.getX()][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()][jTetromino.getY()-1].setEmpty(false);
				field[jTetromino.getX()-1][jTetromino.getY()-1].setEmpty(false);
				field[jTetromino.getX()][jTetromino.getY()+1].setEmpty(false);
				break;
			case 3:
				field[jTetromino.getX()][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()-1][jTetromino.getY()+1].setEmpty(false);
				field[jTetromino.getX()-1][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()+1][jTetromino.getY()].setEmpty(false);
				break;
			case 4:
				field[jTetromino.getX()][jTetromino.getY()].setEmpty(false);
				field[jTetromino.getX()+1][jTetromino.getY()+1].setEmpty(false);
				field[jTetromino.getX()][jTetromino.getY()+1].setEmpty(false);
				field[jTetromino.getX()][jTetromino.getY()-1].setEmpty(false);
				break;
			}
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		gui.repaint();
	}
	public static void clearEmpty() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if(field[i][j].isEmpty() == false) {
					field[i][j].setEmpty(true);
				}
			}
		}
		gui.repaint();
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if(field[i][j].isEmpty() == false) {
					g.fillRect(field[i][j].getX(), field[i][j].getY(), DIMENSIONS, DIMENSIONS); 
				}
			}
		}
		switch(decider) {
		case 1:
			g.setColor(Color.GREEN);
			g.fillRect(field[tTetromino.getX()][tTetromino.getY()].getX(), field[tTetromino.getX()][tTetromino.getY()].getY(), DIMENSIONS, DIMENSIONS);
			g.setColor(Color.BLUE);
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.fillRect(field[lineTetromino.getX()][lineTetromino.getY()].getX(), field[lineTetromino.getX()][lineTetromino.getY()].getY(), DIMENSIONS, DIMENSIONS);
			g.setColor(Color.BLUE);
			break;
		case 3:
			g.setColor(Color.GREEN);
			g.fillRect(field[oTetromino.getX()][oTetromino.getY()].getX(), field[oTetromino.getX()][oTetromino.getY()].getY(), DIMENSIONS, DIMENSIONS);
			g.setColor(Color.BLUE);
			break;
		case 4:
			g.setColor(Color.GREEN);
			g.fillRect(field[jTetromino.getX()][jTetromino.getY()].getX(), field[jTetromino.getX()][jTetromino.getY()].getY(), DIMENSIONS, DIMENSIONS);
			g.setColor(Color.BLUE);
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		g.setColor(Color.BLACK);
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				g.drawRect(field[i][j].getX(), field[i][j].getY(), DIMENSIONS, DIMENSIONS);
			}
		}
	}
	public void paint(Graphics g) {
		 doubleBufferImg = createImage(530, 890);
	     doubleBufferGraphics = doubleBufferImg.getGraphics();
	     paintComponent(doubleBufferGraphics);
	     g.drawImage(doubleBufferImg,0,0,this);
	}
	/*
	 * Move method
	 *  */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			switch(decider) {
			case 1:
				if(tTetromino.getFlip() == 4) {
					if(tTetromino.getY()-1 >= 0) {
						tTetromino.setY(tTetromino.getY()-1);
					}
				} else {
					if(tTetromino.getY()-2 >= 0) {
						tTetromino.setY(tTetromino.getY()-1);
					}
				}
				break;
			case 2:
				if(lineTetromino.getFlip() == 1) {
					if(lineTetromino.getY()-2 >= 0) {
						lineTetromino.setY(lineTetromino.getY()-1);
					}
				} else {
					if(lineTetromino.getY()-1 >= 0) {
						lineTetromino.setY(lineTetromino.getY()-1);
					}
				}
				break;
			case 3:
				if(oTetromino.getY()-1 >= 0) {
					oTetromino.setY(oTetromino.getY()-1);
				}
				break;
			case 4:
				if(jTetromino.getFlip() == 3) {
					if(jTetromino.getY()-1 >= 0) {
						jTetromino.setY(jTetromino.getY()-1);
					}	
				} else {
					if(jTetromino.getY()-2 >= 0) {
						jTetromino.setY(jTetromino.getY()-1);
					}
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			switch(decider) {
			case 1:
				if(tTetromino.getFlip() == 2) {
					if(tTetromino.getY()+1 < field[0].length) {
						tTetromino.setY(tTetromino.getY()+1);
					}
				} else {
					if(tTetromino.getY()+2 < field[0].length) {
						tTetromino.setY(tTetromino.getY()+1);
					}
				}
				break;
			case 2:
				if(lineTetromino.getFlip() == 1) {
					if(lineTetromino.getY()+3 < field[0].length) {
						lineTetromino.setY(lineTetromino.getY()+1);
					}
				} else {
					if(lineTetromino.getY()+1 < field[0].length) {
						lineTetromino.setY(lineTetromino.getY()+1);
					}
				}
				break;
			case 3:
				if(oTetromino.getY()+2 < field[0].length) {
					oTetromino.setY(oTetromino.getY()+1);
				}
				break;
			case 4:
				if(jTetromino.getFlip() == 1) {
					if(jTetromino.getY()+1 < field[0].length) {
						jTetromino.setY(jTetromino.getY()+1);
					}	
				} else {
					if(jTetromino.getY()+2 < field[0].length) {
						jTetromino.setY(jTetromino.getY()+1);
					}
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			switch(decider) {
			case 1:
				if(tTetromino.getY() == 0 || tTetromino.getY() == field[0].length-1) {
					if(tTetromino.getY() == 0) {
						tTetromino.setY(tTetromino.getY()+1);
					} else {
						tTetromino.setY(tTetromino.getY()-1);
					}
				}
				if(tTetromino.getX() == 0) {
					tTetromino.setX(1);
				}
				if(tTetromino.getFlip() == 4) {
					tTetromino.setFlip(1);
				} else {
					tTetromino.setFlip(tTetromino.getFlip()+1);
				}	
				break;
			case 2:
				if(lineTetromino.getFlip() == 1 && lineTetromino.getX() <= 14) {
					if(lineTetromino.getX() == 0) {
						lineTetromino.setX(1);
					}
					lineTetromino.setFlip(2);
				} else {
					if(lineTetromino.getY() == 0) {
						lineTetromino.setY(1);
					} else {
						if(lineTetromino.getY() == field[0].length-1) {
							lineTetromino.setY(field[0].length-3);
						}
					}
					lineTetromino.setFlip(1);
				}
				break;
			case 3:
				break;
			case 4:
				if(jTetromino.getY() == 0) {
					jTetromino.setY(1);
				} else {
					if(jTetromino.getY() == field[0].length-1) {
						jTetromino.setY(field[0].length-2);
					} else {
						if(jTetromino.getX() == 0) {
							jTetromino.setX(1);
						}
					}
				}
				if(jTetromino.getFlip() == 4) {
					jTetromino.setFlip(1);
				} else {
					jTetromino.setFlip(jTetromino.getFlip()+1);
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
		clearEmpty();
		applyFlip(decider);	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
