#include <random>
#include <limits.h>
#include "../matrix.h"

/* in:
 *   seed - number to init generator
 * out:
 *   same as taxi_station()
 * info:
 *   same as taxi_station() */
auto taxi_station_data(int seed) -> Matrix<int> {
	auto generator = std::default_random_engine(seed);
	auto distributionRowsAmount = std::uniform_int_distribution<int>(10, 20);
	auto distributionDay = std::uniform_int_distribution<int>(100, 999);
	
	size_t rows = distributionRowsAmount(generator);
	auto data_ = Matrix<int>(rows, 7);
	for (size_t i = 0; i < rows; i++) {
		for (int j = 0; j < 7; j++)
			data_.at(i, j) = distributionDay(generator);
	}
	return data_;
}

/* in:
 *   -
 * out:
 *   pair:
 *     first - 2d array, 7 cols
 *     second - amount of rows in "first"
 * info:
 *   generates n * 7 2d array,
 *   n = 10 to 20,
 *   fills it with values from 100 to 999
 *   returns this array paired with n
 *      actually delegates work to taxi_station(int) */
auto taxi_station_data() -> Matrix<int> {
	auto rd = std::random_device();
	return taxi_station_data(rd());
}
