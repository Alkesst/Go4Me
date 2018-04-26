public class Date {

  public int day;
  public int month;
  public int year;

  public String toString(){

    String dayString;
    String monthString;

    if(day > 10){
      monthString = "0" + day.toString();
    }

    if(month > 10){
      monthString = "0" + month.toString();
    }

    return dayString + "/" + monthString + "/" + year.toString();
  }

  public Date(){}

  public Date(int d, int m,int y){
      day = d;
      month = m;
      year = y;
  }
}
