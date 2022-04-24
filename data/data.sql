CREATE TABLE equipment (
/* Contém todos os equipamentos da aplicação.*/
    id SERIAL PRIMARY KEY,
    equipment_model_id int NOT NULL,
    name varchar(256) NOT NULL,
    FOREIGN KEY (equipment_model_id) REFERENCES equipment_model(id)
);

CREATE TABLE equipment_state (
/*Contém todos os estados dos equipamentos.*/
    id SERIAL PRIMARY KEY,
    name varchar(256) NOT NULL,
    color varchar(256) NOT NULL
);

CREATE TABLE equipment_model (
/*Contém todos os modelos de equipamentos*/
    id SERIAL PRIMARY KEY,
    name varchar(256) NOT NULL
);

CREATE TABLE equipment_model_state_hourly_earnings (
/*Informação de qual é o valor por hora do modelo de equipamento em cada um dos estados.*/
    equipment_model_id SERIAL, 
    equipment_state_id SERIAL,
    value float NOT NULL,
    FOREIGN KEY (equipment_model_id) REFERENCES equipment_model (id),
    FOREIGN KEY (equipment_state_id) REFERENCES equipment_state (id)
);

CREATE TABLE equipment_state_history (
/*O histórico de estados por equipamento.*/
    equipment_id int,
    date date,
    equipment_state_id int, 
    FOREIGN KEY (equipment_id) REFERENCES equipment(id),
    FOREIGN KEY (equipment_state_id) REFERENCES equipment_state(id)
);

CREATE TABLE equipment_position_history (
/*O histórico de posições dos equipamentos.*/
    equipment_id int,
    date date,
    lat float NOT NULL, 
    lon float NOT NULL,
    FOREIGN KEY (equipment_id) REFERENCES equipment(id)
);

INSERT INTO equipment_position_history (equipment_id, date, lat, lon) VALUES (1, '20/02/2022', -40.20, 20.30), (2, '10/03/2021', 50.25, 89.00), (3, '02/09/2022', 87.90, -14.50);

/*Dados*/ 
ALTER SEQUENCE equipment_id_seq RESTART WITH 1
ALTER SEQUENCE equipment_state_id_seq RESTART WITH 1
ALTER SEQUENCE equipment_model_id_seq RESTART WITH 1
ALTER SEQUENCE equipment_model_state_hourly_earnings_equipment_model_id_seq RESTART WITH 1 
ALTER SEQUENCE equipment_model_state_hourly_earnings_equipment_state_id_seq RESTART WITH 1 

INSERT INTO equipment (equipment_model_id, name) VALUES (1, 'Equipamento1'), (2, 'Equipamento2'), (3, 'Equipamento3'),(4, 'Equipamento4'), (5, 'Equipamento5')

INSERT INTO equipment_model (name) VALUES ('ModeloEquipamento1'), ('ModeloEquipamento2'), ('ModeloEquipamento3'),('ModeloEquipamento4'), ('ModeloEquipamento5')

INSERT INTO equipment_state(name, color) VALUES ('Operando', 'Verde'), ('Manutenção', 'Amarelo'), ('Parado', 'Vermelho');

INSERT INTO equipment_model_state_hourly_earnings (value) VALUES (20.00), (15.00), (10.00);

INSERT INTO equipment_state_history (equipment_id, date, equipment_state_id) VALUES (1, '20/04/2022', 1), (2, '20/03/2020', 3);

SELECT *
FROM equipment
RIGHT JOIN equipment_model
ON equipment.equipment_model_id=equipment_model.id;

SELECT equipment_id, equipment_state_id
FROM equipment_state_history
RIGHT JOIN equipment
ON equipment_state_history.equipment_id=equipment.id;

SELECT MAX(equipment_state_id) FROM equipment_state_history GROUP BY equipment_state_id; 
SELECT lat, lon, MAX(date) FROM equipment_position_history GROUP BY lat,lon;