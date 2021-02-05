#include "taxi_data.h"
#include <iomanip>
#include <iostream>

const size_t COLUMN_WIDTH = 5;

void print(const TaxiData& td) {
	for (size_t i = 0; i < td.getSize(); i++) {
		std::cout << "taxi " << std::setw(2) << i + 1 << ":";
		for (size_t j = 0; j < DAYS_IN_WEEK; j++) {
			std::cout << " " << std::setw(COLUMN_WIDTH) << td.get(i, j);
		}
		std::cout << std::endl;
	}
}


void print_result(int const* days, size_t day) {
	std::cout << "SUM     ";
	for (size_t i = 0; i < DAYS_IN_WEEK; i++) {
		std::cout << " " << std::setw(COLUMN_WIDTH) << days[i];// cppcoreguidelines-pro-bounds-pointer-arithmetic
	}
	std::cout << std::endl << "         ";
	for (size_t i = 0; i < day; i++) {
		std::cout << "      ";
	}
	std::cout << "*****" << std::endl;
}


void print_heading() {
	std::cout << "DAY        MON   TUE   WED   THU   FRI   SAT   SUN" << std::endl;
}


void print(const TaxiData& td, int const* sums, size_t day) {
	print_heading();
	std::cout << std::endl;
	print(td);
	std::cout << std::endl;
	print_result(sums, day);
}
