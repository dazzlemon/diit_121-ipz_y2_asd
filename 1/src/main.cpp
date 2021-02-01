#include "taxi_data.h"
#include "asd1.h"
#include "prints.h"

int main() {
	auto data_ = taxi_station_data();
	
	auto daywise_sums = col_sums(data_.first, data_.second, 7);
	auto idx = idx_max(daywise_sums, 7);

	print_stats(data_.first, daywise_sums, data_.second, idx);
	
	delete_taxi_station_data(data_.first, data_.second);
}
