package me.rerere.polymartapp.model.resource

import okhttp3.FormBody

class ResourceSearchParam {
    private val _params: MutableMap<String, String> = mutableMapOf()
    val params: Map<String, String> = _params

    fun addParam(key: String, value: String) {
        _params[key] = value
    }

    fun toFormBody() = FormBody.Builder().let {
        _params.forEach { (k, v) -> it.add(k, v) }
        it.build()
    }
}

fun searchResourceParams(vararg paramPairs: Pair<String, String>): ResourceSearchParam {
    val resourceSearchParam = ResourceSearchParam()
    paramPairs.forEach {
        resourceSearchParam.addParam(it.first, it.second)
    }
    return resourceSearchParam
}