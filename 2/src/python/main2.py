import matplotlib.pyplot as plt
import numpy as np
from py4j.java_gateway import JavaGateway
from scipy.optimize import curve_fit
from sklearn.metrics import r2_score

gateway = JavaGateway()
tests = gateway.jvm.asd2.Tests

data = [
    (tests.quickSort(), 'quicksort; %5.3f * n * log(n)', lambda n, c: c * n * np.log(n)),
    (tests.bubbleSort(), 'bubblesort; %5.3f * n^2', lambda n, c: c * n * n),
    (tests.gnomeSort(), 'gnomesort; %5.3f * n^2', lambda n, c: c * n * n)
]

for s, l, f in data:
    s = np.array(s)
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
