#include "asd1.h"
#include "matrix.h"
#include <memory>

auto col_sums(const Matrix<int>& data_) -> int* {
	int* result = new int[data_.getCols()];// cppcoreguidelines-owning-memory
	for (size_t j = 0; j < data_.getCols(); j++) {
		result[j] = 0;// cppcoreguidelines-pro-bounds-pointer-arithmetic
		for (size_t i = 0; i < data_.getRows(); i++) {
			result[j] += data_.get(i, j);// cppcoreguidelines-pro-bounds-pointer-arithmetic
		}
	}
	return result;
}


auto idx_max(int const* array, size_t size) -> int {
	int res = 0;
	for (size_t i = 0; i < size; i++) {
		if (array[i] > array[res]) {// cppcoreguidelines-pro-bounds-pointer-arithmetic
			res = i;
		}
	}
	return res;
}
