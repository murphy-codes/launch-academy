class Author {
  constructor(firstName, lastName, genre, anthology = []) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.genre = genre;
    this.anthology = anthology;
  };

  writeBook(book) {
    this.anthology.push(book);
  };
};

export default Author;