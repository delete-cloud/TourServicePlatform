-- 删除数据库如果已经存在
DROP DATABASE IF EXISTS tourserviceplatform;

-- 创建数据库
CREATE DATABASE tourserviceplatform;
USE tourserviceplatform;

-- 创建用户表
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL
);

-- 创建景点表
CREATE TABLE scenic_spots (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              description TEXT NOT NULL,
                              image_url VARCHAR(255) NOT NULL
);

-- 创建预约表
CREATE TABLE reservations (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              user_id BIGINT NOT NULL,
                              scenic_spot_id BIGINT NOT NULL,
                              reservation_time TIMESTAMP NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(id),
                              FOREIGN KEY (scenic_spot_id) REFERENCES scenic_spots(id)
);

-- 创建检票记录表
CREATE TABLE checkin_records (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 ticket_code VARCHAR(255) NOT NULL,
                                 checkin_time TIMESTAMP
);

-- 创建天气信息表
CREATE TABLE weather_info (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              scenic_spot_id BIGINT NOT NULL,
                              temperature VARCHAR(255) NOT NULL,
                              weather_condition VARCHAR(255) NOT NULL,
                              FOREIGN KEY (scenic_spot_id) REFERENCES scenic_spots(id)
);

-- 创建排队状态表
CREATE TABLE queue_status (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              scenic_spot_id BIGINT NOT NULL,
                              queue_length INT NOT NULL,
                              updated_time TIMESTAMP NOT NULL,
                              FOREIGN KEY (scenic_spot_id) REFERENCES scenic_spots(id)
);

-- 创建服务站信息表
CREATE TABLE service_stations (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL,
                                  description TEXT NOT NULL,
                                  type VARCHAR(255) NOT NULL,
                                  scenic_spot_id BIGINT NOT NULL,
                                  FOREIGN KEY (scenic_spot_id) REFERENCES scenic_spots(id)
);

-- 创建票表
CREATE TABLE tickets (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         scenic_spot_id BIGINT NOT NULL,
                         ticket_code VARCHAR(255) NOT NULL UNIQUE,
                         checked_in BOOLEAN NOT NULL,
                         checkin_time TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (scenic_spot_id) REFERENCES scenic_spots(id)
);

-- 插入示例数据到用户表
INSERT INTO users (username, password, email) VALUES
                                                  ('john_doe', 'password123', 'john@example.com'),
                                                  ('jane_doe', 'password456', 'jane@example.com'),
                                                  ('alice_wonder', 'password789', 'alice@example.com'),
                                                  ('bob_builder', 'password101', 'bob@example.com'),
                                                  ('charlie_chap', 'password112', 'charlie@example.com');

-- 插入示例数据到景点表
INSERT INTO scenic_spots (name, description, image_url) VALUES
                                                            ('Great Wall of China', 'The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials.', 'https://example.com/great_wall.jpg'),
                                                            ('Eiffel Tower', 'The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France.', 'https://example.com/eiffel_tower.jpg'),
                                                            ('Statue of Liberty', 'The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor in New York, in the United States.', 'https://example.com/statue_of_liberty.jpg'),
                                                            ('Taj Mahal', 'The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in the Indian city of Agra.', 'https://example.com/taj_mahal.jpg'),
                                                            ('Sydney Opera House', 'The Sydney Opera House is a multi-venue performing arts centre at Sydney Harbour in Sydney, New South Wales, Australia.', 'https://example.com/sydney_opera_house.jpg');

-- 插入示例数据到预约表
INSERT INTO reservations (user_id, scenic_spot_id, reservation_time) VALUES
                                                                         (1, 1, '2024-07-01 10:00:00'),
                                                                         (2, 2, '2024-07-02 11:00:00'),
                                                                         (3, 3, '2024-07-03 12:00:00'),
                                                                         (4, 4, '2024-07-04 13:00:00'),
                                                                         (5, 5, '2024-07-05 14:00:00'),
                                                                         (1, 2, '2024-07-06 15:00:00'),
                                                                         (2, 3, '2024-07-07 16:00:00'),
                                                                         (3, 4, '2024-07-08 17:00:00'),
                                                                         (4, 5, '2024-07-09 18:00:00'),
                                                                         (5, 1, '2024-07-10 19:00:00');

-- 插入示例数据到检票记录表
INSERT INTO checkin_records (ticket_code, checkin_time) VALUES
                                                            ('TICKET12345', '2024-07-01 09:50:00'),
                                                            ('TICKET67890', '2024-07-02 10:50:00'),
                                                            ('TICKET11223', '2024-07-03 11:50:00'),
                                                            ('TICKET44556', '2024-07-04 12:50:00'),
                                                            ('TICKET77889', '2024-07-05 13:50:00'),
                                                            ('TICKET99001', '2024-07-06 14:50:00'),
                                                            ('TICKET22334', '2024-07-07 15:50:00'),
                                                            ('TICKET55667', '2024-07-08 16:50:00'),
                                                            ('TICKET88990', '2024-07-09 17:50:00'),
                                                            ('TICKET10101', '2024-07-10 18:50:00');

-- 插入示例数据到天气信息表
INSERT INTO weather_info (scenic_spot_id, temperature, weather_condition) VALUES
                                                                              (1, '25°C', 'Sunny'),
                                                                              (2, '18°C', 'Cloudy'),
                                                                              (3, '30°C', 'Hot'),
                                                                              (4, '28°C', 'Humid'),
                                                                              (5, '22°C', 'Breezy'),
                                                                              (1, '26°C', 'Sunny'),
                                                                              (2, '19°C', 'Cloudy'),
                                                                              (3, '31°C', 'Hot'),
                                                                              (4, '29°C', 'Humid'),
                                                                              (5, '23°C', 'Breezy');

-- 插入示例数据到排队状态表
INSERT INTO queue_status (scenic_spot_id, queue_length, updated_time) VALUES
                                                                          (1, 50, NOW()),
                                                                          (2, 30, NOW());

-- 插入示例数据到服务站信息表
INSERT INTO service_stations (name, description, type, scenic_spot_id) VALUES
                                                                           ('First Aid', 'Medical assistance available here.', 'Medical', 1),
                                                                           ('Food Court', 'Various food options available.', 'Food', 2);

-- 插入示例数据到票表
INSERT INTO tickets (user_id, scenic_spot_id, ticket_code, checked_in, checkin_time) VALUES
                                                                                         (1, 1, 'TICKET001', false, NULL),
                                                                                         (2, 2, 'TICKET002', false, NULL),
                                                                                         (3, 3, 'TICKET003', false, NULL),
                                                                                         (4, 4, 'TICKET004', false, NULL),
                                                                                         (5, 5, 'TICKET005', false, NULL),
                                                                                         (1, 2, 'TICKET006', false, NULL),
                                                                                         (2, 3, 'TICKET007', false, NULL),
                                                                                         (3, 4, 'TICKET008', false, NULL),
                                                                                         (4, 5, 'TICKET009', false, NULL),
                                                                                         (5, 1, 'TICKET010', false, NULL);
