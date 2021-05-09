package main;

/**
 * point
 */
public class Point {
    int value;
    int possiblevalue[];
//    LinkedList<Integer> leftover = new LinkedList<>();
    int size;

    Point() {
		size = 0;
        value = 0;
		possiblevalue = func.getallone();
    }

    Point(int val) {
        size = 0;
        value = val;
		possiblevalue = func.getallzero();
    }

	int remove(int n) {

		if (possiblevalue[n] != 0)
		{
			possiblevalue[n] = 0;
			size--;
		}


		if (size == 1) {
			return 1;
		}
		return 0;

    }

    int valueleft() {
		for (int i = 1; i < possiblevalue.length; i++) {
			if (possiblevalue[i] == 1)
				return i;
        }
		return -1;
    }

}