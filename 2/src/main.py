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

for s in data:
    lis = list(s)
    print(lis)
    plt.scatter(y=lis,
                x=np.arange(0, len(lis)))
plt.legend(['quicksort', 'bubblesort', 'gnomesort'])

plt.show()
