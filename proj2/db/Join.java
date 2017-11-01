package db;
import java.util.ArrayList;
import java.util.List;
public class Join {
    String commonColumnName;
    public Table joinTables(List<Table> tables){
    Table result = joinTwoTables(tables.get(0), tables.get(1));
        for (int i = 2; i < tables.size() ; i ++ ){
            result = joinTwoTables(result, tables.get(i));
        }
        return result;
    }
    private Table joinTwoTables(Table table1, Table table2){
        Table resultTable = table1.replicate();
        if (haveColumnInCommon(table1.columns,table2.columns)){
            for (Row row:resultTable.rows){
                String matchID= row.findElement(commonColumnName);
                Column columnToSearch = table2.getColumn(commonColumnName);
                Row rowToAppend = table2.findRow(columnToSearch,mathcID);
                row.append(rowToAppend);
                resultTable.update();
                return resultTable;
            }
        }
        else {
            for (Row row3:resultTable.rows){
                for (Row row2:table2.rows) {
                    Row rowToAppend = row2;
                    row3.append(rowToAppend);
                }
            }
            resultTable.update();
            return resultTable;
        }
    }

    private boolean haveColumnInCommon(List<Column> columns1, List<Column> columns2){
        for (Column column1:columns1){
            for (Column column2:columns2){
                if (column1.name.equals(column2.name)){
                    commonColumnName = column1.name;
                    return true;
                }
            }
        }
        return false;
    }
}
