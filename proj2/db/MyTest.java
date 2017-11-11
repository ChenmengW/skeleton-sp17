package db;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    @Test
    public void testOfJoin(){
        Table fans = makeTableFans();
        Table teams = makeTableTeams();
        Join join = new Join(fans,teams);
        Table actualJoinedTable = join.conduct();
        Table expected = makeTableJoined();
        expected.printTable();
        actualJoinedTable.printTable();
    }

    @Test
    public void testOfCartesian(){
        Table fans2 = makeTableFans2();
        Table teams = makeTableTeams();
        Join join = new Join(fans2,teams);
        Table actualJoinedTable = join.conduct();
        actualJoinedTable.printTable();
    }


    private List<String> makeRow(String[] elements){
        ArrayList<String> columns = new ArrayList();
        columns.addAll(Arrays.asList(elements));
        return columns;
    }

    private Table makeTableFans(){
        String[] column1 = {"Lastname", "Firstname", "TeamName"};
        List<String> fanColumns = makeRow(column1);
        Table fans = new Table("fans", fanColumns);

        String[] row1elements = {"Lee",	"Maurice","Mets"};
        List<String> row1 = makeRow(row1elements);
        String[] row2elements = {"Lee",	"Maurice","Steelers"};
        List<String> row2 = makeRow(row2elements);
        String[] row3elements = {"Ray",	"Mitas","Patriots"};
        List<String> row3 = makeRow(row3elements);
        fans.insertIntoTable(row1);
        fans.insertIntoTable(row2);
        fans.insertIntoTable(row3);
        return fans;
    }

    private Table makeTableFans2() {
        String[] column1 = {"Lastname", "Firstname", "A"};
        List<String> fanColumns = makeRow(column1);
        Table fans = new Table("fans", fanColumns);

        String[] row1elements = {"Lee", "Maurice", "Mets"};
        List<String> row1 = makeRow(row1elements);
        String[] row2elements = {"Lee", "Maurice", "Steelers"};
        List<String> row2 = makeRow(row2elements);
        String[] row3elements = {"Ray", "Mitas", "Patriots"};
        List<String> row3 = makeRow(row3elements);
        fans.insertIntoTable(row1);
        fans.insertIntoTable(row2);
        fans.insertIntoTable(row3);
        return fans;
    }

    private Table makeTableTeams(){
        String[] column1 = {"TeamName", "City"};
        List<String> teamsColumns = makeRow(column1);
        Table teams = new Table("teams", teamsColumns);

        String[] row1elements = {"Mets",	"New York"};
        List<String> row1 = makeRow(row1elements);
        String[] row2elements = {"Steelers","Pittsburgh"};
        List<String> row2 = makeRow(row2elements);
        String[] row3elements = {"Patriots","New England"};
        List<String> row3 = makeRow(row3elements);
        teams.insertIntoTable(row1);
        teams.insertIntoTable(row2);
        teams.insertIntoTable(row3);
        return teams;
    }

    private Table makeTableJoined(){
        String[] column1 = {"TeamName ", "Lastname", "Firstname","City"};
        List<String> teamsColumns = makeRow(column1);
        Table teams = new Table("teams", teamsColumns);

        String[] row1elements = {"Mets","Lee","Maurice","New York"};
        List<String> row1 = makeRow(row1elements);
        String[] row2elements = {"Steelers","Lee","Maurice","Pittsburgh"};
        List<String> row2 = makeRow(row2elements);
        String[] row3elements = {"Patriots","Ray",	"Mitas","New England"};
        List<String> row3 = makeRow(row3elements);
        teams.insertIntoTable(row1);
        teams.insertIntoTable(row2);
        teams.insertIntoTable(row3);
        return teams;
    }


