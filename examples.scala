import scala.math._

List(1.0, 4.0, 9.0, 16.0).map(sqrt)

List("A", "b", "C").map(_.toLowerCase)

val mysqrt = sqrt _

mysqrt(25.0)

def powerOfTwo(k : Int) = pow(2.0, k)

List(1, 2, 3, 4).map(powerOfTwo)

(k : Int) => pow(2.0, k)

((k : Int) => pow(2.0, k))(5)

List(1, 2, 3, 4).map((k : Int) => pow(2.0, k))

def isAlpha(c : Char) = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')

List('x', 'y', '2', '3', 'a').filter(isAlpha)

def isOdd(x : Int) = x % 2 == 1

List(1, 2, 3, 4).filter(isOdd)

List("abc", "", "d").filter(s => s.length > 0)

List(1, 2, 3).foldLeft(0)(_+_)

List(5, 8, 3, 1).reduce(max)

List(List(1, 2), List(3, 4), List(), List(5)).reduce(_++_)

def flatten[T](l : List[List[T]]) = l.fold(List())(_++_)

def evaluate(a: List[Double], x: Double) = {
    (0 to a.length-1)
    .map((i) => a(i) * pow(x, i))
    .fold(0.0)(_+_)
}

evaluate(List(1.0, 2.0, 3.0), 4.0)

class Camera(pixelsV : Int, brandV : String) { def pixels = pixelsV; def brand = brandV }

def example (cameras: List[Camera]) = {
    cameras
    .filter(_.brand == "Nikon")
    .map(_.pixels)
    .reduce(max)
}

example(List(new Camera(100, "Nikon"), new Camera(200, "Nikon"), new Camera(300, "Other")))

def linesOf(s: String) = s.lines
def listOf(i : Iterator[String]) = i.toList
def linesOfList = (listOf _).compose(linesOf)
