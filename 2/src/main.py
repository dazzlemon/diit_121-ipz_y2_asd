import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

with open('tests.txt', 'r') as f:
    data = map(
        lambda s: map(
            lambda n: int(n),
            s.replace('\n', '').split()
        ),
        f.readlines()
    )

labels = ['quicksort', 'bubblesort', 'gnomesort']
for s, l in zip(data, labels):
    y = list(s)
    x = np.arange(0, len(y))

    z = np.polyfit(x, y, 2)
    p = np.poly1d(z)

    plt.scatter(x, y,
                label=l + ' y=%.6fx2+(%.6fx)+(%.6f)'%(z[0], z[1], z[2]))
    #plt.plot(x, p(x), 'r--')

plt.legend(loc='upper left')
plt.title('Sorting algorithms')
plt.xlabel('Length of array')
plt.ylabel('Operations taken')
plt.show()
