package d2.col;

import java.util.Map;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/7/31 16:42
 */
public abstract class Col {
    private String colName;

    private ColType colType;

    private int sequence;

    public Col(String colName, ColType colType, int sequence) {
        this.colName = colName;
        this.colType = colType;
        this.sequence = sequence;
    }

    public abstract String getColValFormatter(Map<String, Object> map);

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public ColType getColType() {
        return colType;
    }

    public void setColType(ColType colType) {
        this.colType = colType;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
