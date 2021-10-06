###########################################################
################## CREATE FRESH DATABASE ##################
###########################################################
DROP DATABASE IF EXISTS SQLProject; #Project0
CREATE DATABASE SQLProject; #Project0

USE SQLProject; #Project0

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
#DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS junction_accounts_customers;





CREATE TABLE accounts
(
    account_id 		INT AUTO_INCREMENT,
    account_balance DECIMAL (10, 2),
    account_type	VARCHAR(200), # ?Needs to be a list of selection CHECKING, SAVINGS, OTHER
    CONSTRAINT accounts_pk PRIMARY KEY (account_id)
#    CONSTRAINT accounts_junction_accounts_customers_fk FOREIGN KEY (account_id) REFERENCES junction_accounts_customers (account_id)
);

CREATE TABLE customers
(
    customer_id 	INT AUTO_INCREMENT,
    first_name 		VARCHAR(200),
    last_name		VARCHAR(200),
    username		VARCHAR(200),
    password		VARCHAR(200),
    CONSTRAINT customers_pk PRIMARY KEY (customer_id)
#    CONSTRAINT customers_junction_accounts_customers_fk FOREIGN KEY (customer_id) REFERENCES junction_accounts_customers (customer_id)
   );

  CREATE TABLE junction_accounts_customers #junction table to join all tables
(
	junction_id INT AUTO_INCREMENT,
	account_id 	INT NOT NULL,
	customer_id INT NOT NULL,
	CONSTRAINT junction_accounts_customers_fk PRIMARY KEY (junction_id),
	CONSTRAINT account_junction FOREIGN KEY (account_id) REFERENCES accounts(account_id),
	CONSTRAINT customer_junction FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
	);

###########################################################
################# POPULATE FRESH DATABASE #################
###########################################################

-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0001, 900001); #used when I was creating junction first... not needed now.
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0001, 900002);
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0002, 900003);
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0002, 900004);
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0003, 900005);
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0004, 900006);
-- INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0005, 900007);

INSERT INTO customers (customer_id, first_name, last_name, username, password) VALUES (0001, "Jason", "Smith", "Smurfy01","P@rty0n");
INSERT INTO customers (customer_id, first_name, last_name, username, password) VALUES (0002, "Amanda", "Smith", "Smurfy02","P@rty0n");
INSERT INTO customers (customer_id, first_name, last_name, username, password) VALUES (0003, "John", "Cross", "Smurfy03","P@rty0n");
INSERT INTO customers (customer_id, first_name, last_name, username, password) VALUES (0004, "Marty", "Gras", "Smurfy04","P@rty0n");
INSERT INTO customers (customer_id, first_name, last_name, username, password) VALUES (0005, "Jason", "Lourdes", "Smurfy05","P@rty0n");

INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900001, 1500.50, "Checking");
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900002, 2780.25, "Savings");
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900003, 150, "Checking");
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900004, 13.33, "Savings");
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900005, 100000.01, "Checking"); 
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900006, 12345.67, "Checking");
INSERT INTO accounts (account_id, account_balance, account_type) VALUES (900007, 1345.67, "Checking");

INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0001, 900001); #used when I was creating junction first... not needed now.
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0001, 900002);
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0002, 900003);
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0002, 900004);
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0003, 900005);
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0004, 900006);
INSERT INTO junction_accounts_customers (customer_id, account_id) VALUES (0005, 900007);

###########################################################
#################### MAKE SOME CHANGES ####################
###########################################################
#SELECT * FROM accounts;

UPDATE accounts a 
SET a.account_balance = (a.account_balance * 1.05);

UPDATE accounts a 
SET a.account_balance = (a.account_balance - 2500)
WHERE account_id = 900005;


#SELECT * FROM customers



###########################################################
################### TEST FRESH DATABASE ###################
###########################################################

SELECT c.first_name, c.last_name, a.account_id, a.account_balance
FROM customers c
JOIN junction_accounts_customers jac ON c.customer_id = jac.customer_id
JOIN accounts a ON jac.account_id = a.account_id
ORDER BY a.account_balance DESC;

SELECT SUM(account_balance) AS "Total Deposits"
FROM accounts;

