package com.resende.codesignal;

import java.util.ArrayList;
import java.util.List;

public class BestProfit {

	static int bestProfit(int[] priceHistory) {

		int max = priceHistory[1] - priceHistory[0];
		int min = priceHistory[0];
		
		int x = 1;
		int y = 0;

		for (int i = 1; i < priceHistory.length; i++) {
			if (priceHistory[i] - min > max) {
				max = priceHistory[i] - min;
				x = i;
			}
			if (priceHistory[i] < min) {
				min = priceHistory[i];
				System.out.println("Buy day "+y+" Sell day "+x);
				y = i;
			}
		}
		System.out.println("Buy day "+y+" Sell day "+x);
		return max;
	}
	
	static class Interval {
		int buy, sell;
		@Override
		public String toString() {
			return "Interval [buy=" + buy + ", sell=" + sell + "]";
		}
	}
	
	static List<Interval> stuckBuySell(int[] profits) {
		
		int i = 0;
		int n = profits.length;
		
		List<Interval> list = new ArrayList<>();
		
		while (i < n - 1) {
			
			//find min
			while (i < n - 1 && profits[i] >= profits[i+1]) {
				i++;
			}
			
			if (i == n - 1) {
				break;
			}
			
			Interval e = new Interval();
			
			e.buy = i++;
			
			// Find max
			while(i < n && profits[i - 1] < profits[i]) {
				i++;
			}
			
			e.sell = i - 1;
			list.add(e);
			
		}
		
		return list;
		
	}
	

	public static void main(String[] args) {
//		System.out.println(bestProfit(new int[] { 100, 180, 260, 310, 40, 535, 695}));
//		System.out.println(stuckBuySell(new int[] { 100, 180, 260, 310, 40, 535, 695}));
//		System.out.println(bestProfit(new int[] { 2, 3, 5, 1, 2, 6, 5 }));
//		System.out.println(stuckBuySell(new int[] { 2, 3, 5, 1, 2, 6, 5 }));
//		System.out.println(bestProfit(new int[] { 10, 8, 7, 5, 3, 6, 7, 6, 4, 6 }));
//		System.out.println(stuckBuySell(new int[] { 10, 8, 7, 5, 3, 6, 7, 6, 4, 6 }));
//		System.out.println(bestProfit(new int[] { 10, 8, 7, 5, 3, 6, 7, 6, 4, 30 }));
		System.out.println(stuckBuySell(new int[] { 10, 8, 7, 5, 3, 6, 7, 6, 4, 30 }));
//		System.out.println(bestProfit(new int[] { 10, 15, 7, 5, 1, 3 }));
	}

}
