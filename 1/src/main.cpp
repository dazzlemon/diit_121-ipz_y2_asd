
template<class T>
class Matrix {
	int rows;
	int cols;
	T** elems;

public:
	Matrix(const int& rows, const int& cols) : rows(rows), cols(cols) {
		elems = new T*[rows];
		for (int i = 0; i < rows; i++)
			elems[i] = new T[col];
	}

	~Matrix() {
		for (int i = 0; i < rows; i++)
			delete [] elems[i];
		delete [] elems;
	}

	int getRows() {return rows;}
	int getCols() {return cols;}
	T& get(const size_t& x, const size_t& y) {return elems[x][y]}	
}

bool chooseFill() {
	return true;
}

int promptDriversAmount() {
	return 1;
}

void fillRandom(const int& min, const int& max, Matrix<int>& m) {

}

void fillManual(Matrix<int>& m) {

}

void printMatrix(Matrix<int>& m) {

}

auto mostProfitableDay(Matrix<int>& t) {
	
}

int main() {
	Matrix<int> table;
	if (chooseFill()) {
		table = new Matrix(, 7);
		fillRandom(100, 200, table);
	} else {
		table = new Matrix(promptDriversAmount(), 7);
		fillManual(table);
	}

	auto mostProfitableDay = mostProfitableDay(table);
}
