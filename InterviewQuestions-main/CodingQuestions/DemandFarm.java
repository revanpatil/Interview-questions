//Two arrays are equal or not.

arr[] arr1 = {}
arr[] arr2 = {}

Map<Integer, Integer> map = new HashMap<>();

for(int num : arr1){
	map.put(num, map.getOrDefault(num, 0) + 1);
}

for(int num: arr2){
	if(num == map.get(num) && ){
		map.put(num, map.get(num) - 1);
	} else{
		return "not equal"
	}
}



/*arr =  [[1, 2, 3], 
		[0,1, 0], 
		[4, 0, 0]]
*/
int colSum = 0;
int rowSum = 0;

int colAns = 0; 
int rowAns = 0;

int current = 0;
int currentCol = 0;

for(int i = 0; i < arr.length; i++){
	for(int j = 0; j < arr[0].length; j++){
		current = current + arr[i][j];
	}
	
	
	if(rowSum < current){
		rowAns = i;
		rowSum = current;
	}
	
	//for col 0 0 1 0 2 0 
	
	for(k = 0; k < arr.length; k++){
		currentCol = currentCol + arr[k][i];
	}
	
	if(colSum < currentCol){
		colAns = k;
		colSum = current;
	}
}

sout(rowAns, colAns)


Employee table:

id
name 
dept
manager_id
salary

deptwise total salary where employee > 1


SELECT dept,SUM(salary) AS total_salary
FROM Employee
GROUP BY dept
HAVING COUNT(id) > 1;


SELECT dept,SUM(salary) AS total_salary
FROM Employee e1
Join Employee e2 ON e1.dept = e2.dept AND e1.id <> e2.id
GROUP BY dept
 	
