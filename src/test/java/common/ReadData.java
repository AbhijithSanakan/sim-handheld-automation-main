package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class ReadData {

    public static String getEncodePassword() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("D:\\SOF Automation\\IMAF-main\\.idea\\Settings.txt"));
        String line;
        line = reader.readLine();
        reader.close();
        return new String(Base64.getEncoder().encode(line.getBytes()));
    }

    public static String getDecodepassword() throws IOException {
        return new String(Base64.getDecoder().decode(getEncodePassword().getBytes()));
    }

}
