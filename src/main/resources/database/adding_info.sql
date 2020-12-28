INSERT INTO cinema_repository.movie (title, description)
VALUES ('Home Alone',
        'When bratty 8-year-old Kevin McCallister acts out the night before a family trip to Paris, ' ||
        'his mother (Catherine O''Hara) makes him sleep in the attic. ' ||
        'After the McCallisters mistakenly leave for the airport without Kevin, he awakens to an empty ' ||
        'house and assumes his wish to have no family has come true.'),
       ('Forrest Gump', 'Slow-witted Forrest Gump (Tom Hanks) has never thought of himself as disadvantaged, ' ||
        'and thanks to his supportive mother (Sally Field), he leads anything but a restricted life.'),
       ('Interstellar','n Earth''s future, a global crop blight and second Dust Bowl are slowly rendering the ' ||
       'planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is' ||
        'working on plans to save mankind by transporting Earth''s population to a new home via a wormhole.');

INSERT INTO cinema_repository.tickets(cinema_id, price)
VALUES (1, 5.36),
       (2, 3.48),
       (3, 5.39);

INSERT INTO cinema_repository.users(username, password, email, ticket_id)
VALUES('test 1', '12345', 'test1@mail.ru', 1),
('test 2', '12345', 'test2@mail.ru', 3),
('test 3', '12345', 'test3@mail.ru', 2);