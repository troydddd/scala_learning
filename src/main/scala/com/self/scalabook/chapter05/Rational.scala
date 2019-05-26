package com.self.scalabook.chapter05

/**
  * @author Yijun Dai
  * @date 2019-05-26 15:20
  */
object Rational {
    val x = new Rational(1,2)
    println(x * 2)
}

class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g
    def this(n : Int ) = this(n, 1)
    // Rational number part
    def + (that: Rational) : Rational = {
        new Rational(numer*that.denom+that.numer*denom, denom*that.denom)
    }

    def - (that: Rational) : Rational = {
        new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    }

    def * (that: Rational) : Rational = {
        new Rational(numer * that.numer, denom * that.denom)
    }

    def / (that : Rational) : Rational = {
        new Rational(numer * that.denom, denom * that.numer)
    }

    // Integer part
    def + (n : Int) : Rational = {
        new Rational(numer + n * denom, denom)
    }

    def - (n : Int) : Rational = {
        new Rational(numer - n * denom, denom)
    }

    def * (n : Int) : Rational = {
        new Rational(numer * n, denom)
    }

    def / (n: Int) : Rational = {
        new Rational(numer, denom * n)
    }

    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a % b)
    }

    // TODO: figure out implicit in scala
    implicit def intToRational(x: Int) = new Rational(x)
}
