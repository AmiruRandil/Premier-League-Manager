package sample;

import java.util.Comparator;

public class PointsComparator implements Comparator<SportsClub> {

        @Override
        public int compare(SportsClub o1, SportsClub o2) {
                return ((FootballClub) o1).comparePoints(((FootballClub) o2));
        }
}
