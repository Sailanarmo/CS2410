

/*
package cs2410.assn7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*public class GUI {


	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		frame.setSize(500,150);
		frame.add(window);
		
		JComboBox dropBox = new JComboBox();
		JTextArea text = new JTextArea();
		
		window.add(dropBox);
		window.add(text);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.setResizable(false);
		

	}

}



public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 15, 10, 15));
		hBox.setSpacing(5);

		for (int i = 0; i < 20; i++) {
			hBox.getChildren().add(new Button("" + i));
		}

		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

*/

package cs2410.assn7;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

import java.util.ArrayList;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUI extends Application {

    private ArrayList<Race> list;
    private Text text = new Text("Hello");
    //GUI m = new GUI();

    public ArrayList<Race> getList() {
        return list;
    }


    public GUI() {

        //this.text = text;
        list = new ArrayList<Race>();
        Hobbit h1 = new Hobbit("Frodo", 136);
        list.add(h1);
        Hobbit h2 = new Hobbit("Gaffer", 100);
        list.add(h2);
        HourlyWorker hw1 = new HourlyWorker("Linda", 85, 10, 50);
        list.add(hw1);
        HourlyWorker hw2 = new HourlyWorker("Fred", 90, 7, 65);
        list.add(hw2);
        ContractWorker cw1 = new ContractWorker("Billy", 65, 75);
        list.add(cw1);
        ContractWorker cw2 = new ContractWorker("Sally", 90, 65);
        list.add(cw2);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        BorderPane mainPane = new BorderPane();
        HBox hBox = new HBox();

        initComboBoxes(hBox);
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        StackPane displayPane = new StackPane();
        displayPane.setPrefSize(400, 500);
        displayPane.getChildren().add(text);
        mainPane.setTop(hBox);
        mainPane.setCenter(displayPane);
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void initComboBoxes(Pane pane) {

        ComboBox<String> stringComboBox = new ComboBox<>();
        stringComboBox.getItems().addAll("Math", "Income", "Hours", "IQ", "Say", "Carrots", "Contracts");
        stringComboBox.setValue(stringComboBox.getItems().get(0));

        stringComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (stringComboBox.getValue() == ("Math")) {
                    text.setText("Do some Math yo.");
                    printMath();
                }
                if (stringComboBox.getValue() == "Income") {
                    text.setText("We are poor yo");
                    printIncome();
                }
                if (stringComboBox.getValue() == "Hours") {
                    text.setText("Do some more work yo.");
                    printHours();
                }
                if (stringComboBox.getValue() == "IQ") {
                    text.setText("You are smart yo.");
                    printIQ();
                }
                if (stringComboBox.getValue() == "Say") {
                    text.setText("Say Something yo");
                    printSay();
                }
                if (stringComboBox.getValue() == "Carrots") {
                    text.setText("Carrots yo");
                    printCarrots();
                }
                if (stringComboBox.getValue() == "Contracts") {
                    text.setText("I got a contract for you yo.");
                    printContracts();
                }
            }
        });

        Button hourly = new Button("Hourly");
        hourly.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("PLS");
            }
        });

        Button contract = new Button("Contract");
        contract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("Halp");
            }
        });

        Button hobbit = new Button("Hobbit");
        hobbit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("Ok");
            }
        });

        pane.getChildren().addAll(stringComboBox, hourly, contract, hobbit);
    }

//		dropBox.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent event) {
//		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
//		        String selected = (String) combo.getSelectedItem();
//
//		        if (selected.equals("Math")) {
//		            m.printMath();
//		        } else if (selected.equals("Income")) {
//		            m.printIncome();
//		        } else if (selected.equals("Hours")) {
//		            m.printHours();
//		        } else if (selected.equals("IQ")) {
//		            m.printIQ();
//		        } else if (selected.equals("Say")) {
//		            m.printSay();
//		        } else if (selected.equals("Carrots")) {
//		            m.printCarrots();
//		        } else if (selected.equals("Contracts")) {
//		            m.printContracts();
//		        }
//
//			}
//		});
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    frame.setLocationRelativeTo(null);
//	    frame.setVisible(true);
//	    frame.setResizable(false);
//	}

    public void printMath() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            Race s = (Race) list.get(i);
            fullText = fullText.concat(s.getName() + ": " + s.doMath() + "\n");
        }
        text.setText(fullText);
    }

    public void printIncome() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                Smarty s = (Smarty) list.get(i);
                fullText = fullText.concat(s.getName() + ": " + s.getIncome() + "\n");
            } catch (ClassCastException e) {

            }
        }
        text.setText(fullText);
    }

    public void printHours() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                HourlyWorker s = (HourlyWorker) list.get(i);
                fullText = fullText.concat(s.getName() + ": " + s.getHoursWorked() + "\n");
            } catch (ClassCastException e) {

            }
        }
        text.setText(fullText);

    }

    public void printIQ() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                Smarty s = (Smarty) list.get(i);
                fullText = fullText.concat(s.getName() + ": " + s.getIQ() + "\n");
            } catch (ClassCastException e) {

            }
        }
        text.setText(fullText);

    }

    public void printSay() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            Race s = (Race) list.get(i);
            fullText = fullText.concat(s.getName() + ": " + s.saySomethingSmart() + "\n");
        }
        text.setText(fullText);
    }

    public void printCarrots() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                Hobbit s = (Hobbit) list.get(i);
                fullText = fullText.concat(s.getName() + ": " + s.getCarrotsPicked() + "\n");
            } catch (ClassCastException e) {

            }
        }
        text.setText(fullText);

    }

    public void printContracts() {
        String fullText;
        fullText = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                ContractWorker s = (ContractWorker) list.get(i);
                fullText = fullText.concat(s.getName() + ": " + s.getContractsCompleted() + "\n");
            } catch (ClassCastException e) {

            }
        }
        text.setText(fullText);

    }
}