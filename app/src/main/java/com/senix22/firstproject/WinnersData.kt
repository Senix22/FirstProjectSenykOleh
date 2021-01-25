package com.senix22.firstproject

data class WinnersData(
    val name: String,
    val score: Int
) {
    override fun toString(): String {
        return "$name $score"
    }
}