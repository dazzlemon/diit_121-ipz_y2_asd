int* col_sums(int const* const*, int, int);
int idx_max(int const*, int);

/* in:
 *   data_ - 2d array
 *   rows - rows amount for "data_"
 *   cols - cols amount for "data_"
 * out:
 *   array, len = "cols", sum of each column of data_.first
 * info:
 *   doesnt alter input data*/
int* col_sums(int const* const* data_, int rows, int cols) {
	int* result = new int[cols];
	for (int j = 0; j < cols; j++) {
		result[j] = 0;
		for (int i = 0; i < rows; i++)
			result[j] += data_[i][j];
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
int idx_max(int const* array, int size) {
	int res = 0;
	for (int i = 0; i < size; i++)
		if (array[i] > array[res])
			res = i;
	return res;
}
