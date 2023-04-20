CREATE TABLE administrator (
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(50),
    password VARCHAR(255)
);

INSERT INTO administrator(id,login,password) VALUES (DEFAULT,'admin',md5('admin'));

CREATE TABLE driver(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200),
    password VARCHAR(255),
    birth DATE
);

CREATE TABLE type(
    id SERIAL PRIMARY KEY NOT NULL,
    description VARCHAR(200)
);

INSERT INTO type(id,description) VALUES (DEFAULT,'SUV');
INSERT INTO type(id,description) VALUES (DEFAULT,'Legere');
INSERT INTO type(id,description) VALUES (DEFAULT,'Utilitaire');
INSERT INTO type(id,description) VALUES (DEFAULT,'Camion');

CREATE TABLE vehicle(
    number VARCHAR(7) PRIMARY KEY NOT NULL,
    idtype INT,
    mark VARCHAR(255),
    model VARCHAR(255),
    km DOUBLE PRECISION,
    FOREIGN KEY(idtype) REFERENCES type(id)
);

CREATE TABLE trajectory(
    id SERIAL PRIMARY KEY NOT NULL,
    numbervehicle VARCHAR(7),
    iddriver INT,
    motif VARCHAR(255),
    departure_time TIMESTAMP,
    departure_place VARCHAR(255),
    departure_km DOUBLE PRECISION,
    arrival_time TIMESTAMP,
    arrival_place VARCHAR(255),
    arrival_km DOUBLE PRECISION,
    fuel_price DOUBLE PRECISION,
    fuel_quantity DOUBLE PRECISION,
    status BOOLEAN,
    FOREIGN KEY (numbervehicle) REFERENCES vehicle(number),
    FOREIGN KEY (iddriver) REFERENCES driver(id)
);

ALTER TABLE driver ADD COLUMN login VARCHAR(255);

CREATE TABLE assurance(
    id SERIAL PRIMARY KEY NOT NULL,
    numbervehicle VARCHAR(7),
    last_date_of_payment DATE,
    expiration DATE,
    FOREIGN KEY (numbervehicle) REFERENCES vehicle (number)
);

CREATE TABLE visite(
    id SERIAL PRIMARY KEY NOT NULL,
    numbervehicle VARCHAR(7),
    last_visit DATE,
    next_visit DATE,
    FOREIGN KEY (numbervehicle) REFERENCES vehicle (number)
);

CREATE TABLE maintenance(
    id SERIAL PRIMARY KEY,
    numbervehicle VARCHAR(7),
    lastvidange_km DOUBLE PRECISION,
    lastpneu_km DOUBLE PRECISION,
    nextvidange_km DOUBLE PRECISION,
    nextpneu_km DOUBLE PRECISION,
    FOREIGN KEY (numbervehicle) REFERENCES vehicle(number)
);

CREATE VIEW vehiclestate AS (
    SELECT number,km,a.id as assurance_id,last_date_of_payment,expiration,vi.id as visite_id,last_visit,next_visit,lastvidange_km,nextvidange_km,lastpneu_km,nextpneu_km
     FROM vehicle v JOIN assurance a ON v.number=a.numbervehicle JOIN visite vi ON v.number=vi.numbervehicle JOIN
    maintenance m ON v.number=m.numbervehicle
    );