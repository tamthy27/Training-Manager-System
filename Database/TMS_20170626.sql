USE [master]
GO
/****** Object:  Database [TMS]    Script Date: 6/26/2017 1:25:48 AM ******/
CREATE DATABASE [TMS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TMS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SKYPLUS\MSSQL\DATA\TMS.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TMS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SKYPLUS\MSSQL\DATA\TMS_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TMS] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TMS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TMS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TMS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TMS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TMS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TMS] SET ARITHABORT OFF 
GO
ALTER DATABASE [TMS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TMS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TMS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TMS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TMS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TMS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TMS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TMS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TMS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TMS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TMS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TMS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TMS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TMS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TMS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TMS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TMS] SET RECOVERY FULL 
GO
ALTER DATABASE [TMS] SET  MULTI_USER 
GO
ALTER DATABASE [TMS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TMS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TMS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TMS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [TMS] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'TMS', N'ON'
GO
USE [TMS]
GO
/****** Object:  Table [dbo].[CATEGORY]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CATEGORY](
	[CategoryID] [uniqueidentifier] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Description] [ntext] NOT NULL,
	[LogID] [int] NULL,
 CONSTRAINT [PK_CATEGORY] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[COURSE]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COURSE](
	[CourseID] [uniqueidentifier] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[StartDate] [date] NOT NULL,
	[EndDate] [date] NOT NULL,
	[Description] [ntext] NOT NULL,
	[CategoryID] [uniqueidentifier] NOT NULL,
	[LogID] [int] NULL,
 CONSTRAINT [PK_COURSE_1] PRIMARY KEY CLUSTERED 
(
	[CourseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LOG]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOG](
	[LogID] [int] IDENTITY(1,1) NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[CreatedDate] [date] NOT NULL,
	[LastModifiedBY] [int] NOT NULL,
	[LastModifiedDate] [date] NOT NULL,
	[FlagDelete] [bit] NOT NULL,
 CONSTRAINT [PK_LOG] PRIMARY KEY CLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERMISSION]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERMISSION](
	[id] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](1000) NULL,
 CONSTRAINT [PK_PERMISSION_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROFILE]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROFILE](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](500) NULL,
 CONSTRAINT [PK_PROFILE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROFILE_USER]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROFILE_USER](
	[ProfileId] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[Value] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_PROFILE_USER] PRIMARY KEY CLUSTERED 
(
	[ProfileId] ASC,
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ROLE]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROLE](
	[RoleID] [nvarchar](10) NOT NULL,
	[RoleName] [nvarchar](100) NOT NULL,
	[Decription] [nvarchar](1000) NULL,
 CONSTRAINT [PK_PERMISSION] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ROLE_PERMISSTION]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROLE_PERMISSTION](
	[RoleID] [nvarchar](10) NOT NULL,
	[PermissionID] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_ROLE_PERMISSTION_1] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC,
	[PermissionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TOPIC]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TOPIC](
	[TopicID] [uniqueidentifier] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Description] [ntext] NOT NULL,
	[CourseID] [uniqueidentifier] NOT NULL,
	[Time] [date] NOT NULL,
	[LogID] [int] NULL,
	[TrainerID] [int] NULL,
 CONSTRAINT [PK_TOPIC] PRIMARY KEY CLUSTERED 
(
	[TopicID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TRAINEE_COURSE]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TRAINEE_COURSE](
	[Trainee] [int] NOT NULL,
	[CourseID] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK_LEARN] PRIMARY KEY CLUSTERED 
(
	[Trainee] ASC,
	[CourseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USERS]    Script Date: 6/26/2017 1:25:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](200) NOT NULL,
	[Role] [nvarchar](10) NOT NULL,
	[LogID] [int] NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'5f5752fb-61cd-4569-a2b8-05baf279e19b', N'Internet of Things (IoT)', N'The Internet of Things may be a hot topic in the industry but it’s not a new concept. In the early 2000’s,
Kevin Ashton was laying the groundwork for what would become the Internet of Things (IoT) at MIT’s
AutoID lab. Ashton was one of the pioneers who conceived this notion as he searched for ways that
Proctor & Gamble could improve its business by linking RFID information to the Internet. ', 6)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'f3dde887-36dc-46d7-941e-31ad5eada9c1', N'Angular 2', N'Learn one way to build applications with Angular and reuse your code and abilities to build apps for any deployment target. For web, mobile web, native mobile and native desktop.', 3)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'693fb07c-f6f5-4f97-91fb-368632034dc1', N'Developing iOS', N'Start Developing iOS Apps (Swift) is the perfect starting point for learning to create apps that run on iPhone and iPad. View this set of incremental lessons as a guided introduction to building your first app—including the tools, major concepts, and best practices that will ease your path', 71)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'2c412d8c-d073-4ce6-9f33-51640df65e51', N'Web Programing', N'Web programming, also known as web development, is the creation of dynamic web applications. Examples of web applications are social networking sites like Facebook or e-commerce sites like Amazon.', 2)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'f3c8ade6-1676-4d91-b525-8997c95c1a95', N'Predix Developer Network', N'The Predix System™ provides the software architecture and services required to make any machine an intelligent asset - bringing actionable insights to every part of industrial infrastructure and operations.', 5)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'd5c4a520-b1f4-40ed-beed-bb7f1fe2fbe2', N'Android Delopment', N'Android provides a rich application framework that allows you to build innovative apps and games for mobile devices in a Java language environment. The documents listed in the left navigation provide details about how to build apps using Android''s various APIs.', 4)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'b397bf93-4fe8-49f6-8a0e-0a2b2dd2280a', N'2', CAST(N'2017-06-26' AS Date), CAST(N'2017-06-28' AS Date), N'2', N'2c412d8c-d073-4ce6-9f33-51640df65e51', 15)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'154d72ca-7bba-4bd6-b608-bb784475e204', N'3', CAST(N'2017-06-20' AS Date), CAST(N'2017-06-20' AS Date), N'3', N'f3dde887-36dc-46d7-941e-31ad5eada9c1', 35)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'605dc074-6d80-45af-95d9-c6d717ef88e2', N'New Course', CAST(N'2017-06-27' AS Date), CAST(N'2017-07-28' AS Date), N'Internet of Things represents a general concept for the ability of network devices to sense and collect data from the world around us, internet of Things represents a general concept for the ability of network devices to sense and collect data from the world around us', N'5f5752fb-61cd-4569-a2b8-05baf279e19b', 70)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'fe57ba82-38cb-4024-961a-ca128a6cd11e', N'Internet of Things', CAST(N'2017-06-25' AS Date), CAST(N'2017-06-26' AS Date), N'Internet of Things represents a general concept for the ability of network devices to sense and collect data from the world around us, internet of Things represents a general concept for the ability of network devices to sense and collect data from the world around us.', N'5f5752fb-61cd-4569-a2b8-05baf279e19b', 69)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', N'Web Programing T3H', CAST(N'2017-06-25' AS Date), CAST(N'2017-06-28' AS Date), N'w', N'f3dde887-36dc-46d7-941e-31ad5eada9c1', 20)
SET IDENTITY_INSERT [dbo].[LOG] ON 

INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (1, 1, CAST(N'2017-06-10' AS Date), 1, CAST(N'2017-06-10' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (2, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (3, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (4, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (5, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (6, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (15, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (20, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (22, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (23, 1, CAST(N'2017-06-24' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (24, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (25, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (26, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (27, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (28, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (29, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (30, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (31, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (32, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (33, 1, CAST(N'2017-06-24' AS Date), 1, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (34, 3, CAST(N'2017-06-24' AS Date), 3, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (35, 3, CAST(N'2017-06-24' AS Date), 3, CAST(N'2017-06-24' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (36, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (37, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (38, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (39, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (40, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (41, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (42, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (43, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (44, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (45, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (46, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (47, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (48, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (49, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (50, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (51, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (52, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (54, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (55, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (60, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (61, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (64, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (65, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (66, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (67, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (68, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (69, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (70, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (71, 3, CAST(N'2017-06-25' AS Date), 3, CAST(N'2017-06-25' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (72, 1, CAST(N'2017-06-26' AS Date), 1, CAST(N'2017-06-26' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (73, 1, CAST(N'2017-06-26' AS Date), 1, CAST(N'2017-06-26' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (74, 3, CAST(N'2017-06-26' AS Date), 3, CAST(N'2017-06-26' AS Date), 0)
SET IDENTITY_INSERT [dbo].[LOG] OFF
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'A_Staff', N'M_A_Staff', N'Manage Account Staff')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'A_Trainer', N'M_A_Trainer', N'Manage Account Trainer')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'AS_Trainee', N'AS_Trainee', N'Assign Trainee To Course')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'AS_Trainer', N'AS_Trainer', N'Assign Trainer To Topic')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'M_Category', N'M_Category', N'Staff Manage Category')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'M_Course', N'M_Course', N'Staff Manage Course')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'M_Topic', N'M_Topic', N'Staff Manage Topic')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'P_Staff', N'M_P_Staff', N'Manage Profile Staff')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'P_Trainee', N'M_P_Trainee', N'Manage Profile Trainee')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'P_Trainer', N'M_P_Trainer', N'Manage  Profile Trainer')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'S_Login', N'S_Login', N'Login To System')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'T_V_Topic', N'Trainer_V_Topic', N'Trainer View Topics Are Assigned')
SET IDENTITY_INSERT [dbo].[PROFILE] ON 

INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (1, N'ProgrammingLanguage', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (2, N'TOIEC', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (3, N'FirstName', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (4, N'LastName', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (5, N'Email', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (6, N'Birthday', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (7, N'Phone', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (8, N'Education', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (9, N'Type', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (11, N'WorkingPlace', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (12, N'Address', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (14, N'Experience', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (15, N'Department', NULL)
SET IDENTITY_INSERT [dbo].[PROFILE] OFF
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 4, N'Truong')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 6, N'Huy')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 7, N'Khoa')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 8, N'Khôi')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 9, N'Liên')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 10, N'Ngân')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 11, N'Ngọc')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 12, N'Nhàn')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 13, N'Như')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 14, N'Như')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 15, N'Quý')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 16, N'Quý')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 17, N'Tâm')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 18, N'Uyên')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 19, N'Vy')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 20, N'Nguyen')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 21, N'Nguyen Van')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 4, N'Nguyen Nhut')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 6, N'Trịnh Quốc')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 7, N'Võ Nguyễn Đăng')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 8, N'Nguyễn Minh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 9, N'Lê Thị Thái')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 10, N'Ngô Thị Kim')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 11, N'Nguyễn Thị Bảo')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 12, N'Sơn Mỹ')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 13, N'Nguyễn Quỳnh Ánh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 14, N'Nguyễn Khâu Quỳnh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 15, N'Nguyễn Thanh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 16, N'Trần Văn')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 17, N'Nguyễn Hoàng Hoài')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 18, N'Dương Quỳnh Thảo')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 19, N'Đỗ Trần Thuý')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 20, N'Tinh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 21, N'Tinh')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (5, 4, N'kyoyuki05@gmail.com')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (5, 20, N'nguyentinh0410@gmail.com')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (5, 21, N'nguyentinh0410@gmail.com')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 4, N'20/11/1995')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 6, N'25/09/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 7, N'15/05/1998')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 8, N'14/10/1999')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 9, N'27/06/1999')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 10, N'27/06/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 11, N'21/09/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 12, N'20/07/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 14, N'18/11/2001')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 15, N'15/10/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 16, N'28/03/1997')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 17, N'20/09/1998')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 18, N'14/02/2000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 19, N'15/10/1999')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 20, N'11/11/1111')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 21, N'15/02/1995')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 4, N'0977372584')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 6, N'01653578431')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 7, N'0937251000')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 8, N'0906671542')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 9, N'01267080910')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 10, N'0903196219')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 11, N'0909128021')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 12, N'0909968116')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 13, N'01276649651')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 14, N'0967992098')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 15, N'01685322324')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 16, N'01224933558')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 17, N'01203311932')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 18, N'01216211477')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 19, N'0901319867')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 20, N'01654116641')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 21, N'06541166411')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (8, 4, N'Post and Telecommunication Institute of Technology')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (8, 20, N'PTIT')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (8, 21, N'')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (9, 4, N'External')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (11, 4, N'97 Man Thien, Hiep Phu Ward, District 9, HCM City')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (11, 20, N' ')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (11, 21, N' ')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 6, N'243/26A Tôn Thất Thuyết P3 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 7, N'F17 CXVH Bến Vân Đồn P5 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 8, N'129F/138/92 Bến Vân Đồn P6 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 9, N'86/30 Vĩnh Khánh P10 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 10, N'188/22/1 Tôn Thất Thuyết P4 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 11, N'202A C/c Vĩnh Hội Nguyễn Hữu Hào P6 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 12, N'189I/20 Tôn Thất Thuyết P3 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 13, N'231/4 Tôn Thất Thuyết P3 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 14, N'224/21 Bến Vân Đồn P5 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 15, N'122/27/30/2/12A Tôn Đản P10 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 16, N'50 Trần Đình Xu PCầu Kho Q1')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 17, N'407A Lô M2 CCư Tôn Thất Thuyết P1 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 18, N'K 48 CXVH Bến Vân Đồn P6 Q4')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (12, 19, N'47/60C Đường số 10 PTân Quy Q7')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'AD', N'ADMIN', N'Admin Role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'STAFF', N'STAFF', N'USER Role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'TRAINEE', N'TRAINEE', N'TRAINEE Role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'TRAINER', N'TRAINER', N'TRAINER Role')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'A_Staff')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'A_Trainer')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'P_Staff')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'P_Trainer')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'S_Login')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'AS_Trainee')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'AS_Trainer')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'M_Category')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'M_Course')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'M_Topic')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'P_Staff')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'P_Trainee')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'P_Trainer')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'STAFF', N'S_Login')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'TRAINER', N'P_Trainer')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'TRAINER', N'S_Login')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'TRAINER', N'T_V_Topic')
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'3afcf16e-a806-4f8c-a0ce-0f8c3648262c', N'1', N'1', N'b397bf93-4fe8-49f6-8a0e-0a2b2dd2280a', CAST(N'2017-07-08' AS Date), 23, 4)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'896d0241-c23e-4343-9bcc-1379aa6657e1', N'Topic 3', N'Topic 3', N'fe57ba82-38cb-4024-961a-ca128a6cd11e', CAST(N'2017-05-27' AS Date), 50, 4)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'73901bd8-d96b-445d-bd7f-244f3f2b1103', N'Topic 2', N'lsat', N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', CAST(N'2017-06-29' AS Date), 60, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'e7c7814d-f43e-42a1-88f2-3151d942721a', N'1', N'1', N'b397bf93-4fe8-49f6-8a0e-0a2b2dd2280a', CAST(N'2017-06-07' AS Date), 22, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'beb4bbc9-a84b-4286-9f82-819c8a077567', N'Topic 4', N'Topic 4', N'fe57ba82-38cb-4024-961a-ca128a6cd11e', CAST(N'2017-05-29' AS Date), 51, 4)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'025fb44d-f5cd-45da-a353-85a23cb5942d', N'Topic 3', N'Topic 3', N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', CAST(N'2017-06-27' AS Date), 54, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'e36e3955-a2e5-4942-9c4a-8cdf3e75f763', N'Topic 2', N'Topic 2', N'fe57ba82-38cb-4024-961a-ca128a6cd11e', CAST(N'2017-06-26' AS Date), 26, 4)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'21b9449b-34cc-4f3b-a908-ae43eba1d48c', N'Topic 1', N'Topic 1', N'154d72ca-7bba-4bd6-b608-bb784475e204', CAST(N'2017-06-26' AS Date), 64, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'8ebc5981-67c5-4429-a178-bf2e016ddeed', N'Topic 2', N'Topic 2', N'154d72ca-7bba-4bd6-b608-bb784475e204', CAST(N'2017-06-27' AS Date), 65, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'b5de02dd-299d-42e8-83d9-c689c16ac78a', N'Topic 4', N'Topic 4', N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', CAST(N'2017-06-30' AS Date), 55, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'59cac55b-0929-44c3-8331-d2d5a75c82c8', N'Topic 4', N'Topic 44', N'154d72ca-7bba-4bd6-b608-bb784475e204', CAST(N'2017-06-30' AS Date), 67, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'6f2d4a27-0791-453e-a3fc-d334de090d76', N'Topic 10', N'lsat', N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', CAST(N'2017-06-29' AS Date), 61, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'bed5999e-c3e1-47cd-93af-e248a2697518', N'Topic 1', N'Topic 1', N'fe57ba82-38cb-4024-961a-ca128a6cd11e', CAST(N'2017-06-25' AS Date), 25, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'5e99bfa4-cbd0-4d7e-9227-e77e1fe381a3', N'Topic 1', N'Topic 1', N'605dc074-6d80-45af-95d9-c6d717ef88e2', CAST(N'2017-06-28' AS Date), 74, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'358648b4-d2c5-47a7-8ab2-fa47a08cea93', N'Topic 3', N'Topic 3', N'154d72ca-7bba-4bd6-b608-bb784475e204', CAST(N'2017-06-28' AS Date), 66, NULL)
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'bc094f52-fa9c-4f1c-81ea-fcfe53dcb1ec', N'Topic 1', N'123', N'd1b22b9c-e584-48d4-b52c-f3bb7580d7c2', CAST(N'2017-06-26' AS Date), 52, NULL)
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (6, N'605dc074-6d80-45af-95d9-c6d717ef88e2')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (6, N'fe57ba82-38cb-4024-961a-ca128a6cd11e')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (7, N'605dc074-6d80-45af-95d9-c6d717ef88e2')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (7, N'fe57ba82-38cb-4024-961a-ca128a6cd11e')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (8, N'605dc074-6d80-45af-95d9-c6d717ef88e2')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (8, N'fe57ba82-38cb-4024-961a-ca128a6cd11e')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (9, N'605dc074-6d80-45af-95d9-c6d717ef88e2')
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (9, N'fe57ba82-38cb-4024-961a-ca128a6cd11e')
SET IDENTITY_INSERT [dbo].[USERS] ON 

INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (1, N'Admin', N'$2a$10$8J3tqnITTpSpL0ARMtpxsuj1/wLWj62zGTZc.YfkpifYnf0FaNOmy', N'AD', NULL)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (3, N'TruongNN', N'$2a$10$4T.v5BfJ/ytsl48faE3tuOwEetoxTB0SkX81fBNU8eksiix83/XV2', N'STAFF', 1)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (4, N'TrangNV', N'$2a$10$4T.v5BfJ/ytsl48faE3tuOwEetoxTB0SkX81fBNU8eksiix83/XV2', N'TRAINER', 33)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (6, N'1.0', N'$2a$10$toSAeZA8sykJdoyKULzGXuwi1zgyLMYC2kcL4jcbey.ViRXmjrBxu', N'TRAINEE', 36)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (7, N'2.0', N'$2a$10$8YC0J5ZXIDzwdCH41dwa/Ou1VHXe5giyPb1XlLjU6WJQ4heAgWXJu', N'TRAINEE', 37)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (8, N'3.0', N'$2a$10$uLaQAqIZT/zN89Hblzm1CuWIPFY2qmtHbQQ/wtKs.8xcK5txX7eg6', N'TRAINEE', 38)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (9, N'4.0', N'$2a$10$cZ5GptEP6UAm.zqU/9DwEOFi4AiQLmKNrhSLo8lDKRT9XIKLuE3cC', N'TRAINEE', 39)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (10, N'5.0', N'$2a$10$h9IYLW0Goy.M1KFa78141Osfdy/cQUi2grD/RkNSYOmHLm8hqS48G', N'TRAINEE', 40)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (11, N'6.0', N'$2a$10$k3qwjYOw2ZrB4V7j6h1dge1arvfu3OHhLEIE.G6Imk3iGsDQkIljS', N'TRAINEE', 41)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (12, N'7.0', N'$2a$10$h3I3RXWw.koCs6cU.cz73.IA26azXh9eVAdhQIn1UXCHpXNBy/ig6', N'TRAINEE', 42)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (13, N'8.0', N'$2a$10$Eyc8PVRr0ItEoPKHiTbrFeXsSXGzEAamZvdD205I.XlV5kCxDiqum', N'TRAINEE', 43)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (14, N'9.0', N'$2a$10$e9akOotjdzbvUdr8qfTASeeeFqLEhR32SfLrFWIUvOhQigqewI37C', N'TRAINEE', 44)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (15, N'10.0', N'$2a$10$yQ1yKBmyMhygnU3Ss2/w8eIOz2pXuwdL3SMERr2LJeYqWhfYWfuIa', N'TRAINEE', 45)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (16, N'11.0', N'$2a$10$.FiyTTT0n6cZAErnrzyTueiciKVhwZgTdZ3ful0dytRLuk1EIHVpm', N'TRAINEE', 46)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (17, N'12.0', N'$2a$10$dhumIFLEbO3KqyAmZ0GoPOo7X/7AkxMojeTOJc3l/65PKnVULXc/6', N'TRAINEE', 47)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (18, N'13.0', N'$2a$10$NBaomGlCoKU.vGyWGuuuCuwUoWsvWjy7wwsm6DzhyCfH5ZUVWmDDy', N'TRAINEE', 48)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (19, N'14.0', N'$2a$10$ePGT4tKoy/9LO18BpwHbkOiSd6/f7ROuY/EGRLdRqKQ4w66Thw1ny', N'TRAINEE', 49)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (20, N'NguyenTinh ', N'$2a$10$eiaiC3flWJ3wAj4tQvLIrexuDzEuaHc1ouJ2u10arIacJnMwURLJS', N'TRAINER', 72)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (21, N'tinhNV', N'$2a$10$jGBKmsxfJBwiXWhx0a.cLOK1yZ2YSClONRa8qNFzEiU66pvmj3/sS', N'STAFF', 73)
SET IDENTITY_INSERT [dbo].[USERS] OFF
/****** Object:  Index [U_Log]    Script Date: 6/26/2017 1:25:48 AM ******/
ALTER TABLE [dbo].[CATEGORY] ADD  CONSTRAINT [U_Log] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [U_COURSE]    Script Date: 6/26/2017 1:25:48 AM ******/
ALTER TABLE [dbo].[COURSE] ADD  CONSTRAINT [U_COURSE] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [U_TOPIC]    Script Date: 6/26/2017 1:25:48 AM ******/
ALTER TABLE [dbo].[TOPIC] ADD  CONSTRAINT [U_TOPIC] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [U_USERS]    Script Date: 6/26/2017 1:25:48 AM ******/
ALTER TABLE [dbo].[USERS] ADD  CONSTRAINT [U_USERS] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UL_USERS]    Script Date: 6/26/2017 1:25:48 AM ******/
ALTER TABLE [dbo].[USERS] ADD  CONSTRAINT [UL_USERS] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CATEGORY]  WITH CHECK ADD  CONSTRAINT [FK_CATEGORY_LOG] FOREIGN KEY([LogID])
REFERENCES [dbo].[LOG] ([LogID])
GO
ALTER TABLE [dbo].[CATEGORY] CHECK CONSTRAINT [FK_CATEGORY_LOG]
GO
ALTER TABLE [dbo].[COURSE]  WITH CHECK ADD  CONSTRAINT [FK_COURSE_CATEGORY] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[CATEGORY] ([CategoryID])
GO
ALTER TABLE [dbo].[COURSE] CHECK CONSTRAINT [FK_COURSE_CATEGORY]
GO
ALTER TABLE [dbo].[COURSE]  WITH CHECK ADD  CONSTRAINT [FK_COURSE_LOG] FOREIGN KEY([LogID])
REFERENCES [dbo].[LOG] ([LogID])
GO
ALTER TABLE [dbo].[COURSE] CHECK CONSTRAINT [FK_COURSE_LOG]
GO
ALTER TABLE [dbo].[LOG]  WITH CHECK ADD  CONSTRAINT [FK_LOG_USERS] FOREIGN KEY([CreatedBy])
REFERENCES [dbo].[USERS] ([id])
GO
ALTER TABLE [dbo].[LOG] CHECK CONSTRAINT [FK_LOG_USERS]
GO
ALTER TABLE [dbo].[LOG]  WITH CHECK ADD  CONSTRAINT [FK_LOG_USERS1] FOREIGN KEY([LastModifiedBY])
REFERENCES [dbo].[USERS] ([id])
GO
ALTER TABLE [dbo].[LOG] CHECK CONSTRAINT [FK_LOG_USERS1]
GO
ALTER TABLE [dbo].[PROFILE_USER]  WITH CHECK ADD  CONSTRAINT [FK_PROFILE_USER_PROFILE] FOREIGN KEY([ProfileId])
REFERENCES [dbo].[PROFILE] ([id])
GO
ALTER TABLE [dbo].[PROFILE_USER] CHECK CONSTRAINT [FK_PROFILE_USER_PROFILE]
GO
ALTER TABLE [dbo].[PROFILE_USER]  WITH CHECK ADD  CONSTRAINT [FK_PROFILE_USER_USERS] FOREIGN KEY([UserID])
REFERENCES [dbo].[USERS] ([id])
GO
ALTER TABLE [dbo].[PROFILE_USER] CHECK CONSTRAINT [FK_PROFILE_USER_USERS]
GO
ALTER TABLE [dbo].[ROLE_PERMISSTION]  WITH CHECK ADD  CONSTRAINT [FK_ROLE_PERMISSTION_PERMISSION] FOREIGN KEY([PermissionID])
REFERENCES [dbo].[PERMISSION] ([id])
GO
ALTER TABLE [dbo].[ROLE_PERMISSTION] CHECK CONSTRAINT [FK_ROLE_PERMISSTION_PERMISSION]
GO
ALTER TABLE [dbo].[ROLE_PERMISSTION]  WITH CHECK ADD  CONSTRAINT [FK_ROLE_PERMISSTION_ROLE] FOREIGN KEY([RoleID])
REFERENCES [dbo].[ROLE] ([RoleID])
GO
ALTER TABLE [dbo].[ROLE_PERMISSTION] CHECK CONSTRAINT [FK_ROLE_PERMISSTION_ROLE]
GO
ALTER TABLE [dbo].[TOPIC]  WITH CHECK ADD  CONSTRAINT [FK_TOPIC_COURSE] FOREIGN KEY([CourseID])
REFERENCES [dbo].[COURSE] ([CourseID])
GO
ALTER TABLE [dbo].[TOPIC] CHECK CONSTRAINT [FK_TOPIC_COURSE]
GO
ALTER TABLE [dbo].[TOPIC]  WITH CHECK ADD  CONSTRAINT [FK_TOPIC_LOG] FOREIGN KEY([LogID])
REFERENCES [dbo].[LOG] ([LogID])
GO
ALTER TABLE [dbo].[TOPIC] CHECK CONSTRAINT [FK_TOPIC_LOG]
GO
ALTER TABLE [dbo].[TOPIC]  WITH CHECK ADD  CONSTRAINT [FK_TOPIC_USERS] FOREIGN KEY([TrainerID])
REFERENCES [dbo].[USERS] ([id])
GO
ALTER TABLE [dbo].[TOPIC] CHECK CONSTRAINT [FK_TOPIC_USERS]
GO
ALTER TABLE [dbo].[TRAINEE_COURSE]  WITH CHECK ADD  CONSTRAINT [FK_TRAINEE_COURSE_COURSE] FOREIGN KEY([CourseID])
REFERENCES [dbo].[COURSE] ([CourseID])
GO
ALTER TABLE [dbo].[TRAINEE_COURSE] CHECK CONSTRAINT [FK_TRAINEE_COURSE_COURSE]
GO
ALTER TABLE [dbo].[TRAINEE_COURSE]  WITH CHECK ADD  CONSTRAINT [FK_TRAINEE_COURSE_USERS] FOREIGN KEY([Trainee])
REFERENCES [dbo].[USERS] ([id])
GO
ALTER TABLE [dbo].[TRAINEE_COURSE] CHECK CONSTRAINT [FK_TRAINEE_COURSE_USERS]
GO
ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [FK_USERS_LOG] FOREIGN KEY([LogID])
REFERENCES [dbo].[LOG] ([LogID])
GO
ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [FK_USERS_LOG]
GO
ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [FK_USERS_ROLE] FOREIGN KEY([Role])
REFERENCES [dbo].[ROLE] ([RoleID])
GO
ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [FK_USERS_ROLE]
GO
USE [master]
GO
ALTER DATABASE [TMS] SET  READ_WRITE 
GO
