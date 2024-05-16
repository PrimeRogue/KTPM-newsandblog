-- Chèn dữ liệu vào bảng User
INSERT INTO User (name, email, password, roles) VALUES
                                                    ('John Doe', 'john.doe@example.com', 'password123', 'USER'),
                                                    ('Jane Smith', 'jane.smith@example.com', 'password456', 'USER'),
                                                    ('Admin User', 'admin@example.com', 'adminpassword', 'ADMIN'),
                                                    ('Alice Johnson', 'alice.johnson@example.com', 'password789', 'USER'),
                                                    ('Bob Brown', 'bob.brown@example.com', 'password101112', 'USER');
GO
-- Chèn dữ liệu vào bảng Post
INSERT INTO Post (title, content, created_at, user_id) VALUES
('Introduction to Spring Boot', 'Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".', '2024-01-10', 1),
('Understanding RESTful APIs', 'RESTful APIs are a common architectural style for web services.', '2024-02-15', 2),
('Guide to Microservices', 'Microservices architecture allows building an application as a collection of loosely coupled services.', '2024-03-20', 1),
('Getting Started with Docker', 'Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers.', '2024-04-25', 3),
('Advanced Java Programming', 'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.', '2024-05-05', 4);
GO
-- Chèn dữ liệu vào bảng Comment
INSERT INTO Comment (post_id, user_id, comment) VALUES
(1, 2, 'Great introduction to Spring Boot! I found it very helpful.'),
(1, 3, 'Very informative post. Thank you!'),
(2, 1, 'RESTful APIs are indeed very useful. Nice article.'),
(3, 2, 'Microservices can be tricky, but this guide simplifies it a lot.'),
(4, 4, 'Docker has really changed the way we deploy applications. Great read.'),
(5, 5, 'Java is my favorite programming language. Thanks for the advanced tips.');