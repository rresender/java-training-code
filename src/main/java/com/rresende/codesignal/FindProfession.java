package com.rresende.codesignal;
public class FindProfession {

	static String findProfession(int level, int pos) {
		if (level == 1) {
			return "Engineer";
		}

		int nextPos = (pos + 1) / 2;

		String p = findProfession(level - 1, nextPos);

		if (p.equals("Doctor")) {
			if (pos % 2 != 0) {
				return "Doctor";
			} else {
				return "Engineer";
			}
		}
		if (pos % 2 != 0) {
			return "Engineer";
		} else {
			return "Doctor";
		}
	}

	public static void main(String[] args) {
		findProfession(3, 3);
	}

}
