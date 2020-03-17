
import java.io.FileNotFoundException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martin
 */
public class XORLauncher {

	public static void main(String[] args) {
		try {
			new XORLauncher().work();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(XORLauncher.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void work() throws FileNotFoundException {
		try {
			String res;
			List<Integer> input = DecryptionIOHelper.getInput();
			Set<String> common = DecryptionIOHelper.getCommonWords();

			ExecutorService es = Executors.newFixedThreadPool(6);
			List<Callable<String>> workers = new ArrayList<>();
			for (char c = 'a'; c <= 'z'; c++) {
				workers.add(new XORWorker(input, common, c));
			}
			String output = es.invokeAny(workers);
			es.shutdown();
			System.out.println(output);
			int sum = CharBuffer.wrap(output.toCharArray()).chars().sum();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException ex) {
			Logger.getLogger(XORLauncher.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
