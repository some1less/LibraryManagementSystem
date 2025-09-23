CREATE TABLE BOOK(
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     title VARCHAR(255) NOT NULL,
                     author VARCHAR(255) NOT NULL,
                     publisherId INT NOT NULL,
                     publicationYear INT NOT NULL,
                     isbn VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE USERS(
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(255) NOT NULL,
                     email VARCHAR(255) NOT NULL unique ,
                     phoneNumber VARCHAR(255) NOT NULL ,
                     address VARCHAR(255) NOT NULL
);

CREATE TABLE Borrowing(

                          id INT AUTO_INCREMENT PRIMARY KEY,
                          userId INT NOT NULL,
                          copyId Int NOT NULL ,
                          borrowDate DATE NOT NULL,
                          returnDate DATE NULL
);

CREATE TABLE Librarian(

            id INT AUTO_INCREMENT PRIMARY KEY,
            userId INT NOT NULL UNIQUE ,
            employmentDate DATE NOT NULL,
            position VARCHAR(255) NOT NULL

);

CREATE TABLE Copy(

            id INT AUTO_INCREMENT PRIMARY KEY,
            bookId INT NOT NULL,
            copyNumber INT NOT NULL,
            status VARCHAR(255) NOT NULL
);

CREATE TABLE Publisher(

            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            address VARCHAR(255) NOT NULL,
            phoneNumber VARCHAR(255) NOT NULL

);

ALTER TABLE BOOK ADD CONSTRAINT FK_Book_Publisher
        FOREIGN KEY (publisherId)
        REFERENCES PUBLISHER (id);

ALTER TABLE Borrowing ADD CONSTRAINT FK_User_Borrowing
            FOREIGN KEY (userId)
            references USERS(id);

ALTER TABLE Borrowing ADD CONSTRAINT FK_Copy_Borrowing
    FOREIGN KEY (copyId)
        references Copy(id);

ALTER TABLE Librarian ADD CONSTRAINT FK_User_Librarian
    FOREIGN KEY (userId)
        references USERS(id);

ALTER TABLE Copy ADD CONSTRAINT FK_Book_Copy
    FOREIGN KEY (bookId)
        references BOOK(id);

ALTER TABLE Copy
    ADD CONSTRAINT uq_book_copy UNIQUE (bookId, copyNumber);



