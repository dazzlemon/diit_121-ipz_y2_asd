#include "taxi_data.h"

void fill_rand(TaxiData* td, int seed) {
	const size_t MIN = 100;
	const size_t MAX = 999;
	auto generator = std::default_random_engine(seed);
	auto distributionDay = std::uniform_int_distribution<int>(MIN, MAX);	
	for (size_t i = 0; i < td->getSize(); i++) {
		for (size_t j = 0; j < DAYS_IN_WEEK; j++) {
			td->df().at(i, j) = distributionDay(generator);
		}
	}
}


void fill_rand(TaxiData* td) {
	auto rd = std::random_device();
	fill_rand(td, rd());
}
