package sample;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GUI extends Application {
    protected static List<Match> matchArrayListGUI = new ArrayList<>();
    protected static List<SportsClub> clubArrayListGUI = new ArrayList<>();
    public static PremierLeagueManager manager = new PremierLeagueManager();
    public static Stage window;
    Scene menu;
    Scene clubTable;
    Scene matchTable;
    TableView<Match> matchTableView;
    TableView<SportsClub> footballClubTableView;
    ConsoleApplication consoleApplication = new ConsoleApplication();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("loading...");
        try {
            manager.load("premierLeagueFile.txt", "matchesPlayedFile.txt");
            System.out.println("Files Successfully Loaded");
        }catch (FileNotFoundException e){
            new File("premierLeagueFile.txt");
            new File("matchesPlayedFile.txt");
            System.out.println("New Files Created");
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        displayMatchesPlayed(true, false);
        displayPremierLeague(true, false);
        displayGUI(true);
    }

    public void displayGUI(boolean show) throws IOException, ClassNotFoundException, InvocationTargetException {

        //display Premier league table button
        Button premierLeagueTableButton = new Button("Display Premier League table");
        premierLeagueTableButton.setFont(Font.font("Helvetica nuee"));
        premierLeagueTableButton.setOnAction( e ->{
            //checking if there are any clubs in the premier league to display
            if (manager.getPremierLeagueSize() == 0){
                System.out.println("No clubs in Premier League");
                return;
            }
            window.setScene(clubTable);
            try {
                displayPremierLeague(false, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            window.setIconified(false);
        });

        //Display matches played table button
        Button matchesPlayedTableButton = new Button("Display Matches Played table");
        matchesPlayedTableButton.setFont(Font.font("Helvetica nuee"));
        matchesPlayedTableButton.setOnAction( e ->{
            //checking if there are any matches played to display
            if (manager.getMatchesPlayed().size() == 0){
                System.out.println("Not matches played yet");
                return;
            }
            window.setScene(matchTable);
            displayMatchesPlayed(false, true);
            window.setIconified(false);
        });

        //generate random match
        Button generateRandomMatchButton = new Button("Generate Random Match");
        generateRandomMatchButton.setFont(Font.font("Helvetica nuee"));
        generateRandomMatchButton.setOnAction( e ->{
            //checking if there are enough clubs in generate a match
            if (manager.getPremierLeagueSize() < 2){
                System.out.println("Not enough clubs in Premier League to generate a match");
                return;
            }
            generateMatch();
        });

        //back to menu button
        Button backToMenuButton = new Button("Back to menu");
        backToMenuButton.setFont(Font.font("Helvetica nuee"));
        backToMenuButton.setOnAction( e ->{
            window.setIconified(true);
            try {
                ConsoleApplication.console();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
        });

        //menu layout
        VBox menuVBox = new VBox(30);

        premierLeagueTableButton.setMaxWidth(200);
        matchesPlayedTableButton.setMaxWidth(200);
        generateRandomMatchButton.setMaxWidth(200);
        backToMenuButton.setMaxWidth(200);

        premierLeagueTableButton.setStyle("-fx-background-color: #d77452");
        matchesPlayedTableButton.setStyle("-fx-background-color: #d77452");
        generateRandomMatchButton.setStyle("-fx-background-color: #d77452");
        backToMenuButton.setStyle("-fx-background-color: #d77452");

        menuVBox.getChildren().addAll(premierLeagueTableButton,matchesPlayedTableButton,generateRandomMatchButton,backToMenuButton);

        menuVBox.setAlignment(Pos.BOTTOM_RIGHT);
        menuVBox.setPadding(new Insets(50));

        //Combining everything together
        StackPane stackPaneMenu = new StackPane();
        stackPaneMenu.getChildren().addAll(menuVBox);
        menu = new Scene(stackPaneMenu, 1050, 500);
        window.setScene(menu);
        stackPaneMenu.setStyle("-fx-background-image: url('/sample/background_image.jpg')");
        window.setTitle("Premier League Manager");
        window.show();
        window.setResizable(false);
        window.setIconified(show);
        if (show){
            consoleApplication.console();
        }
    }

    public void generateMatch(){
        SportsClub homeTeam;
        SportsClub awayTeam;
        int c1;
        int c2;

        //Generating 2 random number that aren't equal to each other
        c1 = (int) (Math.random() * (manager.getPremierLeagueSize()));
        {
            c2 = (int) (Math.random() * (manager.getPremierLeagueSize()));
            while (c1 == c2){
                c2 = (int) (Math.random() * (manager.getPremierLeagueSize()));
            }
        }
        if (manager.getPremierLeagueSize() == 0){
            System.out.println("No clubs in premier League");
            return;
        }
        homeTeam = manager.getClub(c1);
        awayTeam = manager.getClub(c2);
        String homeTeamName = homeTeam.getName();
        String awayTeamName = awayTeam.getName();
        //Generating random scores for each team
        int homeTeamGoals = (int) (Math.random() * 11);
        int awayTeamGoals = (int) (Math.random() * 11);
        int homeGoalDifference = homeTeamGoals - awayTeamGoals;
        int awayGoalDifference = awayTeamGoals - homeTeamGoals;
        int homeTeamPoints = 0;
        int awayTeamPoints = 0;
        //Assigning points according to goals scored
        if (homeTeamGoals > awayTeamGoals){
            homeTeamPoints = 3;
        }
        else if (awayTeamGoals > homeTeamGoals){
            awayTeamPoints = 3;

        }else if (homeTeamGoals == awayTeamGoals){
            homeTeamPoints = 1;
            awayTeamPoints = 1;
        }
        //generating a random date
        int day = (int) (Math.random() * (30 - 1) + 1);
        int month = (int) (Math.random() * (12 - 1) + 1);
        int year = (int) (Math.random() * (2022 - 2020) + 2020);
        Match match = new Match(homeTeamName, awayTeamName, homeTeamGoals, awayTeamGoals, homeGoalDifference,
                awayGoalDifference, homeTeamPoints, awayTeamPoints, year, month, day);
        manager.enterMatch(match);
        DisplayGeneratedMatch.displayMatch(match.getHomeTeam(), match.getAwayTeam(), match.getHomeTeamGoals(), match.getAwayTeamGoals(),
                match.getHomeTeamPoints(), match.getAwayTeamPoints(), match.getYear(), match.getMonth(), match.getDay());
    }

    public void displayPremierLeague(boolean show, boolean get) throws IOException, ClassNotFoundException, InvocationTargetException{
        if (get){
            clubArrayListGUI.addAll(manager.getPremierLeague());
            Collections.sort(clubArrayListGUI, new PointsComparator().reversed());
        }
        //Sorting drop down menu
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Ordered By Number Of Points", "Ordered By Number Of Goals Scored", "Ordered By Number Of Wins");
        comboBox.setValue("Ordered By Number Of Points");
        comboBox.setStyle("-fx-background-color: #d77452");
        //Sort Button
        Button sortButton = new Button("Sort");
        sortButton.setMinWidth(100);
        sortButton.setFont(Font.font("Helvetica nuee"));
        sortButton.setStyle("-fx-background-color: #d77452");
        sortButton.setOnAction(e -> {
            String choice = getChoice(comboBox);
            if (choice.equals("Ordered By Number Of Points")){
                Collections.sort(clubArrayListGUI, new PointsComparator().reversed());
                try {
                    displayPremierLeague(false, false);
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }
            }else if (choice.equals("Ordered By Number Of Goals Scored")){
                Collections.sort(clubArrayListGUI, new GoalsComparator().reversed());
                try {
                    displayPremierLeague(false,false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }
            }else if (choice.equals("Ordered By Number Of Wins")){
                Collections.sort(clubArrayListGUI, new winsComparator().reversed());
                try {
                    displayPremierLeague(false,false);
                } catch (IOException | ClassNotFoundException | InvocationTargetException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        HBox sortingHBoc = new HBox(10);
        sortingHBoc.getChildren().addAll(comboBox,sortButton);

        //Back to menu button
        Button back = new Button("Back To Menu");
        back.setFont(Font.font("Helvetica nuee"));
        back.setStyle("-fx-background-color: #d77452");
        back.setOnAction(e ->{
            clubArrayListGUI.clear();
            window.setScene(menu);
        });

        //Creating the table
        viewingFootballClubTable();
        //Combining everything together
        VBox vBox = new VBox(10);
        footballClubTableView.setOpacity(0.7);
        vBox.getChildren().addAll(sortingHBoc,footballClubTableView,back);
        vBox.setPadding(new Insets(10));
        StackPane stackPanePL = new StackPane();
        stackPanePL.setStyle("-fx-background-image: url('/sample/background_image.jpg')");
        stackPanePL.getChildren().addAll(vBox);
        clubTable = new Scene(stackPanePL, 1050, 500);
        window.setScene(clubTable);
        window.setTitle("Premier League Manager");
        window.show();
        window.setResizable(false);
        window.setIconified(show);
    }

    public void displayMatchesPlayed(boolean show, boolean get){

        if (get){
            matchArrayListGUI.addAll(manager.getMatchesPlayed());
        }
        //date label
        Label label = new Label("Enter Date (DD-MM-YYYY)");
        label.setStyle("-fx-text-fill: #d77452");
        label.setFont(Font.font("Helvetica nuee", FontWeight.BOLD, 20));
        //Input field for date
        TextField inputDate = new TextField();
        inputDate.setPromptText("DD-MM-YYYY");
        inputDate.setMaxWidth(120);
        //search button
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #d77452");
        searchButton.setFont(Font.font("Helvetica nuee"));
        searchButton.setOnAction(e ->{
            matchArrayListGUI.clear();
            matchArrayListGUI.addAll(manager.getMatchesPlayed());
            boolean correct = false;
            int year = 0;
            int month = 0;
            int day = 0;
//            isInt(inputDate, inputDate.getText());
            String strDate = inputDate.getText();
            String [] date;
            date = strDate.split("-");
            try {
                day = Integer.parseInt(date[0]);
                month = Integer.parseInt(date[1]);
                year = Integer.parseInt(date[2]);
                if (30<=day || day <= 1 && 12<=month || month <= 1 && 2021<=year || year <=2020 && date[2].length() == 4){
                    correct = true;
                }else {
                    System.out.println("Error In Date");
                }
            }catch (Exception a){
                System.out.println("You have not Entered the date properly\n Please try again");
            }
            if (correct){
                int minutes = (year * 365 * 24 * 60) + (month * 30 * 24 * 60) + (day * 24 * 60);
                for (int i = 0; i < matchArrayListGUI.size(); i++){
                    int matchMins = getMins(matchArrayListGUI.get(i).getYear(),matchArrayListGUI.get(i).getMonth(),matchArrayListGUI.get(i).getDay());
                    if (matchMins != minutes){
                        matchArrayListGUI.remove(i);
                        i--;
                    }
                }
                displayMatchesPlayed(false, false);
            }

        });
        //back to menu button
        Button back = new Button("Back To Menu");
        back.setFont(Font.font("Helvetica nuee"));
        back.setStyle("-fx-background-color: #d77452");
        back.setOnAction(e ->{
            matchArrayListGUI.clear();
            window.setScene(menu);
        });

        //sort button
        Button sort = new Button("Sort According To Date");
        sort.setStyle("-fx-background-color: #d77452");
        sort.setOnAction(e -> {
            Collections.sort(matchArrayListGUI);
            displayMatchesPlayed(false,false);
        });

        //combining everything together
        HBox search = new HBox(10);
        search.getChildren().addAll(inputDate, searchButton);
        viewingMatchesPlayedTable();
        VBox v = new VBox(10);
        v.getChildren().addAll(label, search, sort, matchTableView, back);
        matchTableView.setOpacity(0.7);
        v.setPadding(new Insets(60));
        StackPane stackPaneMP = new StackPane();
        stackPaneMP.setStyle("-fx-background-image: url('/sample/background_image.jpg')");
        stackPaneMP.getChildren().addAll(v);
        matchTable = new Scene(stackPaneMP, 1050, 500);
        window.setScene(matchTable);
        window.setTitle("Premier League Manager");
        window.show();
        window.setResizable(false);
        window.setIconified(show);
    }

    //get time in minutes method
    private int getMins(int year, int month, int day){
        int minutes = (year * 365 * 24 * 60) + (month * 30 * 24 * 60) + (day * 24 * 60);
        return minutes;
    }

    //get selected choice method
    private String getChoice(ComboBox<String> comboBox) {
        return comboBox.getValue();
    }

    //Getting matches played list
    public ObservableList<Match> getMatch(){
        ObservableList<Match> matchObservableList = FXCollections.observableArrayList();
        matchObservableList.addAll(matchArrayListGUI);
        return matchObservableList;
    }

    //getting premier league list
    public ObservableList<SportsClub> getClub(){
        ObservableList<SportsClub> clubObservableList = FXCollections.observableArrayList();
        clubObservableList.addAll(clubArrayListGUI);
        return clubObservableList;
    }

    //creating matches played table method
    public void viewingMatchesPlayedTable(){
        TableColumn<Match, String> homeTeam = new TableColumn<>("Home Team");
        homeTeam.setMaxWidth(150);
        homeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));

        TableColumn<Match, String> awayTeam = new TableColumn<>("Away Team");
        awayTeam.setMaxWidth(150);
        awayTeam.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));

        TableColumn<Match, String> homeTeamGoals = new TableColumn<>("Home team Goals");
        homeTeamGoals.setMinWidth(50);
        homeTeamGoals.setCellValueFactory(new PropertyValueFactory<>("homeTeamGoals"));

        TableColumn<Match, String> awayTeamGoals = new TableColumn<>("Away Team Goals");
        awayTeamGoals.setMinWidth(50);
        awayTeamGoals.setCellValueFactory(new PropertyValueFactory<>("awayTeamGoals"));

        TableColumn<Match, String> homeTeamPoints = new TableColumn<>("Home Team Points");
        homeTeamPoints.setMinWidth(50);
        homeTeamPoints.setCellValueFactory(new PropertyValueFactory<>("homeTeamPoints"));

        TableColumn<Match, String> awayTeamPoints = new TableColumn<>("Away Team Points");
        awayTeamPoints.setMinWidth(50);
        awayTeamPoints.setCellValueFactory(new PropertyValueFactory<>("awayTeamPoints"));

        TableColumn<Match, String> year = new TableColumn<>("Year");
        year.setMinWidth(50);
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Match, String> month = new TableColumn<>("Month");
        month.setMinWidth(50);
        month.setCellValueFactory(new PropertyValueFactory<>("month"));

        TableColumn<Match, String> day = new TableColumn<>("Day");
        day.setMinWidth(50);
        day.setCellValueFactory(new PropertyValueFactory<>("day"));

        matchTableView = new TableView<>();
        matchTableView.setItems(getMatch());
        matchTableView.getColumns().addAll(homeTeam,awayTeam,homeTeamGoals,awayTeamGoals,homeTeamPoints,awayTeamPoints,year,month,day);
        matchTableView.setMaxWidth(790);
    }

    //creating premier league table method
    public void viewingFootballClubTable(){
        TableColumn<SportsClub, String> name = new TableColumn<>("Club name");
        name.setMinWidth(50);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SportsClub, String> location = new TableColumn<>("Club location");
        location.setMinWidth(50);
        location.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<SportsClub, String> wins = new TableColumn<>("Wins");
        wins.setMinWidth(50);
        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<SportsClub, String> draws = new TableColumn<>("Draws");
        draws.setMinWidth(50);
        draws.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<SportsClub, String> defeats = new TableColumn<>("Defeats");
        defeats.setMinWidth(50);
        defeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        TableColumn<SportsClub, String> numberOfGoalsReceived = new TableColumn<>("Number of goals received");
        numberOfGoalsReceived.setMinWidth(50);
        numberOfGoalsReceived.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        TableColumn<SportsClub, String> numberOfGoalsScored = new TableColumn<>("Number of goals scored");
        numberOfGoalsScored.setMinWidth(50);
        numberOfGoalsScored.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        TableColumn<SportsClub, String> numberOfMatchesPlayed = new TableColumn<>("Number of matches played");
        numberOfMatchesPlayed.setMinWidth(50);
        numberOfMatchesPlayed.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));

        TableColumn<SportsClub, String> numberOfPoints = new TableColumn<>("Number of points");
        numberOfPoints.setMinWidth(50);
        numberOfPoints.setCellValueFactory(new PropertyValueFactory<>("numberOfPoints"));

        TableColumn<SportsClub, String> goalDifference = new TableColumn<>("Goal difference");
        goalDifference.setMinWidth(50);
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));

        footballClubTableView = new TableView<>();
        footballClubTableView.setItems(getClub());
        footballClubTableView.getColumns().addAll(name,location,wins,draws,defeats,numberOfGoalsReceived,numberOfGoalsScored,numberOfMatchesPlayed,numberOfPoints,goalDifference);
        footballClubTableView.setMaxWidth(1018);
    }
}