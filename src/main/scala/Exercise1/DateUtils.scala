package Exercise1

import Exercise1.MainApp.intArray

import java.util.{Calendar, Date}

object DateUtils {
  val firstJan2000 = DateUtils.getDate(2000,0,1);
  var year: Int = -1;
  var month: Int = -1;
  var day: Int = -1;
var earliestDate: Date = getDate(0,0,0);
  val invalidMessage = " is illegal";
  var isValid = true;

  def isBeforeOrEqualTo(date1: Date, date2: Date): Boolean = {
    date1.before(date2) || date1.equals(date2);
  }

  /**
   * takes two dates, returns the earliest one that is >= 1/1/2000
   * @param date1
   * @param date2
   * @return
   */
  def assignEarlierDate(date1: Date,date2:Date): Date = {
    if (null == date1) {
      return date2;
    }
    val earlierDate = if (isBeforeOrEqualTo(date2, date1) && isBeforeOrEqualTo(firstJan2000,date2)) date2
    else date1;
    return earlierDate;
  }

  /**
   * Constructor of a {@link java.util.Date} instance with time = 00:00:00
   *
   * @param intA year
   * @param intB month
   * @param intC day
   * @return
   */
  def getDate(intA: Int, intB: Int, intC: Int): Date = {
    var calendar = Calendar.getInstance();
    calendar.set(intA,intB-1,intC,0,0,0);
return calendar.getTime();
  }

  /**
   * Checks the values in a given array to see which might suit being the 'year',
   * and assigns the {@link DateUtils.year} value a corresponding value.
   *
   * The {@code intUsed} field is then used to identify which value has been used to set the year.
   * @param intArray
   * @return intUsed a value used to match to which value has been used to set the year
   */
  def setYear(intArray: Array[Int]): Int = {
    var intUsed = -1
    if(intArray.contains(0)) {
      year = 2000
      intUsed = 0
    }
    else if (intArray(0) > 31) {
      year = intArray(0)
      intUsed = intArray(0)
    }
    else if (intArray(1) > 31){
      year = intArray(1)
      intUsed = intArray(1)
    }
    else if (intArray(2) > 31) {
      year = intArray(2)
      intUsed = intArray(2)
    } ;

    if (31 < year  && year < 100) year += 2000;

    return intUsed;
  }

  /**
   * Returns a formatted 'invalid' message and sets a validity flag to false, stopping further processing.
   * @param a first input value
   * @param b second input value
   * @param c third input value
   */
  def returnInvalidDateMessage(a:Int,b:Int,c:Int) = {
    val invalidMessage = " is illegal";
    println(a.toString + "/" + b.toString + "/" + c.toString + invalidMessage);
    isValid = false;

  };

  /**
   * Makes a quick check on input values to save time if numbers are obviously invalid
   * @param values array of three input values
   */
  def checkUpperLimits(values:Array[Int]) = {
    var numberOfOver31 = 0;
      values.foreach(a=>if(a>31)numberOfOver31+=1);
    if (numberOfOver31 > 1){
      returnInvalidDateMessage(values(0),values(1),values(2));
    }
  };

  /**
   * a bunch of dummy variables used when comparing dates
   */
  var date1: Date = DateUtils.getDate(0,0,0);
  var date2: Date = DateUtils.getDate(0,0,0);
  var date3: Date = DateUtils.getDate(0,0,0);
  var date4: Date = DateUtils.getDate(0,0,0);
  var date5: Date = DateUtils.getDate(0,0,0);
  var date6: Date = DateUtils.getDate(0,0,0);

}
