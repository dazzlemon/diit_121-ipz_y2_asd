/// @file matrix.h
#ifndef MATRIX_H
#define MATRIX_H

#include <cstddef>

/**
 * Represents a 2D matrix
 */
template<class T>
class Matrix {
	T** matrix;
	size_t rows;
	size_t cols;

	void reserve();
	void free();
	void copy(const Matrix& other);

public:
	Matrix(size_t rows, size_t cols);
	Matrix(const Matrix& other);
	Matrix(Matrix&& other);
	~Matrix();
	
	auto operator= (const Matrix& other) -> Matrix&;
	auto operator= (Matrix&& other) -> Matrix&;

	/**
	 * Returns a reference to element at [x][y].
	 */
	auto at(size_t x, size_t y) -> T&;


	/**
	 * Returns a value of element at [x][y].
	 */
	auto get(size_t x, size_t y) const -> T;


	/**
	 * Returns amount of rows in this object.
	 */
	[[nodiscard]] auto getRows() const -> size_t {return this->rows;}
	

	/**
	 * Returns amount of columns in this object.
	 */
	[[nodiscard]] auto getCols() const -> size_t {return this->cols;}
};

template<class T>
void Matrix<T>::reserve() {
	this->matrix = new T*[this->rows];// cppcoreguidelines-owning-memory
	for (size_t i = 0; i < this->rows; i++) {
		this->matrix[i] = new T[this->cols];// cppcoreguidelines-owning-memory
	}
}


template<class T>
void Matrix<T>::copy(const Matrix& other) {
	for (size_t i = 0; i < this->rows; i++) {
		for (size_t j = 0; j < this->cols; j++) {
			this->matrix[i][j] = other.get(i, j);
		}
	}
}


template<class T>
Matrix<T>::Matrix(size_t rows, size_t cols) : rows(rows), cols(cols) {
	reserve();	
}


template<class T>
Matrix<T>::Matrix(const Matrix& other) : rows(other.rows), cols(other.cols) {
	this->reserve();
	this->copy(other);
}


template<class T>
Matrix<T>::Matrix(Matrix&& other) : rows(other.rows), cols(other.cols) {
	this->reserve();
	this->copy(other);
	for (size_t i = 0; i < this->rows; i++) {
		for (size_t j = 0; j < this->cols; j++) {
			other.matrix[i][j] = T(0);
		}
	}
}


template<class T>
Matrix<T>::~Matrix() {
	this->free();
}


template<class T>
auto Matrix<T>::operator= (const Matrix& other) -> Matrix& {
	if (this != &other) {
		this->free();
		this->reserve();
		this->copy(other);
	}
	return *this;
}


template<class T>
auto Matrix<T>::operator= (Matrix&& other) -> Matrix& {
	this->free();
	this->copy(other);
	for (size_t i = 0; i < this->rows; i++) {
		for (size_t j = 0; j < this->cols; j++) {
			other.matrix[i][j] = T(0);
		}
	}
}


template<class T>
void Matrix<T>::free() {
	for (size_t i = 0; i < this->cols; i++) {
		delete [] this->matrix[i];// cppcoreguidelines-owning-memory
	}
	delete this->matrix;
}


template<class T>
auto Matrix<T>::at(size_t x, size_t y) -> T& {
	return this->matrix[x][y];
}


template<class T>
auto Matrix<T>::get(size_t x, size_t y) const -> T {
	return this->matrix[x][y];
}

#endif
