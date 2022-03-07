package Exercise1

import Exercise1.Exercise1MainApp.intArray

import java.util.{Calendar, Date}

object DateUtils {

  var year: Int = -1;
  var month: Int = -1;
  var day: Int = -1;

  val invalidMessage = " is illegal";
  var isValid = true;

  def isBeforeOrEqualTo(date1: Date, date2: Date): Boolean = {
    date1.before(date2) || date1.equals(date2);
  }

  def getDate(intA: Int, intB: Int, intC: Int): Date = {
    var calendar = Calendar.getInstance();
    calendar.set(intA,intB,intC);
return calendar.getTime();
  }

  def setYear(intArray: Array[Int]): Int = {
    var intUsed = -1
    if(intArray.contains(0)) {
      DateUtils.year = 2000
      intUsed = 0
    }
    else if (intArray(0) > 31) {
      DateUtils.year = intArray(0)
      intUsed = intArray(0)
    }
    else if (intArray(1) > 31){
      DateUtils.year = intArray(1)
      intUsed = intArray(1)
    }
    else if (intArray(2) > 31) {
      DateUtils.year = intArray(2)
      intUsed = intArray(2)
    } ;

    if (31 < DateUtils.year  && DateUtils.year < 100) DateUtils.year += 2000;
    println("year" + DateUtils.year);

    return intUsed;
  }

  def returnInvalidDateMessage(a:Int,b:Int,c:Int) = {
    val invalidMessage = " is illegal";
    println(a.toString + "/" + b.toString + "/" + c.toString + invalidMessage);
    isValid = false;
  };

  def checkUpperLimits(values:Array[Int]) = {
    var numberOfOver31 = 0;
      values.foreach(a=>if(a>31)numberOfOver31+=1);
    if (numberOfOver31 > 1){
      returnInvalidDateMessage(values(0),values(1),values(2));
    }
  };



}
