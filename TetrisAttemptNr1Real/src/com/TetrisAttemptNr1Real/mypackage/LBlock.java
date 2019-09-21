package com.TetrisAttemptNr1Real.mypackage;

public class LBlock extends BlockTemplate {
	public LBlock(int pFlip) {
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
