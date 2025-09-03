N = int(input())
arr = []
def make_star(f):
    if f == 1:
        return ['*']
    else:
        stars = make_star(f//3)
        L = []
        for star in stars:
            L.append(star*3)
        for star in stars:
            L.append(star + ' '*(f//3) + star)
        for star in stars:
            L.append(star*3)
        return L
arr = make_star(N)
for line in arr:
    print(line)