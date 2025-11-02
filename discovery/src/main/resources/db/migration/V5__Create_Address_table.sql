CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address_type VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(255),
    employee_id BIGINT,
    CONSTRAINT fk_employee_address FOREIGN KEY (employee_id) REFERENCES employee(id)
);
