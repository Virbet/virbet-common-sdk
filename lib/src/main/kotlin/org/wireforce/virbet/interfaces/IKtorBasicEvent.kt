package org.wireforce.virbet.interfaces

import kotlinx.datetime.Instant
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.dto.KtorEventFactor
import org.wireforce.virbet.dto.KtorEventScore
import org.wireforce.virbet.dto.KtorEventStatus
import org.wireforce.virbet.dto.KtorEventTeam

/**
 * Интерфейс `IKtorBasicEvent` предоставляет контракт для классов, представляющих основную информацию о событии в Ktor.
 */
interface IKtorBasicEvent {
	/**
	 * Свойство `status` представляет собой статус события типа `KtorEventStatus`.
	 */
	val status: KtorEventStatus

	/**
	 * Свойство `eventName` предоставляет имя события (может быть `null`).
	 */
	val eventName: String?

	/**
	 * Свойство `teamGuest` представляет команду-гостя события типа `KtorEventTeam`.
	 */
	val teamGuest: KtorEventTeam

	/**
	 * Свойство `teamHost` представляет команду-хозяина события типа `KtorEventTeam`.
	 */
	val teamHost: KtorEventTeam

	/**
	 * Свойство `score` предоставляет информацию о счете события типа `KtorEventScore` (может быть `null`).
	 */
	val score: KtorEventScore?

	/**
	 * Свойство `startAt` предоставляет момент начала события типа `Instant` (может быть `null`).
	 */
	val startAt: Instant?

	/**
	 * Свойство `sportId` представляет идентификатор вида спорта типа `Sport`.
	 */
	val sportId: Sport

	/**
	 * Свойство `factors` предоставляет список факторов события типа `KtorEventFactor`.
	 */
	val factors: List<KtorEventFactor>
}