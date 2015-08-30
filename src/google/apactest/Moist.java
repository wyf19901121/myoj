package google.apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Moist {
    public static void main(String[] args) throws NumberFormatException, IOException {
        File file = new File("C-small-2-attempt0.in");
        BufferedReader reader = null;
        File outfile = new File("output.txt");
        BufferedWriter writer = null;
        
        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outfile));
        int caseNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseNum; i++) {
            int cardNum = Integer.parseInt(reader.readLine());
            String curMax = " ";
            int cost = 0;
            for (int j = 0; j < cardNum; j++) {
                String curCard = reader.readLine();
                if (curCard.compareTo(curMax) < 0) {
                    cost++;
                }
                else {
                    curMax = curCard;
                }
            }
            StringBuffer result = new StringBuffer("Case #");
            result.append(i+1);
            result.append(": " + cost);
            writer.write(result.toString());
            writer.newLine();
            cost = 0;
            curMax = " ";
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
