package google.apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BadHorse {
    public static void main(String[] args) {
        File file = new File("C-small-1-attempt0.in");
        BufferedReader reader = null;
        File outfile = new File("output.txt");
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(outfile);
            writer = new BufferedWriter(fw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                int caseNum = Integer.parseInt(tempString);
                boolean canSperater = true;
                for (int i = 0; i < caseNum; i++) {
                    int troubleNum = Integer.parseInt(reader.readLine());
                    Set<String> set1 = new HashSet<String>();
                    Set<String> set2 = new HashSet<String>();
                    for (int j = 0; j < troubleNum; j++) {
                        String trouble = reader.readLine();
                        String[] troubles = trouble.split(" ");
                        if (!set1.contains(troubles[1])) {
                            set1.add(troubles[0]);
                        }
                        else if (!set2.contains(troubles[1])) {
                            set2.add(troubles[0]);
                        }
                        else {
                            canSperater = false;
                        }

                        if (!set1.contains(troubles[0])) {
                            set1.add(troubles[1]);
                        }
                        else if (!set2.contains(troubles[0])) {
                            set2.add(troubles[1]);
                        }
                        else {
                            canSperater = false;
                        }
                    }
                    StringBuilder result = new StringBuilder("Case #");
                    result.append(i+1);
                    result.append(": ");
                    result.append(canSperater == true ? "Yes" : "No");
                    writer.write(result.toString());
                    writer.newLine();
                    canSperater = true;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        try {
            writer.flush();
            writer.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

