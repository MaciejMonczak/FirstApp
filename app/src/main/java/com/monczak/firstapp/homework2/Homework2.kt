package com.monczak.firstapp.homework2

class Homework2 () {
    private val listOfLists = (1..3).map { i -> (1..4).map {i + 1}}

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
        // # This is read-only and changes in the original list will also update reversed one
        // val reversedList: List<Any> = list.asReversed()
        val reversedList: List<Any> = list.reversed()
        return list == reversedList
    }

}