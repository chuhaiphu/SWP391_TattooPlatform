


Create database TattooPlatform
use TattooPlatform

CREATE TABLE [dbo].[Admin](
	[admin_email] [varchar](50) NOT NULL,
	[username] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[full_name] [nvarchar](100) NOT NULL,
	[phone_number] [nvarchar](20) NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[roleID] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[admin_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Artist]    Script Date: 10/2/2023 10:02:52 AM ******/
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
 CONSTRAINT [PK_Artist] PRIMARY KEY CLUSTERED 
(
	[artist_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Artist_Certificate]    Script Date: 10/2/2023 10:02:52 AM ******/
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
/****** Object:  Table [dbo].[Booking]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Booking](
	[tattoo_Lover_email] [varchar](50)NOT NULL,
	[service_ID] [varchar](20) NOT NULL,
	[artist_email] [varchar](50) NOT NULL,
	[time] [time](7) NOT NULL,
	[date] [date] NOT NULL,
	[customer_name] [varchar](100) NOT NULL,
	[customer_phone_number] [varchar](20) NOT NULL,

)

alter table Booking 
add constraint PK_Booking
Primary key (tattoo_lover_email, service_ID, artist_email)


/****** Object:  Table [dbo].[Booking_Detail]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking_Detail](
	[booking_Detail_ID] [varchar](20) NOT NULL,
	[booking_ID] [varchar](20) NOT NULL,
	[statusID] [varchar](20) NOT NULL,
	[description] [text] NULL,
	[tattoo_Lover_email] [varchar](50)NOT NULL,
	[service_ID] [varchar](20) NOT NULL,
	[artist_email] [varchar](50)NOT NULL,
	[voucherID] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[booking_Detail_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) 
GO

/****** Object:  Table [dbo].[Feedback]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[booking_Detail_ID] [varchar](20) NOT NULL,
	[description] [text] NULL,
	[tattoo_Lover_email] [varchar](50)NOT NULL,
	[service_ID] [varchar](20) NOT NULL,
	[artist_email] [varchar](50)NOT NULL,

) 
alter table Feedback
add constraint PK_Feedback
primary key (tattoo_lover_email, service_ID, artist_email)

GO
/****** Object:  Table [dbo].[Post]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[postID] [nvarchar](20) NOT NULL,
	[post_tittle] [nvarchar](100) NOT NULL,
	[author_name] [nvarchar](100) NOT NULL,
	[update_date] [date] NOT NULL,
	[thumbnail_link] [nvarchar](max) NOT NULL,
	[description] [text] NOT NULL,
	[brief_info] [nvarchar](500) NOT NULL,
	[status] [int] NOT NULL,
	[system_Staff_email] [varchar](50) NOT NULL,
	[admin_email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Post] PRIMARY KEY CLUSTERED 
(
	[postID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_ID] [varchar](20) NOT NULL,
	[role_name] [varchar](20) NOT NULL,
 CONSTRAINT [role_ID] PRIMARY KEY CLUSTERED 
(
	[role_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role_Artist]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Artist](
	[role_ID] [varchar](20) NOT NULL,
	[tattoo_Lover_email] [varchar](50)NOT NULL,
) 

alter table Role_Artist
add constraint PK_Role_Artist
primary key (role_ID, tattoo_Lover_email)
GO
/****** Object:  Table [dbo].[Role_StudioTattooManager]    Script Date: 10/2/2023 10:02:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_StudioTattooManager](
	[role_ID] [varchar](20)NOT NULL,
	[studio_Manager_email] [varchar](50)NOT NULL,
) 

alter table Role_StudioTattooManager
add constraint PK_Role_StudioTattooManager
primary key (role_ID, studio_Manager_email)
GO
/****** Object:  Table [dbo].[Role_TattooLovers]    Script Date: 10/2/2023 10:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_TattooLovers](
	[role_ID] [varchar](20) NOT NULL,
	[tattoo_Lover_email] [varchar](50) NOT NULL,
) 
alter table Role_TattooLovers
add constraint PK_Role_TattooLovers
primary key (role_ID, tattoo_lover_email)

GO
/****** Object:  Table [dbo].[Service]    Script Date: 10/2/2023 10:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[service_ID] [varchar](20) NOT NULL,
	[service_name] [varchar](20) NOT NULL,
	[description] [text] NOT NULL,
	[price] [float] NOT NULL,
	[link_image] [varchar](250) NOT NULL,
	[tattoo_Manager_email] [varchar](50) NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[service_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 10/2/2023 10:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create table Booking_Detail_Status (
	statusID varchar(20) not null,
	Booking_Detail_ID varchar(20) not null
)

alter table Booking_Detail_Status
add constraint PK_Booking_Detail_Status
primary key(statusID,Booking_Detail_ID )

CREATE TABLE [dbo].[Status](
	[statusID] [varchar](20) NOT NULL,
	[status_Name] [varchar](20) NOT NULL,
	[description] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[statusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Studio_Certificate]    Script Date: 10/2/2023 10:02:53 AM ******/
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
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Studio_Tattoo_Manager]    Script Date: 10/2/2023 10:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Studio_Tattoo_Manager](
	[studio_Manager_email] [varchar](50) NOT NULL,
	[full_name] [nvarchar](20) NOT NULL,
	[phone_number] [varchar](20) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[System_Staff_email] [varchar](50) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Studio_Tattoo_Manager] PRIMARY KEY CLUSTERED 
