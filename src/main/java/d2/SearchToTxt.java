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
 * 需求：
 * 把指定表的一些字段输出到txt，使用特定字符分隔及换行
 * 需求分析：
 * 目前已知两张表以及它的字段及顺序，涉及变动的可能有增加表、增加字段、调整顺序，另外客户希望如果发生这些变动，
 * 能够实现不改代码
 *
 * 不采取存储过程的话，需要配置文件维护表及字段信息
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
