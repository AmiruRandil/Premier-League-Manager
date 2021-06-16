package sample;

import java.io.Serializable;
import java.util.Objects;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

public class Match implements Comparable<Match>, Serializable {

        private String homeTeam;
        private String awayTeam;
        private int homeTeamGoals;
        private int awayTeamGoals;
        private int homeGoalDifference;
        private int awayGoalDifference;
        private int homeTeamPoints;
        private int awayTeamPoints;
        private int year;
        private int month;
        private int day;



        public Match() {

        }

        public Match(String homeTeam, String awayTeam, int numberOfGoalsScored, int numberOfGoalsReceived, int homeGoalDifference, int awayGoalDifference, int homeTeamPoints, int awayTeamPoints,
                     int year, int month, int day) {
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                this.homeTeamGoals = numberOfGoalsScored;
                this.awayTeamGoals = numberOfGoalsReceived;
                this.homeGoalDifference = homeGoalDifference;
                this.awayGoalDifference = awayGoalDifference;
                this.homeTeamPoints = homeTeamPoints;
                this.awayTeamPoints = awayTeamPoints;
                this.year = year;
                this.month = month;
                this.day = day;
        }

        public String getHomeTeam() {
                return homeTeam;
        }

        public void setHomeTeam(String homeTeam) {
                this.homeTeam = homeTeam;
        }

        public String getAwayTeam() {
                return awayTeam;
        }

        public void setAwayTeam(String awayTeam) {
                this.awayTeam = awayTeam;
        }

        public int getHomeTeamGoals() {
                return homeTeamGoals;
        }

        public void setHomeTeamGoals(int homeTeamGoals) {
                this.homeTeamGoals = homeTeamGoals;
        }

        public int getAwayTeamGoals() {
                return awayTeamGoals;
        }

        public void setAwayTeamGoals(int awayTeamGoals) {
                this.awayTeamGoals = awayTeamGoals;
        }

        public int getHomeGoalDifference() {
                return homeGoalDifference;
        }

        public void setHomeGoalDifference(int homeGoalDifference) {
                this.homeGoalDifference = homeGoalDifference;
        }

        public int getAwayGoalDifference() {
                return awayGoalDifference;
        }

        public void setAwayGoalDifference(int awayGoalDifference) {
                this.awayGoalDifference = awayGoalDifference;
        }

        public int getHomeTeamPoints() {
                return homeTeamPoints;
        }

        public void setHomeTeamPoints(int homeTeamPoints) {
                this.homeTeamPoints = homeTeamPoints;
        }

        public int getAwayTeamPoints() {
                return awayTeamPoints;
        }

        public void setAwayTeamPoints(int awayTeamPoints) {
                this.awayTeamPoints = awayTeamPoints;
        }

        public int getYear() {
                return year;
        }

        public void setYear(int year) {
                this.year = year;
        }

        public int getMonth() {
                return month;
        }

        public void setMonth(int month) {
                this.month = month;
        }

        public int getDay() {
                return day;
        }

        public void setDay(int day) {
                this.day = day;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Match match = (Match) o;
                return homeTeamGoals == match.homeTeamGoals &&
                        awayTeamGoals == match.awayTeamGoals &&
                        homeGoalDifference == match.homeGoalDifference &&
                        awayGoalDifference == match.awayGoalDifference &&
                        homeTeamPoints == match.homeTeamPoints &&
                        awayTeamPoints == match.awayTeamPoints &&
                        year == match.year &&
                        month == match.month &&
                        day == match.day &&
                        Objects.equals(homeTeam, match.homeTeam) &&
                        Objects.equals(awayTeam, match.awayTeam);
        }

        @Override
        public int hashCode() {
                return Objects.hash(homeTeam, awayTeam, homeTeamGoals, awayTeamGoals, homeGoalDifference, awayGoalDifference, homeTeamPoints, awayTeamPoints, year, month, day);
        }

        @Override
        public String toString() {
                return "Match{" +
                        "homeTeam='" + homeTeam + '\'' +
                        ", awayTeam='" + awayTeam + '\'' +
                        ", homeTeamGoals=" + homeTeamGoals +
                        ", awayTeamGoals=" + awayTeamGoals +
                        ", homeGoalDifference=" + homeGoalDifference +
                        ", awayGoalDifference=" + awayGoalDifference +
                        ", homeTeamPoints=" + homeTeamPoints +
                        ", awayTeamPoints=" + awayTeamPoints +
                        ", year=" + year +
                        ", month=" + month +
                        ", day=" + day +
                        "}\n";
        }


        @Override
        public int compareTo(Match o) {
                return this.getMinutes(this.getYear(), this.getMonth(), this.getDay()) - o.getMinutes(o.getYear(), o.getMonth(), o.getDay());
        }

        public int getMinutes(int year, int month, int day){
                return (year * 365 * 24 * 60) + (month * 30 * 24 * 60) + (day * 24 * 60);
        }
}