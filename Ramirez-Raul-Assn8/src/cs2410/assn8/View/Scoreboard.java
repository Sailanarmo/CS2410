package cs2410.assn8.View;

import javafx.scene.layout.FlowPane;
import cs2410.assn8.View.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Raul on 12/7/2016.
 */
public class Scoreboard extends FlowPane {
    ArrayList<Cell> cells = new ArrayList<Cell>();

    private int bombs = 0;



    public void setSize(int height, int width, double difficulty){
        cells.clear();
        bombs = 0;
        for (int i = 0; i < height*width; ++i){
            if(bombs >= height * width * difficulty) {
                cells.add(new Cell(true));
                bombs++;
            }
            else {
                cells.add(new Cell(false));
            }
        }
        this.getChildren().addAll(cells);
    }


}
