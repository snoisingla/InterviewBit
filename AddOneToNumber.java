//interviewbit.com/problems/add-one-to-number/

import java.util.*;
class AddOneToNumber {
	public static int[] plusOne(int[] a) {
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i : a) {
			ar.add(i);
		}

		int currDigitsSum = 0;
		int carry = 1; //initial number to add

		int i = 0;
		while (i < ar.size() - 1 && ar.get(i) == 0) { //remove 0's in the beginning
			ar.remove(i);
		}

		i = ar.size() - 1;
		while (i >= 0) {
			currDigitsSum = ar.get(i) + carry;
			carry = currDigitsSum / 10;
			currDigitsSum = currDigitsSum % 10;
			ar.set(i, currDigitsSum);
			if (carry == 0) {
				break;
			}
			i--;
		}
		if (carry > 0) {
			ar.add(0, carry);
		}

		int[] result = new int[ar.size()];
		int k = 0;
		for (Integer in  : ar) {
			result[k] = in;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {0, 0, 6, 0, 6, 4, 8, 8, 1};
		int[] result = plusOne(a);
		// for(int i = 0; i < result.length ; i++){
		// 	System.out.print(result[i]+" ");
		// }
		// System.out.println();
	}
}