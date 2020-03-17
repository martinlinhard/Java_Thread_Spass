/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler_39;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class TriangleLauncher {

	public void performCalc() throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		CompletionService<Set<Triple>> service = new ExecutorCompletionService<>(pool);

		for (int p = 10; p <= 1000; p++) {
			service.submit(new TriangleWorker(p));
		}

		Set<Triple> maxTriple = null;

		pool.shutdown(); //submits done

		while (!pool.isTerminated()) {
			Future<Set<Triple>> fut = service.take();
			Set<Triple> result = fut.get();
			if (maxTriple == null || result.size() > maxTriple.size()) {
				maxTriple = result;
			}
		}
		maxTriple.forEach(System.out::println);
	}

	public static void main(String[] args) {
		try {
			long time = System.currentTimeMillis();
			new TriangleLauncher().performCalc();
			System.out.println((System.currentTimeMillis() - time) / 1000);
		} catch (InterruptedException | ExecutionException e) {
		}
	}
}
