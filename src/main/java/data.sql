
-- m_biodata 
insert into m_biodata(fullname, mobile_phone, created_by, created_on, is_delete)
values 
('dr. H. Boyke Dian Nugraha, SpOG MARS', '0813113188', 1, now(), false),
('dr. Teuku Adifitrian, Sp.BP-RE', '0813101188', 1, now(), false),
('Dr. dr. Terawan Agus Putranto, Sp.Rad', '0813110188', 1, now(), false),
('dr. Anastasia Novitasari, Sp.S', '0813113180', 1, now(), false),
('dr. Irawan Wahyudi, Sp.BP', '0813113188', 1, now(), false),
('Bagus Aryo', '08131139128', 1, now(), false),
('Martin Luther Jr', '08171139128', 1, now(), false),
('Joko Widodo', '08131130128', 1, now(), false);



-- m_user 
insert into m_user(created_by, created_on, biodata_id) values 
(99, now(), 6);




--m_blood_group
insert into m_blood_group (code, description, created_by, created_on, is_delete)
values ('AB', 'golongan darah AB', 1, now(), false),
('A', 'golongan darah A', 1, now(), false),
('B', 'golongan darah B', 1, now(), false),
('O', 'golongan darah O', 1, now(), false);


--m_customer
insert into m_customer (biodata_id,blood_group_id,created_by, created_on,dob,height,weight)
values (7,2,1, now(), '2000-08-04 07:00:00',123,23);


--m_customer_relation
insert into m_customer_relation (created_by, created_on,name)
values (1, now(), 'anak'),
(1, now(), 'ibu'),
(1, now(), 'bapak');


--m_customer_member
insert into m_customer_member (customer_id,customer_relation_id,created_by, created_on)
values (1,1,1,now());




--m_location_level
insert into m_location_level (name, created_on, created_by, is_delete,abbreviation)
values ('Provinsi', '2020-07-25 1:00:00', 1, false,'Prov'),
('Kabupaten', now(), 1, false, 'Kab'),
('Kota', now(), 1, false, 'Kota'),
('Kecamatan', now(), 1, false, 'Kec'),
('Kelurahan', now(), 1, false, 'Kel');


--m_location


--m_biodata_address
insert into m_biodata_address(address,created_by,created_on,label,postal_code,recipient,recipient_phone_number)
values ('z',1,now(),'z',1,'a',123),
('c',1,now(),'b',2,'z',345),
('a',1,now(),'c',3,'a',678);


