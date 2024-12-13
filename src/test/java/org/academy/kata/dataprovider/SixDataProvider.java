package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SixDataProvider extends BaseDataProvider {
    private final static String RAINFALL_DATA =
            """
                    Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9\

                    London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9\

                    Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7\

                    NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2\

                    Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5\

                    Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2\

                    Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4\

                    Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4\

                    Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7\

                    Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7""";

    @DataProvider(name = "data-Mean")
    public static Iterator<Object[]> dpMean() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{"London", RAINFALL_DATA, 51.199999999999996});
        inputs.add(new Object[]{"Beijing", RAINFALL_DATA, 52.416666666666664});

        inputs.add(new Object[]{"None", RAINFALL_DATA, -1});

        return combineData(inputs, SIX);
    }

    @DataProvider(name = "data-Variance")
    public static Iterator<Object[]> dpVariance() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{"London", RAINFALL_DATA, 57.42833333333374});
        inputs.add(new Object[]{"Beijing", RAINFALL_DATA, 4808.37138888889});

        inputs.add(new Object[]{"None", RAINFALL_DATA, -1});

        return combineData(inputs, SIX);
    }

    @DataProvider(name = "data-NBA")
    public static Iterator<Object[]> dpNBA() {
        final List<Object[]> inputs = new ArrayList<>();
        String resultSheet1 = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
                + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,";
        String resultSheet2 = "San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,"
                + "New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,"
                + "Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,"
                + "Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,"
                + "Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,"
                + "Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,"
                + "Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104,"
                + "Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,"
                + "Houston Rockets 120 New Orleans Pelicans 100,Boston Celtics 111 Brooklyn Nets 105,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97";
        String resultSheet3 = resultSheet1 + resultSheet2;

        // Positive tests
        inputs.add(new Object[]{
                resultSheet1,
                "Boston Celtics",
                "Boston Celtics:W=1;D=0;L=0;Scored=112;Conceded=95;Points=3"
        });
        inputs.add(new Object[]{
                resultSheet3,
                "Boston Celtics",
                "Boston Celtics:W=4;D=0;L=0;Scored=403;Conceded=350;Points=12"
        });
        inputs.add(new Object[]{
                resultSheet2,
                "Boston Celt",
                "Boston Celt:This team didn't play!"
        });
        //Negative tests
        inputs.add(new Object[]{
                "Los Angeles Clippers 104 Dallas Mavericks ABC,New York Knicks 101 Atlanta Hawks 112",
                "Los Angeles Clippers",
                "Error(invalid score format):Los Angeles Clippers 104 Dallas Mavericks ABC"
        });
        inputs.add(new Object[]{
                "Los Angeles Clippers 104 Dallas Mavericks -88,New York Knicks 101 Atlanta Hawks 112",
                "Dallas Mavericks",
                "Error(negative score):Los Angeles Clippers 104 Dallas Mavericks -88"
        });
        inputs.add(new Object[]{
                "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,"
                        + "Boston Celtics Philadelphia 76ers",
                "Boston Celtics",
                "Error(missing score):Boston Celtics Philadelphia 76ers"
        });

        return combineData(inputs, SIX);
    }

    @DataProvider(name = "data-stockSummary")
    public static Iterator<Object[]> dpStockSummary() {
        final List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[]{"A", "B", "C", "D"},
                "(A : 200) - (B : 1140) - (C : 500) - (D : 600)"});
        inputs.add(new Object[]{new String[]{},
                new String[]{"A", "B", "C"},
                ""});
        inputs.add(new Object[]{new String[]{"ABAR 100"},
                new String[]{"Z"},
                "(Z : 0)"});
        inputs.add(new Object[]{new String[]{"XYZZ 300", "UVWX 400", "MNOP 150"},
                new String[]{"A", "B", "C"},
                "(A : 0) - (B : 0) - (C : 0)"});
        inputs.add(new Object[]{new String[]{"ABAR 1000", "ABAR 2000", "BKWR 1500", "BTSQ 3000", "CDXE 500", "DRTY 600", "DRTY 900"},
                new String[]{"A", "B", "C", "D"},
                "(A : 3000) - (B : 4500) - (C : 500) - (D : 1500)"});
        inputs.add(new Object[]{new String[]{"ABAR 200", "BKWR 150", "BTSQ 300", "CDXE 250", "DRTY 400"},
                new String[]{"D", "C", "B", "A"},
                "(D : 400) - (C : 250) - (B : 450) - (A : 200)"});

        return combineData(inputs, SIX);
    }

    @DataProvider(name = "data-findNb")
    public static Iterator<Object[]> dbFindNb() {
        final List<Object[]> inputs = new ArrayList<>();
        // equals
        inputs.add(new Object[]{225, 5, true});
        inputs.add(new Object[]{3025, 10, true});
        inputs.add(new Object[]{15, -1, true});
        inputs.add(new Object[]{30, -1, true});
        // not equals
        inputs.add(new Object[]{4356, 10, false});
        inputs.add(new Object[]{15, 1, false});
        inputs.add(new Object[]{1, -1, false});
        return combineData(inputs, SIX);
    }
}
