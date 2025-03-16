insert into address (id, address_line1, address_line2, city, postal_code) values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization) values (1, 901, 2, 'qwe@wp.pl', 'qwee', 'qwe', '123445', 'GP');

insert into patient (id, date_of_birth, address_id, email, first_name, last_name, patient_number, telephone_number) values (1, now(), 901, 'patient@wp.pl', 'qweee', 'qwe', 1, '123456');

insert into visit(id, doctor_id, patient_id, time, description) values (1,1,1, now(), 'des');

insert into medical_treatment(visit_id, description, type) values (1, 'description', 'EKG');
