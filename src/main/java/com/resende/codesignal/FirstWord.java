package com.resende.codesignal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstWord {
	
	
	public interface Stream {
		
		char getNext();
		
		boolean hasNext();
		
	}
	
	static String firstWord(final Stream input) {
			
		Map<String, Integer> counts = new HashMap<>();
		Map<Integer, LinkedList<String>> freqs = new HashMap<Integer, LinkedList<String>>();
		
		StringBuilder builder = new StringBuilder();
		
		while (input.hasNext()) {
			char c = input.getNext();
			if (c == ' ' || c == '.' || c == ',') {
				process(counts, freqs, builder);
				builder = new StringBuilder();
			} else {
				builder.append(c);
			}
		}
		
		process(counts, freqs, builder);
		
		for(int i=1; i < freqs.size(); i++ ) {
			LinkedList<String> list = freqs.get(i);
			if (!list.isEmpty()) {
				return list.getFirst();
			}
		}
		
		return null;
	}

	private static void process(Map<String, Integer> counts, Map<Integer, LinkedList<String>> freqs,
			StringBuilder builder) {
		String word = builder.toString().toLowerCase().trim();
		
		if (word.isEmpty()) {
			return;
		}
		
		Integer freq = counts.get(word);
		if (freq == null) {
			freq = 0;
		} else {
			LinkedList<String> currFreq = freqs.getOrDefault(freq, new LinkedList<String>());
			if (currFreq.contains(word)) {
				currFreq.remove(word);
			}
		}
		
		LinkedList<String> newFreq = freqs.getOrDefault(++freq, new LinkedList<String>());
		newFreq.add(word);
		freqs.put(freq, newFreq);
		
		counts.put(word, freq);
	}
	
	public static void main(String[] args) {
		
		System.out.println(firstWord(new Stream() {
			
			String source = "The angry dog was red. And the cat was also dog red and cat angry";
			
			int size = 0;
			
			@Override
			public boolean hasNext() {
				return size < source.length();
			}
			
			@Override
			public char getNext() {
				return source.charAt(size++);
			}
		}));
	}

}
