package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {

        private Object SportsClub;
        sample.SportsClub club = new FootballClub("liverpool", "london", 12,12,12,
                12,12,12,12,12);
        @Test
        void addTeam() {

                assertEquals(this.club, new FootballClub("liverpool", "london", 12,12,12,
                        12,12,12,12,12), "success");
        }

        @Test
        void deleteTeam(String name) {
        }

        @Test
        void displayClubStats() {
        }

        @Test
        void displayTableOfFootballClubs() {
        }

        @Test
        void enterMatch() {
//                Match match = new Match()
        }

        @Test
        void save() {
        }

        @Test
        void load() {
        }
}