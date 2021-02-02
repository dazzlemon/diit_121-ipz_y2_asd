#include <random>
#include <limits.h>

auto taxi_station_data(int) -> std::pair<int**, size_t>;
auto taxi_station_data() -> std::pair<int**, size_t>;
void delete_taxi_station_data(int**, int);

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
auto taxi_station_data() -> std::pair<int**, size_t> {
	auto rd = std::random_device();
	return taxi_station_data(rd());
}

/* in:
 *   seed - number to init generator
 * out:
 *   same as taxi_station()
 * info:
 *   same as taxi_station() */
auto taxi_station_data(int seed) -> std::pair<int**, size_t> {
	auto generator = std::default_random_engine(seed);
	auto distributionRowsAmount = std::uniform_int_distribution<int>(10, 20);
	auto distributionDay = std::uniform_int_distribution<int>(100, 999);
	
	size_t nOfTaxis = distributionRowsAmount(generator);
	auto data_ = new int*[nOfTaxis];
	for (size_t i = 0; i < nOfTaxis; i++) {
		data_[i] = new int[7];
		for (int j = 0; j < 7; j++)
			data_[i][j] = distributionDay(generator);
	}
	return std::make_pair(data_, nOfTaxis);
}

/* in:
 *   data_ - 2d array n * 7
 *   size - n for "data_"
 * out:
 *   -
 * info:
 *   frees memory of "data_"
 * */
void delete_taxi_station_data(int** data_, size_t size) {
	for (size_t i = 0; i < size; i++)
		delete [] data_[i];
	delete [] data_;
}
