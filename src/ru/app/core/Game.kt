package ru.app.core

import ru.app.core.impl.PingPongTableImpl

interface Game {
    fun run(pingPongTable: PingPongTableImpl, playerOne: Player, playerTwo: Player)
}