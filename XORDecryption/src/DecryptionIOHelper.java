
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martin
 */
public class DecryptionIOHelper {

	public static final String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res" + File.separator + "input.txt";
	public static final String WORDS_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res" + File.separator + "words";

	public static List<Integer> getInput() throws FileNotFoundException {
		List<Integer> ints = new ArrayList<>();
		new BufferedReader(new FileReader(new File(PATH)))
			.lines()
			.forEach(line -> Arrays.stream(line.split(",")).map(Integer::parseInt).forEach(ints::add));
		return ints;
	}

	public static Set<String> getCommonWords() throws FileNotFoundException {
		return new BufferedReader(new FileReader(new File(WORDS_PATH)))
			.lines()
			.collect(Collectors.toSet());
	}
}
