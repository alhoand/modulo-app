package modulo
import scala.io.StdIn._

object modCalculator extends App{
  private var a = 0
  private var n = 3
  private var b = 0
  private var c = 0
  private var nPlusOne = false
  private var quit = false

  println("Modulus test. hit a to increase a. n to increase n. e for exit.") //+ "\n" + "a: " + a + " n: " + n + " b: " + b + " c: " + c)
  println("a + c = b (mod n): ")
  println(a + " + " + c + " = " +  b + " (mod " + n +")")
  while (!quit){
    var temp = readLine()
    if (temp.contains('n')){
      nPlusOne = true
      n += 1
    }
    else if(temp.contains('e')){
      quit = true
    }else if(temp.contains('a')){
      a += 1
    }
    c = calculateC(a, b, c, n, nPlusOne)
    b = (a + c) % n
    println(a + " + " + c + " = " +  b + " (mod " + n +")")
    nPlusOne = false
  }
  println("Ended.")
  
  
  def calculateC(a: Int, b: Int, c: Int, nextN: Int, increaseModuloN: Boolean): Int = {
    if ( !increaseModuloN ){
      c
    }else{
      val n = nextN - 1
      val nextA = a + 1
      val nextB = 1 + (b % n)
      val nextC = nextB - (nextA % nextN)
      if (nextC < 0){
        nextN - math.abs(nextC)
      }else {
        nextC
      }
    }
  }
  
  
  
}
