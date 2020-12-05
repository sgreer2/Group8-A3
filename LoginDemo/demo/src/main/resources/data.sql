-- Stephen Greer
INSERT INTO USER VALUES
    -- ID, Name, Role
    ( NULL, 'admin', 'admin'),
    ( NULL, 'user1', 'user'),
    ( NULL, 'user2', 'user'),
    ( NULL, 'creator1', 'creator'),
    ( NULL, 'creator2', 'creator')
;

INSERT INTO SHOW VALUES
    -- ID, Title, Desc, #Episodes
    ( NULL, 'Game of Thrones', 'People competing for a throne', 100, 4),
    ( NULL, 'Breaking Bad', 'Guy deals with cancer', 50, 5),
    ( NULL, 'Mr. Robot', 'Hacker show', 25, 4),
    ( NULL, 'Supernatural', 'Magic show?', 63, 5),
    ( NULL, 'Queens Gambit', 'Cool Chess show', 24, 5)
;

INSERT INTO WATCHING VALUES
    -- ID, User ID, Show ID, #Episodes watched, Rating
    ( NULL, 2, 1, 35, 5 ),
    ( NULL, 2, 2, 45, 7 ),
    ( NULL, 2, 5, 35, 5 ),
    ( NULL, 2, 4, 20, 9 ),
    ( NULL, 2, 3, 24, 4 ),
    ( NULL, 3, 3, 10, 10 ),
    ( NULL, 3, 5, 2, 8 )
;


