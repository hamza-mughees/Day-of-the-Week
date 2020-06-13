public class DayOfWeek {
  public static void main(String[] args) {
    System.out.println(findDay(5, 10, 1952));
    System.out.println(findDay(14, 8, 1947));
    System.out.println(findDay(1, 1, 2000));
  }
  
  public static String findDay(int day, int month, int year) {
    int m;
    int d;
    if (month < 3) {
      m = month + 10;
      d = year % 100 - 1;
    } else {
      m = month - 2;
      d = year % 100;
    }
    int c = year / 100;

    int dayOfWeek = day + ((13*m-1)/5) + d + d/4 + c/4 - 2*c;
    dayOfWeek = dayOfWeek < 0 ? negHandler(dayOfWeek) : dayOfWeek % 7;

    switch (dayOfWeek) {
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
	
	public static int negHandler(int n) {
    int r = 0;
    while (r > n)
      r -= 7;
    return n - r;
  }
}
