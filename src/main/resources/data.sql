/**
* Test data
*/

INSERT INTO company (company_id, name, address, city, country, email, phone_number) VALUES
(1001, 'BMW', 'Berlin warburg str.22001','Berlin', 'Germany', 'bmw@xyz.de','9988083727');
INSERT INTO beneficialowner (name, owner_id) values ('Peter', 9001);
INSERT INTO company_owners (company_id, owner_id) values (1001, 9001)