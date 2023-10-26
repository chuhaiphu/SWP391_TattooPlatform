USE TattooPlatform

INSERT INTO [dbo].[User_Status] ([status_ID], [status_name], [description])
VALUES
    ('1', 'Active', 'Active status'),
    ('0', 'Suspended', 'Suspended status');

	INSERT INTO [dbo].[SystemStaff] ([system_Staff_email], [username], [password], [full_name], [phone_number], [address], [admin_email], [status_ID])
VALUES
    ('system1@example.com', 'SystemStaff1', '123', 'Ha Dinh Duc Anh', '123-456-7890', '123 Main St, City', 'admin1@example.com', '1'),
	('system2@example.com', 'SystemStaff2', '123', 'Phu Le', '123-456-7890', '234 Main St, City', 'admin2@example.com', '1'),
	('system3@example.com', 'SystemStaff3', '123', 'Tran Minh Quan', '020-712-3456', '768 Main St, City', 'admin3@example.com', '1');

	INSERT INTO [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email], [full_name], [phone_number], [System_Staff_email], [username], [password], [status_ID])
VALUES
    ('manager1@example.com', 'Nguyen Le Ngoc Cuong', '987-654-3210', 'system1@example.com', 'manager1', '123', '1'),
    ('manager2@example.com', 'Nguyen Thanh Phuc', '555-555-5555', 'system2@example.com', 'manager2', '123', '1'),
	('manager3@example.com', 'Hoang Quy Duong', '111-333-6666', 'system2@example.com', 'manager3', '123', '1'),
	('manager4@example.com', 'Do Duy Khanh', '222-444-5555', 'system1@example.com', 'manager4', '123', '1'),
	('manager5@example.com', 'Tran Danh Tai', '555-123-4567', 'system3@example.com', 'manager5', '123', '1'),
	('manager6@example.com', 'Nguyen Mai Phuong', '777-543-2314', 'system3@example.com', 'manager6', '123', '1');

	INSERT INTO [dbo].[Studio] ([studio_ID], [studio_name], [address], [district], [banner_img], [brief_info], [content], [manager_email])
VALUES
    ('S1', 'Studio A', '456 Studio Ave, New York', 'Bronx', 'https://images.toledocitypaper.com/wp-content/uploads/2022/08/image000001.jpg', 'Our studio offers a wide range of tattoo services.', 'Our services: Tattoos, tattoo erasure.', 'manager1@example.com'),
    ('S2', 'Studio B', '789 Studio St, New York', 'Brookyln', 'https://www.collectivearttattoostudio.com/usr/tattoo_shop_studio_in_riga_latvia_collective_art_xxl.jpg', 'Studio B specializes in various tattoo styles.', 'Our services: Tattoos, tattoo erasure, ear piercings.', 'manager2@example.com'),
	('S3', 'Studio C', '179 Saint St, New York', 'Manhattan', 'https://www.blackcobratattoos.com/wp-content/uploads/2021/06/black_cobra_poplar_2021a.jpg', 'Studio C specializes in various tattoo styles and piercings.', 'Our services: Tattoos, tattoo erasure, various types of body piercings.', 'manager3@example.com'),
	('S4', 'Studio D', '234 Studio Ave, New York', 'Queens', 'https://youmedia-cdn.s3.eu-west-2.amazonaws.com/wp-content/uploads/2022/03/25143227/grimm-tattoo-studio-mar-22-no-credit-800x450.png', 'We offer a wide variety of services realted to body art.', 'Our services: Tattoos, tattoo erasure, piercings.', 'manager4@example.com'),
	('S5', 'Studio E', '657 Studio St, New York', 'Bronx', 'https://images.toledocitypaper.com/wp-content/uploads/2022/08/image000001.jpg', 'We specialize in many aspects related to tattoos.', 'Our services: Tattoos, tattoo erasure.', 'manager5@example.com'),
	('S6', 'Studio G', '987 Louis St, New York', 'Queens', 'https://assets0.dostuffmedia.com/uploads/aws_asset/aws_asset/6418416/a0342f60-0956-45b2-af62-b49c12ee075c.jpg', 'We are highly proficient in tattoo and piercing services.', 'Our services: Tattoos, tattoo erasure, body piercings.', 'manager6@example.com');

	INSERT [dbo].[Studio_Certificate] ([studio_Certificate_ID],[studio_Certificate_name],[description],[studio_Manager_email])
