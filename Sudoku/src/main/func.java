package main;

public class func {

	static int[] getallone()

	{
		int arr[] = { -1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		return arr;
	}

	static int[] getallzero()

	{
		int arr[] = { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
		return arr;
	}

//	private int compute(int i, int j) {
//		// TODO Auto-generated method stub
//		i--;
//		j--;
//		i /= 3;
//		j /= 3;
//
//		return i * 3 + j + 1;
//	}

	public static int getSource(int i, int j) {

		i = (int) (Math.ceil(i / 3.0) - 1);
		j = (int) (Math.ceil(j / 3.0) - 1);
//		i--;
//		j--;
		return (i * 3 + j + 1);

	}

}
