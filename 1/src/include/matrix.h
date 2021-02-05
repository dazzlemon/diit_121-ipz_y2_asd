#ifndef __MATRIX_H__
#define __MATRIX_H__

#include <cstddef>

template<class T>
class Matrix {
	T** __matrix;
	size_t __rows;
	size_t __cols;
public:
	Matrix(size_t rows, size_t cols) {
		__rows = rows;
		__cols = cols;
		__matrix = new T*[__rows];
		for (size_t i = 0; i < __rows; i++)
			__matrix[i] = new T[__cols];
	}

	Matrix(const Matrix<T>& other) {
		Matrix(other.rows(), other.cols());
		for (size_t i = 0; i < __rows; i++)
			for (size_t j = 0; j < __cols; j++)
				__matrix[i][j] = other.get(i, j);
	}

	~Matrix() {
		for (size_t i = 0; i < __cols; i++)
			delete [] __matrix[i];
		delete __matrix;
	}

	T& at(size_t x, size_t y) {
		return __matrix[x][y];
	}

	T get(size_t x, size_t y) const {
		return __matrix[x][y];
	}

	size_t rows() const {return __rows;}

	size_t cols() const {return __cols;}
};
#endif
