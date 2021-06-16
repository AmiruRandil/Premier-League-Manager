package sample;/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

import java.io.IOException;

public interface LeagueManager {

        void addTeam(SportsClub club);

        void deleteTeam(String clubName);

        void displayClubStats(String clubName);

        void displayTableOfFootballClubs();

        boolean enterMatch(Match match);

        void save(String pLFile, String mPFile) throws IOException;

        void load(String pLFile, String mPFile) throws IOException, ClassNotFoundException;

}