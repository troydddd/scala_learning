package com.self.scalabook.chapter05

object Relational {
    def main(args: Array[String]): Unit = {
        val x = new Relational(5,2)
        println(x)
        val y = new Relational(4,3)
        println(y)
        // Class cannot be inferred,
//        val z = x.add(y)
        println(x add y)
    }
}

class Relational(n: Int, d: Int) {

    // make sure the input is valid
    require(d != 0)

    // find gcd first
    private val g = gcd(n.abs, d.abs)
    // define field
    val numer: Int = n
    val denom: Int = d
    // auxiliary constructor
    def this(n: Int) = this(n, 1)
    // override the toString in order to display relational number with the correct format
    override def toString = n + "/" + d

    // Class cannot be inferred, must specified the output type
//    def add(that: Relational): Relational = {
//        new Relational(
//            numer * that.denom + that.numer * denom,
//            denom * that.denom
//        )
//    }
    def +(that: Relational): Relational = {
        new Relational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )
    }

    def *(that: Relational): Relational = {
        new Relational(
            numer * that.numer,
            denom * that.denom
        )
    }

    def lessThan(that: Relational) ={
        this.numer * that.denom < that.numer * this.denom
    }

    def max(that: Relational): Unit = {
        if (this.lessThan(that)) that else this
    }

    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a%b)
    }

}
