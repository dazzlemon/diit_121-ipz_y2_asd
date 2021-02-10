import matplotlib.pyplot as plt
import numpy as np
from py4j.java_gateway import JavaGateway
from scipy.optimize import curve_fit

gateway = JavaGateway()

data = np.array([
    (list(gateway.jvm.src.Tests.quickSort())[1:], 'quicksort %5.3f * n * log(n)', lambda n, c: c * n * np.log(n)),
    (list(gateway.jvm.src.Tests.bubbleSort()), 'bubblesort %5.3f * n^2', lambda n, c: c * n * n),
    (list(gateway.jvm.src.Tests.gnomeSort()), 'gnomesort %5.3f * n^2', lambda n, c: c * n * n)
], dtype=object)

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(0, len(s))
    fitargs, cov = curve_fit(f, x, s)

    fitdata = f(x, *fitargs)
    abs_err = s - fitdata

    sqr_err           = np.square(abs_err)
    mean_sqr_err      = np.mean(sqr_err)
    root_mean_sqr_err = np.sqrt(mean_sqr_err)
    r2                = 1.0 - (np.var(abs_err) / np.var(fitdata))

    plt.scatter(x, s, label=l % tuple(fitargs) + ' R2 = %5.3f' % r2)
    plt.plot(x, fitdata, 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
