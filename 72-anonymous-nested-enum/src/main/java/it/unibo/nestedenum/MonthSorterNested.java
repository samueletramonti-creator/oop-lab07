package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    /**
     * Month
     */
    public enum Month {
        JANUARY("January", 31), 
        FEBRUARY("February", 28),
        MARCH("March", 31), 
        APRIL("April", 30), 
        MAY("May", 31), 
        JUNE("June", 30), 
        JULY("July", 31), 
        AUGUST("August", 31), 
        SEPTEMBER("September", 30), 
        OCTOBER("October", 31), 
        NOVEMBER("November", 30), 
        DECEMBER("December", 31);

        private int days;
        private String actualName;

        private Month (final String actualName,final int days ) {
            this.actualName = actualName ;
            this.days=days;
        }

        public int getDays() {
            return this.days;
        }
    
        public static Month fromString(String string) {
            for (Month month: Month.values()) {
                if (month.actualName.equalsIgnoreCase(string)) {
                    return month;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }

    public static class SortByMonthOrder implements java.util.Comparator<String> {

        @Override 
        public int compare(String s1,String s2) {
            Month month1=Month.fromString(s1);
            Month month2=Month.fromString(s2);
            return Integer.compare(month1.ordinal(),month2.ordinal());
        }
    }

    public static class SortByDate implements java.util.Comparator<String> {

        @Override 
        public int compare(String s1,String s2) {
            Month month1=Month.fromString(s1);
            Month month2=Month.fromString(s2);
            return Integer.compare(month1.getDays(),month2.getDays());
        }
    }
}
