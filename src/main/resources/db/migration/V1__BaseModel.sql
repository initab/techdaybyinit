CREATE TABLE review (
  id INT PRIMARY KEY,
  comments TEXT
);

CREATE TABLE question (
  id INT PRIMARY KEY,
  display_text TEXT
);

CREATE TABLE answer (
  id INT PRIMARY KEY,
  review_id INT,
  question_id INT,
  rating INT,
  comment TEXT
);

CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 START WITH 3 NO CYCLE;
