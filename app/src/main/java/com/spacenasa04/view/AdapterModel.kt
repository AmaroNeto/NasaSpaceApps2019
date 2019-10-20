package com.spacenasa04.view

interface AdapterModel {
    fun layoutId(): Int
    fun isFilterable(filter: String): Boolean
}