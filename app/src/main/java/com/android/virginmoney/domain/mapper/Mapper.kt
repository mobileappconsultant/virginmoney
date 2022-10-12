package com.android.virginmoney.domain.mapper

interface Mapper<E, D, I> {
    fun toEntity(value: D): E
    fun toItem(value: E): I
}
