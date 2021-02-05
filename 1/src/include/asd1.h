/// @file asd1.h
#ifndef ASD1_H
#define ASD1_H

#include "matrix.h"

/**
 * @brief Returns array of sums of columns of given matrix.
 * @param[in] data_ Input matix
 * @return Sums of columns of data_
 */
auto col_sums(const Matrix<int>& data_) -> int*;


/**
 * @brief Return index of maximum element in given array.
 * @param[in] array Sample array
 * @param[in] size Size of sample array
 * @return Index of largest value in sample array
 */
auto idx_max(int const* array, size_t size) -> int;

#endif
