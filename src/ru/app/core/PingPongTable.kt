package ru.app.core

import ru.app.core.impl.TablePoint

interface PingPongTable {
    fun getAllTablePoints(): Set<TablePoint>
    fun getPlayerOneTablePoints(): Set<TablePoint>
    fun getPlayerTwoTablePoints(): Set<TablePoint>
    fun getPlayerOneTablePointsForShooting(): Set<TablePoint>
    fun getPlayerTwoTablePointsForShooting(): Set<TablePoint>
}