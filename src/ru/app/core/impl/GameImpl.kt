package ru.app.core.impl

import ru.app.core.Game
import ru.app.core.Player

class GameImpl : Game {
    companion object {
        private const val MAXIMUM_GAME_POINT = 11
    }
    override fun run(pingPongTable: PingPongTableImpl, playerOne: Player, playerTwo: Player) {
        var gamePointPlayerOne = 0
        var gamePointPlayerTwo = 0
        while (gamePointPlayerOne < MAXIMUM_GAME_POINT || gamePointPlayerTwo < MAXIMUM_GAME_POINT) {

            if (gamePointPlayerOne == MAXIMUM_GAME_POINT) {
                break
            }

            val playerOneHit = playerOne.hit()
            val isPlayerOneHitOpponentTable = pingPongTable.getPlayerTwoTablePoints().contains(playerOneHit)

            if (!isPlayerOneHitOpponentTable) {
                gamePointPlayerTwo++
            }
            printGameInfo(
                playerOne, playerOneHit, isPlayerOneHitOpponentTable,
                gamePointPlayerOne, gamePointPlayerTwo
            )

            if (gamePointPlayerTwo == MAXIMUM_GAME_POINT) {
                break
            }

            val playerTwoHit = playerTwo.hit()
            val isPlayerTwoHitOpponentTable = pingPongTable.getPlayerOneTablePoints().contains(playerTwoHit)

            if (!isPlayerTwoHitOpponentTable) {
                gamePointPlayerOne++
            }
            printGameInfo(
                playerTwo, playerTwoHit, isPlayerTwoHitOpponentTable,
                gamePointPlayerOne, gamePointPlayerTwo
            )
        }
        printWinner(gamePointPlayerOne, gamePointPlayerTwo)
    }

    private fun printGameInfo(
        player: Player, hitPoint: TablePoint, isPlayerHitOpponentTable: Boolean,
        gamePointPlayerOne: Int, gamePointPlayerTwo: Int
    ) {
        println("Игрок ${player.name} попал в точку $hitPoint")
        if (isPlayerHitOpponentTable) {
            println("Игрок ${player.name} попал по столу противника")
        } else {
            println("Игрок ${player.name} промахнулся")
            println("Счет становится $gamePointPlayerOne - $gamePointPlayerTwo")
        }
    }

    private fun printWinner(gamePointPlayerOne: Int, gamePointPlayerTwo: Int) {
        if (gamePointPlayerOne == MAXIMUM_GAME_POINT) {
            println("Игрок 1 выиграл! Поздравляем!")
        } else if (gamePointPlayerTwo == MAXIMUM_GAME_POINT) {
            println("Игрок 2 выиграл! Поздравляем!")
        }
    }
}