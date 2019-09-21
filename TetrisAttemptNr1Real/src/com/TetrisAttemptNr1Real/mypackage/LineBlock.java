package com.TetrisAttemptNr1Real.mypackage;

public class LineBlock extends BlockTemplate{

	public LineBlock(int pFlip) {
		if(pFlip == 1) {
			x = 0;
			y = 4;
		} else {
			x = 1;
			y = 4;
		}
		flip = pFlip;
	}
}
/* 
 * Flip 1:
 * OOOO
 * 
 * Flip 2:
 * O
 * O
 * O
 * O
 * 
 * */
