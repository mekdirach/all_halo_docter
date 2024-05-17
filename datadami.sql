-- m_user
insert into m_user(created_by, created_on) values
(99, now());

-- m_biodata
insert into m_biodata(fullname, mobile_phone, image_path, created_by, created_on, is_delete)
values ('dr. Tatjana Saphira, Sp.A', '081315139988', 'sajana.jpg', 1, now(), false),
('dr. Teuku Adifitrian, Sp.BP-RE', '081315019988', 'photo.png', 1, now(), false),
('Dr. dr. Terawan Agus Putranto, Sp.Rad', '081315109988', '', 1, now(), false),
('dr. Anastasia Novitasari, Sp.S', '081315139980', '', 1, now(), false),
('dr. Irawan Wahyudi, Sp.BP', '081315139988', '', 1, now(), false),
('Andini Dianita', '081315139128', '', 1, now(), false),
('Martin Luther Jr', '081715139128', '', 1, now(), false),
('Kartika', '081315130128', '', 1, now(), false);

-- m_doctor
insert into m_doctor(biodata_id, str, created_by, created_on, is_delete)
values (1, 'Mrs. Sajana', 1, now(), false),
(2, 'Mr. Tompi', 1, now(), false),
(3, 'Mr. Terawan', 1, now(), false),
(4, 'Mrs. Anastasia', 1, now(), false),
(5, 'Mr. Irawan', 1, now(), false);

--m_education_level
insert into m_education_level(name, created_by, created_on, is_delete)
values ('Bachelor', 1, now(), false),
('Master', 1, now(), false),
('Doctor', 1, now(), false);

--m_doctor_education
insert into m_doctor_education(doctor_id, education_level_id, institution_name, major, start_year, end_year, is_last_education, created_by, created_on, is_delete)
values (1, 2, 'Universitas Airlangga', 'Magister Administrasi Rumah Sakit', '2016', '2020', false, 1, now(), false),
(1, 2, 'Universitas Gajah Mada', 'Spesialis Obstetri & Ginekologi', '2010', '2012', false, 1, now(), false),
(1, 1, 'Universitas Indonesia', 'Sarjana Kedokteran', '2006', '2010', false, 1, now(), false),
(2, 2, 'Universitas Gajah Mada', 'Magister Administrasi Rumah Sakit', '2016', '2020', false, 1, now(), false),
(3, 3, 'Universitas Budi Luhur', 'Magister Administrasi Rumah Sakit', '2016', '2020', false, 1, now(), false),
(4, 2, 'Universitas Telkom', 'Magister Administrasi Rumah Sakit', '2016', '2020', false, 1, now(), false),
(5, 2, 'Universitas Pamulang', 'Magister Administrasi Rumah Sakit', '2016', '2020', false, 1, now(), false);

--m_specialization
insert into m_specialization(name, created_by, created_on, is_delete)
values ('Spesialis Anak', 1, now(), false),
('Spesialis Kandungan', 1, now(), false),
('Spesialis Mata', 1, now(), false),
('Spesialis Paru-paru', 1, now(), false),
('Spesialis THT', 1, now(), false);

--t_current_doctor_specialization
insert into t_current_doctor_specialization(doctor_id, specialization_id, created_by, created_on, is_delete)
values(1, 2, 1, now(), false),
(2, 1, 1, now(), false),
(3, 4, 1, now(), false),
(4, 5, 1, now(), false),
(5, 3, 1, now(), false);

--t_doctor_treatment
insert into t_doctor_treatment (doctor_id, name, created_by, created_on, is_delete)
values (1, 'Pengendalian kehamilan', 1, now(), false),
(1, 'Menopause', 1, now(), false),
(1, 'Infeksi saluran kemih', 1, now(), false),
(1, 'Masalah pada panggul', 1, now(), false),
(1, 'Infeksi kelamin', 1, now(), false),
(2, 'Tumbuh kembang anak', 1, now(), false),
(2, 'Pertumbuhan anak', 1, now(), false),
(2, 'Pernafasan anak', 1, now(), false),
(3, 'Treatment paru-paru', 1, now(), false),
(3, 'Penanganan covid-19', 1, now(), false),
(3, 'Sulit bernafas', 1, now(), false),
(4, 'Gangguan pendengaran', 1, now(), false),
(4, 'Infeksi saluran telinga', 1, now(), false),
(4, 'Telinga berdengung', 1, now(), false),
(5, 'Infeksi mata', 1, now(), false),
(5, 'Gangguan pengelihatan', 1, now(), false),
(5, 'Kelainan kornea', 1, now(), false);

