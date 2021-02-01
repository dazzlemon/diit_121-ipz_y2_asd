#include <random>
#include <iostream>
#include <limits.h>
#include <iomanip>

auto taxi_station_data(const int&) -> std::pair<int**, int>;
int* taxi_data(const int& seed);
void print_taxi_station_data(int**, int);
void delete_taxi_station_data(int**, int);
int* taxi_day_sums(const std::pair<int**, int>&);
int idx_max(int*, int);

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

void print_taxi_station_data(int** data_, int size) {
	std::cout << "           MON   TUE   WED   THU   FRI   SAT   SUN" << std::endl;
	for (int i = 0; i < size; i++) {
		std::cout << "taxi " << std::setw(2) << i + 1 << ":";
		for (int j = 0; j < 7; j++)
			std::cout << " " << std::setw(5) << data_[i][j];
		std::cout << std::endl;
	}
}

void delete_taxi_station_data(int** data_, int size) {
	for (int i = 0; i < size; i++)
		delete [] data_[i];
	delete [] data_;
}

int* taxi_day_sums(const std::pair<int**, int>& data_) {
	int* result = new int[7];
	for (int j = 0; j < 7; j++) {
		result[j] = 0;
		for (int i = 0; i < data_.second; i++)
			result[j] += data_.first[i][j];
	}
	return result;
}

int idx_max(int* array, int size) {
	int res = 0;
	for (int i = 0; i < size; i++)
		if (array[i] > array[res])
			res = i;
	return res;
}

void print_result(int* days, int day) {
	std::cout << "        ";
	for (int i = 0; i < 7; i++)
		std::cout << " " << std::setw(5) << days[i];
	std::cout << std::endl << "         ";
	for (int i = 0; i < day; i++)
		std::cout << "      ";
	std::cout << "*****" << std::endl;
}

int main() {
	auto rd = std::random_device();
	int seed = rd();
	auto data_ = taxi_station_data(seed);
	auto daywise_sums = taxi_day_sums(data_);
	auto idx = idx_max(daywise_sums, 7);
	print_taxi_station_data(data_.first, data_.second);
	print_result(daywise_sums, idx);
	delete_taxi_station_data(data_.first, data_.second);
}
