import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

"""
    first line - quicksort
    second     - bubblesort
    third      - gnomesort
    (space separated values)
"""
with open('tests.txt', 'r') as f:
    data = list(map(
        lambda s: list(map(
            lambda n: int(n),
            s.replace('\n', '').split()
        )),
        f.readlines()
    ))

data[0] = (data[0], 'quicksort 10 * n * log(n)', lambda n: 10 * n * np.log(n))
data[1] = (data[1], 'bubblesort 3.5 * n^2', lambda n: 3.5 * n * n)
data[2] = (data[2], 'gnomesort 1.75 * n^2', lambda n: 1.75 * n * n)

data = np.array(data, dtype=object)

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(0, len(s))
    plt.scatter(x, s, label=l)
    plt.plot(x, f(x), 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
