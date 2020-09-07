package com.resende.codesignal;

public class HashTable<K, V> {
	
	class Tuple {
		K key;
		V value;
		
		public Tuple(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
	
	private final java.util.LinkedList<Tuple>[] buckets;
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		this.buckets = new java.util.LinkedList[capacity];
	}

	public void put(K key, V value) {
		int hash = hash(key);
		if (buckets[hash] ==  null) {
			buckets[hash] = new java.util.LinkedList<>();
		}
		buckets[hash].add(new Tuple(key, value));
	}
	
	public V get(K key) {
		int hash = hash(key);
		java.util.LinkedList<Tuple> bucket = buckets[hash];
		if (bucket ==  null || bucket.isEmpty()) 
			return null;
		for (Tuple t: bucket) {
			if (t.key.equals(key)) {
				return t.value;
			}
		}
		return null;
	}
	
	public boolean remove(K key) {
		int hash = hash(key);
		java.util.LinkedList<Tuple> bucket = buckets[hash];
		if (bucket ==  null || bucket.isEmpty()) 
			return false;
		for (Tuple t: bucket) {
			if (t.key.equals(key)) {
				bucket.remove(t);
				return true;
			}
		}
		return false;
	}
	
	private int hash(K key) {
		return 31 * key.hashCode() % buckets.length;
	}
	
	public static void main(String[] args) {
		
		HashTable<String, Integer> table = new HashTable<String, Integer>(10);
		table.put("A", 1);
		table.put("B", 2);
		table.put("C", 3);
		System.out.println(table.get("A"));
		System.out.println(table.get("B"));
		System.out.println(table.get("C"));
		System.out.println(table.remove("B"));
		System.out.println(table.get("B"));
		table.put("B", 7);
		System.out.println(table.get("B"));
	}

}
