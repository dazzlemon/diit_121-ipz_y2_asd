#include "asd1.h"
#include "helper/taxi_data.h"
#include "helper/prints.h"

int main() {
	auto [data_, size] = taxi_station_data();
	
	auto daywise_sums = col_sums(data_, size, 7);
	auto idx = idx_max(daywise_sums, 7);

	print_stats(data_, daywise_sums, size, idx);
	
	delete_taxi_station_data(data_, size);
}
