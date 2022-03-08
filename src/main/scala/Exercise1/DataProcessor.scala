package Exercise1

import Exercise1.MainApp.{args, intArray}
import java.text.DecimalFormat

object DataProcessor {
  val inputS = "Input String: ";

  /**
   * Takes the string input, divides it into three parts,
   * and returns an array of the three contained integers
   * @param input the string input of "/" - delimited integers
   * @return array of integers
   */
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

  /**
   * formats the day and month integers to be returned in the form "MM"and"DD"
   * @param intInput
   * @return
   */
  def formatDateIntegers(intInput: Int): String = {
    val formatter = new DecimalFormat("00");
    val formattedInt: String = formatter.format(intInput)
    return formattedInt;
  }

}
