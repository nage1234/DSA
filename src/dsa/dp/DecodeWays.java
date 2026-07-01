package dsa.dp;

public class DecodeWays {
	private int numDecod(String A, int[] arr) {
        int MOD = 1000000007;
        if (A.length() == 1 && A.charAt(0) != '0') {
		    return 1;
		}
		if (A.charAt(0) == '0') {
		    return 0;
		}
		arr[0] = 1;
		arr[1] = 1;
		for( int i = 2;i<=A.length();i++) {
		    int tempSum = 0;
		    if (A.charAt(i-1) != '0')
		    {
		       tempSum = arr[i-1];
		    }
		    if (A.charAt(i-2) != '0') {
		        int val = Integer.parseInt(A.substring(i-2, i));
		        if(val <= 26) {
		            tempSum = (tempSum + arr[i-2])%MOD;
		        }
		    }
		    arr[i] = tempSum;
		}
		return arr[A.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1206";
		DecodeWays dw = new DecodeWays();
		int[] arr = new int[s.length()+1];
		dw.numDecod(s, arr);
	}

}
