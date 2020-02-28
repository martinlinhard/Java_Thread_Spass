/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author martin
 */
public class IO_Handler {

    private static Path path = Paths.get(System.getProperty("user.dir"), "src", "res", "coords.csv");

    public static HashMap<String, List<List<Integer>>> getValues() throws IOException {
        List<List<Integer>> xCoords = new ArrayList<>();
        List<List<Integer>> yCoords = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            xCoords.add(new ArrayList<>());
            yCoords.add(new ArrayList<>());
        }
        
        List<String> lines = Files.lines(path).collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            String[] get = lines.get(i).split(";");
            for (int j = 0; j < get.length; j++) {
                String[] pos = get[j].split(",");
                xCoords.get(i).add(new Integer(pos[0]));
                yCoords.get(i).add(new Integer(pos[1]));
            }
        }
        
        return new HashMap<String, List<List<Integer>>>(){{
            put("xVal", xCoords);
            put("yVal", yCoords);
        }};
    }
}
