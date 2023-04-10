package com.monczak.firstapp.Homework2

class Homework2 () {
    val listOfLists = (1..3).map { i -> (1..4).map {i + 1}}

    fun getDefaultListOfLists() : List<List<Any>> = listOfLists

    fun flatten(listOfLists: List<List<Any>>): List<Any> {
        return listOfLists.flatten()
    }

    fun duplicate(obj: Any, multiplier: Int) : List<Any>{
        val listOfDuplicatedObjects : MutableList<Any> = mutableListOf()
        repeat(multiplier) {
            listOfDuplicatedObjects.add(obj)
        }
        return listOfDuplicatedObjects
    }

    fun palindrome(list: List<Any>) : Boolean{
        // # What is the difference?
        // val reversedList: List<Any> = list.asReversed()
        val reversedList: List<Any> = list.reversed()
        return list == reversedList
    }

}