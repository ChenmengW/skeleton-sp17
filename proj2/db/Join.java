package db;
import java.util.*;
public class Join {
    Table table1;
    Table table2;
    List<String> commonColumns = new ArrayList<String>();


    Join(Table table1,Table table2){
        this.table1 = table1;
        this.table2 = table2;
    }

    Table conduct() {
        Table newTable = new Table();
        if (haveCommonColumn()) {
            return joinX();
        } else {
            return Cartesian();
        }
    }

    private boolean haveCommonColumn(){
        boolean b = false;
        List<String> list1 = table1.columns;
        List<String> list2 = table2.columns;
        for (String s1:list1){
            for (String s2:list2){
                if (s1.equals(s2)){
                    b = true;
                    commonColumns.add(s1);
                }
            }
        }
        return b;
    }

    private Table joinX(){
        /* This function will be used when there is common column.*/
    }

    private List<String> makeNewColumn(){
        List<String> newColumn = commonColumns;
        newColumn = columnWithout(table1.columns,commonColumns);
        newColumn.addAll(columnWithout(table2.columns,commonColumns));
        return newColumn;
    }

    private static List<String> columnWithout(List<String> list1, List<String> list2){
        for (String s1:list1){
            if (list2.contains(s1)){
                list1.remove(s1)
            }
        }
        return list1;
    }
    private Table Cartesian(){
        /* This function will be used when there is not common column.*/
    }
}
