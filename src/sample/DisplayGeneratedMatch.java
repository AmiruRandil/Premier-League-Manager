package sample;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayGeneratedMatch {

        public static void displayMatch(String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals, int homeTeamPoints, int awayTeamPoints, int year, int month, int day){
                Stage window = new Stage();
                window.initModality(Modality.APPLICATION_MODAL);

                Label homeTeamLabel = new Label("Home Team \n" + homeTeam);
                homeTeamLabel.setFont(Font.font("Helvetica nuee", FontWeight.BOLD, 20));
                homeTeamLabel.setStyle("-fx-text-fill: #fd5c63");

                Label awayTeamLabel = new Label("Away Team \n" + awayTeam);
                awayTeamLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
                awayTeamLabel.setStyle("-fx-text-fill: #6CB4EE");
                awayTeamLabel.setAlignment(Pos.CENTER_LEFT);

                Label hGoals = new Label("Goals Scored \n" + homeTeamGoals);
                hGoals.setFont(Font.font("Helvetica nuee", FontWeight.BOLD, 20));
                hGoals.setStyle("-fx-text-fill: #fd5c63");

                Label hPoints = new Label("Points \n" + homeTeamPoints);
                hPoints.setFont(Font.font("Helvetica nuee", FontWeight.BOLD, 20));
                hPoints.setStyle("-fx-text-fill: #fd5c63");

                VBox hTeam = new VBox(10);
                hTeam.getChildren().addAll(homeTeamLabel,hGoals, hPoints);
                hTeam.setAlignment(Pos.CENTER_LEFT);
//                hTeam.setMaxWidth(100);
                hTeam.setPadding(new Insets(30,200,30,30));

                Label aGoals = new Label("Goals Scored \n" + awayTeamGoals);
                aGoals.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
                aGoals.setStyle("-fx-text-fill: #6CB4EE");
                aGoals.setAlignment(Pos.CENTER_LEFT);

                Label aPoints = new Label("Points \n" + awayTeamPoints);
                aPoints.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
                aPoints.setStyle("-fx-text-fill: #6CB4EE");
                aPoints.setAlignment(Pos.CENTER_LEFT);

                VBox aTeam = new VBox(10);
                aTeam.getChildren().addAll(awayTeamLabel,aGoals, aPoints);
                aTeam.setAlignment(Pos.CENTER_LEFT);
//                aTeam.setMaxWidth(400);
                aTeam.setPadding(new Insets(30,30,30,540));

                HBox matchStats = new HBox(30);
                matchStats.getChildren().addAll(hTeam, aTeam);
                matchStats.setAlignment(Pos.CENTER);

                Label MDate = new Label("Date : " + day + "-" + month + "-" + year);
                MDate.setFont(Font.font("Helvetica nuee", FontWeight.BOLD, 20));
                MDate.setStyle("-fx-text-fill: #ffffff");
                MDate.setAlignment(Pos.BASELINE_RIGHT);
                MDate.setPadding(new Insets(0,500,435,0));

                StackPane stackPane = new StackPane();
                stackPane.setStyle("-fx-background-image: url('/sample/backgroundGeneratedMatch.jpg')");
                stackPane.getChildren().addAll(MDate, hTeam, aTeam);

                Scene scene = new Scene(stackPane, 700,500);
                window.setScene(scene);
                window.showAndWait();
        }
}
