package BaizeXS_Utils.NameCreator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NameCreator {
    static ArrayList<String> lastNameSet = new ArrayList<>();
    static ArrayList<String> boyFirNameSet = new ArrayList<>();
    static ArrayList<String> girlFirNameSet = new ArrayList<>();
    public void lastNameStore(String path) {
        BufferedReader br = null;
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lastNameSet.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null ) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    public void firstNameStore(String gender, String path) {
        BufferedReader br = null;
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            String line;
            if (gender.equals("M")) {
                while ((line = br.readLine()) != null) {
                    String[] tmp = line.split("、");
                    boyFirNameSet.addAll(Arrays.asList(tmp));
                }
            } else if (gender.equals("F")) {
                while ((line = br.readLine()) != null) {
                    String[] tmp = line.split("、");
                    girlFirNameSet.addAll(Arrays.asList(tmp));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    public String createName(String gender) {
        String lastName = lastNameSet.get((int)(Math.random() * (lastNameSet.size() - 1)) + 1);
        String firstName;
        if (gender.equals("M"))
            firstName = boyFirNameSet.get((int)(Math.random() * (boyFirNameSet.size() - 1)) + 1);
        else if (gender.equals("F"))
            firstName = girlFirNameSet.get((int)(Math.random() * (girlFirNameSet.size() - 1)) + 1);
        else
            throw new RuntimeException("请输入正确的性别");
        return lastName + firstName;
    }

    public static void main(String[] args) {
        NameCreator nc = new NameCreator();
        nc.lastNameStore("src/Test/NameCreator/lastName_CN");
        nc.firstNameStore("M","src/Test/NameCreator/boyName_CN");
        nc.firstNameStore("F","src/Test/NameCreator/girlName_CN");
        for (int i = 0; i < 50; i++) {
            System.out.println(nc.createName("M"));
            System.out.println(nc.createName("F"));
        }
    }
}
