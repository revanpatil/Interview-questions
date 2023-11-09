# Round 2

1 

2 13 

3 12 14 

4 11 15 22 

5 10 16 21 23 

6 9 17 20 24 27 

7 8 18 19 25 26 28

```java

int rows = 7;

for(int i = 0; i < rows; i++){
	int num = i;
	
	for(int j = 1; j <= i; j++){
		sout(num + " ");
		num = num + rows - j;
	}
	
	sout() // new line
	
}

```









Given an array of integers (both odd and even), arrange them in such a way that
 odd and even values come in alternate fashion in ascending order respectively such that

 If the smallest value is Even then we have to print Even-Odd pattern.

 If the smallest value is Odd then we have to print Odd-Even pattern

 

Input: arr[] = {1, 3, 2, 5, 4, 7, 10}

Output: 1, 2, 3, 4, 5, 10, 7

  

Input: arr[] = {9, 8, 13, 2, 19, 14}

Output: 2, 9, 8, 13, 14, 19


odd = 1 3 5 7 
even = 2 4 10 12 14 16

1 2 3 4 5 10 7

```java

boolean isEven = (arr[0] % 2 == 0);

List<Integer> odd = new ArrayList<>();
List<Integer> even = new ArrayList<>();


for(int i = 0; i < arr.length; i++){
	for(int j = 1; j < arr.length - i; j ++){
		if(arr[i] > arr[j]){
			swap(arr, i, j);
		}
	}
}


private static swap(int[] arr, int n1, int n2){
	int temp = arr[n1];
	arr[n1] = arr[n2];
	arr[n2] = temp;
}

//arr is sorted

for(int num : arr){
	if(num % 2 == 0){
		even.add(num);
	}else{
		odd.add(num);
	}
}

int evenCounter = 0;
int oddCounter = 0;

while(evenCounter < even.size() && oddCounter < odd.size()){

	if(isEven){
		sout(even.get(evenCounter);
		sout(odd.get(oddCounter);
	}
	
	
	sout(odd.get(oddCounter);
	sout(even.get(evenCounter);
	
	
	evenCounter++;
	oddCounter++;
}

if(evenCounter < even.size()){
	sout(subarray of (evenCounter, even.size))
}

if(oddCounter < odd.size()){
	sout(subarray of (oddCounter, odd.size))
}

```







```mysql

Schema

Dept(ID, name)

Emp(ID, name, sal, designation, Mgr_id, Dept_id)

Mgr(id, name)

 

Questions

1. Print Max Salary from each department along with the dept name

Select D.name as DepartmentName, Max(E.sal) AS MaxSalary From
Dept D
Join Emp E on D.ID = E.Dept_id
Group By D.name;

2. Print all employees which are also manager in 'Finance' department

Select * Emp.name 
WHERE
Emp.Id IN(Select Mgr_id From Emp Where designation = 'Manager' AND Dept_id = (Select ID From Dept WHERE name ='Finance')); 

3. Print 3rd Highest salaries records
Select Distinct E1.name ,E1.sal
From Emp E1
Where 3 = (Select Count(Distinct E2.sal) From Emp E2 where E2.sal > E1.sal);

4. Print all the departments where max sal > 20000

Select D.name AS DepartmentName
From Dept D 
Where 20000< (Select Max(E.sal) From Emp E Where E.Dept_id = D.Id);


```

4 inputs
day
month
year
days to add

10 1 2023 10
out - 20 1 2023

```java
arr[] = {0 , 31, 28, }

public void daysToAdd(int inpuDay,int inputMonth, int inputYear, int daysToAdd){

int[] daysinMonth={0,31,28,31,30,31,30....}

int newDay;

int newMonth = inputMonth;
int newYear = inputYear;


if(daysToAdd >= 365){
	int yearsToAdd = daysToAdd / 365;
	int newDay = inputDay + daysToAdd % 365;
}else{
	newDay = inputDay + daysToAdd;
}



newYear = inputYear + yearsToAdd;

if(newDay>daysinMonth[inputMonth]){
	newDay -= daysinMonth[inputMonth];
	newMonth++;
	if(newMonth > 12){
		newMonth =1;
		newYear++
	}
}

System.out.println(newDay +" " +newMonth + " " + newYear)
```


# Round 3

array => [3,2,1,4,3,5,2,3,4,6,8]

count occurences of each element 

print elements and counts in descending order of counts

Output:

3 => 3 times

2 => 2 times

4 => 2 times

1 => 1 time

```java
Map<Integer, Integer> map = new HashMap<>();

for(int num : array){
	if(map.containsKey(num)){
		map.put(num, map.get(num) + 1);
	} else{
		map.put(num, 1);
	}
}

List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
	sortedEntries.sort((entry1, entry2) -> entry2.getValue().comapareTo(entry1.getValue));
	
	
for(Map.Entry<Integer, Integer> entry : sortedEntries){
	System.out.println("Number - " + entry.getKey() + " Occurrance => " + entry.getValue);
}	
```

Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example:

Input matrix : (mat)

0 1 1 1

0 0 1 1

1 1 1 1 // this row has maximum 1s

0 0 0 0

Output: 2

```java

int maxRowCount = 0;
int currentRowCount = 0;
int maxRow = 0;

for(int i = 0; i < mat.length; i++){
	
	if(currentRowCount == mat.length[i]){
		System.out.println("Max row = " + i);
		return;
	}
	

	for(j = 0; j < mat.length[i]; j++){
		if(mat[i][j] == 1){
			currentRowCount++;
		}
	}
	
	if(currentRowCount > maxRowCount){
		maxRowCount = currentRowCount;
		maxRow = i;
	}
}
```

```mysql
Q3: Consider a table employee_reimburse_amount and below sample data.

+-------------+---------------+

| emp_name | reimburse_type | Amount

+-------------+---------------+

| Ram | dinner | 150 |

| Ram | lunch | 100 |

| Ram | lunch | 100 |

| Naresh | breakfast | 100|

| Mahesh| lunch| 100 |

| Naresh | lunch | 100 |

| Naresh | breakfast | 150 |

+-------------+---------------+

 

Write a query which will output the employee name , type and total reimburse amount for the employees 
whose total reimburse amount for a particular reimburse_type is greater than 200.

Select emp_name, reimburse_type, SUM(Amount)
FROM employee_reimburse_amount
GROUP BY emp_name, reimburse_type 
HAVING SUM(amount) > 200;
 

Above sample data will give output as below

 

Naresh | breakfast | 250
```
