USE [Demo1]
GO

/****** Object:  Table [dbo].[Booking_Detail]    Script Date: 9/28/2023 4:04:14 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Booking_Detail](
	[booking_Detail_ID] [varchar](20) primary key, 
	[booking_ID] [varchar](20) NOT NULL,
	[description] [varchar](20) NULL,
	[price] [float] NOT NULL,
	[bookingTattoo_Lover_semail] [varchar](50) NULL,
	[bookingService_ID] [varchar](20) NOT NULL,
	[bookingArtist_email] [varchar](20) NULL,
	[voucherID] [varchar](20) NOT NULL
) 






CREATE TABLE [dbo].[Feedback](
	[tattoo_Lovers_Email] [varchar](50)not NULL,
	[Service_ID] [varchar](20) NOT NULL,
	[artist_email] [varchar](50)not NULL,
	[description] [nvarchar](200) NULL,
	[booking_Detail_ID] [varchar](20) NOT NULL
) 


ALTER TABLE [dbo].[Feedback]
ADD CONSTRAINT PK_Feedback
PRIMARY KEY (service_ID, artist_email, tattoo_Lovers_Email)


CREATE TABLE [dbo].[Voucher](
	[voucher_ID] [varchar](20) primary key,
	[voucher_Name] [varchar](20) NOT NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[description] [nvarchar](50) NULL
) 

CREATE TABLE [dbo].[Status](
	[statusID] [varchar](20) primary key,
	[status_Name] [varchar](20) NOT NULL,
	[description] [varchar](200) NULL,
	[booking_Detail_ID] [varchar](20) NOT NULL
) 


GO


