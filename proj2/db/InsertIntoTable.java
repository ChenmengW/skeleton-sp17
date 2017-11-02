package db;

public class InsertIntoTable implements Command{

    public static String conduct(Table table, Column column){
        table.columns.add(column);
        table.chm.put(column.name, column);
        table.rows = table.makeRows();
        return "";
    };
}