VALUES 
	('SCerti1', 'Studio Certificate 1', 'This is a certificate for Studio A', 'manager1@example.com'),
	('SCerti2', 'Studio Certificate 2', 'This is a certificate for Studio B', 'manager2@example.com'),
	('SCerti3', 'Studio Certificate 3', 'This is a certificate for Studio C', 'manager3@example.com'),
	('SCerti4', 'Studio Certificate 4', 'This is a certificate for Studio D', 'manager4@example.com'),
	('SCerti5', 'Studio Certificate 5', 'This is a certificate for Studio E', 'manager5@example.com'),
	('SCerti6', 'Studio Certificate 6', 'This is a certificate for Studio G', 'manager5@example.com');

	INSERT INTO [dbo].[Artist] ([artist_email], [full_name], [phone_number], [address], [rate], [studio_Manager_email], [username], [password], [status_ID], [number_of_ratings])
VALUES
    ('artist1@example.com', 'Nguyen Thanh Tung', '111-111-1111', '123 Artist Lane, District 1', 75.0, 'manager1@example.com', 'artist1', '123', '1', 10),
    ('artist2@example.com', 'Nguyen Van Tang', '222-222-2222', '456 Artist Blvd, District 2', 80.0, 'manager2@example.com', 'artist2', '123', '1', 8),
	('artist3@example.com', 'Nguyen Viet Hoang', '333-333-3333', '125 Saint Street, District 11', 90.0, 'manager3@example.com', 'artist3', '123', '1', 9),
    ('artist4@example.com', 'Tran Van Tung', '444-444-4444', '765 Gate Street, District 3', 85.0, 'manager4@example.com', 'artist4', '123', '1', 8),
	('artist5@example.com', 'Tran Hai Duy', '555-555-5555', '902 Well St, District 9', 92.0, 'manager5@example.com', 'artist5', '123', '1', 7),
	('artist6@example.com', 'Van Thanh Tu', '666-555-8768', '435 Tide St, District 5', 92.0, 'manager6@example.com', 'artist6', '123', '1', 7);

	INSERT INTO [dbo].[Artist_Certificate] ([certificateID], [certificate_name], [artist_email])
VALUES
    ('cert1', 'Tattoo Artist License', 'artist1@example.com'),
    ('cert2', 'First Aid Certificate', 'artist1@example.com'),
    ('cert3', 'Tattoo Artist License', 'artist2@example.com'),
    ('cert4', 'Body Art Piercing Certification', 'artist2@example.com'),
	('cert5', 'Tattoo Artist License', 'artist3@example.com'),
	('cert6', 'Body Art Piercing Certification', 'artist3@example.com'),
	('cert12', 'Tattoo Artist License', 'artist4@example.com'),
	('cert13', 'Body Art Piercing Certification', 'artist4@example.com'),
	('cert7', 'Tattoo Artist License', 'artist5@example.com'),
	('cert8', 'First Aid Certificate', 'artist5@example.com'),
	('cert9', 'Body Art Piercing Certification', 'artist6@example.com'),
	('cert10', 'Tattoo Artist License', 'artist6@example.com'),
	('cert11', 'First Aid Certificate', 'artist6@example.com');

	INSERT INTO [dbo].[Service] ([service_ID], [service_name], [description], [link_image], [tattoo_Manager_email], [price])
VALUES
    ('service1', 'Hand Tattoo', 'Mandala hand tattoo', 'https://i.pinimg.com/736x/8b/ee/8a/8bee8a4142e0ce68bbd063037c89e9f2.jpg', 'manager1@example.com', 100.0),
    ('service2', 'Finger Tattoo', 'Flower tattoo for 1 finger', 'https://tattooicon.com/cdn/shop/products/BlackRoseFingerTemporaryTattoo_1200x1200.jpg?v=1642593662', 'manager2@example.com', 50.0),
	('service3', 'Ear Piercing', 'Multiple small flower piercings for the ear', 'https://studs.com/cdn/shop/articles/Helix2_PVL2022_EarscapeEcomm_f67863b5-6eef-4e44-b6b1-9b2576bcab9a_1024x1024.jpg?v=1672782127', 'manager3@example.com', 70.0),
    ('service4', 'Leg Tattoo', 'Tattoo on the left calf', 'https://www.dmarge.com/wp-content/uploads/2023/03/Tribal-Leg-Tattoo-Feat-Source-@stevenjhouse-via-Instagram.jpg', 'manager4@example.com', 120.0),
	('service5', 'Forearm Tattoo', 'Blackwork flower tattoo on forearm', 'https://i.pinimg.com/originals/e9/85/a7/e985a75e5eb0bba1b70feccf87e461e1.jpg', 'manager5@example.com', 100.0),
	('service6', 'Nose Piercing', 'Gold ring piercing on the nose', 'https://www.matrixbeautyacademy.co.uk/wp-content/uploads/2023/04/il_fullxfull.3679385531_7ecm-scaled-1.webp', 'manager6@example.com', 50.0);
	
	INSERT INTO [dbo].[Slot] ([slot_ID], [studio_ID], [start_time], [date], [slot_status])
