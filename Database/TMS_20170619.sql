USE [master]
GO
/****** Object:  Database [TMS]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[CATEGORY]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[COURSE]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[LOG]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[PERMISSION]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[PROFILE]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[PROFILE_USER]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[ROLE]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[ROLE_PERMISSTION]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[TOPIC]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[TRAINEE_COURSE]    Script Date: 6/19/2017 12:55:48 AM ******/
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
/****** Object:  Table [dbo].[USERS]    Script Date: 6/19/2017 12:55:48 AM ******/
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
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'4f0300c1-82e5-4e31-8213-13ce17777bf6', N'AngularJS adsdas', N'This tutorial is specially designed to help you learn AngularJS as quickly and efficiently as possible.
First, you will learn the basics of AngularJS: directives, expressions, filters, modules, and controllers.', 66)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'28671452-23f5-41ee-9629-157db9853f04', N'dsad', N'dsa', 162)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'6a46a8cf-a62c-4514-a63b-644027c16f53', N'4444', N'44', 150)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'f13cb391-a2bc-4d07-a85a-74c16ffe9233', N'22', N'22', 148)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'41e9c6ff-62eb-48bd-ac3e-82a49626953a', N'ABC', N'abcccccccccccccccccc', 71)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'd50ef71d-031b-4e19-9944-e9be5c73195c', N'Android Delopment', N'Android provides a rich application framework that allows you to build innovative apps and games for mobile devices in a Java language environment.', 64)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'6f1c48f7-e281-41dd-9087-f9ee59b9169a', N'33', N'3344', 149)
INSERT [dbo].[CATEGORY] ([CategoryID], [Name], [Description], [LogID]) VALUES (N'7ac8b46a-99e0-442d-89a3-fe057ecb619d', N'3', N'3', 146)
INSERT [dbo].[COURSE] ([CourseID], [Name], [StartDate], [EndDate], [Description], [CategoryID], [LogID]) VALUES (N'e2573d2a-e740-4e81-ab05-287cee344142', N'Nguyen Nhut Truong', CAST(N'2017-06-20' AS Date), CAST(N'2017-06-22' AS Date), N'dsa', N'4f0300c1-82e5-4e31-8213-13ce17777bf6', 166)
SET IDENTITY_INSERT [dbo].[LOG] ON 

INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (1, 1, CAST(N'2017-06-10' AS Date), 1, CAST(N'2017-06-10' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (64, 1, CAST(N'2017-06-11' AS Date), 1, CAST(N'2017-06-13' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (66, 1, CAST(N'2017-06-12' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (67, 1, CAST(N'2017-06-13' AS Date), 1, CAST(N'2017-06-13' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (69, 1, CAST(N'2017-06-13' AS Date), 1, CAST(N'2017-06-13' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (70, 1, CAST(N'2017-06-13' AS Date), 1, CAST(N'2017-06-13' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (71, 1, CAST(N'2017-06-14' AS Date), 1, CAST(N'2017-06-14' AS Date), 1)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (74, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (76, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (77, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (78, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (79, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (80, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (81, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (83, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (84, 1, CAST(N'2017-06-15' AS Date), 1, CAST(N'2017-06-15' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (85, 1, CAST(N'2017-06-16' AS Date), 1, CAST(N'2017-06-16' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (98, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (99, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (100, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (104, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (105, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (107, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (108, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (110, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (112, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (113, 1, CAST(N'2017-06-17' AS Date), 1, CAST(N'2017-06-17' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (114, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (116, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (117, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (119, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (120, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (121, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (122, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (123, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (124, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (125, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (126, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (127, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (128, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (129, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (130, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (131, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (132, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (133, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (135, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (139, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (146, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 1)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (148, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 1)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (149, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 1)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (150, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (154, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (155, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (161, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (162, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (163, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (166, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
INSERT [dbo].[LOG] ([LogID], [CreatedBy], [CreatedDate], [LastModifiedBY], [LastModifiedDate], [FlagDelete]) VALUES (174, 1, CAST(N'2017-06-18' AS Date), 1, CAST(N'2017-06-18' AS Date), 0)
SET IDENTITY_INSERT [dbo].[LOG] OFF
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_AC', N'db_accessadmin', N'')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_BK', N'db_backupoperator', N'')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_DDA', N'db_ddladmin', NULL)
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_DDR', N'db_denydatareader', NULL)
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_DDW', N'db_denydatawriter', NULL)
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_DR', N'db_datareader', N'')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_DW', N'db_datawriter', N'')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_OW', N'db_owner', N'')
INSERT [dbo].[PERMISSION] ([id], [Name], [Description]) VALUES (N'DB_SA', N'db_securityadmin', NULL)
SET IDENTITY_INSERT [dbo].[PROFILE] ON 

INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (3, N'FirstName', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (4, N'LastName', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (5, N'Email', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (6, N'Birthday', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (7, N'Phone', NULL)
INSERT [dbo].[PROFILE] ([id], [Name], [Description]) VALUES (8, N'Education', NULL)
SET IDENTITY_INSERT [dbo].[PROFILE] OFF
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (3, 4, N'Truong')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (4, 4, N'Nguyen Nhut')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (5, 4, N'TruongNN5@fosft.com.vn')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (6, 4, N'2011-11-1995')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (7, 4, N'0977372584')
INSERT [dbo].[PROFILE_USER] ([ProfileId], [UserID], [Value]) VALUES (8, 4, N'Post and Post and Telecommunication Institute of Technology')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'AD', N'ADMIN', N'Admin Role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'ON', N'OWNER', N'Owner role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'TRAINEE', N'TRAINEE', N'TRAINEE Role')
INSERT [dbo].[ROLE] ([RoleID], [RoleName], [Decription]) VALUES (N'USER', N'USER', N'USER Role')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'DB_OW')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'AD', N'DB_SA')
INSERT [dbo].[ROLE_PERMISSTION] ([RoleID], [PermissionID]) VALUES (N'USER', N'DB_OW')
INSERT [dbo].[TOPIC] ([TopicID], [Name], [Description], [CourseID], [Time], [LogID], [TrainerID]) VALUES (N'18a8422a-3e6a-4e8e-ad94-c30d0acf63c2', N'new topic 2', N'new topic 2', N'e2573d2a-e740-4e81-ab05-287cee344142', CAST(N'2017-06-21' AS Date), 174, NULL)
INSERT [dbo].[TRAINEE_COURSE] ([Trainee], [CourseID]) VALUES (4, N'e2573d2a-e740-4e81-ab05-287cee344142')
SET IDENTITY_INSERT [dbo].[USERS] ON 

INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (1, N'Admin', N'$2a$10$8J3tqnITTpSpL0ARMtpxsuj1/wLWj62zGTZc.YfkpifYnf0FaNOmy', N'AD', NULL)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (3, N'TruongNN', N'$2a$10$4T.v5BfJ/ytsl48faE3tuOwEetoxTB0SkX81fBNU8eksiix83/XV2', N'USER', 1)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (4, N'Trainee', N'123', N'TRAINEE', 113)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (5, N'Trainee1', N'123', N'TRAINEE', 112)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (6, N'Trainee2', N'123', N'TRAINEE', 110)
INSERT [dbo].[USERS] ([id], [Username], [Password], [Role], [LogID]) VALUES (7, N'Trainee3', N'123', N'TRAINEE', 108)
SET IDENTITY_INSERT [dbo].[USERS] OFF
/****** Object:  Index [U_Log]    Script Date: 6/19/2017 12:55:48 AM ******/
ALTER TABLE [dbo].[CATEGORY] ADD  CONSTRAINT [U_Log] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [U_COURSE]    Script Date: 6/19/2017 12:55:48 AM ******/
ALTER TABLE [dbo].[COURSE] ADD  CONSTRAINT [U_COURSE] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [U_TOPIC]    Script Date: 6/19/2017 12:55:48 AM ******/
ALTER TABLE [dbo].[TOPIC] ADD  CONSTRAINT [U_TOPIC] UNIQUE NONCLUSTERED 
(
	[LogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [U_USERS]    Script Date: 6/19/2017 12:55:48 AM ******/
ALTER TABLE [dbo].[USERS] ADD  CONSTRAINT [U_USERS] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UL_USERS]    Script Date: 6/19/2017 12:55:48 AM ******/
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
