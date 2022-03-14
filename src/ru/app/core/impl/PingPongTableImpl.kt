package ru.app.core.impl

import ru.app.core.PingPongTable

class PingPongTableImpl : PingPongTable {
    private val tablePoints: Set<TablePoint>
    private val playerOneTablePoints: Set<TablePoint>
    private val playerTwoTablePoints: Set<TablePoint>
    private val playerOnePointsForShooting: Set<TablePoint>
    private val playerTwoPointsForShooting: Set<TablePoint>

    init {
        println("Generate table")
        tablePoints =
            buildTablePoints(LEFT_TOP_POINT, TABLE_SIZE_IN_POINTS, TABLE_SIZE_IN_POINTS)
        playerOneTablePoints = buildTablePoints(TablePoint(3, 2), 6, 4)
        playerTwoTablePoints = buildTablePoints(TablePoint(3, 6), 6, 4)

        playerOnePointsForShooting = getPointForShouting(tablePoints, playerOneTablePoints)
        playerTwoPointsForShooting = getPointForShouting(tablePoints, playerTwoTablePoints)
        println("Table generated successfully")
    }

    companion object {
        private const val TABLE_SIZE_IN_POINTS = 10
        private val LEFT_TOP_POINT: TablePoint = TablePoint(1, 1)
    }

    private fun getPointForShouting(allPoints: Set<TablePoint>, excludedPoints: Set<TablePoint>): Set<TablePoint> {
        val pointsForShooting: MutableSet<TablePoint> = allPoints.toHashSet()
        pointsForShooting.removeAll(excludedPoints)

        println("Player points for shouting $pointsForShooting")
        return pointsForShooting
    }

    private fun buildTablePoints(startPoint: TablePoint, pointsByX: Int, pointsByY: Int): Set<TablePoint> {
        val tablePoints: MutableSet<TablePoint> = HashSet()
        for (i in startPoint.x until startPoint.x + pointsByX) {
            for (j in startPoint.y until startPoint.y + pointsByY) {
                tablePoints.add(TablePoint(i, j))
            }
        }

        println("Created tablePoints: $tablePoints")
        return tablePoints
    }

    override fun getAllTablePoints(): Set<TablePoint> {
        return tablePoints
    }

    override fun getPlayerOneTablePoints(): Set<TablePoint> {
        return playerOneTablePoints
    }

    override fun getPlayerTwoTablePoints(): Set<TablePoint> {
        return playerTwoTablePoints
    }

    override fun getPlayerOneTablePointsForShooting(): Set<TablePoint> {
        return playerOnePointsForShooting
    }

    override fun getPlayerTwoTablePointsForShooting(): Set<TablePoint> {
        return playerTwoPointsForShooting
    }
}