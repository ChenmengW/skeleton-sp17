package db;
import java.util.*;
public class Join {
    Table table1;
    Table table2;
    String commonColumns;
    int commonColumnIndex;


    Join(Table table1,Table table2){
        this.table1 = table1;
        this.table2 = table2;
    }

    Table conduct() {
        if (haveCommonColumn()) {
            return joinX();
        } else {
            return Cartesian();
        }
    }

    private boolean haveCommonColumn(){
        /* check is there is a common column and save it in commonColumns */
        boolean b = false;
        int i = 0;
        List<String> list1 = table1.columns;
        List<String> list2 = table2.columns;
        for (String s1:list1){
            for (String s2:list2){
                if (s1.equals(s2)){
                    b = true;
                    commonColumns =s1;
                    commonColumnIndex = i;
                }
            }
            i += 1;
        }
        return b;
    }

    private Table joinX(){
        /* This function will be used when there is common column.*/
        List<String> newColumn = makeNewColumn();
        HashMap<String,String> columnType = new HashMap();
        columnType.putAll(table1.columnType);
        columnType.putAll(table2.columnType);
        Table joinedTable = new Table("", newColumn, columnType);
        for (Map.Entry<String,LinkedHashMap<String,String>> entry:table1.data.entrySet()){
            String rowNameInTable1 = entry.getKey();
            LinkedHashMap<String,String> dataOfRow = entry.getValue();
            String searchData = dataOfRow.get(commonColumns);
            if (findElementInColumn(searchData,commonColumns,table2){
                String rowNameInTable2 = findRowName(searchData,commonColumns,table2);
                for (String columnName: joinedTable.columns){
                    LinkedHashMap<String,String> ColumnAndData = new LinkedHashMap<String,String>();
                    ColumnAndData.put(columnName,lookForDataInBothTable(columnName,rowNameInTable1,rowNameInTable2));
                    joinedTable.data.put(rowNameInTable1, ColumnAndData);
                }
            }
        }
        return joinedTable;
    }

    private List<String> makeNewColumn(){
        List<String> newColumn = new ArrayList<String>();
        newColumn.add(commonColumns);
        newColumn.addAll(columnWithout(table1.columns,commonColumns));
        newColumn.addAll(columnWithout(table2.columns,commonColumns));
        return newColumn;
    }



    private static List<String> columnWithout(List<String> list1, String s){
        for (String s1:list1){
            if (s.equals(s1)){
                list1.remove(s1);
            }
        }
        return list1;
    }
    private Table Cartesian(){
        /* This function will be used when there is not common column.*/
        List<String> newColumn = new ArrayList<>();
        HashMap<String,String> columnType = new HashMap();
        columnType.putAll(table1.columnType);
        columnType.putAll(table2.columnType);
        Table joinedTable = new Table("", newColumn, columnType);
       /* to be continued*/
    }

    private boolean findElementInColumn(String element, String columnName, Table table){
        for(Map.Entry<String,LinkedHashMap<String,String>> entry:table.data.entrySet())
        {
           String elementInData = entry.getValue().get(columnName);
           if (element.equals(elementInData)){
               return true;
           }
        }
        return false;
    }

    private String findRowName(String element, String columnName, Table table){
        for(Map.Entry<String,LinkedHashMap<String,String>> entry:table.data.entrySet())
        {
            String elementInData = entry.getValue().get(columnName);
            if (element.equals(elementInData)){
                return entry.getKey();
            }
        }
        return "error";
    }

    private String lookForDataInBothTable(String columnName,String rowInTable1,String rowInTable2){
        if (table1.columns.contains(columnName)) {
            for (Map.Entry<String, LinkedHashMap<String, String>> entry : table1.data.entrySet()) {
                if (entry.getKey().equals(rowInTable1)) {
                    return entry.getValue().get(columnName);
                }
            }
        }
        else {
            for (Map.Entry<String, LinkedHashMap<String, String>> entry : table2.data.entrySet()) {
                if (entry.getKey().equals(rowInTable2)) {
                    return entry.getValue().get(columnName);
                }
            }
        }
        return "error";
    }

}
