package db;
import java.util.ArrayList;
import java.util.List;
public class Join {
    public static Table joinTables(List<Table> tables){
    Table result = joinTwoTables(tables.get(0), tables.get(1));
        for (int i = 2; i < tables.size() ; i ++ ){
            result = joinTwoTables(result, tables.get(i));
        }
        return result;
    }
    private static Table joinTwoTables(Table table1, Table table2){
        if (table1.columns.get(0).name == table2.columns.get(0).name){
            /* to be continued*/
        }
    }
}
