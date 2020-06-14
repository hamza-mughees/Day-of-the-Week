# Day of the Week

There is a much easier, buit-in way to get the day of the year, you have to be using Java 8, however. In order to use that, you must ```import java.time.LocalDate;```

The following is the same method, written using this way of obtaining the day of the year:

```java
public static String findDay(int day, int month, int year) {
  LocalDate date = LocalDate.of(year, month, day);
  return date.getDayOfYear().name();
}
```

Despite this, I thought it would be fun to make my own method, which uses Zeller's rule to calculate the day of the week for any given date.

Zeller's rule states the following:

<img src="https://github.com/hamza-mughees/Day-of-the-Week/blob/master/formula.png" width="600">

where
- ***f*** is the day of the week (i.e. 0: Sunday, 1: Monday, ...)
- ***k*** is the day of the month
- ***m*** is the month of the year
- ***D*** is the number of decades in the century up to the year (i.e. year % 100)
- ***C*** is the number of centuries up to the century (i.e. year / 100)

For some dates, there are cases where ***f*** evaluates to a negative number. The rule provides a work-around for such a case as follows:

- Find the largest multiple of 7 that is less than or equal to ***f***
- Subtract this multiple of 7, from ***f***
- Let this value become the new ***f***
