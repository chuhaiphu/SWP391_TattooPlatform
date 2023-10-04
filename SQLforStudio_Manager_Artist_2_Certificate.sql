use Demo

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Studio_Tattoo_Manager](
	[email] [varchar](20) NOT NULL,
	[full_name] [nvarchar](20) NOT NULL,
	[phone_number] [varchar](20) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[roleID] [varchar](10) NOT NULL,
	[System_Staff_email] [varchar](20) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Studio_Tattoo_Manager] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO



CREATE TABLE [dbo].[Studio_Certificate](
	[studio_certificate_ID] [varchar](20) NOT NULL,
	[studio_certificate_name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](250) NULL,
	[studio_manager_email] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Studio_Certificate] PRIMARY KEY CLUSTERED 
(
	[studio_certificate_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[Artist_Certificate](
	[certificateID] [varchar](20) NOT NULL,
	[certificate_name] [nvarchar](50) NOT NULL,
	[Artist_email] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Artist_Certificate] PRIMARY KEY CLUSTERED 
(
	[certificateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[Artist](
	[email] [varchar](20) NOT NULL,
	[full_name] [nvarchar](50) NOT NULL,
	[phone_number] [varchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[rate] [float] NOT NULL,
	[roleID] [varchar](10) NOT NULL,
	[studio_manager_email] [varchar](20) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Artist] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

alter table Studio_Certificate 
add constraint fk_Studio_Certificate_Studio_Tattoo_Manager
foreign key (studio_manager_email) 
references Studio_Tattoo_Manager (email)

alter table Artist 
add constraint fk_Artist_Studio_Tattoo_Manager
foreign key (studio_manager_email) 
references Studio_Tattoo_Manager(email)

alter table Artist_Certificate
add constraint fk_Artist_Certificate_Artist
foreign key (Artist_email) 
references Artist (email)