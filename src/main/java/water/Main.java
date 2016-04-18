package water;

import water.dao.DataDao;
import water.dao.VodAccServThread;
import water.dao.VodAccThread;
import water.wwf.ReadFile;
import water.wwf.SeparateLinesResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by steve on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(new Date());

        ReadFile readFile = new ReadFile("/home/steve/Max/work/Poltava/Refresh/Water/L_151031.11_1");
        SeparateLinesResult separateLinesResult = readFile.getFileData();

        List<String> listLSC = separateLinesResult.getListLSC();
        List<String> listServ = new ArrayList<String>(listLSC);
        List<String> listVDM = separateLinesResult.getListVDM();

        VodAccThread accThread = new VodAccThread();
        accThread.setList(listLSC);
        accThread.start();

        VodAccServThread accServThread = new VodAccServThread();
        accServThread.setList(listServ);
        accServThread.start();

        DataDao dao = new DataDao();
        dao.insertPltvVodCounter(listVDM);

        System.out.println(new Date());
    }
}