VALUES
	('slot1', 'S1', '10:00 AM', '2023-10-26', '1'),
    ('slot2', 'S2', '2:00 PM', '2023-10-26', '1'),
    ('slot3', 'S3', '4:00 PM', '2023-10-26', '1'),
	('slot1', 'S4', '10:00 AM', '2023-10-27', '1'),
    ('slot2', 'S5', '2:00 PM', '2023-10-27', '1'),
    ('slot3', 'S6', '4:00 PM', '2023-10-27', '1'),
	('slot1', 'S7', '10:00 AM', '2023-10-28', '1'),
    ('slot2', 'S8', '2:00 PM', '2023-10-28', '1'),
    ('slot3', 'S9', '4:00 PM', '2023-10-28', '1'),
	('slot1', 'S10', '10:00 AM', '2023-10-29', '1'),
    ('slot2', 'S11', '2:00 PM', '2023-10-29', '1'),
    ('slot3', 'S12', '4:00 PM', '2023-10-29', '1'),
	('slot1', 'S13', '10:00 AM', '2023-10-30', '1'),
    ('slot2', 'S14', '2:00 PM', '2023-10-30', '1'),
    ('slot3', 'S15', '4:00 PM', '2023-10-30', '1'),
	('slot1', 'S16', '10:00 AM', '2023-10-31', '1'),
    ('slot2', 'S17', '2:00 PM', '2023-10-31', '1'),
    ('slot3', 'S18', '4:00 PM', '2023-10-31', '1'),
	('slot1', 'S19', '10:00 AM', '2023-11-01', '1'),
    ('slot2', 'S20', '2:00 PM', '2023-11-01', '1'),
    ('slot3', 'S21', '4:00 PM', '2023-11-01', '1'),
	('slot1', 'S22', '10:00 AM', '2023-11-02', '1'),
    ('slot2', 'S23', '2:00 PM', '2023-11-02', '1'),
    ('slot3', 'S24', '4:00 PM', '2023-11-02', '1'),
	('slot1', 'S25', '10:00 AM', '2023-11-03', '1'),
    ('slot2', 'S26', '2:00 PM', '2023-11-03', '1'),
    ('slot3', 'S27', '4:00 PM', '2023-11-03', '1'),
	('slot1', 'S28', '10:00 AM', '2023-11-04', '1'),
    ('slot2', 'S29', '2:00 PM', '2023-11-04', '1'),
    ('slot3', 'S30', '4:00 PM', '2023-11-04', '1'),
	('slot1', 'S31', '10:00 AM', '2023-11-05', '1'),
    ('slot2', 'S32', '2:00 PM', '2023-11-05', '1'),
    ('slot3', 'S33', '4:00 PM', '2023-11-05', '1'),
	('slot1', 'S34', '10:00 AM', '2023-11-06', '1'),
    ('slot2', 'S35', '2:00 PM', '2023-11-06', '1'),
    ('slot3', 'S36', '4:00 PM', '2023-11-06', '1'),
	('slot1', 'S37', '10:00 AM', '2023-11-07', '1'),
    ('slot2', 'S38', '2:00 PM', '2023-11-07', '1'),
    ('slot3', 'S39', '4:00 PM', '2023-11-07', '1'),
	('slot1', 'S40', '10:00 AM', '2023-11-08', '1'),
    ('slot2', 'S41', '2:00 PM', '2023-11-08', '1'),
    ('slot3', 'S42', '4:00 PM', '2023-11-08', '1'),
	('slot1', 'S43', '10:00 AM', '2023-11-09', '1'),
    ('slot2', 'S44', '2:00 PM', '2023-11-09', '1'),
    ('slot3', 'S45', '4:00 PM', '2023-11-09', '1'),
	('slot1', 'S46', '10:00 AM', '2023-11-10', '1'),
    ('slot2', 'S47', '2:00 PM', '2023-11-10', '1'),
    ('slot3', 'S48', '4:00 PM', '2023-11-10', '1'),
	('slot1', 'S49', '10:00 AM', '2023-11-11', '1'),
    ('slot2', 'S50', '2:00 PM', '2023-11-11', '1'),
    ('slot3', 'S51', '4:00 PM', '2023-11-11', '1'),
	('slot1', 'S52', '10:00 AM', '2023-11-12', '1'),
    ('slot2', 'S53', '2:00 PM', '2023-11-12', '1'),
    ('slot3', 'S54', '4:00 PM', '2023-11-12', '1'),
	('slot1', 'S55', '10:00 AM', '2023-11-13', '1'),
    ('slot2', 'S56', '2:00 PM', '2023-11-13', '1'),
    ('slot3', 'S57', '4:00 PM', '2023-11-13', '1'),
	('slot1', 'S58', '10:00 AM', '2023-11-14', '1'),
    ('slot2', 'S59', '2:00 PM', '2023-11-14', '1'),
    ('slot3', 'S60', '4:00 PM', '2023-11-14', '1'),
	('slot1', 'S61', '10:00 AM', '2023-11-15', '1'),
    ('slot2', 'S62', '2:00 PM', '2023-11-15', '1'),
    ('slot3', 'S63', '4:00 PM', '2023-11-15', '1'),
	('slot1', 'S64', '10:00 AM', '2023-11-16', '1'),
    ('slot2', 'S65', '2:00 PM', '2023-11-16', '1'),
    ('slot3', 'S66', '4:00 PM', '2023-11-16', '1'),
	('slot1', 'S67', '10:00 AM', '2023-11-17', '1'),
    ('slot2', 'S68', '2:00 PM', '2023-11-17', '1'),
    ('slot3', 'S69', '4:00 PM', '2023-11-17', '1'),
	('slot1', 'S70', '10:00 AM', '2023-11-18', '1'),
    ('slot2', 'S71', '2:00 PM', '2023-11-18', '1'),
    ('slot3', 'S72', '4:00 PM', '2023-11-18', '1'),
	('slot1', 'S73', '10:00 AM', '2023-11-19', '1'),
    ('slot2', 'S74', '2:00 PM', '2023-11-19', '1'),
    ('slot3', 'S75', '4:00 PM', '2023-11-19', '1'),
	('slot1', 'S76', '10:00 AM', '2023-11-20', '1'),
    ('slot2', 'S77', '2:00 PM', '2023-11-20', '1'),
    ('slot3', 'S78', '4:00 PM', '2023-11-20', '1'),
	('slot1', 'S79', '10:00 AM', '2023-11-21', '1'),
    ('slot2', 'S80', '2:00 PM', '2023-11-21', '1'),
    ('slot3', 'S81', '4:00 PM', '2023-11-21', '1'),
	('slot1', 'S82', '10:00 AM', '2023-11-22', '1'),
    ('slot2', 'S83', '2:00 PM', '2023-11-22', '1'),
    ('slot3', 'S84', '4:00 PM', '2023-11-22', '1'),
	('slot1', 'S85', '10:00 AM', '2023-11-23', '1'),
    ('slot2', 'S86', '2:00 PM', '2023-11-23', '1'),
    ('slot3', 'S87', '4:00 PM', '2023-11-23', '1'),
	('slot1', 'S88', '10:00 AM', '2023-11-24', '1'),
    ('slot2', 'S89', '2:00 PM', '2023-11-24', '1'),
    ('slot3', 'S90', '4:00 PM', '2023-11-24', '1'),
	('slot1', 'S91', '10:00 AM', '2023-11-25', '1'),
    ('slot2', 'S92', '2:00 PM', '2023-11-25', '1'),
    ('slot3', 'S93', '4:00 PM', '2023-11-25', '1'),	
	('slot1', 'S94', '10:00 AM', '2023-11-26', '1'),
    ('slot2', 'S95', '2:00 PM', '2023-11-26', '1'),
    ('slot3', 'S96', '4:00 PM', '2023-11-26', '1'),	
	('slot1', 'S97', '10:00 AM', '2023-11-27', '1'),
    ('slot2', 'S98', '2:00 PM', '2023-11-27', '1'),
    ('slot3', 'S99', '4:00 PM', '2023-11-27', '1'),	
	('slot1', 'S101', '10:00 AM', '2023-11-28', '1'),
    ('slot2', 'S102', '2:00 PM', '2023-11-28', '1'),
    ('slot3', 'S103', '4:00 PM', '2023-11-28', '1'),	
	('slot1', 'S104', '10:00 AM', '2023-11-29', '1'),
    ('slot2', 'S105', '2:00 PM', '2023-11-29', '1'),
    ('slot3', 'S106', '4:00 PM', '2023-11-29', '1'),	
	('slot1', 'S107', '10:00 AM', '2023-11-30', '1'),
    ('slot2', 'S108', '2:00 PM', '2023-11-30', '1'),
    ('slot3', 'S109', '4:00 PM', '2023-11-30', '1');

	INSERT INTO [dbo].[Booking_Status] ([status_ID], [status_Name], [description])
