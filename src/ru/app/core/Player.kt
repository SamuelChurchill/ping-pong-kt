package ru.app.core

import ru.app.core.impl.TablePoint

interface Player {
    val name: String
    fun hit(): TablePoint
}