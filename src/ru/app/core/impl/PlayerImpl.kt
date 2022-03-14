package ru.app.core.impl

import ru.app.core.Player

class PlayerImpl(
    override val name: String,
    private val playerTablePoints: Set<TablePoint>,
    private val pointsForShooting: Set<TablePoint>
) : Player {
    override fun hit(): TablePoint {
        return pointsForShooting.random()
    }
}