#include "matrix.h"

/* in:
 *   data_ - 2d array
 *   rows - rows amount for "data_"
 *   cols - cols amount for "data_"
 * out:
 *   array, len = "cols", sum of each column of data_.first
 * info:
 *   doesnt alter input data*/
int* col_sums(const Matrix<int>& data_) {
	int* result = new int[data_.cols()];
	for (size_t j = 0; j < data_.cols(); j++) {
		result[j] = 0;
		for (size_t i = 0; i < data_.rows(); i++)
			result[j] += data_.get(i, j);
	}
	return result;
}

/* in:
 *   array: sample array
 *   size: size of "array"
 * out:
 *   idx of largest value in array
 * info:
 *   doesnt alter input data*/
int idx_max(int const* array, size_t size) {
	int res = 0;
	for (size_t i = 0; i < size; i++)
		if (array[i] > array[res])
			res = i;
	return res;
}
