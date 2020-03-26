/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.concurrent.Callable;

/**
 *
 * @author martin
 */
public class SudokuWorker implements Callable<Integer> {

	private SudokuPuzzle puzzle;

	public SudokuWorker(SudokuPuzzle puzzle) {
		this.puzzle = puzzle;
	}

	@Override
	public Integer call() throws Exception {
		puzzle.solve();
		return puzzle.getResult();
	}

}
