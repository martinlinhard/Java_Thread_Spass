/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author martin
 */
public class SudokuPuzzle {

	private int[][] field;

	public SudokuPuzzle(int[][] field) {
		this.field = field;
	}

	public static SudokuPuzzle fromLines(List<String> lines) {
		int[][] grid = new int[9][9];
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < lines.get(i).length(); j++) {
				grid[i][j] = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));
			}
		}
		return new SudokuPuzzle(grid);
	}

	public void print() {
		synchronized (System.out) {
			for (int[] arr : this.field) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println("");
		}

	}

	private boolean isViable(int row, int col, int num) {

		for (int d = 0; d < this.field.length; d++) {
			//number is present in row
			if (this.field[row][d] == num) {
				return false;
			}

			//number is present in column
			if (this.field[d][col] == num) {
				return false;
			}
		}

		int sqrt = (int) Math.sqrt(this.field.length);
		int rowStart = row - row % sqrt;
		int colStart = col - col % sqrt;

		for (int r = rowStart; r < rowStart + sqrt; r++) {
			for (int d = colStart; d < colStart + sqrt; d++) {
				//number is present in square
				if (this.field[r][d] == num) {
					return false;
				}
			}
		}

		//number is valid
		return true;
	}

	public boolean solve() {
		int n = this.field.length;
		int row = -1;
		int col = -1;

		boolean isEmpty = true;

		//check whether there's still a 0 left
		OUTER:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//an empty field was found!
				if (this.field[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break OUTER;
				}
			}
		}

		//no 0 left --> DONE! :)
		if (isEmpty) {
			return true;
		}

		//loop through all numbers
		for (int num = 1; num <= n; num++) {
			//numer is valid / possible
			if (isViable(row, col, num)) {
				// assign it & continue with next field
				this.field[row][col] = num;
				if (solve()) {
					return true;
				} else {
					//the previous number made the puzzle unsolveable --> reset the field
					this.field[row][col] = 0;
				}
			}
		}
		return false; // returns false when no number fits (i.e. the previous number was wrong)
	}

	public int getResult() {
		return ((this.field[0][0] * 100)
			+ (this.field[0][1] * 10)
			+ (this.field[0][2]));
	}
}
