class Company {
  constructor(name, headquarters, employeeCount = 0, games = []) {
    this.name = name;
    this.headquarters = headquarters;
    this.employeeCount = employeeCount;
    this.games = games;
  };

  hire(employees) {
    this.employeeCount += employees;
  };

  makeGame(game) {
    this.games.push(game);
  };
};

export default Company;