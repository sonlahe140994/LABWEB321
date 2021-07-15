USE [OnlineQuiz]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/28/2021 11:36:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userName] [varchar](50) NULL,
	[passW] [varchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[type] [int] NULL,
	[email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TypePermission]    Script Date: 6/28/2021 11:36:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypePermission](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 
GO
INSERT [dbo].[Account] ([id], [userName], [passW], [name], [type], [email]) VALUES (1, N'sa', N'123', N'Le Anh Son', 1, N'sonlahe140994@gmail.com')
GO
INSERT [dbo].[Account] ([id], [userName], [passW], [name], [type], [email]) VALUES (2, N'sb', N'123', N'Lê Thanh Sơn', 2, N'sonlethanh10994@gmai.com')
GO
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
INSERT [dbo].[TypePermission] ([id], [name]) VALUES (1, N'Student')
GO
INSERT [dbo].[TypePermission] ([id], [name]) VALUES (2, N'Teacher')
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([type])
REFERENCES [dbo].[TypePermission] ([id])
GO
