package water.wwf;

import java.util.List;

/**
 * Created by steve on 11/19/15.
 */
public class SeparateLinesResult {

    private List<String> listLSC;
    private List<String> listVDM;

    public SeparateLinesResult(List<String> listLSC, List<String> listVDM) {
        this.listLSC = listLSC;
        this.listVDM = listVDM;
    }

    public List<String> getListLSC() {
        return listLSC;
    }

    public void setListLSC(List<String> listLSC) {
        this.listLSC = listLSC;
    }

    public List<String> getListVDM() {
        return listVDM;
    }

    public void setListVDM(List<String> listVDM) {
        this.listVDM = listVDM;
    }
}
