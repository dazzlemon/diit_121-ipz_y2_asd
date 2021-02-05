#ifndef TAXI_DATA_H
#define TAXI_DATA_H

#include "matrix.h"
#include <climits>
#include <random>

const size_t DAYS_IN_WEEK = 7;

/**
 * Represents a week table of daily profits for a taxi station.
 */
class TaxiData {
	size_t size;
	Matrix<int>* dataframe;
public:
	explicit TaxiData(size_t size) : size(size) {
		this->dataframe = new Matrix<int>(size, DAYS_IN_WEEK);// cppcoreguidelines-owning-memory
	}

	/**
	 * Returns amount of taxis working on station.
	 */
	[[nodiscard]] auto getSize() const -> size_t {return this->size;}

	/**
	 * Returns a reference to the raw datatable.
	 */
	auto df() -> Matrix<int>& {return *this->dataframe;}

	/**
	 * Returns profit for xth taxi on yth day.
	 */
	[[nodiscard]] auto get(size_t x, size_t y) const -> int {return this->dataframe->at(x, y);}
};

/**
 * @brief Fills TaxiData object with random values from 100 to 999.
 * @param[in] td Pointer to TaxiData object
 * @param[in] seed Seed to initialize prng
 */
void fill_rand(TaxiData* td, int seed);


/**
 * @brief Fills TaxiData object with random values from 100 to 999.
 * @param[in] td Pointer to TaxiData object
 */
void fill_rand(TaxiData* td);

#endif
