import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read txt file and export it to string arraylist
 */
public class ReaderTxtUtil {
    public static ArrayList<String> readTxtFile(String fileName){
        try (BufferedReader txtFile = new BufferedReader(new FileReader(ReaderTxtUtil.class.getResource(fileName).getFile()))){
            ArrayList<String> readArr = new ArrayList<>();
            String currRow;

            while ((currRow = txtFile.readLine()) != null) {
                readArr.add(currRow);
            }
            String[] result = new String[readArr.size()];
            return readArr;
        } catch (IOException e) {
            System.err.println("fail to read file，please check config file:"+fileName);
            throw new RuntimeException(e);
        }

    }


}