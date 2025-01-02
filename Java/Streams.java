
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
public class streamOperations 
 {
 public static void main(String[] args) 
//Initilization of stream
//Performing intermediate oprs.
//Terminal operation
 List<Employee> emps = employeesList();
 //initialization of stream 
 Stream<Employee> stream1 = emps.parallelStream();
 
// To fetch all employee names 
 List<String> list1 = emps.parallelStream()//Initilization
 .map(x->x.getName()) //intermediate operation
 .toList(); //terminal operation 
 System.out.println("Employee names : "+list1);
 
 //fetch all employee city names
 List <String> list2 = emps.parallelStream().map(x->x.getDept()) .toList();
 System.out.println("Employee city names : "+list2);
 //fetch gender names
 List<String> list3 = emps.parallelStream().map(x->x.getGender()).toList();
 System.out.println("Employee gender names : "+list3);
 //fetch yearOfJoining
 List<Integer> list4 = emps.parallelStream().map(y->y.getYearOfJoining()).toList();
 System.out.println("Employees year of joining : "+list4);
//filter --> intermediate operation
// it generates or it produces one more Stream object 
 //fetch Employee names whose age is > 30
 List<String> list5 = emps.parallelStream()
 .filter(x->x.getAge()>30)
 .map(x->x.getName())
 .toList();
 System.out.println("Employees names whose age is > 30 : "+list5);
 //get city names whose salary is more than 40,000
 List<String> list6 = emps.parallelStream().filter(a->a.getSalary()>40000).map(a-
>a.getName()).toList();
 System.out.println("Employees city names whose salary is more than 40,000 : 
"+list6);
 
 //get joining year whose id > 130
 List<Integer> list7= emps.parallelStream()
 .filter(t->t.getId()>130)
 .map(e->e.getYearOfJoining())
 .toList();
 System.out.println("Employees joining year whose id > 130 : "+list7);
//fetch gender names without duplicates
 List<String> list8 = emps.parallelStream().map(x->x.getGender()).distinct().toList();
 System.out.println("Employee gender names without duplicates : "+list8);
//fetch employee names without duplicates
 List<String> list9= emps.parallelStream().
 map(c->c.getName()).distinct()
 .toList();
 System.out.println("Employee emp names without duplicates : "+list9);
//fetch emp ids
 List<Integer> list10 = stream1.map(x->x.getId()).toList();
 System.out.println("List 10 : "+list10);
//fetch emp names
Stream<Employee> stream2 = emps.parallelStream();
 List<String> list11 = stream2.map(x->x.getName()).toList();
 System.out.println("List 11 : "+list11);
 Stream<Employee> stream3 = emps.parallelStream();
 List<String> list12 = stream3.map(x->x.getName()).toList();
 System.out.println("List 11 : "+list12);
 //fetch emp names
 //fetch emp ids 
 // fetch emp names whose age is > 30
 ////fetch emp ids whose salary is > 40k
 //fetch emp salaries whose belongs to city is Banglore
 
 //fetch emp names whose belongs to male category
 List<String> list13 =emps.parallelStream().filter(x->x.getGender()=="Male").map(x-
>x.getName()).toList();
 System.out.println("emp names whose belongs to male category : "+list13);
 //It will create a new stream object but not the result..
 
System.out.println("===================================================");
//get joining year whose id > 130
 List<Integer> listq7= emps.parallelStream()
 .filter(t->t.getId()>130).filter(x->x.getGender()=="Male")
 .map(e->e.getYearOfJoining())
 .toList();
 System.out.println("Employees joining year whose id > 130 : "+listq7);
 Stream<Employee> str = emps.parallelStream();
 System.out.println("Stream object : "+str);
 System.out.println("Object reference with filter method : "+ str.filter(t->t.getId()>130));
 System.out.println("Object reference with map method : "+ 
emps.parallelStream().filter(t->t.getId()>130).map(e->e.getYearOfJoining()));
 System.out.println("when adding terminal operation : "+ 
emps.parallelStream().filter(t->t.getId()>130).map(e->e.getYearOfJoining()).toList());
 System.out.println("===================================================");
 //count() we are going to get the count ---
 //count of employees
 long countofEmployees= emps.parallelStream().map(x->x.getName()).count();
 System.out.println("Count of employees : "+countofEmployees);
 // limit()
 List<Employee> listof5Employyes = emps.parallelStream().limit(5).toList();
 System.out.println("listof5Employyes: "+listof5Employyes);
 //skip() -- negotiating the top & looks for reamining employe objs
 List<Employee> listofEmployyes = emps.parallelStream().skip(5).toList();
 System.out.println("listofEmployyes: "+listofEmployyes);
 //anyMatch() – generates Boolean result based on condition
 //employees age is <18 or not 
 boolean is18UnderAge = emps.parallelStream().anyMatch(x->x.getAge()<18);
 System.out.println(" Boolean result "+is18UnderAge);
 //allmatch()– generates Boolean result based on condition
 boolean isSalaryabove50k =emps.parallelStream().allMatch(x->x.getSalary()>50000);
 System.out.println(" Boolean result isSalaryabove50k : "+isSalaryabove50k);
 //noneMatch()– generates Boolean result based on condition 
 //joiningYearMoreThan2023year
 boolean joiningYearMoreThan2023year = emps.parallelStream().noneMatch(x-
>x.getYearOfJoining()>2023);
 System.out.println("joiningYearMoreThan2023year "+ joiningYearMoreThan2023year);
 
//findFirst() – Always gives the first object details
 Employee e2 = emps.parallelStream().findFirst().get();
 System.out.println("First employee object "+e2);
 System.out.println(" object "+ emps.parallelStream().findFirst() );
 
 // findAny()
 Employee e22 = emps.parallelStream().findAny().get();
 System.out.println("Any employee object "+e22); 
 
 //sorted()-->elements
 //emp names
 List<String> sortedOrder = emps.parallelStream().map(x-
>x.getName()).sorted().toList();
 System.out.println("sortedOrder of names "+sortedOrder);
 
 //sorted()
 //emp ids //dept names //salaries 
 
 //sorted comparator -->objects
 //sort employee objects according to emp ids
 List<Employee> sortedBasedonEmployeeIds= emps.parallelStream().sorted((e1,e4)->
 {
 return e4.getId()-e1.getId(); 
 }).toList();
 System.out.println(" sortedBasedonEmployeeIds : 
"+sortedBasedonEmployeeIds);
List<Employee> sortedOngetYearOfJoining = emps.parallelStream().sorted((x,y)-> {
 return x.getYearOfJoining()-y.getYearOfJoining();
 }).toList();
 System.out.println(" sortedOnSalary : "+sortedOngetYearOfJoining);
 //min()
 Employee emp1 = emps.parallelStream().min((e1,e42)->(int)(e1.getSalary()-
e42.getSalary())).get();
 System.out.println(" min salary Employee details : "+emp1);
 //max()
 System.out.println(" max salary Employee details : "+ 
emps.parallelStream().max((a,b)->Float.compare(a.getSalary(),b.getSalary())).get() );
 
 //average()
 Double averageofIds= emps.parallelStream().mapToDouble(x-
>x.getId()).average().getAsDouble();
 System.out.println("averageofIds of employees ids : "+averageofIds);
 
 System.out.println("======================================”);
 System.out.println("======================================”);
//Collect() - terminal operational
 //One of the feature to accumulate elements into collections, summarizing 
elements etc
 
 //fetch emp names
 //List<String> lis100 = emps.stream().map(emps->emps.getName()).toList();
 
 // //fetch emp names by using collect method
 // emps.stream().map(table_name::desired column_name)
 List<String> lis101 = 
emps.stream().map(Employee::getName).collect(Collectors.toList());
 System.out.println("Collectors method - emp names : "+lis101);
 List<String> lis102 = emps.stream().
 map(Employee::getName).
 toList();
 System.out.println("Collectors method - emp names : "+lis102);
 
 //fetch emp department
 List<String> lis111 = emps.stream().map(Employee::getDept).toList();
 System.out.println("Collectors method - emp dept names : "+lis111);
 
 ///fetch emp salaries
 System.out.println("Collectors method - emp salries : "+ 
emps.stream().map(Employee::getSalary).collect(Collectors.toList()));
 
 //fetch emp cities 
 System.out.println("Collectors method - emp cities : "+ 
emps.stream().map(Employee::getCity).collect(Collectors.toList()));
 
 //fetch emp names whose age is >30 
 System.out.println("Collectors method - emp names whose age is >30 : 
"+emps.stream().filter(x->x.getAge()>30).map(Employee::getName).toList());
 
 //duplicates 
 //fetch dept names without duplicates
 List<String> duplicacyOFEmpDepts = 
emps.stream().map(Employee::getDept).distinct().toList();
System.out.println("Collectors method - duplicacyOFEmpDepts : 
"+duplicacyOFEmpDepts);
Method 2 by using Set Interface :
//fetch genders without duplicates
 Set<String> duplicacyOFEmpGender = 
emps.stream().map(Employee::getGender).collect(Collectors.toSet());
 System.out.println("Collectors method - duplicacyOFEmpGender : 
"+duplicacyOFEmpGender);
//fetch emp names & their salries
//Map <k,v> ----K should not be duplicate
 Map<String,Float> salarys= 
emps.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));
 System.out.println("Collectors method - emp names & their salries : "+salarys);
//fetch emp names & their age
 Map<String,Integer> emplyeeNamesWithAge = 
emps.stream().collect(Collectors.toMap(Employee::getName,Employee::getAge));
 System.out.println("Collectors method - emp names & their Ids : 
"+emplyeeNamesWithAge);
 // groupingBy
 //fetch emp salaries dept wise
 //fetch gender wise salaries
 Map<String,Double> genderwiseSalary = 
emps.stream().collect(Collectors.groupingBy(Employee::getGender , 
Collectors.averagingDouble(Employee::getSalary)));
 System.out.println("Collectors method - emp departmentwiseSalary : 
"+genderwiseSalary);
 Map<String,Double> DeptwiseSalary = 
emps.stream().collect(Collectors.groupingBy(Employee::getDept, 
Collectors.averagingDouble(Employee::getSalary)) );
 System.out.println("Collectors method - emp departmentwiseSalary : 
"+DeptwiseSalary);
 //count 
 //count 0f males & females
 Map<String,Long> genderWiseCOunt= 
emps.stream().collect(Collectors.groupingBy(Employee::getGender , 
Collectors.counting()));
 System.out.println("Collectors method -genderWiseCOunt : 
"+genderWiseCOunt);
 
 //summing 
 //fetch Employee Salary avg
 Double avgSalary = 
emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
 System.out.println("Collectors method -avgSalary : "+avgSalary);
//summary
 DoubleSummaryStatistics avgSummarizingSalary = 
emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
System.out.println("Collectors method -avgSalary : "+avgSummarizingSalary);
//maxBy
// emps.stream().collect(Collectors.maxBy(x,y)->x.getId()-y.getId()).get();
 
}
public static List<Employee> employeesList()
{
List<Employee> employeeList = new ArrayList<>();
employeeList.add(new Employee(124, "Rishi", "Banglore", 27,"Finance", 27000, "Male", 
2021));
employeeList.add(new Employee(100, "Kumari", "Chennai", 37,"IT", 23000, "Male", 
2022));
employeeList.add(new Employee(121, "Sravan", "Hyderabad",40,"Hr", 63000, "Male", 
2020));
employeeList.add(new Employee(99, "Rishitha", "Pune", 26,"It", 53000, "Female", 
2019));
employeeList.add(new Employee(101, "Sai", "Kolkata", 31,"Data Engineer", 17000, 
"Male", 2022));
employeeList.add(new Employee(185, "Ravi", "Mumbai", 37,"Maintenance", 37000, 
"Female", 2022));
employeeList.add(new Employee(196, "Kavvya", "Delhi", 28,"Finance", 42000, "Female", 
2015));
employeeList.add(new Employee(154, "Reema", "Maharastra", 28,"Finance", 65000, 
"Female", 2017));
employeeList.add(new Employee(132, "Hima", "Pune", 29,"Finance", 25000, "Female", 
2013));
employeeList.add(new Employee(159, "Kumar", "Kochi", 16,"Finance", 96000, "Male", 
2023));
return employeeList;
}
}
public class Employee {
private int id;
private String name;
private String city;
private int age;
private String dept;
private float salary;
private String gender;
private int yearOfJoining;
public Employee(int id, String name, String city, int age, String dept, float salary, String 
gender,int yearOfJoining) {
super();
this.id = id;
this.name = name;
this.city = city;
this.age = age;
this.dept = dept;
this.salary = salary;
this.gender = gender;
this.yearOfJoining = yearOfJoining;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getCity() {
return city;
}
public void setCity(String city) {
this.city = city;
}
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}
public String getDept() {
return dept;
}
public void setDept(String dept) {
this.dept = dept;
}
public float getSalary() {
return salary;
}
public void setSalary(float salary) {
this.salary = salary;
}
public String getGender() {
return gender;
}
public void setGender(String gender) {
this.gender = gender;
}
public int getYearOfJoining() {
return yearOfJoining;
}
public void setYearOfJoining(int yearOfJoining) {
this.yearOfJoining = yearOfJoining;
}
@Override
public String toString() {
return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + ", dept=" 
+ dept
+ ", salary=" + salary + ", gender=" + gender + ", yearOfJoining=" + yearOfJoining + "]";
}
}
