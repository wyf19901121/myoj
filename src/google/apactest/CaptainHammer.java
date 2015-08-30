package google.apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaptainHammer {
    public static void main(String[] args) throws IOException {
        File file = new File("B-small-attempt0.in");
        BufferedReader reader = null;
        File outfile = new File("output.txt");
        BufferedWriter writer = null;
        
        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outfile));
        int caseNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseNum; i++) {
            String[] temp = reader.readLine().split(" ");
            int v = Integer.parseInt(temp[0]);
            int d = Integer.parseInt(temp[1]);
            double sin2x = 9.8 * d / (v * v);
            double x = Math.asin(sin2x) * (180 / Math.PI) / 2;
            
            StringBuilder result = new StringBuilder("Case #");
            result.append(i+1);
            result.append(": ");
            result.append(x);
            writer.write(result.toString());
            writer.newLine();
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
