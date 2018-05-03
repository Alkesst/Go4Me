public class Date {

  private int day;
  private int month;
  private int year;

  public String toString(){

    String dayString;
    String monthString;

    if(day > 10){
      monthString = "0" + Integer.toString(day);
    }

    if(month > 10){
      monthString = "0" + Integer.toString(month);
    }

    return dayString + "/" + monthString + "/" + Integer.toString(year);
  }

  public void setDay(int d){
    day = d;
  }

  public void setMonth(int m){
    month = m;
  }

  public void setYear(int y){
    year = y;
  }

  public int getDay(){
    return day;
  }

  public int getMonth(){
    return month;
  }

  public int getYear(){
    return year;
  }

  public Date(){}

  public Date(int d, int m,int y){
      day = d;
      month = m;
      year = y;
  }
}
