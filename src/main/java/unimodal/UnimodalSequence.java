package unimodal;

public class UnimodalSequence {

	/**
	 * Determine the length of the longest unimodal sequence in intArray
	 * 
	 * @param intArray
	 *            is not null
	 * @return the length of the longest unimodal sequence in intArray
	 * @throws NoUnimodalSequenceException
	 *             if there is no unimodal sequence in intArray
	 */
	public static int getLength_longestUnimodalSequence(int[] intArray) throws NoUnimodalSequenceException {
		int i = 0, j = i + 1, temp_i, temp_j;
		int sequence;
		int maxsequence = 0;
		if (intArray.length < j + 2) {
			throw new NoUnimodalSequenceException();
		}
		while (j < intArray.length) {
			temp_i = i; temp_j = j;
			int numIncr, numDecr;
			numIncr = countIncr(intArray, i, j);
			if(numIncr!=0){
				i = i+ numIncr - 1;
				j = j+ numIncr-1;
				if(j<intArray.length){
					numDecr = countDecr(intArray, i, j);
					if(numDecr!=0){
						sequence = numIncr + numDecr - 1; //subtract the common element
						if (maxsequence < sequence) {
							maxsequence = sequence;
						}
					}
				}
			}
			i = temp_i + 1;
			j = temp_j + 1;
		}
		if(maxsequence==0){
			throw new NoUnimodalSequenceException();
		}
		return maxsequence;
	}

	private static int countIncr(int[] array, int i, int j){
		int numIncr=0;
		while(array[i]<array[j] && j<array.length){
			numIncr++;
			if(j==array.length-1){
				break;
			}
			i++; j++;
		}
		if(numIncr==0) return numIncr;
		return numIncr+1;

	}
	private static int countDecr(int[] array, int i, int j){
		int numDecr=0;
		while(array[i]>array[j] && j<array.length){
			numDecr++;
			if(j==array.length-1){
				break;
			}
			i++; j++;
		}
		if (numDecr==0) return numDecr;
		return numDecr+1;
	}

}
