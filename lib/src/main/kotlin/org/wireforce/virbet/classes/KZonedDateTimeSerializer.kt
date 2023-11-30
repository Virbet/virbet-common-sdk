package org.wireforce.virbet.classes

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.ZonedDateTime

/**
 * Объект `KZonedDateTimeSerializer` представляет собой сериализатор для типа `ZonedDateTime`.
 */
object KZonedDateTimeSerializer : KSerializer<ZonedDateTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ZonedDateTime", PrimitiveKind.STRING)

    /**
     * Метод `serialize` выполняет сериализацию значения `ZonedDateTime` в строковый формат.
     *
     * @param encoder Объект типа `Encoder`.
     * @param value Значение типа `ZonedDateTime` для сериализации.
     */
    override fun serialize(encoder: Encoder, value: ZonedDateTime) {
        encoder.encodeString(value.toString())
    }

    /**
     * Метод `deserialize` выполняет десериализацию строки в значение типа `ZonedDateTime`.
     *
     * @param decoder Объект типа `Decoder`.
     * @return Значение типа `ZonedDateTime` после десериализации.
     */
    override fun deserialize(decoder: Decoder): ZonedDateTime {
        val string = decoder.decodeString()
        return ZonedDateTime.parse(string)
    }
}