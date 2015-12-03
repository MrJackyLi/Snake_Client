
package gui;

import sdk.Score;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Objects;



/**
 * Created by Jacky on 29/11/15.
 */


public class HighscoreTable extends AbstractTableModel {

    private ArrayList<Score> highscores;
    private String[] columns = {"Username","Score", "Game id"};
    private int numberOfRows;

    public HighscoreTable(ArrayList<Score> highscores) {

        this.highscores = highscores;
    }


    public int getColumnCount() {
        return columns.length;
    }
//identifier
    public Class<?> getColumnClass( int columnIndex){
        return super.getColumnClass(columnIndex);
    }

    public int getRowCount() {
        numberOfRows = highscores.size();
        return numberOfRows;
    }

    public String getColumnName(int columnIndex){
          return columns[columnIndex];
        }

    public Object getValueAt(int rowIndex, int coloumnIndex) {
        highscores.get(rowIndex);
        switch (coloumnIndex) {
            case 0:
                return highscores.get(rowIndex).getUser().getUsername();
            case 1:
                return highscores.get(rowIndex).getScore();
            case 2:
                return highscores.get(rowIndex).getGame().getGameId();
        }
        return null;
    }
}


