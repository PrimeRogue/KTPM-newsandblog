-- Insert into User table
INSERT INTO `User` (username, password, email)
VALUES ('john_doe', 'password123', 'john.doe@example.com'),
       ('alice_smith', 'alicepass', 'alice.smith@example.com'),
       ('bob_johnson', 'bob123', 'bob.johnson@example.com'),
       ('emily_white', 'emilypass', 'emily.white@example.com'),
       ('michael_brown', 'michaelpass', 'michael.brown@example.com');

-- Insert into Category table
INSERT INTO `Category` (categoryName)
VALUES ('Technology'),
       ('Travel'),
       ('Food'),
       ('Sports'),
       ('Movies');

-- Insert into Post table
INSERT INTO `Post` (title, content, userId, categoryId)
VALUES ('Introduction to Artificial Intelligence',
        'Artificial Intelligence (AI) is the simulation of human intelligence processes by machines, especially computer systems.',
        1, 1),
       ('Top 10 Destinations to Visit in 2024',
        'Explore the top travel destinations around the world for an unforgettable experience.', 2, 2),
       ('Delicious Recipes for a Family Dinner',
        'Discover easy and delicious recipes to prepare for your next family dinner.', 3, 3),
       ('Tips for Improving Your Tennis Game',
        'Learn valuable tips and techniques to enhance your tennis skills and dominate the court.', 4, 4),
       ('Must-Watch Movies of the Decade',
        'Check out the must-watch movies that have defined the past decade and captivated audiences worldwide.', 5, 5);

-- Insert into Comment table
INSERT INTO `Comment` (postId, userId, comment)
VALUES (1, 2, 'Great introduction to AI! Looking forward to more articles.'),
       (2, 3, 'These destinations look amazing! Can\'t wait to plan my next trip.'),
(3, 4, 'The recipes are fantastic! Tried them last night and my family loved it.'),
(4, 5, 'Thanks for the tennis tips! Excited to practice them on the court.'),
(5, 1, 'Awesome movie recommendations! Will definitely check them out.');
