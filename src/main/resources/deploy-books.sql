DROP TABLE books;

CREATE TABLE books (
	books_id int8 NOT NULL,
	books_name text NOT NULL,
	CONSTRAINT pk_books PRIMARY KEY (books_id)
);


INSERT INTO books (books_id, books_name) VALUES(1, 'Soumission');
INSERT INTO books (books_id, books_name) VALUES(2, 'La ferme des animaux');
INSERT INTO books (books_id, books_name) VALUES(3, 'Ainsi parlait');
INSERT INTO books (books_id, books_name) VALUES(4, 'Monsieur Ibrahim et les fleurs du Coran');
