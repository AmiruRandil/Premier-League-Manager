package sample;
/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

import sample.LeagueManager;
import sample.SportsClub;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager {

        public static final int MAX_TEAMS = 20;
        private int count = 20;
        protected static List<SportsClub> premierLeague = new ArrayList<>();
        protected static List<Match> matchesPlayed = new ArrayList<>();

        public int getPremierLeagueSize(){
                return premierLeague.size();
        }

        public SportsClub getClub(int num){
                return premierLeague.get(num);
        }

        public List<Match> getMatchesPlayed() {
                return matchesPlayed;
        }

        public void setMatchesPlayed(List<Match> matchesPlayed) {
                this.matchesPlayed = matchesPlayed;
        }

        public List<SportsClub> getPremierLeague() {
                return premierLeague;
        }

        public void setPremierLeague(List<SportsClub> premierLeague) {
                this.premierLeague = premierLeague;
        }

        @Override
        public void addTeam(SportsClub club) {
                //checking if there's space in the Premier League
                if (count != 0) {
                        premierLeague.add(club);
                        count -= 1;
                        System.out.println("Remaining Slots in Premier League: " + count);
                        System.out.println();
                } else if (premierLeague.contains(club)) {
                        System.out.println("This club is already in the Premier League");
                } else {
                        System.out.println("Premier League can not have more than 20 teams");
                }
        }

        @Override
        public void deleteTeam(String clubName) {
                boolean found = false;
                SportsClub club = null;
                //checking if club in Premier league
                for (SportsClub fClub : premierLeague) {
                        if (fClub.getName().equals(clubName)) {
                                found = true;
                                club = fClub;
                        }
                }
                if (found){
                        count += 1;
                        premierLeague.remove(club);
                        System.out.println(club.getName() + " has been removed from the Premier League");
                }
                if (!found) {
                        System.out.println("Club Not Found");
                }
        }

        @Override
        public void displayClubStats(String clubName) {
                if (premierLeague.size() == 0){
                        System.out.println("No clubs in th Premier League");
                        return;
                }
                boolean found = false;
                for (SportsClub fClub : premierLeague) {
                        if (fClub.getName().equals(clubName)) {
                                System.out.printf("%-20s%-20s%-10s%-10s%-10s%-20s%-20s %n", "Club Name", "Club location",
                                        "Wins", "Draws", "Defeats", "Number of Points",
                                        "Goal Difference");
                                System.out.printf("%-20s%-20s%-10d%-10d%-10d%-20d%-20d %n", fClub.getName(),
                                        fClub.getLocation(), ((sample.FootballClub) fClub).getWins(),
                                        ((FootballClub) fClub).getDraws(), ((FootballClub) fClub).getDefeats(),
                                        ((FootballClub) fClub).getNumberOfPoints(),
                                        ((FootballClub) fClub).getGoalDifference());
                                found = true;
                        }
                }
                if (!found) {
                        System.out.println("No such team in the Premier league");
                }
        }

        @Override
        public void displayTableOfFootballClubs() {
                //checking if there are clubs in premier league
                if (premierLeague.size() == 0){
                        System.out.println("No clubs in the Premier League");
                        return;
                }
                List<SportsClub> sorted = new ArrayList<>();
                sorted.addAll(premierLeague);
                sorted.sort(Collections.reverseOrder());
                System.out.printf("%-20s%-20s%-10s%-10s%-10s%-20s%-20s %n", "Club Name", "Club location", "Wins",
                        "Draws", "Defeats", "Number of Points",
                        "Goal Difference");
                for (SportsClub club : sorted) {
                        System.out.printf("%-20s%-20s%-10d%-10d%-10d%-20d%-20d %n", club.getName(), club.getLocation(),
                                ((FootballClub) club).getWins(), ((FootballClub) club).getDraws(),
                                ((FootballClub) club).getDefeats(), ((FootballClub) club).getNumberOfPoints(),
                                ((FootballClub) club).getGoalDifference());
                }
        }

        @Override
        public boolean enterMatch(Match match) {
                boolean added = false;
                boolean home = false;
                boolean away = false;
                SportsClub homeT = null;
                SportsClub awayT = null;
                //checking if the clubs are available
                for (SportsClub club : premierLeague) {
                        if (match.getHomeTeam().equals(club.getName())) {
                                homeT = club;
                                home = true;
                        }
                }
                for (SportsClub club : premierLeague) {
                        if (match.getAwayTeam().equals(club.getName())) {
                                awayT = club;
                                away = true;
                        }
                }
                if (!home) {
                        System.out.println("Home team is not in Premier league");
                }
                if (!away) {
                        System.out.println("Away team is not in Premier league");
                }
                if (home && away) {
                        added = true;
                        update(homeT,awayT,match);
                        matchesPlayed.add(match);
                }
                return added;
        }

        public void update(SportsClub homeT, SportsClub awayT, Match match){
                //Home team
                ((FootballClub) homeT).setNumberOfGoalsScored(((FootballClub) homeT).getNumberOfGoalsScored() +
                        (match.getHomeTeamGoals()));
                ((FootballClub)homeT).setNumberOfGoalsReceived(((FootballClub)homeT).getNumberOfGoalsReceived()
                        + match.getAwayTeamGoals());
                ((FootballClub)homeT).setGoalDifference(((FootballClub)homeT).getGoalDifference() +
                        (match.getHomeGoalDifference()));
                ((FootballClub)homeT).setNumberOfPoints(((FootballClub)homeT).getNumberOfPoints() +
                        (match.getHomeTeamPoints()));
                //Away team
                ((FootballClub) awayT).setNumberOfGoalsScored(((FootballClub) awayT).getNumberOfGoalsScored() +
                        (match.getAwayTeamGoals()));
                ((FootballClub)awayT).setNumberOfGoalsReceived(((FootballClub)awayT).getNumberOfGoalsReceived()
                        + match.getHomeTeamGoals());
                ((FootballClub)awayT).setGoalDifference(((FootballClub)awayT).getGoalDifference() +
                        (match.getAwayGoalDifference()));
                ((FootballClub)awayT).setNumberOfPoints(((FootballClub)awayT).getNumberOfPoints() +
                        (match.getAwayTeamPoints()));
                ((FootballClub) homeT).setNumberOfMatchesPlayed(((FootballClub)homeT).getNumberOfMatchesPlayed() + 1);
                ((FootballClub) awayT).setNumberOfMatchesPlayed(((FootballClub)awayT).getNumberOfMatchesPlayed() + 1);
                //win/defeat/draw
                if (match.getHomeTeamGoals() > match.getAwayTeamGoals()){
                        ((FootballClub) homeT).setWins(((FootballClub)homeT).getWins() + 1);
                        ((FootballClub) awayT).setDefeats(((FootballClub)awayT).getDefeats() + 1);
                }
                else if (match.getHomeTeamGoals() < match.getAwayTeamGoals()){
                        ((FootballClub) homeT).setDefeats(((FootballClub)homeT).getDefeats() + 1);
                        ((FootballClub) awayT).setWins(((FootballClub)awayT).getWins() + 1);

                }else if (match.getHomeTeamGoals() == match.getAwayTeamGoals()){
                        ((FootballClub) homeT).setDraws(((FootballClub)homeT).getDraws() + 1);
                        ((FootballClub) awayT).setDraws(((FootballClub)awayT).getDraws() + 1);
                }
        }

        @Override
        public void save(String pLFile, String mPFile) throws IOException{
                //premier league
                FileOutputStream fileOutputStream = new FileOutputStream(pLFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (SportsClub sportsClub : premierLeague){
                        objectOutputStream.writeObject(sportsClub);
                }

                //matches played
                FileOutputStream fileOutputStream1 = new FileOutputStream(mPFile);
                ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
                for (Match match : matchesPlayed){
                        objectOutputStream1.writeObject(match);
                }
                objectOutputStream.flush();
                fileOutputStream.close();
                objectOutputStream.close();
                objectOutputStream1.flush();
                fileOutputStream1.close();
                objectOutputStream1.close();

        }

        @Override
        public void load(String pLFile, String mPFile) throws IOException, ClassNotFoundException {
                FileInputStream fileInputStream = new FileInputStream(pLFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                for (;;){
                        try {
                                SportsClub sportsClub = (SportsClub) objectInputStream.readObject();
                                premierLeague.add(sportsClub);

                        }catch (EOFException e){
                                break;
                        }
                }
                FileInputStream fileInputStream1 = new FileInputStream(mPFile);
                ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
                for (;;){
                        try {
                                Match match = (Match) objectInputStream1.readObject();
                                matchesPlayed.add(match);

                        }catch (EOFException e){
                                break;
                        }
                }
                fileInputStream.close();
                objectInputStream.close();
                fileInputStream1.close();
                objectInputStream1.close();
        }
}