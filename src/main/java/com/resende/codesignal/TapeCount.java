package com.resende.codesignal;

import java.util.Arrays;

public class TapeCount {
	
	
	public interface Batch {
		
		int[] getFileSizes();
		
		int getTapeSize();
		
	}
	
	static int getMinTapCount(int tapSize, int[] fileSizes) {
        Arrays.sort(fileSizes);
        int tapCount = 0;
        for (int low = 0, high = fileSizes.length - 1; low <= high; ) {
            if (fileSizes[high] + fileSizes[low] <= tapSize) low++;
            high--;
            tapCount++;
        }
        return tapCount;
    }
	
	static int getMinimumTapeCount(final Batch batch) {
		int[] fs = batch.getFileSizes();
		
		if (fs.length == 0) {
			return 0;
		}
		
		if (fs.length == 1) {
			return 1;
		}

		int ts = batch.getTapeSize();
		int nt = 0;
		
		int temp = ts - fs[0];
		nt++;
		int max = 1;
		
		for (int i = 1; i < fs.length; i++) {
			if (temp >= fs[i] && max < 2) {
				max++;
				continue;
			}
			temp = ts - fs[i];
			max=0;
			nt++;
		}
		return nt;
	}
	
	public static void main(String[] args) {
		System.out.println(getMinimumTapeCount(new Batch() {
			
			@Override
			public int getTapeSize() {
				return 100;
			}
			
			@Override
			public int[] getFileSizes() {
				return new int[]{70, 31, 70, 31, 69};
			}
		}));
		System.out.println(getMinTapCount(100, new int[]{70, 31, 70, 31, 69}));
	}

}
