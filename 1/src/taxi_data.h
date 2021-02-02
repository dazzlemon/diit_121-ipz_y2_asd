#include <random>
#include <limits.h>
#include "matrix.h"

class TaxiData {
	size_t __size;
	Matrix<int>* __dataframe;
public:
	TaxiData(size_t size) {
		__size = size;
		__dataframe = new Matrix<int>(size, 7);
	}

	size_t size() const {return __size;}

	Matrix<int>& df() {return *__dataframe;}

	int get(size_t x, size_t y) const {return __dataframe->at(x, y);}
};

/* in:
 *   td - taxi data table
 *   seed - number to init generator
 * out:
 *   -
 * info:
 *   fills td with values from 100 to 999 */
void fill_rand(TaxiData& td, int seed) {
	auto generator = std::default_random_engine(seed);
	auto distributionDay = std::uniform_int_distribution<int>(100, 999);	
	for (size_t i = 0; i < td.size(); i++)
		for (int j = 0; j < 7; j++)
			td.df().at(i, j) = distributionDay(generator);
}

/* in:
 *   td - taxi data table
 * out:
 *   -
 * info:
 *  generates random seed,
 *  calls fillrand(td, seed) */
void fill_rand(TaxiData& td) {
	auto rd = std::random_device();
	fill_rand(td, rd());
}
