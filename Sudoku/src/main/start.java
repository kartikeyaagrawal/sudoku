package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class start {
	public static void main(String[] args) throws IOException {
//		File f = new File("program.txt");

		Grid grid = new Grid();
		System.out.println("helos`");
		grid.init_Grid();
		grid.init_Borders();



		while (true) {
			Iterator<Validpoint> i = grid.fill.iterator();
			while (i.hasNext()) {
				Validpoint point = i.next();
				int x = point.x;
				int y = point.y;
				int value = grid.arr[x][y].valueleft();
				grid.arr[x][y].value = value;
				grid.arr[x][y].possiblevalue[value] = 0;
				grid.arr[x][y].size = 0;


			}
			i = grid.fill.iterator();
			while (i.hasNext()) {
				Validpoint point = i.next();
				grid.updateall(point.x, point.y, grid.arr[point.x][point.y].value);
				i.remove();
			}

			grid.fill.clear();
			grid.fill = (Vector<Validpoint>) grid.temp.clone();
			grid.temp.clear();
			if (grid.fill.isEmpty()) {
				break;
			}
		}


		print(grid);
	}

	private static void print(Grid grid) {
		int length = 10;
		for (int i = 1; i < length; i++) {
			for (int j = 1; j < length; j++) {
				System.out.print(grid.arr[i][j].value);
			}
			System.out.println();
		}
		// TODO Auto-generated method stub

	}

}