(
	[studio_Manager_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SystemStaff]    Script Date: 10/2/2023 10:02:53 AM ******/
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
	[roleID] [nvarchar](20) NOT NULL,
	[admin_email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_SystemStaff] PRIMARY KEY CLUSTERED 
(
	[system_Staff_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TattooLovers]    Script Date: 10/2/2023 10:02:53 AM ******/
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
	[system_Staff_email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_TattooLovers] PRIMARY KEY CLUSTERED 
(
	[tattoo_Lover_email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 10/2/2023 10:02:53 AM ******/
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
PRIMARY KEY CLUSTERED 
(
	[voucher_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


ALTER TABLE [dbo].[Artist]  WITH CHECK ADD  CONSTRAINT [fk_Artist_Studio_Tattoo_Manager] FOREIGN KEY([studio_Manager_email])
REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
GO
ALTER TABLE [dbo].[Artist] CHECK CONSTRAINT [fk_Artist_Studio_Tattoo_Manager]
GO


ALTER TABLE [dbo].[Artist_Certificate]  WITH CHECK ADD  CONSTRAINT [fk_Artist_Certificate_Artist] FOREIGN KEY([artist_email])
REFERENCES [dbo].[Artist] ([artist_email])
GO
ALTER TABLE [dbo].[Artist_Certificate] CHECK CONSTRAINT [fk_Artist_Certificate_Artist]
GO


ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Artist] FOREIGN KEY([artist_email])
REFERENCES [dbo].[Artist] ([artist_email])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Artist]
GO


ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Service] FOREIGN KEY([service_ID])
REFERENCES [dbo].[Service] ([service_ID])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Service]
GO



ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Tattoo_Lover] FOREIGN KEY([tattoo_Lover_email])
REFERENCES [dbo].[TattooLovers] ([tattoo_Lover_email])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Tattoo_Lover]
GO


ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Booking] FOREIGN KEY(tattoo_lover_email, service_ID, artist_email)
REFERENCES [dbo].[Booking] (tattoo_lover_email, service_ID, artist_email)
GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Booking]
GO


ALTER TABLE Booking_Detail_Status WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Status_Booking_Detail] FOREIGN KEY([booking_Detail_ID])
REFERENCES [dbo].[Booking_Detail] ([Booking_Detail_ID])
GO

ALTER TABLE Booking_Detail_Status WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Status_Status] FOREIGN KEY([statusID])
REFERENCES [dbo].[Status] ([statusID])
GO

/*------------------------------------------------------------------------------------------------------------------------------------*/

ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Voucher] FOREIGN KEY([voucherID])
REFERENCES [dbo].[Voucher] ([voucher_ID])
GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Voucher]
GO


ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Booking_Detail] FOREIGN KEY(tattoo_lover_email, service_ID, artist_email)
REFERENCES [dbo].[Feedback] (tattoo_lover_email, service_ID, artist_email)
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Booking_Detail]
GO


ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Admin] FOREIGN KEY([admin_email])
REFERENCES [dbo].[Admin] ([admin_email])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Admin]
GO


ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_SystemStaff] FOREIGN KEY([system_Staff_email])
REFERENCES [dbo].[SystemStaff] ([system_Staff_email])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_SystemStaff]
GO

