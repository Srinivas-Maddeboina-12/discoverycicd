ALTER TABLE employee ADD COLUMN user_id BIGINT;

ALTER TABLE employee ADD CONSTRAINT fk_employee_user
  FOREIGN KEY (user_id) REFERENCES user(id);
