create table if not exists PHOTOS (
 	id BIGINT generated by default as identity primary key,
  file_name VARCHAR(255),
  content_type VARCHAR(255),
  data BINARY LARGE OBJECT
);