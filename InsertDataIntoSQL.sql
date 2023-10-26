
USE [TattooPlatform]
GO
/****** Object:  Table [dbo].[Artist]    Script Date: 10/19/2023 3:59:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Artist](
    [artist_email] [varchar](50) NOT NULL,
    [full_name] [nvarchar](50) NOT NULL,
    [phone_number] [varchar](50) NOT NULL,
    [address] [nvarchar](50) NOT NULL,
    [rate] [float] NOT NULL,
    [studio_Manager_email] [varchar](50) NOT NULL,
    [username] [varchar](20) NOT NULL,
    [password] [varchar](20) NOT NULL,
    [status_ID] [varchar](5) NOT NULL,
    [number_of_ratings] [int] NULL,
    CONSTRAINT [PK_Artist] PRIMARY KEY CLUSTERED
(
[artist_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Artist_Certificate]    Script Date: 10/19/2023 3:59:33 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Artist_Certificate](
    [certificateID] [varchar](20) NOT NULL,
    [certificate_name] [nvarchar](50) NOT NULL,
    [artist_email] [varchar](50) NOT NULL,
    CONSTRAINT [PK_Artist_Certificate] PRIMARY KEY CLUSTERED
(
[certificateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Booking]    Script Date: 10/19/2023 3:59:33 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Booking](
    [Booking_ID] [varchar](20) NOT NULL,
    [tattoo_Lover_email] [varchar](50) NOT NULL,
    [customer_email] [varchar](50) NOT NULL,
    [customer_name] [varchar](100) NOT NULL,
    [customer_phone_number] [varchar](20) NOT NULL,
    [address] [nvarchar](100) NOT NULL,
    [total_price] [float] NULL,
    CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED
(
[Booking_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Booking_Detail]    Script Date: 10/19/2023 3:59:33 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Booking_Detail](
    [booking_Detail_ID] [varchar](20) NOT NULL,
    [booking_ID] [varchar](20) NOT NULL,
    [status_ID] [varchar](20) NOT NULL,
    [description] [text] NULL,
    [slot_ID] [varchar](50) NOT NULL,
    [service_ID] [varchar](20) NOT NULL,
    [artist_email] [varchar](50) NOT NULL,
    [voucherID] [varchar](20) NULL,
    [price] [float] NULL,
    PRIMARY KEY CLUSTERED
(
[booking_Detail_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Booking_Status]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Booking_Status](
    [status_ID] [varchar](20) NOT NULL,
    [status_Name] [varchar](20) NOT NULL,
    [description] [text] NULL,
    PRIMARY KEY CLUSTERED
(
[status_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Feedback](
    [feedback_ID] [varchar](20) NOT NULL,
    [booking_Detail_ID] [varchar](20) NOT NULL,
    [description] [text] NULL,
    [tattoo_Lover_email] [varchar](50) NOT NULL,
    [service_ID] [varchar](20) NOT NULL,
    [artist_email] [varchar](50) NOT NULL,
    [artist_rating] [int] NOT NULL,
    [service_rating] [int] NOT NULL,
    [booking_date] [date] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[feedback_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Post]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Post](
    [postID] [nvarchar](20) NOT NULL,
    [post_title] [nvarchar](100) NOT NULL,
    [author_name] [nvarchar](100) NOT NULL,
    [update_date] [date] NOT NULL,
    [thumbnail_link] [nvarchar](max) NOT NULL,
    [description] [text] NOT NULL,
    [brief_info] [nvarchar](500) NOT NULL,
    [status] [int] NOT NULL,
    [system_Staff_email] [varchar](50) NOT NULL,
    [manager_email] [varchar](50) NOT NULL,
    CONSTRAINT [PK_Post] PRIMARY KEY CLUSTERED
(
[postID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Service]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Service](
    [service_ID] [varchar](20) NOT NULL,
    [service_name] [varchar](20) NOT NULL,
    [description] [text] NOT NULL,
    [link_image] [varchar](250) NOT NULL,
    [tattoo_Manager_email] [varchar](50) NOT NULL,
    [price] [float] NULL,
    CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED
(
[service_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Slot]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Slot](
    [slot_ID] [varchar](50) NOT NULL,
    [studio_ID] [varchar](50) NOT NULL,
    [start_time] [varchar](50) NOT NULL,
    [date] [date] NULL,
	[slot_status] [int] NOT NULL,
    CONSTRAINT [PK_Slot] PRIMARY KEY CLUSTERED
(
[slot_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Studio]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Studio](
    [studio_ID] [varchar](50) NOT NULL,
    [studio_name] [nvarchar](100) NOT NULL,
    [address] [nvarchar](200) NOT NULL,
    [district] [nvarchar](50) NOT NULL,
    [banner_img] [varchar](max) NOT NULL,
    [brief_info] [nchar](100) NOT NULL,
    [content] [nvarchar](max) NOT NULL,
    [manager_email] [varchar](50) NOT NULL,
    CONSTRAINT [PK_Studio] PRIMARY KEY CLUSTERED
(
[studio_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Studio_Certificate]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Studio_Certificate](
    [studio_Certificate_ID] [varchar](20) NOT NULL,
    [studio_Certificate_name] [nvarchar](50) NOT NULL,
    [description] [text] NULL,
    [studio_Manager_email] [varchar](50) NOT NULL,
    CONSTRAINT [PK_Studio_Certificate] PRIMARY KEY CLUSTERED
(
[studio_Certificate_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Studio_Tattoo_Manager]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Studio_Tattoo_Manager](
    [studio_Manager_email] [varchar](50) NOT NULL,
    [full_name] [nvarchar](50) NOT NULL,
    [phone_number] [varchar](20) NOT NULL,
    [System_Staff_email] [varchar](50) NOT NULL,
    [username] [varchar](20) NOT NULL,
    [password] [varchar](20) NOT NULL,
    [status_ID] [varchar](5) NOT NULL,
    CONSTRAINT [PK_Studio_Tattoo_Manager] PRIMARY KEY CLUSTERED
(
[studio_Manager_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[SystemStaff]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[SystemStaff](
    [system_Staff_email] [varchar](50) NOT NULL,
    [username] [nvarchar](20) NOT NULL,
    [password] [nvarchar](20) NOT NULL,
    [full_name] [nvarchar](100) NOT NULL,
    [phone_number] [nvarchar](20) NOT NULL,
    [address] [nvarchar](100) NOT NULL,
    [admin_email] [varchar](50) NOT NULL,
    [status_ID] [varchar](5) NULL,
    CONSTRAINT [PK_SystemStaff] PRIMARY KEY CLUSTERED
(
[system_Staff_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[TattooLovers]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[TattooLovers](
    [tattoo_Lover_email] [varchar](50) NOT NULL,
    [username] [nvarchar](20) NOT NULL,
    [password] [nvarchar](20) NOT NULL,
    [full_name] [nvarchar](100) NOT NULL,
    [phone_number] [nvarchar](20) NOT NULL,
    [address] [nvarchar](100) NOT NULL,
    [status_ID] [varchar](5) NOT NULL,
    CONSTRAINT [PK_TattooLovers] PRIMARY KEY CLUSTERED
(
[tattoo_Lover_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[User_Status]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[User_Status](
    [status_ID] [varchar](5) NOT NULL,
    [status_name] [varchar](10) NOT NULL,
    [description] [nvarchar](50) NULL,
    CONSTRAINT [PK_User_Status] PRIMARY KEY CLUSTERED
(
[status_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 10/19/2023 3:59:34 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Voucher](
    [voucher_ID] [varchar](20) NOT NULL,
    [voucher_Name] [varchar](20) NOT NULL,
    [start_date] [date] NOT NULL,
    [end_date] [date] NOT NULL,
    [description] [text] NULL,
    [manager_email] [varchar](50) NOT NULL,
    [discount] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[voucher_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
ALTER TABLE [dbo].[Artist]  WITH CHECK ADD  CONSTRAINT [fk_Artist_Studio_Tattoo_Manager] FOREIGN KEY([studio_Manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Artist] CHECK CONSTRAINT [fk_Artist_Studio_Tattoo_Manager]
    GO
ALTER TABLE [dbo].[Artist]  WITH CHECK ADD  CONSTRAINT [FK_Artist_User_Status] FOREIGN KEY([status_ID])
    REFERENCES [dbo].[User_Status] ([status_ID])
    GO
ALTER TABLE [dbo].[Artist] CHECK CONSTRAINT [FK_Artist_User_Status]
    GO
ALTER TABLE [dbo].[Artist_Certificate]  WITH CHECK ADD  CONSTRAINT [fk_Artist_Certificate_Artist] FOREIGN KEY([artist_email])
    REFERENCES [dbo].[Artist] ([artist_email])
    GO
ALTER TABLE [dbo].[Artist_Certificate] CHECK CONSTRAINT [fk_Artist_Certificate_Artist]
    GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Tattoo_Lover] FOREIGN KEY([tattoo_Lover_email])
    REFERENCES [dbo].[TattooLovers] ([tattoo_Lover_email])
    GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Tattoo_Lover]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Artist] FOREIGN KEY([artist_email])
    REFERENCES [dbo].[Artist] ([artist_email])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Artist]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Booking] FOREIGN KEY([booking_ID])
    REFERENCES [dbo].[Booking] ([Booking_ID])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Booking]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Booking_Status] FOREIGN KEY([status_ID])
    REFERENCES [dbo].[Booking_Status] ([status_ID])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Booking_Status]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Service] FOREIGN KEY([service_ID])
    REFERENCES [dbo].[Service] ([service_ID])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Service]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Slot] FOREIGN KEY([slot_ID])
    REFERENCES [dbo].[Slot] ([slot_ID])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Slot]
    GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Voucher] FOREIGN KEY([voucherID])
    REFERENCES [dbo].[Voucher] ([voucher_ID])
    GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Voucher]
    GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Booking_Detail] FOREIGN KEY([booking_Detail_ID])
    REFERENCES [dbo].[Booking_Detail] ([booking_Detail_ID])
    GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Booking_Detail]
    GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Studio_Tattoo_Manager] FOREIGN KEY([manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Studio_Tattoo_Manager]
    GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_SystemStaff] FOREIGN KEY([system_Staff_email])
    REFERENCES [dbo].[SystemStaff] ([system_Staff_email])
    GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_SystemStaff]
    GO
ALTER TABLE [dbo].[Service]  WITH CHECK ADD  CONSTRAINT [fk_Service_Studio_Tattoo_Manager] FOREIGN KEY([tattoo_Manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Service] CHECK CONSTRAINT [fk_Service_Studio_Tattoo_Manager]
    GO
ALTER TABLE [dbo].[Slot]  WITH CHECK ADD  CONSTRAINT [FK_Slot_Studio] FOREIGN KEY([studio_ID])
    REFERENCES [dbo].[Studio] ([studio_ID])
    GO
ALTER TABLE [dbo].[Slot] CHECK CONSTRAINT [FK_Slot_Studio]
    GO
ALTER TABLE [dbo].[Studio]  WITH CHECK ADD  CONSTRAINT [FK_Studio_Studio_Tattoo_Manager] FOREIGN KEY([manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Studio] CHECK CONSTRAINT [FK_Studio_Studio_Tattoo_Manager]
    GO
ALTER TABLE [dbo].[Studio_Certificate]  WITH CHECK ADD  CONSTRAINT [fk_Studio_Certificate_Studio_Manager] FOREIGN KEY([studio_Manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Studio_Certificate] CHECK CONSTRAINT [fk_Studio_Certificate_Studio_Manager]
    GO
ALTER TABLE [dbo].[Studio_Tattoo_Manager]  WITH CHECK ADD  CONSTRAINT [fk_Studio_Tattoo_Manager_SystemStaff] FOREIGN KEY([System_Staff_email])
    REFERENCES [dbo].[SystemStaff] ([system_Staff_email])
    GO
ALTER TABLE [dbo].[Studio_Tattoo_Manager] CHECK CONSTRAINT [fk_Studio_Tattoo_Manager_SystemStaff]
    GO
ALTER TABLE [dbo].[Studio_Tattoo_Manager]  WITH CHECK ADD  CONSTRAINT [FK_Studio_Tattoo_Manager_User_Status] FOREIGN KEY([status_ID])
    REFERENCES [dbo].[User_Status] ([status_ID])
    GO
ALTER TABLE [dbo].[Studio_Tattoo_Manager] CHECK CONSTRAINT [FK_Studio_Tattoo_Manager_User_Status]
    GO
ALTER TABLE [dbo].[SystemStaff]  WITH CHECK ADD  CONSTRAINT [FK_SystemStaff_User_Status] FOREIGN KEY([status_ID])
    REFERENCES [dbo].[User_Status] ([status_ID])
    GO
ALTER TABLE [dbo].[SystemStaff] CHECK CONSTRAINT [FK_SystemStaff_User_Status]
    GO
ALTER TABLE [dbo].[TattooLovers]  WITH CHECK ADD  CONSTRAINT [FK_TattooLovers_User_Status] FOREIGN KEY([status_ID])
    REFERENCES [dbo].[User_Status] ([status_ID])
    GO
ALTER TABLE [dbo].[TattooLovers] CHECK CONSTRAINT [FK_TattooLovers_User_Status]
    GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [FK_Voucher_Studio_Tattoo_Manager] FOREIGN KEY([manager_email])
    REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
    GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [FK_Voucher_Studio_Tattoo_Manager]
    GO

	
