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

public class SchoolFootballClub extends FootballClub implements Serializable {

        private String schoolName;

        public SchoolFootballClub() {   //default constructor
        }

        public SchoolFootballClub(String schoolName) {      //parameterized constructor
                this.schoolName = schoolName;
        }

        public SchoolFootballClub(String name, String location, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored,
                                  int numberOfMatchesPlayed, int numberOfPoints, String schoolName, int goalDifference) {
                super(name, location, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfMatchesPlayed, numberOfPoints, goalDifference);
                this.schoolName = schoolName;
        }

        public String getSchoolName() {
                return schoolName;
        }

        public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
        }

        @Override
        public String toString() {
                return super.toString() +
                        ", " +
                        "School Name='" + schoolName + '\'' +
                        ' ';
        }

        //equals method
        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                if (!super.equals(obj)) return false;
                SchoolFootballClub schoolFootballClub = (SchoolFootballClub) obj;
                return Objects.equals(schoolName, schoolFootballClub.schoolName);
        }

        //hashCode method
        @Override
        public int hashCode() {
                return Objects.hash(super.hashCode(), schoolName);
        }


}