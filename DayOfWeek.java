public class DayOfWeek {
  public static void main(String[] args) {
    System.out.println(findDay(5, 10, 1952));
    System.out.println(findDay(14, 8, 1947));
    System.out.println(findDay(1, 1, 2000));
  }
  
  public static String findDay(int day, int month, int year) {
    int m;
    int d = year % 100;
    int c = year / 100;
    if (month < 3) {
      m = month + 10;
      d = d == 0 ? 99 : d - 1;
      c--;
    } else m = month - 2;

    int f = day + (int)((13*m-1)/5) + d + (int)d/4 + (int)c/4 - 2*c;
    f = f < 0 ? negHandler(f) : f % 7;

    switch (f) {
      case 0: return "SUNDAY";
      case 1: return "MONDAY";
      case 2: return "TUESDAY";
      case 3: return "WEDNESDAY";
      case 4: return "THURSDAY";
      case 5: return "FRIDAY";
      case 6: return "SATURDAY";
      default: return "CALCULATION FAILED";
    }
  }
	
  public static int negHandler(int f) {
    int m = 0;
    while (m > f)
      m -= 7;
    return f - m;
  }
}
