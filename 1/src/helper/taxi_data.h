#include <random>
#include <limits.h>

auto taxi_station_data(const int&) -> std::pair<int**, int>;
auto taxi_station_data() -> std::pair<int**, int>;
int* taxi_data(const int& seed);
void delete_taxi_station_data(int**, int);

auto taxi_station_data() -> std::pair<int**, int> {
	auto rd = std::random_device();
	return taxi_station_data(rd());
}

auto taxi_station_data(const int& seed) -> std::pair<int**, int> {
	auto generator = std::default_random_engine(seed);
	auto distributionN = std::uniform_int_distribution<int>(10, 20);
	auto distributionSeed = std::uniform_int_distribution<int>(0, INT_MAX);
	auto nOfTaxis = distributionN(generator);
	auto data_ = new int*[nOfTaxis];
	for (int i = 0; i < nOfTaxis; i++) {
		auto taxi_seed = distributionSeed(generator);
		auto row = taxi_data(taxi_seed);
		data_[i] = row;
	}
	return std::make_pair(data_, nOfTaxis);
}

int* taxi_data(const int& seed) {
	auto generator = std::default_random_engine(seed);
	auto distribution = std::uniform_int_distribution<int>(100, 999);
	auto data_ = new int[7];
	for (int i = 0; i < 7; i++)
		data_[i] = distribution(generator);
	return data_;
}

void delete_taxi_station_data(int** data_, int size) {
	for (int i = 0; i < size; i++)
		delete [] data_[i];
	delete [] data_;
}


