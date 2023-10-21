INSERT INTO [dbo].[User_Status] ([status_ID], [status_name], [description], [start_date], [end_date])
VALUES
    ('1', 'Active', 'Active status', '2023-01-01', '2023-12-12'),
    ('2', 'Suspended', 'Suspended status', '2023-01-01', '2023-12-12');

	INSERT INTO [dbo].[SystemStaff] ([system_Staff_email], [username], [password], [full_name], [phone_number], [address], [admin_email], [status_ID])
VALUES
    ('system1@example.com', 'SystemStaff1', '123', 'Duc Anh', '123-456-7890', '123 Main St, City', 'admin1@example.com', '1'),
	('system2@example.com', 'SystemStaff2', '123', 'Phu Le', '123-456-7890', '123 Main St, City', 'admin2@example.com', '1');

	INSERT INTO [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email], [full_name], [phone_number], [System_Staff_email], [username], [password], [status_ID])
VALUES
    ('manager1@example.com', 'Cuong', '987-654-3210', 'system1@example.com', 'manager1', '123', '1'),
    ('manager2@example.com', 'Cuong', '555-555-5555', 'system2@example.com', 'manager2', '123', '1');

	INSERT INTO [dbo].[Studio] ([studio_ID], [studio_name], [address], [district], [banner_img], [brief_info], [content], [manager_email])
VALUES
    ('S1', 'Studio A', '456 Studio Ave, District 1', 'District 1', 'https://images.toledocitypaper.com/wp-content/uploads/2022/08/image000001.jpg', 'Vjp', 'Our studio offers a wide range of tattoo services.', 'manager1@example.com'),
    ('S2', 'Studio B', '789 Studio St, District 2', 'District 2', 'https://www.collectivearttattoostudio.com/usr/tattoo_shop_studio_in_riga_latvia_collective_art_xxl.jpg', 'Vjp', 'Studio B specializes in various tattoo styles.', 'manager2@example.com');
	
	INSERT INTO [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email], [full_name], [phone_number], [System_Staff_email], [username], [password], [status_ID])
VALUES
    ('manager1@example.com', 'Nguyen Le Ngoc Cuong', '987-654-3210', 'system1@example.com', 'manager1', '123', '1'),
    ('manager2@example.com', 'Nguyen Thanh Phuc', '555-555-5555', 'system2@example.com', 'manager2', '123', '1');

	INSERT [dbo].[Studio_Certificate] ([studio_Certificate_ID],[studio_Certificate_name],[description],[studio_Manager_email])
VALUES 
	('SCerti1', 'Studio Certificate 1', 'This is a certificate for Studio A', 'manager1@example.com'),
	('SCerti2', 'Studio Certificate 2', 'This is a certificate for Studio B', 'manager2@example.com');

	INSERT INTO [dbo].[Artist] ([artist_email], [full_name], [phone_number], [address], [rate], [studio_Manager_email], [username], [password], [status_ID], [numer_of_ratings])
VALUES
    ('artist1@example.com', 'Artist 1', '111-111-1111', '123 Artist Lane, District 1', 75.0, 'manager1@example.com', 'artist1', '123', '1', 10),
    ('artist2@example.com', 'Artist 2', '222-222-2222', '456 Artist Blvd, District 2', 80.0, 'manager2@example.com', 'artist2', '123', '1', 8);

	INSERT INTO [dbo].[Artist_Certificate] ([certificateID], [certificate_name], [artist_email])
VALUES
    ('cert1', 'Certification 1', 'artist1@example.com'),
    ('cert2', 'Certification 2', 'artist1@example.com'),
    ('cert3', 'Certification 1', 'artist2@example.com'),
    ('cert4', 'Certification 2', 'artist2@example.com');

	INSERT INTO [dbo].[Service] ([service_ID], [service_name], [description], [link_image], [tattoo_Manager_email], [price])
VALUES
    ('service1', 'Tattoo Service 1', 'Service description 1', 'service1.jpg', 'manager1@example.com', 100.0),
    ('service2', 'Tattoo Service 2', 'Service description 2', 'service2.jpg', 'manager2@example.com', 120.0);

	INSERT INTO [dbo].[Slot] ([slot_ID], [studio_ID], [start_time], [end_time], [date])
