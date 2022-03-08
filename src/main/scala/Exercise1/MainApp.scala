package Exercise1

import Exercise1.DataProcessor.formatDateIntegers
import Exercise1.DateUtils.{assignEarlierDate, checkUpperLimits, date1, date2, date3, date4, date5, date6, day, earliestDate, firstJan2000, getDate, isValid, month, returnInvalidDateMessage, year}

import java.util.Date

object Exercise1MainApp extends App {

  val intArray = DataProcessor.getIntegers(args);

  checkUpperLimits(intArray);

  if (DateUtils.isValid) {

    val intUsed = DateUtils.setYear(intArray);

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
         date1 = getDate(if (intC == -1) year else intC+2000,intB,intA);
         date2 = getDate(if(intA == -1) year else intA+2000,intB,intC);
      }


    // intA month

      if (intA < 13 && intA > 0){
        date3 = getDate(if(intB == -1) year else intB+2000,intA,intC);
        date4 = getDate(if(intC == -1) year else intC+2000,intA,intB);
      }

      // intC month

      if (intC < 13 && intC > 0){
        date5 = getDate(if(intB == -1) year else intB+2000,intC,intA);
        date6 = getDate(if(intA == -1) year else intA+2000,intC,intB);
      }

    var earliestDate: Date = assignEarlierDate(date1, date2);
    earliestDate = assignEarlierDate(earliestDate,date3);
    earliestDate = assignEarlierDate(earliestDate,date4);
    earliestDate = assignEarlierDate(earliestDate,date5);
    earliestDate = assignEarlierDate(earliestDate,date6);

    if(null == earliestDate || earliestDate.before(firstJan2000)) {
      returnInvalidDateMessage(intArray(0),intArray(1),intArray(2));
    }
    if (isValid) {
      year = earliestDate.getYear + 1900
      month = earliestDate.getMonth + 1
      day = earliestDate.getDate
      val formattedMonth: String = formatDateIntegers(month);
      val formattedDay: String = formatDateIntegers(day);
      println(year + "-" + formattedMonth + "-" + formattedDay);
    }
  }
}
