#include "asd1.h"
#include "prints.h"
#include "taxi_data.h"

auto main() -> int {
	const size_t MIN_TAXIS = 10;
	const size_t MAX_TAXIS = 20;

	auto rd = std::random_device();
	auto gen = std::default_random_engine(rd());
	auto distrib = std::uniform_int_distribution<size_t>(MIN_TAXIS, MAX_TAXIS);

	auto td = TaxiData(distrib(gen));
	fill_rand(&td);
	
	auto* sums = col_sums(td.df());
	auto idx = idx_max(sums, DAYS_IN_WEEK);

	print(td, sums, idx);
}
