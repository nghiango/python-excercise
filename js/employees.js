function solution(employees, employeeId) {
    let employee = employees.find(employee => employee[0] === employeeId);
    return getSubImportance(employee, employees) + getItSelfImportance(employee, employeeId);
  }
  
  
  function getItSelfImportance(employee, employeeId) {
    if (employee[0] !== employeeId) {
      return 0;
    }
    return employee[1];
  }
  
  function getSubImportance(employee, employees) {
    const subImportance = employee[2];
    let total = 0;
    for (const subEmployee of subImportance) {
      for (const employee of employees) {
        const importance = getItSelfImportance(employee, subEmployee);
        if (importance) {
          total += importance;
          total += getSubImportance(employee, employees);
        }
      }
    }
    return total;
  }
  
  const case1 = [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]];
  const case2 = [[1, 2, [5]], [5, -3, []]];
  const case3 = [[1, 5, [2]], [2, 3, [3]], [3, 3, []]];
  console.log(getItSelfImportance([1, 5, [2, 3]], 1) === 5);
  console.log(getSubImportance([1, 5, [2, 3]], [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]) === 6);
  
  
  console.log(solution(case1, 1) === 11); // 11
  console.log(solution(case2, 5) === -3); // 11
  console.log(solution(case3, 1) === 11); /*?.*/
  
  function solution2(employees, employeeId) {
    let total = 0;
    const employeeMap = buildEmployeeMap(employees);
    total += employeeMap[employeeId].importance;
    total += getSubImportance2(employeeMap, employeeId);
    return total;
  }
  function getSubImportance2(employeeMap, employeeId) {
    let total = 0;
    if (employeeMap[employeeId].subordinates.length) {
      for (const subId of employeeMap[employeeId].subordinates) {
        total += employeeMap[subId].importance;
        total += getSubImportance2(employeeMap, subId);
      }
    }
    return total;
  }
  
  function buildEmployeeMap(employees) {
    const map = {};
    for (const employee of employees) {
      map[employee[0]] = {importance: employee[1], subordinates: employee[2]};
    }
    return map;
  }
  
  console.log(solution2(case1, 1) === 11);
  console.log(solution2(case2, 5) === -3);
  console.log(solution2(case3, 1) === 11);
  