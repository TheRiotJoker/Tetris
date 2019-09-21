package com.TetrisAttemptNr1Real.mypackage;

public class TBlock extends BlockTemplate {
	public TBlock(int pFlip) {
		flip = pFlip;
		switch(pFlip) {
		case 1:
			x = 0;
			y = 4;
			break;
		case 2:
			x = 1;
			y = 4;
			break;
		case 3:
			x = 1;
			y = 4;
			break;
		case 4:
			x = 1;
			y = 4;
			break;
		}
	}
}
/* 
 * Flips:
 * 1: OOO
 * 	   O
 * 
 * 2: O
 *   OO
 *    O
 *    
 * 3: O
 * 	 OOO
 * 
 * 4: O
 *    OO
 *    O
 * 
 * 
 * */
 
