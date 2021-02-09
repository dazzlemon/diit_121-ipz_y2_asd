import matplotlib.pyplot as plt
import numpy as np
from py4j.java_gateway import JavaGateway

gateway = JavaGateway()

data = np.array([
    (list(gateway.jvm.src.Tests.quickSort()), 'quicksort 10 * n * log(n)', lambda n: 10 * n * np.log(n)),
    (list(gateway.jvm.src.Tests.bubbleSort()), 'bubblesort 3.5 * n^2', lambda n: 3.5 * n * n),
    (list(gateway.jvm.src.Tests.gnomeSort()), 'gnomesort 1.75 * n^2', lambda n: 1.75 * n * n)
])

for s, l, f in data[[0, 1, 2]]:
    x = np.arange(0, len(s))
    plt.scatter(x, s, label=l)
    plt.plot(x, f(x), 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
