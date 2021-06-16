package sample;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

public class ConsoleApplication {
        static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        static Scanner sc = new Scanner(System.in);
        static Scanner sc1 = new Scanner(System.in);

        public static void console() throws IOException, ClassNotFoundException, InvocationTargetException {
                System.out.println("\nWELCOME TO PREMIER LEAGUE MANAGER. (2020/2021)\n");
                menu();
                //checking if the input is a number
                while (!sc.hasNextInt()) {
                        System.out.println("Invalid input");
                        System.out.println("Input should be a number");
                        System.out.print("Enter Input : ");
                        sc.next();
                }
                //checking if the input is in the range of 1 and 8
                int choice = sc.nextInt();
                if (choice > 8 || choice < 1) {
                        System.out.println("Invalid input");
                        System.out.println("input should be between 1 and 8");
                        System.out.println("Try again");
                        console();
                } else {
                        menuLoop:
                        switch (choice) {
                                case 1:
                                        addClub();
                                        console();
                                        break;
                                case 2:
                                        deleteClub();
                                        console();
                                        break;
                                case 3:
                                        displaySelectedClub();
                                        console();
                                        break;
                                case 4:
                                        premierLeagueManager.displayTableOfFootballClubs();
                                        console();
                                        break;
                                case 5:
                                        addMatch();
                                        console();
                                        break;
                                case 6:
                                        GUI.window.setIconified(false);
                                        break;
                                case 7:
                                        premierLeagueManager.save("premierLeagueFile.txt",
                                                "matchesPlayedFile.txt");
                                        System.out.println("Save ended");
                                        console();
                                        break ;
                                case 8:
                                        System.out.println("Thank you for using Premier League Manager");
                                        premierLeagueManager.save("premierLeagueFile.txt",
                                                "matchesPlayedFile.txt");
                                        GUI.window.close();
                                        break menuLoop;
                                default:
                                        System.out.print("invalid input \nPlease try again\nEnter selected option");
                        }
                }
//

        }

        //menu options method
        public static void menu() {
                System.out.print("MENU \n1 : Add a Football Club And Add It To The Premier League \n2 : Delete " +
                        "Football club from Premier league manager \n3 : Display statistics on a selected club \n" +
                        "4 : Display statistics of all the clubs \n5 : Enter a Match Played \n6 : Open GUI \n" +
                        "7 : Save \n8 : Exit Program \n" +
                        "Enter selected option : ");
        }

        //validating if the inputs are integers methods
        private static void validate(String message) {
                while (!sc.hasNextInt()) {
                        System.out.print("Invalid input \nInput should be a number\n" + message);
                        sc.next();
                }
        }

        private static void addClub() {
                System.out.print("Enter Club Name : ");
                String name = sc1.nextLine();
                if (name == null || name.equals("")){
                        System.out.println("Club name cant be empty");
                        addClub();
                }
                System.out.print("Enter club location : ");
                String location = sc1.nextLine();
                if (location == null || location.equals("")){
                        System.out.println("Club location cant be empty");
                        addClub();
                }
                System.out.print("Enter number of wins : ");
                validate("Enter number of wins");
                int wins = sc.nextInt();
                System.out.print("Enter number of draws : ");
                validate("Enter number of draws");
                int draws = sc.nextInt();
                System.out.print("Enter number of defeats : ");
                validate("Enter number of defeats");
                int defeats = sc.nextInt();
                System.out.print("Enter number of goals received : ");
                validate("Enter number of goals received");
                int numberOfGoalsReceived = sc.nextInt();
                System.out.print("Enter number of goals scored : ");
                validate("Enter number of goals scored");
                int numberOfGoalsScored = sc.nextInt();
                //calculating the number of matches played and number of points according to the users inputs
                int numberOfMatchesPlayed = wins + draws + defeats;
                int numberOfPoints = (wins*3) + (draws);
                int goalDifference = numberOfGoalsScored - numberOfGoalsReceived;
                SportsClub sportsClub = new FootballClub(name, location, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfMatchesPlayed,
                        numberOfPoints, goalDifference);
                premierLeagueManager.addTeam(sportsClub);
        }

        private static void deleteClub() {
                //checking if there clubs in the premier league
                if (premierLeagueManager.getPremierLeagueSize() == 0){
                        System.out.println("No clubs in th Premier League");
                        return;
                }
                System.out.print("Enter club name : ");
                String name = sc.next();
                premierLeagueManager.deleteTeam(name);
        }

        private static void displaySelectedClub() {
                //checking if there clubs in the premier league
                if (premierLeagueManager.getPremierLeagueSize() == 0){
                        System.out.println("No clubs in th Premier League");
                        return;
                }
                System.out.print("Enter club name : ");
                String name = sc.next();
                premierLeagueManager.displayClubStats(name);
        }

        private static void addMatch() {
                //checking if there's more than 2 clubs in the premier league
                if (premierLeagueManager.getPremierLeagueSize() < 2){
                        System.out.println("Premier League should have at least 2 clubs to adda match");
                        return;
                }
                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Enter Home team : ");
                String home = scanner2.nextLine();
                System.out.print("Enter Away team : ");
                String away = scanner2.nextLine();
                //checking if both clubs entered are the same
                if (home.equals(away)){
                        System.out.println("Home team and Away team can not be the same team\n Try again");
                        addMatch();
                }
                System.out.print("Enter goals scored  by home team : ");
                validate("Enter goals scored  by home team : ");
                int homeScored = sc.nextInt();
                System.out.print("Enter goals scored by away team : ");
                validate("Enter goals scored by away team : ");
                int awayScored = sc.nextInt();
                System.out.print("Enter year : ");
                validate("Enter year : ");
                int year = sc.nextInt();
                while (2021<year || year < 2020){
                        System.out.print("Invalid year\ntry again \nEnter year : ");
                        year = sc.nextInt();
                }
                System.out.print("Enter month : ");
                validate("Enter month : ");
                int month = sc.nextInt();
                while (12<month || month < 1){
                        System.out.print("Invalid month\ntry again \nEnter month : ");
                        validate("Enter month : ");
                        month = sc.nextInt();
                }
                System.out.print("Enter day : ");
                validate("Enter day : ");
                int day = sc.nextInt();
                while (30<day || day < 1){
                        System.out.print("Invalid number of day\ntry again \nEnter day : ");
                        day = sc.nextInt();
                }
                int homePoints = 0;
                int awayPoints = 0;
                if (homeScored > awayScored){
                        homePoints = 3;
                }
                else if (awayScored > homeScored){
                        awayPoints = 3;

                }else if (homeScored == awayScored){
                        homePoints = 1;
                        awayPoints = 1;
                }
                int homeDifference = homeScored - awayScored;
                int awayDifference = awayScored - homeScored;
                Match match = new Match(home, away, homeScored, awayScored, homeDifference, awayDifference, homePoints, awayPoints, year, month, day);
                if (premierLeagueManager.enterMatch(match)) {
                        System.out.println("Matched added");
                } else {
                        System.out.println("Try again");
                }
        }
}

