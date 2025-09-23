-- PUBLISHER (10)
INSERT INTO Publisher (id, name, address, phoneNumber) VALUES
                                                           (1, 'HarperCollins', '195 Broadway, New York', '111-111-1111'),
                                                           (2, 'Penguin Books', '80 Strand, London', '222-222-2222'),
                                                           (3, 'Macmillan', '120 Broadway, New York', '333-333-3333'),
                                                           (4, 'Simon & Schuster', '1230 Avenue of the Americas, NY', '444-444-4444'),
                                                           (5, 'Random House', '1745 Broadway, NY', '555-555-5555'),
                                                           (6, 'Oxford Press', 'Great Clarendon Street, Oxford', '666-666-6666'),
                                                           (7, 'Cambridge Press', 'Shaftesbury Rd, Cambridge', '777-777-7777'),
                                                           (8, 'Springer', 'Tiergartenstr. 17, Berlin', '888-888-8888'),
                                                           (9, 'Pearson', '246 High Holborn, London', '999-999-9999'),
                                                           (10, 'Wiley', '111 River St, Hoboken', '101-101-1010');

-- BOOK (10)
INSERT INTO Book (id, title, author, publisherId, publicationYear, isbn) VALUES
                                                                             (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 1, 1925, '9780001'),
                                                                             (2, '1984', 'George Orwell', 2, 1949, '9780002'),
                                                                             (3, 'To Kill a Mockingbird', 'Harper Lee', 3, 1960, '9780003'),
                                                                             (4, 'Moby Dick', 'Herman Melville', 4, 1851, '9780004'),
                                                                             (5, 'War and Peace', 'Leo Tolstoy', 5, 1869, '9780005'),
                                                                             (6, 'Hamlet', 'William Shakespeare', 6, 1603, '9780006'),
                                                                             (7, 'Pride and Prejudice', 'Jane Austen', 7, 1813, '9780007'),
                                                                             (8, 'The Odyssey', 'Homer', 8, -700, '9780008'),
                                                                             (9, 'Crime and Punishment', 'Fyodor Dostoevsky', 9, 1866, '9780009'),
                                                                             (10, 'The Divine Comedy', 'Dante Alighieri', 10, 1320, '9780010');

-- USERS (10)
INSERT INTO Users (id, name, email, phoneNumber, address) VALUES
                                                              (1, 'John Doe', 'john@example.com', '123-456-7890', '123 Elm St'),
                                                              (2, 'Jane Smith', 'jane@example.com', '234-567-8901', '456 Oak St'),
                                                              (3, 'Alice Johnson', 'alice@example.com', '345-678-9012', '789 Pine St'),
                                                              (4, 'Bob Brown', 'bob@example.com', '456-789-0123', '321 Cedar St'),
                                                              (5, 'Charlie Davis', 'charlie@example.com', '567-890-1234', '654 Maple St'),
                                                              (6, 'Diana Evans', 'diana@example.com', '678-901-2345', '987 Birch St'),
                                                              (7, 'Frank Green', 'frank@example.com', '789-012-3456', '147 Walnut St'),
                                                              (8, 'Grace Hill', 'grace@example.com', '890-123-4567', '258 Chestnut St'),
                                                              (9, 'Henry Irving', 'henry@example.com', '901-234-5678', '369 Willow St'),
                                                              (10, 'Ivy Johnson', 'ivy@example.com', '012-345-6789', '159 Ash St');

-- LIBRARIAN (10) → зв’язок 1:1 з USERS
INSERT INTO Librarian (id, userId, employmentDate, position) VALUES
                                                                 (1, 1, '2020-01-15', 'Chief Librarian'),
                                                                 (2, 2, '2021-03-22', 'Assistant Librarian'),
                                                                 (3, 3, '2019-07-10', 'Archivist'),
                                                                 (4, 4, '2022-09-01', 'Cataloger'),
                                                                 (5, 5, '2020-05-18', 'Reference Librarian'),
                                                                 (6, 6, '2018-11-25', 'Children Librarian'),
                                                                 (7, 7, '2017-08-14', 'Media Specialist'),
                                                                 (8, 8, '2021-12-03', 'Systems Librarian'),
                                                                 (9, 9, '2016-04-07', 'Library Assistant'),
                                                                 (10, 10, '2022-02-11', 'Research Librarian');

-- COPY (10)
INSERT INTO Copy (id, bookId, copyNumber, status) VALUES
                                                      (1, 1, 1, 'Available'),
                                                      (2, 1, 2, 'Borrowed'),
                                                      (3, 2, 1, 'Available'),
                                                      (4, 3, 1, 'Available'),
                                                      (5, 4, 1, 'Borrowed'),
                                                      (6, 5, 1, 'Available'),
                                                      (7, 6, 1, 'Withdrawn'),
                                                      (8, 7, 1, 'Available'),
                                                      (9, 8, 1, 'Available'),
                                                      (10, 9, 1, 'Borrowed');

-- BORROWING (10) → зв’язки з Users і Copy
INSERT INTO Borrowing (id, userId, copyId, borrowDate, returnDate) VALUES
                                                                       (1, 1, 2, '2023-01-10', NULL),
                                                                       (2, 2, 5, '2023-02-15', '2023-03-01'),
                                                                       (3, 3, 10, '2023-03-20', NULL),
                                                                       (4, 4, 3, '2023-04-05', '2023-04-20'),
                                                                       (5, 5, 4, '2023-05-12', NULL),
                                                                       (6, 6, 6, '2023-06-01', '2023-06-15'),
                                                                       (7, 7, 7, '2023-07-07', NULL),
                                                                       (8, 8, 8, '2023-08-18', '2023-09-01'),
                                                                       (9, 9, 9, '2023-09-23', NULL),
                                                                       (10, 10, 1, '2023-10-11', '2023-10-25');
