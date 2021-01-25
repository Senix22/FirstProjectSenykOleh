package com.senix22.firstproject.objects

import com.senix22.firstproject.WinnersData

object WinnersStorage {
    private var listOfWinners = ArrayList<WinnersData>()
    private var sortedListOfWinners = ArrayList<WinnersData>()
    fun addWinners(data: WinnersData) {
        listOfWinners.add(data)
    }

    fun getList(): ArrayList<WinnersData> {
        return listOfWinners
    }

    fun clearListOfWinners(): ArrayList<WinnersData> {
        listOfWinners.clear()
        sortedListOfWinners.clear()
        return listOfWinners
    }

    fun addSortedWinner(data: WinnersData) {
        sortedListOfWinners.add(data)
        sortedListOfWinners.sortByDescending { it.score }
    }

    fun getSortedList(): ArrayList<WinnersData> {
        return sortedListOfWinners
    }
}

