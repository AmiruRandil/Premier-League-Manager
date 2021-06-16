package sample;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {
        private String universityName;
        private String universityRanking;

        public UniversityFootballClub(String clubName, String clubLocation, int winCount, int drawCount, int defeatCount, int scoredGoalsCount, int receivedGoalsCount, int points, int matchesPlayed, int goalDifference, String universityName, String universityRanking) {
                super(clubName, clubLocation, winCount, drawCount, defeatCount, scoredGoalsCount, receivedGoalsCount, matchesPlayed, points, goalDifference);
                this.universityName = universityName;
                this.universityRanking = universityRanking;
        }

        public void setUniversityName(String universityName) {
                this.universityName = universityName;
        }

        public String getUniversityName() {
                return universityName;
        }

        public void setUniversityRanking(String universityRanking) {
                this.universityRanking = universityRanking;
        }

        public String getUniversityRanking() {
                return universityRanking;
        }

        @Override
        public String toString() {
                return "lk.oop.coursework.UniversityFootballClub{" +
                        "universityName='" + universityName + '\'' +
                        ", universityRanking='" + universityRanking + '\'' +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                UniversityFootballClub that = (UniversityFootballClub) o;
                return Objects.equals(universityName, that.universityName) &&
                        Objects.equals(universityRanking, that.universityRanking);
        }

        @Override
        public int hashCode() {
                return Objects.hash(super.hashCode(), universityName, universityRanking);
        }
}

