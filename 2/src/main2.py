import matplotlib.pyplot as plt
import numpy as np
from py4j.java_gateway import JavaGateway
from scipy.optimize import curve_fit

gateway = JavaGateway()

data = np.array([
    (np.array(gateway.jvm.src.Tests.quickSort()), 'quicksort; %5.3f * n * log(n)', lambda n, c: c * n * np.log(n)),
    (np.array(gateway.jvm.src.Tests.bubbleSort()), 'bubblesort; %5.3f * n^2', lambda n, c: c * n * n),
    (np.array(gateway.jvm.src.Tests.gnomeSort()), 'gnomesort; %5.3f * n^2', lambda n, c: c * n * n)
], dtype=object)

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(0, len(s))
    fitargs, cov = curve_fit(f, x[1:], s[1:])

    fitdata = f(x[1:], *fitargs)
    abs_err = s[1:] - fitdata
    r2      = 1.0 - (np.var(abs_err) / np.var(fitdata))

    plt.scatter(x, s, label=l % tuple(fitargs) + '; R2 = %5.3f' % r2)
    plt.plot(x[1:], fitdata, 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
