/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author martin
 */
public class SudokuLauncher {

	public static void run() throws FileNotFoundException, ExecutionException {
		List<SudokuPuzzle> puzzles = IOHandler.parseSudokus();
		long resultSum = 0;
		ExecutorService pool = Executors.newFixedThreadPool(6);
		CompletionService<Integer> service = new ExecutorCompletionService<>(pool);

		for (SudokuPuzzle field : puzzles) {
			service.submit(new SudokuWorker(field));
		}

		pool.shutdown();

		while (!pool.isTerminated()) {
			try {
				Future<Integer> result = service.take();
				resultSum += result.get();
			} catch (InterruptedException | ExecutionException ex) {
				System.out.println(ex.toString());
			}
		}

		System.out.println("The sum is " + resultSum);
	}
}
