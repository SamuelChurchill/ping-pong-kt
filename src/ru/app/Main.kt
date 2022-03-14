package ru.app

import ru.app.core.impl.GameImpl
import ru.app.core.impl.PingPongTableImpl
import ru.app.core.impl.PlayerImpl

fun main() {
    val pingPongTable = PingPongTableImpl()
    val game = GameImpl()

    val playerOne = PlayerImpl(
        "Игрок 1",
        pingPongTable.getPlayerOneTablePoints(),
        pingPongTable.getPlayerOneTablePointsForShooting()
    )
    val playerTwo = PlayerImpl(
        "Игрок 2",
        pingPongTable.getPlayerTwoTablePoints(),
        pingPongTable.getPlayerTwoTablePointsForShooting()
    )

    println()
    game.run(pingPongTable, playerOne, playerTwo)
}