SELECT first_name, last_name
FROM customers
WHERE first_name LIKE 'J%';

#SELECT DISTINCT state
#FROM address
#ORDER BY state;

#SELECT c.name, CONCAT(ad.address, " ", ad.city, ", ", ad.state) as "Home Address"
#FROM customers c 
#JOIN address ad ON c.address_id = ad.address_id
#WHERE ad.state = 'NY';

SELECT c.first_name, c.last_name, a.account_id, a.account_balance
FROM customers c 
JOIN junction_accounts_customers jac ON c.customer_id = jac.customer_id
JOIN accounts a ON jac.account_id = a.account_id
WHERE account_balance > 5000;

#SELECT ad.state, SUM(balance) AS "State Balance"
#FROM address ad 
#JOIN customers c ON c.address_id = ad.address_id
#JOIN accounts_customers ac ON c.customer_id = ac.customer_id
#JOIN accounts a ON ac.account_id = a.account_id
#GROUP BY ad.state
#ORDER BY SUM(balance) DESC;






###########################################################
##################### TEST YOUR SKILLS ####################
###########################################################

--  Get a list of all customers with the last name "Smith".
-- SELECT * FROM customers WHERE last_name LIKE '%Smith';
-- 
--  Get the total balance of all accounts held by the Smiths.
--  SELECT SUM(account_balance) AS "Smith Total Balance"
-- FROM customers c 
-- JOIN junction_accounts_customers jac ON c.customer_id = jac.customer_id 
-- JOIN accounts a ON jac.account_id = a.account_id 
-- WHERE last_name LIKE '%Smith'
-- 
-- 
--  Get the name and address of any customer with less than $50 in an account. (No duplicates!)
-- SELECT c.name, ad.address, ad.city, ad.state #, balance
-- FROM customers c 
-- JOIN accounts_customers ac ON c.customer_id = ac.customer_id 
-- JOIN accounts a ON ac.account_id = a.account_id 
-- JOIN address ad ON c.address_id = ad.address_id 
-- WHERE balance < 50;
-- 
--  Get a list of all the customers who live in Texas.
-- SELECT c.name AS "Texas Customers" FROM customers c
-- JOIN address ad ON c.address_id = ad.address_id 
-- WHERE ad.state LIKE 'TX';
-- 
--  Add $100 gift to any accounts belonging to customers in New York
-- SELECT c.name, ad.address, ad.city, ad.state, balance
-- FROM customers c 
-- JOIN accounts_customers ac ON c.customer_id = ac.customer_id 
-- JOIN accounts a ON ac.account_id = a.account_id 
-- JOIN address ad ON c.address_id = ad.address_id 
-- WHERE ad.state LIKE 'NY'; #Block used to look at NY balances
-- 
-- UPDATE accounts a #GIFT MONEY FOR New Yorkers!
-- JOIN accounts_customers ac ON a.account_id = ac.account_id 
-- JOIN customers c ON c.customer_id = ac.customer_id 
-- JOIN address ad ON c.address_id = ad.address_id 
-- SET a.balance = (balance + 100)
-- WHERE ad.state LIKE 'NY';
-- 
-- 
--  Transfer $199.99 from Jason Smith to Amanda Smith
-- UPDATE accounts a  #Take from Jason's account
-- JOIN junction_accounts_customers jac ON a.account_id = jac.account_id 
-- JOIN customers c ON c.customer_id = jac.customer_id 
-- SET a.account_balance = (a.account_balance - 199.99)
-- WHERE first_name LIKE 'Jason' AND last_name LIKE 'Smith' AND account_type LIKE 'Checking';
-- 
-- UPDATE accounts a #Put in to Amanda's account
-- JOIN junction_accounts_customers jac ON a.account_id = jac.account_id 
-- JOIN customers c ON c.customer_id = jac.customer_id 
-- SET a.account_balance = (a.account_balance + 199.99)
-- WHERE first_name LIKE 'Amanda' AND last_name LIKE 'Smith' AND account_type LIKE 'Checking';
-- 
--  Change Amanda Smith's last name to "Lastname"
-- UPDATE customers 
-- SET last_name = 'Lastname' WHERE first_name LIKE 'Amanda' AND last_name LIKE 'Smith';