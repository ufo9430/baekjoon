V, E = map(int, input().split())
K = int(input())
arr = [[] for _ in range(V)]
for _ in range(E):
    u, v, w = map(int, input().split())
    arr[u-1].append((v-1, w))
import heapq
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance = [float('inf')] * V
    distance[start] = 0
    while q:
        dist, curr = heapq.heappop(q)
        if distance[curr] < dist:
            continue
        for next_node, weight in arr[curr]:
            cost = dist + weight
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))
    return distance
for i in dijkstra(K-1):
    if i == float('inf'):
        print("INF")
        continue
    print(i)