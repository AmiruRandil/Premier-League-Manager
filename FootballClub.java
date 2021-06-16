package sample;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {

        private int wins;
        private int draws;
        private int defeats;
        private int numberOfGoalsReceived;
        private int numberOfGoalsScored;
        private int numberOfMatchesPlayed;
        private int numberOfPoints;
        private int goalDifference;

        public FootballClub() {     //default constructor
        }

        public FootballClub(int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfMatchesPlayed, int numberOfPoints,
                            int goalDifference) {
                this.wins = wins;
                this.draws = draws;
                this.defeats = defeats;
                this.numberOfGoalsReceived = numberOfGoalsReceived;
                this.numberOfGoalsScored = numberOfGoalsScored;
                this.numberOfMatchesPlayed = numberOfMatchesPlayed;
                this.numberOfPoints = numberOfPoints;
                this.goalDifference = goalDifference;
        }

        public FootballClub(String name, String location, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored,
                            int numberOfMatchesPlayed, int numberOfPoints, int goalDifference) {
                super(name, location);
                this.wins = wins;
                this.draws = draws;
                this.defeats = defeats;
                this.numberOfGoalsReceived = numberOfGoalsReceived;
                this.numberOfGoalsScored = numberOfGoalsScored;
                this.numberOfMatchesPlayed = numberOfMatchesPlayed;
                this.numberOfPoints = numberOfPoints;
                this.goalDifference = goalDifference;
        }

        // getters and setters for the variables
        public int getWins() {
                return wins;
        }

        public void setWins(int wins) {
                this.wins = wins;
        }

        public int getDraws() {
                return draws;
        }

        public void setDraws(int draws) {
                this.draws = draws;
        }

        public int getDefeats() {
                return defeats;
        }

        public void setDefeats(int defeats) {
                this.defeats = defeats;
        }

        public int getNumberOfGoalsReceived() {
                return numberOfGoalsReceived;
        }

        public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
                this.numberOfGoalsReceived = numberOfGoalsReceived;
        }

        public int getNumberOfGoalsScored() {
                return numberOfGoalsScored;
        }

        public void setNumberOfGoalsScored(int numberOfGoalsScored) {
                this.numberOfGoalsScored = numberOfGoalsScored;
        }

        public int getNumberOfMatchesPlayed() {
                return numberOfMatchesPlayed;
        }

        public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
                this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        }

        public int getNumberOfPoints() {
                return numberOfPoints;
        }

        public void setNumberOfPoints(int numberOfPoints) {
                this.numberOfPoints = numberOfPoints;
        }

        public int getGoalDifference() {
                return goalDifference;
        }

        public void setGoalDifference(int goalDifference) {
                this.goalDifference = goalDifference;
        }

        @Override
        public String toString() {
                return "Football Club - " +
                        super.toString() +
                        "Wins=" + wins +
                        ", Draws=" + draws +
                        ", Defeats=" + defeats +
                        ", Number Of Goals Received=" + numberOfGoalsReceived +
                        ", Number Of Goals Scored=" + numberOfGoalsScored +
                        ", Number Of Matches Played=" + numberOfMatchesPlayed +
                        ", Number Of Points=" + numberOfPoints +
                        ", Goal Difference=" + goalDifference +
                        " \n";
        }

        //equals method
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                FootballClub club = (FootballClub) o;
                return wins == club.wins &&
                        draws == club.draws &&
                        defeats == club.defeats &&
                        numberOfGoalsReceived == club.numberOfGoalsReceived &&
                        numberOfGoalsScored == club.numberOfGoalsScored &&
                        numberOfMatchesPlayed == club.numberOfMatchesPlayed &&
                        numberOfPoints == club.numberOfPoints &&
                        goalDifference == club.goalDifference;
        }

        @Override
        public int hashCode() {
                return Objects.hash(super.hashCode(), wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfMatchesPlayed, numberOfPoints, goalDifference);
        }

        @Override
        public int compareTo(FootballClub o) {
                if (this.getNumberOfPoints() - o.getNumberOfPoints() != 0) {
                        return this.getNumberOfPoints() - o.getNumberOfPoints();
                } else
                        return this.getGoalDifference() - o.getGoalDifference();
        }

        public int comparePoints(FootballClub o){
                return this.getNumberOfPoints() - o.getNumberOfPoints();
        }

        public int compareGoals(FootballClub o){
                return this.getNumberOfGoalsScored() - o.getNumberOfGoalsScored();
        }

        public int compareWins(FootballClub o){
                return this.getWins() - o.getWins();
        }
}