VALUES
    ('slot1', 'S1', '10:00 AM', '11:00 AM', '2023-10-20'),
    ('slot2', 'S1', '11:00 AM', '12:00 PM', '2023-10-20'),
    ('slot3', 'S2', '2:00 PM', '3:00 PM', '2023-10-21'),
    ('slot4', 'S2', '3:00 PM', '4:00 PM', '2023-10-21');
	
	INSERT INTO [dbo].[Booking_Status] ([status_ID], [status_Name], [description])
VALUES
    ('status1', 'Pending', 'Booking is pending approval'),
    ('status2', 'Confirmed', 'Booking is confirmed'),
    ('status3', 'Completed', 'Booking is completed');

	INSERT INTO [dbo].[TattooLovers] ([tattoo_Lover_email], [username], [password], [full_name], [phone_number], [address], [status_ID])
VALUES
    ('lover1@example.com', 'lover1', 'password', 'Tattoo Lover 1', '777-777-7777', '123 Lover Lane, District 1', '1'),
    ('lover2@example.com', 'lover2', 'password', 'Tattoo Lover 2', '666-666-6666', '456 Lover Blvd, District 2', '1');

	INSERT INTO [dbo].[Booking] ([Booking_ID], [tattoo_Lover_email], [customer_email], [customer_name], [customer_phone_number], [address], [total_price])
VALUES
    ('booking1', 'lover1@example.com', 'customer1@example.com', 'Phuc Loc', '999-999-9999', '123 Lover Lane, District 1', 120.0),
    ('booking2', 'lover2@example.com', 'customer2@example.com', 'De Pe Lo', '888-888-8888', '456 Lover Blvd, District 2', 100.0);

	INSERT INTO [dbo].[Booking_Detail] ([booking_Detail_ID], [booking_ID], [status_ID], [description], [slot_ID], [service_ID], [artist_email], [voucherID], [price])
VALUES
    ('detail1', 'booking1', 'status2', 'Service for Customer 1', 'slot1', 'service1', 'artist1@example.com', NULL, 100.0),
    ('detail2', 'booking1', 'status2', 'Service for Customer 1', 'slot2', 'service2', 'artist2@example.com', NULL, 20.0),
    ('detail3', 'booking2', 'status2', 'Service for Customer 2', 'slot3', 'service1', 'artist1@example.com', NULL, 90.0),
    ('detail4', 'booking2', 'status2', 'Service for Customer 2', 'slot4', 'service2', 'artist2@example.com', NULL, 10.0);

	INSERT INTO [dbo].[Feedback] ([feedback_ID], [booking_Detail_ID], [description], [tattoo_Lover_email], [service_ID], [artist_email], [artist_rating], [service_rating], [booking_date])
VALUES
    ('feedback1', 'detail1', 'Great service!', 'lover1@example.com', 'service1', 'artist1@example.com', 5, 4, '2023-10-20'),
    ('feedback2', 'detail3', 'Awesome experience!', 'lover2@example.com', 'service2', 'artist2@example.com', 5, 5, '2023-10-21');

	INSERT INTO [dbo].[Post] ([postID], [post_title], [author_name], [update_date], [thumbnail_link], [description], [brief_info], [status], [system_Staff_email], [manager_email])
VALUES
    ('post1', 'Tattoo Trends', 'Nguyen Le Ngoc Cuong', '2023-10-20', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.phuot3mien.com%2Fget-a-tattoo-in-ho-chi-minh-city.html&psig=AOvVaw1GL3q6oD_obeC-VDU5mrcO&ust=1697963733749000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCKCqmvzdhoIDFQAAAAAdAAAAABAE', 'Explore the latest tattoo trends in our blog.', 'Discover the hottest tattoo styles and designs.', 1, 'system1@example.com', 'manager1@example.com'),
    ('post2', 'Studio A Spotlight', 'Nguyen Thanh Phuc', '2023-10-21', 'https://media.cnn.com/api/v1/images/stellar/prod/230106141452-02-chen-jie.jpg?q=w_2000,c_fillg', 'Learn more about Studio A and its offerings.', 'Get to know our featured studio!', 1, 'system2@example.com', 'manager2@example.com');

	INSERT INTO [dbo].[Voucher] ([voucher_ID], [voucher_Name], [start_date], [end_date], [description], [manager_email], [discount])
VALUES
    ('voucher1', 'Discount Voucher 1', '2023-10-20', '2023-10-25', 'Save 10% on your next booking!', 'manager1@example.com', 10),
    ('voucher2', 'Discount Voucher 2', '2023-10-22', '2023-10-27', 'Get 15% off on select services!', 'manager2@example.com', 15);
