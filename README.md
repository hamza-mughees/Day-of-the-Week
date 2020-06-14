# Day of the Week

[![Run on Repl.it](https://repl.it/badge/github/hamza-mughees/Day-of-the-Week)](https://repl.it/github/hamza-mughees/Day-of-the-Week)

There is a much easier, buit-in way to get the day of the year, you have to be using Java 8, however. In order to use that, you must ```import java.time.LocalDate;```

The following is the same method as in the code, however, it has been written using this way of obtaining the day of the year:

```java
public static String getDay(int day, int month, int year) {
  LocalDate date = LocalDate.of(year, month, day);
  return date.getDayOfYear().name();
}
```

Despite of this, I thought it would be fun to make my own method, which uses Zeller's rule to calculate the day of the week for any given date.

Zeller's rule states:

<img src="https://github.com/hamza-mughees/Day-of-the-Week/blob/master/formula.png" width="600">

where
* ***f*** is the day of the week
  * 0 → Sunday
  * 1 → Monday
  * 2 → Tuesday
  * 3 → Wednesday
  * 4 → Thursday
  * 5 → Friday
  * 6 → Saturday
* ***k*** is the day of the month
* ***m*** is the month of the year
  * January → 11
  * February → 12
  * March → 1
  * April → 2
  * May → 3
  * June → 4
  * July → 5
  * August → 6
  * September → 7
  * October → 8
  * November → 9
  * December → 10
* ***D*** is the number of decades in the century up to the year (i.e. year % 100)
  * When month is January or February, ***D*** of the previous year is used
* ***C*** is the number of centuries up to the century (i.e. year / 100)
  * When month is January or February, ***C*** of the previous year is used

For some dates, there are cases where ***f*** evaluates to a negative number. The rule provides a work-around for such a case as follows:

- Find the largest multiple of 7 that is less than or equal to ***f***
- Subtract this multiple of 7, from ***f***
- Let this value become the new ***f***
