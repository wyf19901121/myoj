package google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GoogleFile {
    static String input = "B-large.in";
    static String output = "output.txt";
    public static void main(String[] args) throws IOException {
        File file = new File(input);
        BufferedReader reader = null;
        File outfile = new File(output);
        BufferedWriter writer = null;
        
        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outfile));
        int caseNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseNum; i++) {
            StringBuffer outr = new StringBuffer("Case #");
            outr.append(i+1);
            outr.append(":");
            //TODO:write ith result
        }
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
