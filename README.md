# Day of the Week

[![Run on Repl.it](https://repl.it/badge/github/hamza-mughees/Day-of-the-Week)](https://repl.it/github/hamza-mughees/Day-of-the-Week)

There is a much easier, buit-in way to get the day of the year for a given date, you have to be using Java 8, however. In order to use that, you must ```import java.time.LocalDate;```

The following is the same method as in the code, however, it has been written using built-in way of obtaining the day of the year:

```java
public static String getDay(int day, int month, int year) {
  LocalDate date = LocalDate.of(year, month, day);
  return date.getDayOfYear().name();
}
```

Despite of this, I thought it would be fun to make my own method, which uses Zeller's rule to calculate the day of the week for any given date.

Zeller's rule states:

<p align="center"><img src="/tex/992851f34bb381e6ba7d3c908bbc80a5.svg?invert_in_darkmode&sanitize=true" align=middle width=369.00571949999994pt height=39.452455349999994pt/></p>

where
* <img src="/tex/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode&sanitize=true" align=middle width=9.81741584999999pt height=22.831056599999986pt/> is the day of the week
  * 0 → Sunday
  * 1 → Monday
  * 2 → Tuesday
  * 3 → Wednesday
  * 4 → Thursday
  * 5 → Friday
  * 6 → Saturday
* <img src="/tex/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode&sanitize=true" align=middle width=9.075367949999992pt height=22.831056599999986pt/> is the day of the month
* <img src="/tex/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode&sanitize=true" align=middle width=14.433101099999991pt height=14.15524440000002pt/> is the month of the year
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
* <img src="/tex/78ec2b7008296ce0561cf83393cb746d.svg?invert_in_darkmode&sanitize=true" align=middle width=14.06623184999999pt height=22.465723500000017pt/> is the number of decades in the century up to the year (i.e. year % 100)
  * When month is January or February, <img src="/tex/78ec2b7008296ce0561cf83393cb746d.svg?invert_in_darkmode&sanitize=true" align=middle width=14.06623184999999pt height=22.465723500000017pt/> of the previous year is considered
* <img src="/tex/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode&sanitize=true" align=middle width=12.92464304999999pt height=22.465723500000017pt/> is the number of centuries up to the century (i.e. year / 100)
  * When month is January or February, <img src="/tex/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode&sanitize=true" align=middle width=12.92464304999999pt height=22.465723500000017pt/> of the previous year is considered

For some dates, there are cases where <img src="/tex/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode&sanitize=true" align=middle width=9.81741584999999pt height=22.831056599999986pt/> evaluates to a negative number. The rule provides a work-around for such a case as follows:

- Find the largest multiple of 7 that is less than or equal to <img src="/tex/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode&sanitize=true" align=middle width=9.81741584999999pt height=22.831056599999986pt/>
- Subtract this multiple of 7, from <img src="/tex/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode&sanitize=true" align=middle width=9.81741584999999pt height=22.831056599999986pt/>
- Let this value become the new <img src="/tex/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode&sanitize=true" align=middle width=9.81741584999999pt height=22.831056599999986pt/>
