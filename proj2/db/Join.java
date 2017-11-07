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
        for (Map.Entry<Integer,LinkedHashMap<String,String>> entry:table1.data.entrySet()){
            Integer i = 0;
            Integer rowNameInTable1 = entry.getKey();
            LinkedHashMap<String,String> dataOfRow = entry.getValue();
            String searchData = dataOfRow.get(commonColumns);
            if (findElementInColumn(searchData,commonColumns,table2)){
                Integer rowNameInTable2 = findRowName(searchData,commonColumns,table2);
                for (String columnName: joinedTable.columns){
                    if (i == 0) {
                        LinkedHashMap<String, String> ColumnAndData = new LinkedHashMap<String, String>();
                        ColumnAndData.put(columnName, lookForDataInBothTable(columnName, rowNameInTable1, rowNameInTable2));
                        joinedTable.data.put(rowNameInTable1, ColumnAndData);
                    }
                    else{
                        LinkedHashMap<String, String> ColumnAndData = new LinkedHashMap<String, String>();
                        String columnData = lookForDataInBothTable(columnName, rowNameInTable1, rowNameInTable2);
                        joinedTable.data.get(rowNameInTable1).put(columnName,columnData);
                    }
                    i += 1;

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
        List<String> toRemove = new ArrayList<>();
        for (String s1:list1){
            if (s.equals(s1)){
                toRemove.add(s1);
            }
        }
        list1.removeAll(toRemove);
        return list1;
    }
    private Table Cartesian(){
        /* This function will be used when there is not common column.*/
        List<String> newColumn = new ArrayList<>();
        newColumn.addAll(table1.columns);
        newColumn.addAll(table2.columns);
        HashMap<String,String> columnType = new HashMap();
        columnType.putAll(table1.columnType);
        columnType.putAll(table2.columnType);
        Table joinedTable = new Table("", newColumn, columnType);
        Integer i = 0;
        for (Map.Entry<Integer, LinkedHashMap<String, String>> entry1 : table1.data.entrySet())
        {
            Integer rowNameInTable1  = entry1.getKey();
            for (Map.Entry<Integer, LinkedHashMap<String, String>> entry2 : table2.data.entrySet())
            {
                Integer rowNameInTable2 = entry2.getKey();
                Integer j = 0;
                for (String columnName: joinedTable.columns) {
                    if (j ==0) {
                        LinkedHashMap<String, String> ColumnAndData = new LinkedHashMap<String, String>();
                        ColumnAndData.put(columnName, lookForDataInBothTable(columnName, rowNameInTable1, rowNameInTable2));
                        joinedTable.data.put(i, ColumnAndData);
                    }
                    else{
                        String columnData = lookForDataInBothTable(columnName, rowNameInTable1, rowNameInTable2);
                        joinedTable.data.get(i).put(columnName, columnData);
                    }
                    j += 1;
                }
                i += 1;
            }

        }
        return joinedTable;
    }

    private boolean findElementInColumn(String element, String columnName, Table table){
        for(Map.Entry<Integer,LinkedHashMap<String,String>> entry:table.data.entrySet())
        {
           String elementInData = entry.getValue().get(columnName);
           if (element.equals(elementInData)){
               return true;
           }
        }
        return false;
    }

    private Integer findRowName(String element, String columnName, Table table){
        for(Map.Entry<Integer,LinkedHashMap<String,String>> entry:table.data.entrySet())
        {
            String elementInData = entry.getValue().get(columnName);
            if (element.equals(elementInData)){
                return entry.getKey();
            }
        }
        return 0;
    }

    private String lookForDataInBothTable(String columnName,Integer rowInTable1,Integer rowInTable2){
        if (table1.columns.contains(columnName)) {
            for (Map.Entry<Integer, LinkedHashMap<String, String>> entry : table1.data.entrySet()) {
                if (entry.getKey().equals(rowInTable1)) {
                    return entry.getValue().get(columnName);
                }
            }
        }
        else {
            for (Map.Entry<Integer, LinkedHashMap<String, String>> entry : table2.data.entrySet()) {
                if (entry.getKey().equals(rowInTable2)) {
                    return entry.getValue().get(columnName);
                }
            }
        }
        return "error";
    }

}
