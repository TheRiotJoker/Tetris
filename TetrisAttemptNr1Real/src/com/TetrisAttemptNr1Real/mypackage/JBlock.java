package com.TetrisAttemptNr1Real.mypackage;

public class JBlock extends BlockTemplate {
	public JBlock(int pFlip){
		if(pFlip == 4) {
			x = 0;
			y = 4;
		} else {
			x = 1;
			y = 4;
		}
		this.flip = pFlip;
	}
}
/* 
 * Flips:
 * 1:
 *   O
 *   O
 *  OO
 *  
 * 2:
 * O
 * OOO
 * 
 * 3: 
 * OO
 * O
 * O
 * 
 * 4:
 * OOO
 *   O
 *   
 * */