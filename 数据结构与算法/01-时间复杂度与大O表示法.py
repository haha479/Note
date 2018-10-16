# 如果a+b+c = 1000, a^2 + b^2 = c^2, 请清楚a,b,c可能的值
import time 

start_time = time.time()
# 第一种程序方式
# for a in range(0,1001):
# 		for b in range(0,1001):
# 			for c in range(0,1001):
# 				if a+b+c == 1000 and a**2 + b**2 == c**2:
# 					print('a, b, c=%d, %d, %d'% (a, b, c))

T = 1000 * 1000 * 1000 * 2
T = 1000 * 1000 * 1000 * 10
T = N * N * N * 2

T(n) = n^3 * 2
T(n) = n^3 * 10
# 上面2和10也就是上面的程序最里面for执行的运算数量(算的大体或细致)
# 而此函数的特征与后面的常数(2和10关系影响不大,所以可以忽略)
T(n) = g(n)
# 上面的T(n)就为时间复杂度

g(n) = n^3
# n^3就是它的大O表示法

# 第二种程序方式: 当a和b的值确定后, c的值也可以确定了
for a in range(0,1001):
		for b in range(0,1001):
			c = 1000 - a - b
			if a**2 + b**2 == c**2:
				print('a, b, c=%d, %d, %d'% (a, b, c))
	'''
	程序的运行离不开计算机环境(包括硬件和操作系统), 这些都会影响程序运行的速度并反应在程序的执行时间上
	所以不能单靠时间值去评估一个算法的效率
	每台机器执行的总时间不同
	但是执行'基本运算数量'大体相同(因为是执行的相同程序)
	基本运算数量总和就是'时间复杂度'
	'''

end_time = time.time()


print('times: ', end_time-start_time)
print('finished')