package com.android.core.utils

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

class DateTimeDeserializer : JsonDeserializer<DateTime>, JsonSerializer<DateTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): DateTime? =
        json
            ?.asString
            ?.takeIf { it.isNotEmpty() }
            ?.let { ISODateTimeFormat.dateTimeParser().parseDateTime(it) }

    override fun serialize(src: DateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src?.let { ISODateTimeFormat.dateTime().print(it) }.orEmpty())
    }
}
