CREATE TABLE users (id SERIAL PRIMARY KEY, username VARCHAR(45),password VARCHAR(20))
CREATE TABLE shoppingList (list_id SERIAL PRIMARY KEY, user_id INT, FOREIGN KEY (user_Id) REFERENCES users (id));
CREATE TABLE items (item_id SERIAL PRIMARY KEY, item_name VARCHAR(45), quantity VARCHAR(20), list_id INT,FOREIGN KEY (list_id) REFERENCES shoppingList (list_id));

INSERT INTO users (username, password) VALUES ('John', 'qwerty'),('Mary', 'asdfg'),('Adam', 'zxcvb');
INSERT INTO shoppingList(user_id) VALUES (2);
INSERT INTO items (item_name, quantity, listId) VALUES('banana', '5', 2),('milk', '3', 2),('bread', '6', 2);