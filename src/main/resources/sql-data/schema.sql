CREATE TABLE BOOK(
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     title VARCHAR(255) NOT NULL,
                     author VARCHAR(255) NOT NULL,
                     publisher_Id INT NOT NULL,
                     publication_Year INT NOT NULL,
                     isbn VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE USERS(
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(50) NOT NULL,
                     email VARCHAR(50) NOT NULL unique ,
                     phone_number VARCHAR(255) NOT NULL ,
                     address VARCHAR(255) NOT NULL
);

CREATE TABLE Borrowing(

                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_Id INT NOT NULL,
                          copy_Id Int NOT NULL ,
                          borrow_date DATE NOT NULL,
                          return_date DATE NULL
);

CREATE TABLE Librarian(

            id INT AUTO_INCREMENT PRIMARY KEY,
            user_Id INT NOT NULL UNIQUE ,
            employment_date DATE NOT NULL,
            position VARCHAR(255) NOT NULL

);

CREATE TABLE Copy(

            id INT AUTO_INCREMENT PRIMARY KEY,
            book_Id INT NOT NULL,
            copy_number INT NOT NULL,
            status VARCHAR(255) NOT NULL
);

CREATE TABLE Publisher(

            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            address VARCHAR(255) NOT NULL,
            phone_number VARCHAR(255) NOT NULL

);

ALTER TABLE BOOK ADD CONSTRAINT FK_Book_Publisher
        FOREIGN KEY (publisher_Id)
        REFERENCES PUBLISHER (id);

ALTER TABLE Borrowing ADD CONSTRAINT FK_User_Borrowing
            FOREIGN KEY (user_Id)
            references USERS(id);

ALTER TABLE Borrowing ADD CONSTRAINT FK_Copy_Borrowing
    FOREIGN KEY (copy_Id)
        references Copy(id);

ALTER TABLE Librarian ADD CONSTRAINT FK_User_Librarian
    FOREIGN KEY (user_Id)
        references USERS(id);

ALTER TABLE Copy ADD CONSTRAINT FK_Book_Copy
    FOREIGN KEY (book_Id)
        references BOOK(id);

ALTER TABLE Copy
    ADD CONSTRAINT uq_book_copy UNIQUE (book_Id, copy_Number);



