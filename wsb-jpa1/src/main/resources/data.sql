-- 1. Addresses (all addresses created first)
insert into address (id, address_line1, address_line2, city, postal_code) values
                                                                              (1001, 'ul. Kliniczna 5', 'blok C', 'Warszawa', '00-001'),
                                                                              (1002, 'ul. Zdrowia 12', NULL, 'Kraków', '30-060'),
                                                                              (1003, 'ul. Rehabilitacyjna 8', 'lok. 4', 'Poznań', '60-001'),
                                                                              (901, '', '', '', '60-400'),
                                                                              (1004, 'ul. Okulistyczna 3', NULL, 'Wrocław', '50-002');

-- 2. Doctors (using EXACT enum values)
insert into doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization) values
                                                                                                                       (101, 1001, 'DOC/101', 'jan.kowalski@med.pl', 'Jan', 'Kowalski', '+48 123 456 789', 'GP'),
                                                                                                                       (102, 1002, 'DOC/102', 'anna.nowak@szpital.pl', 'Anna', 'Nowak', '+48 987 654 321', 'SURGEON'),
                                                                                                                       (103, 1003, 'DOC/103', 'marek.wisniewski@klinika.pl', 'Marek', 'Wiśniewski', '+48 555 444 333', 'DERMATOLOGIST'),
                                                                                                                       (104, 1004, 'DOC/104', 'ewa.wojcik@okulista.pl', 'Ewa', 'Wójcik', '+48 666 777 888', 'OCULIST');

-- 3. Patients
insert into patient (id, date_of_birth, address_id, email, first_name, last_name, patient_number, telephone_number, height) values
                                                                                                                        (201, '1985-03-15', 1001, 'krzysztof.zielinski@mail.com', 'Krzysztof', 'Zieliński', 'P2024/001', '+48 600 123 456', 188),
                                                                                                                        (202, '1999-07-22', 1002, 'agnieszka.kaminska@op.pl', 'Agnieszka', 'Kamińska', 'P2024/002', '+48 505 987 654', 192),
                                                                                                                        (203, '1978-11-30', 1003, 'piotr.lewandowski@gmail.com', 'Piotr', 'Lewandowski', 'P2024/003', '+48 888 222 333', 201),
                                                                                                                        (204, '2005-05-05', 1004, 'zuzanna.dabrowska@wp.pl', 'Zuzanna', 'Dąbrowska', 'P2024/004', '+48 600 555 000', 195);

-- 4. Visits
insert into visit(id, doctor_id, patient_id, time, description) values
                                                                    (301, 101, 201, '2024-03-25 10:00:00', 'Rutynowa kontrola ogólna'),
                                                                    (302, 102, 202, '2024-03-26 14:30:00', 'Konsultacja przedoperacyjna'),
                                                                    (303, 103, 203, '2024-03-27 11:15:00', 'Badanie zmian skórnych'),
                                                                    (305, 103, 203, '2024-03-27 11:15:00', 'Badanie zmian skórnych v2'),
                                                                    (306, 103, 201, '2026-03-27 11:15:00', 'Badanie zmian skórnych v2'),
                                                                    (304, 104, 204, '2024-03-28 09:45:00', 'Badanie wzroku');

-- 5. Medical Treatments (using correct enum types)
insert into medical_treatment(visit_id, description, type) values
                                                               (301, 'Podstawowe badanie EKG', 'EKG'),
                                                               (302, 'USG jamy brzusznej', 'USG'),
                                                               (303, 'Biopsja dermatologiczna', 'USG'),
                                                               (304, 'Badanie ostrości wzroku', 'RTG');