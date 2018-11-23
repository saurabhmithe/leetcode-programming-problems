package String.Easy;

public class DIStringMatch {

    /*

    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
    Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]

    Example 1:
    Input: "IDID"
    Output: [0,4,1,3,2]

    Example 2:
    Input: "III"
    Output: [0,1,2,3]

    Example 3:
    Input: "DDI"
    Output: [3,2,0,1]

    Note:
    1 <= S.length <= 10000
    S only contains characters "I" or "D".

    */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) return null;
        int incSeq = 0;
        int decSeq = S.length();
        boolean increase = true;
        int[] result = new int[S.length() + 1];
        int c = 0;
        for (; c < S.length(); c++) {
            if (S.charAt(c) == 'I') {
                result[c] = incSeq++;
            } else {
                result[c] = decSeq--;
            }
        }
        if (S.charAt(S.length() - 1) == 'I') result[c] = incSeq;
        else result[c] = decSeq;
        return result;
    }

}
