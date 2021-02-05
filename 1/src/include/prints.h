/// @file prints.h

#ifndef PRINTS_H
#define PRINTS_H

#include "taxi_data.h"

/**
 * @brief Prints table for given TaxiData object.
 * @param[in] td TaxiData object
 * @details
 * Prints table for given TaxiData object.
 * Columns represent days starting from monday,
 * rows represent individual taxis.
 */
void print(const TaxiData& td);


/**
 * @brief Prints table for given TaxiData object.
 * @param[in] td TaxiData object
 * @param[in] sums Summaries of each day
 * @param[in] day Index of the most profitable day
 * @details
 * Prints table for given TaxiData object.
 * Columns represent days starting from monday,
 * rows represent individual taxis.
 * Under the most profitable day there is indication - five star symbols('*').
 */
void print(const TaxiData& td, int const* sums, size_t day);

#endif
