import matplotlib.pyplot as plt
import numpy as np
from py4j.java_gateway import JavaGateway
from scipy.optimize import curve_fit

gateway = JavaGateway()

tests = gateway.jvm.asd2.Tests
# [1:] is to skip the first element which is zero(otherwise log cant be calculated)
data = np.array([
    (np.array(tests.quickSort())[1:], 'quicksort; %5.3f * n * log(n)', lambda n, c: c * n * np.log(n)),
    (np.array(tests.bubbleSort())[1:], 'bubblesort; %5.3f * n^2', lambda n, c: c * n * n),
    (np.array(tests.gnomeSort())[1:], 'gnomesort; %5.3f * n^2', lambda n, c: c * n * n)
], dtype=object)

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(1, len(s) + 1)
    fitargs, cov = curve_fit(f, x, s)
    fitdata = f(x, *fitargs)
    abs_err = s - fitdata
    r2      = 1.0 - (np.var(abs_err) / np.var(fitdata))

    plt.scatter(x, s, label=l % tuple(fitargs) + '; R2 = %5.3f' % r2)
    plt.plot(x, fitdata, 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
