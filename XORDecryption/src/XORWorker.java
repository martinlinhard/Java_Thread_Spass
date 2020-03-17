
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martin
 */
public class XORWorker implements Callable<String> {

	private List<Integer> encrypted;
	private Set<String> commonWords;
	private char key;

	public XORWorker(List<Integer> encrypted, Set<String> commonWords, char key) {
		this.encrypted = encrypted;
		this.commonWords = commonWords;
		this.key = key;
	}

	@Override
	public String call() throws Exception {
		for (int i = 97; i <= 154; i++) {
			for (int j = 97; j <= 154; j++) {
				List<Integer> currentSolution = new ArrayList<>();
				int[] keys = new int[]{
					(int) key, i, j
				};
				int keyCounter = 0;

				for (Integer item : this.encrypted) {
					currentSolution.add(item ^ keys[keyCounter]);
					keyCounter++;
					keyCounter %= 3;
				}
				StringBuilder sb = new StringBuilder();

				for (int i2 : currentSolution) {
					sb.append((char) i2);
				}
				int corrCounter = 0;
				for (String word : sb.toString().split(" ")) {
					if (this.commonWords.contains(word)) {
						corrCounter++;
						if (corrCounter == 4) {
							return sb.toString();
						}
					}
				}
			}
		}
		throw new Exception("not found");
	}
}
