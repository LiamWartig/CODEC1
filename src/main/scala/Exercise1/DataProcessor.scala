package Exercise1

import Exercise1.Exercise1MainApp.{args, intArray}
import java.text.DecimalFormat

object DataProcessor {
  val inputS = "Input String: ";

  def getIntegers(input: Array[String]):  Array[Int]  = {
    val inputString = input.mkString
    println(inputS + inputString);
    val inputSplit = inputString.split("/");
    val intA = inputSplit(0).toInt;
    val intB = inputSplit(1).toInt;
    val intC = inputSplit(2).toInt;
    val intArray: Array[Int] = Array(intA, intB, intC);
    return intArray;
  }

def formatDateIntegers(intInput: Int): String = {
  val formatter = new DecimalFormat("00");
  val formattedInt: String = formatter.format(intInput)
return formattedInt;
}
}
