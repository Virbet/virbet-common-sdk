package org.wireforce.virbet.dto

import kotlinx.datetime.Instant
import org.wireforce.virbet.classes.AbstractKtorEventDto
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.interfaces.IKtorBasicEvent

/**
 * Класс `KtorParentEventPreview` представляет собой предварительный обзор родительского события в системе.
 *
 * @param eventId Идентификатор события.
 * @param status Статус события типа `KtorEventStatus`.
 * @param eventName Название события.
 * @param teamGuest Команда-гость типа `KtorEventTeam`.
 * @param teamHost Команда-хозяин типа `KtorEventTeam`.
 * @param score Результат события типа `KtorEventScore`.
 * @param startAt Время начала события типа `Instant`.
 * @param factors Список факторов события типа `List<KtorEventFactor>`.
 * @param sportId Идентификатор вида спорта типа `Sport`.
 */
@Suppress("Unused")
data class KtorEventSlim(
	override val eventId: String,
	override val status: KtorEventStatus,
	override val eventName: String? = null,
	override val teamGuest: KtorEventTeam,
	override val teamHost: KtorEventTeam,
	override val score: KtorEventScore? = null,
	override val startAt: Instant? = null,
	override val factors: List<KtorEventFactor> = listOf(),
	override val sportId: Sport
) : AbstractKtorEventDto(), IKtorBasicEvent