--m_location_level
insert into m_location_level (name, created_on, created_by, is_delete)
values ('Jakarta Pusat', '2020-07-25 1:00:00', 1, false),
('Jakarta Timur', now(), 1, false),
('Jakarta Selatan', now(), 1, false),
('Jakarta Utara', now(), 1, false),
('Jakarta Barat', now(), 1, false),
('Depok', now(), 1, false),
('Bandung', now(), 1, false),
('Flexible', now(), 1, false);

--m_location
insert into m_location (name, location_level_id, created_on, created_by, is_delete)
values
('Pasar Senen', 1, now(), 1, false),
('Blok M', 3, now(), 1, false),
('Senopati', 3, now(), 1, false),
('Srengseng', 5, now(), 1, false),
('Meruya', 5, now(), 1, false),
('Dago', 7, now(), 1, false),
('Margonda', 6, now(), 1, false),
('Kebayoran Lama', 3, now(), 1, false),
('Rumah', 8, now(), 1, false);


--m_medical_facility_category
insert into m_medical_facility_category (name, created_on, created_by, is_delete)
values
('Rumah Sakit', now(), 1, false),
('Klinik', now(), 1, false),
('Apotek', now(), 1, false),
('Online', now(), 1, false);

--m_medical_facility
insert into m_medical_facility (name, medical_facility_category_id, location_id, full_address, email, phone_code, phone, fax, created_on, created_by, is_delete)
values
('RS Mitra', 1, 7, 'Jl. Pahlawan no.45', 'admin@rsmitra.com', '+62', '14022', '-', now(), 1, false),
('RSIA Bunda', 1, 1, 'Jl. Monas no.45', 'admin@rsiabunda.com', '+62', '14045', '-', now(), 1, false),
('RSUP Hasan Sadikin', 1, 6, 'Jl. Gedung Sate no.45', 'admin@rsuphasansadikin.com', '+62', '911', '-', now(), 1, false),
('RS Persahabatan', 1, 8, 'Jl. Langsat No.1', 'admin@rspersahabatan.com', '+62', '928232', '-', now(), 1, false),
('Layanan Online', 4, 9, 'Rumah Dokter Masing-masing', 'admin@online.com', '+62', '928232', '-', now(), 1, false);


--t_docter_office
insert into t_doctor_office (doctor_id, medical_facility_id, specialization, created_on, created_by, deleted_on, deleted_by, is_delete)
values
(1, 3, 'Dokter Kandungan', '2016-01-01', 1, '2018-01-01', 1, true),
(1, 2, 'Dokter Kandungan', '2018-01-01', 1, null, null, false),
(1, 1, 'Dokter Kandungan', '2019-01-01', 1, null, null, false),
(2, 4, 'Dokter Anak', '2013-01-01', 1, '2018-01-01', 1, true),
(2, 2, 'Dokter Anak', '2019-01-01', 1, null, null, false),
(2, 3, 'Dokter Anak', '2018-01-01', 1, null, null, false),
(3, 3, 'Dokter Paru-paru', '2011-01-01', 1, '2018-01-01', 1, true),
(3, 1, 'Dokter Paru-paru', '2019-01-01', 1, null, null, false),--inilayananchat
(1, 5, 'Dokter Kandungan', '2016-01-01', 1, '2018-01-01', 1, true),
(1, 5, 'Dokter Kandungan', '2018-01-01', 1, null, null, false),
(1, 5, 'Dokter Kandungan', '2019-01-01', 1, null, null, false),
(2, 5, 'Dokter Anak', '2013-01-01', 1, '2018-01-01', 1, true),
(2, 5, 'Dokter Anak', '2019-01-01', 1, null, null, false),
(2, 5, 'Dokter Anak', '2018-01-01', 1, null, null, false),
(3, 5, 'Dokter Paru-paru', '2011-01-01', 1, '2018-01-01', 1, true),
(3, 5, 'Dokter Paru-paru', '2019-01-01', 1, null, null, false);


--m_medical_facility_schedule
insert into m_medical_facility_schedule (medical_facility_id, day, time_schedule_start, time_schedule_end, created_by, created_on, is_delete)
values
(1, 'Senin', '08:00', '17:00', 1, now(), false),
(1, 'Kamis', '08:00', '17:00', 1, now(), false),
(1, 'Jumat', '08:00', '17:00', 1, now(), false),
(2, 'Senin', '08:00', '17:00', 1, now(), false),
(2, 'Selasa', '08:00', '17:00', 1, now(), false),
(2, 'Rabu', '08:00', '17:00', 1, now(), false),
(3, 'Senin', '08:00', '17:00', 1, now(), false),
(3, 'Kamis', '08:00', '17:00', 1, now(), false),
(3, 'Sabtu', '08:00', '17:00', 1, now(), false),
(4, 'Rabu', '08:00', '17:00', 1, now(), false),--inijadwalonline
(5, 'Senin', '03:00', '17:00', 1, now(), false),
(5, 'Selasa', '08:00', '23:00', 1, now(), false),
(5, 'Sabtu', '03:00', '17:00', 1, now(), false);


