create table if not exists millionaire.answers
(
    id serial primary key,
    idQuestion int,
    answer varchar(255),
    isRightAnswer boolean
)