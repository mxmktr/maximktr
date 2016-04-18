package water.wwf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 11/18/15.
 */
public class ReadFile {

    private String filePath = null;

    public ReadFile(String filePath){
        this.filePath = filePath;
    }

    public SeparateLinesResult getFileData() {

        String line;
        BufferedReader br = null;
        LineValidator validator = new LineValidator();
        List<String> listLSC = new ArrayList<String>();
        List<String> listVDM = new ArrayList<String>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "CP1251"));
            while ((line = br.readLine()) != null){
                if (validator.checkReadLine(line)){
                    listLSC.add(line);
                } else {
                    listVDM.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SeparateLinesResult separateLinesResult = new SeparateLinesResult(listLSC, listVDM);

        return separateLinesResult;
    }
}
