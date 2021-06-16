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

public abstract class SportsClub implements Serializable {

        private String name;
        private String location;

        public SportsClub() {      //default constructor
        }

        public SportsClub(String name, String location) {
                this.name = name;
                this.location = location;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        //toString method
        @Override
        public String toString() {
                return " Club Name ='" + name + '\'' +
                        ", Location ='" + location + '\'' +
                        ", ";
        }

        //equals method
        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                SportsClub sportsClub = (SportsClub) obj;
                return Objects.equals(name, sportsClub.name) &&
                        Objects.equals(location, sportsClub.location);
        }

        //hashCode method
        @Override
        public int hashCode() {
                return Objects.hash(name, location);
        }


}