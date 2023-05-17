CREATE TABLE IF NOT EXISTS participants (
                                            id SERIAL PRIMARY KEY,
                                            first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES groups(id)
    );

CREATE TABLE IF NOT EXISTS parents (
                                       id SERIAL PRIMARY KEY,
                                       first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    participant_id INT NOT NULL,
    FOREIGN KEY (participant_id) REFERENCES participants(id)
    );

CREATE TABLE IF NOT EXISTS groups (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(100) NOT NULL,
    trainer_id INT NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS trainings (
                                         id SERIAL PRIMARY KEY,
                                         date DATE NOT NULL,
                                         start_time TIME NOT NULL,
                                         end_time TIME NOT NULL,
                                         group_id INT NOT NULL,
                                         FOREIGN KEY (group_id) REFERENCES groups(id)
    );

CREATE TABLE IF NOT EXISTS payments (
                                        id SERIAL PRIMARY KEY,
                                        amount DECIMAL(10,2) NOT NULL,
    date DATE NOT NULL,
    training_id INT NOT NULL,
    participant_id INT NOT NULL,
    FOREIGN KEY (training_id) REFERENCES trainings(id),
    FOREIGN KEY (participant_id) REFERENCES participants(id)
    );

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
    );