--t_doctor_office_schedule
insert into t_doctor_office_schedule (doctor_id, medical_facility_schedule_id, created_on, created_by, deleted_on, deleted_by, is_delete)
values
(1, 9, '2016-01-01', 1, '2018-01-01', 1, true),
(1, 1, '2018-01-01', 1, null, null, false),
(1, 5, '2019-01-01', 1, null, null, false),
(2, 9, '2013-01-01', 1, null, null, false),
(2, 2, '2019-01-01', 1, null, null, false),
(3, 5, '2019-01-01', 1, null, null, false),
(3, 7, '2020-01-01', 1, null, null, false),
(4, 1, '2009-01-01', 1, null, null, false),
(4, 10, '2019-01-01', 1, null, null, false),
(5, 9, '2012-01-01', 1, null, null, false),
(5, 2, '2020-01-01', 1, null, null, false),--inijadwalOnline
(1, 12, '2016-01-01', 1, '2018-01-01', 1, true),
(1, 12, '2018-01-01', 1, null, null, false),
(1, 12, '2019-01-01', 1, null, null, false),
(2, 13, '2013-01-01', 1, null, null, false),
(3, 13, '2019-01-01', 1, null, null, false),
(3, 13, '2020-01-01', 1, null, null, false),
(4, 13, '2009-01-01', 1, null, null, false),
(5, 12, '2012-01-01', 1, null, null, false),
(5, 12, '2020-01-01', 1, null, null, false);

--t_doctor_office_treatment
insert into t_doctor_office_treatment (created_by, created_on, doctor_treatment_id,doctor_office_id)
values
(1, now(), 1, 1),
(1, now(), 1, 2),
(1, now(), 1, 3),
(1, now(), 2, 5),
(1, now(), 2, 6),
(1, now(), 3, 7),
(1, now(), 3, 8),--iniLayananOnline
(1, now(), 1, 9),
(1, now(), 1, 10),
(1, now(), 1, 11),
(1, now(), 2, 12),
(1, now(), 2, 13),
(1, now(), 3, 14),
(1, now(), 3, 15);



--t_appointment
insert into t_appointment (customer_id, doctor_office_id, doctor_office_schedule_id, doctor_office_treatment_id, created_by, created_on, is_delete)
values (1, 1, 1, 1, 1, now(), false),
(2, 1, 1, 1, 1, now(), false),
(3, 1, 1, 1, 1, now(), false),
(1, 2, 1, 1, 1, now(), false),
(2, 2, 1, 1, 1, now(), false),
(2, 3, 1, 1, 1, now(), false),
(3, 4, 1, 1, 1, now(), false),
(1, 5, 1, 1, 1, now(), false),
(2, 6, 1, 1, 1, now(), false),
(2, 6, 1, 1, 1, now(), false);

--m_blood_group
insert into m_blood_group (code, description, created_by, created_on, is_delete)
values ('AB', 'golongan darah AB', 1, now(), false),
('A', 'golongan darah A', 1, now(), false),
('B', 'golongan darah B', 1, now(), false),
('O', 'golongan darah O', 1, now(), false);

--m_customer
insert into m_customer (biodata_id, dob, gender, blood_group_id, rhesus_type, height, weight, created_by, created_on, is_delete)
values (6, '118-07-10', 'L', 4, 'ABO', 173, 56, 1, now(), false),
(7, '1989-09-10', 'L', 2, 'ABO', 178, 76, 1, now(), false),
(8, '1967-10-10', 'L', 1, 'ABO', 170, 60, 1, now(), false);

--t_customer_chat
insert into t_customer_chat (customer_id, doctor_id, created_by, created_on, is_delete)
values (1, 1, 1, now(), false),
(2, 1, 1, now(), false),
(3, 1, 1, now(), false),
(1, 2, 1, now(), false),
(2, 3, 1, now(), false);

insert into t_doctor_office_treatment_price
(created_by, created_on, doctor_office_treatment_id,price,price_start_from,price_until_from) values
(1, now(), 1,300000.0,300000.0,500000.0),
(1, now(), 2,300000.0,300000.0,500000.0),
(1, now(), 3,300000.0,300000.0,500000.0),
(1, now(), 4,300000.0,300000.0,500000.0),
(1, now(), 5,300000.0,300000.0,500000.0),
(1, now(), 6,300000.0,300000.0,500000.0),
(1, now(), 7,300000.0,300000.0,500000.0),
(1, now(), 9,0,0,0),
(1, now(), 10,0,0,0),
(1, now(), 11,0,0,0),
(1, now(), 12,0,0,0),
(1, now(), 13,0,0,0)
;