﻿USE [master]
GO
/****** Object:  Database [controlContable]    Script Date: 10/04/2023 05:35:43 p. m. ******/
CREATE DATABASE [controlContable]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'controlContable', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\controlContable.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'controlContable_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\controlContable_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [controlContable] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [controlContable].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [controlContable] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [controlContable] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [controlContable] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [controlContable] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [controlContable] SET ARITHABORT OFF 
GO
ALTER DATABASE [controlContable] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [controlContable] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [controlContable] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [controlContable] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [controlContable] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [controlContable] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [controlContable] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [controlContable] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [controlContable] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [controlContable] SET  ENABLE_BROKER 
GO
ALTER DATABASE [controlContable] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [controlContable] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [controlContable] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [controlContable] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [controlContable] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [controlContable] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [controlContable] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [controlContable] SET RECOVERY FULL 
GO
ALTER DATABASE [controlContable] SET  MULTI_USER 
GO
ALTER DATABASE [controlContable] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [controlContable] SET DB_CHAINING OFF 
GO
ALTER DATABASE [controlContable] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [controlContable] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [controlContable] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [controlContable] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'controlContable', N'ON'
GO
ALTER DATABASE [controlContable] SET QUERY_STORE = OFF
GO
USE [controlContable]
GO
/****** Object:  Table [dbo].[apoderado]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[apoderado](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellidoUno] [varchar](45) NULL,
	[apellidoDos] [varchar](45) NULL,
	[telefono] [int] NULL,
	[correo] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[clave] [char](10) NOT NULL,
	[valor] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[contrasena]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[contrasena](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[contrasena] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[departamento]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[departamento](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[entidadFederativa]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[entidadFederativa](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[clave] [varchar](10) NOT NULL,
	[valor] [varchar](140) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[factura]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[factura](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[numeroFactura] [varchar](50) NOT NULL,
	[proveedor] [int] NOT NULL,
	[folioFiscal] [varchar](100) NOT NULL,
	[fechaCertificacion] [date] NOT NULL,
	[fechaComprobante] [date] NOT NULL,
	[certificadoSat] [varchar](50) NOT NULL,
	[noCertificado] [varchar](50) NOT NULL,
	[tipoComprobante] [varchar](50) NOT NULL,
	[metodoPago] [varchar](100) NOT NULL,
	[formaPago] [varchar](100) NOT NULL,
	[moneda] [varchar](50) NOT NULL,
	[total] [decimal](13, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[kardexMovimientos]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[kardexMovimientos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[productos] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[entradaRecibe] [varchar](50) NULL,
	[entradaEntrega] [varchar](50) NULL,
	[salidaDepartamentoAsignado] [varchar](50) NULL,
	[cantidad] [decimal](13, 2) NULL,
	[saldo] [int] NULL,
	[factura] [int] NOT NULL,
	[salidas] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[listaProductos]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[listaProductos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[producto] [int] NOT NULL,
	[salida] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[marca]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[marca](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[categoria] [varchar](50) NOT NULL,
	[valor] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[municipio]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[municipio](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[clave] [varchar](10) NOT NULL,
	[valor] [varchar](140) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[personaFisica]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[personaFisica](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellidoUno] [varchar](50) NOT NULL,
	[apellidoDos] [varchar](50) NOT NULL,
	[numeroContacto] [int] NULL,
	[proveedor] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[personaMoral]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[personaMoral](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombreEmpresa] [varchar](100) NOT NULL,
	[apoderado] [int] NOT NULL,
	[proveedor] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[producto]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[factura] [int] NOT NULL,
	[producto] [varchar](100) NOT NULL,
	[categoria] [int] NOT NULL,
	[marca] [varchar](100) NULL,
	[cantidad] [int] NOT NULL,
	[unidadMedida] [int] NOT NULL,
	[precioUnitario] [decimal](13, 2) NOT NULL,
	[fecha] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[proveedor]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proveedor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[regimen] [varchar](50) NULL,
	[RFC] [varchar](50) NOT NULL,
	[actividadEconomica] [varchar](45) NULL,
	[direccion] [varchar](100) NULL,
	[registro] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
	[entidadFedrativa] [int] NOT NULL,
	[municipio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reporteProveedores]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reporteProveedores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[proveedor] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reportes]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reportes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
	[ruta] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[salidas]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[salidas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[producto] [varchar](100) NOT NULL,
	[departamento] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[unidadMedida]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[unidadMedida](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[clave] [char](10) NOT NULL,
	[valor] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 10/04/2023 05:35:43 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[cargo] [varchar](50) NOT NULL,
	[contrasena] [int] NOT NULL,
	[fechaAlta] [datetime] NOT NULL,
	[fechaModificacion] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[factura]  WITH CHECK ADD  CONSTRAINT [fk_proveedor] FOREIGN KEY([proveedor])
REFERENCES [dbo].[proveedor] ([id])
GO
ALTER TABLE [dbo].[factura] CHECK CONSTRAINT [fk_proveedor]
GO
ALTER TABLE [dbo].[kardexMovimientos]  WITH CHECK ADD  CONSTRAINT [fk_factura_k] FOREIGN KEY([factura])
REFERENCES [dbo].[factura] ([id])
GO
ALTER TABLE [dbo].[kardexMovimientos] CHECK CONSTRAINT [fk_factura_k]
GO
ALTER TABLE [dbo].[kardexMovimientos]  WITH CHECK ADD  CONSTRAINT [fk_producto] FOREIGN KEY([productos])
REFERENCES [dbo].[producto] ([id])
GO
ALTER TABLE [dbo].[kardexMovimientos] CHECK CONSTRAINT [fk_producto]
GO
ALTER TABLE [dbo].[kardexMovimientos]  WITH CHECK ADD  CONSTRAINT [fk_salidas] FOREIGN KEY([salidas])
REFERENCES [dbo].[salidas] ([id])
GO
ALTER TABLE [dbo].[kardexMovimientos] CHECK CONSTRAINT [fk_salidas]
GO
ALTER TABLE [dbo].[listaProductos]  WITH CHECK ADD  CONSTRAINT [fk_producto_l] FOREIGN KEY([producto])
REFERENCES [dbo].[producto] ([id])
GO
ALTER TABLE [dbo].[listaProductos] CHECK CONSTRAINT [fk_producto_l]
GO
ALTER TABLE [dbo].[listaProductos]  WITH CHECK ADD  CONSTRAINT [fk_salida] FOREIGN KEY([salida])
REFERENCES [dbo].[salidas] ([id])
GO
ALTER TABLE [dbo].[listaProductos] CHECK CONSTRAINT [fk_salida]
GO
ALTER TABLE [dbo].[personaFisica]  WITH CHECK ADD  CONSTRAINT [fk_proveedor_pf] FOREIGN KEY([proveedor])
REFERENCES [dbo].[proveedor] ([id])
GO
ALTER TABLE [dbo].[personaFisica] CHECK CONSTRAINT [fk_proveedor_pf]
GO
ALTER TABLE [dbo].[personaMoral]  WITH CHECK ADD  CONSTRAINT [fk_apoderado_pm] FOREIGN KEY([apoderado])
REFERENCES [dbo].[apoderado] ([id])
GO
ALTER TABLE [dbo].[personaMoral] CHECK CONSTRAINT [fk_apoderado_pm]
GO
ALTER TABLE [dbo].[personaMoral]  WITH CHECK ADD  CONSTRAINT [fk_proveedor_pm] FOREIGN KEY([proveedor])
REFERENCES [dbo].[proveedor] ([id])
GO
ALTER TABLE [dbo].[personaMoral] CHECK CONSTRAINT [fk_proveedor_pm]
GO
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [fk_categoria] FOREIGN KEY([categoria])
REFERENCES [dbo].[categoria] ([id])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [fk_categoria]
GO
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [fk_factura] FOREIGN KEY([factura])
REFERENCES [dbo].[factura] ([id])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [fk_factura]
GO
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [fk_unidadMedida] FOREIGN KEY([unidadMedida])
REFERENCES [dbo].[unidadMedida] ([id])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [fk_unidadMedida]
GO
ALTER TABLE [dbo].[proveedor]  WITH CHECK ADD  CONSTRAINT [fk_entidadFederativa] FOREIGN KEY([entidadFedrativa])
REFERENCES [dbo].[entidadFederativa] ([id])
GO
ALTER TABLE [dbo].[proveedor] CHECK CONSTRAINT [fk_entidadFederativa]
GO
ALTER TABLE [dbo].[proveedor]  WITH CHECK ADD  CONSTRAINT [fk_municipio] FOREIGN KEY([municipio])
REFERENCES [dbo].[municipio] ([id])
GO
ALTER TABLE [dbo].[proveedor] CHECK CONSTRAINT [fk_municipio]
GO
ALTER TABLE [dbo].[reporteProveedores]  WITH CHECK ADD  CONSTRAINT [fk_reporteProveedores] FOREIGN KEY([proveedor])
REFERENCES [dbo].[proveedor] ([id])
GO
ALTER TABLE [dbo].[reporteProveedores] CHECK CONSTRAINT [fk_reporteProveedores]
GO
ALTER TABLE [dbo].[salidas]  WITH CHECK ADD  CONSTRAINT [fk_departamento] FOREIGN KEY([departamento])
REFERENCES [dbo].[departamento] ([id])
GO
ALTER TABLE [dbo].[salidas] CHECK CONSTRAINT [fk_departamento]
GO
ALTER TABLE [dbo].[usuario]  WITH CHECK ADD  CONSTRAINT [fk_contrasena] FOREIGN KEY([contrasena])
REFERENCES [dbo].[contrasena] ([id])
GO
ALTER TABLE [dbo].[usuario] CHECK CONSTRAINT [fk_contrasena]
GO
USE [master]
GO
ALTER DATABASE [controlContable] SET  READ_WRITE 
GO
