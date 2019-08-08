package d2;

import d2.col.Col;
import d2.col.ColSequence;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/7/31 15:45
 */
public class MyPrinter extends PrintWriter {
    private final String newLineSymbol = "\n";
    private final char separateSymbol = (char)27;

    public MyPrinter(File out, String charset) throws FileNotFoundException, UnsupportedEncodingException {
        super(out, charset);
    }

    public void writeMap(Map<String, Object> map, ColSequence sequence) {

        Col[] sequences = sequence.getSequence();
        if (sequences != null) {
            for (int i = 0; i < sequences.length; i++) {
                Col col = sequences[i];
                // TODO 这里工银用存储过程返回，不再开发，留个口子
                if (col.getSequence() == i) {
                    super.write(col.getColValFormatter(map));
                    super.write(separateSymbol);
                }
            }
            super.write(newLineSymbol);
        }

        // 从存储过程返回输出字段，不关心字段的顺序及其值的格式化
        else {
            Set<String> keySet = map.keySet();
            String val = "";
            for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
                String next = iterator.next();
                Object o = map.get(next);
                if (o != null) {
                    val = String.valueOf(o);
                } else {
                    val = "";
                }
                super.write(val);
                super.write(separateSymbol);
            }
            super.write(newLineSymbol);
        }
    }


}