VALUES
    ('status1', 'Pending', 'Booking is pending approval'),
    ('status2', 'Completed', 'Booking is completed');

	INSERT INTO [dbo].[TattooLovers] ([tattoo_Lover_email], [username], [password], [full_name], [phone_number], [address], [status_ID])
VALUES
    ('lover1@example.com', 'lover1', '123', 'Dang Phuc Loc', '777-777-7777', '123 Lover Lane, District 1', '1'),
    ('lover2@example.com', 'lover2', '123', 'Le Vinh Quang', '666-666-6666', '456 Lover Blvd, District 2', '1'),
	('lover3@example.com', 'lover3', '123', 'Truong Anh Ngoc', '100-100-1000', '100 Lover Lane, District 1', '1'),
    ('lover4@example.com', 'lover4', '123', 'Trinh Van Hieu', '987-987-6666', '98A Lover Street, District 3', '1'),
	('lover5@example.com', 'lover5', '123', 'Tran Anh Tu', '231-435-3466', '11/17 Lake Street, District 5', '1'),
	('lover6@example.com', 'lover6', '123', 'Tran Ngoc Mai', '765-123-9783', '314 Salt Street, District 9', '1');

	INSERT INTO [dbo].[Booking] ([Booking_ID], [tattoo_Lover_email], [customer_email], [customer_name], [customer_phone_number], [address], [total_price])
