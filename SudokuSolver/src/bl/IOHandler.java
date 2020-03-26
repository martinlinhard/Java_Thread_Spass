/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author martin
 */
public class IOHandler {

	public static String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "res" + File.separator + "p096_sudoku.txt";

	public static List<SudokuPuzzle> parseSudokus() throws FileNotFoundException {
		List<String> lines = new BufferedReader(new FileReader(PATH))
			.lines()
			.filter(item -> !item.contains("Grid"))
			.collect(Collectors.toList());

		List<SudokuPuzzle> puzzles = new ArrayList<>();

		for (int i = 0; i < lines.size() - 8; i += 9) {
			puzzles.add(SudokuPuzzle.fromLines(lines.subList(i, i + 9)));
		}

		return puzzles;
	}

}
