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
    plt.scatter(lis, np.arange(0, len(lis)))

#ts = pd.Series(np.random.randn(1000), index = pd.date_range(
#    '1/1/2000',
#    periods = 1000
#))

#ts = ts.cumsum()
#ts.plot()

plt.show()
