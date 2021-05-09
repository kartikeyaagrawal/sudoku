package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import IO.Input;
public class Grid {
    final static int len = 10;
	final static int small_grid_desc[][] = { { 0, 0 }, { 1, 1 }, { 1, 4 }, { 1, 7 }, { 4, 1 }, { 4, 4 }, { 4, 7 },
			{ 7, 1 }, { 7, 4 }, { 7, 7 } };

	Point arr[][];
	int row[][];
	int col[][];
	int small_grid[][];
	Vector<Validpoint> fill;
	Vector<Validpoint> temp = new Vector<>();
//	@SuppressWarnings("unchecked")
	// Constructor
	Grid() {
    	arr= new Point[len][len];
//        row = new LinkedList[len];
//        col = new LinkedList[len];
//        small_grid = new LinkedList[len];
		row = new int[len][len];
		col = new int [len][len];
		small_grid = new int[len][len];
		fill = new Vector<>();
        

    }

	// making grid structure just initializing
	void init_Grid() throws IOException {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
                int temp = Input.readInt();
                if (temp != 0) {
                    arr[i][j] = new Point(temp);
                } else {
                    arr[i][j] = new Point();
                }
            }
        }

    	
    }

	void init_Borders()
    {
		initRow();
		initCol();
		initSub_grid();
		initall();

    }
	private void initall() {
    	for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i][j].value == 0) {
					init_each(i, j);
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	private void initRow() {
    	for (int i = 1; i < arr.length; i++) {
    	
			int temparr[] = func.getallone(); // static wala check karna hoga ek baar
			// changes to zero
    		for (int j = 1; j < arr.length; j++) {
				if(arr[i][j].value!=0)
				{
//					
					temparr[arr[i][j].value] = 0;
					
				}
				
			}

			row[i] = temparr;
		}
    }
	private void initCol() {
		for (int j = 1; j < arr.length; j++) {
	    	
			int temparr[] = func.getallone();
			for (int i = 1; i < arr.length; i++) {
				int a = arr[i][j].value;
				if(arr[i][j].value!=0)
				{
					temparr[arr[i][j].value] = 0;
					
				}
				
			}

			col[j] = temparr;
		}
	    	
	    }
	private void initSub_grid() {
		for (int counter = 1; counter < 10; counter++) {
			int row = small_grid_desc[counter][0];
			int col = small_grid_desc[counter][1];
			int temparr[] = func.getallone();
			for (int i = row; i < row + 3; i++) {
				for (int j = col; j < col + 3; j++) {
					int a = arr[i][j].value;
					if (arr[i][j].value != 0) {
						temparr[arr[i][j].value] = 0;

					}
				}
			}

			small_grid[counter] = temparr;

		}
		
		
	}
	private void init_each(int i, int j) {
		int temparr[] = func.getallone();
		for (int k = 1; k < temparr.length; k++) {
			int a = row[i][k];
			int b = col[j][k];
			int c = small_grid[func.getSource(i, j)][k];
			if (row[i][k] == 1 && col[j][k] == 1 && small_grid[func.getSource(i, j)][k] == 1) {
				temparr[k] = 1;
				arr[i][j].size++;
			} else {
				temparr[k] = 0;
			}
		}
		arr[i][j].possiblevalue = temparr;
		if (arr[i][j].size == 1) {
			addtoqueue(i, j);
		}

	}


	private void delrow(int r, int remove_no) {
		row[r][remove_no] = 0;
	}
	private void delcol(int c, int remove_no) {
		col[c][remove_no] = 0;
	}
	private void delsubgrid(int g, int remove_no) {
		small_grid[g][remove_no] = 0;
	}

	void updateall(int i, int j, int remove_no) {
		delrow(i, remove_no);
		delcol(j, remove_no);
		delsubgrid(func.getSource(i, j), remove_no);
		updaterow(i, remove_no);
		updatecol(j, remove_no);
		updatesmallgrid(func.getSource(i, j), remove_no);

	}
	private void updaterow(int r, int remove_no) {
		for (int i = 1; i < arr.length; i++) {
			updateeach(r, i, remove_no);
		}
	}
	private void updatecol(int r, int remove_no) {
		for (int i = 1; i < arr.length; i++) {
			updateeach(i, r, remove_no);
		}
	}
	private void updatesmallgrid(int gridno, int remove_no) {

		int col = small_grid_desc[gridno][1];

		int row = small_grid_desc[gridno][0];

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				updateeach(i, j, remove_no);
			}
		}
	}
	private void updateeach(int i, int j, int remove_no) {
		if (arr[i][j].value != 0) {
			return;
		}
		int temp = arr[i][j].remove(remove_no);

		if (temp == 1) {
			addtoqueue(i, j);
		}

//		int crow = i;
//		int ccol = j;
//		int csub_grid = compute(i, j);
//		int temp[] = new int[10];
//LinkedList<Integer> total = new LinkedList<>();
//		total.addAll(row[crow]);
//		total.addAll(col[ccol]);
//		total.addAll(small_grid[csub_grid]);
//		
//		Iterator<Integer> i = total.iterator();
//		while (i.hasNext()) {
//			Integer type = i.next();
//			temp[type]++;
//
//		}
//		for (int k = 0; k < temp.length; k++) {
//			int l = temp[k];
//			if (l == 3) {
//				total.add(l);
//
//			}
//
//		}
//		 
//		// TODO Auto-generated method stub

	}

	private void addtoqueue(int i, int j) {
		Iterator<Validpoint> it = temp.iterator();

		while (it.hasNext()) {
			Validpoint p = it.next();
			if (p.x == i && p.y == j) {
				return;
			}
		}

		temp.add(new Validpoint(i, j));
	}
}