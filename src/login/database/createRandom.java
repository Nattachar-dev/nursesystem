package login.database;

import java.security.SecureRandom;

public class createRandom {
	
	public static int[] UniqueRandom(int from,int to) {
		int n = to-from+1;
		
		int a[] = new int[n];
		for (int i=0; i<n;i++) {
			a[i]=i;
			
		}
		int[] result = new int[n];

		
		int x=n;
		SecureRandom rd = new SecureRandom();
		for(int i=0;i<n;i++) {
			int k = rd.nextInt(x);
			result[i] = a[k];
			a[k] = a[x-1];
			x--;
		}
		return result;
		
	}

	public static int BasicRandom(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
