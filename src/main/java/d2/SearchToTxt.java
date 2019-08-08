package d2;

import d2.col.ColSequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/7/31 15:18
 */

/**
 * 这个程序有哪些问题？
 *
 * 把顺序维护出来，可以降低一定的维护难度；但是map.get的值不可能都是想要的，有可能需要转换呢？
 *
 * 有可能文件要进行滚动生成，并且这里没有使用换行和分隔符
 */
public class SearchToTxt implements Runnable {
    private List<Map<String, Object>> writeToTxtList = new ArrayList<Map<String, Object>>();

    private ColSequence sequence;

    public SearchToTxt(List<Map<String, Object>> writeToTxtList, ColSequence sequence) {
        this.writeToTxtList = writeToTxtList;
        this.sequence = sequence;
    }

    public void run() {
        MyPrinter out = null;
        try {
            File txtFile = new File("test.txt");
            out = new MyPrinter(txtFile.getAbsoluteFile(), "utf-8");

            for (int i = 0; i < writeToTxtList.size(); i++) {
                Map<String, Object> stringObjectMap =  writeToTxtList.get(i);
                out.writeMap(stringObjectMap, sequence);
            }
            System.out.println(txtFile.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
