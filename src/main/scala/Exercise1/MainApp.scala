package Exercise1
import sun.util.locale.provider.DateFormatProviderImpl

import java.text.DecimalFormat
import java.util.{Calendar, Date, Locale}

object Exercise1MainApp extends App {

val intArray = DataProcessor.getIntegers(args);

DateUtils.checkUpperLimits(intArray);

  if (DateUtils.isValid) {

    val intUsed = DateUtils.setYear(intArray);

    // set (year, month, day)

    // year > 2099, 31 < year < 100
    // 0 < month <= 12
    // 0 < day <= 31
      var date1 = DateUtils.getDate(0,0,0);
      var date2 = DateUtils.getDate(0,0,0);
      var date3 = DateUtils.getDate(0,0,0);
      var date4 = DateUtils.getDate(0,0,0);
      var date5 = DateUtils.getDate(0,0,0);
      var date6 = DateUtils.getDate(0,0,0);

      var intA = intArray(0);
    var intB = intArray(1);
    var intC = intArray(2);

    if (intA == intUsed) {
        intA = -1;
    }
      if (intB == intUsed) {
          intB = -1;
      }
      if (intC == intUsed) {
          intC = -1;
      }
      // intB month

       if (intB < 13 && intB > 0 ){
          date1 = DateUtils.getDate(if (intC == -1) DateUtils.year else intC+2000,intB-1,intA);
          date2 = DateUtils.getDate(if(intA == -1) DateUtils.year else intA+2000,intB-1,intC);
      }


      // intA month

      if (intA < 13 && intA > 0){
          date3 = DateUtils.getDate(if(intB == -1) DateUtils.year else intB+2000,intA-1,intC);
          date4 = DateUtils.getDate(if(intC == -1) DateUtils.year else intC+2000,intA-1,intB);
      }

      // intC month

      if (intC < 13 && intC > 0){
           date5 = DateUtils.getDate(if(intB == -1) DateUtils.year else intB+2000,intC-1,intA);
           date6 = DateUtils.getDate(if(intA == -1) DateUtils.year else intA+2000,intC-1,intB);
      }
val firstJan2000 = DateUtils.getDate(2000,0,1);
    firstJan2000.setHours(0);
    firstJan2000.setMinutes(0);
    firstJan2000.setSeconds(0);

    var earliestDate: Date = if (DateUtils.isBeforeOrEqualTo(date1,date2) && firstJan2000.before(date1)) date1 else if(firstJan2000.before(date2)) date2 else null;
    earliestDate =
      if (((null != earliestDate && DateUtils.isBeforeOrEqualTo(date3, earliestDate)) || firstJan2000.before(date3))) date3
      else earliestDate;
    earliestDate = if (DateUtils.isBeforeOrEqualTo(date4,earliestDate) &&  firstJan2000.before(date4)) date4  else earliestDate;
    earliestDate = if (DateUtils.isBeforeOrEqualTo(date5,earliestDate) &&  firstJan2000.before(date5)) date5  else earliestDate;
    earliestDate = if (DateUtils.isBeforeOrEqualTo(date6,earliestDate) &&  firstJan2000.before(date6)) date6  else earliestDate;
    println(date2.toString);
    println(date3.toString);
    println(date4.toString);
    println(date5.toString);
    println(date6.toString);
    if(null == earliestDate) {
      DateUtils.returnInvalidDateMessage(intArray(0),intArray(1),intArray(2));
    }
    if (DateUtils.isValid) {
      DateUtils.year = earliestDate.getYear+1900
    DateUtils.month = earliestDate.getMonth+1
    DateUtils.day = earliestDate.getDate
    val formatter = new DecimalFormat("00");
    val formattedMonth: String = formatter.format(DateUtils.month);
val formattedDay: String = formatter.format(DateUtils.day);
    println(DateUtils.year + "-" + formattedMonth + "-" + formattedDay);
  }}
}
