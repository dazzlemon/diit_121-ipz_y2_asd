#include "asd1.h"
#include "taxi_data.h"
#include "prints.h"

int main() {
	auto rd = std::random_device();
	auto gen = std::default_random_engine(rd());
	auto distrib = std::uniform_int_distribution<size_t>(10, 20);

	auto td = TaxiData(distrib(gen));
	fill_rand(td);
	
	auto sums = col_sums(td.df());
	auto idx = idx_max(sums, 7);

	print_stats(td, sums, idx);
}
