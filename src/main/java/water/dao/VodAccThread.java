package water.dao;

import java.util.List;

/**
 * Created by steve on 11/20/15.
 */
public class VodAccThread extends Thread{

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        DataDao dao = new DataDao();
        dao.insertPltvVodAcc(list);
    }
}
