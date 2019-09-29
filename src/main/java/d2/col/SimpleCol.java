package d2.col;

import java.util.Map;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/7/31 17:13
 */
public class SimpleCol extends Col {
    public SimpleCol(String colName, ColType colType, int sequence) {
        super(colName, colType, sequence);
    }

    public String getColValFormatter(Map<String, Object> map) {
        Object o = map.get(this.getColName());
        if (o == null) {
            return "";
        }

        return String.valueOf(o);
    }
}
