package cs2410.assn8.View;

import javafx.scene.control.Button;

/**
 * Created by Raul on 12/7/2016.
 */
public class Cell extends Button{

    private int state = 1;
    public boolean isBomb;

    public Cell(boolean isBomb){

        this.isBomb = isBomb;
        this.setPrefHeight(20);
        this.setMinHeight(20);
        this.setPrefWidth(20);
        this.setMinWidth(20);
    }

    public void setState(){
        if(this.state == 3){
            this.state = 1;
            this.setText("");
        }
        else if(this.state == 2){
            this.setText("?");
            state++;
        }
        state++;
    }

}
