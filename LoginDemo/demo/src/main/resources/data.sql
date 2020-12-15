-- Stephen Greer
INSERT INTO USER VALUES
    -- ID, Name, Role
    ( NULL, 'admin', 'admin'),
    ( NULL, 'creator1', 'creator'),
    ( NULL, 'creator2', 'creator'),
    ( NULL, 'user1', 'user'),
    ( NULL, 'user2', 'user')
;

INSERT INTO SHOW VALUES
    -- ID, Title, Desc, #Episodes, User ID
    ( NULL, 'Game of Thrones', 'People competing for a throne', 100, 2),
    ( NULL, 'Breaking Bad', 'Guy deals with cancer', 50, 3),
    ( NULL, 'Mr. Robot', 'Hacker show', 25, 2),
    ( NULL, 'Supernatural', 'Magic show?', 63, 3),
    ( NULL, 'Queens Gambit', 'Cool Chess show', 24, 3),
    ( NULL, 'Avatar: The Last Airbender', 'Arrow head kid', 75, 2),
    ( NULL, 'Evangelion', 'Giant robots', 80, 3),
    ( NULL, 'End Game', 'Time travel and stuff', 1, 2),
    ( NULL, 'The Lord of the Rings', 'People dont like the ring of invisibility', 1, 3),
    ( NULL, 'The Mandalorian', 'Space adventures with baby Yoda', 30, 3),
    ( NULL, 'FMA: Brotherhood', 'Brotherly adventures', 75, 3),
    ( NULL, 'The Flash', 'Speedy speed boy', 100, 3),
    ( NULL, 'Spiderman: Into the Spider-verse', 'Does whatever a spider can*', 1, 3),
    ( NULL, 'Batman Begins', 'Batman makes friends', 1, 3),
    ( NULL, 'The Dark Knight', 'Batman hangs out with friends', 1, 3),
    ( NULL, 'The Dark Knight Rises', 'Batman moves away :(', 1, 3)
;

INSERT INTO WATCHING VALUES
    -- ID, User ID, Show ID, #Episodes watched, Rating
    ( NULL, 4, 1, 35, 5 ),
    ( NULL, 4, 2, 45, 7 ),
    ( NULL, 4, 5, 35, 5 ),
    ( NULL, 4, 4, 20, 9 ),
    ( NULL, 4, 3, 24, 4 ),
    ( NULL, 5, 3, 10, 10 ),
    ( NULL, 5, 5, 2, 8 ),
    ( NULL, 4, 6, 35, 10 ),
    ( NULL, 4, 7, 45, 7 ),
    ( NULL, 4, 8, 1, 5 ),
    ( NULL, 4, 9, 1, 9 ),
    ( NULL, 4, 10, 24, 4 ),
    ( NULL, 5, 1, 10, 10 ),
    ( NULL, 5, 2, 2, 8 ),
    ( NULL, 5, 6, 10, 10 ),
    ( NULL, 5, 7, 2, 8 ),
    ( NULL, 4, 11, 35, 5 ),
    ( NULL, 4, 12, 55, 7 ),
    ( NULL, 4, 13, 1, 5 ),
    ( NULL, 4, 14, 0, 9 ),
    ( NULL, 4, 15, 1, 7 ),
    ( NULL, 4, 16, 1, 10 )
;


