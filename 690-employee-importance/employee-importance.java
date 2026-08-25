/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e : employees) map.put(e.id,e);
        return dfs(id);
    }
    public int dfs(int id){
        Employee emp = map.get(id);
        int total = emp.importance;

        for(int ele : emp.subordinates){
            total += dfs(ele);
        }
        return total;
    }
}