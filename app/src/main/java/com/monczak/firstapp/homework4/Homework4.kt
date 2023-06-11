package com.monczak.firstapp.homework4

class Homework4 {

    fun isPrime(p: Int) : Boolean {
        if (p <= 1) {
            return false
        }

        val upperLimit = p/2
        for (i in 2..upperLimit) {
            if (p % i == 0) {
                return false
            }
        }
        return true
    }
}