public class Date implements Comparable<Date>{

  private int minute;
  private int hour;
  private int day;
  private int month;
  private int year;

  public String toString(){

    String dayString = "";
    String monthString = "";

    if(day > 10){
      monthString = "0" + Integer.toString(day);
    }

    if(month > 10){
      monthString = "0" + Integer.toString(month);
    }

    return dayString + "/" + monthString + "/" + Integer.toString(year) + " " + Integer.toString(hour) + ":" + Integer.toString(minute);
  }

  public boolean equals(Object o){
    boolean res=false;
    if(o instanceof Date){
      Date d=(Date) o;
      res= (this.year==d.year) && (this.month==d.month) &&(this.day==d.day)
        && (this.hour==d.hour) && (this.minute==d.minute);
    }
    return res;
  }

  public int hashCode(){
    return Integer.hashCode(year) + Integer.hashCode(month)
      + Integer.hashCode(day) + Integer.hashCode(hour)+
      Integer.hashCode(minute);
  }

  public int compareTo(Date d1){ //returns 1 if d1 > d2, -1 if d1 < d2 and 0 if d1 == d2
    int resultado= Integer.compare(year, d1.year);
    if (resultado==0){
      resultado= Integer.compare(month, d1.month);
      if (resultado==0){
        resultado=Integer.compare(day, d1.day);
        if(resultado==0){
          resultado=Integer.compare(hour, d1.hour);
          if (resultado==0){
            resultado=Integer.compare(minute, d1.minute);
          }
        }
      }
    }
    return resultado;
  }
/*
    else if(d1.getYear() < d2.getYear()){ return -1; }

    if(d1.getMonth() > d2.getMonth()){ return 1; }
    else if(d1.getMonth() < d2.getMonth()){ return -1; }

    if(d1.getDay() > d2.getDay()){ return 1; }
    else if(d1.getDay() < d2.getDay()){ return -1; }

    if(d1.getHour() > d2.getHour()){ return 1; }
    else if(d1.getHour() < d2.getHour()){ return -1; }

    if(d1.getMinute() > d2.getMinute()){ return 1; }
    else if(d1.getMinute() < d2.getMinute()){ return -1; }

    return 0;
  }
*/
  public void setMinute(int m){
      minute = m;
  }

  public void setHour(int h){
    hour = h;
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

  public int getMinute(){
    return minute;
  }

  public int getHour(){
    return hour;
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
      hour = 0;
      minute = 0;
  }

  public Date(int d, int m,int y,int h,int mi){
      day = d;
      month = m;
      year = y;
      hour = h;
      minute = mi;
  }
}
