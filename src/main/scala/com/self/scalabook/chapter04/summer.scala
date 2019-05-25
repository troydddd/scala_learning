package com.self.scalabook.chapter04

import ChecksumAccumulator.calculate
object summer {
    def main(args: Array[String]): Unit = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}
