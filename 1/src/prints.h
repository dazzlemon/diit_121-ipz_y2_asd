#include <iostream>
#include <iomanip>

void print_taxi_station_data(const TaxiData& td) {
	for (size_t i = 0; i < td.size(); i++) {
		std::cout << "taxi " << std::setw(2) << i + 1 << ":";
		for (size_t j = 0; j < 7; j++)
			std::cout << " " << std::setw(5) << td.get(i, j);
		std::cout << std::endl;
	}
}

void print_result(int const* days, size_t day) {
	std::cout << "SUM     ";
	for (size_t i = 0; i < 7; i++)
		std::cout << " " << std::setw(5) << days[i];
	std::cout << std::endl << "         ";
	for (size_t i = 0; i < day; i++)
		std::cout << "      ";
	std::cout << "*****" << std::endl;
}

void print_heading() {
	std::cout << "DAY        MON   TUE   WED   THU   FRI   SAT   SUN" << std::endl;
}

void print_stats(const TaxiData& td, int const* sums, size_t day) {
	print_heading();
	std::cout << std::endl;
	print_taxi_station_data(td);
	std::cout << std::endl;
	print_result(sums, day);
}