/*--------------------------------------------------------------------------------------------------------------------*/
ALTER TABLE [dbo].[Role_Artist]  WITH CHECK ADD  CONSTRAINT [FK_Artist_Role] FOREIGN KEY([tattoo_Lover_email])
REFERENCES [dbo].[TattooLovers] ([tattoo_Lover_email])
GO
ALTER TABLE [dbo].[Role_Artist] CHECK CONSTRAINT [FK_Artist_Role]
GO


ALTER TABLE [dbo].[Role_Artist]  WITH CHECK ADD  CONSTRAINT [FK_Role_Artist] FOREIGN KEY([role_ID])
REFERENCES [dbo].[Role] ([role_ID])
GO
ALTER TABLE [dbo].[Role_Artist] CHECK CONSTRAINT [FK_Role_Artist]
GO


ALTER TABLE [dbo].[Role_StudioTattooManager]  WITH CHECK ADD  CONSTRAINT [FK_Role_StudioTattooManager] FOREIGN KEY([role_ID])
REFERENCES [dbo].[Role] ([role_ID])
GO
ALTER TABLE [dbo].[Role_StudioTattooManager] CHECK CONSTRAINT [FK_Role_StudioTattooManager]
GO


ALTER TABLE [dbo].[Role_StudioTattooManager]  WITH CHECK ADD  CONSTRAINT [FK_StudioTattooManager_Role] FOREIGN KEY([studio_Manager_email])
REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
GO
ALTER TABLE [dbo].[Role_StudioTattooManager] CHECK CONSTRAINT [FK_StudioTattooManager_Role]
GO


ALTER TABLE [dbo].[Role_TattooLovers]  WITH CHECK ADD  CONSTRAINT [FK_Role_TattooLovers] FOREIGN KEY([role_ID])
REFERENCES [dbo].[Role] ([role_ID])
GO
ALTER TABLE [dbo].[Role_TattooLovers] CHECK CONSTRAINT [FK_Role_TattooLovers]
GO


ALTER TABLE [dbo].[Role_TattooLovers]  WITH CHECK ADD  CONSTRAINT [FK_TattooLovers_Role] FOREIGN KEY([tattoo_Lover_email])
REFERENCES [dbo].[TattooLovers] ([tattoo_Lover_email])
GO
ALTER TABLE [dbo].[Role_TattooLovers] CHECK CONSTRAINT [FK_TattooLovers_Role]
GO

/*------------------------------------------------------------------------------------------------------------------------------------*/
ALTER TABLE [dbo].[Service]  WITH CHECK ADD  CONSTRAINT [fk_Service_Studio_Tattoo_Manager] FOREIGN KEY([tattoo_Manager_email])
REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
GO
ALTER TABLE [dbo].[Service] CHECK CONSTRAINT [fk_Service_Studio_Tattoo_Manager]
GO


ALTER TABLE [dbo].[Studio_Certificate]  WITH CHECK ADD  CONSTRAINT [fk_Studio_Certificate_Studio_Tattoo_Manager] FOREIGN KEY([studio_Manager_email])
REFERENCES [dbo].[Studio_Tattoo_Manager] ([studio_Manager_email])
GO
ALTER TABLE [dbo].[Studio_Certificate] CHECK CONSTRAINT [fk_Studio_Certificate_Studio_Tattoo_Manager]
GO


ALTER TABLE [dbo].[Studio_Tattoo_Manager]  WITH CHECK ADD  CONSTRAINT [fk_Studio_Tattoo_Manager_SystemStaff] FOREIGN KEY([System_Staff_email])
REFERENCES [dbo].[SystemStaff] ([system_Staff_email])
GO
ALTER TABLE [dbo].[Studio_Tattoo_Manager] CHECK CONSTRAINT [fk_Studio_Tattoo_Manager_SystemStaff]
GO


ALTER TABLE [dbo].[SystemStaff]  WITH CHECK ADD  CONSTRAINT [FK_SystemStaff_Admin] FOREIGN KEY([admin_email])
REFERENCES [dbo].[Admin] ([admin_email])
GO
ALTER TABLE [dbo].[SystemStaff] CHECK CONSTRAINT [FK_SystemStaff_Admin]
GO


ALTER TABLE [dbo].[TattooLovers]  WITH CHECK ADD  CONSTRAINT [FK_TattooLovers_SystemStaff] FOREIGN KEY([system_Staff_email])
REFERENCES [dbo].[SystemStaff] ([system_Staff_email])
GO
ALTER TABLE [dbo].[TattooLovers] CHECK CONSTRAINT [FK_TattooLovers_SystemStaff]
GO
