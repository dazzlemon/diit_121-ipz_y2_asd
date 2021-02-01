#include <iostream>
#include <iomanip>

void print_taxi_station_data(int const* const*, int);
void print_result(int const*, int);
void print_stats(int const* const*, int const*, int, int);

void print_taxi_station_data(int const* const* data_, int size) {
	std::cout << "           MON   TUE   WED   THU   FRI   SAT   SUN" << std::endl;
	for (int i = 0; i < size; i++) {
		std::cout << "taxi " << std::setw(2) << i + 1 << ":";
		for (int j = 0; j < 7; j++)
			std::cout << " " << std::setw(5) << data_[i][j];
		std::cout << std::endl;
	}
}

void print_result(int const* days, int day) {
	std::cout << "        ";
	for (int i = 0; i < 7; i++)
		std::cout << " " << std::setw(5) << days[i];
	std::cout << std::endl << "         ";
	for (int i = 0; i < day; i++)
		std::cout << "      ";
	std::cout << "*****" << std::endl;
}

void print_stats(int const* const* dataframe, int const* sums, int size, int day) {
	print_taxi_station_data(dataframe, size);
	print_result(sums, day);
}
