package com.self.scalabook.chapter04

object TestApp extends App{
    println("\"")
    println(
        """
          |this is stripMargin test
          |Ohhhh, this is the second LINE
        """.stripMargin)
    val s = raw"No\\\\\\escape"
    println(s)

    val pi = math.Pi
    println(f"$pi%.5f")
}