VALUES
    ('booking1', 'lover1@example.com', 'customer1@example.com', 'Pham Minh', '999-999-9999', '123 Lover Lane, District 1', 110.0),
    ('booking2', 'lover2@example.com', 'customer2@example.com', 'Hoang Xuan Quang', '888-888-8888', '456 Lover Blvd, District 2', 55.0),
	('booking3', 'lover3@example.com', 'customer3@example.com', 'Truong Anh Ngoc', '100-100-1000', '456 Lover Blvd, District 2',77.0),
	('booking4', 'lover4@example.com', 'customer4@example.com', 'Nguyen Dai Nam', '909-909-9090', '456 Lover Blvd, District 2', 132.0),
	('booking5', 'lover5@example.com', 'customer5@example.com', 'Tran Anh Tu', '231-435-3466', '11/17 Lake Street, District 5', 132.0),
	('booking6', 'lover6@example.com', 'customer6@example.com', 'Tran Ngoc Mai', '765-123-9783', '314 Salt Street, District 9', 49.5);

	INSERT INTO [dbo].[Booking_Detail] ([booking_Detail_ID], [booking_ID], [status_ID], [description], [slot_ID], [service_ID], [artist_email], [voucherID], [price])
VALUES
    ('detail1', 'booking1', 'status2', 'Hand tattoo for Pham Minh', 'slot1', 'service1', 'artist1@example.com', NULL, 110.0),
    ('detail2', 'booking2', 'status2', 'Finger tattoo for Hoang Xuan Quang', 'slot2', 'service2', 'artist2@example.com', NULL, 55.0),
    ('detail3', 'booking3', 'status2', 'Ear piercing for Truong Anh Ngoc', 'slot3', 'service3', 'artist3@example.com', NULL, 77.0),
    ('detail4', 'booking4', 'status2', 'Leg tattoo for Nguyen Dai Nam', 'slot4', 'service4', 'artist4@example.com', NULL, 132.0),
	('detail5', 'booking5', 'status2', 'Forearm tattoo for Tran Anh Tu', 'slot6', 'service5', 'artist5@example.com', NULL, 110.0),
	('detail6', 'booking6', 'status2', 'Nose piercing for Tran Ngoc Mai', 'slot6', 'service6', 'artist6@example.com', 'voucher1', 49.5);

	INSERT INTO [dbo].[Feedback] ([feedback_ID], [booking_Detail_ID], [description], [tattoo_Lover_email], [service_ID], [artist_email], [artist_rating], [service_rating], [booking_date])
