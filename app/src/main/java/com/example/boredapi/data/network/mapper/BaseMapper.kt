package com.example.boredapi.data.network.mapper

/**
 * Generic interface for mapping between different data types.
 *
 * @param IN The input type to be mapped.
 * @param OUT The output type to which the data will be mapped.
 */
interface BaseMapper<IN,OUT> {
    /**
     * Maps an object of type[IN] to an object of type [OUT]
     *
     * @param input The opbject of type [IN] to be mapped.
     * @return The mapped object of type [OUT]
     */
    fun mapFromInput(input: IN): OUT
}