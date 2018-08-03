package com.scalablepress.main;

import java.util.concurrent.ThreadLocalRandom;

import com.scalablepress.Constants;
import com.scalablepress.exception.NumberOutOfRangeException;

public class CoinFlip {
	
	private static final int INTEGER = 20;

	public static void main(String[] args) {
		
		CoinFlip coinFlip = new CoinFlip();
		
		try {
			System.out.println(coinFlip.randomNumber(INTEGER));
		} catch (NumberOutOfRangeException e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean flip() {
		ThreadLocalRandom generator = ThreadLocalRandom.current();
		float random = generator.nextFloat();
		
		return random >= 0.5;
	}
	
	private int randomNumber(int number) throws NumberOutOfRangeException {
		boolean randomIsUpper = false;
		boolean isInvalidNumber = ((number < Constants.ZERO) || (number > Constants.MILLION));
		int iterator = 0;
		int numAssertCoinFlip = 0;		
		
		if(isInvalidNumber)
			throw new NumberOutOfRangeException("The number [" + number + "] given is not valid");
		else {
			do {
				randomIsUpper = flip();
				if(randomIsUpper)
					numAssertCoinFlip++;
				else
					iterator++;
				if(iterator >= number)
					iterator = 0;
			}while(!randomIsUpper);
		}
		
		return iterator;
	}

}
