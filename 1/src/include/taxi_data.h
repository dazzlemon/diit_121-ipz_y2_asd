#ifndef TAXI_DATA_H
#define TAXI_DATA_H

#include "matrix.h"
#include <climits>
#include <random>

const size_t DAYS_IN_WEEK = 7;

/**
 *
 */
class TaxiData {
	size_t size;
	Matrix<int>* dataframe;
public:
	explicit TaxiData(size_t size) {
		this->size = size;
		this->dataframe = new Matrix<int>(size, DAYS_IN_WEEK);// cppcoreguidelines-owning-memory
	}

	[[nodiscard]] auto getSize() const -> size_t {return this->size;}

	auto df() -> Matrix<int>& {return *this->dataframe;}

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