VALUES
    ('feedback1', 'detail1', 'Great service!', 'lover1@example.com', 'service1', 'artist1@example.com', 5, 4, '2023-10-20'),
    ('feedback2', 'detail3', 'Awesome experience!', 'lover2@example.com', 'service2', 'artist2@example.com', 5, 5, '2023-10-21'),
	('feedback3', 'detail3', 'Thank you so much!', 'lover3@example.com', 'service3', 'artist3@example.com', 5, 5, '2023-10-23'),
    ('feedback4', 'detail4', 'Amazing artist!', 'lover4@example.com', 'service4', 'artist4@example.com', 5, 5, '2023-10-22'),
	('feedback5', 'detail5', 'I love this tattoo!', 'lover5@example.com', 'service5', 'artist5@example.com', 5, 5, '2023-10-22'),
	('feedback6', 'detail6', 'Great work with the piercing!', 'lover6@example.com', 'service6', 'artist6@example.com', 4, 5, '2023-10-12');

	INSERT INTO [dbo].[Post] ([postID], [post_title], [author_name], [update_date], [thumbnail_link], [description], [brief_info], [status], [system_Staff_email], [manager_email])
VALUES
    ('post1', 'Tattoo Trends', 'Nguyen Le Ngoc Cuong', '2023-10-20', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.phuot3mien.com%2Fget-a-tattoo-in-ho-chi-minh-city.html&psig=AOvVaw1GL3q6oD_obeC-VDU5mrcO&ust=1697963733749000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKCqmvzdhoIDFQAAAAAdAAAAABAE', 'Explore the latest tattoo trends in our blog.', 'Discover the hottest tattoo styles and designs.', 1, 'system1@example.com', 'manager1@example.com'),
    ('post2', 'Studio B Spotlight', 'Nguyen Thanh Phuc', '2023-10-21', 'https://media.cnn.com/api/v1/images/stellar/prod/230106141452-02-chen-jie.jpg?q=w_2000,c_fillg', 'Learn more about Studio B and its offerings.', 'Get to know our featured studio!', 1, 'system2@example.com', 'manager2@example.com'),
	('post3', 'The sacred tattoo inked by Thai monks', 'Hoang Quy Duong', '2023-10-19', 'https://ichef.bbci.co.uk/news/1024/branded_news/12DFD/production/_129090377_tattoosthumbnailjpg2.jpg', 'The BBC visits a 400-year-old Thai temple where devotees get spiritual tattoos.', 'Get to know these ancient tattoos!', 1, 'system2@example.com', 'manager3@example.com'),
	('post4', 'From cultural to criminal — the complex world of tattoos in Asian families', 'Do Duy Khanh', '2023-10-19', 'https://live-production.wcms.abc-cdn.net.au/3605073e1e4493ab111be8bc08e7d0f4?impolicy=wcms_crop_resize&cropH=920&cropW=1635&xPos=132&yPos=160&width=862&height=485', 'A lot of families in asia look down on tattoos, seeing them as a symbol of violence.', 'What do asian parents think about tattoos?', 1, 'system1@example.com', 'manager4@example.com');

	INSERT INTO [dbo].[Voucher] ([voucher_ID], [voucher_Name], [start_date], [end_date], [description], [manager_email], [discount])
VALUES
    ('voucher1', 'Discount Voucher 1', '2023-10-20', '2023-10-25', 'Save 10% on your next booking!', 'manager1@example.com', 10),
    ('voucher2', 'Discount Voucher 2', '2023-10-22', '2023-10-27', 'Get 15% off on select services!', 'manager2@example.com', 15);
