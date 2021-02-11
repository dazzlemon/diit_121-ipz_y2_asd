import matplotlib.pyplot as plt
import numpy as np
from scipy.optimize import curve_fit
from sklearn.metrics import r2_score

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

data[0] = (data[0], 'quicksort; %5.3f * n * log(n)', lambda n, c: c * n * np.log(n))
data[1] = (data[1], 'bubblesort %5.3f * n^2', lambda n, c: c * n * n)
data[2] = (data[2], 'gnomesort %5.3f * n^2', lambda n, c: c * n * n)

data = np.array(data, dtype=object)

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(1, len(s) + 1)
    fitargs, cov = curve_fit(f, x, s)
    fitdata = f(x, *fitargs)
    r2 = r2_score(s, fitdata)

    plt.scatter(x, s, label=l % tuple(fitargs) + '; R2 = %5.3f' % r2)
    plt.plot(x, fitdata, 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
