package sample;

/*
 * Name: Amiru Randil
 * UoW ID: W1761765
 * "I confirm that I understand what plagiarism / collusion / contract cheating is and have read and understood the
 * section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely
 * my own. Any work from other authors is duly referenced and acknowledged."
 */

import java.util.Comparator;

public class winsComparator implements Comparator<SportsClub> {
        @Override
        public int compare(SportsClub o1, SportsClub o2) {
                return ((FootballClub) o1).compareWins(((FootballClub) o2));
        }
}
