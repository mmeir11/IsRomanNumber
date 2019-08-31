import kotlin.math.max

//    I = 1
//    V = 5
//    X = 10
//    L = 50
//    C = 100

/*
fun main(){
   println(isRomanNumber("XCIX"))
}
*/

val romanLiteralsMap = mapOf("I" to 1, "X" to 10, "C" to 100, "V" to 5, "L" to 50)

fun isRomanNumber(i_RomanNumber : String) : Boolean {

    if( isInvalidInput(i_RomanNumber))
    {
        return false
    }
    if(HaveMoreThanOnceLoV(i_RomanNumber)){
        return false
    }
    if(HaveThreeInRowIoXoC(i_RomanNumber)){
        return false
    }

    if(LesserNumberNotFollowBiggerNumber(i_RomanNumber))
    {
        return false
    }



    return true
}

//check if all the charecter is a Roman Numerals
fun isInvalidInput(i_Romannumber: String): Boolean {

    if(i_Romannumber.isEmpty()){
        return true
    }
    i_Romannumber.forEach {
        if(!romanLiteralsMap.containsKey(it.toString()))
        {
            return true
        }
    }
    return false
}

// check if Have More Than Once L Or V
fun HaveMoreThanOnceLoV(i_RomanNumber: String) : Boolean{
    var flagL : Boolean = false
    var flagV : Boolean = false

    i_RomanNumber.forEach {
        if(it.equals('L'))
        {
            if(flagL == true){
                return true;    //Find second L
            }
            else{   //Find first L
                flagL = true;
            }
        }
        else if(it.equals('V'))
        {
            if(flagV == true){
                return true;    //Find second v
            }
            else{   //Find first v
                flagV = true;
            }
        }
    }

    return false
}

//check if Have Three In a Row I or X or C
fun HaveThreeInRowIoXoC(i_RomanNumber: String) : Boolean
{
    if(i_RomanNumber.contains("IIII") || i_RomanNumber.contains("XXXX") || i_RomanNumber.contains("CCCC"))
    {
        return true
    }

    return false
}

//check if Lesser Number Follow Bigger Number,
//and if not check if the Lesser is X or I, and appear once
fun LesserNumberNotFollowBiggerNumber(i_RomanNumber: String): Boolean
{
    var i : Int = 0

    while (i < i_RomanNumber.length - 1)
    {
        val firstNum: Int = romanLiteralsMap[i_RomanNumber[i].toString()]!!
        val secondNum: Int = romanLiteralsMap[i_RomanNumber[i + 1].toString()]!!

        if(firstNum < secondNum)
        {
            if(!i_RomanNumber[i].toString().equals("X") && !i_RomanNumber[i].toString().equals("I"))  //if first number is not X or I, false
            {
                return true
            }
            else   //if first num is I or X
            {
                if(i > 0)
                {
                    val thirdNum: Int = romanLiteralsMap[i_RomanNumber[i - 1].toString()]!!     //check the number before the first number.
                    if(thirdNum < secondNum)                                                     //if the third number is Lesser, founded two Lesser before Bigger, false
                    {
                        return true
                    }
                }
            }

        }
        i++
    }
    return false
}


